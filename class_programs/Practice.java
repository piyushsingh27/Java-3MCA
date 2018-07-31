import java.io.*;
import java.util.Scanner;


class Publications
{
    long publ_id;
    String title;
    String author;
    int price;
    static long spubl_id;

    static
    {
        spubl_id = 0;
    }

    Publications(String name)
    {
        spubl_id += 1;
        publ_id = spubl_id;

        title = name;
        author = "ABC";
        price = 100;
    }

    public void getdata()throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner in = new Scanner(System.in);

        System.out.println("Enter title of book:");
        title = br.readLine();

        System.out.println("Enter author of book:");
        author = br.readLine();

        System.out.println("Enter price of book");
        price = in.nextInt();
    }

    public void putdata()
    {
        System.out.println("Publication id:" + publ_id);
        System.out.println("Title:" + title);
        System.out.println("Author:" + author);
        System.out.println("Price:" + price);
    }
}

class TextBook extends Publications
{
    short page_count;

    TextBook(String y,short x)
    {
        super(y);
        page_count = x;
    }

    public void getdata()throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner in = new Scanner(System.in);

        super.getdata();
        System.out.println("Enter the page count:");
        page_count = Short.parseShort(br.readLine());
    }

    public void putdata()
    {
        super.putdata();
        System.out.println("page count:" + page_count);
    }

    public void searchbook(short pgcnt)
    {
        if(page_count > pgcnt)
        this.putdata();
    }
}


class CD extends Publications
{
    short play_time;

    CD(String z,short a)
    {
        super(z);
        play_time = a;
    }

    public void getdata()throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner in = new Scanner(System.in);
        
        super.getdata();
        System.out.println("Enter the play time of CD:");
        play_time = Short.parseShort(br.readLine());
    }

    public void putdata()
    {
        super.putdata();
        System.out.println("Play time:" + play_time);
    }

    public void searchCD(short pltime)
    {
        if(play_time < pltime)
        this.putdata();
    }
}


class Practice
{
    public static void main(String []args)throws IOException
    {
        final int var = 2;
        int i;

        TextBook []obj_text = new TextBook[var];
        System.out.println("Read data from textbook");
        for(i = 0;i < var;i += 1)
        {
            obj_text[i] = new TextBook("XYZ",(short) 105);
            obj_text[i].getdata();
        }

        System.out.println("Data of textbook");
        for(i = 0;i < var;i += 1)
        {
            obj_text[i].putdata();
        }

        CD []obj_cd = new CD[var];
        System.out.println("Read data from CD");
        for(i = 0;i < var;i += 1)
        {
            obj_cd[i] = new CD("XYZ",(short) 25);
            obj_cd[i].getdata();
        }

        System.out.println("Data of CD");
        for(i = 0;i < var;i += 1)
        {
            obj_cd[i].putdata();
        }

        for(i = 0;i < var;i += 1)
        {
            obj_text[i].searchbook((short) 100);
        }

        for(i = 0;i <var;i += 1)
        {
            obj_cd[i].searchCD((short) 20);
        }



    }
}