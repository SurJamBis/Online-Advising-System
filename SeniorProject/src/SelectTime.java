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

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.*;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class SelectTime implements ActionListener {
    public static String clickedButton="";
    java.sql.PreparedStatement pst = null;
    private JButton closeButton;
    private JFrame frame = new JFrame("Course pages");
    // Make JPanels
    private JPanel panelLabel = new JPanel(new BorderLayout());
    private JPanel buttonGrid = new JPanel(new GridLayout(0, 3,5,5));//3,3 is hgap and vGap
    private JLabel label1 = new JLabel("Available Time Slots");
   // private final static Set<String> timegap1= new HashSet<>();
    private final static ArrayList<String> timegap1 = new ArrayList<String>();
    private static ArrayList<String> timehasmeeting = new ArrayList<String>();
    private final static ArrayList<String> StudentList = new ArrayList<String>();
     

    /**
     * @wbp.parser.entryPoint
     */
    public SelectTime() {
    	
        frame.setBounds(new Rectangle(380, 230, 20, 20));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(1100, 600));
        //frame.setLocation(450,150);
        frame.getContentPane().add(createMainPanel());
       frame.setUndecorated(true);
        frame.pack();
        //frame.setLocationByPlatform(true);
        frame.setVisible(true);
        
        
        
       
    }
    public static void arrayList()
    {
    	timegap1.clear();

    	try
        {
        	Class.forName("com.mysql.cj.jdbc.Driver");
        	Connection con = DriverManager.getConnection(
            		"jdbc:mysql://127.0.0.1:3306/onlinesystem?serverTimezone=UTC", "root", "toor");
            Statement st = con.createStatement();
        	ResultSet rs = st.executeQuery("SELECT slot FROM onlinesystem.meeting where id<13");
        	while(rs.next())
        	{
        		timegap1.add(rs.getString(1));
               	
        	}
        }
    	
    	
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex);
        }
    	//JOptionPane.showMessageDialog(null, timegap1);
    	 
  
		try
        {
			
        	Class.forName("com.mysql.cj.jdbc.Driver");
        	Connection con = DriverManager.getConnection(
            		"jdbc:mysql://127.0.0.1:3306/onlinesystem?serverTimezone=UTC", "root", "toor");
            Statement st = con.createStatement();
        	ResultSet rs = st.executeQuery("SELECT meeting.slot "
        			+ "FROM onlinesystem.advisor"
        			+ " inner join meeting_has_advisor on meeting_has_advisor.advisor_id = advisor.id "
        			+ "inner join meeting on meeting.id = meeting_has_advisor.meeting_id "
        	+ "where onlinesystem.advisor.username in "
        	+"(SELECT onlinesystem.advisor.username FROM onlinesystem.advisor "
         		+ "where onlinesystem.advisor.id in ( \"" + StudentAdvisors.idpass  + "\"))"); 
        	
        	
        	//+ "\""+ StudentAdvisors.idpass + "\")");
        	
        	
        	
        //	Iterator itr = timegap1.iterator();
        	
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
        if(timegap1.size()==0)
        {
            JOptionPane.showMessageDialog(null,"You don't have any appointment set yet!");
        }
        // add Buttons
        Iterator<String> iterOnAL= timegap1.iterator();
        while(iterOnAL.hasNext())
        {
            JButton button = new JButton(iterOnAL.next().toString());
            button.setPreferredSize(new Dimension(10, 10));
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
                new SelectTime();
                
            }
        };
        SwingUtilities.invokeLater(runnable);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        clickedButton=button.getText();
       
      //  int y = TrioAdvisors.va;
    //    JOptionPane.showMessageDialog(null,y);
      // JOptionPane.showMessageDialog(null,clickedButton);
     //   JOptionPane.showMessageDialog(null,assignmentsAL.get(0)+ "  "+assignmentsAL.get(1));
       boolean isBooked=false;
        for(int i=0; i <timehasmeeting.size();i++)
        {
        	//JOptionPane.showMessageDialog(null,i);
        	if(timehasmeeting.get(i).equals(clickedButton))
        	{
        		JOptionPane.showMessageDialog(null,"This date is already Booked");
        		isBooked=true;
        		break;
           	}     	
        }
      //  new ViewAssignmentsTeacher().setVisible(true);
        if(isBooked==false)
        {

        	int result = JOptionPane.showConfirmDialog(frame,"Are you sure you want to schedule an appointment?", "Swing Tester",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE);
                 if(result == JOptionPane.YES_OPTION){
                	// JOptionPane.showMessageDialog(null,"yes");
               // 	 JOptionPane.showMessageDialog(null, clickedButton);
                //	 JOptionPane.showMessageDialog(null, CalenderPage.datePass);
                	  
                	 try
                     {
                     	Class.forName("com.mysql.cj.jdbc.Driver");
                     	Connection con = DriverManager.getConnection(
                         		"jdbc:mysql://127.0.0.1:3306/onlinesystem?serverTimezone=UTC", "root", "toor");
                         Statement st = con.createStatement();
                         ResultSet rs = st.executeQuery("select student_ID from onlinesystem.meeting_has_advisor "
                         		+ "where onlinesystem.meeting_has_advisor.student_ID in "

                         		+"(SELECT ID FROM onlinesystem.student "
        		      	           		+ "where onlinesystem.student.Username in ( \"" + loginPage.textusername1.getText()  + "\"))"); 
                        
                         while(rs.next())
                     	{
                     		StudentList.add(rs.getString(1));
             	
                     	}
                     }
        
                     catch(Exception ex)
                     {
                         JOptionPane.showMessageDialog(null, ex);
                     }
               
                	
                	if(StudentList.size()==0)
                	{
                	 
                	 try
			      		{
			        		 
			      			 Connection con = ConnectionProvider.getCon();
			      	            Statement st = con.createStatement();
  
      	           	  
      	            String sttt =("INSERT INTO onlinesystem.meeting_has_advisor (meeting_id, advisor_id,student_ID) \r\n"
			      	           + "VALUES "
			      	           + "((SELECT id  FROM onlinesystem.meeting where "
			      	           + "(onlinesystem.meeting.Date in (\"" + CalenderPage.datePass  + "\") and meeting.slot in (\""+  clickedButton + "\") )),"
			      	   //        + "\""+ StudentAdvisors.idpass + "\")");
	      	           
      	           	  
      	           	+ "\""+ StudentAdvisors.idpass + "\",(SELECT ID FROM onlinesystem.student "
  	           		+ "where onlinesystem.student.Username in ( \"" + loginPage.textusername1.getText()+ "\")))");

      	           	pst= con.prepareStatement(sttt);

					  pst.executeUpdate();
					  
					  
					  String stt =("INSERT INTO onlinesystem.student_has_advisor (student_ID, advisor_id) \r\n"
			      	           + "VALUES  ((SELECT ID FROM onlinesystem.student "
			      	           		+ "where onlinesystem.student.Username in ( \"" + loginPage.textusername1.getText()+ "\")),"
			      	           
			      	           	+ "\""+ StudentAdvisors.idpass + "\")");

     	           	pst= con.prepareStatement(stt);

					  pst.executeUpdate();	      	           	    
					  JOptionPane.showMessageDialog(null, "Appointment set on "+clickedButton);
					 
				}
			        	 
                	 catch (Exception ex)
		        {
		           JOptionPane.showMessageDialog(null, "You already have an Appointment");
		       
		        }
              }
                	
                	else
                		  JOptionPane.showMessageDialog(null, "You already have an Appointment");
             // label.setText("You selected: Yes");
          // }else if (result == JOptionPane.NO_OPTION){
            //  label.setText("You selected: No");
           }else {
            //  label.setText("None selected");
          	 JOptionPane.showMessageDialog(null,"No");
           }
  	
           
      	           
        	
        }
        else if(isBooked==true)
        {
        	JOptionPane.showMessageDialog(null,"This is booked");
        }
         	
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