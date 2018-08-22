package com.inventory.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.inventory.model.Cls;
import com.inventory.model.CustomerModel;

public class Main {

	
void insert()
{
	SessionFactory sessionFactory= new Configuration().configure().buildSessionFactory();
	Session session=sessionFactory.openSession();
	session.beginTransaction();
CustomerModel customerModel=new CustomerModel();
	customerModel.setName("pri");

customerModel.setAddress("chennai");
customerModel.setCity("vh");
customerModel.setCode("boy");
customerModel.setContact(99);
customerModel.setDelivered("hat");
customerModel.setDesignation("nu");
customerModel.setDiv("po");
customerModel.setEcc("cc");
customerModel.setEmail("oop");
customerModel.setFactory(888);
customerModel.setFax(99);
customerModel.setGst("bn");
customerModel.setMobile(999);
customerModel.setOffice(88);
customerModel.setPager(66);
customerModel.setPan("nnnn");
customerModel.setPinCode(88);
customerModel.setRange("ggg");
customerModel.setRemarks("h");
customerModel.setStd("ggg");
customerModel.setUrl("ggg");
customerModel.setVendor("vendor");


session.save(customerModel);
session.getTransaction().commit();
session.close();
sessionFactory.close();
}
public static void main(String[] args) {
	// TODO Auto-generated method stub
CustomerModel customerModel=new CustomerModel();

}
}