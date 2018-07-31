
import java.util.Scanner;

import java.io.*;

class Employee
{
    long e_id;
    String e_name;
    byte e_age;
    long e_phone;
    String e_address;
    String e_email;
    char e_gender;
    String e_dob;
    String e_joindate;
    float da;
    float basics;
    float hra;
    float pf;
    float incomeTax;
    float grossSalary;
    float deductions;
    double netSalary;
    private static int autoempid;  

    static
    {
        autoempid = 0;
    }
    
    public Employee()
    {
        autoempid++;
        e_id = autoempid;
       
       e_name = "Piyush";
       e_age = 21;
       e_dob = "27/05/1996";
       e_gender = 'M';
       e_email = "abcd@gmail.com";
       e_address = "Delhi";
       e_phone = 234568745;
       e_joindate = "01/01/2010";
    }

    public Employee(String n,String jdate)
    {
        autoempid += 1;
        e_id = autoempid;
        e_name = n;
        e_joindate = jdate;
        e_age = 21;
        e_email = "xyz@gmail.com";
        e_gender = 'M';
        e_address = "Mumbai";
        e_phone = (long) 1199733549;
    }



    public void read()throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter the employee name:");
        e_name = br.readLine();

        System.out.println("Enter employee age:");
        e_age = Byte.parseByte(br.readLine());

        System.out.println("Enter employee phone:");
        e_phone = Long.parseLong(br.readLine());

        System.out.println("Enter employee address:");
        e_address = br.readLine();

        System.out.println("Enter employee email:");
        e_email = br.readLine();

        System.out.println("Enter employee gender:");
        e_gender = (char) br.read();
        br.readLine();

        System.out.println("Enter employee dob:");
        e_dob = br.readLine();

        System.out.println("Enter employee joining date:");
        e_joindate = br.readLine();
    }

    public void display(String... var)
    {
        if(var.length > 0)
        {
            System.out.println("Id of the employee:\n\n" + e_id);
            System.out.println("Joining date of the employee:\n\n" + e_joindate);
        }
        else{
        System.out.println("Name of the employee: \n\n\n\n" + e_name);
        System.out.println("Id of the employee: \n\n"   + e_id);
        System.out.println("Age of the employee:\n\n" + e_age);
        System.out.println("Phone number of the employee:\n\n" + e_phone);
        System.out.println("Address of the employee:\n\n" + e_address);
        System.out.println("Email of the employee:\n\n" + e_email);
        System.out.println("Gender of the employee:\n\n" + e_gender);
        System.out.println("DOB of the employee:\n\n" + e_dob);
        System.out.println("Joining date of the employee:\n\n" + e_joindate);
        }
    }
    
    public double calculateSalary(float basics)
    {
        da = (float)(basics * 0.2) ;
        hra = (float)(basics * 0.15) ;
        pf = (float)(basics * 0.1) ;
        incomeTax = (float)(basics * 0.1);
        grossSalary = basics + da + hra;
        deductions = pf + incomeTax;
        netSalary = grossSalary - deductions;

        return netSalary;
    }

    byte search(long id)
    {
        if(e_id == id)
        {
            this.display();
            return 1;
        }
        
        else
        {
            System.out.println("No employee found!!!");
            System.exit(0);
            return 0;
            
        }
    }

    byte search(float basicSalary , char gend)
    {
        if(basics >= basicSalary && e_gender == gend)
        {
            this.display();
            return 1;
        }
        else
        return 0;
    }
}	

public class Question3
{
    public static void main(String []args)throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final int var = 2;
        String name,datejoined;
        long id;
        char gend;
        float basicSalary;

        System.out.println("Enter the name of employee:");
        name = br.readLine();

        System.out.println("Enter joining date:");
        datejoined = br.readLine();

        Employee [] obj_emp = new Employee[var];
        Employee obj = new Employee();

        Employee obj_parm = new Employee(name,datejoined);

        byte choice;
        byte i;

        float basic_sal = Float.parseFloat(args[0]);

        boolean loop = true;

        while(loop)
        {
            System.out.println("1.Read details:");
            System.out.println("2.Display details:");
            System.out.println("3.Display previous details:");
            System.out.println("4.Calculate salary:");
            System.out.println("5.Search employee:");
            System.out.println("6.Exit");
            System.out.println("Enter your choice:");
            choice = Byte.parseByte(br.readLine());
            switch(choice)
            {
                case 1: System.out.print("\033[H\033[2J");
                        for(i = 0;i < var; i += 1)
                        {
                            obj_emp[i] = new Employee();
                            obj_emp[i].read();
                        }
                        break;

                case 2: System.out.print("\033[H\033[2J");
                        for(i = 0;i < var; i += 1)
                        {
                            if(args.length > 1)
                            obj_emp[i].display(args[1]);

                            else
                            obj_emp[i].display();

                            
                        }
                        break;
                        
                case 3: System.out.print("\033[H\033[2J");
                        while(loop)
                        {
                            System.out.println("1.Previous datails entered");
                            System.out.println("2.Previous details after modification");
                            System.out.println("3.Exit");
                            System.out.println("Enter choice");
                            choice = Byte.parseByte(br.readLine());
                            switch(choice)
                            {
                                case 1: obj.display();
                                        break;        
                                        
                                case 2: obj_parm.display();
                                        break;
                                        
                                case 3: loop = false;
                                        break;
                                        
                                default : System.out.println("!!!Try again!!!");
                                            break;
                            }
                        }                                                      
                        
                case 4: System.out.print("\033[H\033[2J");
                        //for(i = 0; i < 5; i++)
                        System.out.println("Net Salary:" + obj.calculateSalary(basic_sal));
                        break;
                        
                case 5: while(loop)
                        {
                            System.out.println("1.Search by id");
                            System.out.println("2.Search by basic salary and gender");
                            System.out.println("3.Exit");
                            System.out.println("Enter choice");
                            choice = Byte.parseByte(br.readLine());
                            switch(choice)
                            {
                                case 1: System.out.println("Enter id to search");
                                        id = Long.parseLong(br.readLine());
                                        for(i = 0;i < var;i += 1)
                                        obj_emp[i].search(id);
                                        break;

                                case 2: System.out.println("Enter basic salary to search");
                                        basicSalary = Float.parseFloat(br.readLine());

                                        System.out.println("Enter gender to search");
                                        gend = (char) br.read();
                                        br.readLine();

                                        for(i = 0;i < var;i += 1)
                                        obj_emp[i].search(basicSalary,gend);
                                        break;

                                case 3: loop = false;
                                        break;
                                        
                                default : System.out.println("!!!Try again!!!");
                            }
                        }                                        
                                            
                        
                case 6: loop = false;
                        break;
                        
                default : System.out.println("!!!Try again!!!");                                            
            }


        }
    }
}