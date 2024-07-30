import java.util.*;
import java.io.*;
public class DVR {
 static int graph[][], via[][], rt[][], v, e;
 public static void main(String[] args) {
  Scanner sc=new Scanner(System.in);
  System.out.print("Enter the number of vertices:");
  v=sc.nextInt();
  System.out.print("edges:");
  e=sc.nextInt();
  graph=new int[v][v];
  via=new int[v][v];
  rt=new int[v][v];
  for(int i=0;i<v;i++)
   for(int j=0;j<v;j++) {
    if(i==j)
     graph[i][j]=0;
    else
     graph[i][j]=9999;
   }
  for(int i=0;i<e;i++) {
   System.out.println("Enter the details for edge "+(i+1));
   System.out.print("Source: ");
   int s=sc.nextInt();
   s--;
   System.out.print("Destination: ");
   int d=sc.nextInt();
   d--;
   System.out.print("Cost: ");
   int c=sc.nextInt();
   graph[s][d]=c;
   graph[d][s]=c;
  }
  dvr_calc("The initial routing tables");
  System.out.print("S: ");
  int s=sc.nextInt();
  s--;
  System.out.print("D: ");
  int d=sc.nextInt();
  d--;
  System.out.print("new Cost: ");
  int c=sc.nextInt();
  graph[s][d]=c;
  graph[d][s]=c;
  dvr_calc("The new routing tables");
 }
 static void dvr_calc(String message) {
  init_tables();
  update_tables();
  System.out.print(message);
  print_tables();
 }
 static void update_table(int source) {
  for(int i=0;i<v;i++) {
   if(graph[source][i]!=9999) {
    int dist=graph[source][i];
    for(int j=0;j<v;j++) {
     int inter_dist=rt[i][j];
     if(via[i][j]==source)
      inter_dist=9999;
     if(dist+inter_dist<rt[source][j]) {
      rt[source][j]=dist+inter_dist;
      via[source][j]=i;
     }
    }
   }
  }
 }
 static void update_tables() {
  int k=0;
  for(int i=0;i<4*v;i++) {
   update_table(k);
   k++;
   if(k==v) 
    k=0;
  }
 }
 static void init_tables() {
  for(int i=0;i<v;i++) {
   for(int j=0;j<v;j++) {
    if(i==j) {
     rt[i][j]=0;
     via[i][j]=i;
    } else {
     rt[i][j]=9999;
     via[i][j]=100;
    }
   }
  }
 }
 static void print_tables() {
  for(int i=0;i<v;i++) {
   for(int j=0;j<v;j++)
    System.out.print("Dist: "+rt[i][j]+"	");
   System.out.println();
  }
 }
}