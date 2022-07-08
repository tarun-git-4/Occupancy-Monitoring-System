package javaprojjd;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class dashboard extends JFrame {

	private JPanel contentPane;
	private javaprojjd.MyButton adminlginbtn;
	private javaprojjd.MyButton userlginbtn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					dashboard frame = new dashboard();
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
	public dashboard() {
		setBackground(new Color(0, 139, 139));
//		setUndecorated(true);
//		setEnabled(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 714, 477);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Occupancy Monitoring System");
		lblNewLabel.setFont(new Font("Tw Cen MT", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel.setBounds(161, 29, 406, 37);
		contentPane.add(lblNewLabel);
		
		userlginbtn = new javaprojjd.MyButton();
		userlginbtn.setText("User Sign in");
//		userlginbtn.setBounds(282, 292, 147, 31);
		Border emptyBorder = BorderFactory.createEmptyBorder();
		userlginbtn.setBorder(emptyBorder);
		userlginbtn.setFocusPainted(false);
		userlginbtn.setColorOver(new Color(198, 228, 212));
		userlginbtn.setColorClick(new Color(187, 232, 208));
		userlginbtn.setBorderColor(new Color(255,255,255));
		userlginbtn.setRadius(30);
		userlginbtn.setFont(new Font("Tahoma", Font.BOLD, 17));
		userlginbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userlogin ulogin = new userlogin();
				ulogin.setVisible(true);
				setVisible(false);
			}
		});
		userlginbtn.setBounds(398, 358, 153, 32);
		contentPane.add(userlginbtn);
		
		adminlginbtn = new javaprojjd.MyButton();
		adminlginbtn.setText("Admin Sign in");
//		userlginbtn.setBounds(282, 292, 147, 31);
//		Border emptyBorder = BorderFactory.createEmptyBorder();
		adminlginbtn.setBorder(emptyBorder);
		adminlginbtn.setFocusPainted(false);
		adminlginbtn.setColorOver(new Color(198, 228, 212));
		adminlginbtn.setColorClick(new Color(187, 232, 208));
		adminlginbtn.setBorderColor(new Color(255,255,255));
		adminlginbtn.setRadius(30);
		adminlginbtn.setFont(new Font("Tahoma", Font.BOLD, 17));
		adminlginbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminLogin alogin = new AdminLogin();
				alogin.setVisible(true);
				setVisible(false);
			}
		});
		adminlginbtn.setBounds(107, 358, 167, 32);
		contentPane.add(adminlginbtn);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(getClass().getResource("/images/sensing.png")));
		lblNewLabel_1.setBounds(48, 77, 622, 270);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_2.setIcon(new ImageIcon(getClass().getResource("/images/signup-bg.jpg")));
		lblNewLabel_2.setBounds(0, 0, 700, 440);
		contentPane.add(lblNewLabel_2);
	}
}
