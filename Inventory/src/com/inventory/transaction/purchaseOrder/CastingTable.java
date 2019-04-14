package com.inventory.transaction.purchaseOrder;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.inventory.frames.ComponentMaster;
import com.inventory.model.CastingTableModel;
import com.inventory.model.ComponentModel;
import com.inventory.model.VendorModel;

import javassist.runtime.Desc;

public class CastingTable extends JFrame {

	private JPanel contentPane;
	private JTextField des;
	private JTextField q;
	private JTextField u;
	private JTextField ur;
	private JTextField a;
	private JTextField igst;
	private JTextField cgst;
	private JTextField sgst;
	private 	JComboBox comboBox;
	private JComboBox comboBox_1;
	private JTextField norm;
	private JTextField re;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CastingTable frame = new CastingTable();
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
	public CastingTable() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				
				

				SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
				// SessionFactc=
				Session session = sessionFactory.openSession();
				session.beginTransaction();
				
				
				
				List<ComponentModel> component = session.createQuery(" from ComponentModel ").list();
				// System.out.println(customerModel.get());
				DefaultComboBoxModel coModel1 = (DefaultComboBoxModel)comboBox.getModel();

				for (ComponentModel componentModel : component) {

					coModel1.addElement(componentModel.getPartCode());

				comboBox.setModel(coModel1);

				}
				
				
				
				
				
				List<VendorModel> products = session.createQuery(" from VendorModel ").list();
				// System.out.println(customerModel.get());
				DefaultComboBoxModel coModel = (DefaultComboBoxModel) comboBox_1.getModel();

				for (VendorModel customerModel1 : products) {

					coModel.addElement(customerModel1.getCode());

					comboBox_1.setModel(coModel);

				}
				
				
				
				
				
				
				
				
				
				
				
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 754, 455);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBounds(0, 11, 739, 350);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("code");
		label.setBounds(25, 80, 91, 14);
		label.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panel.add(label);
		
		JLabel label_1 = new JLabel("description");
		label_1.setBounds(308, 80, 91, 14);
		label_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panel.add(label_1);
		
		JLabel lblUom = new JLabel("UOM");
		lblUom.setBounds(25, 157, 91, 14);
		lblUom.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panel.add(lblUom);
		
		JLabel label_4 = new JLabel("unit rate");
		label_4.setBounds(308, 157, 91, 14);
		label_4.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panel.add(label_4);
		
		JLabel label_5 = new JLabel("");
		label_5.setBounds(308, 205, 91, 14);
		label_5.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panel.add(label_5);
		
		JLabel label_6 = new JLabel("amount");
		label_6.setBounds(25, 205, 91, 14);
		label_6.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panel.add(label_6);
		
		JLabel label_7 = new JLabel("Igst");
		label_7.setBounds(308, 205, 91, 14);
		
	
		label_7.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panel.add(label_7);
		
		JLabel label_8 = new JLabel("cgst");
		label_8.setBounds(25, 239, 91, 14);
		label_8.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panel.add(label_8);
		
		JLabel label_9 = new JLabel("sgst");
		label_9.setBounds(308, 239, 91, 14);
		label_9.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panel.add(label_9);
		
		des = new JTextField();
		des.setBounds(413, 78, 260, 20);
		des.setColumns(10);
		panel.add(des);
		
		q = new JTextField();
		q.setBounds(126, 109, 120, 20);
		q.setColumns(10);
		panel.add(q);
		
		u = new JTextField();
		u.setBounds(126, 155, 120, 20);
		u.setColumns(10);
		panel.add(u);
		
		ur = new JTextField();
		ur.setBounds(413, 155, 120, 20);
		ur.setColumns(10);
		panel.add(ur);
		ur.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void changedUpdate(DocumentEvent arg0) {
			int qnty=Integer.parseInt(q.getText());
			int unts=Integer.parseInt(u.getText());
			int unrate=Integer.parseInt(ur.getText());
			
			int amnt=qnty*unrate;	
				
				a.setText(String.valueOf(amnt));
			}

			@Override
			public void insertUpdate(DocumentEvent arg0) {
				int qnty=Integer.parseInt(q.getText());
				int unts=Integer.parseInt(u.getText());
				int unrate=Integer.parseInt(ur.getText());
				
				int amnt=qnty*unrate;	
					
					a.setText(String.valueOf(amnt));
			}

			@Override
			public void removeUpdate(DocumentEvent arg0) {
				int qnty=Integer.parseInt(q.getText());
				int unts=Integer.parseInt(u.getText());
				int unrate=Integer.parseInt(ur.getText());
				
				int amnt=qnty*unrate;	
					
					a.setText(String.valueOf(amnt));
			}
			
				
		});
	
	
		a = new JTextField();
		a.setBounds(126, 205, 120, 20);
		a.setColumns(10);
		panel.add(a);
		
		igst = new JTextField();
		igst.setBounds(409, 205, 120, 20);
		igst.setColumns(10);
		panel.add(igst);
		
		igst.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void insertUpdate(DocumentEvent arg0) {
				

				if (Float.parseFloat(igst.getText()) > 0) {
					float val = (Float.parseFloat(igst.getText()));
					float ha = val / 2;
					sgst.setText(String.valueOf(ha));
					cgst.setText(String.valueOf(ha));
				} else {
					igst.setText(String.valueOf(0));
					cgst.setText(String.valueOf(0));
					sgst.setText(String.valueOf(0));

				}
			}

			@Override
			public void removeUpdate(DocumentEvent arg0) {
				
				if (Float.parseFloat(igst.getText()) > 0) {
					float val = (Float.parseFloat(igst.getText()));
					float ha = val / 2;
					sgst.setText(String.valueOf(ha));
					cgst.setText(String.valueOf(ha));
				} else {
					igst.setText(String.valueOf(0));
					cgst.setText(String.valueOf(0));
					sgst.setText(String.valueOf(0));

				}
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				
				if (Float.parseFloat(igst.getText()) > 0) {
					float val = (Float.parseFloat(igst.getText()));
					float ha = val / 2;
					sgst.setText(String.valueOf(ha));
					cgst.setText(String.valueOf(ha));
				} else {
					igst.setText(String.valueOf(0));
					cgst.setText(String.valueOf(0));
					sgst.setText(String.valueOf(0));

				}
			}

		});
		cgst = new JTextField();
		cgst.setBounds(126, 237, 120, 20);
		cgst.setColumns(10);
		panel.add(cgst);
		
		sgst = new JTextField();
		sgst.setBounds(409, 237, 120, 20);
		sgst.setColumns(10);
		panel.add(sgst);
		
		 comboBox = new JComboBox();
		 comboBox.setBounds(126, 78, 91, 20);
		 comboBox.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		
		 		

				SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
				Session session = sessionFactory.openSession();
				session.beginTransaction();
				String part = comboBox.getSelectedItem().toString();
				ComponentModel co=(ComponentModel)session.get(ComponentModel.class, part);
				des.setText(co .getComponenetName());
				session.getTransaction().commit();
				session.close();
				sessionFactory.close();

		 	
		 		
		 		
		 		
		 		
		 		
		 		
		 		
		 		
		 		
		 		
		 		
		 	}
		 });
		panel.add(comboBox);
		
		JButton button = new JButton("add");
		button.setBounds(205, 322, 89, 23);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				

				SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
				Session session = sessionFactory.openSession();
				session.beginTransaction();
				CastingTableModel model=new CastingTableModel();
				model.setPart_code(comboBox.getSelectedItem().toString());
				model.setV_code(comboBox_1.getSelectedItem().toString());
				model.setAmount(Long.parseLong(a.getText()));
				model.setPart_des(des.getText());
				model.setQty(Integer.parseInt(q.getText()));
				model.setUom(Integer.parseInt(u.getText()));
				model.setRate(Integer.parseInt(ur.getText()));
				model.setIgst(Double.parseDouble(igst.getText()));
				model.setSgst(Double.parseDouble(sgst.getText()));
				model.setCgst(Double.parseDouble(cgst.getText()));

				session.save(model);
				session.getTransaction().commit();
				session.close();
				sessionFactory.close();
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
			}
		});
		panel.add(button);
		
		comboBox_1 = new JComboBox();
		comboBox_1.setBounds(131, 28, 98, 20);
		panel.add(comboBox_1);
		
		JLabel label_2 = new JLabel("quantity");
		label_2.setBounds(25, 115, 91, 14);
		panel.add(label_2);
		label_2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		
		JLabel lblNewLabel = new JLabel("vendorCode");
		lblNewLabel.setBounds(25, 31, 68, 14);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel.add(lblNewLabel);
		
		JLabel norms = new JLabel("norms");
		norms.setBounds(25, 288, 91, 14);
		norms.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panel.add(norms);
		
		JLabel remarks = new JLabel("remarks");
		remarks.setBounds(308, 289, 91, 14);
		remarks.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panel.add(remarks);
		
		norm = new JTextField();
		norm.setBounds(126, 286, 120, 20);
		norm.setColumns(10);
		panel.add(norm);
		
		re = new JTextField();
		re.setBounds(413, 286, 120, 20);
		re.setColumns(10);
		panel.add(re);
	}
}
