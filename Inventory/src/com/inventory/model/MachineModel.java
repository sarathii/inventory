package com.inventory.model;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class MachineModel {
	
	
	
	@Id
	private String Mcode;
	private String MDes;
	
	
	
	public String getMcode() {
		return Mcode;
	}
	public void setMcode(String mcode) {
		Mcode = mcode;
	}
	public String getMDes() {
		return MDes;
	}
	public void setMDes(String mDes) {
		MDes = mDes;
	}
	
	
	
	
	
	
	
	
	

}
