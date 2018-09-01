import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridBagLayout;
import java.awt.Panel;
import java.awt.GridLayout;
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
        b1.setBackground(Color.WHITE);
        b2 = new Button("2");
        b2.setBackground(Color.WHITE);
        b3 = new Button("3");
        b3.setBackground(Color.WHITE);
        b4 = new Button("4");
        b4.setBackground(Color.WHITE);
        b5 = new Button("5");
        b5.setBackground(Color.WHITE);
        b6 = new Button("6");
        b6.setBackground(Color.WHITE);
        b7 = new Button("7");
        b7.setBackground(Color.WHITE);
        b8 = new Button("8");
        b8.setBackground(Color.WHITE);
        b9 = new Button("9");
        b9.setBackground(Color.WHITE);
        f = new Frame("Layout Checking");
        //f.setLayout(new GridBagLayout());
        //f.setLayout(new FlowLayout());
        f.setLayout(new GridLayout());
        p1 = new Panel();
        p2 = new Panel();
        p3 = new Panel();

        f.setBackground(Color.BLUE);
        p1.setBackground(Color.RED);
        p2.setBackground(Color.YELLOW);
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
        p3.add(b7);
        p3.add(b8);
        p3.add(b9);
        f.add(p1);
        f.add(p2);
        f.add(p3);
        f.setSize(500,500);
        f.setVisible(true);
    }
    
    public static void main(String []args)
    {
        Layout obj = new Layout();
        obj.addComp();
    }
}