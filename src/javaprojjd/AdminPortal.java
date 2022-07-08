package javaprojjd;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class AdminPortal extends JFrame {
	String lim = "0";
	private JPanel contentPane;
	private javaprojjd.MyButton btnNewButton;
	private javaprojjd.MyButton btnReset;
	private javaprojjd.MyButton btnNewButton_2;
	private javaprojjd.MyButton btnNewButton_2_1;
	private javaprojjd.MyButton btnHome;
	private JLabel lblNewLabel_1_2;
	private JLabel lblNewLabel_1_2_1;
	private JLabel lblNewLabel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminPortal frame = new AdminPortal();
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
	public int OccupancyCheck()
	{
		int flag=0;
		try {
//	         HashMap hm = new HashMap<>();
	         Class.forName("com.mysql.cj.jdbc.Driver");
	         Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/udetail","root","Gauttam@2002");
	         Statement statement = (Statement) con.createStatement();
	         String sql;
	         sql = "select * from totalSeats";
	         ResultSet resultSet = statement.executeQuery(sql);
//	         st=("User id       Checkin          Checkout"+"\n"+"\n");
	         while (resultSet.next()) {
	        	 lim = resultSet.getString("capa");
//	        	 str = resultSet.getString("capa");
//	        	 str1 = resultSet.getString("aval");
	         }
	         flag=1;
//	         lblNewLabel_2.setText(str);
//	         datatext.setText(st);
//	      System.out.println(hm);

	      } catch (Exception e6) {
	         e6.printStackTrace();
	      }
		return flag;
	}
	public AdminPortal() {
		System.out.println("hi");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 655, 437);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
//		System.out.println(lim);
//		lbl_1.setText(lim);
		
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.RED);
		panel.setBounds(10, 11, 623, 380);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton button = new JButton("OK");
		button.setBackground(Color.BLACK);
		button.setForeground(Color.WHITE);
		Border emptyBorder = BorderFactory.createEmptyBorder();
		button.setFocusPainted(false);
		button.setBorder(emptyBorder);
		button.setPreferredSize(new Dimension(50,30));
		button.addActionListener(new ActionListener() {
		   @Override
		   public void actionPerformed(ActionEvent actionEvent) {
		       JOptionPane.getRootFrame().dispose();
		   }
		});
		JButton[] buttons = { button };
		
		JLabel lblNewLabel = new JLabel("Occupancy limit :");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(173, 112, 190, 35);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("SimSun-ExtB", Font.BOLD, 20));
		
		JLabel lbl_1 = new JLabel("0");
		lbl_1.setBounds(381, 116, 46, 35);
		panel.add(lbl_1);
		lbl_1.setFont(new Font("Viner Hand ITC", Font.BOLD, 20));
		
		if(OccupancyCheck()==1)
		{
			lbl_1.setText(lim);
		}
		
		btnNewButton = new javaprojjd.MyButton();
		btnNewButton.setBounds(72, 179, 190, 32);
		btnNewButton.setText("Set Limit");
//		Border emptyBorder = BorderFactory.createEmptyBorder();
		btnNewButton.setBorder(emptyBorder);
		btnNewButton.setFocusPainted(false);
		btnNewButton.setColorOver(new Color(255, 225, 225));
		btnNewButton.setColorClick(new Color(255, 134, 134));
		btnNewButton.setBorderColor(new Color(255,255,255));
		btnNewButton.setRadius(30);
		panel.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setentrylimit sentry = new setentrylimit();
				sentry.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		btnReset = new javaprojjd.MyButton();
		btnReset.setBounds(354, 179, 190, 32);
		btnReset.setText("Reset");
//		Border emptyBorder = BorderFactory.createEmptyBorder();
		btnReset.setBorder(emptyBorder);
		btnReset.setFocusPainted(false);
		btnReset.setColorOver(new Color(255, 225, 225));
		btnReset.setColorClick(new Color(255, 134, 134));
		btnReset.setBorderColor(new Color(255,255,255));
		btnReset.setRadius(30);
		panel.add(btnReset);
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try 
				{
//					HashMap hm = new HashMap<>();
			         Class.forName("com.mysql.cj.jdbc.Driver");
			         Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/udetail","root","Gauttam@2002");
			         Statement statement = (Statement) con.createStatement();
			         String sql;
			         sql = "delete from udetails ";
			         statement.executeUpdate(sql);
			         System.out.println("system reseted");
			         lbl_1.setText("0");
			         JOptionPane.showOptionDialog(null, "System Reset Successful..", "Dialog", JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE, new ImageIcon(), buttons, buttons[0]);
//			         JOptionPane.showMessageDialog(null, "System Reset Successful..");
				}
				catch (Exception e2) {
					// TODO: handle exception
				}
				try 
				{
//					HashMap hm = new HashMap<>();
			         Class.forName("com.mysql.cj.jdbc.Driver");
			         Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/udetail","root","Gauttam@2002");
			         Statement statement = (Statement) con.createStatement();
			         String sql;
			         sql = "delete from totalSeats ";
			         statement.executeUpdate(sql);
			         System.out.println("system reseted");
			         lbl_1.setText("0");
				}
				catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		btnNewButton_2 = new javaprojjd.MyButton();
		btnNewButton_2.setBounds(72, 238, 190, 32);
		btnNewButton_2.setText("Display");
//		Border emptyBorder = BorderFactory.createEmptyBorder();
		btnNewButton_2.setBorder(emptyBorder);
		btnNewButton_2.setFocusPainted(false);
		btnNewButton_2.setColorOver(new Color(255, 225, 225));
		btnNewButton_2.setColorClick(new Color(255, 134, 134));
		btnNewButton_2.setBorderColor(new Color(255,255,255));
		btnNewButton_2.setRadius(30);
		panel.add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DisplayLog detl = new DisplayLog();
				detl.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		btnHome = new javaprojjd.MyButton();
		btnHome.setBounds(72, 300, 190, 32);
//		btnHome = new javaprojjd.MyButton();
//		btnHome.setBounds(320, 238, 167, 32);
		btnHome.setText("Home");
//		Border emptyBorder = BorderFactory.createEmptyBorder();
		btnHome.setBorder(emptyBorder);
		btnHome.setFocusPainted(false);
		btnHome.setColorOver(new Color(255, 225, 225));
		btnHome.setColorClick(new Color(255, 134, 134));
		btnHome.setBorderColor(new Color(255,255,255));
		btnHome.setRadius(30);
		panel.add(btnHome);
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dashboard dsh = new dashboard();
				dsh.setVisible(true);
				setVisible(false);
			}
		});
		btnHome.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		btnNewButton_2_1 = new javaprojjd.MyButton();
		btnNewButton_2_1.setBounds(354, 238, 190, 32);
		btnNewButton_2_1.setText("Get Report");
//		Border emptyBorder = BorderFactory.createEmptyBorder();
		btnNewButton_2_1.setBorder(emptyBorder);
		btnNewButton_2_1.setFocusPainted(false);
		btnNewButton_2_1.setColorOver(new Color(255, 225, 225));
		btnNewButton_2_1.setColorClick(new Color(255, 134, 134));
		btnNewButton_2_1.setBorderColor(new Color(255,255,255));
		btnNewButton_2_1.setRadius(30);
//		panel.add(btnNewButton_2);
		panel.add(btnNewButton_2_1);
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
//			         HashMap hm = new HashMap<>();
			         Class.forName("com.mysql.cj.jdbc.Driver");
			         Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/udetail","root","Gauttam@2002");
			         Statement statement = (Statement) con.createStatement();
			         String sql;
			         sql = "select uname,checkin,checkout from udetails";
//			         PreparedStatement pst = con.prepareStatement(sql);
			         ResultSet resultSet = statement.executeQuery(sql);
//			         table.setModel(DbUtils.resultSetToTableModel(resultSet));
			         try {
			        	String file_name = "C:\\generate_pdf\\test.pdf";
			 			Document doc = new Document();
			 			PdfWriter.getInstance(doc, new FileOutputStream(file_name));
			 			doc.open();
			 			Paragraph para = new Paragraph("User log details\n");
			 			doc.add(para);
			 			Paragraph par1 = new Paragraph("\n");
			 			doc.add(par1);
			 			PdfPTable tbl = new PdfPTable(3);
			 			PdfPCell c1 = new PdfPCell(new Phrase("User name"));
			 			tbl.addCell(c1);
			 			c1 = new PdfPCell(new Phrase("Checkin"));
			 			tbl.addCell(c1);
			 			c1 = new PdfPCell(new Phrase("Checkout"));
			 			tbl.addCell(c1);
//			 			tbl.addCell("User name");
//			 			tbl.addCell("Checkin");
//			 			tbl.addCell("Checkout");
			 			tbl.setHeaderRows(1);
			 			
			 			while(resultSet.next())
						{
							tbl.addCell(resultSet.getString(1));
							tbl.addCell(resultSet.getString(2));
							tbl.addCell(resultSet.getString(3));
						}
			 			doc.add(tbl);
			 			doc.close();
				         JOptionPane.showOptionDialog(null, "Report generated successfully", "Dialog", JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE, new ImageIcon(), buttons, buttons[0]);
//						JOptionPane.showMessageDialog(null, "Report generated successfully");
					} 
			         catch (Exception e2) {
						// TODO: handle exception
					}

			      } 
				catch (Exception e6) {
			         e6.printStackTrace();
			      }
			}
		});
		btnNewButton_2_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		lblNewLabel_1_2 = new JLabel("Admin");
		lblNewLabel_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_2.setFont(new Font("Vivaldi", Font.BOLD, 30));
		lblNewLabel_1_2.setBounds(221, 45, 99, 38);
		panel.add(lblNewLabel_1_2);
		
		lblNewLabel_1_2_1 = new JLabel("Portal");
		lblNewLabel_1_2_1.setForeground(Color.WHITE);
		lblNewLabel_1_2_1.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewLabel_1_2_1.setBounds(313, 44, 99, 38);
		panel.add(lblNewLabel_1_2_1);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(getClass().getResource("/images/abstract (1).png")));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 24));
		lblNewLabel_1.setBounds(10, 11, 64, 68);
		panel.add(lblNewLabel_1);
	}
}
