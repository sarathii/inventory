package com.inventory.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PORawTableModel {
@Id
	private String code, des;

	private int quantity, unit, unitrate;
	private double amount, igst, cgst,sgst;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDes() {
		return des;
	}

	public void setDes(String des) {
		this.des = des;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getUnit() {
		return unit;
	}

	public void setUnit(int unit) {
		this.unit = unit;
	}

	public int getUnitrate() {
		return unitrate;
	}

	public void setUnitrate(int unitrate) {
		this.unitrate = unitrate;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getIgst() {
		return igst;
	}

	public void setIgst(double igst) {
		this.igst = igst;
	}

	public double getCgst() {
		return cgst;
	}

	public void setCgst(double cgst) {
		this.cgst = cgst;
	}

	public double getSgst() {
		return sgst;
	}

	public void setSgst(double sgst) {
		this.sgst = sgst;
	}

	

}
