package com.inventory.frames;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.inventory.model.MachineModel;
import com.inventory.model.RawModel;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MachineMaster extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField mCode;
	private JTextField mDes;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MachineMaster frame = new MachineMaster();
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
	public MachineMaster() {
		setTitle("Machine Master");
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {

				SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

				Session session = sessionFactory.openSession();
				List<MachineModel> Model = session.createQuery("from MachineModel").list();

				Vector<String> tableHeaders = new Vector<String>();
				Vector tableData = new Vector();
				tableHeaders.add("Machinecode");
				tableHeaders.add("Machine Description");
				// tableHeaders.add("address");

				// tableHeaders.add("name");
				for (Object o : Model) {
					MachineModel machine = (MachineModel) o;
					Vector<Object> oneRow = new Vector<Object>();
					oneRow.add(machine.getMcode());
					oneRow.add(machine.getMDes());

					tableData.add(oneRow);
				}
				table.setModel(new DefaultTableModel(tableData, tableHeaders));

				session.close();
				sessionFactory.close();

			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 774, 566);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	JScrollPane scrollPane = new JScrollPane();

	/*/*		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				DefaultTableModel model1 = (DefaultTableModel) table.getModel();
				int index = table.getSelectedRow();
				mCode.setText(model1.getValueAt(index, 0).toString());
				mDes.setText(model1.getValueAt(index, 1).toString());

				
				
			}
		});*/

		scrollPane.setBounds(26, 75, 586, 270);
		contentPane.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		mCode = new JTextField();
		mCode.setBounds(29, 402, 113, 32);
		contentPane.add(mCode);
		mCode.setColumns(10);

		mDes = new JTextField();
		mDes.setBounds(189, 402, 395, 32);
		contentPane.add(mDes);
		mDes.setColumns(10);

		JButton button = new JButton("Save");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
				Session session = sessionFactory.openSession();
				session.beginTransaction();
				MachineModel machineModel = new MachineModel();
				machineModel.setMcode(mCode.getText());
				machineModel.setMDes(mDes.getText());
				session.save(machineModel);
				session.getTransaction().commit();
				List<MachineModel> Model = session.createQuery("from MachineModel").list();

				Vector<String> tableHeaders = new Vector<String>();
				Vector tableData = new Vector();
				tableHeaders.add("Machinecode");
				tableHeaders.add("Machine Description");
				// tableHeaders.add("address");

				// tableHeaders.add("name");
				for (Object o : Model) {
					MachineModel machine = (MachineModel) o;
					Vector<Object> oneRow = new Vector<Object>();
					oneRow.add(machine.getMcode());
					oneRow.add(machine.getMDes());

					tableData.add(oneRow);
				}
				table.setModel(new DefaultTableModel(tableData, tableHeaders));

				JOptionPane.showMessageDialog(null, "saved");
			
				
				session.close();
				sessionFactory.close();

			}
		});
		button.setIcon(new ImageIcon(MachineMaster.class.getResource("/inventory/save.png")));
		button.setFont(new Font("Tahoma", Font.BOLD, 14));
		button.setBounds(10, 0, 102, 29);
		contentPane.add(button);

		// ************update********************

		JButton button_1 = new JButton("Update");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
				Session session = sessionFactory.openSession();
				session.beginTransaction();

				MachineModel machineModel = new MachineModel();

				machineModel.setMcode(mCode.getText());
				machineModel.setMDes(mDes.getText());

				session.update(machineModel);

				session.getTransaction().commit();

				mCode.setText("");
				mDes.setText("");
				session.close();
				sessionFactory.close();
			}

		});
		button_1.setIcon(new ImageIcon(MachineMaster.class.getResource("/inventory/update.png")));
		button_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		button_1.setBounds(112, 0, 116, 29);
		contentPane.add(button_1);

		JButton button_2 = new JButton("Delete");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
				Session session = sessionFactory.openSession();

				session.beginTransaction();
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				int index = table.getSelectedRow();
				mCode.setText(model.getValueAt(index, 0).toString());
				mDes.setText(model.getValueAt(index, 1).toString());

				MachineModel machine = new MachineModel();
				machine.setMcode(mCode.getText());

				int result = JOptionPane.showConfirmDialog(null, "Are you sure you delete   " + mCode.getText() + "  ?",
						null, JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.YES_OPTION) {
					session.delete(machine);
					mCode.setText("");
					mDes.setText("");

					session.getTransaction().commit();
				
					List<MachineModel> Model = session.createQuery("from MachineModel").list();

					Vector<String> tableHeaders = new Vector<String>();
					Vector tableData = new Vector();
					tableHeaders.add("Machinecode");
					tableHeaders.add("Machine Description");
					// tableHeaders.add("address");

					// tableHeaders.add("name");
					for (Object o : Model) {
						MachineModel machin = (MachineModel) o;
						Vector<Object> oneRow = new Vector<Object>();
						oneRow.add(machin.getMcode());
						oneRow.add(machin.getMDes());

						tableData.add(oneRow);
					}
					table.setModel(new DefaultTableModel(tableData, tableHeaders));

					// JOptionPane.showMessageDialog(null, "updated");
				}	
					
					session.close();
					sessionFactory.close();

				}

			}
		);
		button_2.setIcon(new ImageIcon(MachineMaster.class.getResource("/inventory/delete.png")));
		button_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		button_2.setBounds(228, 0, 102, 29);
		contentPane.add(button_2);

		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				
				
				SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
				Session session=sessionFactory.openSession();
			//	model1.removeTableModelListener(table);
				
				List<MachineModel> Model = session.createQuery("from MachineModel").list();

				Vector<String> tableHeaders = new Vector<String>();
				Vector tableData = new Vector();
				tableHeaders.add("Machinecode");
				tableHeaders.add("Machine Description");
				// tableHeaders.add("address");

				// tableHeaders.add("name");
				for (Object o : Model) {
					MachineModel machin = (MachineModel) o;
					Vector<Object> oneRow = new Vector<Object>();
					oneRow.add(machin.getMcode());
					oneRow.add(machin.getMDes());

					tableData.add(oneRow);
				}
				table.setModel(new DefaultTableModel(tableData, tableHeaders));

				// JOptionPane.showMessageDialog(null, "updated");
				session.close();
				sessionFactory.close();
			}
		});
		btnNewButton.setIcon(new ImageIcon(MachineMaster.class.getResource("/inventory/viw.png")));
		btnNewButton.setBounds(614, 193, 89, 40);
		contentPane.add(btnNewButton);

		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		JButton button_3 = new JButton("Home");
		button_3.setIcon(new ImageIcon(MachineMaster.class.getResource("/inventory/home (1).png")));
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose ();
				Home hom=new Home();
				hom.setVisible(true);
			}
		});
		button_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		button_3.setBounds(332, 0, 102, 29);
		contentPane.add(button_3);

		ListSelectionModel selectionModel = table.getSelectionModel();

		selectionModel.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent arg0) {

				DefaultTableModel model1 = (DefaultTableModel) table.getModel();
				int index = table.getSelectedRow();
				
				mCode.setText(model1.getValueAt(index, 0).toString());
				mDes.setText(model1.getValueAt(index, 1).toString());
				
			}
		});

	}
}
