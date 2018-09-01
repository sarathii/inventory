package com.inventory.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.SQLInsert;


@Entity
public class MouldModel implements Serializable {
//@GenericGenerator(name="newGenerator", strategy = "foreign",parameters=@Parameter(value="cuatomerModel",name="property"))
	private String code;

	private String name;
	private String mouldName;
	@Id
	private String mouldCode;
	private Long totalshot;
	//@OneToOne(cascade =CascadeType.ALL)
	//@JoinColumn(name="code" ,nullable=false ,  insertable=false, updatable=false)
	/*private CustomerModel customerModel;
	
	
	
	
	public CustomerModel getCustomerModel() {
		return customerModel;
	}
	public void setCustomerModel(CustomerModel customerModel) {
		this.customerModel = customerModel;
	}*/
	
	
	
	
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
	public String getMouldName() {
		return mouldName;
	}
	public void setMouldName(String mouldName) {
		this.mouldName = mouldName;
	}
	public String getMouldCode() {
		return mouldCode;
	}
	public void setMouldCode(String mouldCode) {
		this.mouldCode = mouldCode;
	}
	public Long getTotalshot() {
		return totalshot;
	}
	public void setTotalshot(Long totalshot) {
		this.totalshot = totalshot;
	}
	
	
	
	
	
}
