import java.io.*;  
import java.net.*;  
public class Server {  
public static void main(String[] args){  
try{  
ServerSocket ss=new ServerSocket(6666);  
Socket s=ss.accept();//establishes connection 
DataOutputStream dout=new DataOutputStream(s.getOutputStream()); 
DataInputStream dis=new DataInputStream(s.getInputStream()); 
BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
String str; 
while(true)
{
	
	str=(String)dis.readUTF(); 
	System.out.println("Message from client"+str+"\n");  
	System.out.print("\nEnter Your Message:");
	str = br.readLine();
    	dout.writeUTF(str); 
	
}
 
}catch(Exception e){System.out.println(e);}  

}  
}  
