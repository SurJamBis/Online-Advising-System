import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.UIManager;
import javax.swing.JScrollPane;

public class AdvisorAppointmentList extends JFrame {
	private JPanel contentPane1;
	private JTextField customer_ID;
	private static JTable table_1;
	  static java.sql.PreparedStatement pst = null;
	  private JTextField Id_textField;


	/**
	 * Launch the application.
	 */
	
	
	public AdvisorAppointmentList ()
	{
		AdvisorAppointmentList1();
	getDetails();
	
	}
	public static void getDetails()
    {
	//	 JOptionPane.showMessageDialog(null,StudentAdvisors.idpass);
		 try
	        {
	        	
	            String app="";
	             
	            Connection con = ConnectionProvider.getCon();
	            Statement st = con.createStatement();
	           
	           ResultSet rs;
	           String stt= "SELECT onlinesystem.meeting_has_advisor.id,student.First_Name, student.Last_name, meeting.slot, meeting.Date, meeting.Month_Year,onlinesystem.meeting_has_advisor.Status "
	           		+ "FROM onlinesystem.meeting "
	           		+ "inner join meeting_has_advisor on meeting_has_advisor.meeting_id = meeting.id "
	           		+ "inner join student on student.id = meeting_has_advisor.student_ID "
	           		+ "inner join advisor on advisor.id  = meeting_has_advisor.advisor_id "
	           		+ "where advisor.Username in (\""+   loginPage.textusername1.getText() + "\")";
        
        
	           
	           
	           Class.forName("com.mysql.cj.jdbc.Driver");
		         String userName= "root";
		     	 String password="toor";
				 String url= "jdbc:mysql://localhost:3306/onlinesystem";
				 con= DriverManager.getConnection(url,userName,password);
				 pst = con.prepareStatement(stt);
				 rs=pst.executeQuery();
				 table_1.setModel(DbUtils.resultSetToTableModel(rs));
	        }
		 catch(Exception ex)
	      {
	           JOptionPane.showMessageDialog(null, ex);
	        }			
    }
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdvisorAppointmentList frame = new AdvisorAppointmentList();
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
	public void AdvisorAppointmentList1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(480, 200, 1000, 600);
		contentPane1 = new JPanel();
		contentPane1.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane1);
		contentPane1.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(141, 11, 875, 42);
		contentPane1.add(panel);
		panel.setLayout(null);
		setUndecorated(true);
		
		JLabel lblNewLabel = new JLabel("Apointment:");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(0, 0, 748, 42);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(782, 0, 72, 36);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				dispose();
			}
		});
		lblNewLabel_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\jamun\\eclipse-workspace\\HostelManagementSystem\\images\\cancel.png"));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(782, 0, 72, 36);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.BLACK);
		panel_2.setBounds(141, 53, 323, 10);
		contentPane1.add(panel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(96, 116, 1118, 517);
		contentPane1.add(panel_3);
		panel_3.setLayout(null);
		
	
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBackground(new Color(102, 0, 0));
		panel_4.setBounds(40, 422, 205, 37);
		panel_3.add(panel_4);
		
		JLabel Delete_Button = new JLabel("Delete Appointment");
		Delete_Button.setBounds(0, 0, 205, 37);
		panel_4.add(Delete_Button);
		Delete_Button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				 try
		      		{
		        		 
		      			 Connection con = ConnectionProvider.getCon();
		      	            Statement st = con.createStatement();

	           	  
	            String sttt =("delete FROM onlinesystem.student_has_advisor WHERE onlinesystem.student_has_advisor.student_ID= \r\n"
	            		+ "(select onlinesystem.meeting_has_advisor.student_ID from"
	            		+ " onlinesystem.meeting_has_advisor where onlinesystem.meeting_has_advisor.id = ?)");
   	                      
	           	pst= con.prepareStatement(sttt);
	           	pst.setString(1,Id_textField.getText());
				
	       	 pst.executeUpdate();
				  
				  
				  
//				  
//		            String sttta =(" DELETE FROM onlinesystem.meeting_has_advisor WHERE student_ID = ((SELECT ID FROM onlinesystem.student "
//				      	           		+ "where onlinesystem.student.Username in ( \"" + loginPage.textusername1.getText()  + "\")))");
	   	           
				 String sttta =("delete From onlinesystem.meeting_has_advisor where onlinesystem.meeting_has_advisor.id = ?");
		           
				 pst= con.prepareStatement(sttta);
		           	pst.setString(1,Id_textField.getText());
					 pst.executeUpdate();
				 
					  
					 Id_textField.setText("");
				  
//			       String stt = ("UPDATE onlinesystem.advisor SET student_ID = \"\" WHERE student_ID = ((SELECT ID FROM onlinesystem.student "
//	      	           		+ "where onlinesystem.student.Username in ( \"" + loginPage.textusername1.getText()  + "\")))");
//
//	      	           
//	           	  pst= con.prepareStatement(stt);
//	           	    pst.executeUpdate();
//		      	           	    
				
			}
		        	 
         	 catch (Exception ex)
	        {
	           JOptionPane.showMessageDialog(null, "You can not delete at this time");
	       
	        }
				 getDetails();
				
				
				
			}
		});
		Delete_Button.setHorizontalAlignment(SwingConstants.CENTER);
		Delete_Button.setForeground(Color.WHITE);
		Delete_Button.setFont(new Font("Tahoma", Font.BOLD, 15));
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(40, 32, 791, 234);
			panel_3.add(scrollPane);
			
			table_1 = new JTable();
			scrollPane.setViewportView(table_1);
				
				JPanel panel_4_1 = new JPanel();
				panel_4_1.setLayout(null);
				panel_4_1.setBackground(new Color(102, 0, 0));
				panel_4_1.setBounds(40, 360, 205, 37);
				panel_3.add(panel_4_1);
						
							
						//	***************************************8	
							JLabel Complete_button = new JLabel("Complete");
							Complete_button.setBounds(0, 0, 205, 37);
							panel_4_1.add(Complete_button);
							Complete_button.addMouseListener(new MouseAdapter() {
								@Override
								public void mouseClicked(MouseEvent e) 
								{
									try
							        {
							        	
							            String app="Completed";
							             
							            Connection con = ConnectionProvider.getCon();
							            Statement st = con.createStatement();
							           
							           ResultSet rs;
							           String stt = "update onlinesystem.meeting_has_advisor set onlinesystem.meeting_has_advisor.Status = (\""+app+"\") where id = ?; ";
						        
						        

							           
							         	pst= con.prepareStatement(stt);
							           	pst.setString(1,Id_textField.getText());
							       	 pst.executeUpdate();
							       	 
							       	 
							       	 JOptionPane.showMessageDialog(null, "Appointment Completed!!");
							     
							       	 Id_textField.setText("");
							        }
								 catch(Exception ex)
							      {
							           JOptionPane.showMessageDialog(null, ex);
							        }			
								}
							});
							Complete_button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
							Complete_button.setHorizontalAlignment(SwingConstants.CENTER);
							Complete_button.setForeground(Color.WHITE);
							Complete_button.setFont(new Font("Tahoma", Font.BOLD, 15));
							
							JPanel panel_4_1_1 = new JPanel();
							panel_4_1_1.setLayout(null);
							panel_4_1_1.setBackground(new Color(102, 0, 0));
							panel_4_1_1.setBounds(40, 292, 205, 37);
							panel_3.add(panel_4_1_1);
							
							JLabel Id_label = new JLabel("Meeting Id");
							Id_label.setForeground(new Color(255, 255, 255));
							Id_label.setFont(new Font("Tahoma", Font.BOLD, 15));
							Id_label.setHorizontalAlignment(SwingConstants.CENTER);
							Id_label.setBounds(0, 0, 205, 37);
							panel_4_1_1.add(Id_label);
							
							Id_textField = new JTextField();
							Id_textField.setBounds(255, 290, 175, 39);
							panel_3.add(Id_textField);
							Id_textField.setColumns(10);
		
		
	}
}
