package com.inventory.frames;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import com.jgoodies.forms.layout.FormLayout;
import com.inventory.model.CustomerModel;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import net.proteanit.sql.DbUtils;

import com.jgoodies.forms.layout.FormSpecs;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
//import org.hibernate.mapping.List;

import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.JSeparator;
import javax.swing.JTable;

import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;
import java.awt.event.ActionEvent;

import javax.persistence.Query;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import java.awt.Color;

public class CustomerForm {
	public JTextArea address;
	public JFrame frmCustomerDetail;
	public JTextField code1;
	public JTextField name;
	public JTextField pincode;
	public JTextField city;
	public JTextField contact;
	public JTextField designation;
	public JTextField destination;
	public JTextField office;
	public JTextField fax;
	public JTextField factory;
	public JTextField mobile;
	public JTextField pager;
	public JTextField email;
	public JTextField url;
	public JTextField pan;
	public JTextField ecc;
	public JTextField gst;
	public JTextField vendor;
	public JTextField div;
	public JTextField range;
	public JTextField std;
	private JTextField textField_15;
	private final JSeparator separator_4 = new JSeparator();
	private final JSeparator separator_5 = new JSeparator();
	public JTextArea deliver;
	public JTextArea remarks;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerForm window = new CustomerForm();
					window.frmCustomerDetail.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CustomerForm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCustomerDetail = new JFrame();
		frmCustomerDetail.getContentPane().setFont(new Font("Times New Roman", Font.BOLD, 16));
		frmCustomerDetail.setTitle("Customer Detail");
		frmCustomerDetail.setBounds(250, 250, 931, 772);
		frmCustomerDetail.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCustomerDetail.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Code");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel.setBounds(10, 50, 46, 14);
		frmCustomerDetail.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1.setBounds(10, 86, 46, 14);
		frmCustomerDetail.getContentPane().add(lblNewLabel_1);

		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblAddress.setBounds(10, 125, 62, 22);
		frmCustomerDetail.getContentPane().add(lblAddress);

		JLabel lblCity = new JLabel("City");
		lblCity.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblCity.setBounds(343, 221, 46, 22);
		frmCustomerDetail.getContentPane().add(lblCity);

		JLabel lblPincode = new JLabel("PinCode");
		lblPincode.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblPincode.setBounds(568, 225, 73, 14);
		frmCustomerDetail.getContentPane().add(lblPincode);

		JLabel lblContact = new JLabel("Contact");
		lblContact.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblContact.setBounds(10, 221, 73, 14);
		frmCustomerDetail.getContentPane().add(lblContact);

		JLabel lblDesignation = new JLabel("Designation");
		lblDesignation.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblDesignation.setBounds(20, 269, 98, 22);
		frmCustomerDetail.getContentPane().add(lblDesignation);

		code1 = new JTextField();
		code1.setFont(new Font("Monospaced", Font.PLAIN, 16));
		lblNewLabel.setLabelFor(code1);
		code1.setBounds(115, 48, 62, 20);
		frmCustomerDetail.getContentPane().add(code1);
		code1.setColumns(10);

		name = new JTextField();
		name.setFont(new Font("Monospaced", Font.PLAIN, 16));
		lblNewLabel_1.setLabelFor(name);
		name.setBounds(115, 86, 234, 29);
		frmCustomerDetail.getContentPane().add(name);
		name.setColumns(10);

		JTextArea textArea = new JTextArea();
		textArea.setBounds(115, 114, 175, -52);
		frmCustomerDetail.getContentPane().add(textArea);

		pincode = new JTextField();
		pincode.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblPincode.setLabelFor(pincode);
		pincode.setBounds(651, 219, 98, 29);
		frmCustomerDetail.getContentPane().add(pincode);
		pincode.setColumns(10);

		city = new JTextField();
		city.setFont(new Font("Monospaced", Font.PLAIN, 16));
		lblCity.setLabelFor(city);
		city.setColumns(10);
		city.setBounds(399, 217, 159, 26);
		frmCustomerDetail.getContentPane().add(city);

		contact = new JTextField();
		contact.setFont(new Font("Monospaced", Font.PLAIN, 16));
		lblContact.setLabelFor(contact);
		contact.setColumns(10);
		contact.setBounds(115, 215, 193, 29);
		frmCustomerDetail.getContentPane().add(contact);

		designation = new JTextField();
		designation.setFont(new Font("Monospaced", Font.PLAIN, 16));
		lblDesignation.setLabelFor(designation);
		designation.setColumns(10);
		designation.setBounds(118, 267, 204, 29);
		frmCustomerDetail.getContentPane().add(designation);

		JTextArea address = new JTextArea();
		address.setFont(new Font("Monospaced", Font.PLAIN, 14));
		lblAddress.setLabelFor(address);
		address.setLineWrap(true);
		address.setBounds(109, 125, 240, 53);
		frmCustomerDetail.getContentPane().add(address);

		JSeparator separator = new JSeparator();
		separator.setBounds(413, 50, 1, 225);
		frmCustomerDetail.getContentPane().add(separator);

		JLabel lblNewLabel_2 = new JLabel("Delivered To");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_2.setBounds(413, 46, 99, 22);
		frmCustomerDetail.getContentPane().add(lblNewLabel_2);

		JTextArea deliver = new JTextArea();
		deliver.setLineWrap(true);
		deliver.setFont(new Font("Monospaced", Font.PLAIN, 16));
		deliver.setBounds(522, 44, 311, 53);
		frmCustomerDetail.getContentPane().add(deliver);

		JLabel lblDestination = new JLabel("Destination");
		lblDestination.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblDestination.setBounds(424, 113, 89, 22);
		frmCustomerDetail.getContentPane().add(lblDestination);

		destination = new JTextField();
		destination.setFont(new Font("Monospaced", Font.PLAIN, 16));
		destination.setBounds(542, 116, 222, 31);
		frmCustomerDetail.getContentPane().add(destination);
		destination.setColumns(10);

		JLabel lblRemars = new JLabel("Remarks");
		lblRemars.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblRemars.setBounds(424, 162, 89, 22);
		frmCustomerDetail.getContentPane().add(lblRemars);

		JTextArea remarks = new JTextArea();
		remarks.setLineWrap(true);
		remarks.setFont(new Font("Monospaced", Font.PLAIN, 16));
		remarks.setBounds(542, 157, 311, 53);
		frmCustomerDetail.getContentPane().add(remarks);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 322, 892, -5);
		frmCustomerDetail.getContentPane().add(separator_1);

		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(10, 315, 854, -4);
		frmCustomerDetail.getContentPane().add(separator_2);

		JLabel lblOffice = new JLabel("Office");
		lblOffice.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblOffice.setBounds(10, 323, 47, 22);
		frmCustomerDetail.getContentPane().add(lblOffice);

		JLabel lblFax = new JLabel("Fax");
		lblFax.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblFax.setBounds(302, 323, 47, 22);
		frmCustomerDetail.getContentPane().add(lblFax);

		JLabel lblFactory = new JLabel("Factory");
		lblFactory.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblFactory.setBounds(519, 323, 59, 22);
		frmCustomerDetail.getContentPane().add(lblFactory);

		JLabel lblMobile = new JLabel("Mobile");
		lblMobile.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblMobile.setBounds(9, 372, 55, 22);
		frmCustomerDetail.getContentPane().add(lblMobile);

		JLabel lblPager = new JLabel("Pager");
		lblPager.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblPager.setBounds(302, 378, 47, 22);
		frmCustomerDetail.getContentPane().add(lblPager);

		office = new JTextField();
		office.setFont(new Font("Monospaced", Font.PLAIN, 16));
		office.setColumns(10);
		office.setBounds(80, 326, 210, 29);
		frmCustomerDetail.getContentPane().add(office);

		fax = new JTextField();
		fax.setFont(new Font("Monospaced", Font.PLAIN, 16));
		fax.setColumns(10);
		fax.setBounds(337, 322, 175, 29);
		frmCustomerDetail.getContentPane().add(fax);

		factory = new JTextField();
		factory.setFont(new Font("Monospaced", Font.PLAIN, 16));
		factory.setColumns(10);
		factory.setBounds(588, 321, 234, 29);
		frmCustomerDetail.getContentPane().add(factory);

		mobile = new JTextField();
		mobile.setFont(new Font("Monospaced", Font.PLAIN, 16));
		mobile.setColumns(10);
		mobile.setBounds(77, 370, 213, 29);
		frmCustomerDetail.getContentPane().add(mobile);

		pager = new JTextField();
		pager.setFont(new Font("Monospaced", Font.PLAIN, 16));
		pager.setColumns(10);
		pager.setBounds(359, 375, 234, 29);
		frmCustomerDetail.getContentPane().add(pager);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblEmail.setBounds(10, 434, 47, 22);
		frmCustomerDetail.getContentPane().add(lblEmail);

		JLabel lblUrl = new JLabel("URL");
		lblUrl.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblUrl.setBounds(367, 434, 47, 22);
		frmCustomerDetail.getContentPane().add(lblUrl);

		email = new JTextField();
		email.setFont(new Font("Monospaced", Font.PLAIN, 16));
		email.setColumns(10);
		email.setBounds(77, 434, 245, 29);
		frmCustomerDetail.getContentPane().add(email);

		url = new JTextField();
		url.setFont(new Font("Monospaced", Font.PLAIN, 16));
		url.setColumns(10);
		url.setBounds(447, 427, 375, 29);
		frmCustomerDetail.getContentPane().add(url);

		JLabel lblPanNo = new JLabel("PAN no");
		lblPanNo.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblPanNo.setBounds(10, 490, 69, 22);
		frmCustomerDetail.getContentPane().add(lblPanNo);

		pan = new JTextField();
		pan.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		pan.setColumns(10);
		pan.setBounds(77, 488, 245, 29);
		frmCustomerDetail.getContentPane().add(pan);

		JLabel lblEccCodeNo = new JLabel("E.C.C code no");
		lblEccCodeNo.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblEccCodeNo.setBounds(10, 537, 113, 22);
		frmCustomerDetail.getContentPane().add(lblEccCodeNo);

		JLabel lblGstNo = new JLabel("GST no");
		lblGstNo.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblGstNo.setBounds(10, 570, 60, 22);
		frmCustomerDetail.getContentPane().add(lblGstNo);

		ecc = new JTextField();
		ecc.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		ecc.setColumns(10);
		ecc.setBounds(133, 535, 210, 29);
		frmCustomerDetail.getContentPane().add(ecc);

		gst = new JTextField();
		gst.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		gst.setColumns(10);
		gst.setBounds(92, 573, 245, 29);
		frmCustomerDetail.getContentPane().add(gst);

		JLabel lblVendorCode = new JLabel("Vendor code");
		lblVendorCode.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblVendorCode.setBounds(377, 537, 99, 22);
		frmCustomerDetail.getContentPane().add(lblVendorCode);

		vendor = new JTextField();
		vendor.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		vendor.setColumns(10);
		vendor.setBounds(499, 534, 124, 29);
		frmCustomerDetail.getContentPane().add(vendor);

		JLabel lblDivision = new JLabel("Division");
		lblDivision.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblDivision.setBounds(633, 537, 99, 22);
		frmCustomerDetail.getContentPane().add(lblDivision);

		JLabel lblRange = new JLabel("Range");
		lblRange.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblRange.setBounds(387, 576, 99, 22);
		frmCustomerDetail.getContentPane().add(lblRange);

		div = new JTextField();
		div.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		div.setColumns(10);
		div.setBounds(727, 534, 124, 29);
		frmCustomerDetail.getContentPane().add(div);

		range = new JTextField();
		range.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		range.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		range.setColumns(10);
		range.setBounds(499, 573, 124, 29);
		frmCustomerDetail.getContentPane().add(range);

		JLabel lblSalesTaxDescription = new JLabel("Sales Tax Description");
		lblSalesTaxDescription.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblSalesTaxDescription.setBounds(350, 490, 167, 22);
		frmCustomerDetail.getContentPane().add(lblSalesTaxDescription);

		std = new JTextField();
		std.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		std.setColumns(10);
		std.setBounds(542, 490, 175, 29);
		frmCustomerDetail.getContentPane().add(std);

		textField_15 = new JTextField();
		textField_15.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		textField_15.setColumns(10);
		textField_15.setBounds(727, 490, 124, 29);
		frmCustomerDetail.getContentPane().add(textField_15);

		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(10, 315, 930, -5);
		frmCustomerDetail.getContentPane().add(separator_3);
		separator_5.setBounds(10, 414, 867, 9);
		frmCustomerDetail.getContentPane().add(separator_5);
		separator_4.setBounds(6, 302, 879, 9);
		frmCustomerDetail.getContentPane().add(separator_4);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				
				
				
				
			}
		});
		scrollPane.setBounds(10, 611, 879, 122);
		frmCustomerDetail.getContentPane().add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		
		JMenuItem mntmSave = new JMenuItem("save");
		mntmSave.setIcon(new ImageIcon("C:\\Users\\Priya\\Pictures\\inventory\\save.png"));
		mntmSave.setFont(new Font("Arial", Font.BOLD, 14));
		mntmSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
				Session session = sessionFactory.openSession();
				session.beginTransaction();
				CustomerModel customerModel = new CustomerModel();
				customerModel.setAddress(address.getText());
				customerModel.setCity(city.getText());
				customerModel.setCode(code1.getText());
				customerModel.setContact(Integer.parseInt(contact.getText()));
				customerModel.setDelivered(deliver.getText());
				customerModel.setDesignation(designation.getText());
				customerModel.setDestiation(destination.getText());
				customerModel.setDiv(div.getText());
				customerModel.setEcc(ecc.getText());
				customerModel.setEmail(email.getText());
				customerModel.setFactory(Integer.parseInt(factory.getText()));
				customerModel.setFax(Integer.parseInt(fax.getText()));
				customerModel.setGst(gst.getText());
				customerModel.setMobile(Integer.parseInt(mobile.getText()));
				customerModel.setName(name.getText());
				customerModel.setOffice(Integer.parseInt(office.getText()));
				customerModel.setPager(Integer.parseInt(pager.getText()));
				customerModel.setPan(pan.getText());
				customerModel.setPinCode(Integer.parseInt(pincode.getText()));
				customerModel.setRange(range.getText());
				customerModel.setRemarks(remarks.getText());
				customerModel.setStd(std.getText());
				customerModel.setUrl(url.getText());
				customerModel.setVendor(vendor.getText());
				
				if(address.getText().length()==0)
				{
						
				
				JOptionPane.showMessageDialog(null, "valuue");
				}
				JOptionPane.showMessageDialog(null, "saved");
				session.save(customerModel);
				
				
				
				@SuppressWarnings("unchecked")
				List<CustomerModel> products = session.createQuery("from CustomerModel").list();

				Vector<String> tableHeaders = new Vector<String>();
				Vector tableData = new Vector();
				tableHeaders.add("code");
				tableHeaders.add("name");
				tableHeaders.add("address");
				tableHeaders.add("city");
				tableHeaders.add("contact");
				tableHeaders.add("deliver");
				tableHeaders.add("designation");
				tableHeaders.add("destination");
				tableHeaders.add("div");
				tableHeaders.add("ecc");
				tableHeaders.add("email");
				tableHeaders.add("factory");
				tableHeaders.add("fax");
				tableHeaders.add("gst");
				tableHeaders.add("pincode");
				tableHeaders.add("remarks");
				tableHeaders.add("office");
				tableHeaders.add("mobile");
				tableHeaders.add("pager");
				tableHeaders.add("pan");
				tableHeaders.add("std");
				tableHeaders.add("url");
				tableHeaders.add("vendor");
				tableHeaders.add("range");

				// tableHeaders.add("name");
				for (Object o : products) {
					CustomerModel model = (CustomerModel) o;
					Vector<Object> oneRow = new Vector<Object>();
					oneRow.add(model.getCode());
					oneRow.add(model.getName());
					oneRow.add(model.getAddress());
					oneRow.add(model.getCity());
					oneRow.add(model.getContact());
					oneRow.add(model.getDelivered());
					oneRow.add(model.getDesignation());
					oneRow.add(model.getDestiation());
					oneRow.add(model.getDiv());
					oneRow.add(model.getEcc());
					oneRow.add(model.getEmail());
					oneRow.add(model.getFactory());
					oneRow.add(model.getFax());
					oneRow.add(model.getGst());
					oneRow.add(model.getPinCode());
					oneRow.add(model.getRemarks());
					oneRow.add(model.getOffice());
					oneRow.add(model.getMobile());
					oneRow.add(model.getPager());
					oneRow.add(model.getPan());
					oneRow.add(model.getStd());
					oneRow.add(model.getUrl());
					oneRow.add(model.getVendor());
					oneRow.add(model.getRange());

					tableData.add(oneRow);
				}
				table.setModel(new DefaultTableModel(tableData, tableHeaders));
				session.getTransaction().commit();
				session.close();
				sessionFactory.close();
				
				
				
			}
		});
		
		
		
		//view all menu item button
		mntmSave.setBounds(10, 4, 82, 26);
		frmCustomerDetail.getContentPane().add(mntmSave);
		
		JMenuItem mntmViewalll = new JMenuItem("view all customer");
		mntmViewalll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				
				
				
				
				
				SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
				Session session = sessionFactory.openSession();
				session.beginTransaction();
				// Query query = session.createQuery("from CustomerModel");
				// List<CustomerModel> customer = session.createQuery("from
				// Custom").list();
			 	@SuppressWarnings("unchecked")
				List<CustomerModel> products = session.createQuery("from CustomerModel").list();

				Vector<String> tableHeaders = new Vector<String>();
				Vector tableData = new Vector();
				tableHeaders.add("code");
				tableHeaders.add("name");
				tableHeaders.add("address");
				tableHeaders.add("city");
				tableHeaders.add("contact");
				tableHeaders.add("deliver");
				tableHeaders.add("designation");
				tableHeaders.add("destination");
				tableHeaders.add("div");
				tableHeaders.add("ecc");
				tableHeaders.add("email");
				tableHeaders.add("factory");
				tableHeaders.add("fax");
				tableHeaders.add("gst");
				tableHeaders.add("pincode");
				tableHeaders.add("remarks");
				tableHeaders.add("office");
				tableHeaders.add("mobile");
				tableHeaders.add("pager");
				tableHeaders.add("pan");
				tableHeaders.add("std");
				tableHeaders.add("url");
				tableHeaders.add("vendor");
				tableHeaders.add("range");

				// tableHeaders.add("name");
				for (Object o : products) {
					CustomerModel model = (CustomerModel) o;
					Vector<Object> oneRow = new Vector<Object>();
					oneRow.add(model.getCode());
					oneRow.add(model.getName());
					oneRow.add(model.getAddress());
					oneRow.add(model.getCity());
					oneRow.add(model.getContact());
					oneRow.add(model.getDelivered());
					oneRow.add(model.getDesignation());
					oneRow.add(model.getDestiation());
					oneRow.add(model.getDiv());
					oneRow.add(model.getEcc());
					oneRow.add(model.getEmail());
					oneRow.add(model.getFactory());
					oneRow.add(model.getFax());
					oneRow.add(model.getGst());
					oneRow.add(model.getPinCode());
					oneRow.add(model.getRemarks());
					oneRow.add(model.getOffice());
					oneRow.add(model.getMobile());
					oneRow.add(model.getPager());
					oneRow.add(model.getPan());
					oneRow.add(model.getStd());
					oneRow.add(model.getUrl());
					oneRow.add(model.getVendor());
					oneRow.add(model.getRange());

					tableData.add(oneRow);
				}
				table.setModel(new DefaultTableModel(tableData, tableHeaders));
				session.getTransaction().commit();
				session.flush();
				session.close();
				sessionFactory.close();
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
	
				
				
				
				
				
				
			}
		});
		mntmViewalll.setIcon(new ImageIcon(CustomerForm.class.getResource("/inventory/view all.png")));
		mntmViewalll.setFont(new Font("Arial", Font.BOLD, 14));
		mntmViewalll.setBounds(92, 4, 198, 29);
		frmCustomerDetail.getContentPane().add(mntmViewalll);
		
		JMenuItem mntmUpdate = new JMenuItem("Update");
		mntmUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
				Session session = sessionFactory.openSession();
				session.beginTransaction();
				CustomerModel customerModel = new CustomerModel();
				customerModel.setAddress(address.getText());
				customerModel.setCity(city.getText());
				customerModel.setCode(code1.getText());
				customerModel.setContact(Integer.parseInt(contact.getText()));
				customerModel.setDelivered(deliver.getText());
				customerModel.setDesignation(designation.getText());
				customerModel.setDestiation(destination.getText());
				customerModel.setDiv(div.getText());
				customerModel.setEcc(ecc.getText());
				customerModel.setEmail(email.getText());
				customerModel.setFactory(Integer.parseInt(factory.getText()));
				customerModel.setFax(Integer.parseInt(fax.getText()));
				customerModel.setGst(gst.getText());
				customerModel.setMobile(Integer.parseInt(mobile.getText()));
				customerModel.setName(name.getText());
				customerModel.setOffice(Integer.parseInt(office.getText()));
				customerModel.setPager(Integer.parseInt(pager.getText()));
				customerModel.setPan(pan.getText());
				customerModel.setPinCode(Integer.parseInt(pincode.getText()));
				customerModel.setRange(range.getText());
				customerModel.setRemarks(remarks.getText());
				customerModel.setStd(std.getText());
				customerModel.setUrl(url.getText());
				customerModel.setVendor(vendor.getText());

				session.update(customerModel);
				
				
				session.getTransaction().commit();
				
				@SuppressWarnings("unchecked")
				List<CustomerModel> products = session.createQuery("from CustomerModel").list();

				Vector<String> tableHeaders = new Vector<String>();
				Vector tableData = new Vector();
				tableHeaders.add("code");
				tableHeaders.add("name");
				tableHeaders.add("address");
				tableHeaders.add("city");
				tableHeaders.add("contact");
				tableHeaders.add("deliver");
				tableHeaders.add("designation");
				tableHeaders.add("destination");
				tableHeaders.add("div");
				tableHeaders.add("ecc");
				tableHeaders.add("email");
				tableHeaders.add("factory");
				tableHeaders.add("fax");
				tableHeaders.add("gst");
				tableHeaders.add("pincode");
				tableHeaders.add("remarks");
				tableHeaders.add("office");
				tableHeaders.add("mobile");
				tableHeaders.add("pager");
				tableHeaders.add("pan");
				tableHeaders.add("std");
				tableHeaders.add("url");
				tableHeaders.add("vendor");
				tableHeaders.add("range");

				// tableHeaders.add("name");
				for (Object o : products) {
					CustomerModel model = (CustomerModel) o;
					Vector<Object> oneRow = new Vector<Object>();
					oneRow.add(model.getCode());
					oneRow.add(model.getName());
					oneRow.add(model.getAddress());
					oneRow.add(model.getCity());
					oneRow.add(model.getContact());
					oneRow.add(model.getDelivered());
					oneRow.add(model.getDesignation());
					oneRow.add(model.getDestiation());
					oneRow.add(model.getDiv());
					oneRow.add(model.getEcc());
					oneRow.add(model.getEmail());
					oneRow.add(model.getFactory());
					oneRow.add(model.getFax());
					oneRow.add(model.getGst());
					oneRow.add(model.getPinCode());
					oneRow.add(model.getRemarks());
					oneRow.add(model.getOffice());
					oneRow.add(model.getMobile());
					oneRow.add(model.getPager());
					oneRow.add(model.getPan());
					oneRow.add(model.getStd());
					oneRow.add(model.getUrl());
					oneRow.add(model.getVendor());
					oneRow.add(model.getRange());

					tableData.add(oneRow);
				}
				table.setModel(new DefaultTableModel(tableData, tableHeaders));
				JOptionPane.showMessageDialog(null, "updated");
				// it will close the particular session after completing the
				// process
				session.flush();
				session.close();
				sessionFactory.close();
				
				
			}
		});
		mntmUpdate.setIcon(new ImageIcon(CustomerForm.class.getResource("/inventory/update.png")));
		mntmUpdate.setFont(new Font("Arial", Font.BOLD, 14));
		mntmUpdate.setBounds(290, 4, 129, 29);
		frmCustomerDetail.getContentPane().add(mntmUpdate);
		
		JMenuItem mntmDelete = new JMenuItem("Delete");
		mntmDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
				Session session = sessionFactory.openSession();
				session.beginTransaction();
				
				
				
				CustomerModel customerModel = new CustomerModel();
				customerModel.setCode(code1.getText());
				session.delete(customerModel);
				session.getTransaction().commit();
				@SuppressWarnings("unchecked")
				List<CustomerModel> products = session.createQuery("from CustomerModel").list();

				Vector<String> tableHeaders = new Vector<String>();
				Vector tableData = new Vector();
				tableHeaders.add("code");
				tableHeaders.add("name");
				tableHeaders.add("address");
				tableHeaders.add("city");
				tableHeaders.add("contact");
				tableHeaders.add("deliver");
				tableHeaders.add("designation");
				tableHeaders.add("destination");
				tableHeaders.add("div");
				tableHeaders.add("ecc");
				tableHeaders.add("email");
				tableHeaders.add("factory");
				tableHeaders.add("fax");
				tableHeaders.add("gst");
				tableHeaders.add("pincode");
				tableHeaders.add("remarks");
				tableHeaders.add("office");
				tableHeaders.add("mobile");
				tableHeaders.add("pager");
				tableHeaders.add("pan");
				tableHeaders.add("std");
				tableHeaders.add("url");
				tableHeaders.add("vendor");
				tableHeaders.add("range");

				// tableHeaders.add("name");
				for (Object o : products) {
					CustomerModel model = (CustomerModel) o;
					Vector<Object> oneRow = new Vector<Object>();
					oneRow.add(model.getCode());
					oneRow.add(model.getName());
					oneRow.add(model.getAddress());
					oneRow.add(model.getCity());
					oneRow.add(model.getContact());
					oneRow.add(model.getDelivered());
					oneRow.add(model.getDesignation());
					oneRow.add(model.getDestiation());
					oneRow.add(model.getDiv());
					oneRow.add(model.getEcc());
					oneRow.add(model.getEmail());
					oneRow.add(model.getFactory());
					oneRow.add(model.getFax());
					oneRow.add(model.getGst());
					oneRow.add(model.getPinCode());
					oneRow.add(model.getRemarks());
					oneRow.add(model.getOffice());
					oneRow.add(model.getMobile());
					oneRow.add(model.getPager());
					oneRow.add(model.getPan());
					oneRow.add(model.getStd());
					oneRow.add(model.getUrl());
					oneRow.add(model.getVendor());
					oneRow.add(model.getRange());

					tableData.add(oneRow);
				}
				table.setModel(new DefaultTableModel(tableData, tableHeaders));
				session.close();
				sessionFactory.close();
				
			}
		});
		mntmDelete.setIcon(new ImageIcon(CustomerForm.class.getResource("/inventory/delete.png")));
		mntmDelete.setFont(new Font("Arial", Font.BOLD, 14));
		mntmDelete.setBounds(413, 6, 129, 29);
		frmCustomerDetail.getContentPane().add(mntmDelete);
		
		JButton btnNewButton_2 = new JButton("New button");
		btnNewButton_2.setIcon(new ImageIcon(CustomerForm.class.getResource("/inventory/viw.png")));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				
				
				
				
				
table.getSelectedRow();
	
				
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				int index = table.getSelectedRow();
				
				
				
				
				
				
				
				

				// populating selected row to textbox
				//display customer data's to tables
				
				
				code1.setText(model.getValueAt(index, 0).toString());
				name.setText(model.getValueAt(index, 1).toString());
				address.setText(model.getValueAt(index, 2).toString());
				city.setText(model.getValueAt(index, 3).toString());
				contact.setText(model.getValueAt(index, 4).toString());
				deliver.setText(model.getValueAt(index, 5).toString());
				designation.setText(model.getValueAt(index, 6).toString());
				destination.setText(model.getValueAt(index, 7).toString());
				div.setText(model.getValueAt(index, 8).toString());
				ecc.setText(model.getValueAt(index, 9).toString());
				email.setText(model.getValueAt(index, 10).toString());
				factory.setText(model.getValueAt(index, 11).toString());
				fax.setText(model.getValueAt(index, 12).toString());
				gst.setText(model.getValueAt(index, 13).toString());
				pincode.setText(model.getValueAt(index, 14).toString());
				remarks.setText(model.getValueAt(index, 15).toString());
				office.setText(model.getValueAt(index, 16).toString());
				mobile.setText(model.getValueAt(index, 17).toString());
				pager.setText(model.getValueAt(index, 18).toString());
				pan.setText(model.getValueAt(index, 19).toString());
				std.setText(model.getValueAt(index, 20).toString());
				url.setText(model.getValueAt(index, 21).toString());
				vendor.setText(model.getValueAt(index, 22).toString());
				range.setText(model.getValueAt(index, 23).toString());
					
				
							
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
			}
		});
		btnNewButton_2.setBounds(894, 655, 27, 53);
		frmCustomerDetail.getContentPane().add(btnNewButton_2);
		
		JSeparator separator_6 = new JSeparator();
		separator_6.setBounds(10, 30, 617, -5);
		frmCustomerDetail.getContentPane().add(separator_6);
		
		JSeparator separator_7 = new JSeparator();
		separator_7.setBounds(10, 30, 204, 0);
		frmCustomerDetail.getContentPane().add(separator_7);
		
		JSeparator separator_8 = new JSeparator();
		separator_8.setBounds(10, 30, 756, 0);
		frmCustomerDetail.getContentPane().add(separator_8);
		
		JSeparator separator_9 = new JSeparator();
		separator_9.setBounds(10, 37, 911, 2);
		frmCustomerDetail.getContentPane().add(separator_9);
		
		JLabel error1 = new JLabel("");
		error1.setForeground(Color.RED);
		error1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		error1.setBounds(343, 269, 458, 20);
		frmCustomerDetail.getContentPane().add(error1);
		
		JLabel label = new JLabel("");
		label.setForeground(Color.RED);
		label.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label.setBounds(603, 374, 289, 20);
		frmCustomerDetail.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setForeground(Color.RED);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_1.setBounds(632, 576, 258, 20);
		frmCustomerDetail.getContentPane().add(label_1);
	}
}
