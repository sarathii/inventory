package com.inventory.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
// @Table(name="custom")
public class CustomerModel implements Serializable {
	// declaring attributes
	@Id
	private String code;

	private String name;

	private String address;
	private String city;
	private Long pinCode;
	private Long contact;
	private String designation;
	private String delivered;
	private String destiation;
	private String remarks;

	

	private Long office;
	private Long fax;
	private Long factory;
	private Long mobile;
	private Long pager;
	private String range;
	private String email;
	private String url;
	private String pan;
	private String ecc;
	private String vendor;
	private String div;
	private String gst;
	private String std;
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
	public Long getPinCode() {
		return pinCode;
	}
	public void setPinCode(Long pinCode) {
		this.pinCode = pinCode;
	}
	public Long getContact() {
		return contact;
	}
	public void setContact(Long contact) {
		this.contact = contact;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getDelivered() {
		return delivered;
	}
	public void setDelivered(String delivered) {
		this.delivered = delivered;
	}
	public String getDestiation() {
		return destiation;
	}
	public void setDestiation(String destiation) {
		this.destiation = destiation;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public Long getOffice() {
		return office;
	}
	public void setOffice(Long office) {
		this.office = office;
	}
	public Long getFax() {
		return fax;
	}
	public void setFax(Long fax) {
		this.fax = fax;
	}
	public Long getFactory() {
		return factory;
	}
	public void setFactory(Long factory) {
		this.factory = factory;
	}
	public Long getMobile() {
		return mobile;
	}
	public void setMobile(Long mobile) {
		this.mobile = mobile;
	}
	public Long getPager() {
		return pager;
	}
	public void setPager(Long pager) {
		this.pager = pager;
	}
	public String getRange() {
		return range;
	}
	public void setRange(String range) {
		this.range = range;
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
	public String getPan() {
		return pan;
	}
	public void setPan(String pan) {
		this.pan = pan;
	}
	public String getEcc() {
		return ecc;
	}
	public void setEcc(String ecc) {
		this.ecc = ecc;
	}
	public String getVendor() {
		return vendor;
	}
	public void setVendor(String vendor) {
		this.vendor = vendor;
	}
	public String getDiv() {
		return div;
	}
	public void setDiv(String div) {
		this.div = div;
	}
	public String getGst() {
		return gst;
	}
	public void setGst(String gst) {
		this.gst = gst;
	}
	public String getStd() {
		return std;
	}
	public void setStd(String std) {
		this.std = std;
	}

	
}
