package com.inventory.transaction.purchaseOrder;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.inventory.model.ComponentModel;
import com.inventory.model.CustomerModel;
import com.inventory.model.PORawMaterialModel;
import com.inventory.model.PORawTableModel;
import com.inventory.model.VendorModel;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JMenuItem;
import javax.swing.JButton;
import javax.persistence.Query;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class PoRawMaterial extends JFrame {

	private JPanel contentPane;
	private JTextField pono;
	private JTextField date;
	private JTextField order;
	private JTextField ur_ref;
	private JTextField sins;
	private JTextField deli;
	private JTextField delipoint;
	private JTextField insurance;
	private JTextField pay;
	private JTextField trans;
	private JTable table;
	private JComboBox comboBox;
	/**
	 * Launch the application.
	 */

	String code, des;
	int quantity, unit, urate;
	double amount, igst, cgst, sgst;
	private JTable table_2;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PoRawMaterial frame = new PoRawMaterial();
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

	public PoRawMaterial(String code, String des, int quantity, double amount, int unit, int urate, double igst,
			double cgst, double sgst) {
		this.code = code;
		this.des = des;
		this.quantity = quantity;
		this.amount = amount;
		this.unit = unit;
		this.urate = urate;
		this.igst = igst;
		this.cgst = cgst;
		this.sgst = sgst;

		addData();

	}

	@SuppressWarnings("unchecked")
	void addData() {
		// DefaultTableModel model=(DefaultTableModel) table.getModel();

		Vector<String> tableHeaders = new Vector<String>();
		Vector tableData = new Vector();
		tableHeaders.add("code");
		tableHeaders.add("description");
		tableHeaders.add("quantity");
		tableHeaders.add("unit");
		tableHeaders.add("unitRate");
		tableHeaders.add("amount");
		tableHeaders.add("igst");
		tableHeaders.add("cgst");
		tableHeaders.add("sgst");

		tableHeaders.add("name");

		/*
		 * Vector oneRow = new Vector(); oneRow.add(code); oneRow.add(des);
		 * oneRow.add(quantity); oneRow.add(unit); oneRow.add(urate);
		 * oneRow.add(amount); oneRow.add(igst); oneRow.add(cgst);
		 * oneRow.add(sgst);
		 */

		// tableData.add(oneRow);
		// model.addRow(oneRow);
		table.setModel(new DefaultTableModel(tableData, tableHeaders));
	}

	// DefaultTableModel model=()

	public PoRawMaterial() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {

				SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
				Session session = sessionFactory.openSession();
				session.beginTransaction();
				List<VendorModel> products = session.createQuery(" from VendorModel ").list();
				// System.out.println(customerModel.get());
				DefaultComboBoxModel coModel = (DefaultComboBoxModel) comboBox.getModel();

				for (VendorModel customerModel1 : products) {

					coModel.addElement(customerModel1.getCode());

					comboBox.setModel(coModel);

				}

				PORawMaterialModel model = new PORawMaterialModel();
				pono.setText(String.valueOf(model.getPo_no()));

			}
		});

		// initComponents();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1205, 772);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBounds(-20, 11, 1169, 711);
		contentPane.add(panel);

		JLabel label = new JLabel("Vendor Code");
		label.setFont(new Font("Times New Roman", Font.BOLD, 14));
		label.setBounds(10, 22, 101, 14);
		panel.add(label);
		comboBox = new JComboBox();
		comboBox.setBounds(105, 20, 58, 20);
		panel.add(comboBox);

		JTextArea adrs = new JTextArea();
		adrs.setBounds(10, 65, 303, 87);
		panel.add(adrs);

		JLabel label_1 = new JLabel("P.o.No");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_1.setBounds(432, 20, 46, 17);
		panel.add(label_1);

		pono = new JTextField();
		pono.setColumns(10);
		pono.setBounds(565, 20, 185, 26);
		panel.add(pono);

		JLabel label_2 = new JLabel("Date");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_2.setBounds(432, 65, 46, 14);
		panel.add(label_2);

		date = new JTextField();
		date.setColumns(10);
		date.setBounds(565, 65, 185, 28);
		panel.add(date);

		JLabel label_3 = new JLabel("Order valid upto");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_3.setBounds(419, 109, 100, 15);
		panel.add(label_3);

		order = new JTextField();
		order.setColumns(10);
		order.setBounds(565, 104, 185, 26);
		panel.add(order);

		JLabel label_4 = new JLabel("Your Reference");
		label_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_4.setBounds(419, 137, 100, 15);
		panel.add(label_4);

		ur_ref = new JTextField();
		ur_ref.setColumns(10);
		ur_ref.setBounds(565, 141, 185, 26);
		panel.add(ur_ref);

		JLabel label_5 = new JLabel("special  Instruction");
		label_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_5.setBounds(10, 385, 117, 15);
		panel.add(label_5);

		sins = new JTextField();
		sins.setColumns(10);
		sins.setBounds(139, 379, 589, 28);
		panel.add(sins);

		JLabel label_6 = new JLabel("delivery");
		label_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_6.setBounds(11, 427, 47, 15);
		panel.add(label_6);

		deli = new JTextField();
		deli.setColumns(10);
		deli.setBounds(68, 422, 185, 26);
		panel.add(deli);

		delipoint = new JTextField();
		delipoint.setColumns(10);
		delipoint.setBounds(359, 422, 185, 26);
		panel.add(delipoint);

		insurance = new JTextField();
		insurance.setColumns(10);
		insurance.setBounds(635, 418, 185, 26);
		panel.add(insurance);

		JLabel label_7 = new JLabel("delivery point");
		label_7.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_7.setBounds(263, 425, 84, 15);
		panel.add(label_7);

		JLabel label_8 = new JLabel("Insurance");
		label_8.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_8.setBounds(565, 424, 60, 15);
		panel.add(label_8);

		trans = new JTextField();
		trans.setColumns(10);
		trans.setBounds(923, 422, 165, 26);
		panel.add(trans);

		JLabel label_9 = new JLabel("Transport");
		label_9.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_9.setBounds(826, 425, 65, 18);
		panel.add(label_9);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 183, 982, 185);
		panel.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		pay = new JTextField();
		pay.setBounds(876, 380, 185, 26);
		panel.add(pay);
		pay.setColumns(10);

		JLabel label_10 = new JLabel("payment Term");
		label_10.setBounds(766, 383, 100, 18);
		panel.add(label_10);
		label_10.setFont(new Font("Tahoma", Font.BOLD, 12));

		JMenuItem menuItem_2 = new JMenuItem("Delete");
		menuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
				Session session = sessionFactory.openSession();
				session.beginTransaction();
				// ComponentModel componentModel = new ComponentModel();
				PORawMaterialModel model = new PORawMaterialModel();
				model.setPo_no(Integer.parseInt(pono.getText()));

				// componentModel.setPartCode(comPartCode.getText());
				session.delete(model);
				session.getTransaction().commit();

				session.close();
				sessionFactory.close();

				// to clear

				adrs.setText("");
				date.setText("");
				order.setText("");
				delipoint.setText("");
				deli.setText("");
				insurance.setText("");
				pay.setText("");
				pono.setText("");
				sins.setText("");
				trans.setText("");
				ur_ref.setText("");
				
				
				
				
				
				
				
				
				
				
				
				// to update table
				SessionFactory sessionFactory1 = new Configuration().configure().buildSessionFactory();
				Session session1 = sessionFactory1.openSession();
				session1.beginTransaction();

				@SuppressWarnings("unchecked")
				List<PORawMaterialModel> products = session1.createQuery("from PORawMaterialModel").list();

				Vector<String> tableHeaders = new Vector<String>();
				Vector tableData = new Vector();
				tableHeaders.add("vendorcode");
				tableHeaders.add("vendor_adrs");
				tableHeaders.add("po_no");
				tableHeaders.add("date");
				tableHeaders.add("order_valid");
				tableHeaders.add("ur_ref");
				tableHeaders.add("special_instruction");
				tableHeaders.add("delivery");
				tableHeaders.add("delvery point");
				tableHeaders.add("insurance");
				tableHeaders.add("payment mode");
				tableHeaders.add("transport");

				// tableHeaders.add("name");
				for (Object o : products) {
					PORawMaterialModel model1 = (PORawMaterialModel) o;
					Vector<Object> oneRow = new Vector<Object>();
					oneRow.add(model1.getVenCode());
					oneRow.add(model1.getV_address());
					oneRow.add(model1.getPo_no());
					oneRow.add(model1.getDate());
					oneRow.add(model1.getOrder_valid());
					oneRow.add(model1.getUr_ref());
					oneRow.add(model1.getSpecial_ins());
					oneRow.add(model1.getDeli());
					oneRow.add(model1.getDel_point());
					oneRow.add(model1.getInsurance());
					oneRow.add(model1.getPay_mode());
					oneRow.add(model1.getTrans());

					tableData.add(oneRow);
				}
				table_2.setModel(new DefaultTableModel(tableData, tableHeaders));
				session1.getTransaction().commit();
				session1.close();
				sessionFactory1.close();

			}
		});
		menuItem_2.setIcon(new ImageIcon(PoRawMaterial.class.getResource("/inventory/delete.png")));
		menuItem_2.setBounds(336, 661, 101, 29);
		panel.add(menuItem_2);
		menuItem_2.setFont(new Font("Arial", Font.BOLD, 14));

		JMenuItem menuItem_1 = new JMenuItem("Update");
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
				Session session = sessionFactory.openSession();
				session.beginTransaction();

				PORawMaterialModel model = new PORawMaterialModel();

				model.setVenCode(comboBox.getSelectedItem().toString());
				model.setV_address(adrs.getText());
				model.setDate(new Date(date.getText()));
				model.setOrder_valid(new Date(order.getText()));
				model.setDel_point(delipoint.getText());
				model.setDeli(deli.getText());
				model.setInsurance(insurance.getText());
				model.setPay_mode(pay.getText());
				model.setPo_no(Integer.parseInt(pono.getText()));
				model.setSpecial_ins(sins.getText());
				model.setTrans(trans.getText());
				model.setUr_ref(ur_ref.getText());
				// model.setInsurance(insurance.getText());
				// model.set
				session.update(model);
				session.getTransaction().commit();
				session.close();
				sessionFactory.close();

			
			
			
			
			
				
				SessionFactory sessionFactory1 = new Configuration().configure().buildSessionFactory();
				Session session1 = sessionFactory1.openSession();
				session1.beginTransaction();

				@SuppressWarnings("unchecked")
				List<PORawMaterialModel> products = session1.createQuery("from PORawMaterialModel").list();

				Vector<String> tableHeaders = new Vector<String>();
				Vector tableData = new Vector();
				tableHeaders.add("vendorcode");
				tableHeaders.add("vendor_adrs");
				tableHeaders.add("po_no");
				tableHeaders.add("date");
				tableHeaders.add("order_valid");
				tableHeaders.add("ur_ref");
				tableHeaders.add("special_instruction");
				tableHeaders.add("delivery");
				tableHeaders.add("delvery point");
				tableHeaders.add("insurance");
				tableHeaders.add("payment mode");
				tableHeaders.add("transport");
				
				// tableHeaders.add("name");
				for (Object o : products) {
					PORawMaterialModel model1 = (PORawMaterialModel) o;
					Vector<Object> oneRow = new Vector<Object>();
					oneRow.add(model1.getVenCode());
					oneRow.add(model1.getV_address());
					oneRow.add(model1.getPo_no());
					oneRow.add(model1.getDate());
					oneRow.add(model1.getOrder_valid());
					oneRow.add(model1.getUr_ref());
					oneRow.add(model1.getSpecial_ins());
					oneRow.add(model1.getDeli());
					oneRow.add(model1.getDel_point());
					oneRow.add(model1.getInsurance());
					oneRow.add(model1.getPay_mode());
					oneRow.add(model1.getTrans());
					
					tableData.add(oneRow);
				}
				table_2.setModel(new DefaultTableModel(tableData, tableHeaders));
				session1.getTransaction().commit();
				session1.close();
				sessionFactory1.close();
				
			
			
			
			
			
			
			
			
			
			
			
			}
		});
		menuItem_1.setIcon(new ImageIcon(PoRawMaterial.class.getResource("/inventory/update.png")));
		menuItem_1.setBounds(189, 661, 129, 29);
		panel.add(menuItem_1);
		menuItem_1.setFont(new Font("Arial", Font.BOLD, 14));

		JMenuItem menuItem = new JMenuItem("save");
		menuItem.setIcon(new ImageIcon(PoRawMaterial.class.getResource("/inventory/save.png")));
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
				Session session = sessionFactory.openSession();
				session.beginTransaction();

				PORawMaterialModel model = new PORawMaterialModel();

				model.setVenCode(comboBox.getSelectedItem().toString());
				model.setV_address(adrs.getText());
				model.setDate(new Date(date.getText()));
				model.setOrder_valid(new Date(order.getText()));
				model.setDel_point(delipoint.getText());
				model.setDeli(deli.getText());
				model.setInsurance(insurance.getText());
				model.setPay_mode(pay.getText());
				model.setPo_no(Integer.parseInt(pono.getText()));
				model.setSpecial_ins(sins.getText());
				model.setTrans(trans.getText());
				model.setUr_ref(ur_ref.getText());
				// model.setInsurance(insurance.getText());
				// model.set
				session.save(model);
				session.getTransaction().commit();
				session.close();
				sessionFactory.close();

				SessionFactory sessionFactory1 = new Configuration().configure().buildSessionFactory();
				Session session1 = sessionFactory1.openSession();
				session1.beginTransaction();

				@SuppressWarnings("unchecked")
				List<PORawMaterialModel> products = session1.createQuery("from PORawMaterialModel").list();

				Vector<String> tableHeaders = new Vector<String>();
				Vector tableData = new Vector();
				tableHeaders.add("vendorcode");
				tableHeaders.add("vendor_adrs");
				tableHeaders.add("po_no");
				tableHeaders.add("date");
				tableHeaders.add("order_valid");
				tableHeaders.add("ur_ref");
				tableHeaders.add("special_instruction");
				tableHeaders.add("delivery");
				tableHeaders.add("delvery point");
				tableHeaders.add("insurance");
				tableHeaders.add("payment mode");
				tableHeaders.add("transport");

				// tableHeaders.add("name");
				for (Object o : products) {
					PORawMaterialModel model1 = (PORawMaterialModel) o;
					Vector<Object> oneRow = new Vector<Object>();
					oneRow.add(model1.getVenCode());
					oneRow.add(model1.getV_address());
					oneRow.add(model1.getPo_no());
					oneRow.add(model1.getDate());
					oneRow.add(model1.getOrder_valid());
					oneRow.add(model1.getUr_ref());
					oneRow.add(model1.getSpecial_ins());
					oneRow.add(model1.getDeli());
					oneRow.add(model1.getDel_point());
					oneRow.add(model1.getInsurance());
					oneRow.add(model1.getPay_mode());
					oneRow.add(model1.getTrans());

					tableData.add(oneRow);
				}
				table_2.setModel(new DefaultTableModel(tableData, tableHeaders));
				session1.getTransaction().commit();
				session1.close();
				sessionFactory1.close();

			}
		});
		menuItem.setBounds(76, 664, 82, 26);
		panel.add(menuItem);
		menuItem.setFont(new Font("Arial", Font.BOLD, 14));

		JButton btnNewButton = new JButton("Add");
		btnNewButton.setBounds(999, 225, 81, 35);
		panel.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PORawTable raw = new PORawTable();
				raw.setVisible(true);

			}
		});
		btnNewButton.setIcon(new ImageIcon(PoRawMaterial.class.getResource("/inventory/add.png")));

		JButton btnView = new JButton("View");
		btnView.setBounds(999, 283, 78, 29);
		panel.add(btnView);
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
				Session session = sessionFactory.openSession();
				session.beginTransaction();
				// PORawTableModel model=new PORawTableModel();
				// Query query = session.createQuery("from CustomerModel");
				// List<CustomerModel> customer = session.createQuery("from
				// Custom").list();

				// Query query=session.createQuery(null);

				String pri = comboBox.getSelectedItem().toString();
				@SuppressWarnings("unchecked")
				List<PORawTableModel> products = session
						.createQuery("from PORawTableModel model where model.venCode='ven'").list();
				// query.setParameter("pri", "%" + pri + "%");
				Vector<String> tableHeaders = new Vector<String>();
				Vector tableData = new Vector();

				tableHeaders.add("code");
				tableHeaders.add("description");
				tableHeaders.add("quantity");
				tableHeaders.add("unit");
				tableHeaders.add("unitRate");
				tableHeaders.add("amount");
				tableHeaders.add("igst");
				tableHeaders.add("cgst");
				tableHeaders.add("sgst");

				// tableHeaders.add("name");

				for (Object o : products) {
					PORawTableModel model = (PORawTableModel) o;
					Vector<Object> oneRow = new Vector<Object>();
					oneRow.add(model.getCode());
					oneRow.add(model.getDes());
					oneRow.add(model.getQuantity());
					oneRow.add(model.getUnit());
					oneRow.add(model.getUnitrate());
					oneRow.add(model.getAmount());
					oneRow.add(model.getIgst());
					oneRow.add(model.getCgst());
					oneRow.add(model.getSgst());

					tableData.add(oneRow);
				}
				table.setModel(new DefaultTableModel(tableData, tableHeaders));
				session.getTransaction().commit();
				session.flush();
				session.close();
				sessionFactory.close();

			}
		});
		btnView.setIcon(new ImageIcon(PoRawMaterial.class.getResource("/inventory/viw.png")));

		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(1001, 324, 87, 29);
		panel.add(btnDelete);
		btnDelete.setIcon(new ImageIcon(PoRawMaterial.class.getResource("/inventory/delete.png")));

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 474, 1101, 176);
		panel.add(scrollPane_1);

		table_2 = new JTable();
		scrollPane_1.setViewportView(table_2);

		JButton view = new JButton("View");
		view.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				SessionFactory sessionFactory1 = new Configuration().configure().buildSessionFactory();
				Session session1 = sessionFactory1.openSession();
				session1.beginTransaction();

				@SuppressWarnings("unchecked")
				List<PORawMaterialModel> products = session1.createQuery("from PORawMaterialModel").list();

				Vector<String> tableHeaders = new Vector<String>();
				Vector tableData = new Vector();
				tableHeaders.add("vendorcode");
				tableHeaders.add("vendor_adrs");
				tableHeaders.add("po_no");
				tableHeaders.add("date");
				tableHeaders.add("order_valid");
				tableHeaders.add("ur_ref");
				tableHeaders.add("special_instruction");
				tableHeaders.add("delivery");
				tableHeaders.add("delvery point");
				tableHeaders.add("insurance");
				tableHeaders.add("payment mode");
				tableHeaders.add("transport");

				// tableHeaders.add("name");
				for (Object o : products) {
					PORawMaterialModel model = (PORawMaterialModel) o;
					Vector<Object> oneRow = new Vector<Object>();
					oneRow.add(model.getVenCode());
					oneRow.add(model.getV_address());
					oneRow.add(model.getPo_no());
					oneRow.add(model.getDate());
					oneRow.add(model.getOrder_valid());
					oneRow.add(model.getUr_ref());
					oneRow.add(model.getSpecial_ins());
					oneRow.add(model.getDeli());
					oneRow.add(model.getDel_point());
					oneRow.add(model.getInsurance());
					oneRow.add(model.getPay_mode());
					oneRow.add(model.getTrans());

					tableData.add(oneRow);
				}
				table_2.setModel(new DefaultTableModel(tableData, tableHeaders));
				session1.getTransaction().commit();
				session1.close();
				sessionFactory1.close();

			}
		});
		view.setFont(new Font("Tahoma", Font.BOLD, 14));
		view.setIcon(new ImageIcon(PoRawMaterial.class.getResource("/inventory/view all.png")));
		view.setBounds(447, 667, 89, 23);
		panel.add(view);

		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setIcon(new ImageIcon(PoRawMaterial.class.getResource("/inventory/viw.png")));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				DefaultTableModel model = (DefaultTableModel) table_2.getModel();
				int index = table_2.getSelectedRow();

				comboBox.setSelectedItem(model.getValueAt(index, 0).toString());
				adrs.setText(model.getValueAt(index, 1).toString());
				pono.setText(model.getValueAt(index, 2).toString());

				String str = model.getValueAt(index, 3).toString();
				// String s=from1.getText();
				String from = str.replace('-', '/');
				// model.getValueAt(index, 12)(new Date(newString));
				date.setText(from);
				String str1 = model.getValueAt(index, 4).toString();
				// String s=from1.getText();
				String from12 = str1.replace('-', '/');
				order.setText(from12);

				sins.setText(model.getValueAt(index, 5).toString());
				deli.setText(model.getValueAt(index, 6).toString());
				delipoint.setText(model.getValueAt(index, 7).toString());

				insurance.setText(model.getValueAt(index, 8).toString());
				pay.setText(model.getValueAt(index, 9).toString());

				trans.setText(model.getValueAt(index, 10).toString());

			}
		});
		btnNewButton_1.setBounds(565, 667, 89, 23);
		panel.add(btnNewButton_1);
	}
}
