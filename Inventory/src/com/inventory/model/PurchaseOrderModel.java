package com.inventory.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
public class PurchaseOrderModel {
	
	
	public float getIgst() {
		return Igst;
	}
	public float getCgst() {
		return cgst;
	}
	public float getSgst() {
		return sgst;
	}
	private String cusCode;
	private String CusName;
	private String partCode;
	@Id
	private  Long poNo;
	@Temporal(TemporalType.DATE)
	private Date date;
	private Long Quantity;
	private long rate;
	private long st;
	private long ed;
	private Long mrp;
	public void setIgst(float igst) {
		Igst = igst;
	}
	public void setCgst(float cgst) {
		this.cgst = cgst;
	}
	public void setSgst(float sgst) {
		this.sgst = sgst;
	}
	private String hsn;
	private float Igst;
	private float cgst;
	private float sgst;
	
	
	
	
	
	public String getCusCode() {
		return cusCode;
	}
	public void setCusCode(String cusCode) {
		this.cusCode = cusCode;
	}
	public String getCusName() {
		return CusName;
	}
	public void setCusName(String cusName) {
		CusName = cusName;
	}
	public String getPartCode() {
		return partCode;
	}
	public void setPartCode(String partCode) {
		this.partCode = partCode;
	}
	public Long getPoNo() {
		return poNo;
	}
	public void setPoNo(Long poNo) {
		this.poNo = poNo;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Long getQuantity() {
		return Quantity;
	}
	public void setQuantity(Long quantity) {
		Quantity = quantity;
	}
	public long getRate() {
		return rate;
	}
	public void setRate(long rate) {
		this.rate = rate;
	}
	public long getSt() {
		return st;
	}
	public void setSt(long st) {
		this.st = st;
	}
	public long getEd() {
		return ed;
	}
	public void setEd(long ed) {
		this.ed = ed;
	}
	public Long getMrp() {
		return mrp;
	}
	public void setMrp(Long mrp) {
		this.mrp = mrp;
	}
	public String getHsn() {
		return hsn;
	}
	public void setHsn(String hsn) {
		this.hsn = hsn;
	}
	
	
	
	
	
	
	
	
	

}
