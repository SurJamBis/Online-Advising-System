
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
public class AdminAccessToClasses extends JFrame 
{
	private static final long serialVersionUID = 1L;
	Connection con = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	private JPanel contentPane;
	private JTextField ID;
	private JTextField Subject;
	private JTextField CRN;
	private JTextField Title;
	private JTable table;
	private JTextField Units;
	private JTextField StartDate;
	private JTextField EndDate;
	private JTextField MeetingTime;
	private JTextField Location;
	private JTextField Instructor;

	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminAccessToClasses frame = new AdminAccessToClasses();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public AdminAccessToClasses() 
	{
		setType(Type.UTILITY);
		setFont(new Font("Times New Roman", Font.BOLD, 24));
		setTitle("CS Classes ");
	
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
		lblNewLabel.setBounds(10, 109, 85, 19);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Subject");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(10, 148, 85, 19);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("CRN");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setBounds(10, 186, 85, 19);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 16));
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Title");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3.setBounds(10, 223, 85, 19);
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 16));
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Units");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_4.setBounds(10, 260, 85, 19);
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 16));
		contentPane.add(lblNewLabel_4);
	
		JLabel lblNewLabel_6 = new JLabel("End Date");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_6.setBounds(10, 333, 85, 19);
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.BOLD, 16));
		contentPane.add(lblNewLabel_6);
	
		JLabel lblNewLabel_8 = new JLabel("Location");
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_8.setBounds(10, 407, 85, 19);
		lblNewLabel_8.setFont(new Font("Times New Roman", Font.BOLD, 16));
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Instructure");
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_9.setBounds(10, 443, 85, 19);
		lblNewLabel_9.setFont(new Font("Times New Roman", Font.BOLD, 16));
		contentPane.add(lblNewLabel_9);

		JLabel lblNewLabel_6_1 = new JLabel("Start Date");
		lblNewLabel_6_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_6_1.setBounds(10, 296, 85, 19);
		lblNewLabel_6_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		contentPane.add(lblNewLabel_6_1);
		JLabel lblNewLabel_8_1 = new JLabel("Meeting Time");
		lblNewLabel_8_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_8_1.setBounds(-7, 370, 96, 19);
		lblNewLabel_8_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		contentPane.add(lblNewLabel_8_1);
		
		
		ID = new JTextField();
		ID.setBounds(115, 106, 184, 26);
		ID.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		contentPane.add(ID);
		ID.setColumns(10);
		
		Subject = new JTextField();
		Subject.setBounds(115, 145, 184, 26);
		Subject.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		contentPane.add(Subject);
		Subject.setColumns(10);
		
		CRN = new JTextField();
		CRN.setBounds(115, 183, 184, 26);
		CRN.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		contentPane.add(CRN);
		CRN.setColumns(10);
		
		Title = new JTextField();
		Title.setBounds(115, 220, 184, 26);
		Title.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		contentPane.add(Title);
		Title.setColumns(10);
			
		Units = new JTextField();
		Units.setBounds(115, 257, 184, 26);
		Units.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		contentPane.add(Units);
		Units.setColumns(10);
		
		StartDate = new JTextField();
		StartDate.setBounds(115, 293, 184, 26);
		StartDate.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		contentPane.add(StartDate);
		StartDate.setColumns(10);
		EndDate = new JTextField();
		EndDate.setBounds(115, 330, 184, 26);
		EndDate.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		EndDate.setColumns(10);
		contentPane.add(EndDate);
		
	
		
		MeetingTime = new JTextField();
		MeetingTime.setBounds(115, 367, 184, 26);
		MeetingTime.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		MeetingTime.setColumns(10);
		contentPane.add(MeetingTime);
		
		Location = new JTextField();
		Location.setBounds(115, 404, 184, 26);
		Location.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		Location.setColumns(10);
		contentPane.add(Location);
		
		Instructor = new JTextField();
		Instructor.setBounds(115, 441, 184, 26);
		Instructor.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		Instructor.setColumns(10);
		contentPane.add(Instructor);
		EndDate.setColumns(10);
		// The below is the part of inserting the database	
		
		JButton btnNewButton = new JButton("Insert");
		btnNewButton.setBackground(new Color(102, 0, 0));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBounds(10, 550, 85, 26);
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					String st="INSERT INTO onlinesystem.coursrs"
							+"(ID, Subject,CRN,Title,Units,Start_Date,End_Date,Meeting_Time,Location,Instructor)"
							+"VALUES (?, ?, ?, ?, ?,?,?,?,?,?)";
					    Class.forName("com.mysql.cj.jdbc.Driver");
			       //     System.out.println("Connected to MySQL");
			 			 String userName= "root";
						 String password="toor";
						 String url= "jdbc:mysql://localhost:3306/project";
						 con= DriverManager.getConnection(url,userName,password);
					//	 System.out.println("\n Database Connection Established....");
						  pst= con.prepareStatement(st);
						  pst.setString(1,ID.getText());
						  pst.setString(2,Subject.getText());
						  pst.setString(3,CRN.getText());
						  pst.setString(4,Title.getText());
						  pst.setString(5,Units.getText());
						  pst.setString(6,StartDate.getText());
						  pst.setString(7,EndDate.getText());
						  pst.setString(8,MeetingTime.getText());
						  pst.setString(9,Location.getText());
						  pst.setString(10,Instructor.getText());
						  
						  pst.executeUpdate();
						  JOptionPane.showMessageDialog(null, "Inserted Successful");
						  
						  ID.setText("");
						  Subject.setText("");
						  CRN.setText("");
						  Title.setText("");
						  Units.setText("");
						  StartDate.setText("");
						  EndDate.setText("");
						  MeetingTime.setText("");
						  Location.setText("");
						  Instructor.setText("");
						 
						  
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
		btnNewButton_1.setBackground(new Color(102, 0, 0));
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBounds(116, 550, 96, 26);
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
			
			
			try
			{
				 String st="DELETE FROM onlinesystem.coursrs WHERE ID = ? ";
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
		btnNewButton_2.setBackground(new Color(102, 0, 0));
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		btnNewButton_2.setBounds(222, 550, 96, 26);
		btnNewButton_2.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					String st="update onlinesystem.coursrs set Subject=?,CRN=?,Title=?,Units=?,Start_Date=?,End_Date=?, Meeting_Time= ?,Location= ?,Instructor = ? where ID=?";
					Class.forName("com.mysql.cj.jdbc.Driver");
		          //  System.out.println("Connected to MySQL");
		 			 String userName= "root";
					 String password="toor";
					 String url= "jdbc:mysql://localhost:3306/onlinesystem";
					 con= DriverManager.getConnection(url,userName,password);
			//		 System.out.println("\n Database Connection Established....");
					  pst= con.prepareStatement(st);
					  pst.setString(10,ID.getText());
					  pst.setString(1,Subject.getText());
					  pst.setString(2,CRN.getText());
					  pst.setString(3,Title.getText());
					  pst.setString(4,Units.getText());
					  pst.setString(5,StartDate.getText());
					  pst.setString(6,EndDate.getText());
					  pst.setString(7,MeetingTime.getText());
					  pst.setString(8,Location.getText());
					  pst.setString(9,Instructor.getText());
					  
					  pst.executeUpdate();
					  JOptionPane.showMessageDialog(null, "Updated Successful");
					  
					  ID.setText("");
					  Subject.setText("");
					  CRN.setText("");
					  Title.setText("");
					  Units.setText("");
					  StartDate.setText("");
					  EndDate.setText("");
					  MeetingTime.setText("");
					  Location.setText("");
					  Instructor.setText("");
					  
					  
				}
						  catch (Exception ex)
					        {
					           JOptionPane.showMessageDialog(null, ex);
					        }
				
						 
			
			}
		});
		contentPane.add(btnNewButton_2);
		
		//The below is  table part, we can see all the list of the customers list.
		JButton btnNewButton_3 = new JButton("Classes");
		btnNewButton_3.setBackground(new Color(102, 0, 0));
		btnNewButton_3.setForeground(new Color(255, 255, 255));
		btnNewButton_3.setBounds(578, 58, 117, 32);
		btnNewButton_3.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					String st="SELECT ID, Subject,CRN,Title,Units,Start_Date,End_Date,"
							+ "Meeting_Time,Location,Instructor\r\n" + 
							"FROM onlinesystem.coursrs;";
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
		scrollPane.setBounds(328, 106, 651, 465);
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
		lblNewLabel_5.setBounds(933, 42, 46, 42);
		contentPane.add(lblNewLabel_5);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(102, 102, 102));
		panel.setBounds(10, 7, 243, 47);
		contentPane.add(panel);
		
		JLabel lblClassesList = new JLabel("Classes List");
		lblClassesList.setForeground(Color.WHITE);
		lblClassesList.setFont(new Font("Stencil", Font.BOLD, 25));
		lblClassesList.setBounds(10, 0, 215, 47);
		panel.add(lblClassesList);
		
		
		
		
		
		
		
		 
	 
		
	}
}
	