import java.io.*;

class PrimeNumbers
{
   //public static void main(String []args)
   public synchronized void prime()
   {		
       int i =0;
       int num =0;
       //Empty String
       String  primeNumbers = "";

       for (i = 1; i <= 10000; i++)         
       { 		  	  
          int counter=0; 	  
          for(num =i; num>=1; num--)
	      {
                if(i%num==0)
	            {
 		            counter = counter + 1;
	            }
	       }
	        if (counter ==2)
	        {
	            //Appended the Prime number to the String
	            primeNumbers = primeNumbers + i + " ";
            }	
            
            try
            {
                Thread.sleep(400);
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
       }	
      System.out.println("Prime numbers from 1 to 10000 are :");
      System.out.println(primeNumbers);
   }
}

class Pallindrome 
{

    //public static void main(String[] args) 
    public synchronized void palindrome()
	{
		int n, b, rev = 0;
		int limit=10000;
		System.out.print("Palindrome numbers from 1 to N:");
		for (int i = 1; i <= limit; i++)
		{
			n = i;
			while (n > 0)
			{
				b = n % 10;
				rev = rev * 10 + b;
				n = n / 10;
			}
			if (rev == i)
			{
				System.out.print(i + " ");
			}
            rev = 0;
            
            try
            {
                Thread.sleep(400);
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
		}
		
	}

}

class MyThread1 extends Thread
{
    PrimeNumbers pn;
    MyThread1(PrimeNumbers pn)
    {
        this.pn = pn;
    }

    public void run()
    {
        pn.prime();
    }
}

class MyThread2 extends Thread
{
    Pallindrome p;
    MyThread2(Pallindrome p)
    {
        this.p = p;
    }

    public void run()
    {
        p.palindrome();
    }
}


public class Synchronization1
{
    public static void main(String []args)
    {
        PrimeNumbers obj1 = new PrimeNumbers();
        Pallindrome obj2 = new Pallindrome();

        MyThread1 t1 = new MyThread1(obj1);
        MyThread2 t2 = new MyThread2(obj2);

        t1.start();
        t2.start();
    }
}