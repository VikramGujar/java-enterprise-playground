package com.admin.product;
import java.io.*;


@SuppressWarnings("serial")
public class AdminBean implements Serializable
{
	private String userName, password, firstName, lastName, city, mailId;
	private long phoneNumber;
	
	public AdminBean() {}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setMailId(String mailId) {
		this.mailId = mailId;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getUserName() {
		return userName;
	}

	public String getPassword() {
		return password;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getCity() {
		return city;
	}

	public String getMailId() {
		return mailId;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}
	
	
	
	
}
