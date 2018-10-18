import java.applet.*;
import java.awt.*;
import java.awt.Graphics;

public class applett extends Applet
{
    Font f;
    Color c;
    @Override
    public void start() {
        System.out.println("I am start");
    }

    @Override
    public void init() {
        f = new Font("Serif", Font.BOLD+Font.ITALIC, 45);
        c = new Color(255,255,255);
        setBackground(new Color(255,255,255));

        System.out.println("I am init");
    }

    @Override
    public void stop() {
        System.out.println("I am stop");
    }

    @Override
    public void paint(Graphics g) {
        //g.setColor(c);
        g.drawRect(10, 10, 10, 10);
        g.drawString("str", 100, 100);
        
        g.fillRect(30, 30, 30, 30);

        System.out.println("I am paint");
    }

    @Override
    public void repaint() {
        System.out.println("I am repaint");
    }

    @Override
    public void destroy() {
        System.out.println("I am destroyed");
    }

}