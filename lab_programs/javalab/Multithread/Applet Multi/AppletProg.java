import java.awt.*;
import java.applet.*;
import java.net.*;
import java.awt.Graphics;
import javax.swing.JApplet;
import java.awt.Color;
import java.awt.Font;
import java.text.SimpleDateFormat;  
import java.util.Date; 
//import java.time.format.DateTimeFormatter;  
//import java.time.LocalDateTime;

class Thread1 extends Thread
{
    Applet a;
    static int ht = 0;
    static
    {
    	ht = 10;
    }
    Thread1(Applet a)
    {
        this.a = a;
    }

    synchronized public void run()
    {
      try
      {

        	  Thread.sleep(1000);  
              Graphics g = a.getGraphics();
              g.drawRect(10,10,50,ht);
              ht = ht + 10;

              //SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
         	  //Date date = new Date();  
              //g.drawString(formatter.format(date),80,20);
          
      }
      catch(Exception e)
      {

      }
    }
}

class Thread2 extends Thread
{
    Applet a;
    static int ht = 0;
    static
    {
    	ht = 10;
    }
    Thread2(Applet a)
    {
        this.a = a;
    }

    synchronized public void run()
    {
      try
      {
          	  Thread.sleep(1000);
              Graphics g = a.getGraphics();
              g.drawRect(100,10,50,ht);
              ht = ht + 10;

      }
      catch(Exception e)
      {

      }
    }
}



public class AppletProg extends Applet implements Runnable
{
  Font bigFont;
  Color redColor;
  Color weirdColor;
  Color bgColor;
   Image img;
   MediaTracker tr;
    String message;
	Font font;
	  public void init() 
	  {
			setBackground(Color.gray);
      }
   
  		public void paint(Graphics g)
  		{
	  
       
  		}

public void run()
    {
      try
      {
      	while(true)  
      	{
      		Thread1 t1 = new Thread1(this);
      		Thread2 t2 = new Thread2(this);
      		t1.start();
        	try
        	{
	            t1.join();
    	    }
 
        	catch(Exception ex)
        	{
	            System.out.println("Exception has " +
                                "been caught" + ex);
    	    }
 
	        // t2 starts
        	t2.start();
 
    	    
        	try
        	{
	            t2.join();
        	}
 
        	catch(Exception ex)
        	{
	            System.out.println("Exception has been" +
                                    	" caught" + ex);
        	}
      	}
      }
      catch(Exception e)
      {

      }
    }
	public void start()
    {
        Thread t = new Thread(this);
        t.start();
    }


}
