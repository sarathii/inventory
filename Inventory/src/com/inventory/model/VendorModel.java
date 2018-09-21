package com.inventory.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class VendorModel {
	@Id
	private String code;

	private String name;

	private String address;
	private String city;
	private long pinCode;
	private long contact;
	private String designation;

	private String remarks;
	private long office;
	private long fax;
	private long factory;
	private  long mobile;
	private long pager;

	private String email;
	private String url;
	private String eci;
	private String ecc;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	

	public long getPinCode() {
		return pinCode;
	}

	public void setPinCode(long pinCode) {
		this.pinCode = pinCode;
	}

	public long getContact() {
		return contact;
	}

	public void setContact(long contact) {
		this.contact = contact;
	}

	public long getOffice() {
		return office;
	}

	public void setOffice(long office) {
		this.office = office;
	}

	public long getFax() {
		return fax;
	}

	public void setFax(long fax) {
		this.fax = fax;
	}

	public long getFactory() {
		return factory;
	}

	public void setFactory(long factory) {
		this.factory = factory;
	}

	public long getMobile() {
		return mobile;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}

	public long getPager() {
		return pager;
	}

	public void setPager(long pager) {
		this.pager = pager;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getEci() {
		return eci;
	}

	public void setEci(String eci) {
		this.eci = eci;
	}

	public String getEcc() {
		return ecc;
	}

	public void setEcc(String ecc) {
		this.ecc = ecc;
	}

}
