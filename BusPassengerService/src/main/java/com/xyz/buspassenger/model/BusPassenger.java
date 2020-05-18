package com.xyz.buspassenger.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class BusPassenger {
	
	@Id
	@Column
	private int ticketNumber;
	@Column
	private String name;
	@Column
	private String gender;
	@Column
	private int age;
	@Column
	private String seatNumber;
	@Column
	private long mobileNumber;
	@Column
	private String emailId;
	@Column
	private String couponCode;
	@Column
	private String sourceCity;
	@Column
	private String destiantionCity;
	public BusPassenger() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BusPassenger(int ticketNumber, String name, String gender, int age, String seatNumber, long mobileNumber,
			String emailId, String couponCode, String sourceCity, String destiantionCity) {
		super();
		this.ticketNumber = ticketNumber;
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.seatNumber = seatNumber;
		this.mobileNumber = mobileNumber;
		this.emailId = emailId;
		this.couponCode = couponCode;
		this.sourceCity = sourceCity;
		this.destiantionCity = destiantionCity;
	}
	public int getTicketNumber() {
		return ticketNumber;
	}
	public void setTicketNumber(int ticketNumber) {
		this.ticketNumber = ticketNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getSeatNumber() {
		return seatNumber;
	}
	public void setSeatNumber(String seatNumber) {
		this.seatNumber = seatNumber;
	}
	public long getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getCouponCode() {
		return couponCode;
	}
	public void setCouponCode(String couponCode) {
		this.couponCode = couponCode;
	}
	public String getSourceCity() {
		return sourceCity;
	}
	public void setSourceCity(String sourceCity) {
		this.sourceCity = sourceCity;
	}
	public String getDestiantionCity() {
		return destiantionCity;
	}
	public void setDestiantionCity(String destiantionCity) {
		this.destiantionCity = destiantionCity;
	}
	@Override
	public String toString() {
		return "BusPassenger [ticketNumber=" + ticketNumber + ", name=" + name + ", gender=" + gender + ", age=" + age
				+ ", seatNumber=" + seatNumber + ", mobileNumber=" + mobileNumber + ", emailId=" + emailId
				+ ", couponCode=" + couponCode + ", sourceCity=" + sourceCity + ", destiantionCity=" + destiantionCity
				+ "]";
	}
	
	

	
}
