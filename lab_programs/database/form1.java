
import java.sql.*;
import java.awt.*;
import java.io.*;
import java.awt.event.*;
import java.applet.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.event.*;
public class form1 extends JFrame implements ActionListener,MouseListener,DocumentListener,WindowListener
{
		Connection con;
		Statement st;
		
		ResultSet rs;
		int id_val;
		JLabel l=new JLabel("    OWNER DETAILS");
		JLabel l1=new JLabel("Owner No :");
		JLabel l2=new JLabel("Name :");
		JLabel l3=new JLabel("Address :");
		JLabel l4=new JLabel("Contact :");
		JLabel l5=new JLabel("License No :");
		JLabel lback=new JLabel();
		JLabel lpic=new JLabel();
		
		JTextField owner_no=new JTextField();
		JTextField name=new JTextField();
		JTextField address=new JTextField();
		JTextField contact=new JTextField();
		JTextField license_no=new JTextField();
		JTextField search=new JTextField();

		JButton save=new JButton("Save");
		JButton edit=new JButton("Edit");
		JButton delete=new JButton("Delete");
		JButton news=new JButton("New");
		JButton exit=new JButton("Exit");
		JButton cancel=new JButton("Cancel");
		JButton refresh=new JButton("Refresh");
		JComboBox combo=new JComboBox();
		
		JTable table=new JTable()
		{
		public boolean isCellEditable(int r,int c)
		{
		return false;
		}
		};
		
		DefaultTableModel model=new DefaultTableModel(new String[]{"Owner_No","Name","Address","Contact","License No"},0);
		JScrollPane scrollpane;
		
		String inputstr,combostr,towner_no;

		int btn;
		
		form1()
		{
		
			setVisible(true);
			setLayout(null);
			setSize(850,600);
			setLocation(100,100);
			setBackground(new Color(100,100,100));
			setTitle("OWNER DETAILS");
			//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setResizable(false);
			setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			lback.setIcon(new ImageIcon("texture.jpg"));

			//Adding Objects To Form			
			add(l);
			add(l1);
			add(l2);
			add(l3);
			add(l4);
			add(l5);
			
			add(owner_no);
			add(name);
			add(address);
			add(contact);
			add(license_no);
			add(search);
			add(save);
			add(edit);
			add(news);
			add(delete);
			add(exit);
			add(refresh);
			add(combo);
			add(cancel);
			scrollpane=new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
			table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

			add(scrollpane);
			add(lpic);
			add(lback);
			//Setting Positions & Size Of Objects
			l.setFont(new Font("ARIAL",Font.PLAIN,40));
			l1.setFont(new Font("ARIAL",Font.BOLD,15));
			l2.setFont(new Font("ARIAL",Font.BOLD,15));
			l3.setFont(new Font("ARIAL",Font.BOLD,15));
			l4.setFont(new Font("ARIAL",Font.BOLD,15));
			l5.setFont(new Font("ARIAL",Font.BOLD,15));
			l.setForeground(Color.WHITE);
			l1.setForeground(Color.WHITE);
			l2.setForeground(Color.WHITE);
			l3.setForeground(Color.WHITE);
			l4.setForeground(Color.WHITE);
			l5.setForeground(Color.WHITE);
			
			lpic.setBounds(10,0,100,100);
			lpic.setIcon(new ImageIcon("logo.png"));
			l.setBounds(60,70,400,50);
			l1.setBounds(100,140,100,20);
			l2.setBounds(100,180,100,20);
			l3.setBounds(100,220,100,20);
			l4.setBounds(100,260,100,20);
			l5.setBounds(100,300,100,20);
			lback.setBounds(0,0,850,600);
			owner_no.setBounds(220,140,100,20);
			owner_no.setEditable(false);
			name.setBounds(220,180,100,20);
			address.setBounds(220,220,100,20);
			contact.setBounds(220,260,100,20);
			license_no.setBounds(220,300,100,20);
			save.setBounds(100,400,80,25);
			news.setBounds(100,350,80,25);
			edit.setBounds(200,350,80,25);
			delete.setBounds(300,350,80,25);
			cancel.setBounds(200,400,80,25);
			exit.setBounds(300,400,80,25);
			refresh.setBounds(690,140,80,20);
			search.setBounds(450,140,100,20);
			combo.setBounds(570,140,100,20);
			combo.addItem("Owner_No");
			combo.addItem("Name");
			combo.addItem("Address");
			combo.addItem("Contact");
			combo.addItem("License No");
			
			//Connection with sql
						
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase","root","");
				st=con.createStatement();
			}
			catch(Exception e)
			{
			}
		
			refresh.addActionListener(this); 
			save.addActionListener(this);
			edit.addActionListener(this);
			delete.addActionListener(this);
			exit.addActionListener(this);
			cancel.addActionListener(this);
			table.addMouseListener(this);
			news.addActionListener(this);
			addWindowListener(this);
			search.getDocument().addDocumentListener(this);
			combostr="";
			inputstr="";
			save.setEnabled(false);
			edit.setEnabled(false);
			delete.setEnabled(false);
			table.setModel(model);

			scrollpane.setBounds(450,180,375,360);	
			combo.addActionListener(this);
			deactivatefun();
			displaytablefun();
		}
				
				
			
		void deactivatefun()
		{
			name.setEditable(false);
			address.setEditable(false);
			contact.setEditable(false);
			license_no.setEditable(false);
		}
		
		void activatefun()
		{
			name.setEditable(true);
			address.setEditable(true);
			contact.setEditable(true);
			license_no.setEditable(true);
		}
				
	public void insertUpdate(DocumentEvent e)
	{
		displaytablefun();
		
	}
	
	public void removeUpdate(DocumentEvent e)
	{
		displaytablefun();
	}
		
	public void changedUpdate(DocumentEvent e)
	{
		displaytablefun();
	}
					
	public void actionPerformed(ActionEvent e)
	{
		
		if(e.getSource()==news)
		{
			activatefun();
			displaytablefun();
		try
		{
			rs=st.executeQuery("select * from owner_key");
			rs.next();
			id_val=Integer.parseInt(rs.getString(1));
			//JOptionPane.showMessageDialog(null,id_val);
		
			rs=st.executeQuery("select lpad(mykey,5,'0') from owner_key");
			rs.next();
			String w="O"+rs.getString(1);
		 
			owner_no.setText(w);
			save.setEnabled(true);
			news.setEnabled(false);
			edit.setEnabled(false);
			delete.setEnabled(false);
			search.setEnabled(false);
			combo.setEnabled(false);
			//cancel.setEnabled(true);
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
		}
		
		if(e.getSource()==save)
		{
		savefun();
		search.setEnabled(true);
		combo.setEnabled(true);
		}
		
		if(e.getSource()==cancel)
		{
		news.setEnabled(true);
		save.setEnabled(false);
		edit.setEnabled(false);
		delete.setEnabled(false);
		deactivatefun();
		displaytablefun();
		search.setEnabled(true);
		combo.setEnabled(true);
		}
			//cancel.setEnabled(false);				
		if(e.getSource()==combo)
		displaytablefun();
		
		if(e.getSource()==refresh)
		{
		search.setText("");
		combo.setSelectedItem("Owner_No");
		edit.setEnabled(false);
		delete.setEnabled(false);
		news.setEnabled(true);
		save.setEnabled(false);
		deactivatefun();
		}
		
		if(e.getSource()==edit)
		{
		btn=1;
		activatefun();
					edit.setEnabled(false);
			delete.setEnabled(false);
		save.setEnabled(true);
				search.setEnabled(false);
		combo.setEnabled(false);
		}
				
		if(e.getSource()==delete)
		deletefun();
		
		if(e.getSource()==exit)
		this.dispose();
				
	}
			
		void deletefun()
		{
			if(name.getText().equals("")||owner_no.getText().equals("")||address.getText().equals("")||contact.getText().equals("")||license_no.getText().equals(""))
			JOptionPane.showMessageDialog(null,"Not Enough Details!!!");
			else
			{
				try
				{
				int i =JOptionPane.showConfirmDialog(null,"Are You Sure You Want To Delete??","alert",JOptionPane.OK_CANCEL_OPTION);
				if(i==0)
				{
				st.executeUpdate("delete from owner where owner_no='"+towner_no+"'");
				displaytablefun();
				JOptionPane.showMessageDialog(null,"Deleted successfully!!!");
				}
				else
				displaytablefun();
				}
				catch(Exception ex)
				{
				System.out.println(ex);
				}
			}
			edit.setEnabled(false);
			delete.setEnabled(false);
			news.setEnabled(true);
			deactivatefun();

		}
		
				
		void editfun()
		{
			if(name.getText().equals("")||owner_no.getText().equals("")||address.getText().equals("")||contact.getText().equals("")||license_no.getText().equals(""))
			JOptionPane.showMessageDialog(null,"Not Enough Details!!!");
			else
			{
				try
				{
					
				st.executeUpdate("update owner set owner_no='"+owner_no.getText()+"',name='"+name.getText()+"',address='"+address.getText()+"',contact='"+contact.getText()+"',license_no='"+license_no.getText()+"' where owner_no='"+towner_no+"'");
				displaytablefun();
				JOptionPane.showMessageDialog(null,"Updated successfully!!!");
				}
				catch(Exception ex)
				{
				System.out.println(ex);
				}
			}
			edit.setEnabled(false);
			delete.setEnabled(false);
			news.setEnabled(true);
			deactivatefun();

		}
						
		void savefun()
		{
			if(btn==1)
			editfun();
			else
			{
				if(name.getText().equals("")||owner_no.getText().equals("")||address.getText().equals("")||contact.getText().equals("")||license_no.getText().equals(""))
				{
				displaytablefun();
				JOptionPane.showMessageDialog(null,"Not Enough Details!!!");
				}
				else
				{
					try
					{
						
						st.executeUpdate("insert into owner values('"+owner_no.getText()+"','"+name.getText()+"','"+address.getText()+"','"+contact.getText()+"','"+license_no.getText()+"')");
						displaytablefun();
						JOptionPane.showMessageDialog(null,"value added successfully!!!");
						st.executeUpdate("update owner_key set mykey ='"+Integer.toString(id_val+1)+"'");
						
					}
					catch(Exception ins)
					{
						displaytablefun();
						JOptionPane.showMessageDialog(null,"Owner id is a primary mykey!!!");
					}
				}
			}
			news.setEnabled(true);
			save.setEnabled(false);
			deactivatefun();
			btn=0;
			//cancel.setEnabled(false);
			
		}
				
		void clearfun()
		{
			owner_no.setText("");
			name.setText("");
			address.setText("");
			contact.setText("");
			license_no.setText("");
			model.setRowCount(0);
		}
				
		void displaytablefun()
		{
				clearfun();
				try
					{
						inputstr=search.getText();
						
						combostr=(String)combo.getSelectedItem();
						if(inputstr.equals(""))
						rs=st.executeQuery("Select * from owner order by name");
						else
						{
						if(combostr.equals("Name"))
						rs=st.executeQuery("Select * from owner where name like lower('"+inputstr+"%') or name like upper('"+inputstr+"%') order by name");
						if(combostr.equals("Address"))
						rs=st.executeQuery("Select * from owner where address like lower('"+inputstr+"%') or address like  upper('"+inputstr+"%') order by name");
						if(combostr.equals("Owner_No"))
						rs=st.executeQuery("Select * from owner where owner_no like lower('"+inputstr+"%') or owner_no like upper('"+inputstr+"%') order by name");
						if(combostr.equals("Contact"))
						rs=st.executeQuery("Select * from owner where contact like lower('"+inputstr+"%') or contact like upper('"+inputstr+"%') order by name");
						if(combostr.equals("License No"))
						rs=st.executeQuery("Select * from owner where license_no like lower('"+inputstr+"%') or license_no like upper('"+inputstr+"%') order by name");
						}
						inputstr="";
						combostr="";
						
						if(rs.next())
						{
							do		
							model.addRow(new Object[]{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)});
							while(rs.next());
							table.setModel(model);
						}						
						
					}
				catch(Exception e)
				{
					System.out.println(e+"hello");
				}
		}
			
		public void mouseClicked(MouseEvent m)
		{
		int row=table.getSelectedRow();
		owner_no.setText(model.getValueAt(row,0).toString());
		name.setText(model.getValueAt(row,1).toString());
		address.setText(model.getValueAt(row,2).toString());
		contact.setText(model.getValueAt(row,3).toString());
		license_no.setText(model.getValueAt(row,4).toString());
		towner_no=owner_no.getText();
		edit.setEnabled(true);
		delete.setEnabled(true);
		news.setEnabled(false);
		save.setEnabled(false);
		deactivatefun();
			name.setOpaque(true);
			address.setOpaque(true);
			contact.setOpaque(true);
			owner_no.setOpaque(true);
			license_no.setOpaque(true);
		}
				
		public void mouseExited(MouseEvent e)
		{

		}
		
		public void mouseEntered(MouseEvent e)
		{

		}
		
		public void mouseReleased(MouseEvent e)
		{

		}
		
		public void mousePressed(MouseEvent e)
		{
			
		}

		public void windowOpened(WindowEvent e) {
		}
		public void windowClosing(WindowEvent e) {
			int i =JOptionPane.showConfirmDialog(null,"Are You Sure You Want To Exit ?","alert",JOptionPane.OK_CANCEL_OPTION);
			if( i == 0 )
					dispose();
		}
		public void windowClosed(WindowEvent e) {
		}
		public void windowIconified(WindowEvent e) {
		}
		public void windowDeiconified(WindowEvent e) {
		}
		public void windowActivated(WindowEvent e) {
		}
		public void windowDeactivated(WindowEvent e) {
		}
				
		public static void main(String args[])
		{
			new form1();
		}
}		