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

public class MulticulturalAd extends JFrame {
	private JPanel contentPane1;
	private JTextField customer_ID;
	private static JLabel First_Name;
	private static JLabel Last_Name_1;
	private JTextField Address;
	private JTable table;
	private JTextField Phone;
	private JTextField Email;


	/**
	 * Launch the application.
	 */
	
	
	public MulticulturalAd ()
	{
		MulticulturalAd1();
	getDetails();
	
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
            Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(
            		"jdbc:mysql://127.0.0.1:3306/onlinesystem?serverTimezone=UTC", "root", "toor");
            Statement st = con.createStatement();
          
           ResultSet rs;
           rs = st.executeQuery("SELECT First_Name,Last_Name  FROM onlinesystem.advisor WHERE id=13");
             
            while(rs.next())
            {
               // userName+=rs.getString(3);
               // password+=rs.getString(4);
                fname+=rs.getString(1);
                lname+=rs.getString(2);
             //   email+=rs.getString(5);
            //    address+=rs.getString(7);
            ///    phone+=rs.getString(6);
             //   uniqueID+=rs.getString(8);
            }
            First_Name.setText(fname);
            Last_Name_1.setText(lname);
          //  Email.setText(email);
          //  Phone.setText(phone);
          //  Address.setText(address);
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
					MulticulturalAd frame = new MulticulturalAd();
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
	public void MulticulturalAd1() {
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
		
		JLabel lblNewLabel = new JLabel("Multicultural Centers Advisors:");
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
				setVisible(false);
			}
		});
		lblNewLabel_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\jamun\\eclipse-workspace\\SeniorProject\\image\\pbackicon.png"));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(782, 0, 72, 36);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.BLACK);
		panel_2.setBounds(141, 53, 323, 10);
		contentPane1.add(panel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(96, 109, 1118, 517);
		contentPane1.add(panel_3);
		panel_3.setLayout(null);
		
		//JLabel lblNewLabel_2 = new JLabel("Catherine Jermany");
		First_Name = new JLabel();
		First_Name.setFont(new Font("Tahoma", Font.PLAIN, 15));
		First_Name.setBounds(52, 11, 78, 30);
		panel_3.add(First_Name);
		
		Last_Name_1 = new JLabel();
		Last_Name_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Last_Name_1.setBounds(128, 11, 106, 30);
		panel_3.add(Last_Name_1);
		
		JLabel lblNewLabel_3 = new JLabel("Coordinator, Rose Black Resource Center");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3.setBounds(52, 35, 319, 30);
		panel_3.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("cjermany1@csudh.edu");
		lblNewLabel_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				//Calender cal = new Calender();
				//cal.setVisible(true);
			}
			
		});
		lblNewLabel_4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_4.setForeground(Color.BLUE);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(52, 63, 244, 30);
		panel_3.add(lblNewLabel_4);
		
		JLabel lblAnaBarragan = new JLabel("Ana Barragan");
		lblAnaBarragan.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAnaBarragan.setBounds(52, 172, 158, 30);
		panel_3.add(lblAnaBarragan);
		
		JLabel lblTdscCoordinatorMulticultural = new JLabel("TDSC Coordinator, Multicultural Affairs");
		lblTdscCoordinatorMulticultural.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTdscCoordinatorMulticultural.setBounds(52, 196, 319, 30);
		panel_3.add(lblTdscCoordinatorMulticultural);
		
		JLabel label = new JLabel("abarragan@csudh.edu");
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				//Calender cal = new Calender();
				//cal.setVisible(true);
			}
		});
		label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label.setHorizontalAlignment(SwingConstants.LEFT);
		label.setForeground(Color.BLUE);
		label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label.setBounds(52, 226, 244, 30);
		panel_3.add(label);
		
		JLabel lblArlinGonzalez = new JLabel("Arlin Gonzalez");
		lblArlinGonzalez.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblArlinGonzalez.setBounds(52, 336, 158, 30);
		panel_3.add(lblArlinGonzalez);
		
		JLabel lblAdvisorTdsc = new JLabel("Advisor, TDSC");
		lblAdvisorTdsc.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAdvisorTdsc.setBounds(52, 360, 319, 30);
		panel_3.add(lblAdvisorTdsc);
		
		JLabel lblAgonzalezcsudhedu = new JLabel("agonzalez322@csudh.edu");
		lblAgonzalezcsudhedu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				//Calender cal = new Calender();
				//cal.setVisible(true);
			}
		});
		lblAgonzalezcsudhedu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblAgonzalezcsudhedu.setHorizontalAlignment(SwingConstants.LEFT);
		lblAgonzalezcsudhedu.setForeground(Color.BLUE);
		lblAgonzalezcsudhedu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAgonzalezcsudhedu.setBounds(52, 377, 244, 30);
		panel_3.add(lblAgonzalezcsudhedu);
		
		JLabel lblKaramaBlackhorn = new JLabel("Karama Blackhorn");
		lblKaramaBlackhorn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblKaramaBlackhorn.setBounds(455, 35, 158, 30);
		panel_3.add(lblKaramaBlackhorn);
		
		JLabel lblQueerCultureAnd = new JLabel("Queer Culture and Resource Center Program Coordinator");
		lblQueerCultureAnd.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblQueerCultureAnd.setBounds(455, 63, 447, 30);
		panel_3.add(lblQueerCultureAnd);
		
		JLabel lblMulticulturalAffairs = new JLabel("Multicultural Affairs");
		lblMulticulturalAffairs.setForeground(Color.BLACK);
		lblMulticulturalAffairs.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMulticulturalAffairs.setBounds(455, 91, 158, 30);
		panel_3.add(lblMulticulturalAffairs);
		
		JLabel lblKblackhorncsudhedu = new JLabel("kblackhorn@csudh.edu");
		lblKblackhorncsudhedu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				//Calender cal = new Calender();
				//cal.setVisible(true);
			}
		});
		lblKblackhorncsudhedu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblKblackhorncsudhedu.setHorizontalAlignment(SwingConstants.LEFT);
		lblKblackhorncsudhedu.setForeground(Color.BLUE);
		lblKblackhorncsudhedu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblKblackhorncsudhedu.setBounds(455, 118, 244, 30);
		panel_3.add(lblKblackhorncsudhedu);
		
		JLabel lblJerrieJones = new JLabel("Jerrie Jones");
		lblJerrieJones.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblJerrieJones.setBounds(455, 236, 158, 30);
		panel_3.add(lblJerrieJones);
		
		JLabel lblAssistantDirectorToro = new JLabel("Assistant Director Toro GuardianToro Guardian Scholars");
		lblAssistantDirectorToro.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAssistantDirectorToro.setBounds(455, 263, 447, 30);
		panel_3.add(lblAssistantDirectorToro);
		
		JLabel lblJjonescsudhedu = new JLabel("jjones271@csudh.edu");
		lblJjonescsudhedu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				//Calender cal = new Calender();
				//cal.setVisible(true);
			}
		});
		lblJjonescsudhedu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblJjonescsudhedu.setHorizontalAlignment(SwingConstants.LEFT);
		lblJjonescsudhedu.setForeground(Color.BLUE);
		lblJjonescsudhedu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblJjonescsudhedu.setBounds(455, 285, 244, 30);
		panel_3.add(lblJjonescsudhedu);
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBackground(new Color(102, 0, 0));
		panel_4.setBounds(40, 91, 205, 37);
		panel_3.add(panel_4);
	
		
	//	***************************************8	
		JLabel label_1 = new JLabel("schedule an appointment");
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
		label_1.setBounds(0, 0, 205, 37);
		panel_4.add(label_1);
	
		
	//	****************************************************	
		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBackground(new Color(102, 0, 0));
		panel_5.setBounds(40, 256, 205, 37);
		panel_3.add(panel_5);
		
		JLabel label_2 = new JLabel("schedule an appointment");
		label_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_2.setBounds(0, 0, 205, 37);
		panel_5.add(label_2);
		
		JPanel panel_6 = new JPanel();
		panel_6.setLayout(null);
		panel_6.setBackground(new Color(102, 0, 0));
		panel_6.setBounds(50, 404, 205, 37);
		panel_3.add(panel_6);
		
		JLabel label_3 = new JLabel("schedule an appointment");
		label_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e)
			{
				dispose();
				MainApp tt = new MainApp();
				tt.setVisible(true);
			}
		});
		label_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_3.setBounds(0, 0, 205, 37);
		panel_6.add(label_3);
		
		JPanel panel_7 = new JPanel();
		panel_7.setLayout(null);
		panel_7.setBackground(new Color(102, 0, 0));
		panel_7.setBounds(448, 315, 205, 37);
		panel_3.add(panel_7);
		
		JLabel label_4 = new JLabel("schedule an appointment");
		label_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e)
			{
				dispose();
				MainApp yy = new MainApp();
				yy.setVisible(true);
			}
		});
		label_4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setForeground(Color.WHITE);
		label_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_4.setBounds(0, 0, 205, 37);
		panel_7.add(label_4);
		
		JPanel panel_8 = new JPanel();
		panel_8.setLayout(null);
		panel_8.setBackground(new Color(102, 0, 0));
		panel_8.setBounds(448, 159, 205, 37);
		panel_3.add(panel_8);
		
		JLabel label_5 = new JLabel("schedule an appointment");
		label_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				dispose();
				MainApp gg = new MainApp();
				gg.setVisible(true);
			}
		});
		label_5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setForeground(Color.WHITE);
		label_5.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_5.setBounds(0, 0, 205, 37);
		panel_8.add(label_5);
		
		
	}
}
