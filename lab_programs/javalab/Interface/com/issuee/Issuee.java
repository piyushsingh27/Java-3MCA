package com.issuee;
import java.io.*;


 interface Transaction 
{
//  final   private static String issueDate,expiryDate;
// 	private static Date date = new Date();
// 	static{
// 		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");
// 		issueDate = formatter.format(date);
// 		Calendar c = Calendar.getInstance();
// 		c.setTime(date);	
// 		c.add(Calendar.DAY_OF_MONTH, 15);
// 		expiryDate = formatter.format(c.getTime()); 
// 	}
public void read()throws IOException;
public void display();
}
public interface Issuee extends Transaction
{
    public void read()throws IOException;
    public void display(); 
}