package com.luxdrive.DriverService.Driver;

import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.Optional;

@RestController
@RequestMapping("/driver")
public class DriverController {

    @Autowired
    private DriverService driverService;

    @Autowired
    private DriverRepository driverRepository;

    private static final String UPLOAD_DIR = "uploads/drivers/";

    // ✅ Upload document or photo
    @PostMapping("/{driverId}/upload")
    public ResponseEntity<?> uploadFile(
            @PathVariable Long driverId,
            @RequestParam("file") MultipartFile file,
            @RequestParam("type") String type // e.g. photo, licenseFront
    ) throws IOException {

        Optional<Driver> optionalDriver = driverRepository.findById(driverId);
        if (optionalDriver.isEmpty()) {
            return ResponseEntity.badRequest().body("Driver not found");
        }

        // Create directory if not exists
        File directory = new File(UPLOAD_DIR);
        if (!directory.exists()) directory.mkdirs();

        // Save file to disk
        String filename = driverId + "-" + type + "-" + file.getOriginalFilename();
        Path path = Paths.get(UPLOAD_DIR + filename);
        Files.write(path, file.getBytes());

        // Update DB with filename/path
        Driver driver = optionalDriver.get();
        switch (type) {
            case "photo" -> driver.setPhoto(filename);
            case "licenseFront" -> driver.setLicenseFront(filename);
            case "licenseBack" -> driver.setLicenseBack(filename);
            case "aadharFront" -> driver.setAadharFront(filename);
            case "aadharBack" -> driver.setAadharBack(filename);
            default -> throw new IllegalArgumentException("Unknown document type");
        }

        driverRepository.save(driver);
        return ResponseEntity.ok("Uploaded " + type);
    }

    // ✅ Save driver basic information (Step 1 of form)
    @PostMapping("/save-info")
    public Driver saveDriverInfo(@RequestBody Driver driver) {
        return driverRepository.save(driver);
    }

    // ✅ (Optional) Download endpoint
    @GetMapping("/download")
    public ResponseEntity<byte[]> downloadFile(@RequestParam String filename) throws IOException {
        Path path = Paths.get(UPLOAD_DIR + filename);
        byte[] fileBytes = Files.readAllBytes(path);

        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .header("Content-Disposition", "attachment; filename=\"" + filename + "\"")
                .body(fileBytes);
    }
}
