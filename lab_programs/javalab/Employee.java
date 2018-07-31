import java.io.*;
class EmployeeDetails{
    private int empid;
    private String name;
    private int basicpay;
    private static int autoempid;   

    static
    {
        autoempid = 1;
    }
    
    EmployeeDetails()
    {
       empid = autoempid;
       autoempid++;
    }
    
    private double calDA(int basicpay){
      return basicpay*0.5;
    }
  
    private double calHRA(int basicpay){
      return basicpay*0.1;
    }
    
    double calTotal(int basicpay)
    {
        return basicpay + calDA(basicpay) + calHRA(basicpay);
    }
    
    void readData()throws IOException
    {
      BufferedReader in = new BufferedReader( new InputStreamReader( System.in ) );
      System.out.println("Employee Details : ");
      System.out.print("Name : ");
      name = in.readLine();
      System.out.print("Basic Pay : ");
      basicpay = Integer.parseInt(in.readLine());
    }
  
    void display()
    {
      System.out.println("\n\nEmployee Details");
      System.out.println("----------------------");
      System.out.println("Name : "+name);
      System.out.println("ID : "+empid);
      System.out.println("Basic Pay : "+basicpay);
      System.out.println("DA : "+calDA(basicpay));
      System.out.println("HRA : "+calHRA(basicpay));
      System.out.println("Total Pay : "+calTotal(basicpay));
    }  
}
class Employee{
    public static void main(String []args)throws IOException{
        BufferedReader in = new BufferedReader( new InputStreamReader( System.in ));
        
        EmployeeDetails[] obj = new EmployeeDetails[20];
        byte choice;
        boolean loop = true;
        do
        {
        System.out.println("1.Enter the Data");
        System.out.println("2.Display the Data");
        System.out.println("3.Exit");
        choice = Byte.parseByte(in.readLine());
        switch(choice)
          {
              case 1:
                  for(byte i = 0; i< 2; i++)
                  {
                      obj[i] = new EmployeeDetails();
                      obj[i].readData();    
                  }
                  break;
              case 2:
                      for(byte i = 0; i< 2; i++)
                  {
                      obj[i].display();    
                  }
                  break;
                  case 3:
                      loop = false;
                      break;
                default:
                    System.out.println("Invalid Choice");
         
             }          
             }while(loop);
    }
}