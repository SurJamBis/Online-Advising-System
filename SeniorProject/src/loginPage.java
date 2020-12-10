import java.awt.BorderLayout; 
import java.awt.EventQueue;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Component;


import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Cursor;
import java.awt.Dimension;

import javax.swing.SwingConstants;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import java.awt.SystemColor;
import java.awt.Toolkit;
import javax.swing.JCheckBox;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;

import javax.swing.DefaultComboBoxModel;

public class loginPage extends JFrame {

	private JPanel contentPane;
	private final JPanel panel = new JPanel();
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_6;
	private JPanel lab3;
	private JLabel labelsignin;
	private JPanel dash1;
	private JLabel user;
	private JLabel pass;
	static JTextField textusername1;
	private JPanel dash;
	private JButton btnsignin;
	static JPasswordField textpassword1;
	private JLabel lblNewLabel_2;
	private JLabel lblForgotPassword;
	private JLabel lblNewLabel_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					loginPage frame = new loginPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the frame.
	 */
	public loginPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 960, 631);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		panel.setBackground(new Color(102, 0, 0));
		panel.setBounds(0, 0, 1894, 1033);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblNewLabel_6 = new JLabel(" X");
		lblNewLabel_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				System.exit(0);
			}
		});
		lblNewLabel_6.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_6.setForeground(new Color(255, 255, 255));
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_6.setBounds(1845, -2, 39, 25);
		panel.add(lblNewLabel_6);
		
		
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(0, 0,screen.width,screen.height - 30);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		lab3 = new JPanel();
		lab3.setBounds(754, 170, 354, 386);
		panel.add(lab3);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		labelsignin = new JLabel("Sign In ");
		labelsignin.setHorizontalAlignment(SwingConstants.CENTER);
		labelsignin.setFont(new Font("Tahoma", Font.BOLD, 25));
		
		dash1 = new JPanel();
		dash1.setBackground(new Color(102, 0, 0));
		dash1.setForeground(new Color(102, 0, 0));
		
		user = new JLabel("Username:");
		user.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		pass = new JLabel("Password:");
		pass.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		textusername1 = new JTextField();
		textusername1.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 12));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Select", "Admin", "Advisor", "Student"}));
		
		
		dash = new JPanel();
		dash.setForeground(new Color(102, 0, 0));
		dash.setBackground(new Color(102, 0, 0));
		
		btnsignin = new JButton("Sign In ");
		btnsignin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnsignin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				String userName = textusername1.getText();
				String password = textpassword1.getText();
				if(comboBox.getSelectedItem().equals("Admin"))
				{
					try
					{
						Class.forName("java.sql.Driver");
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost/onlinesystem","root","toor");
						PreparedStatement st = (PreparedStatement) con.prepareStatement("select username, password from onlinesystem.admin where Username=? and password=?") ;
						st.setString(1, userName);
						st.setString(2, password);
						ResultSet rs = st.executeQuery();
						
						if(rs.next())
						{
							dispose();
							AdminPage mp = new AdminPage ();
							mp.setVisible(true);
							
							
							//JOptionPane.showConfirmDialog(null, "You have successfully logged in");
				
						}
						else
						{
							JOptionPane.showConfirmDialog(null, "Wrong username and password");
					
						}
					}
						
				catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null, ex);
				}
				}
				if(comboBox.getSelectedItem().equals("Advisor"))
					{
					try
					{
						Class.forName("java.sql.Driver");
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost/onlinesystem","root","toor");
						PreparedStatement st = (PreparedStatement) con.prepareStatement("select username, password from onlinesystem.advisor where Username=? and password=?") ;
						st.setString(1, userName);
						st.setString(2, password);
						ResultSet rs = st.executeQuery();
						
						if(rs.next())
						{
							dispose();
							AdvisorMainPage Amp = new AdvisorMainPage ();
							Amp.setVisible(true);
							
							//JOptionPane.showConfirmDialog(null, "You have successfully logged in");
				
						}
						else
						{
							JOptionPane.showConfirmDialog(null, "Wrong username and password");
					
						}
				
					}
						
				catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null, ex);
				}
			}
				if(comboBox.getSelectedItem().equals("Student"))
				{
					try
					{
						Class.forName("java.sql.Driver");
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost/onlinesystem","root","toor");
						PreparedStatement st = (PreparedStatement) con.prepareStatement("select username, password from onlinesystem.student where Username=? and password=?") ;
						st.setString(1, userName);
						st.setString(2, password);
						ResultSet rs = st.executeQuery();
						
						if(rs.next())
						{
							dispose();
							MainPage mp = new MainPage ();
							mp.setTitle("Welcome");
							mp.setVisible(true);
							
							//JOptionPane.showConfirmDialog(null, "You have successfully logged in");
				
						}
						else
						{
							JOptionPane.showConfirmDialog(null, "Wrong username and password");
					
						}
					}
						
				catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null, ex);
				}
				}
			}
		});
	
		btnsignin.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JCheckBox checxkbox = new JCheckBox("View Password");
		checxkbox.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				if(checxkbox.isSelected())
				{
					textpassword1.setEchoChar((char)0);
				}
				else
				{
					textpassword1.setEchoChar('*');
				}
			}
		});
		
		textpassword1 = new JPasswordField();
		
		lblNewLabel_2 = new JLabel("Don't Have An Account! Click Here!");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				userRegister register = new userRegister();
				register.setVisible(true);
			}
		});
		lblNewLabel_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		
		JLabel lblNewLabel_3 = new JLabel("User Type:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		lblForgotPassword = new JLabel("Forgot Password");
		lblForgotPassword.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				changePassword cp = new changePassword();
				cp.setVisible(true);
			}
		});
		lblForgotPassword.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblForgotPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblForgotPassword.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		lblNewLabel_4 = new JLabel("l");
		lblNewLabel_4.setForeground(new Color(102, 102, 102));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 18));
		GroupLayout gl_lab3 = new GroupLayout(lab3);
		gl_lab3.setHorizontalGroup(
			gl_lab3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_lab3.createSequentialGroup()
					.addContainerGap(354, Short.MAX_VALUE)
					.addComponent(lblNewLabel_1))
				.addGroup(gl_lab3.createSequentialGroup()
					.addGap(110)
					.addComponent(labelsignin, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(118, Short.MAX_VALUE))
				.addGroup(gl_lab3.createSequentialGroup()
					.addComponent(dash1, GroupLayout.PREFERRED_SIZE, 330, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(24, Short.MAX_VALUE))
				.addGroup(gl_lab3.createSequentialGroup()
					.addGroup(gl_lab3.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_lab3.createSequentialGroup()
							.addContainerGap()
							.addComponent(checxkbox))
						.addGroup(gl_lab3.createSequentialGroup()
							.addGap(20)
							.addGroup(gl_lab3.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_lab3.createSequentialGroup()
									.addComponent(user, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(textusername1, GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE))
								.addGroup(gl_lab3.createSequentialGroup()
									.addGroup(gl_lab3.createParallelGroup(Alignment.TRAILING)
										.addGroup(gl_lab3.createSequentialGroup()
											.addComponent(pass, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED))
										.addGroup(gl_lab3.createSequentialGroup()
											.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
											.addGap(10)))
									.addGroup(gl_lab3.createParallelGroup(Alignment.TRAILING)
										.addComponent(btnsignin, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)
										.addComponent(textpassword1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
										.addComponent(comboBox, 0, 200, Short.MAX_VALUE))))))
					.addGap(33))
				.addGroup(gl_lab3.createSequentialGroup()
					.addComponent(dash, GroupLayout.PREFERRED_SIZE, 330, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
				.addGroup(gl_lab3.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 203, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_4)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblForgotPassword)
					.addContainerGap(32, Short.MAX_VALUE))
		);
		gl_lab3.setVerticalGroup(
			gl_lab3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_lab3.createSequentialGroup()
					.addComponent(labelsignin, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
					.addGap(14)
					.addGroup(gl_lab3.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_1)
						.addComponent(dash1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_lab3.createParallelGroup(Alignment.BASELINE)
						.addComponent(user, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(textusername1, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
					.addGap(28)
					.addGroup(gl_lab3.createParallelGroup(Alignment.BASELINE)
						.addComponent(pass, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(textpassword1, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_lab3.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_lab3.createSequentialGroup()
							.addComponent(checxkbox)
							.addGap(18)
							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
							.addComponent(btnsignin, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_lab3.createSequentialGroup()
							.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
							.addGap(68)))
					.addGap(18)
					.addComponent(dash, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_lab3.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblForgotPassword, GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE))
					.addGap(18))
		);
		lab3.setLayout(gl_lab3);
		
		lblNewLabel = new JLabel("pic");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setForeground(new Color(102, 0, 0));
		lblNewLabel.setBackground(new Color(102, 0, 0));
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\jamun\\OneDrive\\Desktop\\loginpic.jpg"));
		lblNewLabel.setBounds(21, 23, 1851, 970);
		panel.add(lblNewLabel);
	}
		}
