
import java.util.Scanner;

import java.io.*;

class Request
{
    long req_id;
    long cust_id;
    String store_name;
    String book_name;
    String author;
    String publisher;
    long edition;
    String type;
    static long sreq_id;

    static
    {
        sreq_id = 0;
    }

   

    public Request()
    {
        sreq_id += 1;
        req_id = sreq_id;
        cust_id = 1234;
        store_name ="ABC";
        book_name = "Hounds of Baskerville";
        author = "William Shakespeare";
        publisher = "XUZ";
        edition = 3;
        type = "Fiction";
    }

    public Request(long c_id,String st_name)
    {
        sreq_id += 1;
        req_id = sreq_id;
        cust_id = c_id;
        store_name =st_name;
        book_name = "Hounds of Baskerville";
        author = "William Shakespeare";
        publisher = "XUZ";
        edition = 3;
        type = "Fiction";
    }

    public static void show()
    {
        System.out.println("Last request id:" + sreq_id);
        long count = sreq_id;
        System.out.println("Number of requests made:" + count);
    }


    public void read()throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter the customer id:");
        cust_id = Long.parseLong(br.readLine());

        System.out.println("Enter the store name:");
        store_name = br.readLine();

        System.out.println("Enter the book name:");
        book_name = br.readLine();

        System.out.println("Enter the author name:");
        author = br.readLine();

        System.out.println("Enter publisher of book:");
        publisher = br.readLine();

        System.out.println("Enter the book edition:");
        edition = Long.parseLong(br.readLine());

        System.out.println("Enter type of book:");
        type = br.readLine();
    }


    public void display()
    {
        System.out.println("Request id:" + req_id);
        System.out.println("Customer id:" + cust_id);
        System.out.println("Store name:" + store_name);
        System.out.println("Book name:" + book_name);
        System.out.println("Author name:" + author);
        System.out.println("Publisher name:" + publisher);
        System.out.println("Editon of book:" + edition);
        System.out.println("Type of book:" + type);
    }

    byte search(long id)
    {
        if(cust_id == id)
        {
            this.display();
            return 1;
        }
        
        else
        {
            System.out.println("No request found!!!");
            System.exit(0);
            return 0;
            
        }
    }

    byte search(long id, long c_id)
    {
        if(req_id == id && cust_id == c_id)
        {
            this.display();
            return 1;
        }

        else
        {
            System.out.println("No request found!!!");
            System.exit(0);
            return 0;
        }
    }
}

public class Static
{
    public static void main(String []args)throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final int var = 2;
        String st_name;
        long id,c_id;
        //char gend;
        //float basicSalary;

        System.out.println("Enter the new customer id:");
        c_id = Long.parseLong(br.readLine());

        System.out.println("Enter new store name:");
        st_name = br.readLine();

        Request [] obj_req = new Request[var];
        Request obj = new Request();

        Request obj_parm = new Request(c_id,st_name);

        byte choice;
        byte i;

        //float basic_sal = Float.parseFloat(args[0]);

        boolean loop = true;

        while(loop)
        {
            System.out.println("1.New Request:");
            System.out.println("2.Display requests:");
            System.out.println("3.Display requests already made:");
            System.out.println("4.Search request made:");
            System.out.println("5.Number of requests received:");
            System.out.println("6.Exit");
            System.out.println("Enter your choice:");
            choice = Byte.parseByte(br.readLine());
            switch(choice)
            {
                case 1: System.out.print("\033[H\033[2J");
                        for(i = 0;i < var; i += 1)
                        {
                            obj_req[i] = new Request();
                            obj_req[i].read();
                        }
                        break;

                case 2: System.out.print("\033[H\033[2J");
                        for(i = 0;i < var; i += 1)
                        {
                            obj_req[i].display();    
                        }
                        break;
                        
                case 3: System.out.print("\033[H\033[2J");
                        do
                        {
                            System.out.println("1.Previous requests entered");
                            System.out.println("2.Previous requests after modification");
                            System.out.println("3.Exit");
                            System.out.println("Enter choice");
                            choice = Byte.parseByte(br.readLine());
                            switch(choice)
                            {
                                case 1: obj.display();
                                        break;        
                                        
                                case 2: obj_parm.display();
                                        break;
                                        
                                //case 3: loop = false;
                                  //      break;
                                        
                                default : System.out.println("!!!Try again!!!");
                                            break;
                            }
                        }
                        while(choice != 3);                                                      
                        
                case 4: do
                        {
                            System.out.println("1.Search by customer id");
                            System.out.println("2.Search by request id");
                            System.out.println("3.Exit");
                            System.out.println("Enter choice");
                            choice = Byte.parseByte(br.readLine());
                            switch(choice)
                            {
                                case 1: System.out.println("Enter id to search");
                                        id = Long.parseLong(br.readLine());
                                        for(i = 0;i < var;i += 1)
                                        obj_req[i].search(id);
                                        break;

                                case 2: System.out.println("Enter id to search");
                                        id = Long.parseLong(br.readLine());

                                        System.out.println("Enter c_id to search");
                                        c_id = Long.parseLong(br.readLine());

                                        for(i = 0;i < var;i += 1)
                                        obj_req[i].search(id,c_id);
                                        break;

                               // case 3: loop = false;
                                 //       break;
                                        
                                default : System.out.println("!!!Try again!!!");
                                            break;
                            }
                        }   
                        while(choice != 3);                                     
                    
                case 5: Request.show();
                        break;

                        
                case 6: loop = false;
                        break;
                        
                default : System.out.println("!!!Try again!!!");                                            
            }


        }
    }
}