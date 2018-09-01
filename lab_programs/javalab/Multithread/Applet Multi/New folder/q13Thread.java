import java.lang.*;
import java.io.*;
import java.util.*;
class Prime extends Thread
{
    int i =0;
    int num =0;
    //Empty String
    String  primeNumbers = "";
    int count1 = 0;

	public void run()
	{
		try
		{
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
                    count1 += 1;
                }	

                /*System.out.println("Count of prime Numbers:");
                System.out.println(counter);*/
            
            }
			/*for(int i=1;i<=10000;i++)
			{
				if(i==2||i==3||i==5||i==7)
				{
					System.out.println ("Prime No.= "+i);
				}
				Thread.sleep(500);
			}*/
		}
        catch (Exception e){}
        System.out.println("Prime numbers from 1 to 10000 are :");
        System.out.println(primeNumbers);

        System.out.println("Count:" + count1);
        System.out.println();
        
        System.out.println();

	}
}
class Palindrome extends Thread
{
    int n, b, rev = 0;
    int limit=10000;
    int count=0;
	public void run()
	{
		try
		{
            System.out.print("Palindrome numbers from 1 to N:");
            System.out.println();
            System.out.println();
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
                    count += 1;
			    }
                rev = 0;
            }
			/*for(int i=1;i<=10;i++)
			{
				if(i==4||i==6||i==8||i==9||i==10)
				{
					System.out.println ("Non-Prime No.= "+i);
				}
				Thread.sleep(500);
			}*/
		}
        catch (Exception e){}
        System.out.println();
        System.out.println("Count:" + count);
        System.out.println();
	}
}
class q13Thread
{
	public static void main(String args[])
	{
		new Prime().start();
		new Palindrome().start();
	}
}	