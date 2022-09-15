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
        int [] arr = new int[n];
        arr = in.nextIntAr(arr);

        int maxVal = arr[0]; 
    int minVal = arr[0]; 
    for (int i = 1; i < n; i++) { 
      maxVal = Math.max(maxVal, arr[i]); 
      minVal = Math.min(minVal, arr[i]); 
    } 

    int maxBucket[] = new int[n]; 
    int minBucket[] = new int[n]; 
    Arrays.fill(maxBucket, 0, n, Integer.MIN_VALUE); 
    Arrays.fill(minBucket, 0, n, Integer.MAX_VALUE); 

    float delta = (float) (maxVal - minVal) / (float) (n); 

    for (int i = 0; i < n; i++) { 
      if (arr[i] == maxVal || arr[i] == minVal) { 
        continue; 
      } 

      int index = (int) (Math.floor((arr[i] - minVal) / delta)); 

      if (maxBucket[index] == Integer.MIN_VALUE) { 
        maxBucket[index] = arr[i]; 
      } else { 
        maxBucket[index] = Math.max(maxBucket[index], arr[i]); 
      } 

      if (minBucket[index] == Integer.MAX_VALUE) { 
        minBucket[index] = arr[i]; 
      } else { 
        minBucket[index] = Math.min(minBucket[index], arr[i]); 
      } 
    } 

    int prev_val = minVal; 
    int max_gap = 0; 
    for (int i = 0; i < n; i++) { 
      if (minBucket[i] == Integer.MAX_VALUE) { 
        continue; 
      } 
      max_gap = Math.max(max_gap, minBucket[i] - prev_val); 
      prev_val = maxBucket[i]; 
    } 
    max_gap = Math.max(max_gap, maxVal - prev_val); 

    out.println(max_gap);
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