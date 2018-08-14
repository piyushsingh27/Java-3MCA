import java.io.*;

class test implements Serializable
{
    String x;
    int a ;

    void read()throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("String : ");
        x = in.readLine();
        System.out.print("Integer : ");
        a = Integer.parseInt(in.readLine());
    }
}

class output
{
    public static void main(String[] args)throws Exception {

/*
        FileOutputStream f = new FileOutputStream("abc.txt");
        
        byte b;
        char c = '1';
        b = (byte) c;
        f.write(b);

        String s = "Hero Anurag";
        byte []arr = s.getBytes();
        f.write(arr);

        String s1 = "Legend Abhishek";
        byte[] arr1 = s1.getBytes();
        f.write(arr1, 0, 6);

        FileInputStream fr = new FileInputStream("abc.txt");
        System.out.println("Available bytes to read : "+fr.available());
        System.out.println("Reading byte : "+(char)fr.read());
        fr.skip(2);
        byte arr2[] = new byte[6];
        fr.read(arr2);
        System.out.println("Reading array : "+new String(arr2, 0, 6));
        System.out.println("Reading byte : "+(char)fr.read());
        System.out.println("Available bytes to read : "+fr.available());
*/
        try
        {
        FileOutputStream fs = new FileOutputStream("new");
        ObjectOutputStream ou = new ObjectOutputStream(fs);

        test a = new test();
        a.read();
        
            ou.writeObject(a);
            ou.close();
            fs.close();
        }
        catch(Exception e)
        {
            System.out.print(e.toString());
        }
        


        FileInputStream filein = new FileInputStream("new");
      ObjectInputStream objin = new ObjectInputStream(filein);
        test c1 ;
        try{
            c1 = (test)objin.readObject();
            System.out.print("String : "+c1.x);
        }
        catch(Exception e)
        {

        }
        
        
    }
}