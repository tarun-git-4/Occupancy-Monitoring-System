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
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.border.MatteBorder;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;

public class userregister extends JFrame {

	private JPanel contentPane;
	private JTextField uname;
	private JTextField unum;
	private JTextField uadd;
	private JTextField umail;
	private JTextField upass;
	private javaprojjd.MyButton btnNewButton;
	private javaprojjd.MyButton registerButton;
	private javaprojjd.MyButton btnCancel;
	String mess;
	int flag=1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					userregister frame = new userregister();
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
	public userregister() {
//		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 730, 560);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 11, 346, 501);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setBounds(31, 26, 106, 21);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		
		uname = new JTextField();
		uname.setFont(new Font("Tahoma", Font.PLAIN, 16));
		uname.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		uname.setBounds(31, 58, 222, 21);
		panel.add(uname);
		uname.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Ph. Number");
		lblNewLabel_1_1.setBounds(31, 113, 106, 21);
		panel.add(lblNewLabel_1_1);
		lblNewLabel_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		
		unum = new JTextField();
		unum.setFont(new Font("Tahoma", Font.PLAIN, 16));
		unum.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		unum.setBounds(31, 145, 222, 21);
		panel.add(unum);
		unum.setColumns(10);
		
		JLabel lblNewLabel_1_2 = new JLabel("Address");
		lblNewLabel_1_2.setBounds(31, 191, 106, 21);
		panel.add(lblNewLabel_1_2);
		lblNewLabel_1_2.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		
		uadd = new JTextField();
		uadd.setFont(new Font("Tahoma", Font.PLAIN, 16));
		uadd.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		uadd.setBounds(31, 223, 222, 21);
		panel.add(uadd);
		uadd.setColumns(10);
		
		JLabel lblNewLabel_1_3 = new JLabel("Username");
		lblNewLabel_1_3.setBounds(31, 272, 106, 21);
		panel.add(lblNewLabel_1_3);
		lblNewLabel_1_3.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		
		umail = new JTextField();
		umail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		umail.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		umail.setBounds(31, 304, 222, 21);
		panel.add(umail);
		umail.setColumns(10);
		
		JLabel lblNewLabel_1_4 = new JLabel("Password");
		lblNewLabel_1_4.setBounds(31, 341, 106, 21);
		panel.add(lblNewLabel_1_4);
		lblNewLabel_1_4.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		
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
		
		upass = new JTextField();
		upass.setFont(new Font("Tahoma", Font.PLAIN, 16));
		upass.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		upass.setBounds(31, 373, 222, 21);
		panel.add(upass);
		upass.setColumns(10);
//		Border emptyBorder = BorderFactory.createEmptyBorder();
		registerButton = new javaprojjd.MyButton();
		registerButton.setBounds(31, 428, 137, 37);
		registerButton.setText("Sign Up");
		registerButton.setForeground(new Color(255, 255, 255));
		registerButton.setBorder(emptyBorder);
		registerButton.setFocusPainted(false);
		registerButton.setColorOver(new Color(255, 51, 0));
		registerButton.setColor(new Color(255,51,0));
		registerButton.setColorClick(new Color(255, 134, 134));
		registerButton.setBorderColor(new Color(255,255,255));
		registerButton.setRadius(30);
		panel.add(registerButton);
		registerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mess = "";
				flag=1;
				if(uname.getText().equals(""))
				{
					mess+="Name is not filled\n";
					flag=0;
				}
				if(unum.getText().equals(""))
				{
					mess+="Phone number is not filled\n";
					flag=0;
				}
				if(uadd.getText().equals(""))
				{
					mess+="Address is not filled\n";
					flag=0;
				}
				if(umail.getText().equals(""))
				{
					mess+="Email is not filled\n";
					flag=0;
				}
				if(upass.getText().equals(""))
				{
					mess+="Password is not filled\n";
					flag=0;
				}
				if(flag==0)
				{
					JOptionPane.showOptionDialog(null, mess, "Dialog", JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE, new ImageIcon(), buttons, buttons[0]);
//					JOptionPane.showInternalMessageDialog(null, mess);
				}
				else
				{
					try {
						// MD5 HASHING for encrypting the passwords.
						String name = upass.getText();
						MessageDigest md = MessageDigest.getInstance("MD5");
						md.update(name.getBytes(),0,name.length());
//						System.out.println(new BigInteger(1,md.digest()).toString(16));
						String Pword = new BigInteger(1,md.digest()).toString(16);
//						System.out.println(Pword);
					      
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/usportal","root","Gauttam@2002");
//						Statement statement = connection.createStatement();
						String query = " insert into usdetails (usName,usPhone,usAddress,usEmail,usPassword)"
						        + " values (?,?,?,?,?)";
						String strr = unum.getText();
						PreparedStatement preparedStmt = connection.prepareStatement(query);
					      preparedStmt.setString (1,uname.getText());
					      preparedStmt.setLong (2,Integer.parseInt(strr));
					      preparedStmt.setString (3,uadd.getText());
					      preparedStmt.setString (4,umail.getText());
					      preparedStmt.setString (5,Pword);

					      preparedStmt.execute();
					      connection.close();
					      userlogin uslgin = new userlogin();
					      uslgin.setVisible(true);
					      setVisible(false);
							JOptionPane.showOptionDialog(null, "User Registered Successfully...", "Dialog", JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE, new ImageIcon(), buttons, buttons[0]);

//					      JOptionPane.showMessageDialog(null, "User Registered Successfully...");

					}
					catch(Exception e2)
					{
						System.out.print(e2);
						JOptionPane.showOptionDialog(null, "Registeration failed...", "Dialog", JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE, new ImageIcon(), buttons, buttons[0]);

//						JOptionPane.showInternalMessageDialog(null, "Registeration failed...");
					}
				}
				
			}
		});
		registerButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		btnCancel = new javaprojjd.MyButton();
		btnCancel.setBounds(178, 428, 137, 37);
		btnCancel.setText("Cancel");
		btnCancel.setForeground(new Color(255, 255, 255));
		btnCancel.setBorder(emptyBorder);
		btnCancel.setFocusPainted(false);
		btnCancel.setColorOver(new Color(189, 8, 28));
		btnCancel.setColor(new Color(189, 8, 28));
		btnCancel.setColorClick(new Color(255, 134, 134));
		btnCancel.setBorderColor(new Color(255,255,255));
		btnCancel.setRadius(30);
		panel.add(btnCancel);
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userlogin act1 = new userlogin();
				act1.setVisible(true);
				setVisible(false);
			}
		});
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.RED);
		panel_2.setBounds(360, 11, 346, 501);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(getClass().getResource("/images/abstract (1).png")));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 24));
		lblNewLabel.setBounds(0, 0, 71, 77);
		panel_2.add(lblNewLabel);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Register");
		lblNewLabel_1_2_1.setForeground(Color.WHITE);
		lblNewLabel_1_2_1.setFont(new Font("Vivaldi", Font.PLAIN, 30));
		lblNewLabel_1_2_1.setBounds(112, 35, 115, 38);
		panel_2.add(lblNewLabel_1_2_1);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("Here");
		lblNewLabel_1_3_1.setForeground(Color.WHITE);
		lblNewLabel_1_3_1.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		lblNewLabel_1_3_1.setBounds(217, 36, 78, 34);
		panel_2.add(lblNewLabel_1_3_1);
		
		JLabel lblNewLabel_6 = new JLabel("Welcome BACK");
		lblNewLabel_6.setForeground(Color.WHITE);
		lblNewLabel_6.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 24));
		lblNewLabel_6.setBounds(89, 168, 198, 59);
		panel_2.add(lblNewLabel_6);
		
		JLabel lblNewLabel_6_1 = new JLabel("To keep connected with us please");
//		lblNewLabel_6_1.
		lblNewLabel_6_1.setForeground(Color.WHITE);
		lblNewLabel_6_1.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 18));
		lblNewLabel_6_1.setBounds(47, 238, 289, 43);
		panel_2.add(lblNewLabel_6_1);
		
		JLabel lblNewLabel_6_1_1 = new JLabel("login your personal info");
		lblNewLabel_6_1_1.setForeground(Color.WHITE);
		lblNewLabel_6_1_1.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 18));
		lblNewLabel_6_1_1.setBounds(89, 266, 249, 43);
		panel_2.add(lblNewLabel_6_1_1);
		
		btnNewButton = new javaprojjd.MyButton();
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNewButton.setBounds(101, 358, 157, 43);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.setText("Sign In");
//		Border emptyBorder = BorderFactory.createEmptyBorder();
		btnNewButton.setBorder(emptyBorder);
		btnNewButton.setFocusPainted(false);
		btnNewButton.setColorOver(new Color(255, 255, 255));
		btnNewButton.setColorClick(new Color(255, 134, 134));
		btnNewButton.setBorderColor(new Color(255,255,255));
		btnNewButton.setRadius(30);
		panel_2.add(btnNewButton);
	}
}
