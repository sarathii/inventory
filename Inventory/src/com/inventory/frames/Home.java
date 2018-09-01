package com.inventory.frames;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import com.inventory.model.CustomerModel;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Home extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
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
	public Home() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 635, 395);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Masters");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmCustomermaster = new JMenuItem("CustomerMaster");
		mntmCustomermaster.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				///SwingUtilities.getWindowAncestor(this).setVisible(false);

				//((Window) new CustomerModel()).setVisible(true); 
				//this.frame.dispose();
			CustomerForm.main(null);
			//JOptionPane.showMessageDialog(null," Fuck");
			
				
			}
		});
		mnNewMenu.add(mntmCustomermaster);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Vendor Master");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VendorForm vendor=new VendorForm();
				
				vendor.setVisible(true);
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Component Master");
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("MachineMaster");
		mnNewMenu.add(mntmNewMenuItem_4);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Mould Maaster");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
			MouldMaster mould=new MouldMaster();
			mould.setVisible(true);
			
			}
		});
		mnNewMenu.add(mntmNewMenuItem_5);
		
		JMenu mnNewMenu_1 = new JMenu("Transaction");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("New menu item");
		mnNewMenu_1.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("New menu item");
		mnNewMenu_1.add(mntmNewMenuItem_3);
		
		JMenu mnNewMenu_2 = new JMenu("Reports");
		menuBar.add(mnNewMenu_2);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

}
