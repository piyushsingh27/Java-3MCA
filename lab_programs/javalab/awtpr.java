import java.awt.*;
import java.awt.event.*;
import javax.swing.*;



class awtpr implements ActionListener
{
    JFrame f;
    JTextField tf, tf1, tf2, tf3;
    JButton jb;
    JLabel lb;

    awtpr()
    {
        f = new JFrame("Frame1");
        f.setLayout(new BoxLayout(f.getContentPane(),BoxLayout.X_AXIS));
        f.setSize(400,400);
        f.setLocation(20, 20);

        tf = new JTextField();
        tf.setBounds(30,30,200,30);
        f.add(tf/*,BorderLayout.NORTH*/);

        tf1 = new JTextField();
        tf1.setBounds(30,90,200,30);
        f.add(tf1/*,BorderLayout.SOUTH*/);

        tf2 = new JTextField();
        tf2.setBounds(30,150,200,30);
        f.add(tf2/*,BorderLayout.EAST*/);

        /*tf3 = new JTextField();
        tf3.setBounds(30,150,200,30);
        f.add(tf3,BorderLayout.WEST);
        */

        lb = new JLabel();
        lb.setBounds(30,210,200,30);
        f.add(lb);

        jb = new JButton("add");
        jb.setBounds(40,200,80,30);
        f.add(jb/*,BorderLayout.CENTER*/);

        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jb.addActionListener(this);

        //Key Listener Event, f is the object of frame
        tf.addKeyListener(new KeyAdapter()
        {
            public void keyTyped(KeyEvent e)
            {
                if(e.getKeyChar() == ' ')
                {
                    JOptionPane.showMessageDialog(null,"message");
                    e.consume();
                }
            }

            public void keyPressed(KeyEvent e)
            {
                if(e.getKeyChar() == KeyEvent.VK_BACK_SPACE)
                e.consume();
            }

            public void keyReleased(KeyEvent e)
            {
                if(e.getKeyChar() == KeyEvent.VK_DELETE)
                tf.setText(tf.getText()+"@");
            }
        });

        //Mouse Listener Events, f is the object of frame
        f.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e)
            {
                tf.setText(e.getX()+" "+e.getY());
            }
            public void mouseEntered(MouseEvent e)
            {
                //JOptionPane.showMessageDialog(null, "entry");
            }
        });    
        
        f.addMouseMotionListener(new MouseMotionAdapter()
        {
            public void mouseMoved(MouseEvent e)
            {
                lb.setText(e.getX()+" "+e.getY());
            }
        });

        f.addWindowListener(new WindowAdapter()
        {
            public void windowActivated(WindowEvent e)
            {
                System.out.println("activated");
            }

            public void windowClosed(WindowEvent e)
            {
                System.out.println("closed");
            }

            public void windowDeactivated(WindowEvent e)
            {
                System.out.println("deactivated"); 
            }

            public void windowOpened(WindowEvent e)
            {
                System.out.println("opened"); 
            }
        });

        tf2.addFocusListener(new FocusAdapter()
        {
            public void focusGained(FocusEvent e)
            {
                tf2.setText("you have entered");
            }

            public void focusLost(FocusEvent e)
            {
                tf2.setText("you have lost focus");
            }
        });
    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == jb)
        {
            float a = Float.parseFloat(tf.getText());
            float b = Float.parseFloat(tf1.getText());
            float c = a + b;
            tf2.setText("" + c);
            //tf.setText("Hello");
        }
    }


    public static void main(String[] args) {
        awtpr pr = new awtpr();
    }
}