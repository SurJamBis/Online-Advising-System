import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.awt.Rectangle;
import java.awt.Component;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Dimension;

public class userRegister extends JFrame {

	private JPanel contentPane;
	private JTextField textfname;
	private JTextField textlname;
	private JTextField textusername;
	private JTextField textpassword;
	private JTextField textemail;
	private JTextField textphone;
	private JTextField textRegister;
	private JTextField textcancel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try 
				{
					userRegister frame = new userRegister();
					frame.setVisible(true);
				} 
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}




	/**
	 * Create the frame.
	 */
	public userRegister() {
		setPreferredSize(new Dimension(700, 500));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(750, 150, 408, 518);
		contentPane = new JPanel();
		contentPane.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		contentPane.setAlignmentX(Component.RIGHT_ALIGNMENT);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setUndecorated(true);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 58, 395, 450);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("First Name: ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(55, 11, 65, 29);
		panel_1.add(lblNewLabel_1);
		
		textfname = new JTextField();
		textfname.setBounds(130, 12, 204, 29);
		panel_1.add(textfname);
		textfname.setColumns(10);
		
		JLabel lblLastName = new JLabel("Last Name: ");
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblLastName.setBounds(55, 51, 65, 29);
		panel_1.add(lblLastName);
		
		textlname = new JTextField();
		textlname.setColumns(10);
		textlname.setBounds(130, 52, 204, 29);
		panel_1.add(textlname);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblUsername.setBounds(55, 138, 65, 29);
		panel_1.add(lblUsername);
		
		textusername = new JTextField();
		textusername.setColumns(10);
		textusername.setBounds(130, 138, 204, 29);
		panel_1.add(textusername);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPassword.setBounds(55, 179, 65, 29);
		panel_1.add(lblPassword);
		
		textpassword = new JTextField();
		textpassword.setColumns(10);
		textpassword.setBounds(130, 179, 204, 29);
		panel_1.add(textpassword);
		
		JLabel lblEmailId = new JLabel("Email ID:");
		lblEmailId.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEmailId.setBounds(55, 220, 65, 29);
		panel_1.add(lblEmailId);
		
		textemail = new JTextField();
		textemail.setColumns(10);
		textemail.setBounds(130, 220, 204, 29);
		panel_1.add(textemail);
		
		JLabel lblPhone = new JLabel(" Phone:");
		lblPhone.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPhone.setBounds(55, 261, 65, 29);
		panel_1.add(lblPhone);
		JComboBox comboBox =  new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Select", "Admin", "Advisor", "Student"}));
		comboBox.setBounds(130, 92, 204, 29);
		panel_1.add(comboBox);
		
		textphone = new JTextField();
		textphone.setColumns(10);
		textphone.setBounds(130, 261, 204, 29);
		panel_1.add(textphone);
		
		textRegister = new JTextField();
		textRegister.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				String firstname = textfname.getText();
				String lastname = textlname.getText();
				String usertype = (String) comboBox.getSelectedItem();
				String username = textusername.getText();
				String password = textpassword.getText();
				String email = textemail.getText();
				String phone = textphone.getText();
				 int len = phone.length();
				
				String msg = "" + firstname;
	         
	            
	            if(comboBox.getSelectedItem().equals("Student"))
				{
					
					try
					{
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/onlinesystem","root", "toor");
					//Statement stmt = con.createStatement();
					PreparedStatement Pstatement=con.prepareStatement("insert into onlinesystem.student (First_Name,Last_Name,Phone,Email,Username,password) values(?,?,?,?,?,?) " );
					Pstatement.setString(1, firstname);
					Pstatement.setString(2, lastname);
					Pstatement.setString(5, username);
					Pstatement.setString(6, password );
					Pstatement.setString(4, email);
					Pstatement.setString(3, phone);
					Pstatement.executeUpdate();
                    JOptionPane.showMessageDialog(null,"Data Registered Successfully");
                    
                    
                    textfname.setText("");
                    textlname.setText("");
                    textusername.setText("");
                    textpassword.setText("");
                    textemail.setText("");
                    textphone.setText("");
                   // ((JLabel) comboBox.getSelectedItem()).setText("");
                    
                
					}
			catch (Exception e1)
			{
				JOptionPane.showMessageDialog(null, e1);
            }
				}
	            if(comboBox.getSelectedItem().equals("Advisor"))
				{
					try
					{
				
						
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/onlinesystem","root", "toor");
					//Statement stmt = con.createStatement();
					PreparedStatement Pstatement=con.prepareStatement("insert into onlinesystem.advisor (First_Name,Last_Name,Phone_No,Email,Username,password) values(?,?,?,?,?,?) ");
					Pstatement.setString(1, firstname);
					Pstatement.setString(2, lastname);
					Pstatement.setString(5, username);
					Pstatement.setString(6, password );
					Pstatement.setString(4, email);
					Pstatement.setString(3, phone);
					
					//Statement sta = con.createStatement();
					Pstatement.executeUpdate(); 
                    JOptionPane.showMessageDialog(null,"Data Registered Successfully");
	                //int x = sta.executeUpdate(sql);
	                //if (x == 0) {
	                   // JOptionPane.showMessageDialog(textRegister, "This is alredy exist");
	                //} 
	               // else 
	                //{
	                    //JOptionPane.showMessageDialog(textRegister,
	                   //     "Welcome, " + msg + "Your account is sucessfully created");
	               // }
				
                    textfname.setText("");
                    textlname.setText("");
                    textusername.setText("");
                    textpassword.setText("");
                    textemail.setText("");
                    textphone.setText("");
				}
	            
				catch (Exception e1)
				{
					JOptionPane.showMessageDialog(null, e1);
	            }
				}
					
					if(comboBox.getSelectedItem().equals("Student"))
					{
						
						try
						{
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/onlinesystem","root", "toor");
						//Statement stmt = con.createStatement();
						PreparedStatement Pstatement=con.prepareStatement("insert into onlinesystem.student (First_Name,Last_Name,Phone,Email,Username,password) values(?,?,?,?,?,?) " );
						Pstatement.setString(1, firstname);
						Pstatement.setString(2, lastname);
						Pstatement.setString(5, username);
						Pstatement.setString(6, password );
						Pstatement.setString(4, email);
						Pstatement.setString(3, phone);
						Pstatement.executeUpdate();
	                    JOptionPane.showMessageDialog(null,"Data Registered Successfully");
	                    
	                    textfname.setText("");
	                    textlname.setText("");
	                    textusername.setText("");
	                    textpassword.setText("");
	                    textemail.setText("");
	                    textphone.setText("");
						}
				catch (Exception e1)
				{
					JOptionPane.showMessageDialog(null, e1);
	            }
				
					}
			}
		});
		
	
	
		
		textRegister.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		textRegister.setHorizontalAlignment(SwingConstants.CENTER);
		textRegister.setFont(new Font("Tahoma", Font.BOLD, 15));
		textRegister.setText("Register");
		textRegister.setColumns(10);
		textRegister.setBounds(10, 341, 137, 29);
		panel_1.add(textRegister);
		
		textcancel = new JTextField();
		textcancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				setVisible(false);
			}
		});
		textcancel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		textcancel.setText("Cancel");
		textcancel.setHorizontalAlignment(SwingConstants.CENTER);
		textcancel.setFont(new Font("Tahoma", Font.BOLD, 15));
		textcancel.setColumns(10);
		textcancel.setBounds(202, 341, 137, 29);
		panel_1.add(textcancel);
		
		JLabel textlog = new JLabel("Have An Account!! Click Here");
		textlog.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				loginPage log = new loginPage();
				//log.setLocationRelativeTo(null);
				log.setVisible(true);
			}
		});
		textlog.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		textlog.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textlog.setHorizontalAlignment(SwingConstants.CENTER);
		textlog.setBounds(69, 406, 204, 23);
		panel_1.add(textlog);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(102, 0, 0));
		panel_2.setBounds(0, 385, 382, 10);
		panel_1.add(panel_2);
		
		JLabel lblUserType = new JLabel("User Type:");
		lblUserType.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblUserType.setBounds(55, 91, 65, 29);
		panel_1.add(lblUserType);
		
		
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(102, 0, 0));
		panel.setBounds(0, 51, 382, 10);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("SIGN UP");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(96, 11, 184, 29);
		contentPane.add(lblNewLabel);
	}
}


