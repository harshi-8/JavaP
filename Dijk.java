import java.io.*;
import java.util.*;
public class Dijk {
 private static final int INFINITY=Integer.MAX_VALUE;
 public static void main(String[] args) {
  Scanner sc=new Scanner(System.in);
  System.out.print("number of vertices: ");
  int v=sc.nextInt();
  int[][] graph=new int[v][v];
  System.out.println("Adjacency matrix:");
  for(int i=0;i<v;i++)
   for(int j=0;j<v;j++)
    graph[i][j]=sc.nextInt();
  System.out.print("source vertex:");
  int s=sc.nextInt();
  dijk(graph,s);
 }
 public static void dijk(int[][] graph, int s) {
  int v=graph.length;
  int[] d=new int[v];
  int[] p=new int[v];
  boolean[] visited=new boolean[v];
  for (int i=0;i<v;i++) {
   d[i]=INFINITY;
   visited[i]=false;
  }
  d[s]=0;
  p[s]=-1;
  for(int i=0;i<v;i++) {
   int min=find(d,visited);
   visited[min]=true;
   for(int j=0;j<v;j++) 
    if(!visited[j] && graph[min][j]!=0 && d[min]!=INFINITY && d[min]+graph[min][j]<d[j]) {
     d[j]=d[min]+graph[min][j];
     p[j]=min;
    }
  }
  printS(s,d);
 }
 public static int find(int[] d, boolean[] visited) {
  int minD=INFINITY;
  int min=-1;
  for(int i=0;i<d.length;i++)
   if(!visited[i] && d[i]<minD) {
    minD=d[i];
    min=i;
   }
  return min;
 }
 public static void printS(int s, int[] d) {
  System.out.println("Shortest distance");
  for(int i=0;i<d.length;i++) {
   System.out.println("vertex "+i+": "+d[i]);
   System.out.println();
  }
 }
}