package javaprojjd;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class DisplayLog extends javax.swing.JFrame {

	private JPanel contentPane;
	private javaprojjd.MyButton btnNewButton;
	private javaprojjd.MyButton btnNewButton_1;
	private JTable table;
	private JPanel panel;
	private JLabel lblNewLabel;
//	private button.MyButton myButton2;
//	private button.MyButton myButton3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DisplayLog frame = new DisplayLog();
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
	public DisplayLog() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 637, 417);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		Border emptyBorder = BorderFactory.createEmptyBorder();
        
        panel = new JPanel();
        panel.setBackground(Color.RED);
        panel.setBounds(10, 11, 603, 358);
        contentPane.add(panel);
        panel.setLayout(null);
        btnNewButton = new javaprojjd.MyButton();
        btnNewButton.setBounds(122, 66, 161, 34);
        btnNewButton.setText("Display Log details");
		btnNewButton.setColorOver(new Color(255, 225, 225));
		btnNewButton.setColorClick(new Color(255, 134, 134));
		btnNewButton.setBorderColor(new Color(255,255,255));
		btnNewButton.setRadius(30);
        panel.add(btnNewButton);
        //		JButton btnNewButton = new JButton("Show Log details");
        		
//        		btnNewButton.setRadius(50);
        		btnNewButton.addActionListener(new ActionListener() {
        			public void actionPerformed(ActionEvent e) {
        				try {
//			         HashMap hm = new HashMap<>();
        			         Class.forName("com.mysql.cj.jdbc.Driver");
        			         Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/udetail","root","Gauttam@2002");
        			         Statement statement = (Statement) con.createStatement();
        			         String sql;
        			         sql = "select uname,checkin,checkout from udetails";
        			         PreparedStatement pst = con.prepareStatement(sql);
        			         ResultSet resultSet = pst.executeQuery();
        			         table.setModel(DbUtils.resultSetToTableModel(resultSet));

        			      } 
        				catch (Exception e6) {
        			         e6.printStackTrace();
        			      }
        			}
        		});
        		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
        		btnNewButton.setBorder(emptyBorder);
        		btnNewButton.setFocusPainted(false);
        		
        		MyButton btnNewButton_1_1 = new MyButton();
        		btnNewButton_1_1.setBounds(327, 66, 161,34);
        		btnNewButton_1_1.setColorOver(new Color(255, 225, 225));
        		btnNewButton_1_1.setColorClick(new Color(255, 134, 134));
        		btnNewButton_1_1.setBorderColor(new Color(255,255,255));
        		btnNewButton_1_1.setRadius(30);
        		btnNewButton_1_1.setText("Go Back");
        		btnNewButton_1_1.setBorder(emptyBorder);
        		btnNewButton_1_1.setFocusPainted(false);
        		panel.add(btnNewButton_1_1);
        		btnNewButton_1_1.addActionListener(new ActionListener() {
        			public void actionPerformed(ActionEvent e) {
        				AdminPortal admnport = new AdminPortal();
        				admnport.setVisible(true);
        				setVisible(false);
        			}
        		});
        		btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
        		
//        		btnNewButton_1_1.setRadius(50);
        		//		btnNewButton.setRadius(50);
        				JScrollPane scrollPane = new JScrollPane();
        				scrollPane.setFont(new Font("Viner Hand ITC", Font.PLAIN, 30));
        				scrollPane.setBackground(Color.WHITE);
        				scrollPane.setBounds(40, 133, 519, 193);
        				panel.add(scrollPane);
        				//		table.setBorder(null);
        						table = new JTable();
        						scrollPane.setViewportView(table);
        						
        						lblNewLabel = new JLabel("");
        						lblNewLabel.setIcon(new ImageIcon(getClass().getResource("/images/abstract (1).png")));
        						lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        						lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 24));
        						lblNewLabel.setBounds(10, 11, 58, 58);
        						panel.add(lblNewLabel);
	}
}
