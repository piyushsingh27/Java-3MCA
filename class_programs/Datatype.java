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
    private int custPhone;

    public void read()throws IOException
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
        custPhone = (int) br.read();
    }

    public void display()
    {
    	System.out.println("Name of the customer:" + custName);
    	System.out.println("Account number of customer:" + custAcNo);
    	System.out.println("Age of customer:" + custAge);
    	System.out.println("Min balance of customer:" + custMinBal);
    	System.out.println("Balance of customer:" + custBalance);
    	System.out.println("Gender of Customer:" + custGender);
    	System.out.println("Pan number of Customer:" + custPan);
    	System.out.println("Phone Number of Customer:" + custPhone);
    } 
}

public class Datatype
{
	public static void main(String []args)throws IOException
	{
		Customer obj = new Customer();

		obj.read();
		obj.display();
	}
}
