package com.inventory.transaction.purchaseOrder;

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
import javax.swing.JMenuItem;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PoRawMaterial extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
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
					PoRawMaterial frame = new PoRawMaterial();
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
	public PoRawMaterial() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1143, 772);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBounds(10, 11, 1031, 607);
		contentPane.add(panel);
		
		JLabel label = new JLabel("Vendor Code");
		label.setFont(new Font("Times New Roman", Font.BOLD, 14));
		label.setBounds(10, 22, 101, 14);
		panel.add(label);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(105, 20, 58, 20);
		panel.add(comboBox);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 65, 303, 87);
		panel.add(textArea);
		
		JLabel label_1 = new JLabel("P.o.No");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_1.setBounds(432, 20, 46, 17);
		panel.add(label_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(565, 20, 185, 26);
		panel.add(textField);
		
		JLabel label_2 = new JLabel("Date");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_2.setBounds(432, 65, 46, 14);
		panel.add(label_2);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(565, 65, 185, 28);
		panel.add(textField_1);
		
		JLabel label_3 = new JLabel("Order valid upto");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_3.setBounds(419, 109, 100, 15);
		panel.add(label_3);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(565, 104, 185, 26);
		panel.add(textField_2);
		
		JLabel label_4 = new JLabel("Your Reference");
		label_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_4.setBounds(419, 137, 100, 15);
		panel.add(label_4);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(565, 141, 185, 26);
		panel.add(textField_3);
		
		table = new JTable();
		table.setBounds(10, 193, 1011, 204);
		panel.add(table);
		
		JLabel label_5 = new JLabel("special  Instruction");
		label_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_5.setBounds(10, 421, 117, 15);
		panel.add(label_5);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(173, 421, 589, 28);
		panel.add(textField_4);
		
		JLabel label_6 = new JLabel("delivery");
		label_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_6.setBounds(11, 457, 100, 15);
		panel.add(label_6);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(105, 452, 185, 26);
		panel.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(432, 452, 185, 26);
		panel.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(735, 452, 185, 26);
		panel.add(textField_7);
		
		JLabel label_7 = new JLabel("delivery point");
		label_7.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_7.setBounds(315, 455, 100, 18);
		panel.add(label_7);
		
		JLabel label_8 = new JLabel("Insurance");
		label_8.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_8.setBounds(640, 454, 100, 20);
		panel.add(label_8);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(128, 502, 185, 26);
		panel.add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(495, 502, 185, 26);
		panel.add(textField_9);
		
		JLabel label_9 = new JLabel("Transport");
		label_9.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_9.setBounds(408, 505, 100, 18);
		panel.add(label_9);
		
		JLabel label_10 = new JLabel("payment Term");
		label_10.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_10.setBounds(11, 508, 100, 18);
		panel.add(label_10);
		
		JMenuItem menuItem = new JMenuItem("save");
		menuItem.setFont(new Font("Arial", Font.BOLD, 14));
		menuItem.setBounds(56, 555, 82, 26);
		panel.add(menuItem);
		
		JMenuItem menuItem_1 = new JMenuItem("Update");
		menuItem_1.setFont(new Font("Arial", Font.BOLD, 14));
		menuItem_1.setBounds(184, 552, 129, 29);
		panel.add(menuItem_1);
		
		JMenuItem menuItem_2 = new JMenuItem("Delete");
		menuItem_2.setFont(new Font("Arial", Font.BOLD, 14));
		menuItem_2.setBounds(323, 555, 129, 29);
		panel.add(menuItem_2);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PORawTable raw=new PORawTable();
				raw.setVisible(true);
				
			}
		});
		btnNewButton.setIcon(new ImageIcon(PoRawMaterial.class.getResource("/inventory/add.png")));
		btnNewButton.setBounds(1039, 227, 81, 35);
		contentPane.add(btnNewButton);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setIcon(new ImageIcon(PoRawMaterial.class.getResource("/inventory/delete.png")));
		btnDelete.setBounds(1039, 329, 87, 29);
		contentPane.add(btnDelete);
		
		JButton btnView = new JButton("View");
		btnView.setIcon(new ImageIcon(PoRawMaterial.class.getResource("/inventory/viw.png")));
		btnView.setBounds(1039, 282, 78, 29);
		contentPane.add(btnView);
	}
}
