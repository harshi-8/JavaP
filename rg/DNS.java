import java.net.*;
import java.io.*;
import java.util.*;
public class DNS {
 public static void main(String[] args) {
  Scanner sc=new Scanner(System.in);
  int n;
  do {
   System.out.println("Menu:  1.DNS 2.Exit");
   System.out.print("Enter your choice: ");
   n=sc.nextInt();
   if(n==1) {
    try {
     System.out.print("Enter the host name: ");
     String hname=sc.next();
     InetAddress address;
     address=InetAddress.getByName(hname);
     System.out.println("Host name: "+address.getHostName());
     System.out.println("IP: "+address.getHostAddress());
    }
    catch(IOException i) {
     System.out.println(i);
    } 
   }
  }while(!(n==2));
 }
}