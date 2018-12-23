//USACO Silver Contest 1 2018-2019 Problem 1
import java.io.*;
import java.util.*;

public class convention {

   public static void main(String[] args) throws IOException{
      //file input/output
      BufferedReader br = new BufferedReader(new FileReader(new File("convention.in")));
      PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("convention.out")));
      StringTokenizer st = new StringTokenizer(br.readLine());
      int N = Integer.parseInt(st.nextToken());
      int M = Integer.parseInt(st.nextToken());
      int C = Integer.parseInt(st.nextToken());
   
      int[] T = new int[N];
      st = new StringTokenizer(br.readLine());
      for (int i = 0; i < N; i++) {
         T[i] = Integer.parseInt(st.nextToken());
      }
      Arrays.sort(T);
      //we begin by binary searching for our solution
      //going through the smallest and largest possible values of the solution
      int lo = 0;
      int hi = (int)(1e9);
      while (lo < hi) {
         int diff = lo + (hi - lo) / 2;
         int pt = 0;
         int last = 0;
         int needed = 0;
         while (pt < N) {
            int used = 0;
            while (pt < N && used < C && T[pt] - T[last] <= diff) {
               pt++;
               used++;
            }
            needed++;
            last = pt;
         }
         if (needed <= M) {
            hi = diff;
         } else {
            lo = diff + 1;
         }
      }
      pw.println(lo);
      pw.close();
   
   }



}