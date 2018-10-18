import java.io.*;
import java.net.*;

public class Client1
{
    public static void main(String []args)
    {
        try
        {
            Socket s = new Socket("localhost", 6666);
            DataOutputStream dout=new DataOutputStream(s.getOutputStream());
            DataInputStream din=new DataInputStream(s.getInputStream());  
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            
            String str;

            while(true)
            {
                System.out.println("Enter your message");
                str = br.readLine();
                dout.writeUTF(str);

                str = (String)din.readUTF();
                System.out.println("Message from client" + str);
            }
        }

        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
