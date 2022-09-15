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
        int [][] dp = new int[n][n];
        for(int i=0;i<n;++i){
          for(int j=0;j<n;++j){
               if(i==0){
               dp[i][j] = ar[i][j];
              }
              else if(j==0){
                dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j+1]) + ar[i][j];
              }
              else if(j==n-1){
                dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-1]) + ar[i][j];
              }
              else{
                dp[i][j] = Math.max(dp[i-1][j],Math.max(dp[i-1][j-1],dp[i-1][j+1])) + ar[i][j];
              }
          }
        }
        int max = Integer.MIN_VALUE;
        for(int j=0;j<n;++j){
          max = Math.max(max,dp[n-1][j]);
        }
        out.println(max);
      } 
      //End your solution here.
     out.close();
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