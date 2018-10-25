package com.inventory.frames;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField admin;
	private JPasswordField pass;
	JLabel vali;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setForeground(new Color(0, 255, 255));
		setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 18));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 738, 473);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblInventorySystem = new JLabel("Inventory System");
		lblInventorySystem.setForeground(new Color(0, 255, 255));
		lblInventorySystem.setFont(new Font("Arial Black", Font.ITALIC, 16));
		lblInventorySystem.setBounds(195, 27, 171, 23);
		contentPane.add(lblInventorySystem);

		admin = new JTextField();
		admin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		admin.setColumns(10);
		admin.setBounds(198, 97, 256, 29);
		contentPane.add(admin);

		JButton btnNewButton = new JButton("login");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if ((admin.getText().length() <= 15)
						&& (pass.getText().length() >= 5 && pass.getText().length() <= 8)) {
					if (admin.getText().equals("admin") && pass.getText().equals("admin")) {
					dispose();
						Home home = new Home();
						home.setVisible(true);
						// this.dispatchEvent(new WindowEvent(this,
						// WindowEvent.WINDOW_CLOSING));

					} else {
						vali.setText("admin and password name incorrect");
						vali.setForeground(new Color(0, 255, 255));
						vali.setForeground(new Color(0, 255, 255));
						admin.setText("");
						pass.setText("");
					}
				} else {
					vali.setText("*invalid admin id or password");
					vali.setForeground(new Color(0, 255, 255));
					vali.setForeground(new Color(0, 255, 255));
					admin.setText("");
					pass.setText("");
				}
			}

		});
		btnNewButton.setBackground(new Color(30, 144, 255));
		btnNewButton.setBounds(251, 283, 98, 29);
		contentPane.add(btnNewButton);

		JLabel lblAdmin = new JLabel("Admin");
		lblAdmin.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblAdmin.setForeground(new Color(0, 255, 255));
		lblAdmin.setBounds(58, 106, 43, 19);
		contentPane.add(lblAdmin);

		pass = new JPasswordField();
		pass.setFont(new Font("Tahoma", Font.PLAIN, 15));
		pass.setForeground(new Color(0, 0, 0));
		pass.setEchoChar('*');
		pass.setBounds(198, 178, 256, 29);
		contentPane.add(pass);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(Color.CYAN);
		lblPassword.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblPassword.setBounds(58, 185, 63, 19);
		contentPane.add(lblPassword);

		vali = new JLabel("");
		vali.setBounds(58, 237, 419, 35);
		contentPane.add(vali);
	}
}
