import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class changePassword extends JFrame {

	private JPanel contentPane;
	private JTextField textId;
	private JPasswordField password;
	private JPasswordField confirmPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					changePassword frame = new changePassword();
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
	public changePassword() {
		setTitle(" ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(730, 190, 422, 405);
		contentPane = new JPanel();
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setUndecorated(true);
		
		JLabel lblNewLabel = new JLabel("Username:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(66, 103, 80, 25);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewPassword = new JLabel("New Password:");
		lblNewPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewPassword.setBounds(39, 175, 107, 25);
		contentPane.add(lblNewPassword);
		
		JLabel lblCofirmPassword = new JLabel("Cofirm Password:");
		lblCofirmPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCofirmPassword.setBounds(22, 251, 122, 25);
		contentPane.add(lblCofirmPassword);
		
		textId = new JTextField();
		textId.setBounds(178, 101, 220, 32);
		contentPane.add(textId);
		textId.setColumns(10);
		
		password = new JPasswordField();
		password.setBounds(178, 175, 220, 32);
		contentPane.add(password);
		
		confirmPassword = new JPasswordField();
		confirmPassword.setBounds(176, 244, 220, 32);
		contentPane.add(confirmPassword);
		
		JLabel label1 = new JLabel("");
		label1.setBounds(188, 144, 208, 20);
		contentPane.add(label1);
		
		JLabel label2 = new JLabel("");
		label2.setBounds(178, 213, 208, 20);
		contentPane.add(label2);
		
		JLabel label3 = new JLabel("");
		label3.setBounds(178, 283, 208, 20);
		contentPane.add(label3);
		
		JButton changeBtn = new JButton("Change");
		changeBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				String uid, newPass, cnfpass;
				uid = textId.getText();
				newPass = password.getText();
				cnfpass = confirmPassword.getText();
				
				String sql = "select * from onlinesystem.student where Username='"+uid+"'";
				String sqll = "update onlinesystem.student set password='"+newPass+"' where Username='"+uid+"'";
				
				try
				{
					 Connection con = ConnectionProvider.getCon();
			         Statement st = con.createStatement();
			         ResultSet rs;
			         
			         rs = st.executeQuery(sql);
			         if(rs.next())
			         {
			        	 if(newPass.equals(cnfpass))
			        	 {
			        		 label3.setText("");
			        		 st.executeUpdate(sqll);
			        		 JOptionPane.showMessageDialog(rootPane, "Password Change Successfully");
			        		 textId.setText("");
			        		 password.setText("");
			        		 confirmPassword.setText("");
			        		 
			        	 }
			        	 else
			        	 {
			        		 label3.setText("Confirm Password Does not Match");
			        	 	 confirmPassword.requestFocus();
			        	 }
			        	 
			         }
			         else
			         {
			        	label1.setText("Invalid Username");
			        	textId.requestFocus();
			         }
					
					
				}
				catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null, ex);
				}
				
				
			}
		});
		changeBtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		changeBtn.setBounds(22, 338, 122, 32);
		contentPane.add(changeBtn);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				dispose();
			}
		});
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCancel.setBounds(238, 338, 122, 32);
		contentPane.add(btnCancel);
		
		JLabel lblNewLabel_1 = new JLabel("Change Password");
		lblNewLabel_1.setFont(new Font("Stencil", Font.BOLD, 23));
		lblNewLabel_1.setBounds(22, 25, 352, 25);
		contentPane.add(lblNewLabel_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(102, 0, 0));
		panel.setBounds(22, 49, 374, 10);
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(102, 0, 0));
		panel_1.setBounds(22, 314, 374, 10);
		contentPane.add(panel_1);
	}
}
