package com.luxdrive.DriverService.Driver;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/driver")
public class DriverController {

	@Autowired
	private DriverService driverService;

	@Autowired
	private DriverRepository driverRepository;

	// ✅ Upload document or photo
	@PostMapping("/{driverId}/upload")
	public ResponseEntity<?> uploadFile(@PathVariable Long driverId, @RequestParam("file") MultipartFile file,
			@RequestParam("type") String type // e.g. photo, licenseFront
	) throws IOException {

		return driverService.uploadFile(driverId, file, type);

	}

	// ✅ Save driver basic information (Step 1 of form)
	@PostMapping("/save-info")
	public Driver saveDriverInfo(@RequestBody Driver driver) {
		return driverService.saveDriverInfo(driver);
	}

	// ✅ (Optional) Download endpoint
	@GetMapping("/download")
	public ResponseEntity<byte[]> downloadFile(@RequestParam String filename) throws IOException {
		return driverService.downloadFile(filename);

	}
	
	@GetMapping("profile/{driverId}")
	public Driver getDriver(@PathVariable("driverId") Long id) {
		return driverService.getDriver(id);
		
	}
}
