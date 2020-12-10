import java.awt.BorderLayout;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Window.Type;
import java.awt.ComponentOrientation;
import java.awt.Color;
import java.awt.Cursor;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class FrameHome extends JFrame {

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameHome frame = new FrameHome();
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
	public static String path;
	
	
	public FrameHome() {
		getContentPane().setBackground(Color.WHITE);
		JPanel contentPane;
		setLocation(new Point(600, 600));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 280, 1000, 600);
		setUndecorated(true);
		
		JLabel lblAdvisors = new JLabel("");
		lblAdvisors.setBounds(381, 92, 222, 149);
		lblAdvisors.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e)
			{
				dispose();
				StudentAdvisors fac = new StudentAdvisors();
				fac.setVisible(true);
			}
		});
		lblAdvisors.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblAdvisors.setBackground(Color.LIGHT_GRAY);
		lblAdvisors.setIcon(new ImageIcon("C:\\Users\\jamun\\eclipse-workspace\\SeniorProject\\image\\Advisors.png"));
		lblAdvisors.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblCalender = new JLabel("");
		lblCalender.setBounds(668, 92, 222, 149);
		lblCalender.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				dispose();
				//Calender cal = new Calender();
				//cal.setVisible(true);
			}
		});
		lblCalender.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblCalender.setBackground(Color.LIGHT_GRAY);
		lblCalender.setIcon(new ImageIcon("C:\\Users\\jamun\\eclipse-workspace\\SeniorProject\\image\\iconfinder-128 (1).png"));
		lblCalender.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblInbox = new JLabel("");
		lblInbox.setBounds(73, 632, 222, 149);
		lblInbox.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblInbox.setBackground(Color.LIGHT_GRAY);
		lblInbox.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				dispose();
				InboxPage inpage = new InboxPage();
				inpage.setVisible(true);
			}
		});
		lblInbox.setIcon(new ImageIcon("C:\\Users\\jamun\\eclipse-workspace\\SeniorProject\\image\\email.png"));
		lblInbox.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblClasses = new JLabel("");
		lblClasses.setBounds(371, 632, 222, 149);
		lblClasses.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e)
			{
				dispose();
				Classses clas = new Classses();
				clas.setVisible(true);
			}
		});
		lblClasses.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblClasses.setBackground(Color.LIGHT_GRAY);
		lblClasses.setIcon(new ImageIcon("C:\\Users\\jamun\\eclipse-workspace\\SeniorProject\\image\\classes123.png"));
		lblClasses.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblUpdate = new JLabel("");
		lblUpdate.setBounds(668, 641, 222, 149);
		lblUpdate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				
				AccountPage acpage = new AccountPage();
				acpage.setVisible(true);
			}
		});
		lblUpdate.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblUpdate.setBackground(Color.LIGHT_GRAY);
		lblUpdate.setIcon(new ImageIcon("C:\\Users\\jamun\\eclipse-workspace\\SeniorProject\\image\\Settings.png"));
		lblUpdate.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().setLayout(null);
		getContentPane().add(lblInbox);
		getContentPane().add(lblAdvisors);
		getContentPane().add(lblClasses);
		getContentPane().add(lblUpdate);
		getContentPane().add(lblCalender);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(88, 92, 222, 149);
		getContentPane().add(lblNewLabel_1);
		lblNewLabel_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_1.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				dispose();
				FrameHome home = new FrameHome();
				home.setVisible(true);
			}
		});
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\jamun\\eclipse-workspace\\SeniorProject\\image\\home1.jpg"));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\jamun\\eclipse-workspace\\SeniorProject\\image\\email.png"));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBackground(Color.LIGHT_GRAY);
		label.setBounds(88, 380, 222, 149);
		getContentPane().add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("C:\\Users\\jamun\\eclipse-workspace\\SeniorProject\\image\\classes123.png"));
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBackground(Color.LIGHT_GRAY);
		label_1.setBounds(392, 380, 222, 149);
		getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon("C:\\Users\\jamun\\eclipse-workspace\\SeniorProject\\image\\Settings.png"));
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setBackground(Color.LIGHT_GRAY);
		label_2.setBounds(668, 369, 222, 149);
		getContentPane().add(label_2);
		
	}
	/*
	public void img()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		//contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel profile = new JLabel(); // initialization of JLabel
		profile.setBounds(10, 11, 414, 86);
		path = "C:\\Users\\jamun\\eclipse-workspace\\SeniorProject\\src\\home.png";
		ImageIcon myimage = new ImageIcon(path);
		contentPane.add(profile);
		Image img1 = myimage.getImage();
		Image img2 = img1.getScaledInstance(profile.getWidth(), profile.getHeight(), Image.SCALE_SMOOTH); // it will smooth the quality of the image
		ImageIcon i = new ImageIcon(img2);
		profile.setIcon(i);
	}
	*/
	
}
