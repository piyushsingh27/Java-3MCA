import java.applet.Applet;
import java.awt.*;

public class Appletdemo extends Applet
{

    String str = "Welcome";
    public void paint(Graphics g)
    {
        g.setColor(Color.red);
        
        g.drawString(str, 50, 50);

        g.drawLine(10, 70, 20, 100);
        g.drawRect(20, 100, 40, 20);
        g.drawArc(40, 150, 50, 40, 30, 120);
        g.fillArc(40, 200, 50, 40, 0, 180);

        int x[] = {10, 30, 40, 50, 110, 140};
        int y[] = {140, 110, 50, 40, 30, 10};

        int n_ver = 6;

        g.drawPolygon(x, y, n_ver);
    }
}