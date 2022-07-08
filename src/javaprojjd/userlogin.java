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
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.border.MatteBorder;
import javax.swing.plaf.DimensionUIResource;

//import com.itextpdf.text.Image;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import java.awt.Dimension;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;
import javax.swing.AbstractAction;
import javax.swing.Action;
import java.awt.Checkbox;
import java.awt.Button;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class userlogin extends javax.swing.JFrame {

	private JPanel contentPane;
	private JTextField User;
	private JPasswordField Passsword;
	private final Action action = new SwingAction();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					userlogin frame = new userlogin();
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
	public userlogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 699, 537);
		contentPane = new JPanel();
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.RED);
		panel.setBounds(10, 11, 327, 479);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(95, 155, 128, 128);
		panel.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon(getClass().getResource("/images/abstract (3).png")));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 24));
		
		JLabel lblNewLabel_6 = new JLabel("Welcome To");
		lblNewLabel_6.setForeground(Color.WHITE);
		lblNewLabel_6.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 18));
		lblNewLabel_6.setBounds(20, 320, 120, 30);
		panel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_6_1 = new JLabel("OCCUPANCY MONITORING");
		lblNewLabel_6_1.setForeground(Color.WHITE);
		lblNewLabel_6_1.setFont(new Font("Sitka Text", Font.BOLD, 18));
		lblNewLabel_6_1.setBounds(20, 361, 271, 30);
		panel.add(lblNewLabel_6_1);
		
		JLabel lblNewLabel_6_2 = new JLabel("System");
		lblNewLabel_6_2.setForeground(Color.WHITE);
		lblNewLabel_6_2.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 18));
		lblNewLabel_6_2.setBounds(20, 402, 120, 30);
		panel.add(lblNewLabel_6_2);
		
		JLabel lblNewLabel_1_2 = new JLabel("Login");
		lblNewLabel_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_2.setFont(new Font("Vivaldi", Font.PLAIN, 30));
		lblNewLabel_1_2.setBounds(70, 48, 93, 38);
		panel.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Here");
		lblNewLabel_1_3.setForeground(Color.WHITE);
		lblNewLabel_1_3.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		lblNewLabel_1_3.setBounds(160, 50, 78, 34);
		panel.add(lblNewLabel_1_3);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(351, 11, 327, 479);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setBounds(38, 201, 78, 21);
		panel_1.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setBounds(38, 289, 75, 22);
		panel_1.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		
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
		
		Passsword = new JPasswordField(15);
		Passsword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Passsword.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		Passsword.setBounds(35, 322, 230, 28);
		panel_1.add(Passsword);
		Passsword.setColumns(10);
		
		User = new JTextField();
		User.setFont(new Font("Tahoma", Font.PLAIN, 16));
		User.setBounds(35, 233, 230, 28);
		panel_1.add(User);
		User.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		User.setColumns(10);
		
		JButton lginButton = new JButton("Login");
		lginButton.setBorder(new LineBorder(new Color(255, 0, 51), 4, true));
		lginButton.setBackground(new Color(255, 0, 51));
		lginButton.setForeground(Color.WHITE);
		lginButton.setBounds(38, 377, 227, 31);
		panel_1.add(lginButton);
		Border emptyBorder1 = BorderFactory.createEmptyBorder();
		lginButton.setFocusPainted(false);
		lginButton.setBorder(emptyBorder1);
		lginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					// MD5 HASHING for encrypting the passwords.
					String name = Passsword.getText();
					MessageDigest md = MessageDigest.getInstance("MD5");
					md.update(name.getBytes(),0,name.length());
//					System.out.println(new BigInteger(1,md.digest()).toString(16));
					String Pword = new BigInteger(1,md.digest()).toString(16);
//					System.out.println(Pword);
					System.out.println(User.getText());
					System.out.println(Passsword.getText());
					// CONNECTING DATABASE WITH JAVA
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/usportal","root","Gauttam@2002");
					Statement statement = connection.createStatement();
					String sql = ("select * from usdetails where usEmail='"+User.getText()+"' and usPassword = '"+Pword+"' ");
					ResultSet resultset = statement.executeQuery(sql);
					if(resultset.next())
					{
						UserPortal userport = new UserPortal();
						userport.user_name=User.getText();
						userport.pass_word = Pword;
						
						JOptionPane.showOptionDialog(null, "login successfully..", "Dialog", JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE, new ImageIcon(), buttons, buttons[0]);
//						JOptionPane.showMessageDialog(null, "login successfully..");
						User.setText("");
						Passsword.setText("");
						userport.setVisible(true);
						setVisible(false);
					}
					else if(User.getText().equals("") && Passsword.getText().equals(""))
					{
						JOptionPane.showOptionDialog(null, "Username and Password are empty..", "Dialog", JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE, new ImageIcon(), buttons, buttons[0]);
//						JOptionPane.showMessageDialog(null, "Username and Password are empty..");
						User.setText("");
						Passsword.setText("");
					}
					else if(User.getText().equals(""))
					{
						JOptionPane.showOptionDialog(null, "Username is empty..", "Dialog", JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE, new ImageIcon(), buttons, buttons[0]);
//						JOptionPane.showMessageDialog(null, "Username is empty..");
						User.setText("");
						Passsword.setText("");
					}
					else if(Passsword.getText().equals(""))
					{
						JOptionPane.showOptionDialog(null, "Password is empty..", "Dialog", JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE, new ImageIcon(), buttons, buttons[0]);
//						JOptionPane.showMessageDialog(null, "Password is empty..");
						User.setText("");
						Passsword.setText("");
					}
					else
					{
						JOptionPane.showOptionDialog(null, "Incorrect Id or Password..", "Dialog", JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE, new ImageIcon(), buttons, buttons[0]);
//						JOptionPane.showMessageDialog(null, "User is not Registered..");
						User.setText("");
						Passsword.setText("");
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
		
		JButton btnNewButton_1 = new JButton("Sign up");
		btnNewButton_1.setBorder(null);
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setBounds(128, 431, 96, 31);
		panel_1.add(btnNewButton_1);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(getClass().getResource("/images/abstract (1).png")));
		lblNewLabel_3.setBounds(35, 27, 96, 55);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("WELCOME BACK");
		lblNewLabel_4.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblNewLabel_4.setForeground(new Color(220, 20, 60));
		lblNewLabel_4.setBounds(35, 109, 177, 36);
		panel_1.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Sign in to continue");
		lblNewLabel_5.setForeground(UIManager.getColor("CheckBox.shadow"));
		lblNewLabel_5.setFont(new Font("Segoe UI Semilight", Font.BOLD, 14));
		lblNewLabel_5.setBounds(35, 156, 145, 21);
		panel_1.add(lblNewLabel_5);
		
		JLabel lblNewLabel_1_1 = new JLabel("New User ?");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(35, 436, 110, 21);
		panel_1.add(lblNewLabel_1_1);
		
		JLabel icon2 = new JLabel();
		
//		ImageIcon icon = new ImageIcon("C:\\Users\\gautt\\Downloads\\vision-icon-png-21.jpg");
//		Image img = icon.getImage();
//		"C:\Users\gautt\Downloads\download (3).png"
		icon2.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/images/eyeopen.png")).getImage().getScaledInstance(30,20,Image.SCALE_SMOOTH)));
		icon2.setBounds(269, 319, 37, 31);
		panel_1.add(icon2);
		
		JLabel icon1 = new JLabel();
//		icon1.setBounds(252, 279, 49, 14);
//		panel_1.add(icon1);
//		"C:\Users\gautt\Downloads\download (2).png"
		icon1.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/images/download (2).png")).getImage().getScaledInstance(30,30,Image.SCALE_SMOOTH)));
		icon1.setBounds(269, 322, 37, 31);
		panel_1.add(icon1);
		
		icon2.setVisible(false);
		icon2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				icon2.setVisible(false);
				icon1.setVisible(true);
				Passsword.setEchoChar('*');
			}
		});
		icon1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				icon1.setVisible(false);
				icon2.setVisible(true);
				Passsword.setEchoChar((char)0);
			}
		});
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userregister usreg = new userregister();
				usreg.setVisible(true);
				setVisible(false);
			}
		});
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
