import java.io.*;
import java.net.*;

public class Server1
{
    public static void main(String []args)
    {
        try
        {
            ServerSocket s = new ServerSocket(6666);
            Socket ss = s.accept();

            DataOutputStream dout = new DataOutputStream(ss.getOutputStream());
            DataInputStream din = new DataInputStream(ss.getInputStream());
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            String str;

            while(true)
            {
                str = (String)din.readUTF();
                System.out.println("Message from client" + str);
                System.out.println("Enter your message");
                str = br.readLine();
                dout.writeUTF(str);
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}