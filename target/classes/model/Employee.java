package model;

public class Employee {
	String userName;
	String Password;
	String firstName;
	String lastName;
	String emailId;
	String Address;
	String mobileNumber;


	
	//Naming Conventions
	
	
	public String getUserName() {
		return userName;
	}
	
	@Override
	public String toString() {
		return "Employee [userName=" + userName + ", Password=" + Password + ", firstName=" + firstName + ", lastName="
				+ lastName + ", emailId=" + emailId + ", Address=" + Address + ", mobileNumber=" + mobileNumber + "]";
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getPassword() {
		return Password;
	}
	public void setPassword(String Password) {
		this.Password = Password;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	public String getAddress() {
		return Address;
	}
	public void setAddress(String Address) {
		this.Address = Address;
	}
	
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

}
