import java.io.*;
class Account
{
	private String custName;
	private int accNo;
	public Account()
	{
    		custName = "Demo Customer";
    		accNo = 1;
	}
	//public void readData()
	public void read()
	{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	try
		{
        	System.out.println("Customer Name:");
        	custName  = br.readLine();
        	System.out.println("Account No.:");
        	accNo = Integer.parseInt(br.readLine());
    	}
    	catch( Exception e )
    	{
			System.out.println(e.toString());
    	}
	}
	public void displayData()
	{
    	System.out.println("Customer Name:" + custName);
    	System.out.println("Account No.:" + accNo);
	}  	 
}


class LoanAccount extends Account
{
	private float intRate;
	private int amountSanc;
    
	public LoanAccount()
	{
    	intRate = -1;
    	amountSanc = -1;  	 
	}
	public void read()
	{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 	   	try
    	{
        	super.read();
        	System.out.println("Int Rate:");
        	intRate = Float.parseFloat(br.readLine());
        	System.out.println("Amount Sanction.:");
        	amountSanc = Integer.parseInt(br.readLine());
    	}
    	catch( Exception e )
    	{
        		System.out.println(e.toString());
    	}
	}
    
	public void display()
	{
    	displayData();
    	System.out.println( "Int Rate: "+ intRate );
		System.out.println( "Amount Sanction.: "+ amountSanc );
		//System.out.println("Customer Name:" + custName);
	}	 
}

class CarLoan extends LoanAccount
{
   private String carCompany;
   private String carModel;
   private long carCost;
   
   public CarLoan()
   {
    	carCompany = "Honda";
    	carModel = "city";
    	carCost  = 100000 ;
  }

//public void readCarDetails()
public void read()
{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	try
    	{
        		super.read();
        	System.out.println("Car Company:");
        		carCompany = br.readLine();
        	System.out.println("Car Model.:");
        	carModel = br.readLine();
        	System.out.println("Car Cost.:");
        	carCost = Integer.parseInt(br.readLine());
    	}
    	catch( Exception e )
    	{
        		System.out.println(e.toString());
    	}
}
    
public void displayCarDettails()
{
display();
//displayData();
System.out.println("Car Company: "+carCompany);
System.out.println("Car Model.:"+carModel);
System.out.println("Car Cost.: "+carCost);
}	 
}

public class Inheritance
{
	public static void main(String args[])
	{
		Account obj = new Account();
		//LoanAccount obj = new LoanAccount();
		//CarLoan obj = new CarLoan();
		//obj.read();
		//obj.displayData();	

		LoanAccount obj_LA = new LoanAccount();
		//obj_LA.read();
		//obj_LA.display();

		CarLoan obj_CL = new CarLoan();
		obj_CL.read();
		obj_CL.displayCarDettails();


	}
}


































































































































































































































































































