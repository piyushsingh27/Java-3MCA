import java.awt.*;
import java.applet.*;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;

/*class DateThread extends Thread
{
    Applet a;
    DateThread(Applet a)
    {
        this.a = a;
    }

    public void run()
    {
        while(true)
        {
            Graphics g = a.getGraphics();
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
            LocalDateTime now = LocalDateTime.now();  
            g.drawString(dtf.format(now),80,20);
        }
    }

}*/
public class DrawApplet extends Applet implements Runnable
{
    Font bigFont;
    Color redColor;
    Color weirdColor;
    Color bgColor;


    public void run()
    {

        try
        {
            while(true)
            {
                //repaint();
                Graphics g = getGraphics();
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
                LocalDateTime now = LocalDateTime.now();  
                g.drawString(dtf.format(now),80,20);
                Thread.sleep(1);
            }
        }
        catch(Exception e)
        {

        }
    }
    public void init()
    {
        //System.out.println("init");
        bigFont = new Font("Arial",Font.BOLD,16);
        redColor = Color.red;
        weirdColor = new Color(60,60,122);
        bgColor = Color.blue;
        setBackground(bgColor);
        //DateThread t1 = new DateThread(this);
        //t1.start();
        

    }

    public void start()
    {
        //Thread t1 = new Thread(this);
        ///t1.start();
    }

    public void stop()
    {

    }

    public void destroy()
    {
        
    }
     
    public void paint(Graphics g)
    {
        g.setFont(bigFont);
        
        g.setColor(redColor);
        g.drawRect(100,100,100,100);
        g.fillRect(110,110,80,80);
        g.setColor(weirdColor);
        g.setColor(Color.yellow);
        g.drawRect(100,100,100,100);
        String msg;
       /* URL url = getCodeBase();
        msg = "Code Base" ;
        g.drawString(msg, 10, 20);
        url = getDocumentBase();
        msg = "Document Base:"+url.toString();
        g.drawString(msg, 10, 40);

        AppletContext ac = getAppletContext();
        url = getCodeBase();
        try{
            //ac.showDocument(new URL(url+"Test.html"));
        }
        catch(MailformedURLException e)
        {
            showStatus("Url Not Found");
        }*/
    }
}