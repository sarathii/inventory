package com.inventory.transaction.receipts;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.DefaultComboBoxModel;

public class ProductionSlip extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProductionSlip frame = new ProductionSlip();
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
	public ProductionSlip() {
		setTitle("purchase order slip");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 803, 545);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("Casting Status");
		label.setFont(new Font("Times New Roman", Font.BOLD, 14));
		label.setBounds(10, 77, 90, 17);
		contentPane.add(label);
		
		JRadioButton radioButton = new JRadioButton("rawcasting");
		radioButton.setBounds(21, 112, 109, 23);
		contentPane.add(radioButton);
		
		JRadioButton radioButton_1 = new JRadioButton("semi finished");
		radioButton_1.setBounds(21, 137, 109, 23);
		contentPane.add(radioButton_1);
		
		JRadioButton radioButton_2 = new JRadioButton("finished");
		radioButton_2.setBounds(21, 165, 109, 23);
		contentPane.add(radioButton_2);
		
		JRadioButton radioButton_3 = new JRadioButton("Re work/Rejection");
		radioButton_3.setBounds(21, 191, 113, 23);
		contentPane.add(radioButton_3);
		
		textField = new JTextField();
		textField.setBounds(305, 76, 167, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("NO");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel.setBounds(201, 79, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblDate.setBounds(509, 79, 46, 14);
		contentPane.add(lblDate);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(562, 76, 167, 20);
		contentPane.add(textField_1);
		
		JLabel lblShift = new JLabel("shift");
		lblShift.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblShift.setBounds(212, 141, 46, 14);
		contentPane.add(lblShift);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"A", "B", "C"}));
		comboBox.setBounds(305, 138, 120, 20);
		contentPane.add(comboBox);
		
		table = new JTable();
		table.setBounds(33, 251, 744, 181);
		contentPane.add(table);
	}

}
