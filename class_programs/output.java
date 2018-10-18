import java.io.*;

class test implements Serializable
{
	String x;
	int a;
	
	public void read()throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		x = br.readLine();
		a = Integer.parseInt(br.readLine());
	}
}

public class output
{
	public static void main(String []args)throws Exception
	{
		FileOutputStream f = new FileOutputStream("abc.txt");
		String s = "Hello Anurag";
		byte []arr = s.getBytes();
		f.write(arr);
		
		String s1 = "Legend Murga";
		byte []arr2 = s1.getBytes();
		f.write(arr2,0,6);
		f.close();
		
		FileInputStream fr = new FileInputStream("abc.txt");
		System.out.println("Available bytes:" + fr.available());
		System.out.println("Read Byte:" + (char)fr.read());
		fr.skip(2);
		byte []arr1 = new byte[7];
		fr.read(arr1);
		System.out.println("Read data:" + new String(arr1,0,6));
		System.out.println("Available bytes:" + fr.available());
		fr.close();
		
		try
		{
			FileOutputStream filew = new FileOutputStream("new.txt");
			ObjectOutputStream objout = new ObjectOutputStream(filew);
			
			test a = new test();
			a.read();
			
			objout.writeObject(a);	
			objout.close();
			filew.close();
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
		}
		
		try
		{
			FileInputStream filer = new FileInputStream("new.txt");
			ObjectInputStream objin = new ObjectInputStream(filer);
		
			test c1 = new test();
		
		
			c1 = (test)objin.readObject();
			System.out.println("String:" + c1.x);
			System.out.println("Integer:" + c1.a);

			objin.close();
			filer.close();
		}
		catch(Exception e)
		{
			
		}
		
		
	}
}