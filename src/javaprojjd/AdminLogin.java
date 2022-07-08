package javaprojjd;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.border.MatteBorder;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;

public class AdminLogin extends JFrame {

	private JPanel contentPane;
	private JTextField adname;
	private JPasswordField adpword;
	private javaprojjd.MyButton lginButton;
	private javaprojjd.MyButton btnGoBack;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminLogin frame = new AdminLogin();
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
	public AdminLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 616, 423);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.RED);
		panel.setBounds(10, 11, 585, 366);
		contentPane.add(panel);
		panel.setLayout(null);
		
		adname = new JTextField();
		adname.setFont(new Font("Tahoma", Font.PLAIN, 14));
		adname.setForeground(Color.WHITE);
		adname.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.WHITE));
		adname.setBackground(Color.RED);
		adname.setBounds(254, 149, 212, 21);
		panel.add(adname);
		adname.setColumns(10);
		
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
		
		JLabel lblNewLabel_1 = new JLabel("Username :");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(100, 146, 116, 21);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.PLAIN, 19));
		
		JLabel lblNewLabel_2 = new JLabel("Password :");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(100, 207, 116, 21);
		panel.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Segoe UI", Font.PLAIN, 19));
		
		adpword = new JPasswordField();
		adpword.setForeground(Color.WHITE);
		adpword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		adpword.setBackground(Color.RED);
		adpword.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.WHITE));
		adpword.setBounds(254, 207, 212, 21);
		panel.add(adpword);
		adpword.setEchoChar('*');
		adpword.setColumns(10);
		
		btnGoBack = new javaprojjd.MyButton();
		btnGoBack.setText("Go Back");
		btnGoBack.setBounds(282, 292, 147, 31);
//		Border emptyBorder = BorderFactory.createEmptyBorder();
		btnGoBack.setBorder(emptyBorder);
		btnGoBack.setFocusPainted(false);
		btnGoBack.setColorOver(new Color(255, 225, 225));
		btnGoBack.setColorClick(new Color(255, 134, 134));
		btnGoBack.setBorderColor(new Color(255,255,255));
		btnGoBack.setRadius(30);
		panel.add(btnGoBack);
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dashboard dsh = new dashboard();
				dsh.setVisible(true);
				setVisible(false);
			}
		});
		btnGoBack.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		lginButton = new javaprojjd.MyButton();
		lginButton.setBounds(83, 292, 147, 31);
		lginButton.setText("Log In");
		lginButton.setBorder(emptyBorder);
		lginButton.setFocusPainted(false);
		lginButton.setColorOver(new Color(255, 225, 225));
		lginButton.setColorClick(new Color(255, 134, 134));
		lginButton.setBorderColor(new Color(255,255,255));
		lginButton.setRadius(30);
		panel.add(lginButton);
		lginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					// MD5 HASHING for encrypting the passwords.
					String name = adpword.getText();
					MessageDigest md = MessageDigest.getInstance("MD5");
					md.update(name.getBytes(),0,name.length());
//					System.out.println(new BigInteger(1,md.digest()).toString(16));
					String Pword = new BigInteger(1,md.digest()).toString(16);
					System.out.println(Pword);
					
					// CONNECTING DATABASE WITH JAVA
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/adportal","root","Gauttam@2002");
					Statement statement = connection.createStatement();
					String sql = ("select * from addetails where adEmail='"+adname.getText()+"' and adPassword = '"+Pword+"' ");
					ResultSet resultset = statement.executeQuery(sql);
					if(resultset.next())
					{
				         JOptionPane.showOptionDialog(null, "login successfully..", "Dialog", JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE, new ImageIcon(), buttons, buttons[0]);
//						JOptionPane.showMessageDialog(null, "login successfully..");
						AdminPortal admnp = new AdminPortal();
						admnp.setVisible(true);
						setVisible(false);
//						System.out.println(md5('hello'));
//						frame.dispose();
//						customerinfo cst = new customerinfo();
//						cst.setVisible(true);
					}
					else
					{
				         JOptionPane.showOptionDialog(null, "Incorrect login..", "Dialog", JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE, new ImageIcon(), buttons, buttons[0]);
//						JOptionPane.showMessageDialog(null, "Incorrect login..");
//						System.out.println(usPassword);
					}
				}
				catch(Exception e1)
				{
					System.out.print(e1);
				}
			}
		});
		lginButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Admin");
		lblNewLabel_1_2_1.setForeground(Color.WHITE);
		lblNewLabel_1_2_1.setFont(new Font("Vivaldi", Font.BOLD, 30));
		lblNewLabel_1_2_1.setBounds(203, 53, 99, 38);
		panel.add(lblNewLabel_1_2_1);
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel("Login");
		lblNewLabel_1_2_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_2_1_1.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewLabel_1_2_1_1.setBounds(292, 52, 115, 38);
		panel.add(lblNewLabel_1_2_1_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(getClass().getResource("/images/abstract (1).png")));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 24));
		lblNewLabel.setBounds(10, 11, 71, 69);
		panel.add(lblNewLabel);
	}
}
