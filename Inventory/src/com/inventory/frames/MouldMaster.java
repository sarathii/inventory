package com.inventory.frames;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

//import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.annotations.reflection.XMLContext.Default;
import org.hibernate.query.Query;

import com.inventory.model.CustomerModel;
import com.inventory.model.MouldModel;
import com.inventory.model.RawModel;
import com.inventory.model.VendorModel;

import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JScrollBar;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;

public class MouldMaster extends JFrame {

	private JPanel contentPane;
	private JTextField mName;
	private JTextField mCode;
	private JTextField total;
	private JComboBox comboBox;
	JLabel mouldCustomer;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MouldMaster frame = new MouldMaster();
					frame.setVisible(true);
					// frame.test();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// get()
	public void get() {

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		@SuppressWarnings("unchecked")
		List<MouldModel> mould = session.createQuery("from MouldModel").list();

		Vector<String> tableHeaders = new Vector<String>();
		Vector tableData = new Vector();
		tableHeaders.add("Customer Code");
		tableHeaders.add("Customer Name");
		tableHeaders.add("Mould Code");
		tableHeaders.add("Mould Name");
		tableHeaders.add("Total Mould");
		// tableHeaders.add("address");

		// tableHeaders.add("name");
		for (Object o : mould) {
			MouldModel model = (MouldModel) o;
			Vector<Object> oneRow = new Vector<Object>();
			oneRow.add(model.getCode());
			oneRow.add(model.getName());
			oneRow.add(model.getMouldCode());
			oneRow.add(model.getMouldName());
			oneRow.add(model.getTotalshot());

			tableData.add(oneRow);
		}
		table.setModel(new DefaultTableModel(tableData, tableHeaders));

		session.getTransaction().commit();
		session.flush();
		session.close();
		sessionFactory.close();
	}

	/**
	 * Create the frame.
	 * 
	 * 
	 * public void test() { SessionFactory sessionFactory=new
	 * Configuration().configure().buildSessionFactory(); Session
	 * session=sessionFactory.openSession(); @SuppressWarnings("unchecked") List
	 * <CustomerModel> products = session.createQuery(
	 * "select code from CustomerModel ").list(); System.out.print("oi"); Vector
	 * Data = new Vector();
	 * 
	 * 
	 * //while(results.)
	 * 
	 * for ( :products) { System.out.print("oi"); CustomerModel model=
	 * (CustomerModel) o; //comboBox.intervalAdded(e); //Vector<String> elements
	 * = new Vector<String>(); System.out.print("oi"); Vector<Object> oneRow =
	 * new Vector<Object>(); System.out.print("ugh");
	 * oneRow.addElement(model.get()); System.out.print("oi"); Data.add(oneRow);
	 * 
	 * } comboBox.setModel(new DefaultComboBoxModel(Data));
	 * 
	 * session.getTransaction().commit(); session.close();
	 * sessionFactory.close();
	 * 
	 * 
	 * }
	 * 
	 */

	// combobox customer code retrieving
	public MouldMaster() {
		addWindowListener(new WindowAdapter() {
			@SuppressWarnings("rawtypes")
			@Override
			public void windowOpened(WindowEvent arg0) {
				CustomerModel customerModel = new CustomerModel();

				SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
				Session session = sessionFactory.openSession();
				session.beginTransaction();
				List<CustomerModel> products = session.createQuery(" from CustomerModel ").list();
				//System.out.println(customerModel.get());
				DefaultComboBoxModel coModel = (DefaultComboBoxModel) comboBox.getModel();

				// DefaultComboBoxModel model=(DefaultComboBoxModel)
				// comboBox.getModel();
				// coModel.removeAllElements();
				for (CustomerModel customerModel1 : products) {
					System.out.println("helllo");
					coModel.addElement(customerModel1.getCode());
					comboBox.setModel(coModel);
				}

				session.getTransaction().commit();
				// session.flush();
				session.close();
				sessionFactory.close();

			}
		});
		setFont(new Font("Dialog", Font.BOLD, 15));
		setTitle("Mould Master");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 757, 568);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		comboBox = new JComboBox();
		// comboBox.setModel(new DefaultComboBoxModel(new String[] {"heelo"}));

		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
				Session session = sessionFactory.openSession();
				session.beginTransaction();
				String co = comboBox.getSelectedItem().toString();
				CustomerModel customerModel = (CustomerModel) session.get(CustomerModel.class, co);

				mouldCustomer.setText(customerModel.getName());

				session.getTransaction().commit();
				session.close();
				sessionFactory.close();

			}
		});
		comboBox.setBounds(175, 95, 117, 28);
		contentPane.add(comboBox);

		JLabel lblNewLabel = new JLabel("Customer");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel.setBounds(50, 95, 83, 28);
		contentPane.add(lblNewLabel);

		mouldCustomer = new JLabel("");
		mouldCustomer.setBounds(334, 95, 205, 28);
		contentPane.add(mouldCustomer);

		JLabel lblNewLabel_1 = new JLabel("Mould Name");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(50, 165, 81, 19);
		contentPane.add(lblNewLabel_1);

		mName = new JTextField();
		mName.setBounds(175, 162, 267, 28);
		contentPane.add(mName);
		mName.setColumns(10);

		JLabel lblMouldCode = new JLabel("Mould Code");
		lblMouldCode.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblMouldCode.setBounds(50, 210, 81, 19);
		contentPane.add(lblMouldCode);

		JLabel lblTotalShots = new JLabel("Total Shots");
		lblTotalShots.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblTotalShots.setBounds(50, 257, 81, 19);
		contentPane.add(lblTotalShots);

		mCode = new JTextField();
		mCode.setColumns(10);
		mCode.setBounds(175, 211, 267, 28);
		contentPane.add(mCode);

		total = new JTextField();
		total.setColumns(10);
		total.setBounds(175, 258, 267, 28);
		contentPane.add(total);

		JMenuItem menuItem = new JMenuItem("save");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
				Session session = sessionFactory.openSession();
				session.beginTransaction();
				MouldModel model = new MouldModel();
				model.setCode(comboBox.getSelectedItem().toString());
				model.setName(mouldCustomer.getText());
				model.setMouldCode(mCode.getText());
				model.setMouldName(mName.getText());
				model.setTotalshot(Long.parseLong(total.getText()));
				session.save(model);
				// session.getTransaction().commit();

				List<MouldModel> mould = session.createQuery("from MouldModel").list();

				// List<MouldModel> mould = session.createQuery("from
				// MouldModel").list();

				Vector<String> tableHeaders = new Vector<String>();
				Vector tableData = new Vector();
				tableHeaders.add("Customer Code");
				tableHeaders.add("Customer Name");
				tableHeaders.add("Mould Code");
				tableHeaders.add("Mould Name");
				tableHeaders.add("Total Mould");
				// tableHeaders.add("address");

				// tableHeaders.add("name");
				for (Object o : mould) {
					MouldModel mode = (MouldModel) o;
					Vector<Object> oneRow = new Vector<Object>();
					oneRow.add(mode.getCode());
					oneRow.add(mode.getName());
					oneRow.add(mode.getMouldCode());
					oneRow.add(mode.getMouldName());
					oneRow.add(mode.getTotalshot());

					tableData.add(oneRow);
				}
				table.setModel(new DefaultTableModel(tableData, tableHeaders));
				session.getTransaction().commit();
				session.close();
				sessionFactory.close();

			}
		});
		menuItem.setIcon(new ImageIcon(MouldMaster.class.getResource("/inventory/save.png")));
		menuItem.setFont(new Font("Arial", Font.BOLD, 14));
		menuItem.setBounds(21, 11, 82, 26);
		contentPane.add(menuItem);

		// view All module
		JMenuItem menuItem_1 = new JMenuItem("view all customer");
		menuItem_1.addActionListener(new ActionListener() {

			// listener view all

			public void actionPerformed(ActionEvent arg0) {

				SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
				Session session = sessionFactory.openSession();
				session.beginTransaction();
				@SuppressWarnings("unchecked")
				List<MouldModel> mould = session.createQuery("from MouldModel").list();

				Vector<String> tableHeaders = new Vector<String>();
				Vector tableData = new Vector();
				tableHeaders.add("Customer Code");
				tableHeaders.add("Customer Name");
				tableHeaders.add("Mould Code");
				tableHeaders.add("Mould Name");
				tableHeaders.add("Total Mould");
				// tableHeaders.add("address");

				// tableHeaders.add("name");
				for (Object o : mould) {
					MouldModel model = (MouldModel) o;
					Vector<Object> oneRow = new Vector<Object>();
					oneRow.add(model.getCode());
					oneRow.add(model.getName());
					oneRow.add(model.getMouldCode());
					oneRow.add(model.getMouldName());
					oneRow.add(model.getTotalshot());

					tableData.add(oneRow);
				}
				table.setModel(new DefaultTableModel(tableData, tableHeaders));

				session.getTransaction().commit();
				session.flush();
				session.close();
				sessionFactory.close();

				// MouldMaster s=new MouldMaster();
				// s.get();
				/*
				 * List<MouldModel> raw = session.createQuery("from MouldModel"
				 * ).list();
				 * 
				 * Vector<String> tableHeaders = new Vector<String>(); Vector
				 * tableData = new Vector(); tableHeaders.add("code");
				 * tableHeaders.add("Raw Material Description"); //
				 * tableHeaders.add("address");
				 * 
				 * // tableHeaders.add("name"); for (Object o : raw) { RawModel
				 * model = (RawModel) o; Vector<Object> oneRow = new
				 * Vector<Object>(); oneRow.add(model.getCode());
				 * oneRow.add(model.getDes());
				 * 
				 * tableData.add(oneRow); } table.setModel(new
				 * DefaultTableModel(tableData, tableHeaders));
				 * 
				 * JOptionPane.showMessageDialog(null, "updated");
				 * session.getTransaction().commit(); session.close();
				 * sessionFactory.close(); Raw f = new Raw(); f.get();
				 */

			}
		});
		menuItem_1.setIcon(new ImageIcon(MouldMaster.class.getResource("/inventory/view all.png")));
		menuItem_1.setFont(new Font("Arial", Font.BOLD, 14));
		menuItem_1.setBounds(103, 11, 198, 29);
		contentPane.add(menuItem_1);

		// update
		JMenuItem menuItem_2 = new JMenuItem("Update");
		menuItem_2.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
				Session session = sessionFactory.openSession();
				session.beginTransaction();

				MouldModel model = new MouldModel();
				model.setCode(comboBox.getSelectedItem().toString());
				model.setName(mouldCustomer.getText());
				model.setMouldCode(mCode.getText());
				model.setMouldName(mName.getText());
				model.setTotalshot(Long.parseLong(total.getText()));

				session.update(model);

				// session.flush();

				List<MouldModel> mould = session.createQuery("from MouldModel").list();

				// List<MouldModel> mould = session.createQuery("from
				// MouldModel").list();

				Vector<String> tableHeaders = new Vector<String>();
				Vector tableData = new Vector();
				tableHeaders.add("Customer Code");
				tableHeaders.add("Customer Name");
				tableHeaders.add("Mould Code");
				tableHeaders.add("Mould Name");
				tableHeaders.add("Total Mould");
				// tableHeaders.add("address");

				// tableHeaders.add("name");
				for (Object o : mould) {
					MouldModel mode = (MouldModel) o;
					Vector<Object> oneRow = new Vector<Object>();
					oneRow.add(mode.getCode());
					oneRow.add(mode.getName());
					oneRow.add(mode.getMouldCode());
					oneRow.add(mode.getMouldName());
					oneRow.add(mode.getTotalshot());

					tableData.add(oneRow);
				}
				table.setModel(new DefaultTableModel(tableData, tableHeaders));
				session.getTransaction().commit();
				session.close();
				sessionFactory.close();

			}
		});
		menuItem_2.setIcon(new ImageIcon(MouldMaster.class.getResource("/inventory/update.png")));
		menuItem_2.setFont(new Font("Arial", Font.BOLD, 14));
		menuItem_2.setBounds(301, 11, 129, 29);
		contentPane.add(menuItem_2);

		JMenuItem menuItem_3 = new JMenuItem("Delete");
		menuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
				Session session = sessionFactory.openSession();
				session.beginTransaction();
				MouldModel mould = new MouldModel();
				System.out.println(mCode.getText());
				mould.setMouldCode(mCode.getText());

				int result = JOptionPane.showConfirmDialog(null, "Are you sure you delete   " + mCode.getText() + "  ?",
						null, JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.YES_OPTION) {
					session.delete(mould);
					mCode.setText("");
					mName.setText("");
					mouldCustomer.setText("");
					total.setText("");
					comboBox.setSelectedIndex(0);

					session.getTransaction().commit();
				}

				List<MouldModel> mod = session.createQuery("from MouldModel").list();

				// List<MouldModel> mould = session.createQuery("from
				// MouldModel").list();

				Vector<String> tableHeaders = new Vector<String>();
				Vector tableData = new Vector();
				tableHeaders.add("Customer Code");
				tableHeaders.add("Customer Name");
				tableHeaders.add("Mould Code");
				tableHeaders.add("Mould Name");
				tableHeaders.add("Total Mould");
				// tableHeaders.add("address");

				// tableHeaders.add("name");
				for (Object o : mod) {
					MouldModel mode = (MouldModel) o;
					Vector<Object> oneRow = new Vector<Object>();
					oneRow.add(mode.getCode());
					oneRow.add(mode.getName());
					oneRow.add(mode.getMouldCode());
					oneRow.add(mode.getMouldName());
					oneRow.add(mode.getTotalshot());

					tableData.add(oneRow);
				}
				table.setModel(new DefaultTableModel(tableData, tableHeaders));

				session.close();
				sessionFactory.close();

			}
		});
		menuItem_3.setIcon(new ImageIcon(MouldMaster.class.getResource("/inventory/delete.png")));
		menuItem_3.setFont(new Font("Arial", Font.BOLD, 14));
		menuItem_3.setBounds(438, 8, 129, 29);
		contentPane.add(menuItem_3);

		JSeparator separator = new JSeparator();
		separator.setBounds(103, 80, -74, -27);
		contentPane.add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(132, 95, -93, -27);
		contentPane.add(separator_1);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 329, 582, 162);
		contentPane.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		// view

		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {

				DefaultTableModel model = (DefaultTableModel) table.getModel();
				int index = table.getSelectedRow();

				// populating selected row to textbox
				// display customer data's to tables

				// anObject
				comboBox.setSelectedItem(model.getValueAt(index, 0).toString());
				mouldCustomer.setText(model.getValueAt(index, 1).toString());
				mCode.setText(model.getValueAt(index, 2).toString());
				mName.setText(model.getValueAt(index, 3).toString());
				total.setText(model.getValueAt(index, 4).toString());

			}
		});
		btnNewButton.setIcon(new ImageIcon(MouldMaster.class.getResource("/inventory/viw.png")));
		btnNewButton.setBounds(604, 381, 89, 47);
		contentPane.add(btnNewButton);
		
		JMenuItem mntmHome = new JMenuItem("Home");
		mntmHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose ();
				Home hom=new Home();
				hom.setVisible(true);
			}
		});
		mntmHome.setIcon(new ImageIcon(MouldMaster.class.getResource("/inventory/home (1).png")));
		mntmHome.setFont(new Font("Arial", Font.BOLD, 14));
		mntmHome.setBounds(577, 8, 129, 29);
		contentPane.add(mntmHome);

	}
}
