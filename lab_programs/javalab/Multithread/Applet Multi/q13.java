import java.lang.*;
import java.io.*;
import java.util.*;
class Prime extends Thread
{
	public void run()
	{
		try
		{
			for(int i=1;i<=10;i++)
			{
				if(i==2||i==3||i==5||i==7)
				{
					System.out.println ("Prime No.= "+i);
				}
				Thread.sleep(500);
			}
		}
		catch (Exception e){}
	}
}
class notPrime extends Thread
{
	public void run()
	{
		try
		{
			for(int i=1;i<=10;i++)
			{
				if(i==4||i==6||i==8||i==9||i==10)
				{
					System.out.println ("Non-Prime No.= "+i);
				}
				Thread.sleep(500);
			}
		}
		catch (Exception e){}
	}
}
class q13Thread
{
	public static void main(String args[])
	{
		new Prime().start();
		new notPrime().start();
	}
}	