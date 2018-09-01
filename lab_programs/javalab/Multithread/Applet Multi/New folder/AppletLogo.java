import java.applet.Applet;
import java.awt.*;

public class AppletLogo extends Applet
{
    public void paint(Graphics g)
    {
        g.setColor(Color.black);

        int x1[] = {10, 40, 70, 40};
        int y1[] = {140, 120, 130, 145};

        int n_ver1 = 4;

        g.fillPolygon(x1, y1, n_ver1);

        int x2[] = {70, 100, 120, 80};
        int y2[] = {130, 110, 120, 150};

        int n_ver2 = 4;

        g.fillPolygon(x2, y2, n_ver2);
    }

}