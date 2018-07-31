import java.util.Scanner;

import java.io.*;
import java.lang.*;

class Customer
{
    int c_id;
    String c_name;
    byte c_age;
    long c_phone;
    String c_address;
    String c_email;
    char c_gender;
    String c_dob;
    String c_joindate;
    boolean member;
    float fine;
    short books_count;

    public void read()throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the customer name:");
        c_name = br.readLine();

        System.out.println("Enter customer id:");
        c_id = sc.nextInt();

        System.out.println("Enter customer age:");
        c_age = Byte.parseByte(br.readLine());

        System.out.println("Enter customer phone:");
        c_phone = Long.parseLong(br.readLine());

        System.out.println("Enter customer address:");
        c_address = br.readLine();

        System.out.println("Enter customer email:");
        c_email = br.readLine();

        System.out.println("Enter customer gender:");
        c_gender = (char) br.read();
        br.readLine();

        System.out.println("Enter customer dob:");
        c_dob = br.readLine();

        System.out.println("Enter customer joining date:");
        c_joindate = br.readLine();

        System.out.println("Is customer a member or not");
        member = Boolean.parseBoolean(br.readLine());
        

        System.out.println("Enter the total number of books taken:");
        books_count = Short.parseShort(br.readLine());

        System.out.println("Outstanding fine:");
        fine = Float.parseFloat(br.readLine());

    }

    public void display()
    {
        System.out.println("Name of the customer:" + c_name);
        System.out.println("Id of the customer:" + c_id);
        System.out.println("Age of the customer:" + c_age);
        System.out.println("Phone number of the customer:" + c_phone);
        System.out.println("Address of the customer:" + c_address);
        System.out.println("Email of the customer:" + c_email);
        System.out.println("Gender of the customer:" + c_gender);
        System.out.println("DOB of the customer:" + c_dob);
        System.out.println("Joining date of the customer:" + c_joindate);
        System.out.println("Member or not:" + member);
        System.out.println("Count of books:" + books_count);
        System.out.println("Outstanding fine:" + fine);
    }

    public void max_books(short max_bks)
    {
        if(books_count <= max_bks)
            System.out.println("Issue of books allowed");

        else
            System.out.println("Issue of books not allowed!!!");
        
    }


    byte search(int id)
    {
        if(c_id == id)
        {
            this.display();
            return 1;
        }
        
        else
        {
            System.out.println("No customer found!!!");
            System.exit(0);
            return 0;
            
        }
    }

}

class Employee
{
    String ename;
    int basics;
    float da;
    float hra;
    float pf;
    float incomeTax;
    float grossSalary;
    float deductions;
    double netSalary;

    public void read()throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter name of employee:");
        ename = br.readLine();

        System.out.println("Enter basic salary");
        basics = sc.nextInt();
    }


    double calculateSalary()
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

    public void display()
    {
        System.out.println("Name of employee:" + ename);
        System.out.println("Net Salary of employee:" + calculateSalary());
        
    }
}

public class Question1
{
    public static void main(String []args)throws IOException
    { 
        byte choice;
        int id;
        boolean loop = true;
        final int var = 2;
        short max_bks = 5;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        Scanner sc = new Scanner(System.in);

        Employee obj_emp = new Employee();

        Customer [] obj_cust = new Customer[var];
        byte i;
        //obj_cust.read();
        //obj_cust.display();

        while(loop)
        {
        	System.out.println("1.Read");
        	System.out.println("2.Display");
            System.out.println("3.Search");
            System.out.println("4.Max books allowed");
            System.out.println("5.Employee details");
            System.out.println("6.Exit");
        	System.out.println("Enter your choice:");


        	choice = Byte.parseByte(br.readLine());

        	switch(choice)
        	{
        		case 1:for(i = 0;i < var; i += 1)
        		        {
        		        	obj_cust[i] = new Customer();
        		        	obj_cust[i].read();
        		        }
        		        break;

        		case 2: for(i = 0;i < var; i += 1)
        		        {
        		        	obj_cust[i].display();
        		        }
        		        //obj_cust.display();
                        break;
                        
                case 3: while(loop)
                        {
                            System.out.println("1.Search customer");
                            System.out.println("2.Exit");
                            System.out.println("Enter choice");
                            choice = Byte.parseByte(br.readLine());
                            switch(choice)
                            {
                                case 1: System.out.println("Enter id to search");
                                        id = sc.nextInt();
                                        for(i = 0;i < var;i += 1)
                                        obj_cust[i].search(id);
                                        break;

                                case 2: loop = false;
                                        break;

                                default: System.out.println("!!!Try again!!!");
                            }

                        }
                

                case 4: System.out.println("Maximum issue of books allowed:" + max_bks);
                        for(i = 0;i < var;i += 1)
                        obj_cust[i].max_books(max_bks);
                        
                        break;
                        
                        
                case 5: obj_emp.read();
                        obj_emp.display();
                        break;



        		case 6: loop = false;
        		        break;

        		default : System.out.println("!!!!Wrong choice!!!!");
        		                                 
        	}
        }
    }
}