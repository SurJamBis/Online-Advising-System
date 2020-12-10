
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
import javax.swing.JToggleButton;
import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JMenuItem;
import java.awt.Choice;
import java.awt.ScrollPane;
import java.awt.Point;
import java.awt.Scrollbar;
import java.awt.List;
import javax.swing.JTextArea;
import javax.swing.DefaultComboBoxModel;
import java.awt.SystemColor;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;
import javax.swing.UIManager;

public class FacultyPage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FacultyPage frame = new FacultyPage();
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
	public FacultyPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 280, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setUndecorated(true);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(102, 0, 0));
		panel.setLayout(null);
		setUndecorated(true);
		
		JLabel lblNewLabel = new JLabel("UNIVERSITY ACADEMIC ADVISORS");
		lblNewLabel.setFont(new Font("Serif", Font.PLAIN, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(26, 0, 913, 44);
		panel.add(lblNewLabel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(153, 153, 153));
		panel_2.setLayout(null);
		
		JLabel lblCollegeAdvisors = new JLabel("College Advisors");
		lblCollegeAdvisors.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblCollegeAdvisors.setHorizontalAlignment(SwingConstants.LEFT);
		lblCollegeAdvisors.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblCollegeAdvisors.setBounds(10, 0, 523, 44);
		panel_2.add(lblCollegeAdvisors);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(153, 153, 153));
		panel_3.setLayout(null);
		
		JLabel lblEducationalOpportunityProgrameop = new JLabel("Educational Opportunity Program (EOP) Academic Advisors");
		lblEducationalOpportunityProgrameop.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblEducationalOpportunityProgrameop.setHorizontalAlignment(SwingConstants.LEFT);
		lblEducationalOpportunityProgrameop.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblEducationalOpportunityProgrameop.setBounds(10, 0, 771, 44);
		panel_3.add(lblEducationalOpportunityProgrameop);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(153, 153, 153));
		panel_4.setLayout(null);
		
		JLabel lblEncounterToExcellence = new JLabel("Encounter to Excellence Academic (ETE) Advisors");
		lblEncounterToExcellence.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e)
			{
				dispose();
				SecondClass ete = new SecondClass();
				ete.setVisible(true);
			}
		});
		lblEncounterToExcellence.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblEncounterToExcellence.setHorizontalAlignment(SwingConstants.LEFT);
		lblEncounterToExcellence.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblEncounterToExcellence.setBounds(10, 0, 692, 44);
		panel_4.add(lblEncounterToExcellence);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(153, 153, 153));
		panel_5.setLayout(null);
		
		JLabel lblTrioAdvisors = new JLabel("TRIO Advisors");
		lblTrioAdvisors.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{ 
				dispose();
				TrioAdvisors tri = new TrioAdvisors();
				tri.setVisible(true);
			}
		});
		lblTrioAdvisors.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblTrioAdvisors.setHorizontalAlignment(SwingConstants.LEFT);
		lblTrioAdvisors.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblTrioAdvisors.setBounds(10, 0, 523, 44);
		panel_5.add(lblTrioAdvisors);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(153, 153, 153));
		panel_6.setLayout(null);
		
		JLabel lblMulticulturalCentersAdvisors = new JLabel("Multicultural Centers  Advisors");
		lblMulticulturalCentersAdvisors.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e)
			{
				dispose();
				MulticulturalAd multiad = new MulticulturalAd();
				multiad.setVisible(true);
			}
		});
		lblMulticulturalCentersAdvisors.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblMulticulturalCentersAdvisors.setHorizontalAlignment(SwingConstants.LEFT);
		lblMulticulturalCentersAdvisors.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblMulticulturalCentersAdvisors.setBounds(10, 0, 523, 44);
		panel_6.add(lblMulticulturalCentersAdvisors);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 984, Short.MAX_VALUE)
					.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(panel_3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(panel_4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(panel_5, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(panel_6, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
					.addGap(103)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
					.addGap(27)
					.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
					.addGap(28)
					.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
					.addGap(24)
					.addComponent(panel_5, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
					.addGap(28)
					.addComponent(panel_6, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
					.addGap(116))
		);
		
		JLabel lblNewLabel_3 = new JLabel("X");
		lblNewLabel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				setVisible(false);
			}
		});
		lblNewLabel_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(949, 11, 25, 22);
		panel.add(lblNewLabel_3);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(new Color(102, 0, 0));
		panel_7.setBounds(949, 11, 25, 22);
		panel.add(panel_7);
		panel_7.setLayout(null);
		
		JLabel label_4 = new JLabel("");
		label_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e)
			{
				dispose();
				MulticulturalAd multiad = new MulticulturalAd();
				multiad.setVisible(true);
			}
		});
		label_4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_4.setIcon(new ImageIcon("C:\\Users\\jamun\\eclipse-workspace\\SeniorProject\\image\\iconfinder-48.png"));
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setBounds(905, 0, 59, 44);
		panel_6.add(label_4);
		
		JLabel label_3 = new JLabel("");
		label_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				//dispose();
				//MainApp tri = new MainApp();
				//tri.setVisible(true);
			}
		});
		label_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_3.setIcon(new ImageIcon("C:\\Users\\jamun\\eclipse-workspace\\SeniorProject\\image\\iconfinder-48.png"));
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setBounds(905, 0, 59, 44);
		panel_5.add(label_3);
		
		JLabel label_2 = new JLabel("");
		label_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				dispose();
				StudentAdvisors ete = new StudentAdvisors();
				ete.setVisible(true);
			}
		});
		label_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_2.setIcon(new ImageIcon("C:\\Users\\jamun\\eclipse-workspace\\SeniorProject\\image\\iconfinder-48.png"));
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setBounds(905, 0, 59, 44);
		panel_4.add(label_2);
		
		JLabel label_1 = new JLabel("");
		label_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_1.setIcon(new ImageIcon("C:\\Users\\jamun\\eclipse-workspace\\SeniorProject\\image\\iconfinder-48.png"));
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(905, 0, 59, 44);
		panel_3.add(label_1);
		
		JLabel label = new JLabel("");
		label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label.setIcon(new ImageIcon("C:\\Users\\jamun\\eclipse-workspace\\SeniorProject\\image\\iconfinder-48.png"));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(905, 0, 59, 44);
		panel_2.add(label);
		contentPane.setLayout(gl_contentPane);
		
		
		JLabel lbltext = new JLabel();
	}
}
