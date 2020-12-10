import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;



import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.awt.Font;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.*;

public class AdminAccountPage extends JFrame {

		private JPanel contentPane;
		private static JLabel ID;
		private static JTextField F_Name;
		private static JTextField L_Name;
		private static JTextField Email;
		private static JTextField Phone;
		private static JTextField Address;
		private static JLabel Photo;
		private static JLabel lbl_image;
		private static String filename;
		private static JLabel UserShow;
		java.sql.PreparedStatement pst = null;
	

		/**
		 * Launch the application.
		 */
		
	public AdminAccountPage ()
		{
		AccountPage1();
		getDetails();
		
		}
		
		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						AdminAccountPage account = new AdminAccountPage();
						getDetails();
						account.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}
		
		
		
		public static void getDetails()
	    {
	        try
	        {
	        	
	            String fname="";
	            String lname="";
	            String email="";
	            String phone="";
	            String address="";
	            String userName="";
	            String password ="";
	            String uniqueID="";
	            byte[] pto = null;
	           
	            Connection con = ConnectionProvider.getCon();
	            Statement st = con.createStatement();
	           
	           ResultSet rs;
	           
	           rs = st.executeQuery("select * from onlinesystem.admin where username = \"" + 
	           loginPage.textusername1.getText() + "\" and password=\"" + loginPage.textpassword1.getText() +"\"");
	         
	            while(rs.next())
	            {
	                userName+=rs.getString(7);
	                password+=rs.getString(8);
	                fname+=rs.getString(2);
	                lname+=rs.getString(3);
	                email+=rs.getString(6);
	                address+=rs.getString(4);
	                phone+=rs.getString(5);
	                uniqueID+=rs.getString(1);
	                pto=rs.getBytes(9);
	            }
	            F_Name.setText(fname);
	            L_Name.setText(lname);
	            Email.setText(email);
	            Phone.setText(phone);
	            Address.setText(address);
	            UserShow.setText(userName);
	            //Resize The ImageIcon
                ImageIcon image = new ImageIcon(pto);
                Image im = image.getImage();
                Image myImg = im.getScaledInstance(Photo.getWidth(), Photo.getHeight(),Image.SCALE_SMOOTH);
                ImageIcon newImage = new ImageIcon(myImg);
                Photo.setIcon(newImage);
	           ID.setText(uniqueID);
	        }

	        catch(Exception ex)
	        {
	            JOptionPane.showMessageDialog(null, ex);
	        }
	    }
		

		/**
		 * Create the frame.
		 */
		public void AccountPage1() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 280, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("X");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				setVisible(false);
			}
		});
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(1343, 0, 57, 23);
		contentPane.add(btnNewButton);
		
		JPanel panel_2 = new JPanel();
		panel_2.setForeground(Color.BLACK);
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(-14, 23, 1400, 718);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Admin ID: ");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(43, 103, 114, 25);
		panel_2.add(lblNewLabel);
		
		ID = new JLabel();
		ID.setForeground(Color.BLACK);
		ID.setFont(new Font("Tahoma", Font.PLAIN, 18));
		ID.setBounds(167, 102, 71, 31);
		panel_2.add(ID);
	//	ID.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("First Name:");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(267, 101, 94, 31);
		panel_2.add(lblNewLabel_1);
		
		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setForeground(Color.BLACK);
		lblLastName.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblLastName.setBounds(620, 101, 94, 31);
		panel_2.add(lblLastName);
		
		F_Name = new JTextField();
		F_Name.setColumns(10);
		F_Name.setBounds(371, 103, 162, 31);
		panel_2.add(F_Name);
		
		JLabel lblPhone = new JLabel("Phone: ");
		lblPhone.setForeground(Color.BLACK);
		lblPhone.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPhone.setBounds(620, 172, 63, 31);
		panel_2.add(lblPhone);
		
		JLabel lblEmail = new JLabel("Email Id:");
		lblEmail.setForeground(Color.BLACK);
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblEmail.setBounds(643, 249, 71, 31);
		panel_2.add(lblEmail);
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setForeground(Color.BLACK);
		lblAddress.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAddress.setBounds(272, 319, 89, 31);
		panel_2.add(lblAddress);
		
		JLabel lblNewLabel_2 = new JLabel("Personal Infomation: ");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2.setBounds(43, 11, 331, 27);
		panel_2.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Image");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setForeground(Color.BLACK);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3.setBounds(620, 319, 101, 31);
		panel_2.add(lblNewLabel_3);
		
		L_Name = new JTextField();
		L_Name.setColumns(10);
		L_Name.setBounds(724, 103, 162, 31);
		panel_2.add(L_Name);
		
		Email = new JTextField();
		Email.setColumns(10);
		Email.setBounds(724, 251, 162, 31);
		panel_2.add(Email);
		
		Phone = new JTextField();
		Phone.setColumns(10);
		Phone.setBounds(724, 174, 162, 31);
		panel_2.add(Phone);
		
		Address = new JTextField();
		Address.setColumns(10);
		Address.setBounds(371, 311, 162, 60);
		panel_2.add(Address);
		
		
		
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		lblNewLabel_4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\jamun\\eclipse-workspace\\HostelManagementSystem\\images\\cancel.png"));
		lblNewLabel_4.setBounds(952, 11, 40, 46);
		panel_2.add(lblNewLabel_4);
		
		JButton btnNewButton_1 = new JButton("Update");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e)
			{
				try
		        {    byte[] pto = null;
			            
			           String st = "update onlinesystem.admin set First_Name=?, Last_Name=?,Email=?, Phone=?, Address=?, image=? "
			           		+ " where username=\"" +  loginPage.textusername1.getText() + "\"and password=\"" + loginPage.textpassword1.getText() + "\"";
			    
			          Connection con = ConnectionProvider.getCon();
			          pst= con.prepareStatement(st);
			    
			          InputStream inputStream = new FileInputStream(new File(filename));
			             pst.setBlob(6, inputStream);
			          
					  pst.setString(1,F_Name.getText());
					  pst.setString(2,L_Name.getText());
					  pst.setString(3,Email.getText());
					  pst.setString(5,Address.getText());
					  pst.setString(4,Phone.getText());
				  
					  pst.executeUpdate();
					  JOptionPane.showMessageDialog(null, "Updated Successful");
				}
						  catch (Exception ex)
					        {
					           JOptionPane.showMessageDialog(null, ex);
					        }
			}			    
			      
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1.setBounds(43, 162, 101, 31);
		panel_2.add(btnNewButton_1);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setForeground(Color.BLACK);
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblUsername.setBounds(267, 172, 94, 31);
		panel_2.add(lblUsername);
//	111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111	
		lbl_image = new JLabel("");
		lbl_image.setBounds(724, 311, 261, 169);
		//panel_2.add(lbl_image);
		setUndecorated(true);
		
		JButton btnNewButton_2 = new JButton("Attach");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				JFileChooser chooser = new JFileChooser();
				chooser.showOpenDialog(null);
				File f = chooser.getSelectedFile();
				filename = f.getAbsolutePath();
				//txt_filename.setText(filename);
				//Image getAbsolutePath = null;
				
	             
				ImageIcon icon = new ImageIcon(filename);
				Image image = icon.getImage().getScaledInstance(lbl_image.getWidth(), lbl_image.getHeight(), Image.SCALE_SMOOTH);
				lbl_image.setIcon(icon);
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_2.setBounds(786, 491, 121, 29);
		panel_2.add(btnNewButton_2);
		
		Photo = new JLabel();
		Photo.setBounds(713, 330, 177, 107);
		panel_2.add(Photo);
		
		UserShow = new JLabel();
		UserShow.setBounds(371, 174, 169, 31);
		panel_2.add(UserShow);
		
		
	}
}
