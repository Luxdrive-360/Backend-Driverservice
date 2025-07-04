package com.luxdrive.DriverService.Driver;

import org.springframework.web.multipart.MultipartFile;

public class DriverRequest {
	
	 private String fullName;
	    private String email;
	    private String phone;
	    private String city;
	    private String gearType;
	    private String carName;
	    private String dob;
	    private String referenceNumber;
	    private String referenceRelation;
	    private String referenceName;

	    private MultipartFile licenseFront;
	    private MultipartFile licenseBack;
	    private MultipartFile aadharFront;
	    private MultipartFile aadharBack;
	    private MultipartFile photo;
		public String getFullName() {
			return fullName;
		}
		public void setFullName(String fullName) {
			this.fullName = fullName;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getPhone() {
			return phone;
		}
		public void setPhone(String phone) {
			this.phone = phone;
		}
		public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
		}
		public String getGearType() {
			return gearType;
		}
		public void setGearType(String gearType) {
			this.gearType = gearType;
		}
		public String getCarName() {
			return carName;
		}
		public void setCarName(String carName) {
			this.carName = carName;
		}
		public String getDob() {
			return dob;
		}
		public void setDob(String dob) {
			this.dob = dob;
		}
		public String getReferenceNumber() {
			return referenceNumber;
		}
		public void setReferenceNumber(String referenceNumber) {
			this.referenceNumber = referenceNumber;
		}
		public String getReferenceRelation() {
			return referenceRelation;
		}
		public void setReferenceRelation(String referenceRelation) {
			this.referenceRelation = referenceRelation;
		}
		public String getReferenceName() {
			return referenceName;
		}
		public void setReferenceName(String referenceName) {
			this.referenceName = referenceName;
		}
		public MultipartFile getLicenseFront() {
			return licenseFront;
		}
		public void setLicenseFront(MultipartFile licenseFront) {
			this.licenseFront = licenseFront;
		}
		public MultipartFile getLicenseBack() {
			return licenseBack;
		}
		public void setLicenseBack(MultipartFile licenseBack) {
			this.licenseBack = licenseBack;
		}
		public MultipartFile getAadharFront() {
			return aadharFront;
		}
		public void setAadharFront(MultipartFile aadharFront) {
			this.aadharFront = aadharFront;
		}
		public MultipartFile getAadharBack() {
			return aadharBack;
		}
		public void setAadharBack(MultipartFile aadharBack) {
			this.aadharBack = aadharBack;
		}
		public MultipartFile getPhoto() {
			return photo;
		}
		public void setPhoto(MultipartFile photo) {
			this.photo = photo;
		}
		public DriverRequest() {
			super();
			// TODO Auto-generated constructor stub
		}
		public DriverRequest(String fullName, String email, String phone, String city, String gearType, String carName,
				String dob, String referenceNumber, String referenceRelation, String referenceName,
				MultipartFile licenseFront, MultipartFile licenseBack, MultipartFile aadharFront,
				MultipartFile aadharBack, MultipartFile photo) {
			super();
			this.fullName = fullName;
			this.email = email;
			this.phone = phone;
			this.city = city;
			this.gearType = gearType;
			this.carName = carName;
			this.dob = dob;
			this.referenceNumber = referenceNumber;
			this.referenceRelation = referenceRelation;
			this.referenceName = referenceName;
			this.licenseFront = licenseFront;
			this.licenseBack = licenseBack;
			this.aadharFront = aadharFront;
			this.aadharBack = aadharBack;
			this.photo = photo;
		}

	    
}
