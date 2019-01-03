// This solution is the exact same as the one posted on the USACO Website but written in Java
// The recursive solution presented in the C++ file is not viable for Java

import java.io.*;
import java.util.*;

public class teamwork {

   public static void main (String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new FileReader(new File("teamwork.in")));
      PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("teamwork.out")));
      
      StringTokenizer st = new StringTokenizer(br.readLine());
      int N = Integer.parseInt(st.nextToken());
      int K = Integer.parseInt(st.nextToken());
      
      int[] dp = new int[N];
      int[] data = new int[N];
      
      for (int i = 0; i < N; i++) {
         data[i] = Integer.parseInt(br.readLine());
      }
      dp[0] = data[0];
   
      for(int i=1;i<N;i++) {
         int max = dat[i];
         for(int j=i;i-j < K && j >= 0; j--) {
            max = Math.max(max, data[j]);
            if(j==0) 
               dp[i] = Math.max(dp[i],max*(i+1-j));
            else 
               dp[i] = Math.max(dp[i],dp[j-1] + max*(i+1-j));
         }
      }
      
      pw.println(dp[N-1]);
      pw.close();
   
   }
   
     


}


