/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author jamuna
 */


    import java.util.Observer;
import java.util.Observable;


public class TextClock implements Observer {
	
	public TextClock(Observable model)
	{
		model.addObserver(this);
		update(model, null);
	}
	
	public void update(Observable model, Object obj)
	{
		System.out.println(((clock)model).getDate());
		System.out.println("\t" + ((clock)model).getTime() + "\n");
	}
}


