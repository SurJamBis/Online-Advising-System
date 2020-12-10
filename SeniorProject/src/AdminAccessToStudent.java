
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.proteanit.sql.DbUtils;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPasswordField;
public class AdminAccessToStudent extends JFrame 
{
	private static final long serialVersionUID = 1L;
	Connection con = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	private JPanel contentPane;
	private JTextField ID;
	private JTextField First_Name;
	private JTextField Last_Name;
	private JTextField Address;
	private JTable table;
	private JTextField Email;
	private JTextField Phone;
	private JTextField username;
	private JPasswordField Pas;

	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminAccessToStudent frame = new AdminAccessToStudent();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public AdminAccessToStudent() 
	{
		setType(Type.UTILITY);
		setFont(new Font("Times New Roman", Font.BOLD, 24));
		setTitle("CS Student ");
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 280, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setUndecorated(true);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(28, 127, 85, 19);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("First_Name");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(28, 164, 85, 19);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Last_Name");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setBounds(28, 202, 85, 19);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Address");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3.setBounds(28, 240, 85, 19);
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Email");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_4.setBounds(28, 278, 85, 19);
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		contentPane.add(lblNewLabel_4);
	
		JLabel lblNewLabel_6 = new JLabel("Phone");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_6.setBounds(28, 392, 85, 19);
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		contentPane.add(lblNewLabel_6);

		JLabel lblNewLabel_6_1 = new JLabel("password");
		lblNewLabel_6_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_6_1.setBounds(28, 354, 85, 19);
		lblNewLabel_6_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		contentPane.add(lblNewLabel_6_1);
		JLabel lblNewLabel_8_1 = new JLabel("username");
		lblNewLabel_8_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_8_1.setBounds(28, 316, 85, 19);
		lblNewLabel_8_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		contentPane.add(lblNewLabel_8_1);
		
		
		ID = new JTextField();
		ID.setBounds(133, 124, 174, 27);
		ID.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		contentPane.add(ID);
		ID.setColumns(10);
		
		First_Name = new JTextField();
		First_Name.setBounds(133, 160, 174, 27);
		First_Name.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		contentPane.add(First_Name);
		First_Name.setColumns(10);
		
		Last_Name = new JTextField();
		Last_Name.setBounds(133, 198, 174, 27);
		Last_Name.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		contentPane.add(Last_Name);
		Last_Name.setColumns(10);
		
		Address = new JTextField();
		Address.setBounds(133, 236, 174, 27);
		Address.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		contentPane.add(Address);
		Address.setColumns(10);
			
		Email = new JTextField();
		Email.setBounds(133, 274, 174, 27);
		Email.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		contentPane.add(Email);
		Email.setColumns(10);
		Phone = new JTextField();
		Phone.setBounds(133, 388, 174, 27);
		Phone.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		Phone.setColumns(10);
		contentPane.add(Phone);
		
	
		
		username = new JTextField();
		username.setBounds(133, 312, 174, 27);
		username.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		username.setColumns(10);
		contentPane.add(username);
		Phone.setColumns(10);
		// The below is the part of inserting the database	
		
		JButton btnNewButton = new JButton("Insert");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(102, 0, 0));
		btnNewButton.setBounds(10, 562, 85, 27);
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					String st="INSERT INTO onlinesystem.student"
							+"(ID, First_Name,Last_Name,Address,Email,Phone,username,password)"
							+"VALUES (?, ?, ?, ?, ?,?,?,?)";
					    Class.forName("com.mysql.cj.jdbc.Driver");
			            System.out.println("Connected to MySQL");
			 			 String userName= "root";
						 String password="toor";
						 String url= "jdbc:mysql://localhost:3306/onlinesystem";
						 con= DriverManager.getConnection(url,userName,password);
					//	 System.out.println("\n Database Connection Established....");
						  pst= con.prepareStatement(st);
						  pst.setString(1,ID.getText());
						  pst.setString(2,First_Name.getText());
						  pst.setString(3,Last_Name.getText());
						  pst.setString(4,Address.getText());
						  pst.setString(5,Email.getText());
						  pst.setString(6,Phone.getText());
						  pst.setString(7,username.getText());
						  pst.setString(8,Pas.getText());
						 
						  pst.executeUpdate();
						  JOptionPane.showMessageDialog(null, "Inserted Successful");
						  
						  ID.setText("");
						  First_Name.setText("");
						  Last_Name.setText("");
						  Address.setText("");
						  Email.setText("");
						  Phone.setText("");
						  username.setText("");
						  Pas.setText("");
						  
				}
						  catch (Exception ex)
					        {
					           JOptionPane.showMessageDialog(null, ex);
					        }
						 
			}
		});
		contentPane.add(btnNewButton);
		
		//The below is the delete part of the Database where we use the customer id as the key for deleting the data
		
		JButton btnNewButton_1 = new JButton("Delete");
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBackground(new Color(102, 0, 0));
		btnNewButton_1.setBounds(105, 562, 96, 27);
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
			
			
			try
			{
				 String st="DELETE FROM onlinesystem.student WHERE ID = ? ";
				 Class.forName("com.mysql.cj.jdbc.Driver");
		         String userName= "root";
		     	 String password="toor";
				 String url= "jdbc:mysql://localhost:3306/onlinesystem";
				 con= DriverManager.getConnection(url,userName,password);
			//	 System.out.println("\n Database Connection Established....");
				 pst= con.prepareStatement(st);
				 pst.setString(1,ID.getText());
				 pst.executeUpdate();
				JOptionPane.showMessageDialog(null, "Deleted Successful");
				
				ID.setText("");
			}
			
			catch (Exception ex)
			{
			        JOptionPane.showMessageDialog(null, ex);
			}
					 
		}
				
			
		});
		contentPane.add(btnNewButton_1);
	
		//The below is the Part where we can update the database,
		//just we need to know which Id we are going to update other information.
		JButton btnNewButton_2 = new JButton("Update");
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		btnNewButton_2.setBackground(new Color(102, 0, 0));
		btnNewButton_2.setBounds(211, 562, 96, 27);
		btnNewButton_2.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					String st="update onlinesystem.student set First_Name=?,Last_Name=?,Address=?,Email=?,Phone=?,username=?, password= ? where ID=?";
					Class.forName("com.mysql.cj.jdbc.Driver");
		            System.out.println("Connected to MySQL");
		 			 String userName= "root";
					 String password="toor";
					 String url= "jdbc:mysql://localhost:3306/onlinesystem";
					 con= DriverManager.getConnection(url,userName,password);
			//		 System.out.println("\n Database Connection Established....");
					  pst= con.prepareStatement(st);
					  pst.setString(8,ID.getText());
					  pst.setString(1,First_Name.getText());
					  pst.setString(2,Last_Name.getText());
					  pst.setString(3,Address.getText());
					  pst.setString(4,Email.getText());
					 // pst.setString(5,password.getText());
					  pst.setString(5,Phone.getText());
					  pst.setString(6,username.getText());
					  pst.setString(7,Pas.getText());
					  
					//  
					  pst.executeUpdate();
					  JOptionPane.showMessageDialog(null, "Updated Successful");
					  
					  ID.setText("");
					  First_Name.setText("");
					  Last_Name.setText("");
					  Address.setText("");
					  Email.setText("");
					  Phone.setText("");
					  username.setText("");
					  Pas.setText("");
				}
						  catch (Exception ex)
					        {
					           JOptionPane.showMessageDialog(null, ex);
					        }
				
						 
			
			}
		});
		contentPane.add(btnNewButton_2);
		
		//The below is  table part, we can see all the list of the customers list.
		JButton btnNewButton_3 = new JButton("Students");
		btnNewButton_3.setForeground(new Color(255, 255, 255));
		btnNewButton_3.setBackground(new Color(102, 0, 0));
		btnNewButton_3.setBounds(605, 77, 117, 32);
		btnNewButton_3.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					String st="SELECT ID, First_Name,Last_Name,Address,Email,Phone FROM onlinesystem.student;";
					 Class.forName("com.mysql.cj.jdbc.Driver");
			         String userName= "root";
			     	 String password="toor";
					 String url= "jdbc:mysql://localhost:3306/onlinesystem";
					 con= DriverManager.getConnection(url,userName,password);
				//	 System.out.println("\n Database Connection Established....");
					 pst = con.prepareStatement(st);
					 rs=pst.executeQuery();
					 table.setModel(DbUtils.resultSetToTableModel(rs));
				 }
				
				catch (Exception ex)
				{
					  JOptionPane.showMessageDialog(null, ex);
				}
				
			
			}
		});
		contentPane.add(btnNewButton_3);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(325, 124, 651, 465);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e)
			{
				dispose();
			}
		});
		lblNewLabel_5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setIcon(new ImageIcon("C:\\Users\\jamun\\eclipse-workspace\\HostelManagementSystem\\images\\shut.png"));
		lblNewLabel_5.setBounds(930, 64, 46, 37);
		contentPane.add(lblNewLabel_5);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(102, 102, 102));
		panel.setBounds(28, 11, 243, 47);
		contentPane.add(panel);
		
		JLabel label = new JLabel("Classes List");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Stencil", Font.BOLD, 25));
		label.setBounds(10, 0, 215, 47);
		panel.add(label);
		
		Pas = new JPasswordField();
		Pas.setBounds(133, 354, 174, 27);
		contentPane.add(Pas);
		
		
		
		
		
		
		
		 
	 
		
	}
}
	