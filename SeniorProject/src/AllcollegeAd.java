import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JButton;
import javax.swing.JScrollBar;

public class AllcollegeAd extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
		
			public void run() {
				try {
					AllcollegeAd frame = new AllcollegeAd();
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
	public AllcollegeAd() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 280, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 984, 33);
		panel.setLayout(null);
		panel.setBackground(Color.WHITE);
		contentPane.add(panel);
		
		JLabel lblCollegeAdvisors = new JLabel("MAJOR ADVISORS - ALL");
		lblCollegeAdvisors.setForeground(Color.BLACK);
		lblCollegeAdvisors.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblCollegeAdvisors.setBounds(10, 0, 679, 33);
		panel.add(lblCollegeAdvisors);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(727, 0, 45, 33);
		panel.add(panel_1);
		
		JLabel label_1 = new JLabel("");
		label_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				setVisible(false);
			}
		});
		label_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_1.setIcon(new ImageIcon("C:\\Users\\jamun\\eclipse-workspace\\SeniorProject\\image\\pbackicon.png"));
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_1.setBounds(0, 0, 45, 33);
		panel_1.add(label_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(10, 33, 431, 4);
		panel_3.setBackground(Color.BLACK);
		contentPane.add(panel_3);
		
	}
}

