import java.sql.*;
import java.awt.*;
import java.io.*;
import java.awt.event.*;
import java.applet.*;
import javax.swing.*;
public class form0 implements ActionListener
{
        JFrame jf =  new JFrame("");
		JLabel l=new JLabel("    LOGIN");
		JLabel l1=new JLabel("User Id :");
		JLabel l2=new JLabel("Password :");
		JLabel lpic=new JLabel();	
		JLabel lback=new JLabel();		
		
		JTextField id=new JTextField();;
		JPasswordField password=new JPasswordField();
		
		JButton login=new JButton("Login");
		JComboBox combo=new JComboBox();					
		form0()
		{
		
		}

		void display(int x)        
		{
			jf.setVisible(true);
			jf.setLayout(new GridBagLayout());
			jf.setSize(500,500);
			jf.setLocation(100,100);
			jf.setTitle("User Login");
			jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			//jf.setResizable(false);
			switch (x) {
				case 0:
				jf.setLayout(new BorderLayout());
					break;

				case 1:
				jf.setLayout(new FlowLayout());
					break;

				case 2:
				jf.setLayout(new GridLayout());
					break;

				case 3:
				jf.setLayout(new CardLayout());
					break;
				case 4:
				jf.setLayout(new GridBagLayout());	
					break;
				
				case 5:
				jf.setLayout(new SpringLayout());
					break;
			
				default:
					break;
			}
			//Adding Objects To Form
			jf.add(l);
			jf.add(l1);
			jf.add(l2);
			jf.add(id);
			jf.add(password);
			jf.add(login);
			//jf.add(lpic);
			//jf.add(lback);
			jf.add(combo);
			combo.removeAllItems();
			combo.addItem("BorderLayout");
			combo.addItem("FlowLayout");
			combo.addItem("GridLayout");
			combo.addItem("CardLayout");
			combo.addItem("GridBagLayout");
			//combo.addItem("ScrollPaneLayout");
			combo.addItem("SpringLayout ");
			combo.setSelectedIndex(x);
			jf.getContentPane().setBackground(new Color(255,100,10));
			id.setToolTipText("Enter User Id");
			password.setToolTipText("Enter Password");
			
		    //lback.setIcon(new ImageIcon("login1.jpg"));
			
			//Setting Positions & Size Of Objects
			l.setFont(new Font("ARIAL",Font.PLAIN,25));
			//l.setForeground(Color.white);
			//l1.setForeground(Color.white);
			//l2.setForeground(Color.white);
			//lback.setBounds(0,-15,400,400);
			// l.setBounds(140,100,400,20);
			// lpic.setBounds(10,0,100,100);
			// //lpic.setIcon(new ImageIcon("logo.png"));
			// l1.setBounds(100,140,100,20);
			// l2.setBounds(100,180,100,20);
			// id.setBounds(220,140,100,20);
			// password.setBounds(220,180,100,20);
			// login.setBounds(240,220,80,20);
			// combo.setBounds(240,280,80,20);
			password.setEchoChar('*');
		
			login.addActionListener(this);
			combo.addActionListener(this);

		}
            
					
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == login)
		{
			JOptionPane.showMessageDialog(null,"This Doesn't Work!!!");
		}
		else if( e.getSource() == combo )
		{
			//JOptionPane.showMessageDialog(null,"This Doesn't Work!!!");
			int x = combo.getSelectedIndex();
			display(x);
		}
		
			
	}
					
	public static void main(String args[])
	{
		form0 f = new form0();
		f.display(0);
	}
}		