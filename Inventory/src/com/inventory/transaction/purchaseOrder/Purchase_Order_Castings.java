package com.inventory.transaction.purchaseOrder;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.inventory.model.ComponentModel;
import com.inventory.model.CustomerModel;
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
import java.util.List;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;

public class Purchase_Order_Castings extends JFrame {
	JTextArea address;
	private JPanel contentPane;
	JComboBox vendorCombo;
	private JTextField pono;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTable table;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;

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
				DefaultComboBoxModel coModel = (DefaultComboBoxModel) vendorCombo.getModel();

				for (VendorModel vendor : products) {

					coModel.addElement(vendor.getCode());

					vendorCombo.setModel(coModel);

				}
				Po_CastingModel po=new Po_CastingModel();
				pono.setText(String.valueOf(po.getPo_no()));

			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1105, 646);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Vendor Code");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel.setBounds(10, 22, 101, 14);
		contentPane.add(lblNewLabel);

		vendorCombo = new JComboBox();
		vendorCombo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
				Session session = sessionFactory.openSession();
				session.beginTransaction();
				String part = vendorCombo.getSelectedItem().toString();
				VendorModel vendor = (VendorModel) session.get(VendorModel.class, part);
				address.setText(vendor.getAddress());
				session.getTransaction().commit();
				session.close();
				sessionFactory.close();

			}
		});
		vendorCombo.setBounds(105, 20, 58, 20);
		contentPane.add(vendorCombo);

		address = new JTextArea();
		address.setBounds(10, 65, 264, 73);
		contentPane.add(address);

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

		textField_1 = new JTextField();
		textField_1.setBounds(565, 65, 185, 28);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Order valid upto");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3.setBounds(419, 109, 100, 15);
		contentPane.add(lblNewLabel_3);

		textField_2 = new JTextField();
		textField_2.setBounds(565, 104, 185, 26);
		contentPane.add(textField_2);
		textField_2.setColumns(10);

		JLabel lblYourReference = new JLabel("Your Reference");
		lblYourReference.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblYourReference.setBounds(419, 137, 100, 15);
		contentPane.add(lblYourReference);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(565, 141, 185, 26);
		contentPane.add(textField_3);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 206, 993, 204);
		contentPane.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		JLabel lblSpecialInstruction = new JLabel("special  Instruction");
		lblSpecialInstruction.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSpecialInstruction.setBounds(10, 421, 100, 15);
		contentPane.add(lblSpecialInstruction);

		textField_4 = new JTextField();
		textField_4.setBounds(130, 415, 589, 28);
		contentPane.add(textField_4);
		textField_4.setColumns(10);

		JLabel lblDelivery = new JLabel("delivery");
		lblDelivery.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDelivery.setBounds(11, 457, 100, 15);
		contentPane.add(lblDelivery);

		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(105, 452, 185, 26);
		contentPane.add(textField_5);

		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(432, 452, 185, 26);
		contentPane.add(textField_6);

		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(735, 452, 185, 26);
		contentPane.add(textField_7);

		JLabel lblDeliveryPoint = new JLabel("delivery point");
		lblDeliveryPoint.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDeliveryPoint.setBounds(315, 455, 100, 18);
		contentPane.add(lblDeliveryPoint);

		JLabel lblInsurance = new JLabel("Insurance");
		lblInsurance.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblInsurance.setBounds(640, 454, 100, 20);
		contentPane.add(lblInsurance);

		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(128, 502, 185, 26);
		contentPane.add(textField_8);

		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(495, 502, 185, 26);
		contentPane.add(textField_9);

		JLabel lblTransport = new JLabel("Transport");
		lblTransport.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTransport.setBounds(408, 505, 100, 18);
		contentPane.add(lblTransport);

		JLabel lblPaymentTerm = new JLabel("payment Term");
		lblPaymentTerm.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPaymentTerm.setBounds(11, 508, 100, 18);
		contentPane.add(lblPaymentTerm);

		JMenuItem menuItem = new JMenuItem("save");
		menuItem.setIcon(new ImageIcon(Purchase_Order_Castings.class.getResource("/inventory/save.png")));
		menuItem.setFont(new Font("Arial", Font.BOLD, 14));
		menuItem.setBounds(56, 555, 82, 26);
		contentPane.add(menuItem);

		JMenuItem menuItem_2 = new JMenuItem("Update");
		menuItem_2.setIcon(new ImageIcon(Purchase_Order_Castings.class.getResource("/inventory/update.png")));
		menuItem_2.setFont(new Font("Arial", Font.BOLD, 14));
		menuItem_2.setBounds(184, 552, 129, 29);
		contentPane.add(menuItem_2);

		JMenuItem menuItem_3 = new JMenuItem("Delete");
		menuItem_3.setIcon(new ImageIcon(Purchase_Order_Castings.class.getResource("/inventory/delete.png")));
		menuItem_3.setFont(new Font("Arial", Font.BOLD, 14));
		menuItem_3.setBounds(323, 555, 129, 29);
		contentPane.add(menuItem_3);
	}
}
