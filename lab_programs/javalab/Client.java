    import java.io.*;  
    import java.net.*;      
    public class Client {   
    public static void main(String[] args) {    
    try{      
    Socket s=new Socket("localhost",6666);  
    DataOutputStream dout=new DataOutputStream(s.getOutputStream());    
    DataInputStream dis=new DataInputStream(s.getInputStream());  
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	String str = null;
	while(true)
	{
		System.out.print("\nEnter Your Message:");
		str = br.readLine();
    	dout.writeUTF(str); 
		str = (String)dis.readUTF();
		System.out.print("Message From Server"+str+"\n");
	} 	
   // dout.flush();  
    //dout.close();  
//    s.close();  
    }catch(Exception e){System.out.println(e);}  
    }  
    }  
