package com.inventory.frames;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import java.net.URI;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.inventory.transaction.issues.Delivery_Challen;
import com.inventory.transaction.issues.ExportInvoice;
import com.inventory.transaction.issues.JoWorkDeliveryChallan_Raw;
import com.inventory.transaction.issues.Job_Woring_Challan;
import com.inventory.transaction.issues.Mrs_Castings;
import com.inventory.transaction.issues.Mrs_RawMaterial;
import com.inventory.transaction.issues.SalesInvoice;
import com.inventory.transaction.issues.labourInvoice;
import com.inventory.transaction.purchaseOrder.PoRawMaterial;
import com.inventory.transaction.purchaseOrder.Purchase_Order_Castings;
import com.inventory.transaction.receipts.Grn_Casting;
import com.inventory.transaction.receipts.Grn_RawMaterialCustomer;
import com.inventory.transaction.receipts.Grn_RawMaterialReturn;
import com.inventory.transaction.receipts.ProductionSlip;

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
				dispose();
				VendorForm vendor = new VendorForm();

				vendor.setVisible(true);
				
			}
		});
		mnNewMenu.add(mntmNewMenuItem);

		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Component Master");
		mntmNewMenuItem_1.setFont(new Font("Segoe UI", Font.BOLD, 12));
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				ComponentMaster  componentMaster =new ComponentMaster();
				componentMaster.setVisible(true);
				
				
				
				
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);

		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Mould Master");
		mntmNewMenuItem_5.setFont(new Font("Segoe UI", Font.BOLD, 12));
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				MouldMaster mould = new MouldMaster();
				mould.setVisible(true);

			}
		});
		mnNewMenu.add(mntmNewMenuItem_5);
		
				JMenuItem mntmNewMenuItem_4 = new JMenuItem("Raw Master");
				mntmNewMenuItem_4.setFont(new Font("Segoe UI", Font.BOLD, 12));
				mntmNewMenuItem_4.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
						dispose();
						Raw raw=new Raw();
						raw.setVisible(true);
						
						
					}
				});
				mnNewMenu.add(mntmNewMenuItem_4);
				
				JMenuItem mntmNewMenuItem_6 = new JMenuItem("Machine Master");
				mntmNewMenuItem_6.setFont(new Font("Segoe UI", Font.BOLD, 12));
				mntmNewMenuItem_6.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
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
								dispose();
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
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				dispose();
				Purchase_Order_Castings po=new Purchase_Order_Castings();
				po.setVisible(true);
				
				
				
			}
		});
		mntmNewMenuItem_2.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		mnPurchaseOrder.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_9 = new JMenuItem("Raw Material");
		mntmNewMenuItem_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
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
		mntmNewMenuItem_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				dispose();
				Grn_Casting casting=new Grn_Casting();
				casting.setVisible(true);
				
			}
		});
		mntmNewMenuItem_10.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		mnReceipts.add(mntmNewMenuItem_10);
		
		JMenuItem mntmNewMenuItem_13 = new JMenuItem("GRN-Raw Materials(purchase and return from sub-contractor)");
		mntmNewMenuItem_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				
				Grn_RawMaterialReturn retur=new Grn_RawMaterialReturn();
				retur.setVisible(true);
			}
		});
		mntmNewMenuItem_13.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		mnReceipts.add(mntmNewMenuItem_13);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("GRN-raw Materials(customer)");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				dispose();

				Grn_RawMaterialCustomer raw=new Grn_RawMaterialCustomer();
				raw.setVisible(true);
			
			
			}
		});
		mntmNewMenuItem_3.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		mnReceipts.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_11 = new JMenuItem("Production Slip");
		mntmNewMenuItem_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				ProductionSlip slip=new ProductionSlip();
				slip.setVisible(true);
				
				
				
			}
		});
		mntmNewMenuItem_11.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		mnReceipts.add(mntmNewMenuItem_11);
		
		JMenu mnNewMenu_3 = new JMenu("Issues");
		mnNewMenu_3.setFont(new Font("Segoe UI", Font.BOLD, 12));
		mnNewMenu_1.add(mnNewMenu_3);
		
		JMenuItem mntmMrsrawmaterial = new JMenuItem("MRS-RawMaterial");
		mntmMrsrawmaterial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				Mrs_RawMaterial raw=new Mrs_RawMaterial();
				raw.setVisible(true);
				
			}
		});
		mnNewMenu_3.add(mntmMrsrawmaterial);
		
		JMenuItem mntmMrscastings = new JMenuItem("MRS-Castings");
		mntmMrscastings.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Mrs_Castings cast=new Mrs_Castings();
				cast.setVisible(true);
				
				
			}
		});
		mnNewMenu_3.add(mntmMrscastings);
		
		JMenuItem menuItem = new JMenuItem("job Work Delivery Chalan(Castings)");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			Job_Woring_Challan challan=new Job_Woring_Challan();
			challan.setVisible(true);
				
				
			}
		});
		mnNewMenu_3.add(menuItem);
		
		JMenuItem mntmJobWorkDelivery = new JMenuItem("job Work Delivery Chalan(Raw Materials)");
		mntmJobWorkDelivery.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				JoWorkDeliveryChallan_Raw raw=new JoWorkDeliveryChallan_Raw();
				raw.setVisible(true);
			}
		});
		mnNewMenu_3.add(mntmJobWorkDelivery);
		
		JMenuItem mntmLabourInvoiceCum = new JMenuItem("labour Invoice cum delivery challan(Castings)");
		mntmLabourInvoiceCum.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				labourInvoice in=new labourInvoice();
				in.setVisible(true);
				
				
				
			}
		});
		mnNewMenu_3.add(mntmLabourInvoiceCum);
		
		JMenuItem mntmDeliveryChallanrawMaterialscustomers = new JMenuItem("Delivery challan(Raw Materials)-Customers");
		mntmDeliveryChallanrawMaterialscustomers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				
				Delivery_Challen challan=new Delivery_Challen();
				challan.setVisible(true);
			}
		});
		mnNewMenu_3.add(mntmDeliveryChallanrawMaterialscustomers);
		
		JMenuItem mntmSalesInvoiceCum = new JMenuItem("Sales Invoice cum Delivery challan");
		mntmSalesInvoiceCum.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				SalesInvoice sales=new SalesInvoice();
				sales.setVisible(true);
			}
		});
		mnNewMenu_3.add(mntmSalesInvoiceCum);
		
		JMenuItem mntmExortInvoice = new JMenuItem("Export Invoice");
		mntmExortInvoice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				ExportInvoice invoice=new ExportInvoice();
				invoice.setVisible(true);
				
			}
		});
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
		
		JMenuItem mntmNewMenuItem_20 = new JMenuItem("Elasticsearch");
		mntmNewMenuItem_20.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
				Process rt =Runtime.getRuntime().exec("cmd /c start "+"D:/downloads/elasticsearch-6.5.4/elasticsearch-6.5.4/bin/elasticsearch.bat");
				}
				catch(Exception e)
				{
					System.out.println(e);
				}
				
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_20);
		
		JMenuItem mntmLogstash = new JMenuItem("logstash");
		mntmLogstash.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					PrintWriter pw =new PrintWriter("lat.bat");
					pw.println("D:");
					pw.println("cd downloads");
					pw.println("cd logstash-6.5.4");
					pw.println("cd logstash-6.5.4");
					pw.println("cd bin");
					pw.println("logstash -f  D:\\downloads\\logstash-6.5.4\\logstash-6.5.4\\config\\jdbcdemo.conf ");
					pw.close();
				Runtime rt =Runtime.getRuntime();
				rt.exec("cmd /c start "+"lat.bat");
			//	rt.exec("cmd /c start "+"D:/downloads/logstash-6.5.4/logstash-6.5.4/bin");
				}
				catch(Exception e1){
					System.out.println(e1);
				}
				
				
				
			}
		});
		mnNewMenu_2.add(mntmLogstash);
		
		JMenuItem mntmNewMenuItem_21 = new JMenuItem("kibana");
		mntmNewMenuItem_21.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					Process rt =Runtime.getRuntime().exec("cmd /c start "+"D:/downloads/kibana-6.5.4-windows-x86_64/bin/kibana.bat");
					}
					catch(Exception e3)
					{
						System.out.println(e3);
					}
					
				}
				
				
				
			
		});
		mnNewMenu_2.add(mntmNewMenuItem_21);
		
		JMenuItem mntmOpenVisualization = new JMenuItem("open visualization");
		mntmOpenVisualization.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
				
				
				  Desktop d=Desktop.getDesktop();

			        // Browse a URL, say google.com
			        d.browse(new URI("http://localhost:5601"));
				}
				catch(Exception x)
				{
					System.out.println(x);
				}
			}
		});
		mnNewMenu_2.add(mntmOpenVisualization);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuItem menuItem_1 = new JMenuItem("");
		menuItem_1.setBounds(385, 60, 129, 22);
		contentPane.add(menuItem_1);
		
		JButton profile = new JButton("Profile");
		profile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				

				dispose();
			Profile pro=new Profile();
				pro.setVisible(true);	
				
				
				
				
			}
		});
		profile.setBackground(Color.WHITE);
		profile.setBounds(520, 0, 89, 45);
		contentPane.add(profile);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Home.class.getResource("/inventory/soln.jpg")));
		lblNewLabel.setBounds(10, 0, 619, 335);
		contentPane.add(lblNewLabel);
		
		
	
		
		
		
		
		
		
		
		
	}
}
