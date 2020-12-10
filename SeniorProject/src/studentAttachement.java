import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import java.awt.Cursor;
import javax.swing.UIManager;
import java.awt.Color;




public class studentAttachement extends JFrame {
	static Connection con = null;
	 
	static ResultSet rs = null;
	private JPanel contentPane;
	private static JLabel UserShow;
	static java.sql.PreparedStatement pst = null;
	private JLabel IDlable;
	private JLabel Documentlabel;
	private JLabel Phonelabel;
	private JLabel Emaillabel;
	private static JLabel F_Name;
	private static JLabel L_Name;
	private static JLabel Phone;
	private static JLabel Email;
	private static JScrollPane scrollPane;
	private static JLabel readfile;
	private static JTable table;
	private static JLabel student_ID;
	private static String filename;
	private static JTextField des;
	private static JTextField descrip;
	private static DataInputStream dis;
	private JLabel lblNewLabel;
	private JPanel panel;
	private JLabel lblNewLabel_1;
	/**
	 * Launch the application.
	 */
	
	
	public studentAttachement ()
	{
		studentAttachement1();
	getDetails();

	
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					studentAttachement frame = new studentAttachement();
					getDetails();
				
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
				String st="SELECT * FROM onlinesystem.studentclearance where student_ID = (SELECT ID FROM onlinesystem.student "
	           		+ "where onlinesystem.student.Username in ( \"" + loginPage.textusername1.getText()  + "\"))";
				 Class.forName("com.mysql.cj.jdbc.Driver");
		         String userName= "root";
		     	 String password="toor";
				 String url= "jdbc:mysql://localhost:3306/onlinesystem";
				 con= DriverManager.getConnection(url,userName,password);
				 System.out.println("\n Database Connection Established....");
				 pst = con.prepareStatement(st);
				 rs=pst.executeQuery();
				 table.setModel(DbUtils.resultSetToTableModel(rs));
			 }
			
			catch (Exception ex)
			{
				  JOptionPane.showMessageDialog(null, ex);
			}
		 
        try
        {
        	
            String fname="";
            String lname="";
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
           
           rs = st.executeQuery("select * from onlinesystem.student where username = \""
        //		   " student.Username in (\"jam\")");
          + loginPage.textusername1.getText() + "\" and password=\"" + loginPage.textpassword1.getText() +"\"");
         
            while(rs.next())
            {
                userName+=rs.getString(7);
                password+=rs.getString(8);
                fname+=rs.getString(2);
                lname+=rs.getString(3);
                email+=rs.getString(6);
                phone+=rs.getString(5);
                uniqueID+=rs.getString(1);
               
            }
            F_Name.setText(fname);
            L_Name.setText(lname);
            Email.setText(email);
            Phone.setText(phone);
            student_ID.setText(uniqueID);
        }

        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

	public static void getDetailsDocument()
    {
		try
        {
        	
            String fname="";
            String lname="";
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
           
           rs = st.executeQuery("SELECT studentclearance.Attach FROM onlinesystem.studentclearance where student_ID in(SELECT ID FROM onlinesystem.student "
           		+ "where onlinesystem.student.Username in (\"" + loginPage.textusername1.getText()  + "\"))");
         //  loginPage.textusername1.getText() + "\" and password=\"" + loginPage.textpassword1.getText() +"\"");
           
       // 			+ " where student.Username in (\"jam\")";
            
           while(rs.next())
           {
                
               fname =rs.getString(1);
                
           }
//          // F_Name.setText(fname);
//           File file = new File(fname);
//           if(file.toString().endsWith(".pdf"))
               Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + fname +"");
//           else{
//               Desktop dt = Desktop.getDesktop();
//               dt.open(file);
//           }
        }
        	    

        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
        
        	    

 
	

		  
	public void studentAttachement1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 200, 1000, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		//getDetails();
		setUndecorated(true);
		JButton btnNewButton = new JButton("Upload");
		
		
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				String descrip = des.getText();
				//getDetails();
				try
		        {   // byte[] pto = null;
				    Connection con = ConnectionProvider.getCon();
		            Statement stt = con.createStatement();
		             
			           String st = "Insert onlinesystem.studentclearance set studentclearance.student_ID = ?, F_Name=?, L_Name=?,Email=?, "
			           		+ "Phone=?, studentclearance.Document = ?, Attach=? ";
			           	//	+ " where student.Username in (\"jam\")";
			        //   		username=\"" +  loginPage.textusername1.getText() + "\"and password=\"" + loginPage.textpassword1.getText() + "\"";
			       //   Connection con = ConnectionProvider.getCon();
			          pst= con.prepareStatement(st);
			    
			          //InputStream inputStream = new FileInputStream(new File(filename));
			   
			          pst.setString(1,student_ID.getText());
					  pst.setString(2,F_Name.getText());
					  pst.setString(3,L_Name.getText());
					  pst.setString(4,Email.getText());
					  pst.setString(6,descrip);
					//  des.setText(descrip);
					  pst.setString(5,Phone.getText());
				       pst.setString(7, filename);
				  
					  pst.executeUpdate();
					  JOptionPane.showMessageDialog(null, "Updated Successful");    
					  
				}
						  catch (Exception ex)
					        {
					           JOptionPane.showMessageDialog(null, ex);
					        }
				getDetailsDocument();
			}			    
				    
				
				
			
		});
	
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(739, 550, 103, 33);
		contentPane.add(btnNewButton);
		
		JLabel F_Namelabel = new JLabel("First Name");
		F_Namelabel.setHorizontalAlignment(SwingConstants.RIGHT);
		F_Namelabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		F_Namelabel.setBounds(62, 161, 79, 33);
		contentPane.add(F_Namelabel);
		
		JLabel L_NameLabel = new JLabel("Last Name");
		L_NameLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		L_NameLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		L_NameLabel.setBounds(62, 204, 79, 33);
		contentPane.add(L_NameLabel);
		
		IDlable = new JLabel("ID");
		IDlable.setHorizontalAlignment(SwingConstants.RIGHT);
		IDlable.setFont(new Font("Tahoma", Font.BOLD, 14));
		IDlable.setBounds(62, 120, 79, 33);
		contentPane.add(IDlable);
		
		Documentlabel = new JLabel("Document");
		Documentlabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		Documentlabel.setBounds(82, 529, 79, 33);
		contentPane.add(Documentlabel);
		
		Phonelabel = new JLabel("Phone");
		Phonelabel.setHorizontalAlignment(SwingConstants.RIGHT);
		Phonelabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		Phonelabel.setBounds(62, 290, 79, 33);
		contentPane.add(Phonelabel);
		
		Emaillabel = new JLabel("Email");
		Emaillabel.setHorizontalAlignment(SwingConstants.RIGHT);
		Emaillabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		Emaillabel.setBounds(62, 247, 79, 33);
		contentPane.add(Emaillabel);
		
		F_Name = new JLabel();
		F_Name.setFont(new Font("Tahoma", Font.PLAIN, 14));
		F_Name.setBounds(171, 161, 171, 33);
		contentPane.add(F_Name);
		
		L_Name = new JLabel();
		L_Name.setFont(new Font("Tahoma", Font.PLAIN, 14));
		L_Name.setBounds(171, 204, 171, 33);
		contentPane.add(L_Name);
		
		Phone = new JLabel();
		Phone.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Phone.setBounds(171, 290, 171, 33);
		contentPane.add(Phone);
		
		Email = new JLabel();
		Email.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Email.setBounds(171, 245, 171, 35);
		contentPane.add(Email);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(362, 120, 628, 378);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		readfile = new JLabel();
		scrollPane.setColumnHeaderView(readfile);
		
		student_ID = new JLabel();
		student_ID.setText("");
		student_ID.setFont(new Font("Tahoma", Font.PLAIN, 14));
		student_ID.setBounds(171, 120, 171, 34);
		contentPane.add(student_ID);
		
		JButton AttachemntButton = new JButton("Attachment");
		AttachemntButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		AttachemntButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				JFileChooser chooser = new JFileChooser();
				chooser.showOpenDialog(null);
				File f = chooser.getSelectedFile();
				filename = f.getAbsolutePath();
			
			}
		});
		AttachemntButton.setBounds(725, 510, 117, 30);
		contentPane.add(AttachemntButton);
		
		des = new JTextField();
		des.setBounds(171, 538, 297, 45);
		contentPane.add(des);
		des.setColumns(10);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				dispose();
			}
		});
		lblNewLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\jamun\\eclipse-workspace\\HostelManagementSystem\\images\\cancel.png"));
		lblNewLabel.setBounds(926, 11, 64, 38);
		contentPane.add(lblNewLabel);
		
		panel = new JPanel();
		panel.setBackground(new Color(102, 102, 102));
		panel.setBounds(95, 11, 739, 38);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblNewLabel_1 = new JLabel("Upload Document for Clearance");
		lblNewLabel_1.setFont(new Font("Stencil", Font.BOLD, 30));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(UIManager.getColor("Button.highlight"));
		lblNewLabel_1.setBounds(10, 0, 719, 38);
		panel.add(lblNewLabel_1);
	}
}
