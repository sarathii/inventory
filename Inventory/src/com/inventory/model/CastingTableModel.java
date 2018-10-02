package com.inventory.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CastingTableModel {

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPono() {
		return pono;
	}

	public void setPono(int pono) {
		this.pono = pono;
	}

	public String getPart_code() {
		return part_code;
	}

	public void setPart_code(String part_code) {
		this.part_code = part_code;
	}

	public String getPart_des() {
		return part_des;
	}

	public void setPart_des(String part_des) {
		this.part_des = part_des;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	
	public long getRate() {
		return rate;
	}

	public void setRate(long rate) {
		this.rate = rate;
	}

	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}


	public int getNorms() {
		return norms;
	}

	public void setNorms(int norms) {
		this.norms = norms;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String v_code;

	public String getV_code() {
		return v_code;
	}

	public void setV_code(String v_code) {
		this.v_code = v_code;
	}

	public int pono;

	public String part_code;
	public String part_des;
	public int qty;

	public int uom;
	public void setUom(int uom) {
		this.uom = uom;
	}

	public Double getIgst() {
		return Igst;
	}

	public Double getCgst() {
		return cgst;
	}

	public Double getSgst() {
		return sgst;
	}

	public long rate;
	public long amount;
	public Double Igst;
	public Double cgst;
	public Double sgst;
	public int getUom() {
		return uom;
	}

	

	public void setIgst(Double igst) {
		Igst = igst;
	}

	public void setCgst(Double cgst) {
		this.cgst = cgst;
	}

	public void setSgst(Double sgst) {
		this.sgst = sgst;
	}

	public int norms;
	public String remarks;

}
