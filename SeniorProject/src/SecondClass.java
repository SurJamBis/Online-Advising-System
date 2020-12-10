import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;

public class SecondClass extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SecondClass frame = new SecondClass();
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
	public SecondClass() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 280, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 984, 561);
		contentPane.add(scrollPane);
		
		JLabel lblNewLabel = new JLabel("<html>\r\n<h1>Dr. Mohsen Beheshti</h1><p>Email: mbeheshti@csudh.edu</p><p>Phone: 310-243-3398</p><p>Office: NSM A-132</p><br><br>\r\n\r\n<h1>Dr. Amlan Chatterjee</h1><p>Email: achatterjee@csudh.edu</p><p>Phone: 310-243-3240</p><p>Office: NSM A-133</p><br><br>\r\n\r\n<h1>Dr. Han</h1><p>Email: jhan@csudh.edu</p><p>Phone: 310-243-2624</p><p>Office: NSM A-133</p><br><br>\r\n\r\n<h1>Dr. Brad Hollister</h1><p>Email: bhollister@csudh.edu</p><p>Phone: 310-243-1023</p><p>Office: NSM B-218</p><br><br>\r\n\r\n<h1>Dr. Alireza Izaddoost</h1><p>Email: aizaddoost@csudh.edu</p><p>Phone: 310-243-2873</p><p>Office: NSM E-115</p><br><br>\r\n\r\n<h1>Dr. Khondaker Salehin</h1><p>Email: ksalehin@csudh.edu</p><p>Phone: 310-243-3882</p><p>Office: NSM E-107</p><br><br>\r\n\r\n<h1>Dr. Marek Suchenek</h1><p>Email: suchenek@csudh.edu</p><p>Phone: 310-243-3398</p><p>Office: NSM A-131</p><br><br>\r\n\r\n<h1>Dr. Liudong Zuo</h1><p>Email: lzuo@csudh.edu</p><p>Phone: 310-243-3386</p><p>Office: NSM E-109</p><br><br>\r\n\r\n<h1>Dr. Bin Tang</h1><p>Email: btang@csudh.edu</p><p>Phone: 310-243-2510</p><p>Office: NSM E-117</p>\r\n\r\n\r\n</html>\r\n\r\n");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		scrollPane.setViewportView(lblNewLabel);
		JButton but = new JButton();
	}

}
