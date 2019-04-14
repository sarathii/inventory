package com.inventory.frames;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.fasterxml.classmate.members.RawConstructor;
import com.inventory.model.ComponentModel;
import com.inventory.model.CustomerModel;
import com.inventory.model.MouldModel;
import com.inventory.model.RawModel;

import javax.swing.JTextField;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JMenuBar;

public class ComponentMaster extends JFrame {

	private JPanel contentPane;
	private JTextField comName;
	private JTextField comPartno;

	private JTextField comPartCode;
	private JTextField hsnCode;
	private JTextField norm1;
	private JTextField from1;
	private JTextField to1;
	private JTextField to2;
	private JTextField from2;
	private JTextField norm2;
	private JTextField norm3;
	private JTextField from3;
	private JTextField to3;
	private JTextField aValue;
	private JTextField amFrom;
	private JTextField amQty;
	private JTextField norm4;
	private JTextField from4;
	private JTextField to4;
	private JLabel lblFettlingRate;
	private JTextField fRate;
	private JLabel lblPackagingMode;
	private JComboBox packMode;
	private JLabel lblNoOfCavities;
	private JTextField noCav;
	private JLabel lblMouldCode;
	private JComboBox mouldCombo;
	private JLabel mouldName;
	private JTable table;
	private JComboBox cusCombo;
	private JComboBox rawCombo;
	private JButton button;
	private JButton button_1;
	private JButton button_2;
	private JLabel rawName;
	private JLabel cusName;
	private JScrollPane scrollPane;
	private JButton btnHome;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ComponentMaster frame = new ComponentMaster();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ComponentMaster() {
		setTitle("Component Master");
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {

				// CustomerModel customerModel = new CustomerModel();

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

				/*
				 * session.getTransaction().commit(); //session.flush();
				 * session.close(); sessionFactory.close();
				 * 
				 * 
				 * SessionFactory sessionFactory1 = new
				 * Configuration().configure().buildSessionFactory(); Session
				 * session1 = sessionFactory1.openSession();
				 * session1.beginTransaction();
				 */
				List<RawModel> raw = session.createQuery(" from RawModel ").list();
				// System.out.println(customerModel.get());
				DefaultComboBoxModel model = (DefaultComboBoxModel) rawCombo.getModel();

				// DefaultComboBoxModel model=(DefaultComboBoxModel)
				// comboBox.getModel();
				// coModel.removeAllElements();
				for (RawModel rawModel : raw) {
					// System.out.println("helllo");
					model.addElement(rawModel.getCode());

					rawCombo.setModel(model);

				}

				List<MouldModel> mould = session.createQuery(" from MouldModel ").list();
				// System.out.println(customerModel.get());
				DefaultComboBoxModel model1 = (DefaultComboBoxModel) mouldCombo.getModel();

				for (MouldModel mouldModel : mould) {
					// System.out.println("helllo");
					model1.addElement(mouldModel.getMouldCode());

					mouldCombo.setModel(model1);

				}

				session.getTransaction().commit();
				// session.flush();
				session.close();
				sessionFactory.close();

			}

			@Override
			public void windowClosed(WindowEvent arg0) {

				
			}
		});

		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1062, 772);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.control);
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Customer");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel.setBounds(51, 123, 61, 17);
		contentPane.add(lblNewLabel);

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
		cusCombo.setBackground(SystemColor.window);
		cusCombo.setBounds(211, 122, 86, 20);
		contentPane.add(cusCombo);

		cusName = new JLabel("");
		cusName.setFont(new Font("Monospaced", Font.PLAIN, 14));
		cusName.setBackground(Color.WHITE);
		cusName.setBounds(334, 122, 280, 22);
		contentPane.add(cusName);

		JLabel lblRaw = new JLabel("Raw");
		lblRaw.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblRaw.setBounds(60, 167, 61, 17);
		contentPane.add(lblRaw);

		rawCombo = new JComboBox();
		rawCombo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
				Session session = sessionFactory.openSession();
				session.beginTransaction();
				RawModel rawModel = (RawModel) session.get(RawModel.class, rawCombo.getSelectedItem().toString());
				rawName.setText(rawModel.getDes());
				session.getTransaction().commit();
				session.close();
				sessionFactory.close();

			}
		});
		rawCombo.setBackground(Color.WHITE);
		rawCombo.setBounds(211, 166, 86, 20);
		contentPane.add(rawCombo);

		rawName = new JLabel("");
		rawName.setFont(new Font("Monospaced", Font.PLAIN, 14));
		rawName.setBackground(Color.WHITE);
		rawName.setBounds(334, 164, 280, 20);
		contentPane.add(rawName);

		JLabel lblNewLabel_2 = new JLabel("Component Name");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_2.setBounds(41, 222, 110, 17);
		contentPane.add(lblNewLabel_2);

		comName = new JTextField();
		comName.setFont(new Font("Monospaced", Font.PLAIN, 14));
		comName.setBounds(211, 216, 323, 28);
		contentPane.add(comName);
		comName.setColumns(10);

		JLabel lblComponent = new JLabel(" Comonent's Part No");
		lblComponent.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblComponent.setBounds(35, 261, 128, 17);
		contentPane.add(lblComponent);

		comPartno = new JTextField();
		comPartno.setFont(new Font("Monospaced", Font.PLAIN, 14));
		comPartno.setColumns(10);
		comPartno.setBounds(211, 255, 261, 28);
		contentPane.add(comPartno);

		JLabel lblPartCode = new JLabel("Part Code");
		lblPartCode.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblPartCode.setBounds(485, 261, 61, 17);
		contentPane.add(lblPartCode);

		comPartCode = new JTextField();
		comPartCode.setFont(new Font("Monospaced", Font.PLAIN, 14));
		comPartCode.setColumns(10);
		comPartCode.setBounds(556, 255, 261, 28);
		contentPane.add(comPartCode);

		JLabel lblHsnsacCode = new JLabel("HSN/SAC Code");
		lblHsnsacCode.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblHsnsacCode.setBounds(41, 312, 110, 17);
		contentPane.add(lblHsnsacCode);

		hsnCode = new JTextField();
		hsnCode.setFont(new Font("Monospaced", Font.PLAIN, 14));
		hsnCode.setColumns(10);
		hsnCode.setBounds(211, 306, 261, 28);
		contentPane.add(hsnCode);

		JLabel lblNormsWeight = new JLabel("Norms Weight");
		lblNormsWeight.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNormsWeight.setBounds(53, 340, 110, 17);
		contentPane.add(lblNormsWeight);

		JLabel lblFromDate = new JLabel("From Date");
		lblFromDate.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblFromDate.setBounds(206, 340, 110, 17);
		contentPane.add(lblFromDate);

		JLabel lblToDate = new JLabel("To Date");
		lblToDate.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblToDate.setBounds(362, 340, 110, 17);
		contentPane.add(lblToDate);

		norm1 = new JTextField();
		norm1.setText("0");
		norm1.setFont(new Font("Monospaced", Font.PLAIN, 14));
		norm1.setColumns(10);
		norm1.setBounds(48, 368, 115, 28);
		contentPane.add(norm1);

		from1 = new JTextField();
		from1.setText("00/00/0000");
		from1.setFont(new Font("Monospaced", Font.PLAIN, 14));
		from1.setColumns(10);
		from1.setBounds(201, 368, 115, 28);
		contentPane.add(from1);

		to1 = new JTextField();
		to1.setText("00/00/0000");
		to1.setFont(new Font("Monospaced", Font.PLAIN, 14));
		to1.setColumns(10);
		to1.setBounds(357, 368, 115, 28);
		contentPane.add(to1);

		to2 = new JTextField();
		to2.setFont(new Font("Monospaced", Font.PLAIN, 14));
		to2.setColumns(10);
		to2.setBounds(357, 407, 115, 28);
		contentPane.add(to2);

		from2 = new JTextField();
		from2.setFont(new Font("Monospaced", Font.PLAIN, 14));
		from2.setColumns(10);
		from2.setBounds(201, 407, 115, 28);
		contentPane.add(from2);

		norm2 = new JTextField();
		norm2.setFont(new Font("Monospaced", Font.PLAIN, 14));
		norm2.setColumns(10);
		norm2.setBounds(48, 407, 115, 28);
		contentPane.add(norm2);

		norm3 = new JTextField();
		norm3.setFont(new Font("Monospaced", Font.PLAIN, 14));
		norm3.setColumns(10);
		norm3.setBounds(48, 446, 115, 28);
		contentPane.add(norm3);

		from3 = new JTextField();
		from3.setFont(new Font("Monospaced", Font.PLAIN, 14));
		from3.setColumns(10);
		from3.setBounds(201, 446, 115, 28);
		contentPane.add(from3);

		to3 = new JTextField();
		to3.setFont(new Font("Monospaced", Font.PLAIN, 14));
		to3.setColumns(10);
		to3.setBounds(357, 446, 115, 28);
		contentPane.add(to3);

		JLabel lblAmortiosationValuepercomponent = new JLabel("Amortiosation Value (PerComponent)");
		lblAmortiosationValuepercomponent.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblAmortiosationValuepercomponent.setBounds(21, 526, 234, 17);
		contentPane.add(lblAmortiosationValuepercomponent);

		aValue = new JTextField();
		aValue.setFont(new Font("Monospaced", Font.PLAIN, 14));
		aValue.setColumns(10);
		aValue.setBounds(265, 524, 115, 20);
		contentPane.add(aValue);

		JLabel lblAmortiosationFromDate = new JLabel("Amortiosation From Date");
		lblAmortiosationFromDate.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblAmortiosationFromDate.setBounds(402, 526, 163, 17);
		contentPane.add(lblAmortiosationFromDate);

		amFrom = new JTextField();
		amFrom.setFont(new Font("Monospaced", Font.PLAIN, 14));
		amFrom.setColumns(10);
		amFrom.setBounds(596, 524, 115, 20);
		contentPane.add(amFrom);

		JLabel lblAmortiosationQty = new JLabel("Amortiosation Qty");
		lblAmortiosationQty.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblAmortiosationQty.setBounds(721, 526, 115, 17);
		contentPane.add(lblAmortiosationQty);

		amQty = new JTextField();
		amQty.setFont(new Font("Monospaced", Font.PLAIN, 14));
		amQty.setColumns(10);
		amQty.setBounds(846, 524, 128, 20);
		contentPane.add(amQty);

		norm4 = new JTextField();
		norm4.setFont(new Font("Monospaced", Font.PLAIN, 14));
		norm4.setColumns(10);
		norm4.setBounds(48, 485, 115, 28);
		contentPane.add(norm4);

		from4 = new JTextField();
		from4.setFont(new Font("Monospaced", Font.PLAIN, 14));
		from4.setColumns(10);
		from4.setBounds(201, 485, 115, 28);
		contentPane.add(from4);

		to4 = new JTextField();
		to4.setFont(new Font("Monospaced", Font.PLAIN, 14));
		to4.setColumns(10);
		to4.setBounds(357, 485, 115, 28);
		contentPane.add(to4);

		lblFettlingRate = new JLabel("Fettling Rate");
		lblFettlingRate.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblFettlingRate.setBounds(744, 568, 81, 17);
		contentPane.add(lblFettlingRate);

		fRate = new JTextField();
		fRate.setFont(new Font("Monospaced", Font.PLAIN, 14));
		fRate.setColumns(10);
		fRate.setBounds(859, 565, 115, 22);
		contentPane.add(fRate);

		lblPackagingMode = new JLabel("Packaging Mode");
		lblPackagingMode.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblPackagingMode.setBounds(51, 568, 100, 17);
		contentPane.add(lblPackagingMode);

		packMode = new JComboBox();
		packMode.setModel(new DefaultComboBoxModel(new String[] { "Tray", "Gunny Bag", "Box", "Bag" }));
		packMode.setBackground(Color.WHITE);
		packMode.setBounds(206, 567, 110, 20);
		contentPane.add(packMode);

		lblNoOfCavities = new JLabel("No Of Cavities");
		lblNoOfCavities.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNoOfCavities.setBounds(434, 568, 100, 17);
		contentPane.add(lblNoOfCavities);

		noCav = new JTextField();
		noCav.setFont(new Font("Monospaced", Font.PLAIN, 14));
		noCav.setColumns(10);
		noCav.setBounds(596, 566, 115, 20);
		contentPane.add(noCav);

		lblMouldCode = new JLabel("Mould Code");
		lblMouldCode.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblMouldCode.setBounds(495, 418, 100, 17);
		contentPane.add(lblMouldCode);

		mouldCombo = new JComboBox();
		mouldCombo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
				Session session = sessionFactory.openSession();
				session.beginTransaction();
				MouldModel mouldModel = (MouldModel) session.get(MouldModel.class,
						mouldCombo.getSelectedItem().toString());
				mouldName.setText(mouldModel.getMouldName());
				session.getTransaction().commit();
				session.close();
				sessionFactory.close();

			}
		});
		mouldCombo.setBackground(Color.WHITE);
		mouldCombo.setBounds(599, 412, 132, 20);
		contentPane.add(mouldCombo);
		mouldName = new JLabel("");
		mouldName.setFont(new Font("Monospaced", Font.PLAIN, 14));
		mouldName.setBackground(Color.WHITE);
		mouldName.setBounds(756, 412, 280, 20);
		contentPane.add(mouldName);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(35, 598, 814, 130);
		contentPane.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		button = new JButton("Save");
		button.addActionListener(new ActionListener() {

			// to save

			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {

				SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
				Session session = sessionFactory.openSession();
				session.beginTransaction();

				ComponentModel componentModel = new ComponentModel();

				// String date =
				// DateFormat.getDateInstance().format(amFrom.getText());

				componentModel.setcCode(cusCombo.getSelectedItem().toString());
				componentModel.setcName(cusName.getText());
				componentModel.setRawCode(rawCombo.getSelectedItem().toString());
				componentModel.setRawName(rawName.getText());
				componentModel.setComponenetName(comName.getText());
				componentModel.setCompPartno(Long.parseLong(comPartno.getText()));
				componentModel.setPartCode(comPartCode.getText());
				componentModel.setHsnCode(hsnCode.getText());
				componentModel.setMouldCode(hsnCode.getText());
				componentModel.setFrom1(new Date(from1.getText()));

				
					componentModel.setFrom2(new Date(from2.getText()));
				

				
					componentModel.setFrom3(new Date(from3.getText()));
				
					componentModel.setFrom4(new Date(from4.getText()));
				

				
					componentModel.setTo1(new Date(to1.getText()));
				

					componentModel.setTo2(new Date(to2.getText()));
				

			
					componentModel.setTo3(new Date(to3.getText()));
				

				
					componentModel.setTo4(new Date(to4.getText()));
			

				componentModel.setNorm1(Long.parseLong(norm1.getText()));

			
					componentModel.setNorm2(Long.parseLong(norm2.getText()));

				
				
					componentModel.setNorm3(Long.parseLong(norm3.getText()));
			
					componentModel.setNorm4(Long.parseLong(norm4.getText()));

				
				// componentModel.setTo1(new Date(to1.getText()));

				componentModel.setAmValue(Long.parseLong(aValue.getText()));
				componentModel.setAmFrom(new Date(amFrom.getText()));
				componentModel.setAmQty(Long.parseLong(amQty.getText()));
				componentModel.setFettlingRate(Long.parseLong(fRate.getText()));
				componentModel.setNoCavities(Long.parseLong(noCav.getText()));
				componentModel.setMouldCode(mouldCombo.getSelectedItem().toString());
				componentModel.setMouldName(mouldName.getText());
				componentModel.setPackMode(packMode.getSelectedItem().toString());

				session.save(componentModel);
				session.getTransaction().commit();
				JOptionPane.showMessageDialog(null, "saved");
				session.close();
				sessionFactory.close();

				SessionFactory sessionFactory1 = new Configuration().configure().buildSessionFactory();
				Session session1 = sessionFactory1.openSession();
				session1.beginTransaction();

				@SuppressWarnings("unchecked")
				List<ComponentModel> products = session1.createQuery("from ComponentModel").list();

				Vector<String> tableHeaders = new Vector<String>();
				Vector tableData = new Vector();
				tableHeaders.add("cuscode");
				tableHeaders.add("cusname");
				tableHeaders.add("rawcode");
				tableHeaders.add("rawname");
				tableHeaders.add("component name");
				tableHeaders.add("component part no");
				tableHeaders.add("partcode");
				tableHeaders.add("hsn/sac code");
				tableHeaders.add("norm 1");
				tableHeaders.add("norm 2");
				tableHeaders.add("norm 3");
				tableHeaders.add("norm4");
				tableHeaders.add("from date1");
				tableHeaders.add("from date 2");
				tableHeaders.add("from date 3");
				tableHeaders.add("from date 4");
				tableHeaders.add("to date 1");
				tableHeaders.add("to datte 2");
				tableHeaders.add("to date 3");
				tableHeaders.add("to datte 4");
				tableHeaders.add("amortisation value");
				tableHeaders.add("amortisation from date");
				tableHeaders.add("amortisation qty");
				tableHeaders.add("fettling rate");
				tableHeaders.add("packing mode");
				tableHeaders.add("no of cavities");
				tableHeaders.add("mould code");
				tableHeaders.add("mould name");

				// tableHeaders.add("name");
				for (Object o : products) {
					ComponentModel model = (ComponentModel) o;
					Vector<Object> oneRow = new Vector<Object>();
					oneRow.add(model.getcCode());
					oneRow.add(model.getcName());
					oneRow.add(model.getRawCode());
					oneRow.add(model.getRawName());
					oneRow.add(model.getComponenetName());
					oneRow.add(model.getCompPartno());
					oneRow.add(model.getPartCode());
					oneRow.add(model.getHsnCode());
					oneRow.add(model.getNorm1());
					oneRow.add(model.getNorm2());
					oneRow.add(model.getNorm3());
					oneRow.add(model.getNorm4());
					oneRow.add(model.getFrom1());
					oneRow.add(model.getFrom2());
					oneRow.add(model.getFrom3());
					oneRow.add(model.getFrom4());
					oneRow.add(model.getTo1());
					oneRow.add(model.getTo2());
					oneRow.add(model.getTo3());
					oneRow.add(model.getTo4());

					oneRow.add(model.getAmValue());
					oneRow.add(model.getAmFrom());
					oneRow.add(model.getAmQty());
					oneRow.add(model.getFettlingRate());
					oneRow.add(model.getPackMode());
					oneRow.add(model.getNoCavities());
					oneRow.add(model.getMouldCode());
					oneRow.add(model.getMouldName());

					tableData.add(oneRow);
				}
				table.setModel(new DefaultTableModel(tableData, tableHeaders));
				session1.getTransaction().commit();
				session1.close();
				sessionFactory1.close();
			}
		});
		button.setIcon(new ImageIcon(ComponentMaster.class.getResource("/inventory/save.png")));
		button.setFont(new Font("Tahoma", Font.BOLD, 14));
		button.setBounds(10, 0, 102, 29);
		contentPane.add(button);

		button_1 = new JButton("Update");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
				Session session = sessionFactory.openSession();
				session.beginTransaction();

				ComponentModel componentModel = new ComponentModel();

				// String today = formatter.format(d);
				componentModel.setcCode(cusCombo.getSelectedItem().toString());
				componentModel.setcName(cusName.getText());
				componentModel.setRawCode(rawCombo.getSelectedItem().toString());
				componentModel.setRawName(rawName.getText());
				componentModel.setComponenetName(comName.getText());
				componentModel.setCompPartno(Long.parseLong(comPartno.getText()));
				componentModel.setPartCode(comPartCode.getText());
				componentModel.setHsnCode(hsnCode.getText());
				componentModel.setMouldCode(hsnCode.getText());
				/*
				 * Date str = new Date(from1.getText()); String
				 * s=from1.getText(); String newString = s.replace('/', 'X');
				 * 
				 * componentModel.setFrom1(new Date();
				 */
				componentModel.setFrom1(new Date(from1.getText()));
				componentModel.setFrom2(new Date(from2.getText()));
				componentModel.setFrom3(new Date(from3.getText()));
				componentModel.setFrom4(new Date(from4.getText()));
				componentModel.setNorm1(Long.parseLong(norm1.getText()));
				componentModel.setNorm2(Long.parseLong(norm2.getText()));
				componentModel.setNorm3(Long.parseLong(norm3.getText()));
				componentModel.setNorm4(Long.parseLong(norm4.getText()));
				componentModel.setTo1(new Date(to1.getText()));
				componentModel.setTo2(new Date(to2.getText()));
				componentModel.setTo3(new Date(to3.getText()));
				componentModel.setTo4(new Date(to4.getText()));
				componentModel.setAmValue(Long.parseLong(aValue.getText()));
				componentModel.setAmFrom(new Date(amFrom.getText()));
				componentModel.setAmQty(Long.parseLong(amQty.getText()));
				componentModel.setFettlingRate(Long.parseLong(fRate.getText()));
				componentModel.setNoCavities(Long.parseLong(noCav.getText()));
				componentModel.setMouldCode(mouldCombo.getSelectedItem().toString());
				componentModel.setMouldName(mouldName.getText());
				componentModel.setPackMode(packMode.getSelectedItem().toString());

				session.update(componentModel);
				session.getTransaction().commit();
				session.close();
				sessionFactory.close();
				SessionFactory sessionFactory1 = new Configuration().configure().buildSessionFactory();
				Session session1 = sessionFactory1.openSession();
				session1.beginTransaction();

				@SuppressWarnings("unchecked")
				List<ComponentModel> products = session1.createQuery("from ComponentModel").list();

				Vector<String> tableHeaders = new Vector<String>();
				Vector tableData = new Vector();
				tableHeaders.add("cuscode");
				tableHeaders.add("cusname");
				tableHeaders.add("rawcode");
				tableHeaders.add("rawname");
				tableHeaders.add("component name");
				tableHeaders.add("component part no");
				tableHeaders.add("partcode");
				tableHeaders.add("hsn/sac code");
				tableHeaders.add("norm 1");
				tableHeaders.add("norm 2");
				tableHeaders.add("norm 3");
				tableHeaders.add("norm4");
				tableHeaders.add("from date1");
				tableHeaders.add("from date 2");
				tableHeaders.add("from date 3");
				tableHeaders.add("from date 4");
				tableHeaders.add("to date 1");
				tableHeaders.add("to datte 2");
				tableHeaders.add("to date 3");
				tableHeaders.add("to datte 4");
				tableHeaders.add("amortisation value");
				tableHeaders.add("amortisation from date");
				tableHeaders.add("amortisation to date");
				tableHeaders.add("fettling rate");
				tableHeaders.add("packing mode");
				tableHeaders.add("no of cavities");
				tableHeaders.add("mould code");
				tableHeaders.add("mould name");

				// tableHeaders.add("name");
				for (Object o : products) {
					ComponentModel model = (ComponentModel) o;
					Vector<Object> oneRow = new Vector<Object>();
					oneRow.add(model.getcCode());

					oneRow.add(model.getcName());
					oneRow.add(model.getRawCode());
					oneRow.add(model.getRawName());
					oneRow.add(model.getComponenetName());
					oneRow.add(model.getCompPartno());
					oneRow.add(model.getPartCode());
					oneRow.add(model.getHsnCode());
					oneRow.add(model.getNorm1());
					oneRow.add(model.getNorm2());
					oneRow.add(model.getNorm3());
					oneRow.add(model.getNorm4());
					oneRow.add(model.getFrom1());
					oneRow.add(model.getFrom2());
					oneRow.add(model.getFrom3());
					oneRow.add(model.getFrom4());
					oneRow.add(model.getTo1());
					oneRow.add(model.getTo2());
					oneRow.add(model.getTo3());
					oneRow.add(model.getTo4());

					oneRow.add(model.getAmValue());
					oneRow.add(model.getAmFrom());
					oneRow.add(model.getAmQty());
					oneRow.add(model.getFettlingRate());
					oneRow.add(model.getPackMode());
					oneRow.add(model.getNoCavities());
					oneRow.add(model.getMouldCode());
					oneRow.add(model.getMouldName());

					tableData.add(oneRow);
				}
				table.setModel(new DefaultTableModel(tableData, tableHeaders));
				session1.close();
				sessionFactory1.close();

			}
		});
		button_1.setIcon(new ImageIcon(ComponentMaster.class.getResource("/inventory/view all.png")));
		button_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		button_1.setBounds(112, 0, 116, 29);
		contentPane.add(button_1);

		button_2 = new JButton("Delete");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
				Session session = sessionFactory.openSession();
				session.beginTransaction();
				ComponentModel componentModel = new ComponentModel();
				componentModel.setPartCode(comPartCode.getText());
				
				int result = JOptionPane.showConfirmDialog(null,
						"Are you sure you delete   " + comPartCode.getText() + "  ?", null, JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.YES_OPTION) {
				
				session.delete(componentModel);
				session.getTransaction().commit();
				
				}
				session.close();
				sessionFactory.close();

				SessionFactory sessionFactory1 = new Configuration().configure().buildSessionFactory();
				Session session1 = sessionFactory1.openSession();
				session1.beginTransaction();

				@SuppressWarnings("unchecked")
				List<ComponentModel> products = session1.createQuery("from ComponentModel").list();

				Vector<String> tableHeaders = new Vector<String>();
				Vector tableData = new Vector();
				tableHeaders.add("cuscode");
				tableHeaders.add("cusname");
				tableHeaders.add("rawcode");
				tableHeaders.add("rawname");
				tableHeaders.add("component name");
				tableHeaders.add("component part no");
				tableHeaders.add("partcode");
				tableHeaders.add("hsn/sac code");
				tableHeaders.add("norm 1");
				tableHeaders.add("norm 2");
				tableHeaders.add("norm 3");
				tableHeaders.add("norm4");
				tableHeaders.add("from date1");
				tableHeaders.add("from date 2");
				tableHeaders.add("from date 3");
				tableHeaders.add("from date 4");
				tableHeaders.add("to date 1");
				tableHeaders.add("to datte 2");
				tableHeaders.add("to date 3");
				tableHeaders.add("to datte 4");
				tableHeaders.add("amortisation value");
				tableHeaders.add("amortisation from date");
				tableHeaders.add("amortisation qty");
				tableHeaders.add("fettling rate");
				tableHeaders.add("packing mode");
				tableHeaders.add("no of cavities");
				tableHeaders.add("mould code");
				tableHeaders.add("mould name");

				// tableHeaders.add("name");
				for (Object o : products) {
					ComponentModel model = (ComponentModel) o;
					Vector<Object> oneRow = new Vector<Object>();
					oneRow.add(model.getcCode());
					oneRow.add(model.getcName());
					oneRow.add(model.getRawCode());
					oneRow.add(model.getRawName());
					oneRow.add(model.getComponenetName());
					oneRow.add(model.getCompPartno());
					oneRow.add(model.getPartCode());
					oneRow.add(model.getHsnCode());
					oneRow.add(model.getNorm1());
					oneRow.add(model.getNorm2());
					oneRow.add(model.getNorm3());
					oneRow.add(model.getNorm4());
					oneRow.add(model.getFrom1());
					oneRow.add(model.getFrom2());
					oneRow.add(model.getFrom3());
					oneRow.add(model.getFrom4());
					oneRow.add(model.getTo1());
					oneRow.add(model.getTo2());
					oneRow.add(model.getTo3());
					oneRow.add(model.getTo4());

					oneRow.add(model.getAmValue());
					oneRow.add(model.getAmFrom());
					oneRow.add(model.getAmQty());
					oneRow.add(model.getFettlingRate());
					oneRow.add(model.getPackMode());
					oneRow.add(model.getNoCavities());
					oneRow.add(model.getMouldCode());
					oneRow.add(model.getMouldName());

					tableData.add(oneRow);
				}
				table.setModel(new DefaultTableModel(tableData, tableHeaders));
				session1.getTransaction().commit();
				session1.close();
				sessionFactory1.close();
			}
		});
		button_2.setIcon(new ImageIcon(ComponentMaster.class.getResource("/inventory/delete.png")));
		button_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		button_2.setBounds(228, 0, 102, 29);
		contentPane.add(button_2);

		JButton btnNewButton = new JButton("View All");
		btnNewButton.setIcon(new ImageIcon(ComponentMaster.class.getResource("/inventory/view all.png")));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
				Session session = sessionFactory.openSession();
				session.beginTransaction();

				@SuppressWarnings("unchecked")
				List<ComponentModel> products = session.createQuery("from ComponentModel").list();

				Vector<String> tableHeaders = new Vector<String>();
				Vector tableData = new Vector();
				tableHeaders.add("cuscode");
				tableHeaders.add("cusname");
				tableHeaders.add("rawcode");
				tableHeaders.add("rawname");
				tableHeaders.add("component name");
				tableHeaders.add("component part no");
				tableHeaders.add("partcode");
				tableHeaders.add("hsn/sac code");
				tableHeaders.add("norm 1");
				tableHeaders.add("norm 2");
				tableHeaders.add("norm 3");
				tableHeaders.add("norm4");
				tableHeaders.add("from date1");
				tableHeaders.add("from date 2");
				tableHeaders.add("from date 3");
				tableHeaders.add("from date 4");
				tableHeaders.add("to date 1");
				tableHeaders.add("to datte 2");
				tableHeaders.add("to date 3");
				tableHeaders.add("to datte 4");
				tableHeaders.add("amortisation value");
				tableHeaders.add("amortisation from date");
				tableHeaders.add("amortisation to date");
				tableHeaders.add("fettling rate");
				tableHeaders.add("packing mode");
				tableHeaders.add("no of cavities");
				tableHeaders.add("mould code");
				tableHeaders.add("mould name");

				// tableHeaders.add("name");
				for (Object o : products) {
					ComponentModel model = (ComponentModel) o;
					Vector<Object> oneRow = new Vector<Object>();
					oneRow.add(model.getcCode());
					oneRow.add(model.getcName());
					oneRow.add(model.getRawCode());
					oneRow.add(model.getRawName());
					oneRow.add(model.getComponenetName());
					oneRow.add(model.getCompPartno());
					oneRow.add(model.getPartCode());
					oneRow.add(model.getHsnCode());
					oneRow.add(model.getNorm1());
					oneRow.add(model.getNorm2());
					oneRow.add(model.getNorm3());
					oneRow.add(model.getNorm4());
					oneRow.add(model.getFrom1());
					oneRow.add(model.getFrom2());
					oneRow.add(model.getFrom3());
					oneRow.add(model.getFrom4());
					oneRow.add(model.getTo1());
					oneRow.add(model.getTo2());
					oneRow.add(model.getTo3());
					oneRow.add(model.getTo4());

					oneRow.add(model.getAmValue());
					oneRow.add(model.getAmFrom());
					oneRow.add(model.getAmQty());
					oneRow.add(model.getFettlingRate());
					oneRow.add(model.getPackMode());
					oneRow.add(model.getNoCavities());
					oneRow.add(model.getMouldCode());
					oneRow.add(model.getMouldName());

					tableData.add(oneRow);
				}
				table.setModel(new DefaultTableModel(tableData, tableHeaders));
				session.getTransaction().commit();
				session.close();
				sessionFactory.close();

			}
		});
		btnNewButton.setBounds(334, 0, 109, 29);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) throws java.lang.NullPointerException {

				DefaultTableModel model = (DefaultTableModel) table.getModel();
				int index = table.getSelectedRow();

				cusCombo.setSelectedItem(model.getValueAt(index, 0).toString());
				cusName.setText(model.getValueAt(index, 1).toString());
				rawCombo.setSelectedItem(model.getValueAt(index, 2).toString());
				rawName.setText(model.getValueAt(index, 3).toString());
				comName.setText(model.getValueAt(index, 4).toString());
				comPartno.setText(model.getValueAt(index, 5).toString());

				comPartCode.setText(model.getValueAt(index, 6).toString());
				hsnCode.setText(model.getValueAt(index, 7).toString());

				norm1.setText(model.getValueAt(index, 8).toString());
				norm2.setText(model.getValueAt(index, 9).toString());
				norm3.setText(model.getValueAt(index, 10).toString());
				norm4.setText(model.getValueAt(index, 11).toString());

				String str = model.getValueAt(index, 12).toString();
				// String s=from1.getText();
				String from = str.replace('-', '/');
				// model.getValueAt(index, 12)(new Date(newString));
				from1.setText(from);

				String str1 = model.getValueAt(index, 13).toString();
				// String s=from1.getText();
				String from12 = str1.replace('-', '/');
				from2.setText(from12);

				String str2 = model.getValueAt(index, 14).toString();
				// String s=from1.getText();
				String from13 = str2.replace('-', '/');
				from3.setText(from13);

				String str3 = model.getValueAt(index, 15).toString();
				// String s=from1.getText();
				String from14 = str3.replace('-', '/');
				from4.setText(from14);

				String str4 = model.getValueAt(index, 16).toString();
				// String s=from1.getText();
				String from15 = str4.replace('-', '/');
				to1.setText(from15);

				String str5 = model.getValueAt(index, 17).toString();
				// String s=from1.getText();
				String from16 = str5.replace('-', '/');
				to2.setText(from16);

				String str6 = model.getValueAt(index, 18).toString();
				// String s=from1.getText();
				String from17 = str6.replace('-', '/');
				to3.setText(from17);

				String str7 = model.getValueAt(index, 19).toString();
				// String s=from1.getText();
				String from18 = str7.replace('-', '/');
				to4.setText(from18);

				aValue.setText(model.getValueAt(index, 20).toString());

				String str8 = model.getValueAt(index, 21).toString();
				// String s=from1.getText();
				String from8 = str8.replace('-', '/');
				amFrom.setText(from8);
				amQty.setText(model.getValueAt(index, 22).toString());
				fRate.setText(model.getValueAt(index, 23).toString());
				packMode.setSelectedItem(model.getValueAt(index, 24).toString());

				noCav.setText(model.getValueAt(index, 25).toString());
				mouldCombo.setSelectedItem(model.getValueAt(index, 26).toString());
				mouldName.setText(model.getValueAt(index, 27).toString());
				// session.getTransaction().commit();
				// session.close();
				// sessionFactory.close();
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(ComponentMaster.class.getResource("/inventory/viw.png")));
		btnNewButton_1.setBounds(863, 661, 89, 40);
		contentPane.add(btnNewButton_1);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(73, 30, 619, 21);
		contentPane.add(menuBar);
		
		btnHome = new JButton("Home");
		btnHome.setIcon(new ImageIcon(ComponentMaster.class.getResource("/inventory/home (1).png")));
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				Home home=new Home();
				home.setVisible(true);
			}
		});
		btnHome.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnHome.setBounds(453, 0, 102, 29);
		contentPane.add(btnHome);
	}
}
