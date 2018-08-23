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
import java.awt.Color;
import javax.swing.JToggleButton;
import javax.swing.JTextPane;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class Vendor extends JFrame {

	private JPanel contentPane;
	private JTextField vcode;
	private JTextField vname;
	private JTextField vcity;
	private JTextField vpincode;
	private JTextField vcontacts;
	private JTextField vdesignation;
	private JTextField voffice;
	private JTextField vfax;
	private JTextField vfactory;
	private JTextField vmobile;
	private JTextField vpager;
	private JTextField vemail;
	private JTextField vesicode;
	private JTextField vurl;
	private JTextField vecc;
	private JTable table;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vendor frame = new Vendor();
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
	public Vendor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(1000, 9000, 1200, 1500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Code");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel.setBounds(10, 79, 35, 19);
		contentPane.add(lblNewLabel);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblName.setBounds(10, 120, 40, 19);
		contentPane.add(lblName);
		
		vcode = new JTextField();
		vcode.setFont(new Font("Monospaced", Font.PLAIN, 16));
		vcode.setBounds(101, 72, 86, 28);
		contentPane.add(vcode);
		vcode.setColumns(10);
		
		vname = new JTextField();
		vname.setFont(new Font("Monospaced", Font.PLAIN, 16));
		vname.setBounds(99, 117, 259, 28);
		contentPane.add(vname);
		vname.setColumns(10);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblAddress.setBounds(10, 165, 55, 19);
		contentPane.add(lblAddress);
		
		JLabel lblCity = new JLabel("City");
		lblCity.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblCity.setBounds(17, 244, 28, 19);
		contentPane.add(lblCity);
		
		JLabel lblPincode = new JLabel("PinCode");
		lblPincode.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblPincode.setBounds(404, 244, 56, 19);
		contentPane.add(lblPincode);
		
		JLabel lblContact = new JLabel("Contact");
		lblContact.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblContact.setBounds(13, 286, 52, 19);
		contentPane.add(lblContact);
		
		JLabel lblDesignation = new JLabel("Designation");
		lblDesignation.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblDesignation.setBounds(398, 286, 80, 19);
		contentPane.add(lblDesignation);
		
		JTextArea vadress = new JTextArea();
		vadress.setFont(new Font("Monospaced", Font.PLAIN, 16));
		vadress.setLineWrap(true);
		vadress.setBounds(99, 164, 259, 53);
		contentPane.add(vadress);
		
		vcity = new JTextField();
		vcity.setFont(new Font("Monospaced", Font.PLAIN, 16));
		vcity.setBounds(101, 245, 246, 28);
		contentPane.add(vcity);
		vcity.setColumns(10);
		
		vpincode = new JTextField();
		vpincode.setFont(new Font("Monospaced", Font.PLAIN, 16));
		vpincode.setColumns(10);
		vpincode.setBounds(506, 245, 246, 28);
		contentPane.add(vpincode);
		
		vcontacts = new JTextField();
		vcontacts.setFont(new Font("Monospaced", Font.PLAIN, 16));
		vcontacts.setColumns(10);
		vcontacts.setBounds(101, 281, 246, 28);
		contentPane.add(vcontacts);
		
		vdesignation = new JTextField();
		vdesignation.setFont(new Font("Monospaced", Font.PLAIN, 16));
		vdesignation.setColumns(10);
		vdesignation.setBounds(517, 281, 246, 28);
		contentPane.add(vdesignation);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(486, 126, 1, 263);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(425, 170, 1, 170);
		contentPane.add(separator_1);
		
		JLabel label = new JLabel("");
		label.setBounds(72, 11, 46, 14);
		contentPane.add(label);
		
		JLabel lblRemarks = new JLabel("Remarks");
		lblRemarks.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblRemarks.setBounds(446, 52, 86, 19);
		contentPane.add(lblRemarks);
		
		JTextArea vremarks = new JTextArea();
		vremarks.setFont(new Font("Monospaced", Font.PLAIN, 16));
		vremarks.setLineWrap(true);
		vremarks.setBounds(473, 82, 391, 152);
		contentPane.add(vremarks);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(398, 93, 1, 263);
		contentPane.add(separator_3);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(425, 93, 1, 254);
		contentPane.add(separator_2);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(10, 338, 856, 2);
		contentPane.add(separator_4);
		
		voffice = new JTextField();
		voffice.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		voffice.setColumns(10);
		voffice.setBounds(99, 361, 197, 28);
		contentPane.add(voffice);
		
		vfax = new JTextField();
		vfax.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		vfax.setColumns(10);
		vfax.setBounds(367, 356, 197, 28);
		contentPane.add(vfax);
		
		JLabel lblFactory = new JLabel("Factory");
		lblFactory.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblFactory.setBounds(596, 365, 51, 19);
		contentPane.add(lblFactory);
		
		vfactory = new JTextField();
		vfactory.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		vfactory.setColumns(10);
		vfactory.setBounds(677, 361, 154, 28);
		contentPane.add(vfactory);
		
		JLabel lblMobile = new JLabel("Mobile");
		lblMobile.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblMobile.setBounds(17, 400, 48, 19);
		contentPane.add(lblMobile);
		
		vmobile = new JTextField();
		vmobile.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		vmobile.setColumns(10);
		vmobile.setBounds(101, 396, 197, 28);
		contentPane.add(vmobile);
		
		JLabel label_1 = new JLabel("Fax");
		label_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		label_1.setBounds(316, 365, 41, 19);
		contentPane.add(label_1);
		
		JLabel lblPager = new JLabel("Pager");
		lblPager.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblPager.setBounds(310, 400, 48, 19);
		contentPane.add(lblPager);
		
		vpager = new JTextField();
		vpager.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		vpager.setColumns(10);
		vpager.setBounds(367, 396, 197, 28);
		contentPane.add(vpager);
		
		JSeparator separator_5 = new JSeparator();
		separator_5.setBounds(10, 430, 856, 14);
		contentPane.add(separator_5);
		
		vemail = new JTextField();
		vemail.setFont(new Font("Monospaced", Font.PLAIN, 16));
		vemail.setColumns(10);
		vemail.setBounds(101, 447, 303, 28);
		contentPane.add(vemail);
		
		vesicode = new JTextField();
		vesicode.setFont(new Font("Monospaced", Font.PLAIN, 16));
		vesicode.setColumns(10);
		vesicode.setBounds(99, 480, 197, 28);
		contentPane.add(vesicode);
		
		vurl = new JTextField();
		vurl.setFont(new Font("Monospaced", Font.PLAIN, 16));
		vurl.setColumns(10);
		vurl.setBounds(495, 447, 369, 28);
		contentPane.add(vurl);
		
		vecc = new JTextField();
		vecc.setFont(new Font("Monospaced", Font.PLAIN, 16));
		vecc.setColumns(10);
		vecc.setBounds(434, 486, 213, 28);
		contentPane.add(vecc);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblEmail.setBounds(20, 452, 48, 19);
		contentPane.add(lblEmail);
		
		JLabel lblEsiCode = new JLabel("ESI code");
		lblEsiCode.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblEsiCode.setBounds(15, 485, 67, 19);
		contentPane.add(lblEsiCode);
		
		JLabel lblUrl = new JLabel("URL");
		lblUrl.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblUrl.setBounds(412, 455, 48, 19);
		contentPane.add(lblUrl);
		
		JLabel lblEccCode = new JLabel("ECC code");
		lblEccCode.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblEccCode.setBounds(345, 485, 67, 19);
		contentPane.add(lblEccCode);
		
		JMenuItem mntmViewAllVendors = new JMenuItem("view all Vendors");
		mntmViewAllVendors.setIcon(new ImageIcon(Vendor.class.getResource("/inventory/view all.png")));
		mntmViewAllVendors.setFont(new Font("Arial", Font.BOLD, 14));
		mntmViewAllVendors.setBounds(82, 11, 198, 29);
		contentPane.add(mntmViewAllVendors);
		
		
		
		
		//saving value 
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
				
				vendorModel.setDesignation(vdesignation.getText());
				
				vendorModel.setEcc(vecc.getText());
				vendorModel.setEmail(vemail.getText());
				vendorModel.setFactory(Integer.parseInt(vfactory.getText()));
				vendorModel.setFax(Integer.parseInt(vfax.getText()));
				
				vendorModel.setMobile(Integer.parseInt(vmobile.getText()));
				vendorModel.setName(vname.getText());
				vendorModel.setOffice(Integer.parseInt(voffice.getText()));
				vendorModel.setPager(Integer.parseInt(vpager.getText()));
				
				vendorModel.setPinCode(Integer.parseInt(vpincode.getText()));
				//customerModel.setRange(vrange.getText());
				vendorModel.setRemarks(vremarks.getText());
				//customerModel.setStd(std.getText());
				vendorModel.setUrl(vurl.getText());
		vendorModel.setEci(vesicode.getText());
				//customerModel.setVendor(vendor.getText());
				//customerModel.setEsi()	
				/*if(address.getText().length()==0)
				{
						
				
				JOptionPane.showMessageDialog(null, "valuue");
				}
				JOptionPane.showMessageDialog(null, "saved");*/
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
				//tableHeaders.add("gst");
				tableHeaders.add("pincode");
				tableHeaders.add("remarks");
				tableHeaders.add("office");
				tableHeaders.add("mobile");
				tableHeaders.add("pager");
				//tableHeaders.add("pan");
				//tableHeaders.add("std");
				tableHeaders.add("url");
				//tableHeaders.add("vendor");
				//tableHeaders.add("range");

				// tableHeaders.add("name");
				for (Object o : products) {
					VendorModel model = (VendorModel) o;
					Vector<Object> oneRow = new Vector<Object>();
					oneRow.add(model.getCode());
					oneRow.add(model.getName());
					oneRow.add(model.getAddress());
					oneRow.add(model.getCity());
					oneRow.add(model.getContact());
					//oneRow.add(model.getDelivered());
					oneRow.add(model.getDesignation());
					oneRow.add(model.getEci());
					//oneRow.add(model.getDiv());
					oneRow.add(model.getEcc());
					oneRow.add(model.getEmail());
					oneRow.add(model.getFactory());
					oneRow.add(model.getFax());
					//oneRow.add(model.getGst());
					oneRow.add(model.getPinCode());
					oneRow.add(model.getRemarks());
					oneRow.add(model.getOffice());
					oneRow.add(model.getMobile());
					oneRow.add(model.getPager());
					//oneRow.add(model.getPan());
					//oneRow.add(model.getStd());
					oneRow.add(model.getUrl());
					//oneRow.add(model.getVendor());
					//oneRow.add(model.getRange());

					tableData.add(oneRow);
				}
				table.setModel(new DefaultTableModel(tableData, tableHeaders));
				session.getTransaction().commit();
				session.close();
				sessionFactory.close();
				
				
				
				
				
				
				
				
			}
		});
		menuItem_1.setIcon(new ImageIcon(Vendor.class.getResource("/inventory/save.png")));
		menuItem_1.setFont(new Font("Arial", Font.BOLD, 14));
		menuItem_1.setBounds(0, 11, 82, 26);
		contentPane.add(menuItem_1);
		
		JMenuItem menuItem_2 = new JMenuItem("Update");
		menuItem_2.setIcon(new ImageIcon(Vendor.class.getResource("/inventory/update.png")));
		menuItem_2.setFont(new Font("Arial", Font.BOLD, 14));
		menuItem_2.setBounds(280, 11, 129, 29);
		contentPane.add(menuItem_2);
		
		JMenuItem menuItem_3 = new JMenuItem("Delete");
		menuItem_3.setIcon(new ImageIcon(Vendor.class.getResource("/inventory/delete.png")));
		menuItem_3.setFont(new Font("Arial", Font.BOLD, 14));
		menuItem_3.setBounds(403, 13, 129, 29);
		contentPane.add(menuItem_3);
		
		table = new JTable();
		table.setBounds(316, 659, -117, 63);
		contentPane.add(table);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(17, 519, 844, 190);
		contentPane.add(scrollPane);
		
		table_1 = new JTable();
		scrollPane.setViewportView(table_1);
		
		JLabel label_2 = new JLabel("Office");
		label_2.setFont(new Font("Times New Roman", Font.BOLD, 16));
		label_2.setBounds(24, 359, 41, 19);
		contentPane.add(label_2);
		
		JSeparator separator_6 = new JSeparator();
		separator_6.setBounds(10, 517, 898, 2);
		contentPane.add(separator_6);
	}
}
