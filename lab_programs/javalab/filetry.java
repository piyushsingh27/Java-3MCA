import java.io.*;

class Employee implements Serializable
{
    String name;

    public void read()throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter name");
        name = br.readLine();
    }

    public void write()
    {
        System.out.println("Name" + name);
    }
}

public class filetry
{
    public static void main(String[] args)throws IOException,ClassNotFoundException
    {
        try{
        Employee[] emp = new Employee[5];

        int i;

        FileOutputStream fw = new FileOutputStream("file");
        ObjectOutputStream objout = new ObjectOutputStream(fw);

        for(i=0;i<5;i+=1)
        {
            emp[i] = new Employee();
            emp[i].read();
            objout.writeObject(emp[i]);
        }
        objout.close();

        FileInputStream fr = new FileInputStream("file");
        ObjectInputStream objin = new ObjectInputStream(fr);
        Employee [] emp1 = new Employee[5];

        for(i=0;i<5;i+=1)
        {
            emp1[i] = (Employee)objin.readObject();
            emp1[i].write();
        }
        objin.close();
    }
    catch(Exception e)
    {
        System.out.println(e.toString());
    }

    }
}