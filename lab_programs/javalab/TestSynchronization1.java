import java.io.*;

class Table
{
    /*synchronized*/ void printTable(int n)
    {
        int i;

        synchronized(this)
        {
            for(i=1;i<=10;i+=1)
            {
                System.out.println(n*i);
                try
                {
                    Thread.sleep(1000);
                }
                catch(Exception e)
                {

                }
            }
        }   
    }
}

class MyThread1 extends Thread
{
    Table t;
    MyThread1(Table t)
    {
        this.t = t;
    }

    public void run()
    {
        t.printTable(5);
    }
}

class MyThread2 extends Thread
{
    Table t;
    MyThread2(Table t)
    {
        this.t = t;
    }

    public void run()
    {
        t.printTable(10);
    }
}


public class TestSynchronization1
{
    public static void main(String []args)
    {
        Table obj = new Table();
        MyThread1 t1 = new MyThread1(obj);
        MyThread2 t2 = new MyThread2(obj);

        // Thread t1 = new Thread()
        // {
        //     public void run()
        //     {
        //         obj.printTable(5);
        //     }
        // };

        // Thread t2 = new Thread()
        // {
        //     public void run()
        //     {
        //         obj.printTable(10);
        //     }
        // };

        t1.start();

        t2.start();
    }
}