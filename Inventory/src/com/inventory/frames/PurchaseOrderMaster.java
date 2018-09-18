package com.inventory.frames;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.inventory.model.ComponentModel;
import com.inventory.model.CustomerModel;
import com.inventory.model.PurchaseOrderModel;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class PurchaseOrderMaster extends JFrame {
	private JComboBox cusCombo;
	private JComboBox partCombo;
	private JPanel contentPane;
	private JTextField cusName;
	private JTextField po;
	private JTextField date;
	private JTextField quantity;
	private JTextField rate;
	private JTextField st;
	private JTextField ed;
	private JTextField mrp;
	private JTextField hsn;
	private JTextField igst;
	private JTextField cgst;
	private JTextField sgst;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PurchaseOrderMaster frame = new PurchaseOrderMaster();
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
	public PurchaseOrderMaster() {
		setTitle("Purchase Order");
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
				Session session = sessionFactory.openSession();
				session.beginTransaction();
				List<CustomerModel> products = session.createQuery(" from CustomerModel ").list();
				// System.out.println(customerModel.get());
				DefaultComboBoxModel coModel = (DefaultComboBoxModel) cusCombo.getModel();

				for (CustomerModel customerModel1 : products) {

					coModel.addElement(customerModel1.getCode());

					cusCombo.setModel(coModel);

				}

				List<ComponentModel> component = session.createQuery(" from ComponentModel ").list();
				// System.out.println(customerModel.get());
				DefaultComboBoxModel coModel1 = (DefaultComboBoxModel) partCombo.getModel();

				for (ComponentModel componentModel : component) {

					coModel1.addElement(componentModel.getPartCode());

					partCombo.setModel(coModel1);

				}

			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 974, 594);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		cusCombo = new JComboBox();
		cusCombo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
				Session session = sessionFactory.openSession();
				session.beginTransaction();
				String co = cusCombo.getSelectedItem().toString();
				CustomerModel customerModel = (CustomerModel) session.get(CustomerModel.class, co);

				cusName.setText(customerModel.getName());

				session.getTransaction().commit();
				session.close();
				sessionFactory.close();

			}
		});
		cusCombo.setBounds(124, 57, 111, 20);
		contentPane.add(cusCombo);

		cusName = new JTextField();
		cusName.setBounds(268, 57, 283, 20);
		contentPane.add(cusName);
		cusName.setColumns(10);
		partCombo = new JComboBox();
		partCombo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
				Session session = sessionFactory.openSession();
				session.beginTransaction();
				String part = partCombo.getSelectedItem().toString();
				ComponentModel componentModel = (ComponentModel) session.get(ComponentModel.class, part);

				hsn.setText(componentModel.getHsnCode());

				session.getTransaction().commit();
				session.close();
				sessionFactory.close();

			}
		});
		partCombo.setBounds(78, 135, 111, 20);
		contentPane.add(partCombo);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(159, 110, 46, 14);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_2 = new JLabel("p.o /Amend.no");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(199, 110, 84, 17);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_1 = new JLabel("Part Code");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(10, 136, 83, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_3 = new JLabel("Date");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(305, 110, 46, 14);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Quantity");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(401, 110, 48, 17);
		contentPane.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Rate");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_5.setBounds(500, 110, 46, 14);
		contentPane.add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("S.T%");
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_6.setBounds(595, 110, 46, 14);
		contentPane.add(lblNewLabel_6);

		JLabel lblNewLabel_7 = new JLabel("E.D%");
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_7.setBounds(698, 110, 46, 14);
		contentPane.add(lblNewLabel_7);

		JLabel lblNewLabel_8 = new JLabel("MRP");
		lblNewLabel_8.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_8.setBounds(797, 110, 46, 14);
		contentPane.add(lblNewLabel_8);

		JLabel lblNewLabel_9 = new JLabel("Customer");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_9.setBounds(22, 60, 60, 17);
		contentPane.add(lblNewLabel_9);

		po = new JTextField();
		po.setBounds(199, 135, 86, 20);
		contentPane.add(po);
		po.setColumns(10);

		date = new JTextField();
		date.setColumns(10);
		date.setBounds(293, 135, 86, 20);
		contentPane.add(date);

		quantity = new JTextField();
		quantity.setColumns(10);
		quantity.setBounds(389, 135, 86, 20);
		contentPane.add(quantity);

		rate = new JTextField();
		rate.setColumns(10);
		rate.setBounds(485, 135, 86, 20);
		contentPane.add(rate);

		st = new JTextField();
		st.setColumns(10);
		st.setBounds(581, 135, 86, 20);
		contentPane.add(st);

		ed = new JTextField();
		ed.setColumns(10);
		ed.setBounds(677, 135, 86, 20);
		contentPane.add(ed);

		mrp = new JTextField();
		mrp.setColumns(10);
		mrp.setBounds(773, 135, 70, 20);
		contentPane.add(mrp);

		JLabel lblHsnCode = new JLabel("HSN Code");
		lblHsnCode.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblHsnCode.setBounds(199, 224, 84, 17);
		contentPane.add(lblHsnCode);

		JLabel lblIntegratedGst = new JLabel("Integrated GST");
		lblIntegratedGst.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblIntegratedGst.setBounds(309, 226, 88, 17);
		contentPane.add(lblIntegratedGst);

		JLabel lblCgst = new JLabel("CGST");
		lblCgst.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblCgst.setBounds(427, 224, 84, 17);
		contentPane.add(lblCgst);

		JLabel lblSgst = new JLabel("SGST");
		lblSgst.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblSgst.setBounds(521, 224, 84, 17);
		contentPane.add(lblSgst);

		hsn = new JTextField();
		hsn.setColumns(10);
		hsn.setBounds(199, 252, 86, 20);
		contentPane.add(hsn);

		igst = new JTextField();

		igst.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void insertUpdate(DocumentEvent arg0) {
				// TODO Auto-generated method stub

				if (Float.parseFloat(igst.getText()) > 0) {
					float val = (Float.parseFloat(igst.getText()));
					float ha = val / 2;
					sgst.setText(String.valueOf(ha));
					cgst.setText(String.valueOf(ha));
				} else {
					igst.setText(String.valueOf(0));
					cgst.setText(String.valueOf(0));
					sgst.setText(String.valueOf(0));

				}
			}

			@Override
			public void removeUpdate(DocumentEvent arg0) {
				// TODO Auto-generated method stub
				if (Float.parseFloat(igst.getText()) > 0) {
					float val = (Float.parseFloat(igst.getText()));
					float ha = val / 2;
					sgst.setText(String.valueOf(ha));
					cgst.setText(String.valueOf(ha));
				} else {
					igst.setText(String.valueOf(0));
					cgst.setText(String.valueOf(0));
					sgst.setText(String.valueOf(0));

				}
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				if (Float.parseFloat(igst.getText()) > 0) {
					float val = (Float.parseFloat(igst.getText()));
					float ha = val / 2;
					sgst.setText(String.valueOf(ha));
					cgst.setText(String.valueOf(ha));
				} else {
					igst.setText(String.valueOf(0));
					cgst.setText(String.valueOf(0));
					sgst.setText(String.valueOf(0));

				}
			}

		});
		igst.setColumns(10);
		igst.setBounds(311, 254, 86, 20);
		contentPane.add(igst);

		cgst = new JTextField();
		cgst.setColumns(10);
		cgst.setBounds(413, 254, 86, 20);
		contentPane.add(cgst);

		sgst = new JTextField();
		sgst.setColumns(10);
		sgst.setBounds(519, 252, 86, 20);
		contentPane.add(sgst);
		
		JButton button = new JButton("Save");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
				Session session=sessionFactory.openSession();
				session.beginTransaction();
				
				
				
				PurchaseOrderModel pom=new PurchaseOrderModel();
				pom.setCusCode(cusCombo.getSelectedItem().toString());
				pom.setCusName(cusName.getText());
				pom.setPartCode(partCombo.getSelectedItem().toString());
				pom.setHsn(hsn.getText());
				pom.setPoNo(Long.parseLong(po.getText()));
				pom.setDate(new Date(date.getText()));
				pom.setQuantity(Long.parseLong(quantity.getText()));
				pom.setSgst(Float.parseFloat(sgst.getText()));
				pom.setRate(Long.parseLong(rate.getText()));
				pom.setSt(Long.parseLong(st.getText()));
				pom.setEd(Long.parseLong(ed.getText()));
				pom.setMrp(Long.parseLong(mrp.getText()));
				pom.setIgst(Float.parseFloat(igst.getText()));
				pom.setCgst(Float.parseFloat(cgst.getText()));
				session.save(pom);
				session.getTransaction().commit();
				
				
				
				
				

				@SuppressWarnings("unchecked")
				List<PurchaseOrderModel> products = session.createQuery("from PurchaseOrderModel").list();

				Vector<String> tableHeaders = new Vector<String>();
				Vector tableData = new Vector();
				tableHeaders.add("cuscode");
				tableHeaders.add("cusname");
				tableHeaders.add("partcode");
				tableHeaders.add("po/amend no");
				tableHeaders.add("Date");
				tableHeaders.add("quantity");
				tableHeaders.add("rate");
				tableHeaders.add("s.t%");
				tableHeaders.add("e.d%");
				tableHeaders.add("mrp");
				tableHeaders.add("hsn code");
				tableHeaders.add("igst");
				tableHeaders.add("cgst");
				tableHeaders.add("sgst");
				
				// tableHeaders.add("name");
				for (Object o : products) {
					PurchaseOrderModel model = (PurchaseOrderModel) o;
					Vector<Object> oneRow = new Vector<Object>();
					oneRow.add(model.getCusCode());
					oneRow.add(model.getCusName());
					oneRow.add(model.getPartCode());
					oneRow.add(model.getPoNo());
					oneRow.add(model.getDate());
					oneRow.add(model.getQuantity());
					oneRow.add(model.getRate());
					oneRow.add(model.getSt());
					oneRow.add(model.getEd());
					oneRow.add(model.getMrp());
					oneRow.add(model.getHsn());
					oneRow.add(model.getIgst());
					
					oneRow.add(model.getCgst());
					oneRow.add(model.getSgst());
					
					tableData.add(oneRow);
				}
				table.setModel(new DefaultTableModel(tableData, tableHeaders));
				//ssionFactory.close();

				session.close();
				sessionFactory.close();
				
				
				
				
				
				
				
				
				
				
				
			}
		});
		button.setIcon(new ImageIcon(PurchaseOrderMaster.class.getResource("/inventory/save.png")));
		button.setFont(new Font("Tahoma", Font.BOLD, 14));
		button.setBounds(16, 0, 102, 29);
		contentPane.add(button);
		
		JButton button_1 = new JButton("Update");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
				Session session=sessionFactory.openSession();
				session.beginTransaction();
				
				
				
				PurchaseOrderModel pom=new PurchaseOrderModel();
				pom.setCusCode(cusCombo.getSelectedItem().toString());
				pom.setCusName(cusName.getText());
				pom.setPartCode(partCombo.getSelectedItem().toString());
				pom.setHsn(hsn.getText());
				pom.setPoNo(Long.parseLong(po.getText()));
				pom.setDate(new Date(date.getText()));
				pom.setQuantity(Long.parseLong(quantity.getText()));
				pom.setSgst(Float.parseFloat(sgst.getText()));
				pom.setRate(Long.parseLong(rate.getText()));
				pom.setSt(Long.parseLong(st.getText()));
				pom.setEd(Long.parseLong(ed.getText()));
				pom.setMrp(Long.parseLong(mrp.getText()));
				pom.setIgst(Float.parseFloat(igst.getText()));
				pom.setCgst(Float.parseFloat(cgst.getText()));
				session.update(pom);
				session.getTransaction().commit();
				
				

				@SuppressWarnings("unchecked")
				List<PurchaseOrderModel> products = session.createQuery("from PurchaseOrderModel").list();

				Vector<String> tableHeaders = new Vector<String>();
				Vector tableData = new Vector();
				tableHeaders.add("cuscode");
				tableHeaders.add("cusname");
				tableHeaders.add("partcode");
				tableHeaders.add("po/amend no");
				tableHeaders.add("Date");
				tableHeaders.add("quantity");
				tableHeaders.add("rate");
				tableHeaders.add("s.t%");
				tableHeaders.add("e.d%");
				tableHeaders.add("mrp");
				tableHeaders.add("hsn code");
				tableHeaders.add("igst");
				tableHeaders.add("cgst");
				tableHeaders.add("sgst");
				
				// tableHeaders.add("name");
				for (Object o : products) {
					PurchaseOrderModel model = (PurchaseOrderModel) o;
					Vector<Object> oneRow = new Vector<Object>();
					oneRow.add(model.getCusCode());
					oneRow.add(model.getCusName());
					oneRow.add(model.getPartCode());
					oneRow.add(model.getPoNo());
					oneRow.add(model.getDate());
					oneRow.add(model.getQuantity());
					oneRow.add(model.getRate());
					oneRow.add(model.getSt());
					oneRow.add(model.getEd());
					oneRow.add(model.getMrp());
					oneRow.add(model.getHsn());
					oneRow.add(model.getIgst());
					
					oneRow.add(model.getCgst());
					oneRow.add(model.getSgst());
					
					tableData.add(oneRow);
				}
				table.setModel(new DefaultTableModel(tableData, tableHeaders));
				//ssionFactory.close();

				
				
				
				session.close();
				sessionFactory.close();
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
			}
		});
		button_1.setIcon(new ImageIcon(PurchaseOrderMaster.class.getResource("/inventory/update.png")));
		button_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		button_1.setBounds(118, 0, 116, 29);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("Delete");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
				Session session = sessionFactory.openSession();
				session.beginTransaction();
				PurchaseOrderModel pom=new PurchaseOrderModel();
				pom.setPoNo(Long.parseLong(po.getText()));
				session.delete(pom);
				session.getTransaction().commit();
				cusCombo.setSelectedIndex(0);
po.setText("");			
partCombo.setSelectedIndex(0);
date.setText("");
quantity.setText("");
rate.setText("");
st.setText("");
ed.setText("");
mrp.setText("");
igst.setText("");
cgst.setText("");
sgst.setText("");
				
				

				@SuppressWarnings("unchecked")
				List<PurchaseOrderModel> products = session.createQuery("from PurchaseOrderModel").list();

				Vector<String> tableHeaders = new Vector<String>();
				Vector tableData = new Vector();
				tableHeaders.add("cuscode");
				tableHeaders.add("cusname");
				tableHeaders.add("partcode");
				tableHeaders.add("po/amend no");
				tableHeaders.add("Date");
				tableHeaders.add("quantity");
				tableHeaders.add("rate");
				tableHeaders.add("s.t%");
				tableHeaders.add("e.d%");
				tableHeaders.add("mrp");
				tableHeaders.add("hsn code");
				tableHeaders.add("igst");
				tableHeaders.add("cgst");
				tableHeaders.add("sgst");
				
				// tableHeaders.add("name");
				for (Object o : products) {
					PurchaseOrderModel model = (PurchaseOrderModel) o;
					Vector<Object> oneRow = new Vector<Object>();
					oneRow.add(model.getCusCode());
					oneRow.add(model.getCusName());
					oneRow.add(model.getPartCode());
					oneRow.add(model.getPoNo());
					oneRow.add(model.getDate());
					oneRow.add(model.getQuantity());
					oneRow.add(model.getRate());
					oneRow.add(model.getSt());
					oneRow.add(model.getEd());
					oneRow.add(model.getMrp());
					oneRow.add(model.getHsn());
					oneRow.add(model.getIgst());
					
					oneRow.add(model.getCgst());
					oneRow.add(model.getSgst());
					
					tableData.add(oneRow);
				}
				table.setModel(new DefaultTableModel(tableData, tableHeaders));
				session.close();
				sessionFactory.close();

				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
			}
		});
		button_2.setIcon(new ImageIcon(PurchaseOrderMaster.class.getResource("/inventory/delete.png")));
		button_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		button_2.setBounds(234, 0, 102, 29);
		contentPane.add(button_2);
		
		JButton button_3 = new JButton("View All");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			
			
				SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
				Session session = sessionFactory.openSession();
				session.beginTransaction();

				@SuppressWarnings("unchecked")
				List<PurchaseOrderModel> products = session.createQuery("from PurchaseOrderModel").list();

				Vector<String> tableHeaders = new Vector<String>();
				Vector tableData = new Vector();
				tableHeaders.add("cuscode");
				tableHeaders.add("cusname");
				tableHeaders.add("partcode");
				tableHeaders.add("po/amend no");
				tableHeaders.add("Date");
				tableHeaders.add("quantity");
				tableHeaders.add("rate");
				tableHeaders.add("s.t%");
				tableHeaders.add("e.d%");
				tableHeaders.add("mrp");
				tableHeaders.add("hsn code");
				tableHeaders.add("igst");
				tableHeaders.add("cgst");
				tableHeaders.add("sgst");
				
				// tableHeaders.add("name");
				for (Object o : products) {
					PurchaseOrderModel model = (PurchaseOrderModel) o;
					Vector<Object> oneRow = new Vector<Object>();
					oneRow.add(model.getCusCode());
					oneRow.add(model.getCusName());
					oneRow.add(model.getPartCode());
					oneRow.add(model.getPoNo());
					oneRow.add(model.getDate());
					oneRow.add(model.getQuantity());
					oneRow.add(model.getRate());
					oneRow.add(model.getSt());
					oneRow.add(model.getEd());
					oneRow.add(model.getMrp());
					oneRow.add(model.getHsn());
					oneRow.add(model.getIgst());
					
					oneRow.add(model.getCgst());
					oneRow.add(model.getSgst());
					
					tableData.add(oneRow);
				}
				table.setModel(new DefaultTableModel(tableData, tableHeaders));
				session.getTransaction().commit();
				session.close();
				sessionFactory.close();

			
			
			
			
			
			
			
			
			
			
			
			
			
			}
		});
		button_3.setIcon(new ImageIcon(PurchaseOrderMaster.class.getResource("/inventory/view all.png")));
		button_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		button_3.setBounds(340, 0, 109, 29);
		contentPane.add(button_3);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(43, 307, 756, 190);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("view");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				
				
				
				
				
				
				
				

				DefaultTableModel model = (DefaultTableModel) table.getModel();
				int index = table.getSelectedRow();

				cusCombo.setSelectedItem(model.getValueAt(index, 0).toString());
				cusName.setText(model.getValueAt(index, 1).toString());
				partCombo.setSelectedItem(model.getValueAt(index, 2).toString());
				po.setText(model.getValueAt(index, 3).toString());
				
				String dated=model.getValueAt(table.getSelectedRow(), 4).toString();
			String ha=dated.replace('-', '/');
			date.setText(ha);
				quantity.setText(model.getValueAt(index, 5).toString());

				rate.setText(model.getValueAt(index, 6).toString());
				st.setText(model.getValueAt(index, 7).toString());

				ed.setText(model.getValueAt(index, 8).toString());
				mrp.setText(model.getValueAt(index, 9).toString());
				hsn.setText(model.getValueAt(index, 10).toString());
				igst.setText(model.getValueAt(index, 11).toString());

				

				cgst.setText(model.getValueAt(index, 12).toString());

				sgst.setText(String.valueOf((model.getValueAt(table.getSelectedRow(),13))));
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
			}
		});
		btnNewButton.setIcon(new ImageIcon(PurchaseOrderMaster.class.getResource("/inventory/viw.png")));
		btnNewButton.setBounds(797, 390, 70, 67);
		contentPane.add(btnNewButton);
	}
}
