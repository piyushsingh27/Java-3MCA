import java.io.*;
import java.util.Scanner;



import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import numbervalidation.NumberValidation;
import com.issuee.*;

class Books
{    
    static short bookId = 0001;
    private String isbnNo;
    private String bookName;
    private String author;
    private float mrp;
    private String bookDescription;
    private String bookGenre;
	private byte flag1 = 0;
	private int issueeId;
	private String issueeName,user;
	
	Scanner in =new Scanner(System.in);
	Books()
	{
		bookId ++;
	}
	Books(String s)
    {
        bookGenre = s;
        flag1 = 1;
    }
    public void read()throws IOException
    {
        
		boolean flag = true;
		byte choice;
		
	
    do
	{
		System.out.print("Enter the ISBN Number:-");
		isbnNo = in.next();
		flag = NumberValidation.numberOrNot(isbnNo,(byte)2);
		if(!flag)
		{
			flag = true;
			System.out.println("Input Numbers Only");
		}
		else
		{
			flag = false;
		}
	
	}while(flag);
	
		System.out.print("Enter the Book Name:-");
		in.nextLine();
        bookName = in.nextLine();
        
        System.out.print("Enter the Author for the book:-");
        
        author = in.nextLine();
            
        System.out.print("Enter the Price for the book:-");
        mrp = in.nextFloat();
        System.out.print("Enter the Book Description:-");
        in.nextLine();
        bookDescription = in.nextLine();
		if(flag1 !=1)
        {
	    	do
		    {
		System.out.println("Enter the Book Genre:-");
		
		System.out.println("1.Science fiction");
		System.out.println("2.Action and Adventure");
		System.out.println("3.Mystery");
		System.out.println("4.Course Book");
      
		System.out.print("Choose one from below");

		choice = in.nextByte();
		switch(choice)
		{
			case 1:
				bookGenre = "Science_fiction";
				break;
			case 2:
				bookGenre = "Action_and_Adventure";
				break;
			case 3:
				bookGenre = "Mystery";
				break;
			case 4:
				bookGenre = "Course Book";
				break;
			default:
			{
				System.out.println("Invalid  Choice Enter again ");
				flag = true;
			}
			
		}
			}while(flag);
		}
		
    
	}
	
   final public void display()
    {
        System.out.println("Book Id:-"+bookId);
        System.out.println("ISBN Number:-"+isbnNo);
        System.out.println("Book Name:-"+bookName);
        System.out.println("Author for the book:-"+author);
        System.out.println("Price for the book:-"+mrp);
        System.out.println(" Book Description:-"+bookDescription);
		System.out.println(" Book Description:-"+bookGenre);
	}
}

class Student implements Issuee
{
    int regno;
    String name;
	String classname;
	final private static String issueDate,expiryDate;
	private static Date date = new Date();
	static{
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");
		issueDate = formatter.format(date);
		Calendar c = Calendar.getInstance();
		c.setTime(date);	
		c.add(Calendar.DAY_OF_MONTH, 15);
		expiryDate = formatter.format(c.getTime()); 
	}
    public void read()throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter the Register Number:");
        regno = Integer.parseInt(br.readLine());
        System.out.print("Enter Name:");
        name = br.readLine();
        System.out.print("Enter the Class Your Are Studying In:");
        classname = br.readLine();
        
    }
    public void display()
    {
        System.out.println("The Register Number is:"+regno);
        System.out.println("Name  is:"+name);
		System.out.println("Class Your are studying in  is:"+classname);
		System.out.println("Issue Date:"+issueDate);
		System.out.println("Expiry Date:"+expiryDate);
       
    }
}
class Faculty implements Issuee
{
    int empid;
    String name;
	String deptname;
	final private static String issueDate,expiryDate;
	private static Date date = new Date();
	static{
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");
		issueDate = formatter.format(date);
		Calendar c = Calendar.getInstance();
		c.setTime(date);	
		c.add(Calendar.DAY_OF_MONTH, 30);
		expiryDate = formatter.format(c.getTime()); 
	}
    public void read()throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter the Employee ID:");
        empid = Integer.parseInt(br.readLine());
        System.out.print("Enter Name:");
        name = br.readLine();
        System.out.print("Enter the Department Name:");
        deptname = br.readLine();
    }
    public void display()
    {
        System.out.println("The  Employee id is:"+empid);
        System.out.println("Name  is:"+name);
		System.out.println("Department name:"+deptname);
		System.out.println("Issue Date:"+issueDate);
		System.out.println("Expiry Date:"+expiryDate);
    }

}

class Interfacees
{
	public static void main(String s[]) throws IOException
	{
		byte choice;
		boolean loop = true;
	
		Scanner in =new Scanner(System.in);
		byte flag = 0,no;	
		byte j = 0; 
		System.out.println("******************************************************************");
		System.out.print("Enter the number of books for which u want to enter the details:-");
		no = in.nextByte();
        System.out.println("******************************************************************");
        System.out.println("Are you a ? \n(1)Student\n(2) Faculty");
        System.out.print("Enter Your Choice:");
	   Issuee bk[] = null;
		Books book[] = null;
        j = in.nextByte();
        if(1 == j)
        {
			bk = new Student[no];
			book = new Books[no];
            for(byte k = 0;k < no;k++)
            {
				bk[k] = new Student();
				book[k] = new Books();
            }
        }
        else if( 2 == j)
        {
			bk = new Faculty[no];
			book = new Books[no];
            for(byte k = 0;k < no;k++)
            {
				bk[k] = new Faculty();
				book[k] = new Books();
            }
        }
		
		do
		{
			System.out.println("******************************************************************");
			System.out.println("1.Enter all the details of the Book");
			System.out.println("2.Display all the details of the Book");
			System.out.println("3.Exit\n");
			System.out.print("Enter Your Choice:-");
			choice = Byte.parseByte(in.next());
			System.out.println("******************************************************************");
			
			switch(choice)
			{
				case 1:
				{
					flag = 1;
					for (byte i = 0;i< no;i++)
						{
							System.out.println("******************************************************************");
							System.out.println("Enter the details for the book"+(i+1));
                            System.out.println("******************************************************************");
                            bk[i].read();
                            book[i].read();
						}	
				}
				break;
				case 2:
				{
					if(0 == flag)
					{
						System.out.println("Enter some details first to display");
						System.out.println("******************************************************************");
						break;
					}
					for (byte i = 0;i< no;i++)
						{
							System.out.println("******************************************************************");
							System.out.println("The details for the book"+(i+1));
							System.out.println("******************************************************************");
						
							bk[i].display();
							book[i].display();
                           
						
						}
				}
				break;

				case 3:
				{
					
					loop = false;
					System.out.println("******************************************************************");
					in.close();
				}break;
					
	 			default:
				System.out.println("******************************************************************");
					System.out.println("invalid choice");
			}
		}while(loop);
	}
}
