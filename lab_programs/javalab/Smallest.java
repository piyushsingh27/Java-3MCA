import java.util.*;

class Sorter
{
    int arr[];
  Sorter()
  {
    arr = new int[10];
  }
  void  read()
  {
      Scanner in = new Scanner(System.in);
    for (byte i = 0;i<10;i++)
    {
        System.out.print("Enter the "+(i+1)+" number");
        arr[i] = in.nextInt();
        System.out.println();
    }
  }
  void display()
  {
      for( byte i = 0; i < 10 ; i++)
      {
          System.out.println(arr[i]);
      }  
  }
  void sort()
  {
  byte i,j;
  int temp;
  
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
  int smallestPrimeNumber()
  {
    byte i,c,j;
    for(i=0;i<10;i++) 
    {
        c = 0;
        for(j=1;j<=arr[i];j++)
        {
            if(arr[i]%j == 0)
            {
            c++;
            }
        }
            if( c==2)
            {
                System.out.println("Smallest prime number: "+arr[i]);
                    break;
            }
        
    }
    return 0;
    
  }
}

public class Smallest
{
    public static void main(String[] args) {
        Sorter abc = new Sorter();
        abc.read();
        abc.sort();
       abc.smallestPrimeNumber();
        abc.display();
    }
}
