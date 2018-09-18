package com.inventory.frames;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.List;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.inventory.model.CustomerModel;
import com.inventory.model.RawModel;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Raw extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField rawCode;
	private JTextField rawDes;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Raw frame = new Raw();
					frame.setVisible(true);
					//frame.get();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Raw() {
		setTitle("Raw Master");
		addWindowListener(new WindowAdapter() {
			@SuppressWarnings({ "rawtypes", "unchecked" })
			@Override
			public void windowOpened(WindowEvent arg0) {
			
				SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
				Session session=sessionFactory.openSession();
				
				
				List<RawModel> raw = session.createQuery("from RawModel").list();

				Vector<String> tableHeaders = new Vector<String>();
				Vector tableData = new Vector();
				tableHeaders.add("code");
				tableHeaders.add("Raw Material Description");
				
			
				for (Object o : raw) {
					RawModel model = (RawModel) o;
					Vector<Object> oneRow = new Vector<Object>();
					oneRow.add(model.getCode());
					oneRow.add(model.getDes());

					tableData.add(oneRow);
				}
				table.setModel(new DefaultTableModel(tableData, tableHeaders));

			
				session.getTransaction().commit();
				session.close();
				sessionFactory.close();
			

			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 765, 573);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(46, 43, 598, 390);
		contentPane.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		rawCode = new JTextField();
		rawCode.setBounds(148, 467, 113, 29);
		contentPane.add(rawCode);
		rawCode.setColumns(10);

		rawDes = new JTextField();
		rawDes.setBounds(299, 467, 345, 29);
		contentPane.add(rawDes);
		rawDes.setColumns(10);

		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			
			
			
			
			
			
			//*******save***********
			
			
			
			
			public void actionPerformed(ActionEvent arg0) {

				SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
				Session session = sessionFactory.openSession();
				session.beginTransaction();
				RawModel rawModel = new RawModel();
				rawModel.setCode(rawCode.getText());
				rawModel.setDes(rawDes.getText());
				session.save(rawModel);
				List<RawModel> raw = session.createQuery("from RawModel").list();

				Vector<String> tableHeaders = new Vector<String>();
				Vector tableData = new Vector();
				tableHeaders.add("code");
				tableHeaders.add("Raw Material Description");
				// tableHeaders.add("address");

				// tableHeaders.add("name");
				for (Object o : raw) {
					RawModel model = (RawModel) o;
					Vector<Object> oneRow = new Vector<Object>();
					oneRow.add(model.getCode());
					oneRow.add(model.getDes());

					tableData.add(oneRow);
				}
				table.setModel(new DefaultTableModel(tableData, tableHeaders));

				JOptionPane.showMessageDialog(null, "saved");
				session.getTransaction().commit();
				session.close();
				sessionFactory.close();
			

			}
		});
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSave.setIcon(new ImageIcon(Raw.class.getResource("/inventory/save.png")));
		btnSave.setBounds(0, 0, 102, 29);
		contentPane.add(btnSave);
	
		
		
		
		// ***************update*********************
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
				Session session = sessionFactory.openSession();
				session.beginTransaction();
				RawModel rawModel = new RawModel();
				rawModel.setCode(rawCode.getText());
				rawModel.setDes(rawDes.getText());
				session.update(rawModel);
				List<RawModel> raw = session.createQuery("from RawModel").list();

				Vector<String> tableHeaders = new Vector<String>();
				Vector tableData = new Vector();
				tableHeaders.add("code");
				tableHeaders.add("Raw Material Description");
				// tableHeaders.add("address");

				// tableHeaders.add("name");
				for (Object o : raw) {
					RawModel model = (RawModel) o;
					Vector<Object> oneRow = new Vector<Object>();
					oneRow.add(model.getCode());
					oneRow.add(model.getDes());

					tableData.add(oneRow);
				}
				table.setModel(new DefaultTableModel(tableData, tableHeaders));

				JOptionPane.showMessageDialog(null, "updated");
				session.getTransaction().commit();
				session.close();
				sessionFactory.close();
				

			}
		});
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnUpdate.setIcon(new ImageIcon(Raw.class.getResource("/inventory/update.png")));
		btnUpdate.setBounds(102, 0, 116, 29);
		contentPane.add(btnUpdate);

		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
		
			
			
			
			
			
			
			//**************Delete***************************
			
			
			public void actionPerformed(ActionEvent e) {

				SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
				Session session = sessionFactory.openSession();

				session.beginTransaction();

				RawModel raw = new RawModel();
				raw.setCode(rawCode.getText());

				int result = JOptionPane.showConfirmDialog(null,
						"Are you sure you delete   " + rawCode.getText() + "  ?", null, JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.YES_OPTION) {
					session.delete(raw);

					session.getTransaction().commit();
				}

				List<RawModel> rawq = session.createQuery("from RawModel").list();

				Vector<String> tableHeaders = new Vector<String>();
				Vector tableData = new Vector();
				tableHeaders.add("code");
				tableHeaders.add("Raw Material Description");
				// tableHeaders.add("address");

				// tableHeaders.add("name");
				for (Object o : rawq) {
					RawModel model = (RawModel) o;
					Vector<Object> oneRow = new Vector<Object>();
					oneRow.add(model.getCode());
					oneRow.add(model.getDes());

					tableData.add(oneRow);
				}
				table.setModel(new DefaultTableModel(tableData, tableHeaders));

				session.close();
				sessionFactory.close();

			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnDelete.setIcon(new ImageIcon(Raw.class.getResource("/inventory/delete.png")));
		btnDelete.setBounds(218, 0, 102, 29);
		contentPane.add(btnDelete);

		btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// table.getSelectedRow();

				DefaultTableModel model = (DefaultTableModel) table.getModel();
				int index = table.getSelectedRow();

				// populating selected row to textbox
				// display customer data's to tables

				rawCode.setText(model.getValueAt(index, 0).toString());
				rawDes.setText(model.getValueAt(index, 1).toString());

			}
		});
		btnNewButton.setIcon(new ImageIcon(Raw.class.getResource("/inventory/viw.png")));
		btnNewButton.setBounds(662, 192, 77, 48);
		contentPane.add(btnNewButton);
	}


	}
