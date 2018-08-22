package com.inventory.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="customer")
public class Cls {
	public int getName() {
		return name;
	}

	public void setName(int name) {
		this.name = name;
	}

	@Id
private int name;

}
