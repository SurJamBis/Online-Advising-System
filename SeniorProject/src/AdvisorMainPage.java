import java.awt.BorderLayout;
import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;
import javax.swing.*;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Cursor;
import java.awt.Dimension;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Rectangle;
import java.awt.Toolkit;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import javax.swing.ImageIcon;


public class AdvisorMainPage extends JFrame {

	private JPanel contentPane;
	private Color clockColor;

	/**
	 * Launch the application.
	 */

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdvisorMainPage frame = new AdvisorMainPage();
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
	private FrameHome FrameHome;
	
	public AdvisorMainPage() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1936, 941);
		contentPane = new JPanel();
		contentPane.setBounds(new Rectangle(0, 0, 1200, 800));
		
		contentPane.setBackground(new Color(102, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setUndecorated(true);
		
		
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(0, 0,screen.width,screen.height - 30);
		//setExtendedState(FrameHome.MAXIMIZED_BOTH);
		//setExtendedState(AccountPage.MAXIMIZED_BOTH);
		//setExtendedState(FacultyPage.MAXIMIZED_BOTH);
		//setExtendedState(InboxPage.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBounds(new Rectangle(0, 0, 200, 800));
		panel.setBounds(0, 0, 259, 768);
		panel.setBackground(new Color(102, 0, 0));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnAccount = new JButton("ACCOUNT");
		btnAccount.setFont(new Font("Stencil", Font.BOLD, 18));
		btnAccount.setForeground(new Color(255, 255, 255));
		btnAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Advisoraccount  fr = new Advisoraccount();
				fr.setVisible(true);
				
			}

			
		});
		btnAccount.setBackground(new Color(102, 0, 0));
		btnAccount.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAccount.setBounds(0, 360, 259, 42);
		panel.add(btnAccount);
		
		JButton btnFaculty = new JButton("Document ");
		btnFaculty.setFont(new Font("Stencil", Font.BOLD, 18));
		btnFaculty.setForeground(new Color(255, 255, 255));
		btnFaculty.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				
				StudentClearance sc = new StudentClearance();
				sc.setVisible(true);
			}
		});
		btnFaculty.setBackground(new Color(102, 0, 0));
		btnFaculty.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnFaculty.setBounds(0, 486, 259, 42);
		panel.add(btnFaculty);
		
		JButton btnsignout = new JButton("SIGN OUT");
		btnsignout.setFont(new Font("Stencil", Font.BOLD, 18));
		btnsignout.setForeground(new Color(255, 255, 255));
		btnsignout.setBackground(new Color(102, 0, 0));
		btnsignout.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnsignout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				if(JOptionPane.showConfirmDialog( null, "Are you sure you want to close the application?", "Confirmation", JOptionPane.YES_NO_OPTION)==0)

			{
					//AdvisorMainPage.this.dispose();
					loginPage page = new loginPage();
					page.setVisible(true);
					}
			}
		});
		btnsignout.setBounds(0, 572, 259, 42);
		panel.add(btnsignout);
		
		JButton btnCalender = new JButton("CALENDER");
		btnCalender.setFont(new Font("Stencil", Font.BOLD, 18));
		btnCalender.setForeground(new Color(255, 255, 255));
		btnCalender.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				AdminCalendar  ma = new AdminCalendar();
				ma.setVisible(true);
			}
		});
		btnCalender.setBackground(new Color(102, 0, 0));
		btnCalender.setBounds(0, 529, 259, 42);
		panel.add(btnCalender);
		
		JButton btnListOfAppointment = new JButton("LIST OF APPOINTMENT");
		btnListOfAppointment.setFont(new Font("Stencil", Font.BOLD, 18));
		btnListOfAppointment.setForeground(new Color(255, 255, 255));
		btnListOfAppointment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
			
				AdvisorAppointmentList LP = new AdvisorAppointmentList();
				LP.setLocationRelativeTo(null);
				LP.setVisible(true);
			}
		});
		btnListOfAppointment.setBackground(new Color(102, 0, 0));
		btnListOfAppointment.setBounds(0, 402, 259, 42);
		panel.add(btnListOfAppointment);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\jamun\\eclipse-workspace\\SeniorProject\\image\\250px-DominguezToros.png"));
		lblNewLabel_1.setBounds(10, 113, 249, 177);
		panel.add(lblNewLabel_1);
		
		
		JButton btnhome = new JButton("HOME");
		btnhome.setFont(new Font("Stencil", Font.BOLD, 18));
		btnhome.setForeground(new Color(255, 255, 255));
		btnhome.setBackground(new Color(102, 0, 0));
		btnhome.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnhome.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				
				FrameHome  frame = new FrameHome();
				frame.setVisible(true);
				
			}
		});
		btnhome.setBounds(0, 318, 259, 42);
		panel.add(btnhome);
		
		JButton btnStudentInfo = new JButton("Student Info");
		btnStudentInfo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				StudentSearchPage ssp = new StudentSearchPage();
				ssp.setVisible(true);
			}
		});
		btnStudentInfo.setFont(new Font("Stencil", Font.BOLD, 18));
		btnStudentInfo.setForeground(Color.WHITE);
		btnStudentInfo.setBackground(new Color(102, 0, 0));
		btnStudentInfo.setBounds(0, 444, 259, 42);
		panel.add(btnStudentInfo);
		
		JPanel panelmain = new JPanel();
		panelmain.setBackground(new Color(255, 255, 255));
		panelmain.setBounds(260, 22, 1522, 937);
		contentPane.add(panelmain);
		panelmain.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(102, 0, 0));
		panel_2.setBounds(0, 0, 1634, 117);
		panelmain.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("WEL");
		lblNewLabel_2.setForeground(new Color(255, 153, 51));
		lblNewLabel_2.setFont(new Font("Stencil", Font.BOLD, 40));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2.setBounds(328, 0, 80, 113);
		panel_2.add(lblNewLabel_2);
		
		JLabel lblCome = new JLabel("COME");
		lblCome.setHorizontalAlignment(SwingConstants.LEFT);
		lblCome.setForeground(new Color(255, 255, 255));
		lblCome.setFont(new Font("Stencil", Font.BOLD, 40));
		lblCome.setBounds(412, 0, 121, 113);
		panel_2.add(lblCome);
		
		JLabel lblTo = new JLabel("T");
		lblTo.setHorizontalAlignment(SwingConstants.LEFT);
		lblTo.setForeground(new Color(255, 153, 0));
		lblTo.setFont(new Font("Stencil", Font.BOLD, 40));
		lblTo.setBounds(564, 0, 30, 113);
		panel_2.add(lblTo);
		
		JLabel lblOnl = new JLabel("ONL");
		lblOnl.setHorizontalAlignment(SwingConstants.LEFT);
		lblOnl.setForeground(new Color(255, 153, 0));
		lblOnl.setFont(new Font("Stencil", Font.BOLD, 40));
		lblOnl.setBounds(654, 0, 85, 113);
		panel_2.add(lblOnl);
		
		JLabel lblIne = new JLabel("INE");
		lblIne.setHorizontalAlignment(SwingConstants.LEFT);
		lblIne.setForeground(new Color(255, 255, 255));
		lblIne.setFont(new Font("Stencil", Font.BOLD, 40));
		lblIne.setBounds(734, 0, 85, 113);
		panel_2.add(lblIne);
		
		JLabel lblAdvi = new JLabel("ADVI");
		lblAdvi.setHorizontalAlignment(SwingConstants.LEFT);
		lblAdvi.setForeground(new Color(255, 153, 0));
		lblAdvi.setFont(new Font("Stencil", Font.BOLD, 40));
		lblAdvi.setBounds(853, 0, 109, 113);
		panel_2.add(lblAdvi);
		
		JLabel lblSing = new JLabel("SING");
		lblSing.setHorizontalAlignment(SwingConstants.LEFT);
		lblSing.setForeground(new Color(255, 255, 255));
		lblSing.setFont(new Font("Stencil", Font.BOLD, 40));
		lblSing.setBounds(956, 0, 109, 113);
		panel_2.add(lblSing);
		
		JLabel lblCen = new JLabel("CEN");
		lblCen.setHorizontalAlignment(SwingConstants.LEFT);
		lblCen.setForeground(new Color(255, 153, 0));
		lblCen.setFont(new Font("Stencil", Font.BOLD, 40));
		lblCen.setBounds(1105, 0, 85, 113);
		panel_2.add(lblCen);
		
		JLabel lblTer = new JLabel("TER");
		lblTer.setHorizontalAlignment(SwingConstants.LEFT);
		lblTer.setForeground(new Color(255, 255, 255));
		lblTer.setFont(new Font("Stencil", Font.BOLD, 40));
		lblTer.setBounds(1188, 0, 85, 113);
		panel_2.add(lblTer);
		
		JLabel lblO = new JLabel("O");
		lblO.setHorizontalAlignment(SwingConstants.LEFT);
		lblO.setForeground(new Color(255, 255, 255));
		lblO.setFont(new Font("Stencil", Font.BOLD, 40));
		lblO.setBounds(592, 0, 30, 113);
		panel_2.add(lblO);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 255, 255));
		panel_3.setBounds(149, 301, 1097, 494);
		panelmain.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\jamun\\eclipse-workspace\\SeniorProject\\image\\home1.jpg"));
		lblNewLabel_3.setBounds(71, 32, 246, 178);
		panel_3.add(lblNewLabel_3);
		
		JLabel label = new JLabel("");
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
			
				//FacultyPage fpage = new FacultyPage();
				//fpage.setVisible(true);
			}
		});
		label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label.setIcon(new ImageIcon("C:\\Users\\jamun\\eclipse-workspace\\SeniorProject\\image\\Advisors.png"));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(419, 32, 246, 178);
		panel_3.add(label);
		
		JLabel label_1 = new JLabel();
		label_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				AdminCalendar ma = new AdminCalendar();
				ma.setVisible(true);
				
			}
		});
		label_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_1.setIcon(new ImageIcon("C:\\Users\\jamun\\eclipse-workspace\\SeniorProject\\image\\iconfinder-128 (1).png"));
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(772, 32, 246, 178);
		panel_3.add(label_1);
		
		JLabel label_2 = new JLabel("");
		label_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				
				//InboxPage Inpage = new InboxPage();
				//Inpage.setVisible(true);
			}
		});
		label_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_2.setIcon(new ImageIcon("C:\\Users\\jamun\\eclipse-workspace\\SeniorProject\\image\\email.png"));
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setBounds(71, 283, 246, 178);
		panel_3.add(label_2);
		
		JLabel label_3 = new JLabel("");
		label_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				StudentSearchPage ssp = new StudentSearchPage();
				ssp.setVisible(true);
				
			}
		});
		label_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_3.setIcon(new ImageIcon("C:\\Users\\jamun\\eclipse-workspace\\SeniorProject\\image\\studentInfo.png"));
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setBounds(419, 283, 246, 178);
		panel_3.add(label_3);
		
		JLabel label_4 = new JLabel("");
		label_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				
				Advisoraccount ac = new Advisoraccount();
				ac.setVisible(true);
				
			}
		});
		label_4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_4.setIcon(new ImageIcon("C:\\Users\\jamun\\eclipse-workspace\\SeniorProject\\image\\Settings.png"));
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setBounds(772, 283, 246, 178);
		panel_3.add(label_4);
		
		JLabel lblNewLabel = new JLabel("X");
		lblNewLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e)
			{
				System.exit(0);
			}
		});
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(1874, 0, 20, 26);
		contentPane.add(lblNewLabel);
	
	}
	}
		
	

