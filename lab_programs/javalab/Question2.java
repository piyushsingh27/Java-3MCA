
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
    
    Employee()
    {
       e_id = autoempid;
       autoempid++;
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
            System.out.println("Joining date of the employee:\n" + e_joindate);
        }
        else{
            System.out.println("-----------------------------------------");
            System.out.println("Name of the employee:\n\n" + e_name);
            System.out.println("Id of the employee:\n" + e_id);
            System.out.println("Age of the employee:\n" + e_age);
        System.out.println("Phone number of the employee:\n" + e_phone);
        System.out.println("Address of the employee:\n" + e_address);
        System.out.println("Email of the employee:\n" + e_email);
        System.out.println("Gender of the employee:\n" + e_gender);
        System.out.println("DOB of the employee:\n" + e_dob);
        System.out.println("Joining date of the employee:\n" + e_joindate);
        System.out.println("--------------------------------------------");
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
}	

public class Question2
{
    public static void main(String []args)throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final int var = 2;

        Employee [] obj_emp = new Employee[var];
        Employee obj = new Employee();

        byte choice;
        byte i;

        float basic_sal = Float.parseFloat(args[0]);

        boolean loop = true;

        while(loop)
        {
            System.out.println("1.Read details:");
            System.out.println("2.Display details:");
            System.out.println("3.Calculate salary:");
            System.out.println("4.Exit");
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
                        //obj_cust.display();
                        break;     
                        
                case 3: System.out.print("\033[H\033[2J");
                        //for(i = 0; i < 5; i++)
                        System.out.println("Net Salary:" + obj.calculateSalary(basic_sal));
                        break;   
                        
                case 4: loop = false;
                        break;
                        
                default : System.out.println("!!!Try again!!!");                                            
            }


        }








    }
}