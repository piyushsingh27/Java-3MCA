import java.io.*;
import java.util.Scanner;



import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
enum Issueee
{
    STUDENT,FACULTY;
}
class NumberValidation
{
    static boolean numberOrNot(String input,byte flag )
   {
        try
        {
            if(1 == flag)
            Integer.parseInt(input);
            else if(2 == flag)
            Long.parseLong(input);
            else if(3 == flag)
            Float.parseFloat(input);
        }
        catch(NumberFormatException ex)
        {
            return false;
        }
        return true;
   }
}


class Books
{   
   static short bookId = 0001;
   private String isbnNo;
   private String bookName;
   private String author;
   private float mrp;
 // private boolean issueStatus;
   private String bookDescription;
   private String bookGenre;
    private byte flag1 = 0;
    private int issueeId;
    private String issueeName;
    private Issueee i ;
    Scanner in =new Scanner(System.in);
    Books()
    {
        System.out.println("Enter The Book Details");
    }
    static
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
            default:
            {
                System.out.println("Invalid  Choice Enter again ");
                flag = true;
            }
            
        }
            }while(flag);
        }
        
  
    }
    final public void display(int issueeId,String name,Issueee i)
    {
        this.issueeId = issueeId;
        issueeName = name;
        this.i = i;
        
        this.display1();
        
    }
  final public void display1()
   {
       System.out.println("Book Id:-"+bookId);
       System.out.println("ISBN Number:-"+isbnNo);
       System.out.println("Book Name:-"+bookName);
       System.out.println("Author for the book:-"+author);
       System.out.println("Price for the book:-"+mrp);
       System.out.println(" Book Description:-"+bookDescription);
        System.out.println(i + " Id:-"+issueeId);
        System.out.println(i+" Name:-"+issueeName);
        
    }
}
class Issuee extends Books
{
   private int issueeId;
    private String name;
    Issueee i;
    Issuee()
    {
        super("Action");
    }
    public void read()throws IOException
    {
        byte choice ;
        
        System.out.print("Student or Faculty? ");
        System.out.print("Press 1 for student  or 2 for Faculty::");
        choice = in.nextByte();
        
        if(1  == choice)
        {
            i = Issueee.STUDENT;
        }
        else if( 2 == choice)
        {
            i = Issueee.FACULTY;
        }
        else
        {
            System.out.println("Invalid Choice !!");
            System.exit(0);
        }
        System.out.print("Enter "+i+" id:");
        issueeId = in.nextInt();
        in.nextLine();
        System.out.print("Enter "+i+" Name:");
        name = in.nextLine();
        System.out.println(name);
        
        super.read();
    }
    public void display()
    {
        
        super.display(issueeId,name,i);
    }

    
}
final class Transaction extends Issuee
{
final   private static String issueDate,expiryDate;
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

        super.read();
    }
    public void display()
    {
        System.out.println("Issue Date:"+issueDate);
        System.out.println("Expiry Date:"+expiryDate);
        super.display();
    }
}

class Finall
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
        Transaction []bk = new Transaction[no];
        do
        {
            System.out.println("1.Enter all the details of the Book");
            System.out.println("2.Display all the details of the Book");
            //System.out.println("3.Display the details of the book which are not issued");
           // System.out.println("4.Search books according to MRP filter");
            //System.out.println("5.Search books according to Genre");
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
                            bk[i] = new Transaction();
                            bk[i].read();
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



