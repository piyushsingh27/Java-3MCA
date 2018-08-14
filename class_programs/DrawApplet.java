import java.awt.*;
import java.applet.*;

public class DrawApplet extends Applet
{
    Font bigFont;
    Color redColor;
    Color weirdColor;
    Color bgColor;
    public void init()
    {
        System.out.println("init");
        bigFont = new Font("Arial",Font.BOLD,16);
        redColor = Color.red;
        weirdColor = new Color(60,60,122) ;
        bgColor = Color.blue;
        setBackground(bgColor);
    }
    public void start()
    {
        System.out.println("start");
    }
    public void stop()
    {
        System.out.println("stop");

    }
    public void destroy()
    {
        System.out.println("Destroy");

    }
    public void paint(Graphics g)
    {
        g.setFont(bigFont);
        g.drawString("Shapes and Colors",80,20);
        g.setColor(redColor);
        g.drawRect(100,100,100,100);
        g.fillRect(110,110,80,80);
        g.setColor(weirdColor);
        g.setColor(Color.yellow);
        g.drawLine(140,140,160,160);
        g.setColor(Color.black);
    }
}