package com.luxdrive.DriverService.Driver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class DriverService {
	
	@Autowired
	private DriverRepository driverRepository;
	
    private static final String UPLOAD_DIR = "uploads/drivers/";

    
	public ResponseEntity<?> uploadFile(Long driverId, MultipartFile file, String type) throws IOException
    {
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


	public Driver saveDriverInfo(Driver driver) {
		return driverRepository.save(driver);
	}


	public ResponseEntity<byte[]> downloadFile(String filename) throws IOException {
		  Path path = Paths.get(UPLOAD_DIR + filename);
	        byte[] fileBytes = Files.readAllBytes(path);

	        return ResponseEntity.ok()
	                .contentType(MediaType.APPLICATION_OCTET_STREAM)
	                .header("Content-Disposition", "attachment; filename=\"" + filename + "\"")
	                .body(fileBytes);
	}


	public Driver getDriver(Long id) {
		
		return driverRepository.findById(id).orElse(null);
	}
	  


}
