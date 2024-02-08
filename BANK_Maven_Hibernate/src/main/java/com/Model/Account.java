package com.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Account {
	// That was used for get the auto generated value for the account number
	@SequenceGenerator(sequenceName="Account_seq",initialValue=123456,allocationSize=1, name = "ac_seq")
	@GeneratedValue(generator="ac_seq",strategy=GenerationType.SEQUENCE)
	@Id
	private int id;
	private String acname;
	private String address;
	private long mob_no;
	private long adhar_no;
	private String pan_no;
	private double balance;
	private String actype;
	private String gender;
	
	@Override
	public String toString() {
		return "Account [id=" + id + ", acname=" + acname + ", address=" + address + ", mob_no=" + mob_no
				+ ", adhar_no=" + adhar_no + ", pan_no=" + pan_no + ", balance=" + balance + ", actype=" + actype
				+ ", gender=" + gender + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAcname() {
		return acname;
	}
	public void setAcname(String acname) {
		this.acname = acname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public long getMob_no() {
		return mob_no;
	}
	public void setMob_no(long mob_no) {
		this.mob_no = mob_no;
	}
	public long getAdhar_no() {
		return adhar_no;
	}
	public void setAdhar_no(long adhar_no) {
		this.adhar_no = adhar_no;
	}
	public String getPan_no() {
		return pan_no;
	}
	public void setPan_no(String pan_no) {
		this.pan_no = pan_no;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String getActype() {
		return actype;
	}
	public void setActype(String actype) {
		this.actype = actype;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
}
