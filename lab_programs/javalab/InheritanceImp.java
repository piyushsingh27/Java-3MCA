import java.io.*;
import java.util.Scanner;

class Book
{
    long book_id;
    String publisher;
    String published_date;

    public Book()
    {
        book_id = 0011;
        publisher = "ABC";
        published_date = "17/06/2009";
    }

    public void read()throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try
        {
           System.out.println("Book id");
           book_id = Long.parseLong(br.readLine());

           System.out.println("Publisher name");
           publisher = br.readLine();
           
           System.out.println("Published date"); 
           published_date = br.readLine();
        }
        catch( Exception e )
    	{
			System.out.println(e.toString());
    	}
    }

    public void displayData()
	{
    	System.out.println("Book id:" + book_id);
        System.out.println("Publisher Name:" + publisher);
        System.out.println("Publish date:" + publisher_date);
	}  	 
}

class HardBound extends Book
{
    
}