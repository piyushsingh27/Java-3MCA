import java.io.*;
interface Deposit
{
	 void deposit(float amt);
}
interface Withdraw
{
public void withdraw();

}


abstract class Account
{
	String custName;
	private int accno;
	abstract float interestCalc();
	private float balance;
	Account()
	{
		custName="";
		accno=-1;
		balance=0;
	}
	
	public void read()
	{
		InputStreamReader isr=new InputStreamReader(System.in);
		BufferedReader br=new BufferedReader(isr);
		try
		{
		System.out.println("\nEnter the Customer Name");
		custName=br.readLine();
		System.out.println("\n Enter the Account Number");
		accno=Integer.parseInt(br.readLine());
		System.out.println("\nEnter the Balance");
		balance=Float.parseFloat(br.readLine());
		  }
	   catch(Exception e)
		   {
		   System.out.println(e.toString());
		   }

	}
	public void disp()
	{
		System.out.println("ACustomer Name ="+custName);
		System.out.println("Account Number ="+accno);
		System.out.println("Balance Amount ="+balance);

	}

	public float getBalance()
	{
	
	return balance;
	}
	public void setBalance(float b)
	{
	balance=b;
	}

}

class SavingAccount extends Account implements Withdraw,Deposit
{
	private float minbal;
	
	public void read()
	 {
    	   InputStreamReader isr=new InputStreamReader(System.in);
		   BufferedReader br=new BufferedReader(isr);
    	   try
			{
			super.read();
			System.out.println("Enter the minimum balance");
			minbal=Float.parseFloat(br.readLine());
			}
			catch(Exception e)
		   {
		   System.out.println(e.toString());
		   }
  	 }
		  
	float interestCalc()
	   {
		float inte=(float)0.04*minbal;			 
	    return inte;
		}

	public void disp()
	{
	super.disp();
	//accesss specifiers
	System.out.println("Minimum balance : "+minbal);
	
	}
	public void withdraw()
	{ 
	int amt=0;
	InputStreamReader isr=new InputStreamReader(System.in);
		   BufferedReader br=new BufferedReader(isr);
    	   
		System.out.println("Enter the amount to withdraw: ");
try
{
		amt=Integer.parseInt(br.readLine());
		

}
catch(Exception e)
{

}
		//float b=getBalance();
		if(getBalance()-amt>minbal)
		{
		
		setBalance(getBalance()-amt);

		
		}
		else
		{
			System.out.println("Sorry ! Amount exceeds minimum balance");
	
        }
	

	}
	public void deposit(float a)
	{
	
     setBalance(getBalance()+a);	
    }

}
public class Interface
{
	public static void main(String [] args)
	{
	SavingAccount ac=new SavingAccount();
	ac.read();
	ac.disp();
    ac.withdraw();
    Withdraw obj = new SavingAccount();
    obj.read();
	ac.disp();

  }
} 