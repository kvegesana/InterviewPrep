import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;
import java.util.StringTokenizer;

public class TestClass{
public static void main(String []args) {
      MyScanner in = new MyScanner();
      out = new PrintWriter(new BufferedOutputStream(System.out));
      //Start your solution from here. 
      int t = in.nextInt();
      while(t-->0){
        int n = in.nextInt();
        int [][] ar = new int[n][n];
        for(int i=0;i<n;++i){
          for(int j=0;j<n;++j){
            ar[i][j] = in.nextInt();
          }
        }
        int k = in.nextInt();
        if(k<=0 || k>n*n){
          System.out.println(Integer.MAX_VALUE);
        }
        HeapNode [] dp = new HeapNode[n];
        for(int i=0;i<n;++i){
          dp[i] = new HeapNode(ar[0][i],0,i);
        }
        buildHeap(dp,n);
        HeapNode res = new HeapNode(0,0,0);
        for (int i=0;i<k;++i) {
          res = dp[0];
          int next;
          if(res.r < n-1){
            next = ar[res.r+1][res.c];
          }
          else{
            next = Integer.MAX_VALUE;
          }
          dp[0] = new HeapNode(next,res.r+1,res.c);
          heapify(dp,0,n);
        }
        out.println(res.val);
      }
      //End your solution here.
     out.close();
   }

  static void buildHeap(HeapNode [] ar,int n){
      int mid = (n-1)/2;
      while(mid>=0){
        heapify(ar,mid,n);
        mid--;
      }  
  }
  static void heapify(HeapNode [] ar,int i,int n){
    int l = 2 * i + 1;
    int r = 2 * i + 2;
    int small = i;
    if(l < n && ar[l].val < ar[i].val){
      small = l;
    }
    if(r < n && ar[r].val < ar[small].val){
      small = r;
    }
    if(small != i){
      swap(ar,i,small);
      heapify(ar,small,n);
    }
  }
  static void swap(HeapNode [] ar,int i,int j){
    HeapNode temp = ar[i];
    ar[i] = ar[j];
    ar[j] = temp;
  }
   //-----------PrintWriter for faster output---------------------------------
   public static PrintWriter out;

   //-----------MyScanner class for faster input----------
   public static class MyScanner {
      BufferedReader br;
      StringTokenizer st;

      public MyScanner() {
         br = new BufferedReader(new InputStreamReader(System.in));
      }

      String next() {
          while (st == null || !st.hasMoreElements()) {
              try {
                  st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                  e.printStackTrace();
              }
          }
          return st.nextToken();
      }

      int nextInt() {
          return Integer.parseInt(next());
      }

      long nextLong() {
          return Long.parseLong(next());
      }

      double nextDouble() {
          return Double.parseDouble(next());
      }
      char nextChar()  {
        return next().charAt(0);
      }
      int [] nextIntAr(int [] ar){
        for(int i=0;i<ar.length;++i){
          ar[i] = Integer.parseInt(next());
        }
        return ar;
      }
      long [] nextLongAr(long [] ar){
        for(int i=0;i<ar.length;++i){
          ar[i] = Long.parseLong(next());
        }
        return ar;
      }
      double [] nextDoubleAr(double [] ar){
        for(int i=0;i<ar.length;++i){
          ar[i] = Double.parseDouble(next());
        }
        return ar;
      }
      String [] nextStringAr(String [] ar){
        for(int i=0;i<ar.length;++i){
          ar[i] = next();
        }
        return ar;
      }

      String nextLine(){
          String str = "";
      try {
         str = br.readLine();
      } catch (IOException e) {
         e.printStackTrace();
      }
      return str;
      }

   }
}

class HeapNode{
  int val;
  int r;
  int c;
  HeapNode(int v,int l,int m){
    val =  v;
    r = l;
    c = m;
  }
}