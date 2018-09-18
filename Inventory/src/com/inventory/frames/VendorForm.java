package com.inventory.frames;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.inventory.model.CustomerModel;
import com.inventory.model.VendorModel;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JSeparator;
import javax.swing.JMenuItem;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class VendorForm extends JFrame {

	private JPanel contentPane;
	private JTextField vcode;
	private JTextField vname;
	private JTextField vcity;
	private JTextField vpincode;
	private JTextField vcontacts;
	private JTextField vdes;
	private JTextField voffice;
	private JTextField vfax;
	private JTextField vfactory;
	private JTextField vmobile;
	private JTextField vpager;
	private JTextField vemail;
	private JTextField vesi;
	private JTextField vurl;
	private JTextField vecc;
	// private JTable table;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VendorForm frame = new VendorForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VendorForm() {
		setTitle("Vendor Master");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 939, 847);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBounds(10, 0, 984, 733);
		contentPane.add(panel);

		JLabel label = new JLabel("Code");
		label.setFont(new Font("Times New Roman", Font.BOLD, 16));
		label.setBounds(10, 79, 35, 19);
		panel.add(label);

		JLabel label_1 = new JLabel("Name");
		label_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		label_1.setBounds(10, 120, 40, 19);
		panel.add(label_1);

		vcode = new JTextField();
		vcode.setFont(new Font("Monospaced", Font.PLAIN, 16));
		vcode.setColumns(10);
		vcode.setBounds(101, 72, 86, 28);
		panel.add(vcode);

		vname = new JTextField();
		vname.setFont(new Font("Monospaced", Font.PLAIN, 16));
		vname.setColumns(10);
		vname.setBounds(99, 117, 259, 28);
		panel.add(vname);

		JLabel label_2 = new JLabel("Address");
		label_2.setFont(new Font("Times New Roman", Font.BOLD, 16));
		label_2.setBounds(10, 165, 55, 19);
		panel.add(label_2);

		JLabel label_3 = new JLabel("City");
		label_3.setFont(new Font("Times New Roman", Font.BOLD, 16));
		label_3.setBounds(17, 244, 28, 19);
		panel.add(label_3);

		JLabel label_4 = new JLabel("PinCode");
		label_4.setFont(new Font("Times New Roman", Font.BOLD, 16));
		label_4.setBounds(404, 244, 56, 19);
		panel.add(label_4);

		JLabel label_5 = new JLabel("Contact");
		label_5.setFont(new Font("Times New Roman", Font.BOLD, 16));
		label_5.setBounds(13, 286, 52, 19);
		panel.add(label_5);

		JLabel label_6 = new JLabel("Designation");
		label_6.setFont(new Font("Times New Roman", Font.BOLD, 16));
		label_6.setBounds(398, 286, 80, 19);
		panel.add(label_6);

		JTextArea vadress = new JTextArea();
		vadress.setLineWrap(true);
		vadress.setFont(new Font("Monospaced", Font.PLAIN, 16));
		vadress.setBounds(99, 164, 259, 53);
		panel.add(vadress);

		vcity = new JTextField();
		vcity.setFont(new Font("Monospaced", Font.PLAIN, 16));
		vcity.setColumns(10);
		vcity.setBounds(101, 245, 246, 28);
		panel.add(vcity);

		vpincode = new JTextField();
		vpincode.setFont(new Font("Monospaced", Font.PLAIN, 16));
		vpincode.setColumns(10);
		vpincode.setBounds(506, 245, 246, 28);
		panel.add(vpincode);

		vcontacts = new JTextField();
		vcontacts.setFont(new Font("Monospaced", Font.PLAIN, 16));
		vcontacts.setColumns(10);
		vcontacts.setBounds(101, 281, 246, 28);
		panel.add(vcontacts);

		vdes = new JTextField();
		vdes.setFont(new Font("Monospaced", Font.PLAIN, 16));
		vdes.setColumns(10);
		vdes.setBounds(517, 281, 246, 28);
		panel.add(vdes);

		JSeparator separator = new JSeparator();
		separator.setBounds(486, 126, 1, 263);
		panel.add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(425, 170, 1, 170);
		panel.add(separator_1);

		JLabel label_7 = new JLabel("");
		label_7.setBounds(72, 11, 46, 14);
		panel.add(label_7);

		JLabel label_8 = new JLabel("Remarks");
		label_8.setFont(new Font("Times New Roman", Font.BOLD, 16));
		label_8.setBounds(446, 52, 86, 19);
		panel.add(label_8);

		JTextArea vremarrks = new JTextArea();
		vremarrks.setLineWrap(true);
		vremarrks.setFont(new Font("Monospaced", Font.PLAIN, 16));
		vremarrks.setBounds(473, 82, 391, 152);
		panel.add(vremarrks);

		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(398, 93, 1, 263);
		panel.add(separator_2);

		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(425, 93, 1, 254);
		panel.add(separator_3);

		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(10, 338, 856, 2);
		panel.add(separator_4);

		voffice = new JTextField();
		voffice.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		voffice.setColumns(10);
		voffice.setBounds(99, 361, 197, 28);
		panel.add(voffice);

		vfax = new JTextField();
		vfax.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		vfax.setColumns(10);
		vfax.setBounds(367, 356, 197, 28);
		panel.add(vfax);

		JLabel label_9 = new JLabel("Factory");
		label_9.setFont(new Font("Times New Roman", Font.BOLD, 16));
		label_9.setBounds(596, 365, 51, 19);
		panel.add(label_9);

		vfactory = new JTextField();
		vfactory.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		vfactory.setColumns(10);
		vfactory.setBounds(677, 361, 154, 28);
		panel.add(vfactory);

		JLabel label_10 = new JLabel("Mobile");
		label_10.setFont(new Font("Times New Roman", Font.BOLD, 16));
		label_10.setBounds(17, 400, 48, 19);
		panel.add(label_10);

		vmobile = new JTextField();
		vmobile.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		vmobile.setColumns(10);
		vmobile.setBounds(101, 396, 197, 28);
		panel.add(vmobile);

		JLabel label_11 = new JLabel("Fax");
		label_11.setFont(new Font("Times New Roman", Font.BOLD, 16));
		label_11.setBounds(316, 365, 41, 19);
		panel.add(label_11);

		JLabel label_12 = new JLabel("Pager");
		label_12.setFont(new Font("Times New Roman", Font.BOLD, 16));
		label_12.setBounds(310, 400, 48, 19);
		panel.add(label_12);

		vpager = new JTextField();
		vpager.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		vpager.setColumns(10);
		vpager.setBounds(367, 396, 197, 28);
		panel.add(vpager);

		JSeparator separator_5 = new JSeparator();
		separator_5.setBounds(10, 430, 856, 14);
		panel.add(separator_5);

		vemail = new JTextField();
		vemail.setFont(new Font("Monospaced", Font.PLAIN, 16));
		vemail.setColumns(10);
		vemail.setBounds(101, 447, 303, 28);
		panel.add(vemail);

		vesi = new JTextField();
		vesi.setFont(new Font("Monospaced", Font.PLAIN, 16));
		vesi.setColumns(10);
		vesi.setBounds(99, 480, 197, 28);
		panel.add(vesi);

		vurl = new JTextField();
		vurl.setFont(new Font("Monospaced", Font.PLAIN, 16));
		vurl.setColumns(10);
		vurl.setBounds(495, 447, 369, 28);
		panel.add(vurl);

		vecc = new JTextField();
		vecc.setFont(new Font("Monospaced", Font.PLAIN, 16));
		vecc.setColumns(10);
		vecc.setBounds(434, 486, 213, 28);
		panel.add(vecc);

		JLabel label_13 = new JLabel("Email");
		label_13.setFont(new Font("Times New Roman", Font.BOLD, 16));
		label_13.setBounds(20, 452, 48, 19);
		panel.add(label_13);

		JLabel label_14 = new JLabel("ESI code");
		label_14.setFont(new Font("Times New Roman", Font.BOLD, 16));
		label_14.setBounds(15, 485, 67, 19);
		panel.add(label_14);

		JLabel label_15 = new JLabel("URL");
		label_15.setFont(new Font("Times New Roman", Font.BOLD, 16));
		label_15.setBounds(412, 455, 48, 19);
		panel.add(label_15);

		JLabel label_16 = new JLabel("ECC code");
		label_16.setFont(new Font("Times New Roman", Font.BOLD, 16));
		label_16.setBounds(345, 485, 67, 19);
		panel.add(label_16);

		JMenuItem menuItem = new JMenuItem("view all Vendors");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
				Session session = sessionFactory.openSession();
				// session.beginTransaction();
				// Query query = session.createQuery("from CustomerModel");
				// List<CustomerModel> customer = session.createQuery("from
				// Custom").list();
				@SuppressWarnings("unchecked")
				List<VendorModel> products = session.createQuery("from VendorModel").list();

				Vector<String> tableHeaders = new Vector<String>();
				Vector tableData = new Vector();
				tableHeaders.add("code");
				tableHeaders.add("name");
				tableHeaders.add("address");
				tableHeaders.add("city");
				tableHeaders.add("contact");
				// tableHeaders.add("deliver");
				tableHeaders.add("designation");
				// tableHeaders.add("destination");
				tableHeaders.add("esi");
				tableHeaders.add("ecc");
				tableHeaders.add("email");
				tableHeaders.add("factory");
				tableHeaders.add("fax");
				// tableHeaders.add("gst");
				tableHeaders.add("pincode");
				tableHeaders.add("remarks");
				tableHeaders.add("office");
				tableHeaders.add("mobile");
				tableHeaders.add("pager");
				// tableHeaders.add("pan");
				// tableHeaders.add("std");
				tableHeaders.add("url");
				// tableHeaders.add("vendor");
				// tableHeaders.add("range");

				// tableHeaders.add("name");
				for (Object o : products) {
					VendorModel model = (VendorModel) o;
					Vector<Object> oneRow = new Vector<Object>();
					oneRow.add(model.getCode());
					oneRow.add(model.getName());
					oneRow.add(model.getAddress());
					oneRow.add(model.getCity());
					oneRow.add(model.getContact());
					// oneRow.add(model.getDelivered());
					oneRow.add(model.getDesignation());
					// oneRow.add(model.getDestiation());
					oneRow.add(model.getEci());
					oneRow.add(model.getEcc());
					oneRow.add(model.getEmail());
					oneRow.add(model.getFactory());
					oneRow.add(model.getFax());
					// oneRow.add(model.getGst());
					oneRow.add(model.getPinCode());
					oneRow.add(model.getRemarks());
					oneRow.add(model.getOffice());
					oneRow.add(model.getMobile());
					oneRow.add(model.getPager());
					// oneRow.add(model.getPan());
					// oneRow.add(model.getStd());
					oneRow.add(model.getUrl());
					// oneRow.add(model.getVendor());
					// oneRow.add(model.getRange());

					tableData.add(oneRow);
				}
				table_1.setModel(new DefaultTableModel(tableData, tableHeaders));
				// session.getTransaction().commit();
				session.flush();
				session.close();
				sessionFactory.close();

			}
		});
		menuItem.setIcon(new ImageIcon(VendorForm.class.getResource("/inventory/view all.png")));
		menuItem.setFont(new Font("Arial", Font.BOLD, 14));
		menuItem.setBounds(82, 11, 198, 29);
		panel.add(menuItem);

		JMenuItem menuItem_1 = new JMenuItem("save");
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
				Session session = sessionFactory.openSession();
				session.beginTransaction();
				VendorModel vendorModel = new VendorModel();
				vendorModel.setAddress(vadress.getText());
				vendorModel.setCity(vcity.getText());
				vendorModel.setCode(vcode.getText());
				vendorModel.setContact(Integer.parseInt(vcontacts.getText()));

				vendorModel.setDesignation(vdes.getText());

				vendorModel.setEcc(vecc.getText());
				vendorModel.setEmail(vemail.getText());
				vendorModel.setFactory(Integer.parseInt(vfactory.getText()));
				vendorModel.setFax(Integer.parseInt(vfax.getText()));

				vendorModel.setMobile(Integer.parseInt(vmobile.getText()));
				vendorModel.setName(vname.getText());
				vendorModel.setOffice(Integer.parseInt(voffice.getText()));
				vendorModel.setPager(Integer.parseInt(vpager.getText()));

				vendorModel.setPinCode(Integer.parseInt(vpincode.getText()));
				// customerModel.setRange(vrange.getText());
				vendorModel.setRemarks(vremarrks.getText());
				// customerModel.setStd(std.getText());
				vendorModel.setUrl(vurl.getText());
				vendorModel.setEci(vesi.getText());
				// customerModel.setVendor(vendor.getText());
				// customerModel.setEsi()
				/*
				 * if(address.getText().length()==0) {
				 * 
				 * 
				 * JOptionPane.showMessageDialog(null, "valuue"); }
				 * JOptionPane.showMessageDialog(null, "saved");
				 */
				session.save(vendorModel);

				@SuppressWarnings("unchecked")
				List<VendorModel> products = session.createQuery("from VendorModel").list();

				Vector<String> tableHeaders = new Vector<String>();
				Vector tableData = new Vector();
				tableHeaders.add("code");
				tableHeaders.add("name");
				tableHeaders.add("address");
				tableHeaders.add("city");
				tableHeaders.add("contact");

				tableHeaders.add("designation");

				tableHeaders.add("esi code");
				tableHeaders.add("ecc");
				tableHeaders.add("email");
				tableHeaders.add("factory");
				tableHeaders.add("fax");
				// tableHeaders.add("gst");
				tableHeaders.add("pincode");
				tableHeaders.add("remarks");
				tableHeaders.add("office");
				tableHeaders.add("mobile");
				tableHeaders.add("pager");
				// tableHeaders.add("pan");
				// tableHeaders.add("std");
				tableHeaders.add("url");
				// tableHeaders.add("vendor");
				// tableHeaders.add("range");

				// tableHeaders.add("name");
				for (Object o : products) {
					VendorModel model = (VendorModel) o;
					Vector<Object> oneRow = new Vector<Object>();
					oneRow.add(model.getCode());
					oneRow.add(model.getName());
					oneRow.add(model.getAddress());
					oneRow.add(model.getCity());
					oneRow.add(model.getContact());
					// oneRow.add(model.getDelivered());
					oneRow.add(model.getDesignation());
					oneRow.add(model.getEci());
					// oneRow.add(model.getDiv());
					oneRow.add(model.getEcc());
					oneRow.add(model.getEmail());
					oneRow.add(model.getFactory());
					oneRow.add(model.getFax());
					// oneRow.add(model.getGst());
					oneRow.add(model.getPinCode());
					oneRow.add(model.getRemarks());
					oneRow.add(model.getOffice());
					oneRow.add(model.getMobile());
					oneRow.add(model.getPager());
					// oneRow.add(model.getPan());
					// oneRow.add(model.getStd());
					oneRow.add(model.getUrl());
					// oneRow.add(model.getVendor());
					// oneRow.add(model.getRange());

					tableData.add(oneRow);
				}
				table_1.setModel(new DefaultTableModel(tableData, tableHeaders));
				session.getTransaction().commit();
				session.close();
				sessionFactory.close();

			}
		});
		menuItem_1.setIcon(new ImageIcon(VendorForm.class.getResource("/inventory/save.png")));
		menuItem_1.setFont(new Font("Arial", Font.BOLD, 14));
		menuItem_1.setBounds(0, 11, 82, 26);
		panel.add(menuItem_1);

		JMenuItem menuItem_2 = new JMenuItem("Update");
		menuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
				Session session = sessionFactory.openSession();
				session.beginTransaction();
				VendorModel vendorModel = new VendorModel();
				vendorModel.setAddress(vadress.getText());
				vendorModel.setCity(vcity.getText());
				vendorModel.setCode(vcode.getText());
				vendorModel.setContact(Integer.parseInt(vcontacts.getText()));

				vendorModel.setDesignation(vdes.getText());

				vendorModel.setEcc(vecc.getText());
				vendorModel.setEmail(vemail.getText());
				vendorModel.setFactory(Integer.parseInt(vfactory.getText()));
				vendorModel.setFax(Integer.parseInt(vfax.getText()));

				vendorModel.setMobile(Integer.parseInt(vmobile.getText()));
				vendorModel.setName(vname.getText());
				vendorModel.setOffice(Integer.parseInt(voffice.getText()));
				vendorModel.setPager(Integer.parseInt(vpager.getText()));

				vendorModel.setPinCode(Integer.parseInt(vpincode.getText()));
				// customerModel.setRange(vrange.getText());
				vendorModel.setRemarks(vremarrks.getText());
				// customerModel.setStd(std.getText());
				vendorModel.setUrl(vurl.getText());
				vendorModel.setEci(vesi.getText());
				// customerModel.setVendor(vendor.getText());
				// customerModel.setEsi()
				/*
				 * if(address.getText().length()==0) {
				 * 
				 * 
				 * JOptionPane.showMessageDialog(null, "valuue"); }
				 * JOptionPane.showMessageDialog(null, "saved");
				 */
				session.update(vendorModel);

				@SuppressWarnings("unchecked")
				List<VendorModel> products = session.createQuery("from VendorModel").list();

				Vector<String> tableHeaders = new Vector<String>();
				Vector tableData = new Vector();
				tableHeaders.add("code");
				tableHeaders.add("name");
				tableHeaders.add("address");
				tableHeaders.add("city");
				tableHeaders.add("contact");

				tableHeaders.add("designation");

				tableHeaders.add("esi code");
				tableHeaders.add("ecc");
				tableHeaders.add("email");
				tableHeaders.add("factory");
				tableHeaders.add("fax");
				// tableHeaders.add("gst");
				tableHeaders.add("pincode");
				tableHeaders.add("remarks");
				tableHeaders.add("office");
				tableHeaders.add("mobile");
				tableHeaders.add("pager");
				// tableHeaders.add("pan");
				// tableHeaders.add("std");
				tableHeaders.add("url");
				// tableHeaders.add("vendor");
				// tableHeaders.add("range");

				// tableHeaders.add("name");
				for (Object o : products) {
					VendorModel model = (VendorModel) o;
					Vector<Object> oneRow = new Vector<Object>();
					oneRow.add(model.getCode());
					oneRow.add(model.getName());
					oneRow.add(model.getAddress());
					oneRow.add(model.getCity());
					oneRow.add(model.getContact());

					oneRow.add(model.getDesignation());
					oneRow.add(model.getEci());
					// oneRow.add(model.getDiv());
					oneRow.add(model.getEcc());
					oneRow.add(model.getEmail());
					oneRow.add(model.getFactory());
					oneRow.add(model.getFax());
					// oneRow.add(model.getGst());
					oneRow.add(model.getPinCode());
					oneRow.add(model.getRemarks());
					oneRow.add(model.getOffice());
					oneRow.add(model.getMobile());
					oneRow.add(model.getPager());
					// oneRow.add(model.getPan());
					// oneRow.add(model.getStd());
					oneRow.add(model.getUrl());
					// oneRow.add(model.getVendor());
					// oneRow.add(model.getRange());

					tableData.add(oneRow);
				}
				table_1.setModel(new DefaultTableModel(tableData, tableHeaders));
				session.getTransaction().commit();
				session.close();
				sessionFactory.close();

			}
		});
		menuItem_2.setIcon(new ImageIcon(VendorForm.class.getResource("/inventory/update.png")));
		menuItem_2.setFont(new Font("Arial", Font.BOLD, 14));
		menuItem_2.setBounds(280, 11, 129, 29);
		panel.add(menuItem_2);

		JMenuItem menuItem_3 = new JMenuItem("Delete");
		menuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
				Session session = sessionFactory.openSession();
				session.beginTransaction();

				VendorModel vendorModel = new VendorModel();
				vendorModel.setCode(vcode.getText());
				session.delete(vendorModel);
				session.getTransaction().commit();
				@SuppressWarnings("unchecked")
				List<VendorModel> products = session.createQuery("from VendorModel").list();

				Vector<String> tableHeaders = new Vector<String>();
				Vector tableData = new Vector();
				tableHeaders.add("code");
				tableHeaders.add("name");
				tableHeaders.add("address");
				tableHeaders.add("city");
				tableHeaders.add("contact");

				tableHeaders.add("designation");

				tableHeaders.add("esi code");
				tableHeaders.add("ecc");
				tableHeaders.add("email");
				tableHeaders.add("factory");
				tableHeaders.add("fax");
				// tableHeaders.add("gst");
				tableHeaders.add("pincode");
				tableHeaders.add("remarks");
				tableHeaders.add("office");
				tableHeaders.add("mobile");
				tableHeaders.add("pager");
				// tableHeaders.add("pan");
				// tableHeaders.add("std");
				tableHeaders.add("url");
				// tableHeaders.add("vendor");
				// tableHeaders.add("range");

				// tableHeaders.add("name");
				for (Object o : products) {
					VendorModel model = (VendorModel) o;
					Vector<Object> oneRow = new Vector<Object>();
					oneRow.add(model.getCode());
					oneRow.add(model.getName());
					oneRow.add(model.getAddress());
					oneRow.add(model.getCity());
					oneRow.add(model.getContact());
					// oneRow.add(model.getDelivered());
					oneRow.add(model.getDesignation());
					oneRow.add(model.getEci());
					// oneRow.add(model.getDiv());
					oneRow.add(model.getEcc());
					oneRow.add(model.getEmail());
					oneRow.add(model.getFactory());
					oneRow.add(model.getFax());
					// oneRow.add(model.getGst());
					oneRow.add(model.getPinCode());
					oneRow.add(model.getRemarks());
					oneRow.add(model.getOffice());
					oneRow.add(model.getMobile());
					oneRow.add(model.getPager());
					// oneRow.add(model.getPan());
					// oneRow.add(model.getStd());
					oneRow.add(model.getUrl());
					// oneRow.add(model.getVendor());
					// oneRow.add(model.getRange());

					tableData.add(oneRow);
				}
				table_1.setModel(new DefaultTableModel(tableData, tableHeaders));
				session.getTransaction().commit();
				session.close();
				sessionFactory.close();

			}
		});
		menuItem_3.setIcon(new ImageIcon(VendorForm.class.getResource("/inventory/delete.png")));
		menuItem_3.setFont(new Font("Arial", Font.BOLD, 14));
		menuItem_3.setBounds(403, 13, 129, 29);
		panel.add(menuItem_3);

		JLabel label_17 = new JLabel("Office");
		label_17.setFont(new Font("Times New Roman", Font.BOLD, 16));
		label_17.setBounds(24, 359, 41, 19);
		panel.add(label_17);

		JSeparator separator_6 = new JSeparator();
		separator_6.setBounds(10, 517, 898, 2);
		panel.add(separator_6);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(44, 531, 805, 191);
		panel.add(scrollPane);

		table_1 = new JTable();
		scrollPane.setViewportView(table_1);

		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				DefaultTableModel model = (DefaultTableModel) table_1.getModel();
				int index = table_1.getSelectedRow();

				// populating selected row to textbox
				// display customer data's to tables

				vcode.setText(model.getValueAt(index, 0).toString());
				vname.setText(model.getValueAt(index, 1).toString());
				vadress.setText(model.getValueAt(index, 2).toString());
				vcity.setText(model.getValueAt(index, 3).toString());
				vcontacts.setText(model.getValueAt(index, 4).toString());
				vdes.setText(model.getValueAt(index, 5).toString());
				vesi.setText(model.getValueAt(index, 6).toString());
				vecc.setText(model.getValueAt(index, 7).toString());
				vemail.setText(model.getValueAt(index, 8).toString());
				vfactory.setText(model.getValueAt(index, 9).toString());
				vfax.setText(model.getValueAt(index, 10).toString());
				vpincode.setText(model.getValueAt(index, 11).toString());
				vremarrks.setText(model.getValueAt(index, 12).toString());
				voffice.setText(model.getValueAt(index, 13).toString());
				vmobile.setText(model.getValueAt(index, 14).toString());
				vpager.setText(model.getValueAt(index, 15).toString());
				vurl.setText(model.getValueAt(index, 16).toString());
				// mobile.setText(model.getValueAt(index, 17).toString());

			}
		});
		btnNewButton.setIcon(new ImageIcon(VendorForm.class.getResource("/inventory/viw.png")));
		btnNewButton.setBounds(848, 603, 63, 53);
		panel.add(btnNewButton);
	}
}
