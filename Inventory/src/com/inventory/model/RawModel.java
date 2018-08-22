package com.inventory.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class RawModel {
	@Id
private String code;
private String des;
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
}
