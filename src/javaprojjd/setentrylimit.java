package javaprojjd;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import com.mysql.cj.protocol.a.NativeConstants.IntegerDataType;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.border.MatteBorder;

public class setentrylimit extends JFrame {

	private JPanel contentPane;
	private JTextField limitfield;
	private javaprojjd.MyButton Savebtn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					setentrylimit frame = new setentrylimit();
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
	public setentrylimit() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 338, 310);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 11, 311, 256);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Limit  :");
		lblNewLabel_1.setBounds(45, 96, 88, 28);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("SimSun-ExtB", Font.BOLD, 18));
		
		limitfield = new JTextField();
		limitfield.setBorder(new MatteBorder(0, 2, 2, 0, (Color) new Color(0, 0, 0)));
		limitfield.setBounds(143, 97, 88, 28);
		panel.add(limitfield);
		limitfield.setFont(new Font("Tahoma", Font.PLAIN, 17));
		limitfield.setText("0");
		limitfield.setColumns(10);
		
		Savebtn = new javaprojjd.MyButton();
		Savebtn.setBounds(62, 182, 182, 28);
		Border emptyBorder = BorderFactory.createEmptyBorder();
		Savebtn.setText("Save and Back");
		Savebtn.setForeground(new Color(255, 255, 255));
		Savebtn.setBorder(emptyBorder);
		Savebtn.setFocusPainted(false);
		Savebtn.setColorOver(new Color(189, 8, 28));
		Savebtn.setColor(new Color(189, 8, 28));
		Savebtn.setColorClick(new Color(255, 134, 134));
		Savebtn.setBorderColor(new Color(255,255,255));
		Savebtn.setRadius(30);
		panel.add(Savebtn);
		Savebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int n;
				n = Integer.parseInt(limitfield.getText());
				String message = Integer.toString(n);
				
//				UserPortal usport = new UserPortal();
//				usport.str=message;
				try {
				      
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/udetail","root","Gauttam@2002");
//					Statement statement = connection.createStatement();
					String query = " insert into totalSeats (capa)"
					        + " values (?)";
//					String sql = ("insert into details value ('"+userid.getText()+"','"+pcode.getText()+"') ");
					PreparedStatement preparedStmt = connection.prepareStatement(query);
				      preparedStmt.setInt(1, n);
				    

				      // execute the preparedstatement
				      preparedStmt.execute();
				      connection.close();
				      
				     

//					   JOptionPane.showMessageDialog(null,"new user entered at ");
//				      JOptionPane.showInternalMessageDialog(null, "Registered successfully...");
				}
				catch(Exception e2)
				{
					System.out.print(e2);
//					JOptionPane.showInternalMessageDialog(null, "Registeration failed...");
				}
//				System.out.println(usport.str);
				AdminPortal addn = new AdminPortal();
//				addn.lim = message;
//				System.out.println(addn.lim);
				
				addn.setVisible(true);
				setVisible(false);
			}
		});
		Savebtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblNewLabel_1_2 = new JLabel("Occupancy");
		lblNewLabel_1_2.setForeground(Color.RED);
		lblNewLabel_1_2.setFont(new Font("Vivaldi", Font.BOLD, 30));
		lblNewLabel_1_2.setBounds(42, 29, 149, 38);
		panel.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Portal");
		lblNewLabel_1_2_1.setForeground(Color.RED);
		lblNewLabel_1_2_1.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewLabel_1_2_1.setBounds(172, 28, 99, 38);
		panel.add(lblNewLabel_1_2_1);
	}
}
