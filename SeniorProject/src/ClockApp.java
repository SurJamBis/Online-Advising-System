/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jamuna
 */
public class ClockApp
{
   
	public static void main(String[] args) {

		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				clock clock = new clock();
				new DigitalClock(clock);
				new TextClock(clock);
			}
		});
	}

	public void setVisible() {
		// TODO Auto-generated method stub
		
	}
}


