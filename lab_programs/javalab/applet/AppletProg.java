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

class DateThread extends Thread
{
    Applet a;
    DateThread(Applet a)
    {
        this.a = a;
    }

    public void run()
    {
      try
      {
          while(true)
          {
              Graphics g = a.getGraphics();
              SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
          Date date = new Date();  
          //System.out.println(formatter.format(date));  
          //g.fillRect("               ",80,20); 
              g.drawString(formatter.format(date),80,20);
         //     sleep(1);
          }
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
	  public void init() {
         
         font = new Font("Serif", Font.BOLD+Font.ITALIC, 45);

      }
   
  public void paint(Graphics g)
  {
	  
	  //g.drawRect(30,200,80,20);//horizontal
      //g.fillRect(30,200,80,20);
	  //g.drawRect(40,220,70,20);//horizontal
      //g.fillRect(40,220,70,20);
	  
  	
     g.setColor(Color.black);
    int i;
	for(i=100; i < 110; i++)
    g.drawOval(  i,   i, 250, 250);
  	
	
 
  	/*g.drawRect(145,105,20,100);//vertical
  	g.fillRect(145,105,20,100);
   
  	g.drawRect(20,185,110,20);
    g.fillRect(20,185,110,20);
    g.drawRect(22,85,100,20);
    g.fillRect(22,85,100,20);
    g.drawRect(22,105,100,20);
    g.fillRect(22,105,100,20);*/
	//--------------------------------------------------------
	tr = new MediaTracker(this);
      img = getImage(getCodeBase(), "Mbike.jpg");
      tr.addImage(img,0);
      g.drawImage(img, 180, 130, this);
	 //------------------------------------------------------
	   g.setFont(font);     
      g.drawString("Penguin",120,220);  
	  g.drawString("Book Store",135,255);  
	 //-------------------------------------------------------
  }

public void run()
    {
      try
      {
        while(true)
          {
              Graphics g = getGraphics();
              SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");  
          Date date = new Date();  
          //System.out.println(formatter.format(date)); 
          //g.drawString("               ",240,20); 
              g.drawString(formatter.format(date),240,20);
       //       Thread.sleep(1);
          } 
      }
      catch(Exception e)
      {

      }
    }
public void start()
    {
        DateThread t1 = new DateThread(this);
        Thread t2 = new Thread(this);
        t1.start();
        t2.start();
    }


}





