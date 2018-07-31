import java.util.Scanner;
import java.io.*;

class Customer
{
    long c_id;
    String c_name;
    byte c_age;
    long c_phone;
    String c_address;
    String c_email;
    char c_gender;
    String c_dob;
    String c_joindate;

    public void read()throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter the customer name:");
        c_name = br.readLine();

        System.out.println("Enter customer id:");
        c_id = Long.parseLong(br.readLine());

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
    }

}

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

    public void read()throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter the employee name:");
        e_name = br.readLine();

        System.out.println("Enter employee id:");
        e_id = Long.parseLong(br.readLine());

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

    public void display()
    {
        System.out.println("Name of the employee:" + e_name);
        System.out.println("Id of the employee:" + e_id);
        System.out.println("Age of the employee:" + e_age);
        System.out.println("Phone number of the employee:" + e_phone);
        System.out.println("Address of the employee:" + e_address);
        System.out.println("Email of the employee:" + e_email);
        System.out.println("Gender of the employee:" + e_gender);
        System.out.println("DOB of the employee:" + e_dob);
        System.out.println("Joining date of the employee:" + e_joindate);
	}
}	

    class Book_details
    {
    	long book_id;
    	String book_name;
    	String book_author;
    	String store_loc;
    	String shelf_loc;
    	String book_type;
    	int edition;
    	short publish_date;
    	String pub_name;
    	int price;
    	byte stock;


    	public void read()throws IOException
    	{
        	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        	System.out.println("Enter the book name:");
        	book_name = br.readLine();

        	System.out.println("Enter book id:");
        	book_id = Long.parseLong(br.readLine());

        	System.out.println("Enter book author:");
        	book_author = br.readLine();

        	System.out.println("Enter store location:");
        	store_loc = br.readLine();

        	System.out.println("Enter shelf location:");
        	shelf_loc = br.readLine();

        	System.out.println("Enter book type:");
        	book_type = br.readLine();

        	System.out.println("Enter book edition:");
        	edition = (int) br.read();
      

        	System.out.println("Enter publish year:");
        	publish_date = Short.parseShort(br.readLine());


        	System.out.println("Enter publisher name:");
        	pub_name = br.readLine();

        	System.out.println("Enter price of book");
        	price = (int) br.read();

        	System.out.println("Enter stocks of book");
        	stock = Byte.parseByte(br.readLine());
    	}

    	public void display()
    	{
        	System.out.println("Name of the book:" + book_name);
        	System.out.println("Id of the book:" + book_id);
        	System.out.println("Author of the book:" + book_author);
        	System.out.println("Store location:" + store_loc);
        	System.out.println("Shelf location:" + shelf_loc);
        	System.out.println("Book type:" + book_type);
        	System.out.println("Edition:" + edition);
        	System.out.println("Publish year:" + publish_date);
        	System.out.println("Publisher name:" + pub_name);
        	System.out.println("Price of book:" + price);
        	System.out.println("Stocks of book left:" + stock);
    	}

    }

class Storeinfo
{
	//store_id, name, sub_name, address, phone, email
	long store_id;
	String store_name;
	String sub_name;
	String address;
	int phone;
	String email;

	public void read()throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


		System.out.println("Enter Store id:");
		store_id = Long.parseLong(br.readLine());

		System.out.println("Enter Store name:");
		store_name = br.readLine();

		System.out.println("Enter Sub name:");
		sub_name = br.readLine();

		System.out.println("Enter address:");
		address = br.readLine();

		System.out.println("Enter phone number:");
		phone = (int) br.read();

		System.out.println("Enter Store email:");
		email = br.readLine();
	}

	public void display()
	{
		System.out.println("Store id:" + store_id);
		System.out.println("Store name:" + store_name);
		System.out.println("Sub name:" + sub_name);
		System.out.println("Store address:" + address);
		System.out.println("Store phone:" + phone);
		System.out.println("Store email:" + email);

	}
}    




    

public class Ques1
{
    public static void main(String []args)throws IOException
    { 
    	byte choice;
    	boolean loop = true;

    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Customer [] obj_cust = new Customer[5];
        byte i;
        //obj_cust.read();
        //obj_cust.display();

        while(loop)
        {
        	System.out.println("1.Read");
        	System.out.println("2.Display");
        	System.out.println("3.Exit");
        	System.out.println("Enter your choice:");


        	choice = Byte.parseByte(br.readLine());

        	switch(choice)
        	{
        		case 1:for(i = 0;i < 5; i += 1)
        		        {
        		        	obj_cust[i] = new Customer();
        		        	obj_cust[i].read();
        		        }
        		        
        		        break;

        		case 2: for(i = 0;i < 5; i += 1)
        		        {
        		        	obj_cust[i].display();
        		        }
        		        //obj_cust.display();
        		        break;

        		case 3: loop = false;
        		        break;

        		default : System.out.println("!!!!Wrong choice!!!!");
        		                                 
        	}
        }

        Employee obj_emp = new Employee();

        obj_emp.read();
        obj_emp.display();


        Book_details obj_books = new Book_details();

        obj_books.read();
        obj_books.display();
    }
} 