import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Cursor;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

public class InboxPage extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InboxPage frame = new InboxPage();
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
	public InboxPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 200, 1000, 700);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	
		
		JButton button = new JButton("X");
		button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				setVisible(false);
			}
		});
		button.setFont(new Font("Tahoma", Font.BOLD, 15));
		button.setBackground(Color.LIGHT_GRAY);
		button.setBounds(1343, 0, 57, 23);
		contentPane.add(button);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(102, 0, 0));
		panel_1.setBounds(10, 58, 962, 30);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel label_1 = new JLabel("Messages!!");
		label_1.setBounds(59, 0, 140, 31);
		panel_1.add(label_1);
		label_1.setForeground(new Color(255, 255, 255));
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		
		JPanel panel = new JPanel();
		panel.setBounds(158, 169, 809, 520);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("To:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(72, 64, 57, 24);
		panel.add(lblNewLabel);
		
		JLabel lblFrom = new JLabel("From:");
		lblFrom.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblFrom.setBounds(72, 120, 57, 24);
		panel.add(lblFrom);
		
		JLabel lblSubject = new JLabel("Subject:");
		lblSubject.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSubject.setBounds(72, 186, 66, 24);
		panel.add(lblSubject);
		
		JLabel lblMessage = new JLabel("Message:");
		lblMessage.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMessage.setBounds(72, 269, 78, 24);
		panel.add(lblMessage);
		
		textField = new JTextField();
		textField.setBounds(175, 64, 396, 30);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(175, 124, 396, 30);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(175, 180, 396, 30);
		panel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(175, 257, 396, 165);
		panel.add(textField_3);
		
		JButton btnNewButton = new JButton("Send");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(468, 449, 103, 30);
		panel.add(btnNewButton);
		setUndecorated(true);
	}
}
