package com.inventory.frames;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.JToggleButton;
import javax.swing.JTextPane;

public class Vendor extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;

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
		setBounds(100, 100, 1200, 800);
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
		
		textField = new JTextField();
		textField.setFont(new Font("Monospaced", Font.PLAIN, 16));
		textField.setBounds(101, 80, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Monospaced", Font.PLAIN, 16));
		textField_1.setBounds(99, 117, 259, 28);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
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
		lblPincode.setBounds(9, 287, 56, 19);
		contentPane.add(lblPincode);
		
		JLabel lblContact = new JLabel("Contact");
		lblContact.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblContact.setBounds(10, 321, 52, 19);
		contentPane.add(lblContact);
		
		JLabel lblDesignation = new JLabel("Designation");
		lblDesignation.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblDesignation.setBounds(10, 370, 80, 19);
		contentPane.add(lblDesignation);
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 16));
		textArea.setLineWrap(true);
		textArea.setBounds(99, 164, 259, 53);
		contentPane.add(textArea);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Monospaced", Font.PLAIN, 16));
		textField_2.setBounds(101, 245, 246, 28);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Monospaced", Font.PLAIN, 16));
		textField_3.setColumns(10);
		textField_3.setBounds(101, 284, 246, 28);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Monospaced", Font.PLAIN, 16));
		textField_4.setColumns(10);
		textField_4.setBounds(101, 318, 246, 28);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Monospaced", Font.PLAIN, 16));
		textField_5.setColumns(10);
		textField_5.setBounds(101, 371, 246, 28);
		contentPane.add(textField_5);
		
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
		lblRemarks.setBounds(473, 79, 86, 19);
		contentPane.add(lblRemarks);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setFont(new Font("Monospaced", Font.PLAIN, 16));
		textArea_1.setLineWrap(true);
		textArea_1.setBounds(473, 119, 391, 152);
		contentPane.add(textArea_1);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(398, 93, 1, 263);
		contentPane.add(separator_3);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(425, 93, 1, 254);
		contentPane.add(separator_2);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(10, 429, 856, 2);
		contentPane.add(separator_4);
		
		JLabel lblNewLabel_1 = new JLabel("Office");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_1.setBounds(10, 445, 41, 19);
		contentPane.add(lblNewLabel_1);
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textField_6.setColumns(10);
		textField_6.setBounds(101, 442, 197, 28);
		contentPane.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textField_7.setColumns(10);
		textField_7.setBounds(398, 442, 197, 28);
		contentPane.add(textField_7);
		
		JLabel lblFactory = new JLabel("Factory");
		lblFactory.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblFactory.setBounds(633, 442, 51, 19);
		contentPane.add(lblFactory);
		
		textField_8 = new JTextField();
		textField_8.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textField_8.setColumns(10);
		textField_8.setBounds(704, 442, 154, 28);
		contentPane.add(textField_8);
		
		JLabel lblMobile = new JLabel("Mobile");
		lblMobile.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblMobile.setBounds(17, 489, 48, 19);
		contentPane.add(lblMobile);
		
		textField_9 = new JTextField();
		textField_9.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textField_9.setColumns(10);
		textField_9.setBounds(101, 481, 197, 28);
		contentPane.add(textField_9);
		
		JLabel label_1 = new JLabel("Fax");
		label_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		label_1.setBounds(332, 445, 41, 19);
		contentPane.add(label_1);
		
		JLabel lblPager = new JLabel("Pager");
		lblPager.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblPager.setBounds(335, 489, 48, 19);
		contentPane.add(lblPager);
		
		textField_10 = new JTextField();
		textField_10.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textField_10.setColumns(10);
		textField_10.setBounds(398, 481, 197, 28);
		contentPane.add(textField_10);
		
		JSeparator separator_5 = new JSeparator();
		separator_5.setBounds(10, 536, 856, 2);
		contentPane.add(separator_5);
		
		textField_11 = new JTextField();
		textField_11.setFont(new Font("Monospaced", Font.PLAIN, 16));
		textField_11.setColumns(10);
		textField_11.setBounds(101, 549, 197, 28);
		contentPane.add(textField_11);
		
		textField_12 = new JTextField();
		textField_12.setFont(new Font("Monospaced", Font.PLAIN, 16));
		textField_12.setColumns(10);
		textField_12.setBounds(101, 598, 197, 28);
		contentPane.add(textField_12);
		
		textField_13 = new JTextField();
		textField_13.setFont(new Font("Monospaced", Font.PLAIN, 16));
		textField_13.setColumns(10);
		textField_13.setBounds(430, 549, 197, 28);
		contentPane.add(textField_13);
		
		textField_14 = new JTextField();
		textField_14.setFont(new Font("Monospaced", Font.PLAIN, 16));
		textField_14.setColumns(10);
		textField_14.setBounds(430, 598, 197, 28);
		contentPane.add(textField_14);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblEmail.setBounds(17, 556, 48, 19);
		contentPane.add(lblEmail);
		
		JLabel lblEsiCode = new JLabel("ESI code");
		lblEsiCode.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblEsiCode.setBounds(17, 605, 67, 19);
		contentPane.add(lblEsiCode);
		
		JLabel lblUrl = new JLabel("URL");
		lblUrl.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblUrl.setBounds(332, 556, 48, 19);
		contentPane.add(lblUrl);
		
		JLabel lblEccCode = new JLabel("ECC code");
		lblEccCode.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblEccCode.setBounds(332, 605, 67, 19);
		contentPane.add(lblEccCode);
	}
}
