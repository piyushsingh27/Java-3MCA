import java.io.*;
import java.util.Scanner;

class NumberValidation
{

    static boolean numberOrNot(String input,byte flag )
    {
		try
		{
			if(1 == flag)
			Integer.parseInt(input);
			else if(2 == flag)
			Long.parseLong(input);
			else if(3 == flag)
			Float.parseFloat(input);
		}
		catch(NumberFormatException ex)
		{
			return false;
		}
		return true;
    }
}

abstract class Issuer
{
    public String id;
    public  String name;
    public String mobileNo;
    public String departmentName;
    public  char gender;
    public boolean flag = true;

    Issuer()
    {

    }
    abstract public void read();
    abstract public void display();

}
class Student extends Issuer
{
    private String course;
    private String semester;
   
    
   
    public void read()
    {
        try
        {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            Scanner in = new Scanner(System.in);
            name = br.readLine();
            do
            {
                System.out.print("Enter the Mobile Number:-");
                mobileNo = in.next();
                flag = NumberValidation.numberOrNot(mobileNo,(byte)2);
                if(!flag)
                {
                    flag = true;
                    System.out.println("Input Numbers Only");
                }
                else
                {
                    flag = false;
                }
            }while(flag);
            System.out.print("Enter Gender(M|F):-");
            gender = (char)br.read();
            System.out.print("Enter the Course:-");
            course  = br.readLine();
            System.out.print("Enter the Semester:-");
            semester = br.readLine();
            System.out.print("Enter the Department Name");
            departmentName = br.readLine(); 
                    
        }
        catch(IOException e)
        {
            System.out.print(e.toString());
        }
    }
    public void display()
    {
        System.out.println("Employee Number:-"+id);
        System.out.println("Student Name:-"+name);
        System.out.println("Course:-"+departmentName);
        System.out.println("Gender:-"+gender);
        System.out.println("Mobile Number:-"+mobileNo);
        System.out.println("Course1:-"+course);
        System.out.println("Semester:-"+semester);
    }

}
class Teacher extends Issuer
{
    private String referenceBookName;
    String course;
    public void read()
    {
        try
        {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            Scanner in = new Scanner(System.in);
            name = br.readLine();
            do
            {
                System.out.print("Enter the Mobile Number:-");
                mobileNo = in.next();
                flag = NumberValidation.numberOrNot(mobileNo,(byte)2);
                if(!flag)
                {
                    flag = true;
                    System.out.println("Input Numbers Only");
                }
                else
                {
                    flag = false;
                }
            }while(flag);
            System.out.print("Enter Gender(M|F):-");
            gender = (char)br.read();
            System.out.print("Enter the Course:-");
            course  = br.readLine();
            System.out.print("Enter the Department Name");
            departmentName = br.readLine(); 
            System.out.print("Enter the Reference Book Name");
            referenceBookName = br.readLine();
        }
        catch(IOException e)
        {
            System.out.print(e.toString());
        }
    }   
    public void display()
    {
        System.out.println("Employee Number:-"+id);
        System.out.println("Faculty Name:-"+name);
        System.out.println("Course:-"+departmentName);
        System.out.println("Gender:-"+gender);
        System.out.println("Mobile Number:-"+mobileNo);
   
    }


}
class TryCatch1
{
    public static void main(String[] args) {
        try
        {
        Student s = new Student();
        s.read();
        s.display();
        }
        catch(NullPointerException e)
        {
            System.out.print(e.toString());
        }
        catch(RuntimeException e)
        {
            System.out.print(e.toString());
        }
        catch(InterruptedException e)
        {
            System.out.print(e.toString());
        }
        catch(NoSuchMethodException e )
        {
            System.out.print(e.toString());
        }
        
    }

}
//TryCatch1.java
//Displaying TryCatch1.java.