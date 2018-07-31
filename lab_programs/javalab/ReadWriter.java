import java.io.*;  
public class ReadWriter {  
    public static void main(String[] args) {  
        try {  
			System.out.println("\n***Writing Begins here***");
			System.out.println("\nWriting: Book Store Management");
            Writer w = new FileWriter("output.txt");  
            String content = "Book Store Management System";  
            w.write(content);  
            w.close();  
            System.out.println("Done...");  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
		try {  
			System.out.println("\n***Reading Begins here***");
            Reader reader = new FileReader("output.txt");  
            int data = reader.read();  
            while (data != -1) {  
                System.out.print((char) data);  
                data = reader.read();  
            }  
            reader.close();  
        } catch (Exception ex) {  
            System.out.println(ex.getMessage());  
        } 
    }  
}  