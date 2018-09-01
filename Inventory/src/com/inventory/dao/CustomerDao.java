package com.inventory.dao;

import java.util.List;

import com.inventory.model.CustomerModel;

public interface CustomerDao {


	List<CustomerModel> getAllCustomer();

	CustomerModel  getCustomertById(String CustomerId);

	void deleteCustomer(String productId);

	void addCustomer(CustomerModel customerModel);
	
	void editCustomer(CustomerModel customerModel);
	
}