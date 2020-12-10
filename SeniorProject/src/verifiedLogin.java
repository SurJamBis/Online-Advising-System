
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class verifiedLogin extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					verifiedLogin frame = new verifiedLogin();
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
	public verifiedLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(650, 200, 739, 383);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		//setUndecorated(true);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 731, 348);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 795, 39);
		panel_1.setBackground(new Color(102, 0, 0));
		panel.add(panel_1);
		
		JLabel lblNewLabel = new JLabel("ONE TIME PASSCODE REQUIRED");
		panel_1.add(lblNewLabel);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBackground(new Color(102, 0, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblNewLabel_1 = new JLabel("A One Time Passcode (OTP) will be delivered as an email to:");
		lblNewLabel_1.setBounds(10, 43, 407, 27);
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("It could take 10 to 15 seconds to be delivered. Upon receipt, please enter the OTP below to continue. ");
		lblNewLabel_2.setBounds(10, 106, 671, 44);
		lblNewLabel_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Username: ");
		lblNewLabel_3.setBounds(153, 161, 77, 27);
		lblNewLabel_3.setForeground(new Color(0, 0, 0));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setBounds(242, 161, 313, 27);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(153, 199, 77, 27);
		lblPassword.setForeground(new Color(0, 0, 0));
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(242, 204, 313, 27);
		panel.add(passwordField);
		
		JLabel lblAOneTime = new JLabel("A One Time Passcode:");
		lblAOneTime.setBounds(69, 250, 161, 27);
		lblAOneTime.setForeground(new Color(0, 0, 0));
		lblAOneTime.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lblAOneTime);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(242, 252, 313, 27);
		panel.add(passwordField_1);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(102, 0, 0));
		btnNewButton.setBounds(69, 304, 256, 27);
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel.add(btnNewButton);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setForeground(new Color(255, 255, 255));
		btnCancel.setBackground(new Color(102, 0, 0));
		btnCancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				setVisible(false);
			}
		});
		btnCancel.setBounds(415, 304, 256, 27);
		btnCancel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel.add(btnCancel);
	}
}
