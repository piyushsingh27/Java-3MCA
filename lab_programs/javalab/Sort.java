import java.util.*;
import java.math.*;

class Sorter1{
    int n = 10;
    byte i;
    int arr[];
    Sorter1(){
        n = 10;
        arr = new int[10];
    }
    void read(){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter "+ n + " numbers");
        for(i = 0; i < n; i++){
            arr[i] = in.nextInt();
        }
        System.out.println();
        in.close();
    }
    void sort(){
        int temp;
        byte j;
        for (i = 0; i < 9; i++) 
        {     
            // Last i elements are already in place   
            for (j = 0; j < 9-i; j++) 
            {
                if (arr[j] < arr[j+1])
                {
                    temp = arr[j] ;
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
            
    }
    void display(){
        System.out.println("Sorted Numbers: ");
        for(i = 0; i < n; i++){
            System.out.println(arr[i]); 
        }

    }
    int smallestPrime(){
        byte ch,j;
        for(i=9;i >= 0;i--)
        {
            ch = 0;
            for(j=1;j <=arr[i];j++)
            {
                if(arr[i]%j == 0)
                {
                ch++;
                }
            }
                if( ch==2)
                {
                    return arr[i];
                    // System.out.printn("Smallest : "+arr[i]);
                    //     break;
                }
            
        }
        return 0;
    }
}

class Sort{
    public static void main(String[] args) {
        Sorter1 sorting = new Sorter1();
        sorting.read();
        System.out.print("\f");
        sorting.sort();
        System.out.print("\f");
        sorting.display();
        System.out.println("Smallest Prime Number: "+sorting.smallestPrime());
    }
}