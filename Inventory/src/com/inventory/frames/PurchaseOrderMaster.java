package com.inventory.frames;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.inventory.model.ComponentModel;
import com.inventory.model.CustomerModel;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

public class PurchaseOrderMaster extends JFrame {
	private JComboBox cusCombo;
	private JComboBox partCombo;
	private JPanel contentPane;
	private JTextField cusName;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField hsn;
	private JTextField igst;
	private JTextField cgst;
	private JTextField sgst;

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
		setBounds(100, 100, 869, 476);
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

		textField_1 = new JTextField();
		textField_1.setBounds(199, 135, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(293, 135, 86, 20);
		contentPane.add(textField_2);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(389, 135, 86, 20);
		contentPane.add(textField_3);

		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(485, 135, 86, 20);
		contentPane.add(textField_4);

		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(581, 135, 86, 20);
		contentPane.add(textField_5);

		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(677, 135, 86, 20);
		contentPane.add(textField_6);

		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(773, 135, 70, 20);
		contentPane.add(textField_7);

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
				
				
				
				if(Float.parseFloat(igst.getText())>0){
					float val=(Float.parseFloat(igst.getText()));
					float ha=val/2;
					sgst.setText(String.valueOf(ha));
					cgst.setText(String.valueOf(ha));
					}
					else
					{
						igst.setText(String.valueOf(0));
						cgst.setText(String.valueOf(0));
						sgst.setText(String.valueOf(0));
						
					}
			}

			@Override
			public void removeUpdate(DocumentEvent arg0) {
				// TODO Auto-generated method stub
				if(Float.parseFloat(igst.getText())>0){
				float val=(Float.parseFloat(igst.getText()));
				float ha=val/2;
				sgst.setText(String.valueOf(ha));
				cgst.setText(String.valueOf(ha));
				}
				else
				{
					igst.setText(String.valueOf(0));
					cgst.setText(String.valueOf(0));
					sgst.setText(String.valueOf(0));
					
				}
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				if(Float.parseFloat(igst.getText())>0){
					float val=(Float.parseFloat(igst.getText()));
					float ha=val/2;
					sgst.setText(String.valueOf(ha));
					cgst.setText(String.valueOf(ha));
					}
					else
					{
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
	}
}
