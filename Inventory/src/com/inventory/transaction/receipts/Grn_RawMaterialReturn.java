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
import javax.swing.JTable;

public class Grn_RawMaterialReturn extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Grn_RawMaterialReturn frame = new Grn_RawMaterialReturn();
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
	public Grn_RawMaterialReturn() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 873, 541);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCustomerCode = new JLabel("Customer code");
		lblCustomerCode.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblCustomerCode.setBounds(10, 29, 92, 17);
		contentPane.add(lblCustomerCode);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(117, 28, 81, 25);
		contentPane.add(comboBox);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 84, 273, 68);
		contentPane.add(textArea);
		
		JLabel lblGirNo = new JLabel("GIR No");
		lblGirNo.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblGirNo.setBounds(336, 29, 92, 17);
		contentPane.add(lblGirNo);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblDate.setBounds(336, 69, 92, 17);
		contentPane.add(lblDate);
		
		JLabel lblCustomerDC = new JLabel("Customer D c ref");
		lblCustomerDC.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblCustomerDC.setBounds(336, 109, 107, 17);
		contentPane.add(lblCustomerDC);
		
		JLabel lblDate_1 = new JLabel("Date");
		lblDate_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblDate_1.setBounds(336, 148, 29, 17);
		contentPane.add(lblDate_1);
		
		JLabel lblInspectionReportNo = new JLabel("Inspection Report No");
		lblInspectionReportNo.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblInspectionReportNo.setBounds(331, 193, 130, 17);
		contentPane.add(lblInspectionReportNo);
		
		textField = new JTextField();
		textField.setBounds(478, 28, 148, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(478, 68, 148, 20);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(478, 108, 148, 20);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(478, 147, 148, 20);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(483, 192, 148, 20);
		contentPane.add(textField_4);
		
		table = new JTable();
		table.setBounds(10, 238, 837, 209);
		contentPane.add(table);
	}

}
