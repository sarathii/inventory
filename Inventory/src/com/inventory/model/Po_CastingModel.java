package com.inventory.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Po_CastingModel {

	public String venCode;
	public String v_address;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false)
	private int Po_no;
	public Date date;
	public Date Order_valid;
	public String ur_ref;
	public String part_code;
	public String part_des;
	public int qty;
	public String getVenCode() {
		return venCode;
	}
	public void setVenCode(String venCode) {
		this.venCode = venCode;
	}
	public String getV_address() {
		return v_address;
	}
	public void setV_address(String v_address) {
		this.v_address = v_address;
	}
	public int getPo_no() {
		return Po_no;
	}
	public void setPo_no(int po_no) {
		Po_no = po_no;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Date getOrder_valid() {
		return Order_valid;
	}
	public void setOrder_valid(Date order_valid) {
		Order_valid = order_valid;
	}
	public String getUr_ref() {
		return ur_ref;
	}
	public void setUr_ref(String ur_ref) {
		this.ur_ref = ur_ref;
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
	public String getUom() {
		return uom;
	}
	public void setUom(String uom) {
		this.uom = uom;
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
	public Long getIgst() {
		return Igst;
	}
	public void setIgst(Long igst) {
		Igst = igst;
	}
	public long getCgst() {
		return cgst;
	}
	public void setCgst(long cgst) {
		this.cgst = cgst;
	}
	public long getSgst() {
		return sgst;
	}
	public void setSgst(long sgst) {
		this.sgst = sgst;
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
	public String getSpecial_ins() {
		return special_ins;
	}
	public void setSpecial_ins(String special_ins) {
		this.special_ins = special_ins;
	}
	public String getDeli() {
		return deli;
	}
	public void setDeli(String deli) {
		this.deli = deli;
	}
	public String getDel_point() {
		return del_point;
	}
	public void setDel_point(String del_point) {
		this.del_point = del_point;
	}
	public String getInsurance() {
		return insurance;
	}
	public void setInsurance(String insurance) {
		this.insurance = insurance;
	}
	public String getPay_mode() {
		return pay_mode;
	}
	public void setPay_mode(String pay_mode) {
		this.pay_mode = pay_mode;
	}
	public String getTrans() {
		return trans;
	}
	public void setTrans(String trans) {
		this.trans = trans;
	}
	public String uom;
	public long rate;
	public long amount;
	public Long Igst;
	public long cgst;
	public long sgst;
	public int norms;
	public String remarks;
	public String special_ins;
	public String deli;
	public String del_point;
	public String insurance;
	public String pay_mode,trans;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
