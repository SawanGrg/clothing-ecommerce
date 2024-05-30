package com.ecommerce.model;

public class UsersDetails {

	private Integer userId;
	private String userFirstName;
	private String userLastName;
	private String userName;
	private String userEmail;
	private String userPassword;
	private String usercontact;
	private String userAddress;
	private String userImage;
	private String userGender;
	private String userRole;

	public UsersDetails() {
		// Default constructor
	}

	// Parameterized constructor With id
	public UsersDetails(Integer userId, String userFirstName, String userLastName, String userName, String userEmail,
			String userPassword, String usercontact, String userAddress, String userImage, String userGender,
			String userRole) {
		// Parameterized constructor
		this.userId = userId;
		this.userFirstName = userFirstName;
		this.userLastName = userLastName;
		this.userName = userName;
		this.userEmail = userEmail;
		this.userPassword = userPassword;
		this.usercontact = usercontact;
		this.userAddress = userAddress;
		this.userImage = userImage;
		this.userGender = userGender;
		this.userRole = userRole;

	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserFirstName() {
		return userFirstName;
	}

	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}

	public String getUserLastName() {
		return userLastName;
	}

	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUsercontact() {
		return usercontact;
	}

	public void setUsercontact(String usercontact) {
		this.usercontact = usercontact;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public String getUserImage() {
		return userImage;
	}

	public void setUserImage(String userImage) {
		this.userImage = userImage;
	}

	public String getUserGender() {
		return userGender;
	}

	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
}