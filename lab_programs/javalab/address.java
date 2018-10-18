import java.io.*;
import java.util.*;
class address
{
    public static void main(String[] args)throws IOException {
        String str;
        Scanner in = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new FileWriter("filess.txt"));
        for(int i=0;i<10;i++)
        {
            str = in.nextLine();
            bw.write(str);;
            bw.newLine();
        }
        bw.close();


        System.out.println("\n\n-----------------------\n\n");
        BufferedReader br = new BufferedReader(new FileReader("filess.txt"));
        for(int i=0;i<10;i++)
        {
            str = br.readLine();
            System.out.println(str);
        }
    }
}