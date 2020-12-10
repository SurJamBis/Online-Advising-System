import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Cursor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollBar;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Classses extends JFrame {

	private JPanel contentPane;
 
	private JTable table;
 
	private JTable table_3;
	private JTable table_4;
	private JTable table_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Classses frame = new Classses();
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
	public Classses() {
		
		
		
		
		
		
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 200, 1000, 700);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setUndecorated(true);
		
		JPanel panel_1 = new JPanel();
		panel_1.setForeground(new Color(255, 255, 255));
		panel_1.setBackground(new Color(102, 102, 102));
		panel_1.setBounds(50, 44, 703, 42);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblListOfClassess = new JLabel("Classes Detail");
		lblListOfClassess.setBounds(10, 0, 503, 42);
		panel_1.add(lblListOfClassess);
		lblListOfClassess.setForeground(new Color(255, 255, 255));
		lblListOfClassess.setHorizontalAlignment(SwingConstants.CENTER);
		lblListOfClassess.setFont(new Font("Tahoma", Font.BOLD, 25));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(new Color(255, 255, 255));
		scrollPane.setToolTipText("");
		scrollPane.setBounds(50, 213, 384, 157);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		try
		{
			 Connection con = ConnectionProvider.getCon();
	            Statement st = con.createStatement();
	           
	           ResultSet rs;
	           
	           rs = st.executeQuery("select coursrs.Subject,coursrs.CRN,coursrs.Title ,"
	           		+ "coursrs_has_student.ACTION FROM onlinesystem.student inner join coursrs_has_student on "
	           		+ "student_ID = student.ID inner join coursrs on "
	           		+ "coursrs.ID = coursrs_has_student.coursrs_ID where ( coursrs_has_student.ACTION IN(\"T\") AND "
	         //  	+ " student.Username in (\"jam\"))");
	          +  " student.Username in (\"" + loginPage.textusername1.getText()  + "\"))");
	           
	           table.setModel(DbUtils.resultSetToTableModel(rs));
	           
	       
		}
		
		catch (Exception ex)
		{
			  JOptionPane.showMessageDialog(null, ex);
		}
        
		/////////////////////////////////////////////////////////
		JScrollPane scrollPane_1 = new JScrollPane();
        scrollPane_1.setBackground(new Color(255, 255, 255));
        scrollPane_1.setBounds(499, 213, 349, 157);
        contentPane.add(scrollPane_1);
        
        table_3 = new JTable();
        scrollPane_1.setViewportView(table_3);
        try
		{
			 Connection con = ConnectionProvider.getCon();
	            Statement st = con.createStatement();
	           
	           ResultSet rs;
	           
	         /*  rs = st.executeQuery("select coursrs.Subject,coursrs.CRN,coursrs.Title ,"
	           		+ "coursrs_has_student.ACTION FROM onlinesystem.student inner join coursrs_has_student on "
	           		+ "student_ID = student.ID inner join coursrs on "
	           		+ "coursrs.ID = coursrs_has_student.coursrs_ID where ( coursrs_has_student.ACTION IN(\"NP\") AND "
	           		+ " student.Username in (\"jam\"))");
	          // + " student.Username in (\"" + loginPage.textusername1.getText()  + "\"))");
	           */
	           
	           rs = st.executeQuery("select coursrs.Subject,coursrs.CRN,coursrs.Title FROM coursrs  where (coursrs.Div in (\"UCR\") or coursrs.Div in (\"URC\"))"); 
	           table_3.setModel(DbUtils.resultSetToTableModel(rs));
	           
	           
		}
		
		catch (Exception ex)
		{
			  JOptionPane.showMessageDialog(null, ex);
		}
        
        ////////////////////////////////////////////////////////////////
        JScrollPane scrollPane_2 = new JScrollPane();
        scrollPane_2.setBounds(50, 479, 384, 173);
        contentPane.add(scrollPane_2);
        
        table_4 = new JTable();
        scrollPane_2.setViewportView(table_4);
        
        try
		{
			 Connection con = ConnectionProvider.getCon();
	            Statement st = con.createStatement();
	           
	           ResultSet rs;
	           
	           rs = st.executeQuery("select coursrs.Subject,coursrs.CRN,coursrs.Title ,"
	           		+ "coursrs_has_student.ACTION FROM onlinesystem.student inner join coursrs_has_student on "
	           		+ "student_ID = student.ID inner join coursrs on "
	           		+ "coursrs.ID = coursrs_has_student.coursrs_ID where ( coursrs_has_student.ACTION IN(\"P\") AND "
	           //		+ " student.Username in (\"jam\"))");
	           + " student.Username in (\"" + loginPage.textusername1.getText()  + "\"))");
	           
	           table_4.setModel(DbUtils.resultSetToTableModel(rs));
	           
	          
		}
		
		catch (Exception ex)
		{
			  JOptionPane.showMessageDialog(null, ex);
		}
        
        ////////////////////////////////////////////////////////////////////////
        JScrollPane scrollPane_3 = new JScrollPane();
        scrollPane_3.setBounds(499, 479, 349, 173);
        contentPane.add(scrollPane_3);
        
        table_5 = new JTable();
        scrollPane_3.setViewportView(table_5);
        
        
        try
		{
			 Connection con = ConnectionProvider.getCon();
	            Statement st = con.createStatement();
	           
	           ResultSet rs;
	           rs = st.executeQuery("select coursrs.Subject,coursrs.CRN,coursrs.Title FROM coursrs  where (coursrs.Div in (\"UEL\"))"); 
	        //   table_3.setModel(DbUtils.resultSetToTableModel(rs));
	           
//	           rs = st.executeQuery("select coursrs.Subject,coursrs.CRN,coursrs.Title ,"
//	           		+ "coursrs_has_student.ACTION FROM onlinesystem.student inner join coursrs_has_student on "
//	           		+ "student_ID = student.ID inner join coursrs on "
//	           		+ "coursrs.ID = coursrs_has_student.coursrs_ID where ( coursrs_has_student.ACTION IN(\"NP\") AND "
//	           		+ " student.Username in (\"jam\"))");
//	       //    + " student.Username in (\"" + loginPage.textusername1.getText()  + "\"))");
//	           
	           table_5.setModel(DbUtils.resultSetToTableModel(rs));
	           
	           JPanel panel_2 = new JPanel();
	           panel_2.setBackground(new Color(102, 102, 102));
	           panel_2.setBounds(50, 141, 182, 30);
	           contentPane.add(panel_2);
	           panel_2.setLayout(null);
	           
	           JLabel lblNewLabel = new JLabel("Completed Classes");
	           lblNewLabel.setForeground(new Color(255, 255, 255));
	           lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
	           lblNewLabel.setBounds(10, 0, 162, 30);
	           panel_2.add(lblNewLabel);
	           
	           JPanel panel_3 = new JPanel();
	           panel_3.setLayout(null);
	           panel_3.setBackground(new Color(102, 102, 102));
	           panel_3.setBounds(499, 144, 328, 30);
	           contentPane.add(panel_3);
	           
	           JLabel lblRequiredClasses = new JLabel("Upper Division Core Requirement Course");
	           lblRequiredClasses.setForeground(Color.WHITE);
	           lblRequiredClasses.setFont(new Font("Tahoma", Font.BOLD, 15));
	           lblRequiredClasses.setBounds(10, 0, 817, 30);
	           panel_3.add(lblRequiredClasses);
	           
	           JPanel panel_4 = new JPanel();
	           panel_4.setLayout(null);
	           panel_4.setBackground(new Color(102, 102, 102));
	           panel_4.setBounds(50, 405, 182, 30);
	           contentPane.add(panel_4);
	           
	           JLabel lblClassesInProgress = new JLabel("Classes In Progress");
	           lblClassesInProgress.setForeground(Color.WHITE);
	           lblClassesInProgress.setFont(new Font("Tahoma", Font.BOLD, 15));
	           lblClassesInProgress.setBounds(10, 0, 162, 30);
	           panel_4.add(lblClassesInProgress);
	           
	           JPanel panel_5 = new JPanel();
	           panel_5.setLayout(null);
	           panel_5.setBackground(new Color(102, 102, 102));
	           panel_5.setBounds(499, 405, 268, 30);
	           contentPane.add(panel_5);
	           
	           JLabel label_1 = new JLabel("Upper Division Electives Courses");
	           label_1.setForeground(Color.WHITE);
	           label_1.setFont(new Font("Tahoma", Font.BOLD, 15));
	           label_1.setBounds(10, 0, 257, 30);
	           panel_5.add(label_1);
	           
	           JLabel lblNewLabel_1 = new JLabel("");
	           lblNewLabel_1.setBounds(814, 44, 46, 42);
	           contentPane.add(lblNewLabel_1);
	           lblNewLabel_1.setForeground(new Color(255, 255, 255));
	           lblNewLabel_1.addMouseListener(new MouseAdapter() {
	           	@Override
	           	public void mouseClicked(MouseEvent e) 
	           	{
	           		dispose();
	           	}
	           });
	           lblNewLabel_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	           lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
	           lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\jamun\\eclipse-workspace\\HostelManagementSystem\\images\\cancel.png"));
	           
	          
		}
		
		catch (Exception ex)
		{
			  JOptionPane.showMessageDialog(null, ex);
		}
        }	
	}

