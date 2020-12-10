import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
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

public class TrioAdvisors extends JFrame {
	private JPanel contentPane1;
	private JTextField customer_ID;
	private JTable table;
	private static JLabel Phone;
	private static JLabel Email;
	private static JLabel Name;
	private static JLabel Department;
	private static JLabel Photo;
	


	/**
	 * Launch the application.
	 */
	
	
	public TrioAdvisors ()
	{
		TrioAdvisors1();
	getDetails();
	
	}
	public static void getDetails()
    {
		// JOptionPane.showMessageDialog(null,StudentAdvisors.idpass);
        try
        {
            String name="";
            String email="";
            String phone="";
            String dep="";
            String userName="";
            String password ="";
            String uniqueID="";
            byte[] pto = null;
            Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(
            		"jdbc:mysql://127.0.0.1:3306/onlinesystem?serverTimezone=UTC", "root", "toor");
            Statement st = con.createStatement();
          
           ResultSet rs;
           rs = st.executeQuery("SELECT concat(advisor.First_Name, advisor.Last_Name),advisor.Email,advisor.Phone_No,advisor.Department,advisor.image "
           		+ "FROM onlinesystem.advisor where id = (\"" + StudentAdvisors.idpass  + "\")");
             
            while(rs.next())
            {
               // userName+=rs.getString(3);
               // password+=rs.getString(4);
                name+=rs.getString(1);
                email+=rs.getString(2);
                dep+=rs.getString(4);
                phone+=rs.getString(3);
                pto=rs.getBytes(5);
             //   uniqueID+=rs.getString(8);
            }
            Name.setText(name);
            Email.setText(email);
            Phone.setText(phone);
            Department.setText(dep);
            //Resize The ImageIcon
            ImageIcon image = new ImageIcon(pto);
            Image myImg = image.getImage();
            ImageIcon newImage = new ImageIcon(myImg);
           Photo.setIcon(newImage);
          //  userName.setText(userName);
          //  password.setText(password);
         //   ID.setText(uniqueID);
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
					TrioAdvisors frame = new TrioAdvisors();
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
	public void TrioAdvisors1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 200, 1102, 658);
		contentPane1 = new JPanel();
		contentPane1.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane1);
		contentPane1.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(141, 11, 951, 42);
		contentPane1.add(panel);
		panel.setLayout(null);
		setUndecorated(true);
		
		JLabel lblNewLabel = new JLabel("Advisor Details:");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(0, 0, 748, 42);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(860, 0, 81, 36);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				setVisible(false);
			}
		});
		lblNewLabel_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\jamun\\eclipse-workspace\\HostelManagementSystem\\images\\cancel.png"));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.BLACK);
		panel_2.setBounds(141, 53, 323, 10);
		contentPane1.add(panel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(-22, 109, 1236, 509);
		contentPane1.add(panel_3);
		panel_3.setLayout(null);
		
	
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBackground(new Color(102, 0, 0));
		panel_4.setBounds(40, 294, 205, 37);
		panel_3.add(panel_4);
		
			
		//	***************************************8	
			JLabel label_1 = new JLabel("schedule an appointment");
			label_1.setBounds(0, 0, 205, 37);
			panel_4.add(label_1);
			label_1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) 
				{
					dispose();
					MainApp appoint = new MainApp();
					appoint.setVisible(true);
				}
			});
			label_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			label_1.setHorizontalAlignment(SwingConstants.CENTER);
			label_1.setForeground(Color.WHITE);
			label_1.setFont(new Font("Tahoma", Font.BOLD, 15));
			
			Name = new JLabel();
			Name.setFont(new Font("Tahoma", Font.BOLD, 14));
			Name.setBounds(40, 29, 222, 37);
			panel_3.add(Name);
			
			Department = new JLabel();
			Department.setFont(new Font("Tahoma", Font.BOLD, 14));
			Department.setBounds(40, 72, 222, 37);
			panel_3.add(Department);
			
			Photo = new JLabel();
			Photo.setBounds(554, 57, 265, 246);
			panel_3.add(Photo);
			
			Email = new JLabel();
			Email.setFont(new Font("Tahoma", Font.BOLD, 14));
			Email.setBounds(40, 158, 222, 37);
			panel_3.add(Email);
			
			Phone= new JLabel();
			Phone.setFont(new Font("Tahoma", Font.BOLD, 14));
			Phone.setText("");
			Phone.setBounds(40, 120, 222, 37);
			panel_3.add(Phone);
		
		
	}
}
