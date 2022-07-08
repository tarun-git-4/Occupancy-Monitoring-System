package javaprojjd;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class UserPortal extends javax.swing.JFrame {

	private JPanel contentPane;
	protected String str="0";
	protected String str1="0";
	protected String user_name,pass_word;
	protected String st="";
	int cnt=0;
	int user_limit=0;
	private javaprojjd.MyButton btnNewButton;
	private javaprojjd.MyButton btnActivityLog;
	private javaprojjd.MyButton btnExitBuilding;
	private javaprojjd.MyButton btnEnterBuilding;
	private javaprojjd.MyButton btnProfile;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				setentrylimit stry = new setentrylimit();
				stry.getClass();
				
				try {
					UserPortal frame = new UserPortal();
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
	        	 str = resultSet.getString("capa");
	        	 user_limit = resultSet.getInt("capa");
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
	public int checkAvailable()
	{
		int flg=0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/udetail","root","Gauttam@2002");
			Statement statement = connection.createStatement();
			String sql = ("select count(*) from udetails where checkout is null ");
			ResultSet resultset = statement.executeQuery(sql);
			resultset.next();
			cnt = resultset.getInt(1);
//			System.out.println(cnt);
			str1 = Integer.toString(user_limit-cnt);
			flg=1;
		}
		catch(Exception e3)
		{
			System.out.print(e3);
		}
		return flg;
	}

	public void viewLogDetails() {
		try {
//	         HashMap hm = new HashMap<>();
	         Class.forName("com.mysql.cj.jdbc.Driver");
	         Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/udetail","root","Gauttam@2002");
	         Statement statement = (Statement) con.createStatement();
	         String sql;
	         sql = "select * from udetails where uname='"+user_name+"'";
	         ResultSet resultSet = statement.executeQuery(sql);
	         st=("<html>");
	         while (resultSet.next()) {
//	         hm.put(resultSet.getString("username"), resultSet.getString("pass"));
//	        	 st="";
	        	 st += ("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+resultSet.getString("uname")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+resultSet.getString("checkin")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+resultSet.getString("checkout")+"<br>");
	      }
	         st+="</html>";
//	         datatext.setText(st);
//	         JOptionPane.showMessageDialog(null, st);
	        
//	      System.out.println(hm);

	      } 
		catch (Exception e6) 
		{
	         e6.printStackTrace();
	         
	     }
	}
	public int checkUser() {
		int check = 0;
		try {
//	         HashMap hm = new HashMap<>();
	         Class.forName("com.mysql.cj.jdbc.Driver");
	         Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/udetail","root","Gauttam@2002");
	         Statement statement = (Statement) con.createStatement();
	         String sql;
	         sql = "select * from udetails where uname='"+user_name+"'";
	         ResultSet resultSet = statement.executeQuery(sql);
	         while (resultSet.next()) {
	         if(resultSet.getString("checkout")==null) {
	        	 check=1;
	        	 
	         }
	      }

	      } 
		catch (Exception e6) 
		{
	        e6.printStackTrace();
	    }
		return check;
	}
	public UserPortal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 776, 533);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(null);
		panel.setBackground(Color.RED);
		panel.setBounds(10, 11, 740, 470);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Dashboard");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(344, 20, 217, 68);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tw Cen MT", Font.PLAIN, 30));
		
		JLabel lblNewLabel_1_1 = new JLabel("Total Seats :");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setBounds(177, 129, 137, 23);
		panel.add(lblNewLabel_1_1);
		lblNewLabel_1_1.setFont(new Font("SimSun-ExtB", Font.BOLD, 20));
		
		JLabel lblNewLabel_2_1 = new JLabel("00");
		lblNewLabel_2_1.setBounds(344, 130, 65, 23);
		panel.add(lblNewLabel_2_1);
		lblNewLabel_2_1.setFont(new Font("Viner Hand ITC", Font.BOLD, 20));
		
		JLabel lblNewLabel_2 = new JLabel("00");
		lblNewLabel_2.setBounds(344, 164, 65, 23);
		panel.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Viner Hand ITC", Font.BOLD, 20));
		
		JLabel lblNewLabel_1 = new JLabel("Available Seats :");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(131, 163, 196, 23);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("SimSun", Font.BOLD, 20));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(36, 205, 400, 231);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(220, 20, 60));
		panel_2.setBounds(0, 0, 400, 50);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("    User Name              Checkin                Checkout");
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setFont(new Font("Viner Hand ITC", Font.PLAIN, 18));
		lblNewLabel_4.setBounds(0, 0, 400, 50);
		panel_2.add(lblNewLabel_4);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 255, 255));
		panel_3.setBounds(0, 52, 400, 179);
		panel_1.add(panel_3);
		panel_3.setLayout(null);
		
		panel_3.setVisible(false);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBackground(new Color(255, 255, 255));
		lblNewLabel_3.setBounds(10, 11, 381, 159);
		panel_3.add(lblNewLabel_3);
		lblNewLabel_3.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_3.setVerticalAlignment(SwingConstants.TOP);
		
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
		
		btnNewButton = new javaprojjd.MyButton();
		btnNewButton.setBounds(505, 216, 176, 33);
		btnNewButton.setText("Check Occupancy");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
//		btnNewButton.setText("Sign In");
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

				if(OccupancyCheck()==1)
				{
					lblNewLabel_2_1.setText(str);
//					lblNewLabel_2.setText(str1);
				}
				if(checkAvailable()==1)
				{
					lblNewLabel_2.setText(str1);
				}
				else
				{
					System.out.println("error occured");
				}
			}
		});
		btnNewButton.setFont(new Font("SimSun", Font.BOLD, 15));
		
		btnActivityLog = new javaprojjd.MyButton();
		btnActivityLog.setBounds(505, 157, 176, 33);
		btnActivityLog.setText("Activity Log");
		btnActivityLog.setBorder(emptyBorder);
		btnActivityLog.setFocusPainted(false);
		btnActivityLog.setColorOver(new Color(255, 225, 225));
		btnActivityLog.setColorClick(new Color(255, 134, 134));
		btnActivityLog.setBorderColor(new Color(255,255,255));
		btnActivityLog.setRadius(30);
		panel.add(btnActivityLog);
		btnActivityLog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewLogDetails();
				panel_3.setVisible(true);
				lblNewLabel_3.setText(st);
				
			}
		});
		btnActivityLog.setFont(new Font("SimSun", Font.BOLD, 15));
		
		btnExitBuilding = new javaprojjd.MyButton();
		btnExitBuilding.setBounds(505, 279, 176, 33);
		btnExitBuilding.setText("Exit Building");
		btnExitBuilding.setBorder(emptyBorder);
		btnExitBuilding.setFocusPainted(false);
		btnExitBuilding.setColorOver(new Color(255, 225, 225));
		btnExitBuilding.setColorClick(new Color(255, 134, 134));
		btnExitBuilding.setBorderColor(new Color(255,255,255));
		btnExitBuilding.setRadius(30);
		panel.add(btnExitBuilding);
		btnExitBuilding.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				      DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");  
					   LocalDateTime now = LocalDateTime.now();

					   java.util.Date date=new java.util.Date();
					   java.sql.Date sqlDate=new java.sql.Date(date.getTime());
					   java.sql.Timestamp sqlTime=new java.sql.Timestamp(date.getTime());
//					   System.out.println(dtf.format(now));  
					   String dt = dtf.format(now).toString();
					  Class.forName("com.mysql.cj.jdbc.Driver");
					Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/udetail","root","Gauttam@2002");
					Statement statement = connection.createStatement();
					String query1 = "select * from udetails where uname='"+user_name+"'";
					ResultSet resultSet1 = statement.executeQuery(query1);
//					ResultSet resultSet2 = statement.executeQuery(query1);
//					System.out.println(resultSet1.next());
					if(resultSet1.next()==false)
					{
						JOptionPane.showOptionDialog(null, "You have not entered in the building", "Dialog", JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE, new ImageIcon(), buttons, buttons[0]);
//						JOptionPane.showMessageDialog(null,"You have not entered in the building");
					}
					else
					{
						int pnt=0;
						do {
							System.out.println("Date Of Dispatch: "+resultSet1.getTime(4));
//							if(resultSet1.getTime(3)==null)
//							{
//								JOptionPane.showMessageDialog(null,"You have not entered in the building");
//							}
							if(resultSet1.getTime(4)==null) {
								pnt=1;
								String query = "update udetails set checkout='"+sqlTime+"' where uname='"+user_name+"' and checkout is null";
								statement.executeUpdate(query);

//							      connection.close();
							     
								JOptionPane.showOptionDialog(null, "You exited at "+dt, "Dialog", JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE, new ImageIcon(), buttons, buttons[0]);
//								   JOptionPane.showMessageDialog(null,"You exited at "+dt);
							}

							
						}
						while(resultSet1.next());
						if(pnt==0)
						{
							JOptionPane.showOptionDialog(null,"You are already outside the building", "Dialog", JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE, new ImageIcon(), buttons, buttons[0]);
//							JOptionPane.showMessageDialog(null,"You are already outside the building");
							
						}
						
					}
					resultSet1.close();


					
				}
				catch(Exception e2)
				{
					System.out.print(e2);
//					JOptionPane.showInternalMessageDialog(null, "not able to exit...");
				}
			}
		});
		btnExitBuilding.setFont(new Font("SimSun", Font.BOLD, 15));
		
		btnEnterBuilding = new javaprojjd.MyButton();
		btnEnterBuilding.setBounds(505, 342, 176, 33);
		btnEnterBuilding.setText("Enter Building");
		btnEnterBuilding.setBorder(emptyBorder);
		btnEnterBuilding.setFocusPainted(false);
		btnEnterBuilding.setColorOver(new Color(255, 225, 225));
		btnEnterBuilding.setColorClick(new Color(255, 134, 134));
		btnEnterBuilding.setBorderColor(new Color(255,255,255));
		btnEnterBuilding.setRadius(30);
		panel.add(btnEnterBuilding);
		btnEnterBuilding.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(user_name);
				System.out.println(pass_word);
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/udetail","root","Gauttam@2002");
					Statement statement = connection.createStatement();
					String sql = ("select count(*) from udetails where checkout is null");
					ResultSet resultset = statement.executeQuery(sql);
					resultset.next();
					cnt = resultset.getInt(1);
					if(OccupancyCheck()==1)
					{
						user_limit = Integer.parseInt(str);
						System.out.println(user_limit);
					}
					else
					{
						System.out.println("error occured");
					}
					
					System.out.println(cnt);
				}
				catch(Exception e1)
				{
					System.out.print(e1);
				}
				if(cnt>=user_limit)
				{
					JOptionPane.showOptionDialog(null, "User limit reached", "Dialog", JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE, new ImageIcon(), buttons, buttons[0]);
//					JOptionPane.showMessageDialog(null, "User limit reached");
				}
				else if(checkUser()==1)
				{
					JOptionPane.showOptionDialog(null, "You are already inside building", "Dialog", JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE, new ImageIcon(), buttons, buttons[0]);
//					JOptionPane.showMessageDialog(null, "already inside building");
				}
				else
				{
					try {
					      DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");  
						   LocalDateTime now = LocalDateTime.now();

						   java.util.Date date=new java.util.Date();
						   java.sql.Date sqlDate=new java.sql.Date(date.getTime());
						   java.sql.Timestamp sqlTime=new java.sql.Timestamp(date.getTime());
						   System.out.println(dtf.format(now));  
						   String dt = dtf.format(now).toString();
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/udetail","root","Gauttam@2002");
						String query = " insert into udetails (uname, pword,checkin)"
						        + " values (?,?,?)";
						PreparedStatement preparedStmt = connection.prepareStatement(query);
					      preparedStmt.setString (1,user_name);
					      preparedStmt.setString (2,pass_word);
					      preparedStmt.setTimestamp(3, sqlTime);

					      preparedStmt.execute();
					      connection.close();
					      JOptionPane.showOptionDialog(null, "new user entered at "+dt, "Dialog", JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE, new ImageIcon(), buttons, buttons[0]);
//						   JOptionPane.showMessageDialog(null,"new user entered at "+dt);
					}
					catch(Exception e2)
					{
						System.out.print(e2);
						JOptionPane.showOptionDialog(null, "You are already inside the building", "Dialog", JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE, new ImageIcon(), buttons, buttons[0]);
//						JOptionPane.showInternalMessageDialog(null, "You are already inside the building");
					}
				}
			}
		});
		btnEnterBuilding.setFont(new Font("SimSun", Font.BOLD, 15));
		
		btnProfile = new javaprojjd.MyButton();
		btnProfile.setBounds(505, 403, 176, 33);
		btnProfile.setText("View profile");
		btnProfile.setBorder(emptyBorder);
		btnProfile.setFocusPainted(false);
		btnProfile.setColorOver(new Color(255, 225, 225));
		btnProfile.setColorClick(new Color(255, 134, 134));
		btnProfile.setBorderColor(new Color(255,255,255));
		btnProfile.setRadius(30);
		panel.add(btnProfile);
		btnProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(user_name);
				System.out.println(pass_word);
				UserProfile usrprof = new UserProfile(user_name,pass_word);
//				usrprof.usr_name = user_name;
//				usrprof.usr_pass = pass_word;
//				System.out.println(usrprof.usr_name);
				usrprof.setVisible(true);
//				setVisible(false);
			}
		});
		btnProfile.setFont(new Font("SimSun", Font.BOLD, 15));
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon(getClass().getResource("/images/abstract (1).png")));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 24));
		lblNewLabel_5.setBounds(10, 11, 71, 77);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_1_2 = new JLabel("User");
		lblNewLabel_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_2.setFont(new Font("Vivaldi", Font.BOLD, 30));
		lblNewLabel_1_2.setBounds(259, 36, 71, 38);
		panel.add(lblNewLabel_1_2);
		
		
		
		
		
		
		
		
//		lblNewLabel_2.setText(totlim);
	}
}
