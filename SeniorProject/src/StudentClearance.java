import java.awt.BorderLayout; 
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Cursor;


public class StudentClearance extends JFrame {

	private JPanel contentPane;
	//private static JLabel ID;
	 
	//private static JLabel lbl_image;
	//private static String filename;
	private static JLabel UserShow;
	java.sql.PreparedStatement pst = null;
	private static JTextField ID;
	private JLabel IDlable;
	private JLabel Addresslabel;
	private JLabel Phonelabel;
	private JLabel Emaillabel;
	private static JLabel F_Name;
	private static JLabel L_Name;
	private static JLabel Address;
	private static JLabel Phone;
	private static JLabel Email;
	private JScrollPane scrollPane;
	private JLabel lblNewLabel;
	private static JTable table;
	private JLabel lblNewLabel_1;
	private JLabel label;
	private JLabel Delete_Button;
	private JPanel panel_4;
	private JPanel panel_4_1;
	private JTextField des;
	private JPanel panel_4_2;
	private JPanel panel_4_3;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel lblNewLabel_2;

	/**
	 * Launch the application.
	 */
	
	
	public StudentClearance ()
	{
		StudentClearance1();
	//getDetails();
	
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentClearance frame = new StudentClearance();
				//	getDetails();
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
	public static void getDetails()
    {
		 try
	        {
	        	
	            String fname="";
	            String lname="";
	            String email="";
	            String phone="";
	            String address="";
	       
	            String uniqueID="";
	      
	           
	            Connection con = ConnectionProvider.getCon();
	            Statement st = con.createStatement();
	           
	           ResultSet rs;
	           rs = st.executeQuery("select * from onlinesystem.student where student.id = \"" + ID.getText() +"\"");
	          // rs = st.executeQuery("select * from onlinesystem.student where username = \"" + 
	        //   loginPage.textusername1.getText() + "\" and password=\"" + loginPage.textpassword1.getText() +"\"");
	         
	            while(rs.next())
	            {
	              
	                fname+=rs.getString(2);
	                lname+=rs.getString(3);
	                email+=rs.getString(6);
	                address+=rs.getString(4);
	                phone+=rs.getString(5);
	                uniqueID+=rs.getString(1);
	            
	            }
	            F_Name.setText(fname);
	            L_Name.setText(lname);
	            Email.setText(email);
	            Phone.setText(phone);
	            Address.setText(address);
	       
	            
	           ID.setText(uniqueID);
	        }

	        catch(Exception ex)
	        {
	            JOptionPane.showMessageDialog(null, ex);
	        }

		 
		 try
			{
				 Connection con = ConnectionProvider.getCon();
		            Statement st = con.createStatement();
		           
		           ResultSet rs;
		           
		           rs = st.executeQuery("SELECT id,student_ID,F_Name,L_Name,Email,Phone,Document, Status FROM onlinesystem.studentclearance where"
		           		
		          +  " student_ID = \"" + ID.getText() + "\"");
		      
		           
		           table.setModel(DbUtils.resultSetToTableModel(rs));
		           
		       
			}
			
			catch (Exception ex)
			{
				  JOptionPane.showMessageDialog(null, ex);
			}
		
		
		
		
    }
	public void StudentClearance1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 200, 1000, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setUndecorated(true);
		//getDetails();
		JButton btnNewButton = new JButton("Search");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(102, 0, 0));
		
		
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				getDetails();
				
			}
		});
	
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(210, 88, 103, 33);
		contentPane.add(btnNewButton);
		
		ID = new JTextField();
		ID.setBounds(82, 90, 86, 33);
		contentPane.add(ID);
		ID.setColumns(10);
		
		JLabel F_Namelabel = new JLabel("First Name");
		F_Namelabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		F_Namelabel.setBounds(20, 134, 79, 33);
		contentPane.add(F_Namelabel);
		
		JLabel L_NameLabel = new JLabel("Last Name");
		L_NameLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		L_NameLabel.setBounds(20, 184, 79, 33);
		contentPane.add(L_NameLabel);
		
		IDlable = new JLabel("ID");
		IDlable.setFont(new Font("Tahoma", Font.BOLD, 14));
		IDlable.setBounds(20, 92, 52, 33);
		contentPane.add(IDlable);
		
		Addresslabel = new JLabel("Address");
		Addresslabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		Addresslabel.setBounds(20, 238, 79, 33);
		contentPane.add(Addresslabel);
		
		Phonelabel = new JLabel("Phone");
		Phonelabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		Phonelabel.setBounds(20, 281, 79, 33);
		contentPane.add(Phonelabel);
		
		Emaillabel = new JLabel("Email");
		Emaillabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		Emaillabel.setBounds(20, 328, 79, 33);
		contentPane.add(Emaillabel);
		
		F_Name = new JLabel();
		F_Name.setFont(new Font("Tahoma", Font.PLAIN, 14));
		F_Name.setBounds(135, 143, 191, 24);
		contentPane.add(F_Name);
		
		L_Name = new JLabel();
		L_Name.setFont(new Font("Tahoma", Font.PLAIN, 14));
		L_Name.setBounds(135, 193, 191, 24);
		contentPane.add(L_Name);
		
		Address = new JLabel();
		Address.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Address.setBounds(135, 247, 191, 24);
		contentPane.add(Address);
		
		Phone = new JLabel();
		Phone.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Phone.setBounds(135, 290, 191, 24);
		contentPane.add(Phone);
		
		Email = new JLabel();
		Email.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Email.setBounds(135, 326, 191, 24);
		contentPane.add(Email);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(346, 88, 628, 378);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		
		
		
		
		
		lblNewLabel = new JLabel("Student Details");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(20, 11, 415, 19);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("<html>Action Remarks\r\n                 <br/>T = Completed <br/>P = Progress</html>");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(764, 612, 166, 77);
		contentPane.add(lblNewLabel_1);
		
		panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBackground(new Color(102, 0, 0));
		panel_4.setBounds(20, 635, 205, 37);
		contentPane.add(panel_4);
		
		Delete_Button = new JLabel("Decline");
		Delete_Button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try
				{
				String app="Denied";
       		 
     			 Connection con = ConnectionProvider.getCon();
     	            Statement st = con.createStatement();

      	  
     	         
		  
		  
		  
//		  
//           String sttta =(" DELETE FROM onlinesystem.meeting_has_advisor WHERE student_ID = ((SELECT ID FROM onlinesystem.student "
//		      	           		+ "where onlinesystem.student.Username in ( \"" + loginPage.textusername1.getText()  + "\")))");
	           
		 String sttta =(" UPDATE onlinesystem.studentclearance SET Status = (\""+app+ "\") WHERE id = ?");
          
		 pst= con.prepareStatement(sttta);
          	pst.setString(1,des.getText());
			 pst.executeUpdate();
				
				}
			        	 
		     	 catch (Exception ex)
		        {
		           JOptionPane.showMessageDialog(null, "You can not delete at this time");
		       
		        }
			}
				
		});
		Delete_Button.setBounds(0, 0, 205, 37);
		panel_4.add(Delete_Button);
		Delete_Button.setHorizontalAlignment(SwingConstants.CENTER);
		Delete_Button.setForeground(Color.WHITE);
		Delete_Button.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		panel_4_1 = new JPanel();
		panel_4_1.setLayout(null);
		panel_4_1.setBackground(new Color(102, 0, 0));
		panel_4_1.setBounds(20, 587, 205, 37);
		contentPane.add(panel_4_1);
		
		label = new JLabel("Approve");
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try
	      		{
					String app="Approved";
	        		 
	      			 Connection con = ConnectionProvider.getCon();
	      	            Statement st = con.createStatement();

           	  
	      	         
			  
			  
			  
//			  
//	            String sttta =(" DELETE FROM onlinesystem.meeting_has_advisor WHERE student_ID = ((SELECT ID FROM onlinesystem.student "
//			      	           		+ "where onlinesystem.student.Username in ( \"" + loginPage.textusername1.getText()  + "\")))");
   	           
			 String sttta =(" UPDATE onlinesystem.studentclearance SET Status = (\""+app+ "\") WHERE id = ?");
	           
			 pst= con.prepareStatement(sttta);
	           	pst.setString(1,des.getText());
				 pst.executeUpdate();
			 
				  
			 
			
		}
	        	 
     	 catch (Exception ex)
        {
           JOptionPane.showMessageDialog(null, "You can not delete at this time");
       
        }
	
			
			
			
		}
		});
		label.setBounds(0, 0, 205, 37);
		panel_4_1.add(label);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Tahoma", Font.BOLD, 15));
		
	
		
		panel_4_2 = new JPanel();
		panel_4_2.setLayout(null);
		panel_4_2.setBackground(new Color(102, 0, 0));
		panel_4_2.setBounds(20, 534, 205, 37);
		contentPane.add(panel_4_2);
		
		label_1 = new JLabel("Open");
		label_1.setBounds(0, 0, 205, 37);
		panel_4_2.add(label_1);
		label_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				 try
			        {
			        	
					 String descrip = des.getText();
			            String descripton="";
			            String email="";
			            String phone="";
			          //  String doc="";
			            String userName="";
			            String password ="";
			            String uniqueID="";
			            byte[] pto = null;
			           
			            Connection con = ConnectionProvider.getCon();
			            Statement st = con.createStatement();
			           
			           ResultSet rs;
			           
			           rs = st.executeQuery("SELECT studentclearance.Attach FROM onlinesystem.studentclearance where id =\""+des.getText()+ "\"" );
			         //  loginPage.textusername1.getText() + "\" and password=\"" + loginPage.textpassword1.getText() +"\"");
			           
			       // 			+ " where student.Username in (\"jam\")";
			            
			           while(rs.next())
			           {
			                
			        	   descripton =rs.getString(1);
			                
			           }
//			          // F_Name.setText(fname);
//			           File file = new File(fname);
//			           if(file.toString().endsWith(".pdf"))
			               Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + descripton +"");
//			           else{
//			               Desktop dt = Desktop.getDesktop();
//			               dt.open(file);
//			           }
			        }
			        	    

			        catch(Exception ex)
			        {
			            JOptionPane.showMessageDialog(null, ex);
			        }

			}
		});
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		panel_4_3 = new JPanel();
		panel_4_3.setLayout(null);
		panel_4_3.setBackground(new Color(102, 0, 0));
		panel_4_3.setBounds(20, 486, 205, 37);
		contentPane.add(panel_4_3);
		
		label_2 = new JLabel("Enter ID");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_2.setBounds(0, 0, 205, 37);
		panel_4_3.add(label_2);
		
		
		des = new JTextField();
		des.setColumns(10);
		des.setBounds(270, 486, 175, 39);
		contentPane.add(des);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e)
			{
				dispose();
			}
		});
		lblNewLabel_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\jamun\\eclipse-workspace\\HostelManagementSystem\\images\\cancel.png"));
		lblNewLabel_2.setBounds(928, 11, 62, 44);
		contentPane.add(lblNewLabel_2);
	}
}
