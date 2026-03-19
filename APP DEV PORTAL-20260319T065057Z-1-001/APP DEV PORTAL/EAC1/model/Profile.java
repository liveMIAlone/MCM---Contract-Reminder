package com.EacStudentPort.springboot.EAC1.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

@Entity(name = "Profile")
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    // Personal Information
    private String email;
    private String course;
    private String lastName;
    private String firstName;
    private String middleInitial;
    private Date birthday;
    private String birthPlace;
    private String citizenship;
    private String religion;
    private String phoneNumber;
    private String civilStatus;
    private String gender;

    // Residence Information
    private String address;
    private String barangay;
    private String city;
    private String zipCode;

    // Education Information
    private String elementarySchool;
    private String juniorHighSchool;
    private String seniorHighSchool;
    private String college;

    // Parent Information
    private String fathersName;
    private String fathersPhoneNumber;
    private String fathersOccupation;
    private String fathersAddress;
    private String mothersName;
    private String mothersPhoneNumber;
    private String mothersOccupation;
    private String mothersAddress;
	
 // Profile Picture
    @Lob
    @Column(name = "profile_picture", columnDefinition="BLOB")
    private byte[] profilePicture;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleInitial() {
		return middleInitial;
	}

	public void setMiddleInitial(String middleInitial) {
		this.middleInitial = middleInitial;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getBirthPlace() {
		return birthPlace;
	}

	public void setBirthPlace(String birthPlace) {
		this.birthPlace = birthPlace;
	}

	public String getCitizenship() {
		return citizenship;
	}

	public void setCitizenship(String citizenship) {
		this.citizenship = citizenship;
	}

	public String getReligion() {
		return religion;
	}

	public void setReligion(String religion) {
		this.religion = religion;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getCivilStatus() {
		return civilStatus;
	}

	public void setCivilStatus(String civilStatus) {
		this.civilStatus = civilStatus;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBarangay() {
		return barangay;
	}

	public void setBarangay(String barangay) {
		this.barangay = barangay;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getElementarySchool() {
		return elementarySchool;
	}

	public void setElementarySchool(String elementarySchool) {
		this.elementarySchool = elementarySchool;
	}

	public String getJuniorHighSchool() {
		return juniorHighSchool;
	}

	public void setJuniorHighSchool(String juniorHighSchool) {
		this.juniorHighSchool = juniorHighSchool;
	}

	public String getSeniorHighSchool() {
		return seniorHighSchool;
	}

	public void setSeniorHighSchool(String seniorHighSchool) {
		this.seniorHighSchool = seniorHighSchool;
	}

	public String getCollege() {
		return college;
	}

	public void setCollege(String college) {
		this.college = college;
	}

	public String getFathersName() {
		return fathersName;
	}

	public void setFathersName(String fathersName) {
		this.fathersName = fathersName;
	}

	public String getFathersPhoneNumber() {
		return fathersPhoneNumber;
	}

	public void setFathersPhoneNumber(String fathersPhoneNumber) {
		this.fathersPhoneNumber = fathersPhoneNumber;
	}

	public String getFathersOccupation() {
		return fathersOccupation;
	}

	public void setFathersOccupation(String fathersOccupation) {
		this.fathersOccupation = fathersOccupation;
	}

	public String getFathersAddress() {
		return fathersAddress;
	}

	public void setFathersAddress(String fathersAddress) {
		this.fathersAddress = fathersAddress;
	}

	public String getMothersName() {
		return mothersName;
	}

	public void setMothersName(String mothersName) {
		this.mothersName = mothersName;
	}

	public String getMothersPhoneNumber() {
		return mothersPhoneNumber;
	}

	public void setMothersPhoneNumber(String mothersPhoneNumber) {
		this.mothersPhoneNumber = mothersPhoneNumber;
	}

	public String getMothersOccupation() {
		return mothersOccupation;
	}

	public void setMothersOccupation(String mothersOccupation) {
		this.mothersOccupation = mothersOccupation;
	}

	public String getMothersAddress() {
		return mothersAddress;
	}

	public void setMothersAddress(String mothersAddress) {
		this.mothersAddress = mothersAddress;
	}

	public byte[] getProfilePicture() {
		return profilePicture;
	}

	public void setProfilePicture(byte[] profilePicture) {
		this.profilePicture = profilePicture;
	}

    
    
    
}
