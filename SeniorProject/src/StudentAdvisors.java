import java.awt.BorderLayout;
import java.awt.*;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.swing.*;

public class StudentAdvisors implements ActionListener {
    public static String clickedButton="";
    java.sql.PreparedStatement pst = null;
    public static String idpass;
    private JButton closeButton;
    private JFrame frame = new JFrame("Course pages");
    // Make JPanels
    private JPanel panelLabel = new JPanel(new BorderLayout());
    private JPanel buttonGrid = new JPanel(new GridLayout(0, 3,5,5));//3,3 is hgap and vGap
    private JLabel label1 = new JLabel("Available Advisors");
   // private final static Set<String> AdvisorDetails= new HashSet<>();
    private final static ArrayList<String> AdvisorDetails = new ArrayList<String>();
    private static ArrayList<String> timehasmeeting = new ArrayList<String>();
  

    /**
     * @wbp.parser.entryPoint
     */
    public StudentAdvisors() {
    	
        frame.setBounds(new Rectangle(400, 230, 20, 20));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(1000, 600));
        //frame.setLocation(450,150);
        frame.getContentPane().add(createMainPanel());
       frame.setUndecorated(true);
        frame.pack();
        //frame.setLocationByPlatform(true);
        frame.setVisible(true);
        
        
        
       
    }
    public static void arrayList()
    {
    	AdvisorDetails.clear();

    	try
        {
        	Class.forName("com.mysql.cj.jdbc.Driver");
        	Connection con = DriverManager.getConnection(
            		"jdbc:mysql://127.0.0.1:3306/onlinesystem?serverTimezone=UTC", "root", "toor");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT concat(advisor.First_Name, advisor.Last_Name) FROM onlinesystem.advisor where id<12");
      //  	ResultSet rs = st.executeQuery("SELECT concat(advisor.First_Name, advisor.Last_Name,'\n', advisor.Email,advisor.Phone_No) FROM onlinesystem.advisor where id<12");
        	while(rs.next())
        	{
        		AdvisorDetails.add(rs.getString(1));
        	 
        		
               	
        	}
        }
    	
    	

    	
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex);
        }
   // 	JOptionPane.showMessageDialog(null, AdvisorDetails);
    	 
  
		try
        {
			
        	Class.forName("com.mysql.cj.jdbc.Driver");
        	Connection con = DriverManager.getConnection(
            		"jdbc:mysql://127.0.0.1:3306/onlinesystem?serverTimezone=UTC", "root", "toor");
            Statement st = con.createStatement();
        	ResultSet rs = st.executeQuery("SELECT meeting.slot "
        			+ "FROM onlinesystem.advisor inner join meeting_has_advisor on meeting_has_advisor.advisor_id "
        			+ "= advisor.id inner join meeting on meeting.id = meeting_has_advisor.meeting_id "
        			+ "where (advisor.username  in (\"ken\"));");
        	
        //	Iterator itr = AdvisorDetails.iterator();
        	
        	while(rs.next())
        	{
        	//	Date.add(rs.getString(1));
        		timehasmeeting.add(rs.getString(1));
        	//	Month_Year.add(rs.getString(2));       		
        	}
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex);
        }
		
    }
  
    private JPanel createMainPanel() {
    	 arrayList();
        JPanel panel = new JPanel();
        panel.setBackground(new Color(102, 0, 0));
        panel.setLayout(new BorderLayout());
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        label1.setForeground(new Color(255, 255, 255));
        label1.setBackground(new Color(102, 0, 0));
        label1.setFont(new Font("Stencil", Font.BOLD, 28));

        
        panelLabel.add(label1,BorderLayout.CENTER);
        panelLabel.setBackground(new Color(102, 0, 0));
        
        closeButton =new JButton("Close");
        closeButton.setFont(new Font("Tahoma", Font.BOLD, 14));
        closeButton.setForeground(new Color(255, 255, 255));
        closeButton.setBackground(new Color(102, 0, 0));
        closeButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
           frame.setVisible(false);
           
         }
      });
        
        panelLabel.add(closeButton,BorderLayout.EAST);
        panel.add(panelLabel, BorderLayout.NORTH);
        if(AdvisorDetails.size()==0)
        {
            JOptionPane.showMessageDialog(null,"You don't have any appointment set yet!");
        }
        // add Buttons
        Iterator<String> iterOnAL= AdvisorDetails.iterator();
        while(iterOnAL.hasNext())
        {
            JButton button = new JButton(iterOnAL.next().toString());
            button.setPreferredSize(new Dimension(1, 1));
            button.addActionListener(this);
            button.setBackground(Color.LIGHT_GRAY);
            button.setFont(new Font("Verdana",Font.PLAIN,20));
            buttonGrid.add(button);
            buttonGrid.setBackground(Color.WHITE);
        }
        buttonGrid.setBackground(new Color(102, 0, 0));
      
        panel.add(buttonGrid, BorderLayout.CENTER);

        // Add JText Area to bottom JPanel
        //String num = "value";
        return panel;
    }

    public static void main(String args[])
    {
    	
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                new StudentAdvisors();
                
            }
        };
        SwingUtilities.invokeLater(runnable);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        clickedButton=button.getText();
        
        try
        {
        	Class.forName("com.mysql.cj.jdbc.Driver");
        	Connection con = DriverManager.getConnection(
            		"jdbc:mysql://127.0.0.1:3306/onlinesystem?serverTimezone=UTC", "root", "toor");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT id FROM onlinesystem.advisor "
            		+ "where concat(advisor.First_Name, advisor.Last_Name) "
            		+ "in (\"" + clickedButton  + "\")");
      //  	ResultSet rs = st.executeQuery("SELECT concat(advisor.First_Name, advisor.Last_Name,'\n', advisor.Email,advisor.Phone_No) FROM onlinesystem.advisor where id<12");
        	while(rs.next())
        	{
        		idpass = rs.getString(1);
        	 
        		
               	
        	}
        	
     //   	 JOptionPane.showMessageDialog(null,idpass);
        }
    	
    	

    	
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex);
        }
        
       // JOptionPane.showMessageDialog(null,clickedButton);
    
        TrioAdvisors cla = new TrioAdvisors();
		cla.setVisible(true);
		 				
    
    }
        
    
  
//	public void setVisible(boolean b) {
//		
//		// TODO Auto-generated method stub
//		
//	}       
	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}
	
}