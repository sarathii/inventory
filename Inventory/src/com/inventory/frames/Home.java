package com.inventory.frames;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import com.inventory.model.CustomerModel;
import com.inventory.transaction.PoRawMaterial;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;

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
					//new BackgroundImageJFrame();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Home()
	{
		setTitle("Home");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 635, 395);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("Masters");
		mnNewMenu.setFont(new Font("Segoe UI", Font.BOLD, 12));
		menuBar.add(mnNewMenu);

		JMenuItem mntmCustomermaster = new JMenuItem("Customer Master");
		mntmCustomermaster.setFont(new Font("Segoe UI", Font.BOLD, 12));
		mntmCustomermaster.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/// SwingUtilities.getWindowAncestor(this).setVisible(false);

				// ((Window) new CustomerModel()).setVisible(true);
				// this.frame.dispose();
				CustomerForm.main(null);
				// JOptionPane.showMessageDialog(null," Fuck");

			}
		});
		mnNewMenu.add(mntmCustomermaster);

		JMenuItem mntmNewMenuItem = new JMenuItem("Vendor Master");
		mntmNewMenuItem.setFont(new Font("Segoe UI", Font.BOLD, 12));
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				VendorForm vendor = new VendorForm();

				vendor.setVisible(true);
				
			}
		});
		mnNewMenu.add(mntmNewMenuItem);

		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Component Master");
		mntmNewMenuItem_1.setFont(new Font("Segoe UI", Font.BOLD, 12));
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				ComponentMaster  componentMaster =new ComponentMaster();
				componentMaster.setVisible(true);
				
				
				
				
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);

		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Mould Master");
		mntmNewMenuItem_5.setFont(new Font("Segoe UI", Font.BOLD, 12));
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				MouldMaster mould = new MouldMaster();
				mould.setVisible(true);

			}
		});
		mnNewMenu.add(mntmNewMenuItem_5);
		
				JMenuItem mntmNewMenuItem_4 = new JMenuItem("Raw Master");
				mntmNewMenuItem_4.setFont(new Font("Segoe UI", Font.BOLD, 12));
				mntmNewMenuItem_4.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
						
						Raw raw=new Raw();
						raw.setVisible(true);
						
						
					}
				});
				mnNewMenu.add(mntmNewMenuItem_4);
				
				JMenuItem mntmNewMenuItem_6 = new JMenuItem("Machine Master");
				mntmNewMenuItem_6.setFont(new Font("Segoe UI", Font.BOLD, 12));
				mntmNewMenuItem_6.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
						MachineMaster machineMaster=new MachineMaster();
						machineMaster.setVisible(true);
						
						
						
						
					}
				});
				mnNewMenu.add(mntmNewMenuItem_6);
				
				JMenuItem mntmNewMenuItem_7 = new JMenuItem("PurchaseOrder Master");
				mntmNewMenuItem_7.setFont(new Font("Segoe UI", Font.BOLD, 12));
				mntmNewMenuItem_7.addActionListener(new ActionListener()
						{

							@Override
							public void actionPerformed(ActionEvent e) {
								PurchaseOrderMaster purchaseOrder=new PurchaseOrderMaster();
								purchaseOrder.setVisible(true);
								
							}
					
						}
	);
				
				mnNewMenu.add(mntmNewMenuItem_7);

		JMenu mnNewMenu_1 = new JMenu("Transaction");
		mnNewMenu_1.setFont(new Font("Segoe UI", Font.BOLD, 12));
		menuBar.add(mnNewMenu_1);
		
		JMenu mnPurchaseOrder = new JMenu("Purchase Order");
		mnPurchaseOrder.setFont(new Font("Segoe UI", Font.BOLD, 12));
		mnNewMenu_1.add(mnPurchaseOrder);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Castings");
		mntmNewMenuItem_2.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		mnPurchaseOrder.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_9 = new JMenuItem("Raw Material");
		mntmNewMenuItem_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				PoRawMaterial raw=new PoRawMaterial();
				raw.setVisible(true);
			
				
				
				
				
				
			}
		});
		mntmNewMenuItem_9.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		mnPurchaseOrder.add(mntmNewMenuItem_9);
		
		JMenu mnReceipts = new JMenu("Receipts");
		mnReceipts.setFont(new Font("Segoe UI", Font.BOLD, 12));
		mnNewMenu_1.add(mnReceipts);
		
		JMenuItem mntmNewMenuItem_10 = new JMenuItem("GRN-Castings(Vendor Customer)");
		mntmNewMenuItem_10.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		mnReceipts.add(mntmNewMenuItem_10);
		
		JMenuItem mntmNewMenuItem_13 = new JMenuItem("GRN-Raw Materials(purchase and return from sub-contractor)");
		mntmNewMenuItem_13.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		mnReceipts.add(mntmNewMenuItem_13);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("GRN-raw Materials(customer)");
		mntmNewMenuItem_3.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		mnReceipts.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_11 = new JMenuItem("Production Slip");
		mntmNewMenuItem_11.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		mnReceipts.add(mntmNewMenuItem_11);
		
		JMenu mnNewMenu_3 = new JMenu("Issues");
		mnNewMenu_3.setFont(new Font("Segoe UI", Font.BOLD, 12));
		mnNewMenu_1.add(mnNewMenu_3);
		
		JMenuItem mntmMrsrawmaterial = new JMenuItem("MRS-RawMaterial");
		mnNewMenu_3.add(mntmMrsrawmaterial);
		
		JMenuItem mntmMrscastings = new JMenuItem("MRS-Castings");
		mnNewMenu_3.add(mntmMrscastings);
		
		JMenuItem menuItem = new JMenuItem("job Work Delivery Chalan(Castings)");
		mnNewMenu_3.add(menuItem);
		
		JMenuItem mntmJobWorkDelivery = new JMenuItem("job Work Delivery Chalan(Raw Materials)");
		mnNewMenu_3.add(mntmJobWorkDelivery);
		
		JMenuItem mntmLabourInvoiceCum = new JMenuItem("labour Invoice cum delivery challan(Castings)");
		mnNewMenu_3.add(mntmLabourInvoiceCum);
		
		JMenuItem mntmDeliveryChallanrawMaterialscustomers = new JMenuItem("Delivery challan(Raw Materials)-Customers");
		mnNewMenu_3.add(mntmDeliveryChallanrawMaterialscustomers);
		
		JMenuItem mntmSalesInvoiceCum = new JMenuItem("Sales Invoice cum Delivery challan");
		mnNewMenu_3.add(mntmSalesInvoiceCum);
		
		JMenuItem mntmExortInvoice = new JMenuItem("Export Invoice");
		mnNewMenu_3.add(mntmExortInvoice);

		JMenu mnNewMenu_2 = new JMenu("Reports");
		mnNewMenu_2.setFont(new Font("Segoe UI", Font.BOLD, 12));
		menuBar.add(mnNewMenu_2);
		
		JMenu mnNewMenu_4 = new JMenu("Customer Raw Material Report");
		mnNewMenu_2.add(mnNewMenu_4);
		
		JMenuItem mntmNewMenuItem_8 = new JMenuItem("Raw Material stock Report");
		mnNewMenu_4.add(mntmNewMenuItem_8);
		
		JMenuItem mntmNewMenuItem_15 = new JMenuItem("DCWISE Raw Material Pending (57F4 Challan)");
		mnNewMenu_4.add(mntmNewMenuItem_15);
		
		JMenuItem mntmNewMenuItem_12 = new JMenuItem("Customer 57F4 summary");
		mnNewMenu_4.add(mntmNewMenuItem_12);
		
		JMenuItem mntmNewMenuItem_14 = new JMenuItem("57F4 challanList");
		mnNewMenu_4.add(mntmNewMenuItem_14);
		
		JMenu mnStockInHand = new JMenu("Stock In hand");
		mnNewMenu_2.add(mnStockInHand);
		
		JMenuItem mntmNewMenuItem_16 = new JMenuItem("Raw Materia Stock(In Stores)");
		mnStockInHand.add(mntmNewMenuItem_16);
		
		JMenuItem mntmNewMenuItem_17 = new JMenuItem("Casting Stock Legender( In Hand)");
		mnStockInHand.add(mntmNewMenuItem_17);
		
		JMenu mnNewMenu_5 = new JMenu("Stock with Vendor(sub-contractor)");
		mnNewMenu_2.add(mnNewMenu_5);
		
		JMenuItem mntmNewMenuItem_18 = new JMenuItem("Castings stock Register (with vendor)");
		mnNewMenu_5.add(mntmNewMenuItem_18);
		
		JMenuItem mntmNewMenuItem_19 = new JMenuItem("Raw Material Stock Register(with Vendor)");
		mnNewMenu_5.add(mntmNewMenuItem_19);
		
		JMenuItem mntmBoughtoutRawMaterial = new JMenuItem("Boughtout Raw Material Report");
		mnNewMenu_2.add(mntmBoughtoutRawMaterial);
		
		JMenuItem mntmMaterialInwardRegistergrn = new JMenuItem("Material Inward Register-GRN");
		mnNewMenu_2.add(mntmMaterialInwardRegistergrn);
		
		JMenuItem mntmJobWorkDelivery_1 = new JMenuItem("job work Delivery challan register");
		mnNewMenu_2.add(mntmJobWorkDelivery_1);
		
		JMenuItem mntmSalesRegister = new JMenuItem("Sales Register");
		mnNewMenu_2.add(mntmSalesRegister);
		
		JMenuItem mntmSalesRegisterpartcodeWise = new JMenuItem("Sales Register-partCode Wise");
		mnNewMenu_2.add(mntmSalesRegisterpartcodeWise);
		
		JMenuItem mntmLabourInvoiceRegister = new JMenuItem("Labour Invoice Register");
		mnNewMenu_2.add(mntmLabourInvoiceRegister);
		
		JMenuItem mntmLabourInvoiceRegisterpartcode = new JMenuItem("Labour Invoice Register-partcode wise");
		mnNewMenu_2.add(mntmLabourInvoiceRegisterpartcode);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Home.class.getResource("/inventory/soln.jpg")));
		lblNewLabel.setBounds(0, 0, 619, 335);
		contentPane.add(lblNewLabel);
		
		JMenuItem menuItem_1 = new JMenuItem("");
		menuItem_1.setBounds(385, 60, 129, 22);
		contentPane.add(menuItem_1);
		
		
	
		
		
		
		
		
		
		
		
	}
}
