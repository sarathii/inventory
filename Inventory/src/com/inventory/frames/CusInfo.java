package com.inventory.frames;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.List;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.inventory.model.CustomerModel;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CusInfo extends JFrame {

	private JPanel contentPane;
	public JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CusInfo frame = new CusInfo();
					frame.setVisible(true);
					frame.table();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void table() {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		// Query query = session.createQuery("from CustomerModel");
		// List<CustomerModel> customer = session.createQuery("from
		// Custom").list();
		@SuppressWarnings("unchecked")
		List<CustomerModel> products = session.createQuery("from CustomerModel").list();

		Vector<String> tableHeaders = new Vector<String>();
		Vector tableData = new Vector();
		tableHeaders.add("code");
		tableHeaders.add("name");
		tableHeaders.add("address");
		tableHeaders.add("city");
		tableHeaders.add("contact");
		tableHeaders.add("deliver");
		tableHeaders.add("designation");
		tableHeaders.add("destination");
		tableHeaders.add("div");
		tableHeaders.add("ecc");
		tableHeaders.add("email");
		tableHeaders.add("factory");
		tableHeaders.add("fax");
		tableHeaders.add("gst");
		tableHeaders.add("pincode");
		tableHeaders.add("remarks");
		// tableHeaders.add("name");
		for (Object o : products) {
			CustomerModel model = (CustomerModel) o;
			Vector<Object> oneRow = new Vector<Object>();
			oneRow.add(model.getCode());
			oneRow.add(model.getName());
			oneRow.add(model.getAddress());
			oneRow.add(model.getCity());
			oneRow.add(model.getContact());
			oneRow.add(model.getDelivered());
			oneRow.add(model.getDesignation());
			oneRow.add(model.getDestiation());
			oneRow.add(model.getDiv());
			oneRow.add(model.getEcc());
			oneRow.add(model.getEmail());
			oneRow.add(model.getFactory());
			oneRow.add(model.getFax());
			oneRow.add(model.getGst());
			oneRow.add(model.getPinCode());
			oneRow.add(model.getRemarks());

			tableData.add(oneRow);
		}
		table.setModel(new DefaultTableModel(tableData, tableHeaders));

		session.getTransaction().commit();
		// session.flush();
		// it will close the particular session after completing the process
		session.close();
		sessionFactory.close();
	}

	/**
	 * Create the frame.
	 */
	public CusInfo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 941, 578);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel name = new JLabel("");
		name.setBounds(47, 74, 277, 32);
		contentPane.add(name);

		JScrollPane scrollPane = new JScrollPane();

		scrollPane.setBounds(10, 53, 832, 379);
		contentPane.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		JButton btnNewButton = new JButton("Update");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
				Session session = sessionFactory.openSession();
				session.beginTransaction();

				table.getSelectedRow();
				CustomerForm customerForm = new CustomerForm();
				customerForm.main(null);
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				int index = table.getSelectedRow();

				customerForm.code1.setText(model.getValueAt(index, 0).toString());

				session.getTransaction().commit();
				// session.flush();
				// it will close the particular session after completing the
				// process
				session.close();
				sessionFactory.close();

				/*
				 * SessionFactory sessionFactory= new
				 * Configuration().configure().buildSessionFactory(); Session
				 * session = sessionFactory.openSession();
				 * session.beginTransaction();
				 * 
				 * 
				 * table.getSelectedRow(); // CustomerForm customerForm=new
				 * CustomerForm(); // customerForm.main(null);
				 * //DefaultTableModel model=(DefaultTableModel)
				 * table.getModel(); //int index=table.getSelectedRow(); //
				 * model.setValueAt(CustomerForm.code.ge, row, column); //
				 * String s=customerForm.code.setText(model.getValueAt(index,
				 * 0).toString()));
				 * 
				 * 
				 * 
				 * 
				 * int index=table.getSelectedRow(); TableModel
				 * model=table.getModel(); System.out.print("felll"); String
				 * code= model.getValueAt(index, 0).toString(); String name=
				 * model.getValueAt(index, 1).toString(); String adress=
				 * model.getValueAt(index, 2).toString(); String city=
				 * model.getValueAt(index, 3).toString(); String contact=
				 * model.getValueAt(index, 4).toString(); String delivered=
				 * model.getValueAt(index, 5).toString(); String designation=
				 * model.getValueAt(index, 6).toString();
				 * System.out.print(code); CustomerForm customerForm=new
				 * CustomerForm(); customerForm.main(null);
				 * 
				 * customerForm.code1.setText(code);
				 * session.getTransaction().commit(); session.flush(); // it
				 * will close the particular session after completing the
				 * process session.close(); sessionFactory.close();
				 */
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnNewButton.setBounds(234, 451, 89, 23);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Delete");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnNewButton_1.setBounds(358, 451, 89, 23);
		contentPane.add(btnNewButton_1);
	}
}
