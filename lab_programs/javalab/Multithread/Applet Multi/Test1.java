import java.io.*;

class Test1
{
   public static void main(String []args)
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
       }	
       System.out.println("Prime numbers from 1 to 10000 are :");
       System.out.println(primeNumbers);
   }
}

/*
class Palindrome 
{

	public static void main(String[] args) 
	{
		int n, b, rev = 0;
		int limit=50;
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
		}
		
	}

}*/