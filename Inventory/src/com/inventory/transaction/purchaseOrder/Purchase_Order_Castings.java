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

import com.inventory.model.CastingTableModel;
import com.inventory.model.ComponentModel;
import com.inventory.model.CustomerModel;
import com.inventory.model.PORawMaterialModel;
import com.inventory.model.PORawTableModel;
import com.inventory.model.Po_CastingModel;
import com.inventory.model.VendorModel;

import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JButton;

public class Purchase_Order_Castings extends JFrame {
	JTextArea adrs;
	private JPanel contentPane;
	JComboBox comboBox;
	private JTextField pono;
	private JTextField date;
	private JTextField order;
	private JTextField ur_ref;
	private JTable table;
	private JTextField sins;
	private JTextField deli;
	private JTextField delipoint;
	private JTextField insurance;
	private JTextField pay;
	private JTextField trans;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Purchase_Order_Castings frame = new Purchase_Order_Castings();
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
	public Purchase_Order_Castings() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {

				SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
				Session session = sessionFactory.openSession();
				session.beginTransaction();
				List<VendorModel> products = session.createQuery(" from VendorModel ").list();
				// System.out.println(customerModel.get());
				DefaultComboBoxModel coModel = (DefaultComboBoxModel) comboBox.getModel();

				for (VendorModel vendor : products) {

					coModel.addElement(vendor.getCode());

					comboBox.setModel(coModel);

				}
				Po_CastingModel po=new Po_CastingModel();
				pono.setText(String.valueOf(po.getPo_no()));

			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1105, 789);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Vendor Code");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel.setBounds(10, 22, 101, 14);
		contentPane.add(lblNewLabel);

		comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
				Session session = sessionFactory.openSession();
				session.beginTransaction();
				String part = comboBox.getSelectedItem().toString();
				VendorModel vendor = (VendorModel) session.get(VendorModel.class, part);
				adrs.setText(vendor.getAddress());
				session.getTransaction().commit();
				session.close();
				sessionFactory.close();

			}
		});
		comboBox.setBounds(105, 20, 72, 20);
		contentPane.add(comboBox);

		adrs = new JTextArea();
		adrs.setBounds(10, 65, 264, 73);
		contentPane.add(adrs);

		JLabel lblNewLabel_1 = new JLabel("P.o.No");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(432, 20, 46, 17);
		contentPane.add(lblNewLabel_1);

		pono = new JTextField();
		pono.setBounds(565, 20, 185, 26);
		contentPane.add(pono);
		pono.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Date");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(432, 65, 46, 14);
		contentPane.add(lblNewLabel_2);

		date = new JTextField();
		date.setBounds(565, 65, 185, 28);
		contentPane.add(date);
		date.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Order valid upto");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3.setBounds(419, 109, 100, 15);
		contentPane.add(lblNewLabel_3);

		order = new JTextField();
		order.setBounds(565, 104, 185, 26);
		contentPane.add(order);
		order.setColumns(10);

		JLabel lblYourReference = new JLabel("Your Reference");
		lblYourReference.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblYourReference.setBounds(419, 137, 100, 15);
		contentPane.add(lblYourReference);

		ur_ref = new JTextField();
		ur_ref.setColumns(10);
		ur_ref.setBounds(565, 141, 185, 26);
		contentPane.add(ur_ref);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 178, 948, 204);
		contentPane.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		JLabel lblSpecialInstruction = new JLabel("special  Instruction");
		lblSpecialInstruction.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSpecialInstruction.setBounds(10, 393, 117, 15);
		contentPane.add(lblSpecialInstruction);

		sins = new JTextField();
		sins.setBounds(151, 393, 589, 28);
		contentPane.add(sins);
		sins.setColumns(10);

		JLabel lblDelivery = new JLabel("delivery");
		lblDelivery.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDelivery.setBounds(11, 431, 47, 15);
		contentPane.add(lblDelivery);

		deli = new JTextField();
		deli.setColumns(10);
		deli.setBounds(82, 432, 185, 26);
		contentPane.add(deli);

		delipoint = new JTextField();
		delipoint.setColumns(10);
		delipoint.setBounds(375, 432, 185, 26);
		contentPane.add(delipoint);

		insurance = new JTextField();
		insurance.setColumns(10);
		insurance.setBounds(676, 432, 185, 26);
		contentPane.add(insurance);

		JLabel lblDeliveryPoint = new JLabel("delivery point");
		lblDeliveryPoint.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDeliveryPoint.setBounds(277, 435, 100, 18);
		contentPane.add(lblDeliveryPoint);

		JLabel lblInsurance = new JLabel("Insurance");
		lblInsurance.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblInsurance.setBounds(584, 434, 100, 20);
		contentPane.add(lblInsurance);

		pay = new JTextField();
		pay.setColumns(10);
		pay.setBounds(120, 469, 185, 26);
		contentPane.add(pay);

		trans = new JTextField();
		trans.setColumns(10);
		trans.setBounds(894, 388, 185, 26);
		contentPane.add(trans);

		JLabel lblTransport = new JLabel("Transport");
		lblTransport.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTransport.setBounds(758, 393, 100, 18);
		contentPane.add(lblTransport);

		JLabel lblPaymentTerm = new JLabel("payment Term");
		lblPaymentTerm.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPaymentTerm.setBounds(10, 469, 100, 18);
		contentPane.add(lblPaymentTerm);

		JMenuItem menuItem = new JMenuItem("save");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				

				SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
				Session session = sessionFactory.openSession();
				session.beginTransaction();

		Po_CastingModel model = new Po_CastingModel();

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
				List<Po_CastingModel> products = session1.createQuery("from Po_CastingModel").list();

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
					Po_CastingModel model1 = (Po_CastingModel) o;
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
				table_1.setModel(new DefaultTableModel(tableData, tableHeaders));
				session1.getTransaction().commit();
				session1.close();
				sessionFactory1.close();

				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
			}
		});
		menuItem.setIcon(new ImageIcon(Purchase_Order_Castings.class.getResource("/inventory/save.png")));
		menuItem.setFont(new Font("Arial", Font.BOLD, 14));
		menuItem.setBounds(68, 688, 82, 26);
		contentPane.add(menuItem);

		JMenuItem menuItem_2 = new JMenuItem("Update");
		menuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
				Session session = sessionFactory.openSession();
				session.beginTransaction();

				Po_CastingModel model=new Po_CastingModel();

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
				List<Po_CastingModel> products = session1.createQuery("from Po_CastingModel").list();

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
					Po_CastingModel model1 = (Po_CastingModel) o;
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
				table_1.setModel(new DefaultTableModel(tableData, tableHeaders));
				session1.getTransaction().commit();
				session1.close();
				sessionFactory1.close();
				
			
			
			
			
			
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
			}
		});
		menuItem_2.setIcon(new ImageIcon(Purchase_Order_Castings.class.getResource("/inventory/update.png")));
		menuItem_2.setFont(new Font("Arial", Font.BOLD, 14));
		menuItem_2.setBounds(190, 685, 129, 29);
		contentPane.add(menuItem_2);

		JMenuItem menuItem_3 = new JMenuItem("Delete");
		menuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				
				SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
				Session session = sessionFactory.openSession();
				session.beginTransaction();
				// ComponentModel componentModel = new ComponentModel();
				Po_CastingModel model=new Po_CastingModel();
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
				List<Po_CastingModel> products = session1.createQuery("from Po_CastingModel").list();

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
					Po_CastingModel model1 = (Po_CastingModel) o;
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
				table_1.setModel(new DefaultTableModel(tableData, tableHeaders));
				session1.getTransaction().commit();
				session1.close();
				sessionFactory1.close();

				
				
				
				
				
				
				
				
				
				
				
				
			}
		});
		menuItem_3.setIcon(new ImageIcon(Purchase_Order_Castings.class.getResource("/inventory/delete.png")));
		menuItem_3.setFont(new Font("Arial", Font.BOLD, 14));
		menuItem_3.setBounds(315, 688, 101, 26);
		contentPane.add(menuItem_3);
		
		JButton button = new JButton("Add");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				
				
				
		CastingTable table=new CastingTable();
		table.setVisible(true);
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
			}
		});
		button.setIcon(new ImageIcon(Purchase_Order_Castings.class.getResource("/inventory/add.png")));
		button.setBounds(986, 214, 81, 26);
		contentPane.add(button);
		
		JButton button_1 = new JButton("View");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
				Session session = sessionFactory.openSession();
				session.beginTransaction();
				

				//String pri = comboBox.getSelectedItem().toString();
				@SuppressWarnings("unchecked")
				List<CastingTableModel> products = session
						.createQuery("from CastingTableModel model ").list();
				// query.setParameter("pri", "%" + pri + "%");
				Vector<String> tableHeaders = new Vector<String>();
				Vector tableData = new Vector();
				tableHeaders.add("id");
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
					CastingTableModel model = (CastingTableModel) o;
					Vector<Object> oneRow = new Vector<Object>();
					oneRow.add(model.getId());
					oneRow.add(model.getPart_code());
					oneRow.add(model.getPart_des());
					oneRow.add(model.getQty());
					oneRow.add(model.getUom());
					oneRow.add(model.getRate());
					oneRow.add(model.getAmount());
					oneRow.add(model.getIgst());
					oneRow.add(model.getCgst());
					oneRow.add(model.getSgst());
					oneRow.add(model.getNorms());
					oneRow.add(model.getRemarks());
					tableData.add(oneRow);
				}
				table.setModel(new DefaultTableModel(tableData, tableHeaders));
				session.getTransaction().commit();
				session.flush();
				session.close();
				sessionFactory.close();
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
			}
		});
		button_1.setIcon(new ImageIcon(Purchase_Order_Castings.class.getResource("/inventory/viw.png")));
		button_1.setBounds(986, 251, 78, 29);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("Delete");
		button_2.setIcon(new ImageIcon(Purchase_Order_Castings.class.getResource("/inventory/delete.png")));
		button_2.setBounds(986, 291, 87, 29);
		contentPane.add(button_2);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(24, 512, 1043, 162);
		contentPane.add(scrollPane_1);
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		
		JButton btnViewAll = new JButton("View all");
		btnViewAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				
				
				
				
				SessionFactory sessionFactory1 = new Configuration().configure().buildSessionFactory();
				Session session1 = sessionFactory1.openSession();
				session1.beginTransaction();

				@SuppressWarnings("unchecked")
				List<Po_CastingModel> products = session1.createQuery("from Po_CastingModel").list();

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
					Po_CastingModel model1 = (Po_CastingModel) o;
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
				table_1.setModel(new DefaultTableModel(tableData, tableHeaders));
				session1.getTransaction().commit();
				session1.close();
				sessionFactory1.close();

				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
			}
		});
		btnViewAll.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnViewAll.setIcon(new ImageIcon(Purchase_Order_Castings.class.getResource("/inventory/view all.png")));
		btnViewAll.setBounds(448, 685, 103, 29);
		contentPane.add(btnViewAll);
		
		JButton button_4 = new JButton("View");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				DefaultTableModel model = (DefaultTableModel) table_1.getModel();
				int index = table_1.getSelectedRow();

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
		button_4.setIcon(new ImageIcon(Purchase_Order_Castings.class.getResource("/inventory/viw.png")));
		button_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		button_4.setBounds(598, 691, 85, 29);
		contentPane.add(button_4);
	}
}
