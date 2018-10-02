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
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column( columnDefinition="int GENERATED BY DEFAULT AS IDENTITY (start with 1, increment by 1) ")
	//@NotNull
	private int Po_no;
	public Date date;
	public Date Order_valid;
	public String ur_ref;
	
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
	
	public String special_ins;
	public String deli;
	public String del_point;
	public String insurance;
	public String pay_mode,trans;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
