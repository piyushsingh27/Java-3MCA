import java.io.*;

class NumberValidation
{
    byte flag;
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
            boolean flag;
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Enter The Name Of the Student:-");
            name = br.readLine();
            do
            {
                System.out.print("Enter the Mobile Number:-");
                mobileNo = br.readLine();
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
            br.readLine();
            System.out.print("Enter the Course:-");
            course  = br.readLine();
            System.out.print("Enter the Semester:-");
            semester = (br.readLine());
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
    public void read()
    {
        boolean flag;
        try
        {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Enter The Name Of the Teacher:-");
            name = br.readLine();
            do
            {
                System.out.print("Enter the Mobile Number:-");
                mobileNo = br.readLine();
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
            
            System.out.print("Enter the Department Name:");
            departmentName = br.readLine(); 
            System.out.print("Enter the Reference Book Name:");
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
        System.out.println("Reference Book Issed:" +referenceBookName);
   
    }


}
class TryCatch1
{
    public static void main(String[] args)throws Exception {
        byte no,choice;
        boolean loop = true;
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("******************************************************************");
		System.out.print("How Many Time You Want To  enter the details:-");
		no = Byte.parseByte(in.readLine());
        System.out.println("******************************************************************");
        try
        {
            System.out.println("1.Enter all the details for student");
            System.out.println("2.Enter all the details for Teacher");
            System.out.print("Enter Your Choice:-");
            choice = Byte.parseByte(in.readLine());
            switch(choice)
            {
                case 1:
                {
                    Student s[] = new Student[no];
                    do{
                    System.out.println("1.Enter All The Detalis");
                    System.out.println("2.Display All The Detalis");
                    System.out.println("3.Exit");
                     System.out.print("Enter Your Choice:-");
                    choice = Byte.parseByte(in.readLine());
                    switch(choice)
                    {
                        case 1: 
                        {
                            for(int i = 0; i< no; i++)
                            {
                                System.out.println("******************************************************************");
							    System.out.println("Enter the details for the Student"+(i+1));
                                System.out.println("******************************************************************");
                                s[i] = new Student();
                                s[i].read();
                            }

                        }
                        break;
                        case 2:
                        {
                            for(int i = 0; i< no; i++)
                            {
                                System.out.println("******************************************************************");
                                System.out.println("The details for the Student"+(i+1));
                                System.out.println("******************************************************************");
                               s[i].display();
                            }
                        }
                        break;
                        case 3:
                        {
                            loop = false;
                        } 
                        break;
                        default:
                            throw new Exception("Invalid Choice");

                    }
                }while(loop);
            }
                break;
                case 2:
                {
                    Teacher t[] = new Teacher[no];
                    do{
                    System.out.println("1.Enter All The Detalis");
                    System.out.println("2.Display All The Detalis");
                    System.out.println("3.Exit");
                    System.out.print("Enter Your Choice:-");
                    choice = Byte.parseByte(in.readLine());
                    switch(choice)
                    {
                        case 1: 
                        {
                            for(int i = 0; i< no; i++)
                            {
                                System.out.println("******************************************************************");
							    System.out.println("Enter the details for the Teacher"+(i+1));
                                System.out.println("******************************************************************");
                                t[i] = new Teacher();
                                t[i].read();
                            }

                        }
                        break;
                        case 2:
                        {
                            for(int i = 0; i< no; i++)
                            {
                                System.out.println("******************************************************************");
                                System.out.println("The details for the Teacher"+(i+1));
                                System.out.println("******************************************************************");
                                t[i].display();
                            }
                        }
                        break;
                        case 3:
                        {
                            loop = false;
                        } 
                        break;
                        default:
                            throw new Exception("Invalid Choice");
                    }
                }while(loop);
                }
                break;
                default:
            }

        }
        catch(ArrayIndexOutOfBoundsException e)
        {
            System.out.print(e.toString());
        }        
        catch(NullPointerException e)
        {
            System.out.print(e.toString());
        }
        catch(RuntimeException e)
        {
            System.out.print(e.toString());
        }
        catch(Exception e)
        {
            System.out.print(e.toString());
        }
        finally
        {
            System.out.print("Program Ended ");
        }
      
        
    }

}