import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Component;


import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.Cursor;
import java.awt.Dimension;

import javax.swing.SwingConstants;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import java.awt.SystemColor;
import java.awt.Toolkit;
import javax.swing.JCheckBox;
import javax.swing.JPasswordField;

public class UserSelectionPage extends JFrame {

	private JPanel contentPane;
	private final JPanel panel = new JPanel();
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_1;
	private JLabel lblCsu;
	private JLabel lblDh;
	private JLabel label_4;
	private JLabel label_5;
	private JLabel label_6;
	private JLabel label_7;
	private JLabel label_8;
	private JLabel label_9;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel label;
	private JLabel lblAdvisor;
	private JLabel lblStudent;
	private JLabel lblNewLabel_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserSelectionPage frame = new UserSelectionPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the frame.
	 */
	public UserSelectionPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 960, 631);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		panel.setBackground(new Color(102, 0, 0));
		panel.setBounds(0, 0, 1894, 1033);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblNewLabel_6 = new JLabel(" X");
		lblNewLabel_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				System.exit(0);
			}
		});
		
		lblAdvisor = new JLabel("ADVISOR");
		lblAdvisor.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdvisor.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblAdvisor.setForeground(Color.WHITE);
		lblAdvisor.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAdvisor.setBounds(882, 416, 92, 35);
		panel.add(lblAdvisor);
		lblNewLabel_6.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_6.setForeground(new Color(255, 255, 255));
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_6.setBounds(1845, -2, 39, 25);
		panel.add(lblNewLabel_6);
		
		
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(0, 0,screen.width,screen.height - 30);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		lblNewLabel_1 = new JLabel("Sign In As:");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_1.setBounds(714, 294, 260, 47);
		panel.add(lblNewLabel_1);
		
		lblCsu = new JLabel("CSU");
		lblCsu.setHorizontalAlignment(SwingConstants.LEFT);
		lblCsu.setForeground(new Color(255, 153, 51));
		lblCsu.setFont(new Font("Stencil", Font.BOLD, 45));
		lblCsu.setBounds(523, 23, 92, 113);
		panel.add(lblCsu);
		
		lblDh = new JLabel("DH");
		lblDh.setHorizontalAlignment(SwingConstants.LEFT);
		lblDh.setForeground(new Color(255, 255, 255));
		lblDh.setFont(new Font("Stencil", Font.BOLD, 45));
		lblDh.setBounds(608, 23, 83, 113);
		panel.add(lblDh);
		
		label_4 = new JLabel("ONL");
		label_4.setHorizontalAlignment(SwingConstants.LEFT);
		label_4.setForeground(new Color(255, 153, 0));
		label_4.setFont(new Font("Stencil", Font.BOLD, 45));
		label_4.setBounds(745, 23, 92, 113);
		panel.add(label_4);
		
		label_5 = new JLabel("INE");
		label_5.setHorizontalAlignment(SwingConstants.LEFT);
		label_5.setForeground(Color.WHITE);
		label_5.setFont(new Font("Stencil", Font.BOLD, 45));
		label_5.setBounds(836, 23, 85, 113);
		panel.add(label_5);
		
		label_6 = new JLabel("ADVI");
		label_6.setHorizontalAlignment(SwingConstants.LEFT);
		label_6.setForeground(new Color(255, 153, 0));
		label_6.setFont(new Font("Stencil", Font.BOLD, 45));
		label_6.setBounds(949, 23, 109, 113);
		panel.add(label_6);
		
		label_7 = new JLabel("SING");
		label_7.setHorizontalAlignment(SwingConstants.LEFT);
		label_7.setForeground(Color.WHITE);
		label_7.setFont(new Font("Stencil", Font.BOLD, 45));
		label_7.setBounds(1057, 23, 109, 113);
		panel.add(label_7);
		
		label_8 = new JLabel("CEN");
		label_8.setHorizontalAlignment(SwingConstants.LEFT);
		label_8.setForeground(new Color(255, 153, 0));
		label_8.setFont(new Font("Stencil", Font.BOLD, 45));
		label_8.setBounds(1205, 23, 85, 113);
		panel.add(label_8);
		
		label_9 = new JLabel("TER");
		label_9.setHorizontalAlignment(SwingConstants.LEFT);
		label_9.setForeground(Color.WHITE);
		label_9.setFont(new Font("Stencil", Font.BOLD, 45));
		label_9.setBounds(1293, 23, 102, 113);
		panel.add(label_9);
		
		lblNewLabel_3 = new JLabel("ADMIN");
		lblNewLabel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e)
			{
				AdminPage ad = new AdminPage();
				ad.setVisible(true);
			}
		});
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3.setBounds(714, 415, 92, 35);
		panel.add(lblNewLabel_3);
		
		label = new JLabel("");
		label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label.setIcon(new ImageIcon("C:\\Users\\jamun\\eclipse-workspace\\SeniorProject\\image\\adminshape.png"));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(855, 376, 151, 121);
		panel.add(label);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\jamun\\eclipse-workspace\\SeniorProject\\image\\adminshape.png"));
		lblNewLabel_2.setBounds(686, 376, 151, 121);
		panel.add(lblNewLabel_2);
		
		lblStudent = new JLabel("STUDENT");
		lblStudent.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e)
			{
				dispose();
				loginPage lp = new loginPage();
				lp.setVisible(true);
			}
		});
		lblStudent.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblStudent.setHorizontalAlignment(SwingConstants.CENTER);
		lblStudent.setForeground(Color.WHITE);
		lblStudent.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblStudent.setBounds(1048, 416, 92, 35);
		panel.add(lblStudent);
		
		lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\jamun\\eclipse-workspace\\SeniorProject\\image\\adminshape.png"));
		lblNewLabel_4.setBounds(1027, 376, 139, 121);
		panel.add(lblNewLabel_4);
		
		lblNewLabel = new JLabel("pic");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setForeground(new Color(102, 0, 0));
		lblNewLabel.setBackground(new Color(102, 0, 0));
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\jamun\\OneDrive\\Desktop\\loginpic.jpg"));
		lblNewLabel.setBounds(21, 23, 1851, 970);
		panel.add(lblNewLabel);
	}
				
		}
