import java.io.*;
import java.util.Scanner;


class NumberValidation 
{
    static boolean numberOrNot(String input, byte flag) 
    {
        try
        {
            if (1 == flag)
                Integer.parseInt(input);
            else if (2 == flag)
                Long.parseLong(input);
            else if (3 == flag)
                Float.parseFloat(input);
        } 
        catch (NumberFormatException ex) 
        {
            return false;
        }
        return true;
    }
}


class Books implements Serializable
{
    private String bookId;
    private String isbnNo;
    private String bookName;
    private String author;
    private float mrp;
    private boolean issueStatus;
    private String bookDescription;
    private String bookGenre;
    transient Scanner in = new Scanner(System.in);
    private String regNo;
    public void read() 
    {
        System.out.println("Enter the Register Number");
        regNo = in .nextLine();
        boolean flag = true;
        byte choice;
        do 
        {
            System.out.print("Enter the Book Id:-");
            bookId = in .next();
            flag = NumberValidation.numberOrNot(bookId, (byte) 1);
            if (!flag) 
            {
                flag = true;
                System.out.println("Input Numbers Only");
            }
            else
            {
                flag = false;
            }
        } while (flag);
        do
        {
            System.out.print("Enter the ISBN Number:-");
            isbnNo = in .next();
            flag = NumberValidation.numberOrNot(isbnNo, (byte) 2);
            if (!flag)
            {
                flag = true;
                System.out.println("Input Numbers Only");
            }
            else 
            {
                flag = false;
            }
        } while (flag);
        System.out.print("Enter the Book Name:-"); in .nextLine();
        bookName = in .nextLine();
        System.out.print("Enter the Author for the book:-");
        author = in .nextLine();
        System.out.print("Enter the Price for the book:-");
        mrp = in .nextFloat();
        System.out.print("Enter the Issue Status for the book :-");
        in.nextLine();
        issueStatus = Boolean.parseBoolean( in .nextLine());
        System.out.println(issueStatus);
        System.out.print("Enter the Book Description:-");
        bookDescription = in .nextLine();
        do 
        {
            System.out.println("Enter the Book Genre:-");
            System.out.println("1.Science fiction");
            System.out.println("2.Action and Adventure");
            System.out.println("3.Mystery");
            System.out.print("Choose one from below:");
            choice = in .nextByte();
            switch (choice) 
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
        } while (flag);
    }
    public void display() 
    {
        System.out.println("The Register Number is " + regNo);
        System.out.println("Book Id:-" + bookId);
        System.out.println("ISBN Number:-" + isbnNo);
        System.out.println("Book Name:-" + bookName);
        System.out.println("Author for the book:-" + author);
        System.out.println("Price for the book:-" + mrp);
        System.out.println("Issue Status for the book :-" + issueStatus);
        System.out.println(" Book Description:-" + bookDescription);
        System.out.println("Book Genre:-" + bookGenre);
    }
}

    
class FileObjectWrite 
{
    public static void main(String s[]) throws IOException,ClassNotFoundException
    {
        byte choice;
        boolean loop = true;
        byte no;
        char check;
        try
        {
            Scanner in = new Scanner(System.in);
            System.out.println("******************************************************************");
            System.out.print("Enter the number of books for which u want to enter the details:-");
            no = in .nextByte();
            System.out.println("******************************************************************");
            Books[] bk = new Books[no];
            do 
            {
                System.out.println("1.Enter all the details of the Book");
                System.out.println("2.Display all the details of the Book");
                System.out.println("3.Exit\n");
                System.out.print("Enter Your Choice:-");
                choice = Byte.parseByte( in .next());
                System.out.println("******************************************************************");
                switch (choice) 
                {
                    case 1:
                    {
                        FileOutputStream fw = new FileOutputStream("books");
                        ObjectOutputStream obj = new ObjectOutputStream(fw);
                        for(int i = 0;i < no;i++)
                        {
                            bk[i] = new Books();
                            bk[i].read();
                            System.out.print("here");
                            obj.writeObject(bk[i]);
                            System.out.print("here1");
                        }
                        obj.close();
                    }
                    break;
                    case 2:
                    {
                        Books bb[] = new Books[no];
                        FileInputStream fw = new FileInputStream("books");
                        ObjectInputStream obj = new ObjectInputStream(fw);
                        for(int i = 0; i < no;i ++)
                        {
                            bb[i] = (Books)obj.readObject();
                            bb[i].display();
                        }
                        obj.close();
                    }
                    break;
                    case 3:
                    {
                        loop = false;
                        System.out.println("******************************************************************"); in .close();
                    }
                    break;

                    default:
                    System.out.println("******************************************************************");
                    System.out.println("invalid choice");
                }
            } while (loop);
        }
        catch(Exception e)
        {
            System.out.println(e.toString());
        }
    }
}