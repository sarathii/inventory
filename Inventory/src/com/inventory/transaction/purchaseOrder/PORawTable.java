package com.inventory.transaction.purchaseOrder;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.inventory.model.PORawTableModel;
import com.inventory.model.RawModel;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

public class PORawTable extends JFrame {

	private JPanel contentPane;
	private JTextField d;
	private JTextField q;
	private JTextField u;
	private JTextField ur;
	private JTextField a;
	private JTextField i;
	private JTextField cg;
	private JComboBox rawcombo;
	private JTextField s;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PORawTable frame = new PORawTable();
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
	public PORawTable() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {

				SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
				// SessionFactc=
				Session session = sessionFactory.openSession();
				session.beginTransaction();
				List<RawModel> raw = session.createQuery(" from RawModel ").list();
				// System.out.println(customerModel.get());
				DefaultComboBoxModel model = (DefaultComboBoxModel) rawcombo.getModel();

				// DefaultComboBoxModel model=(DefaultComboBoxModel)
				// comboBox.getModel();
				// coModel.removeAllElements();
				for (RawModel rawModel : raw) {
					// System.out.println("helllo");
					model.addElement(rawModel.getCode());

					rawcombo.setModel(model);

				}
				session.getTransaction().commit();
				// session.flush();
				session.close();
				sessionFactory.close();

			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 573, 502);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("code");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel.setBounds(25, 58, 91, 14);
		contentPane.add(lblNewLabel);

		JLabel lblDescription = new JLabel("description");
		lblDescription.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblDescription.setBounds(308, 58, 91, 14);
		contentPane.add(lblDescription);

		JLabel lblQuntity = new JLabel("quantity");
		lblQuntity.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblQuntity.setBounds(25, 129, 91, 14);
		contentPane.add(lblQuntity);

		JLabel lblUnit = new JLabel("unit");
		lblUnit.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblUnit.setBounds(25, 181, 91, 14);
		contentPane.add(lblUnit);

		JLabel lblUnitRate = new JLabel("unit rate");
		lblUnitRate.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblUnitRate.setBounds(308, 181, 91, 14);
		contentPane.add(lblUnitRate);

		JLabel label_4 = new JLabel("");
		label_4.setFont(new Font("Times New Roman", Font.BOLD, 14));
		label_4.setBounds(308, 239, 91, 14);
		contentPane.add(label_4);

		JLabel lblAmount = new JLabel("amount");
		lblAmount.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblAmount.setBounds(25, 235, 91, 14);
		contentPane.add(lblAmount);

		JLabel lblIgst = new JLabel("Igst");
		lblIgst.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblIgst.setBounds(308, 239, 91, 14);
		contentPane.add(lblIgst);

		JLabel lblCgst = new JLabel("cgst");
		lblCgst.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblCgst.setBounds(25, 283, 91, 14);
		contentPane.add(lblCgst);

		JLabel lblSgst = new JLabel("sgst");
		lblSgst.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblSgst.setBounds(308, 283, 91, 14);
		contentPane.add(lblSgst);

		d = new JTextField();
		d.setBounds(409, 56, 120, 20);
		contentPane.add(d);
		d.setColumns(10);

		q = new JTextField();
		q.setColumns(10);
		q.setBounds(160, 127, 120, 20);
		contentPane.add(q);

		u = new JTextField();
		u.setColumns(10);
		u.setBounds(160, 179, 120, 20);
		contentPane.add(u);

		ur = new JTextField();
		ur.setColumns(10);
		ur.setBounds(413, 179, 120, 20);
		contentPane.add(ur);

		a = new JTextField();
		a.setColumns(10);
		a.setBounds(160, 233, 120, 20);
		contentPane.add(a);

		i = new JTextField();
		i.setColumns(10);
		i.setBounds(413, 239, 120, 20);
		contentPane.add(i);

		cg = new JTextField();
		cg.setColumns(10);
		cg.setBounds(160, 281, 120, 20);
		contentPane.add(cg);

		s = new JTextField();
		s.setColumns(10);
		s.setBounds(413, 281, 120, 20);
		contentPane.add(s);

		rawcombo = new JComboBox();
		rawcombo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
				Session session = sessionFactory.openSession();
				session.beginTransaction();
				RawModel rawModel = (RawModel) session.get(RawModel.class, rawcombo.getSelectedItem().toString());
				d.setText(rawModel.getDes());
				session.getTransaction().commit();
				session.close();
				sessionFactory.close();

			}
		});
		rawcombo.setBounds(140, 56, 82, 20);
		contentPane.add(rawcombo);

		JButton add = new JButton("add");
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				
String code=rawcombo.getSelectedItem().toString();
		String des=d.getText();
		int quantity=Integer.parseInt(q.getText());
		Double amount=Double.parseDouble(a.getText());
				int unit=Integer.parseInt(u.getText());
				int urate=Integer.parseInt(ur.getText());
				Double igst=Double.parseDouble(i.getText());
				Double cgst=Double.parseDouble(cg.getText());
				double sgst=Double.parseDouble(s.getText());
				new PoRawMaterial(code ,des,quantity, amount, unit, urate, igst, cgst, sgst).setVisible(true);
			}
		});
		add.setIcon(new ImageIcon(PORawTable.class.getResource("/inventory/add.png")));
		add.setBounds(205, 322, 89, 23);
		contentPane.add(add);
	}
}
