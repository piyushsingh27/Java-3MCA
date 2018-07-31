import java.io.*;
class Account
{
    protected String custName;
    private int accNo;
    public Account()
    {
        custName = "Demo Customer";
        accNo = 1;
    }

    public Account(String name, int acc)
    {
        this.custName = name;
        accNo = acc;
    }
    public void read()
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try
        {
            System.out.println("Customer Name: ");
            custName  = br.readLine();
            System.out.println("Account No. : ");
            accNo = Integer.parseInt(br.readLine());
        }
        catch( Exception e )
        {
            System.out.println(e.toString());
        }
        
    }
    public void display()
    {
        System.out.println("Customer Name: " + custName);
        System.out.println("Account No. : " + accNo);
    }       
}


class LoanAccount extends Account
{
    private float intRate;
    private int amountSanc;
    
    public LoanAccount()
    {
        intRate = (float)9.0;
        amountSanc = 50000;       
    }
    public LoanAccount(float rate, int amount, String Naam, int acc)
    { 
        super(Naam, acc);
        intRate = rate;
        amountSanc = amount;  
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
        super.display();
        //System.out.println("Customer Name: " + custName);
        System.out.println( "Int Rate: "+ intRate );
        System.out.println( "Amount Sanction.: "+ amountSanc );
    }     
}

class CarLoan extends LoanAccount{
    private String carCompany;
    private String carModel;
    private long carCost;

    public CarLoan(){
        carCompany = "FORD";
        carModel = "MUSTANG GT 500";
        carCost = 5000000;
    }
    public void read(){
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            super.read();
            System.out.println("Enter Car Company");
            carCompany = br.readLine();
            System.out.println("Enter Car Model");
            carModel = br.readLine();
            System.out.println("Enter Car Cost");
            carCost = Long.parseLong(br.readLine());
        }
        catch( Exception e )
        {
            System.out.println(e.toString());
        }
    }
    public void display(){
        super.display();
        System.out.println("Customer Name: " + custName);
        System.out.println( "Car Company: "+ carCompany );
        System.out.println( "Car Model: "+ carModel );
        System.out.println( "Car Cost: "+ carCost );      
    }   
}

public class Bank{
    public static void main(String[] args) {
        // Account obj = new Account();
        // obj.readCustomerData();
        // obj.displayCustomerData();
        // LoanAccount obj_LC = new LoanAccount();
        // obj_LC.read();
        // obj_LC.display();
        // obj.readLoanDetails();
        // obj.displayLoanDetails();
        // CarLoan obj = new CarLoan();
        // System.out.println(obj.custName);
        // obj.read();
        // obj.display(); 
        
        // System.out.println(obj.custName);
        // Account obj = new Account("Aekansh Partani");
        // obj.display();

        LoanAccount obj = new LoanAccount((float)5.52, 500, "MERA NAAM", 54547);
        obj.display();
        CarLoan ob = new CarLoan();
        ob.display();
    }
}