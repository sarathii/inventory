package com.inventory.transaction.receipts;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTable;

public class Grn_Casting extends JFrame {

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
					Grn_Casting frame = new Grn_Casting();
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
	public Grn_Casting() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 934, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("MaterialFrom");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel.setBounds(10, 31, 85, 17);
		contentPane.add(lblNewLabel);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Customer");
		rdbtnNewRadioButton.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		rdbtnNewRadioButton.setBounds(120, 29, 81, 25);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Vendor");
		rdbtnNewRadioButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		rdbtnNewRadioButton_1.setBounds(218, 29, 67, 25);
		contentPane.add(rdbtnNewRadioButton_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 121, 275, 70);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_1.setBounds(10, 68, 102, 25);
		contentPane.add(lblNewLabel_1);
		
		JLabel label = new JLabel("");
		label.setFont(new Font("Times New Roman", Font.BOLD, 14));
		label.setBounds(264, 61, 111, 25);
		contentPane.add(label);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(120, 68, 81, 25);
		contentPane.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(413, 68, 102, 25);
		contentPane.add(comboBox_1);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblDate.setBounds(542, 68, 29, 17);
		contentPane.add(lblDate);
		
		textField = new JTextField();
		textField.setBounds(594, 68, 119, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblGrnNo = new JLabel("GRN No");
		lblGrnNo.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblGrnNo.setBounds(319, 126, 49, 17);
		contentPane.add(lblGrnNo);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(413, 125, 86, 20);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(594, 125, 119, 20);
		contentPane.add(textField_2);
		
		JLabel label_1 = new JLabel("Date");
		label_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		label_1.setBounds(542, 126, 29, 17);
		contentPane.add(label_1);
		
		JLabel lblYourDcRef = new JLabel("your Dc Ref:");
		lblYourDcRef.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblYourDcRef.setBounds(319, 164, 79, 17);
		contentPane.add(lblYourDcRef);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(413, 163, 86, 20);
		contentPane.add(textField_3);
		
		JLabel label_2 = new JLabel("Date");
		label_2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		label_2.setBounds(536, 163, 29, 17);
		contentPane.add(label_2);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(594, 163, 119, 20);
		contentPane.add(textField_4);
		
		JLabel lblOurDcRef = new JLabel("our Dc Ref");
		lblOurDcRef.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblOurDcRef.setBounds(319, 216, 79, 17);
		contentPane.add(lblOurDcRef);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(408, 215, 102, 25);
		contentPane.add(comboBox_2);
		
		JLabel label_3 = new JLabel("Date");
		label_3.setFont(new Font("Times New Roman", Font.BOLD, 14));
		label_3.setBounds(536, 213, 29, 17);
		contentPane.add(label_3);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(594, 213, 119, 20);
		contentPane.add(textField_5);
		
		JLabel lblPendingOurDc = new JLabel("Pending our Dc Component");
		lblPendingOurDc.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblPendingOurDc.setBounds(232, 274, 169, 17);
		contentPane.add(lblPendingOurDc);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(413, 273, 86, 20);
		contentPane.add(textField_6);
		
		JLabel lblCastingStatus = new JLabel("Casting Status");
		lblCastingStatus.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblCastingStatus.setBounds(12, 212, 90, 17);
		contentPane.add(lblCastingStatus);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("rawcasting");
		rdbtnNewRadioButton_2.setBounds(23, 247, 109, 23);
		contentPane.add(rdbtnNewRadioButton_2);
		
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("finished");
		rdbtnNewRadioButton_3.setBounds(23, 300, 109, 23);
		contentPane.add(rdbtnNewRadioButton_3);
		
		JRadioButton radioButton = new JRadioButton("semi finished");
		radioButton.setBounds(23, 272, 109, 23);
		contentPane.add(radioButton);
		
		JRadioButton rdbtnReWorkrejection = new JRadioButton("Re work/Rejection");
		rdbtnReWorkrejection.setBounds(23, 326, 109, 23);
		contentPane.add(rdbtnReWorkrejection);
		
		table = new JTable();
		table.setBounds(10, 382, 840, 168);
		contentPane.add(table);
	}
}
