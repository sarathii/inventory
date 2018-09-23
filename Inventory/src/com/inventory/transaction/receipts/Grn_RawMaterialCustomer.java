package com.inventory.transaction.receipts;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JTable;

public class Grn_RawMaterialCustomer extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Grn_RawMaterialCustomer frame = new Grn_RawMaterialCustomer();
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
	public Grn_RawMaterialCustomer() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 919, 536);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblVendorCode = new JLabel("vendor code");
		lblVendorCode.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblVendorCode.setBounds(10, 21, 85, 17);
		contentPane.add(lblVendorCode);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(117, 20, 81, 25);
		contentPane.add(comboBox);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 76, 273, 68);
		contentPane.add(textArea);
		
		JLabel label = new JLabel("GRN No");
		label.setFont(new Font("Times New Roman", Font.BOLD, 14));
		label.setBounds(361, 87, 49, 17);
		contentPane.add(label);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(455, 86, 86, 20);
		contentPane.add(textField);
		
		JLabel label_1 = new JLabel("Date");
		label_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		label_1.setBounds(584, 87, 29, 17);
		contentPane.add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(636, 86, 119, 20);
		contentPane.add(textField_1);
		
		JLabel lblDcinvoiceNo = new JLabel("Dc/Invoice No");
		lblDcinvoiceNo.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblDcinvoiceNo.setBounds(361, 125, 85, 17);
		contentPane.add(lblDcinvoiceNo);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(455, 124, 86, 20);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(636, 124, 119, 20);
		contentPane.add(textField_3);
		
		JLabel label_3 = new JLabel("Date");
		label_3.setFont(new Font("Times New Roman", Font.BOLD, 14));
		label_3.setBounds(578, 124, 29, 17);
		contentPane.add(label_3);
		
		JLabel lblPurchaseOrderref = new JLabel("Purchase OrderRef");
		lblPurchaseOrderref.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblPurchaseOrderref.setBounds(307, 37, 119, 17);
		contentPane.add(lblPurchaseOrderref);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(455, 36, 86, 20);
		contentPane.add(textField_4);
		
		JLabel label_5 = new JLabel("Date");
		label_5.setFont(new Font("Times New Roman", Font.BOLD, 14));
		label_5.setBounds(578, 36, 29, 17);
		contentPane.add(label_5);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(636, 36, 119, 20);
		contentPane.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(455, 162, 86, 20);
		contentPane.add(textField_6);
		
		JLabel lblReceivedOn = new JLabel("Received on");
		lblReceivedOn.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblReceivedOn.setBounds(361, 165, 79, 17);
		contentPane.add(lblReceivedOn);
		
		JRadioButton rdbtnPurchase = new JRadioButton("purchase");
		rdbtnPurchase.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		rdbtnPurchase.setBounds(307, 196, 81, 25);
		contentPane.add(rdbtnPurchase);
		
		JRadioButton rdbtnRawMaterialreturn = new JRadioButton("Raw Material Return");
		rdbtnRawMaterialreturn.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		rdbtnRawMaterialreturn.setBounds(437, 196, 143, 25);
		contentPane.add(rdbtnRawMaterialreturn);
		
		table = new JTable();
		table.setBounds(10, 250, 883, 172);
		contentPane.add(table);
	}

}
