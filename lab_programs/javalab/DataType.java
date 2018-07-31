import java.util.Scanner;
import java.io.*;

class Customer
{
	private String custName;
	private long custAcNo;
	private byte custAge;
	private short custMinBal;
	private float custBalance;
	private char custGender;
	private boolean custPan;
    private Long custPhone;
    private long custID;
    static long scustid;

    static
    {
        scustid = 100;
    }

    public static void show()
    {
        System.out.println("Last employee id:" + scustid);
        //System.out.println("Name=" + custName);
    }

    public Customer()
    {
        
    }

    public Customer(String n,long acno)
    {
        scustid += 1;
        custID = scustid;
        custName = n;
        custAcNo = acno;
        custAge = 21;
        //custMinBal = 500;
        custBalance  = 2000;    
        custGender = 'M';
        custPan = true;
        custPhone = (long) 1199733549;
    }

    public void read() throws IOException
    {
    	BufferedReader br = new BufferedReader( new InputStreamReader( System.in ));
        
        //Scanner sc = new Scanner(System.in); 
        System.out.println("Enter the customer name:");
        custName = br.readLine();

        System.out.println("Enter the customer number:");
        custAcNo = Long.parseLong(br.readLine());

        System.out.println("Enter the customer age:");
        custAge = Byte.parseByte(br.readLine());

        System.out.println("Enter the minimum balance:");
        custMinBal = Short.parseShort(br.readLine());

        System.out.println("Enter the balance:");
        custBalance = Float.parseFloat(br.readLine());
        
        System.out.println("Enter the gender of person:");
        custGender = (char) br.read();

        br.readLine();

        System.out.println("Do you have a pan card:");
        custPan = Boolean.parseBoolean(br.readLine());

        System.out.println("Enter the phone number:");
        custPhone = Long.parseLong(br.readLine());
    }

    public void display()
    {
        System.out.println("ID of the customer: " + custID);
    	System.out.println("Name of the customer: " + custName);
    	System.out.println("Account number of customer: " + custAcNo);
    	System.out.println("Age of customer: " + custAge);
    	System.out.println("Min balance of customer: " + custMinBal);
        System.out.println("Balance of Customer: " + custBalance);
        System.out.println("Gender: " + custGender);
        System.out.println("PAN CARD: " + custPan);
        System.out.println("Phone: " + custPhone);
    }

    public void minBalInfo(short m){
        if(custMinBal < m){
            display();
        }
    }

    byte search(String name)
    {
        if(custName.equals(name))
        {
            this.display();
            return 1;
        }
        
        else
        return 0;
    }

    byte search(long acno)
    {
        if(custAcNo == acno)
        {
            this.display();
            return 1;
        }
        else
        return 0;
    }


    byte search(float balance, char gend)
    {
        if(custBalance >= balance && custGender == gend)
        {
            this.display();
            return 1;
        }
        else
        return 0;
    }
}



public class DataType{

    
    public static void main(String []args) throws IOException
    {
        byte choice, i;
        String name;
        long acno;
        float balance;
        char gend;
        boolean loop = true;
        //Customer []obj = new Customer[5];
        int myMinBal = Short.parseShort(args[0]);
    	BufferedReader br = new BufferedReader( new InputStreamReader( System.in ));
      /*  while(loop){
            System.out.println("\n1.Read");
            System.out.println("2.Display");
            System.out.println("3. Minimum Balance Display");
            System.out.println("4.Search");
            System.out.println("5.Exit");
            choice = Byte.parseByte(br.readLine());
            switch(choice){
                case 1: System.out.print("\033[H\033[2J");
                        for(i = 0; i < 5; i++)
                        {
                            obj[i] = new Customer();
                            obj[i].read();
                        }
                        break;

                case 2: System.out.print("\033[H\033[2J");
                        for(i = 0; i < 5; i++)
                            obj[i].display();
                        break;

                case 3: System.out.print("\033[H\033[2J");
                        for(i = 0; i < 5; i++)
                            obj[i].minBalInfo((short) myMinBal);

                        break;

                case 4: while(loop)
                        {
                            System.out.println("1.Search by name");
                            System.out.println("2.Search by account no");
                            System.out.println("3.Search by balance");
                            System.out.println("4.Exit");
                            System.out.println("Enter choice");
                            choice = Byte.parseByte(br.readLine());
                            switch(choice)
                            {
                                case 1:System.out.println("Enter name to search");
                                       name = br.readLine();
                                       obj[i].search(name);
                                       break;

                                case 2:System.out.println("Enter account number search");
                                       acno = Long.parseLong(br.readLine());
                                       obj[i].search(acno);
                                       break;
                                       
                                case 3:System.out.println("Enter balance");
                                       balance = Float.parseFloat(br.readLine());
                                       
                                       System.out.println("Enter gender to search");
                                       gend = (char) br.read();
                                       br.readLine();

                                       obj[i].search(balance,gend);
                                       break;

                                case 4:loop = false;
                                        break;

                                default : System.out.println("!!!Try again!!!");
                                          
                            }

                    
                        }
                        break;
                default: System.out.println("Try Again!\n");
            }
        }*/

Customer obj =new Customer("Piyush",1000111);
obj.display();

    }
}