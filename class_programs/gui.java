import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridBagLayout;
import java.awt.Panel;

public class Layout
{
    private Button b1;
    private Button b2;
    private Button b3;
    private Button b4;
    private Button b5;
    private Button b6;
    private Button b7;
    private Button b8;
    private Button b9;

    Frame f;
    private Panel p1,p2,p3;
    public Layout()
    {
        b1 = new Button("1");
        b2 = new Button("2");
        b3 = new Button("3");
        b4 = new Button("4");
        b5 = new Button("5");
        b6 = new Button("6");
        b7 = new Button("7");
        b8 = new Button("8");
        b9 = new Button("9");
        f = new Frame("Layout Checking");
        f.setLayout(new GridBagLayout());
        p1 = new Panel();
        p2 = new Panel();
        p3 = new Panel();

        f.setBackground(Color.BLUE);
        p1.setBackground(Color.black);
        p2.setBackground(Color.CYAN);
        p3.setBackground(Color.GREEN);
    }

    public void addComp()
    {
        p1.add(b1);
        p1.add(b2);
        p1.add(b3);
        p2.add(b4);
        p2.add(b5);
        p2.add(b6);
        p2.add(b7);
        p3.add(b8);
        p3.add(b9);
        p3.add(p1);
        f.add(p1);
        f.add(p2);
        f.add(p3);
        f.setSize(500,500);
        f.setVisible(true);
    }

    public static void main(String[] args) {
        Layout obj = new Layout();
        obj.addComp();
    }
}