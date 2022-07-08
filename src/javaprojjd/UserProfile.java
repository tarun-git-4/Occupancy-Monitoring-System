package javaprojjd;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

public class UserProfile extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	protected String usr_name = "123",usr_pass = "456";
	protected String name,address,phone,addr1;
	UserPortal usport;
//	private JButton btnNewButton;
	private javaprojjd.MyButton btnNewButton;
	private javaprojjd.MyButton btnEditProfile;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					UserProfile frame = new UserProfile();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public void user_profile()
	{
//		usport = new UserPortal();
//		usr_name = usport.user_name;
//		usr_pass = usport.pass_word;
		System.out.println(usr_name);
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/usportal","root","Gauttam@2002");
			Statement statement = connection.createStatement();
			String sql = ("select * from usdetails where usEmail='"+usr_name+"' ");
			ResultSet resultset = statement.executeQuery(sql);
			while(resultset.next())
			{
				name = resultset.getString(1);
				phone = resultset.getString(2);
				address = "<html>";
				address += resultset.getString(3);
				address+="</html>";
				addr1 = resultset.getString(3);
			}
		} 
		catch (Exception e) {
			// TODO: handle exception
		}
	}
	public UserProfile(String ussname,String ussword) {
		System.out.println(usr_name);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 743, 484);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		usr_name = ussname;
		usr_pass = ussword;
		user_profile();
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(382, 11, 331, 425);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setBounds(32, 45, 84, 21);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 20));
		
		textField = new JTextField();
		textField.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		textField.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		textField.setBounds(32, 92, 224, 21);
		panel.add(textField);
		textField.setColumns(10);
		//		System.out.println(name);
		//		System.out.println(phone);
		//		System.out.println(address);
		//		System.out.println(usr_name);
		//		System.out.println(usr_pass);
				textField.setText(name);
				
				JLabel lblname = new JLabel("New label");
				lblname.setFont(new Font("Times New Roman", Font.PLAIN, 18));
				lblname.setBounds(32, 92, 224, 21);
				panel.add(lblname);
				
				lblname.setText(name);
				
				JLabel lblNewLabel_1_1 = new JLabel("Ph. Number");
				lblNewLabel_1_1.setBounds(32, 151, 142, 21);
				panel.add(lblNewLabel_1_1);
				lblNewLabel_1_1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 20));
				
				textField_1 = new JTextField();
				textField_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
				textField_1.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
				textField_1.setBounds(32, 202, 224, 21);
				panel.add(textField_1);
				textField_1.setColumns(10);
				textField_1.setText(phone);
				
				JLabel lblNewLabel_1_2 = new JLabel("Address");
				lblNewLabel_1_2.setBounds(32, 264, 106, 21);
				panel.add(lblNewLabel_1_2);
				lblNewLabel_1_2.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 20));
				
				textField_2 = new JTextField();
				textField_2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
				textField_2.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
				textField_2.setBounds(32, 306, 224, 21);
				panel.add(textField_2);
				textField_2.setColumns(10);
				textField_2.setText(addr1);
				
				JPanel panel_1 = new JPanel();
				panel_1.setBackground(Color.RED);
				panel_1.setBounds(10, 11, 353, 425);
				contentPane.add(panel_1);
				panel_1.setLayout(null);
				
				JLabel icon2 = new JLabel("");
				icon2.setHorizontalAlignment(SwingConstants.CENTER);
//				icon2.setIcon(new ImageIcon("C:\\Users\\gautt\\Downloads\\pngfind.com-profile-icon-png-1102927.png"));
				icon2.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\gautt\\Downloads\\pngfind.com-profile-icon-png-1102927.png").getImage().getScaledInstance(100,100,Image.SCALE_SMOOTH)));
				icon2.setBounds(103, 89, 156, 143);
				panel_1.add(icon2);
				
				JLabel lblNewLabel_2 = new JLabel("");
				lblNewLabel_2.setVerticalAlignment(SwingConstants.TOP);
				lblNewLabel_2.setForeground(Color.WHITE);
				lblNewLabel_2.setFont(new Font("Viner Hand ITC", Font.BOLD, 20));
				lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel_2.setBounds(85, 229, 187, 49);
				panel_1.add(lblNewLabel_2);
				
				lblNewLabel_2.setText("Gauttam goyal");
				
				JLabel lblNewLabel_3 = new JLabel("Ph No. :");
				lblNewLabel_3.setForeground(Color.WHITE);
				lblNewLabel_3.setFont(new Font("Sitka Text", Font.BOLD, 18));
				lblNewLabel_3.setBounds(21, 302, 89, 28);
				panel_1.add(lblNewLabel_3);
				
				JLabel lblNewLabel_3_1 = new JLabel("Address :");
				lblNewLabel_3_1.setForeground(Color.WHITE);
				lblNewLabel_3_1.setFont(new Font("Sitka Text", Font.BOLD, 18));
				lblNewLabel_3_1.setBounds(21, 341, 89, 28);
				panel_1.add(lblNewLabel_3_1);
				
				JLabel lblphone = new JLabel("New label");
				lblphone.setForeground(Color.WHITE);
				lblphone.setVerticalAlignment(SwingConstants.TOP);
				lblphone.setBounds(103, 302, 224, 21);
				panel_1.add(lblphone);
				lblphone.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
				lblphone.setText("hgkjkj");
				
				JLabel lbladdress = new JLabel("New label");
				lbladdress.setForeground(Color.WHITE);
				lbladdress.setVerticalAlignment(SwingConstants.TOP);
				lbladdress.setBounds(113, 341, 216, 73);
				panel_1.add(lbladdress);
				lbladdress.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
				lbladdress.setText("efwefefew");
				
				lblphone.setText(phone);
				lbladdress.setText(address);
				lblNewLabel_2.setText(name);
				
				JLabel lblNewLabel_1_2_1 = new JLabel("User");
				lblNewLabel_1_2_1.setForeground(Color.WHITE);
				lblNewLabel_1_2_1.setFont(new Font("Vivaldi", Font.BOLD, 30));
				lblNewLabel_1_2_1.setBounds(111, 40, 99, 38);
				panel_1.add(lblNewLabel_1_2_1);
				
				JLabel lblNewLabel_1_2_1_1 = new JLabel("Profile");
				lblNewLabel_1_2_1_1.setForeground(Color.WHITE);
				lblNewLabel_1_2_1_1.setFont(new Font("Times New Roman", Font.BOLD, 30));
				lblNewLabel_1_2_1_1.setBounds(193, 40, 99, 38);
				panel_1.add(lblNewLabel_1_2_1_1);
				
				JLabel lblNewLabel_5 = new JLabel("");
				lblNewLabel_5.setIcon(new ImageIcon("C:\\Users\\gautt\\Downloads\\abstract (1).png"));
				lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 24));
				lblNewLabel_5.setBounds(10, 11, 64, 68);
				panel_1.add(lblNewLabel_5);
				
				btnEditProfile = new javaprojjd.MyButton();
				btnEditProfile.setBounds(28, 364, 131, 38);
				btnEditProfile.setText("Edit Profile");
				btnEditProfile.setFont(new Font("Tahoma", Font.BOLD, 15));
//				btnNewButton.setText("Sign In");
				Border emptyBorder = BorderFactory.createEmptyBorder();
				btnEditProfile.setBorder(emptyBorder);
				btnEditProfile.setFocusPainted(false);
				btnEditProfile.setColor(new Color(189, 8, 28));
				btnEditProfile.setForeground(new Color(255,255,255));
				btnEditProfile.setColorOver(new Color(255, 225, 225));
				btnEditProfile.setColorClick(new Color(255, 134, 134));
				btnEditProfile.setBorderColor(new Color(255,255,255));
				btnEditProfile.setRadius(30);
				
				panel.add(btnEditProfile);
				btnEditProfile.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						textField_1.setEditable(true);
						textField.setEditable(true);
						textField_2.setEditable(true);
//						lblname.setVisible(false);
//						lblphone.setVisible(false);
//						lbladdress.setVisible(false);
						
					}
				});
//				btnEditProfile.setFont(new Font("Tahoma", Font.BOLD, 14));
				
				btnNewButton = new javaprojjd.MyButton();
				btnNewButton.setText("Update Profile");
				btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
//				btnNewButton.setText("Sign In");
//				Border emptyBorder = BorderFactory.createEmptyBorder();
				btnNewButton.setBorder(emptyBorder);
				btnNewButton.setFocusPainted(false);
				btnNewButton.setColor(new Color(189, 8, 28));
				btnNewButton.setForeground(new Color(255,255,255));
				btnNewButton.setColorOver(new Color(255, 225, 225));
				btnNewButton.setColorClick(new Color(255, 134, 134));
				btnNewButton.setBorderColor(new Color(255,255,255));
				btnNewButton.setRadius(30);
				btnNewButton.setBounds(169, 364, 131, 38);
				panel.add(btnNewButton);
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try 
						{
							Class.forName("com.mysql.cj.jdbc.Driver");
							Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/usportal","root","Gauttam@2002");
							Statement statement = connection.createStatement();
							String sql = ("update usdetails set usname='"+textField.getText()+"', usPhone='"+textField_1.getText()+"', usAddress='"+textField_2.getText()+"' where usEmail='"+usr_name+"'");
							statement.executeUpdate(sql);
							user_profile();
							textField_1.setEditable(false);
							textField.setEditable(false);
							textField_2.setEditable(false);
							lblname.setVisible(true);
							lblphone.setVisible(true);
							lbladdress.setVisible(true);
							lblname.setText(name);
							lblphone.setText(phone);
							lbladdress.setText(address);
							lblNewLabel_2.setText(name);
							
							
						} 
						catch (Exception e3) {
							// TODO: handle exception
						}
					}
				});
//				btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
				
				
				textField_2.setEditable(false);
				
				textField_1.setEditable(false);
				textField.setEditable(false);
		
		
	}
}
