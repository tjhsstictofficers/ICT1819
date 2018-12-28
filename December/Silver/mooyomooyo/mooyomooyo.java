import java.util.*;
import java.io.*;

public class mooyomooyo {

   static boolean[][] visited;
   static int[][] current_state;

   public static void main (String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new FileReader(new File("mooyomooyo.in")));
      PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("mooyomooyo.out")));
      StringTokenizer st = new StringTokenizer(br.readLine());
      int N = Integer.parseInt(st.nextToken());
      int K = Integer.parseInt(st.nextToken());
      visited = new boolean[N][10];
      current_state = new int[N][10];
      for (int i = 0; i < N; i++) {
         String line = br.readLine();
         for (int j = 0; j < 10; j++) {
            current_state[i][j] = Integer.parseInt(line.charAt(j)+"");
         }
      }
      boolean changed = false;
      while (true) {
         changed = false;
         for (int i = 0; i < N; i++) {
            for (int j = 0; j < 10; j++) {
               if (current_state[i][j] != 0 && find_groups(i,j,current_state[i][j]) >= K) {
                  changed = true;
                  delete(i, j, current_state[i][j]);
               }
                  
            }
         }
         for (int i = 0; i < N; i++) {
            Arrays.fill(visited[i], false);
         }
         if (!changed) 
            break;
         gravity();
      }
      print(pw);
      pw.close();   
      
      
   
   }
   
   public static int find_groups (int i, int j, int num) {
      if (i < 0 || j < 0 || i >= current_state.length || j >= 10)
         return 0;
      if (visited[i][j]) 
         return 0;
      if (current_state[i][j] == num) {
         visited[i][j] = true;
         return 1 + find_groups(i+1, j, num) + find_groups(i-1, j, num) + find_groups(i, j+1, num) + find_groups(i, j-1, num);
      } 
      return 0;   
   }
   
   public static void delete (int i, int j, int num) {
      if (i < 0 || j < 0 || i >= current_state.length || j >= 10)
         return;
      if (!visited[i][j]) 
         return;
      if (current_state[i][j] == num) {
         visited[i][j] = false;
         current_state[i][j] = 0;
         delete(i+1, j, num);
         delete(i-1, j, num);
         delete(i, j+1, num);
         delete(i, j-1, num);
      } 
      return;
   }
   
   public static void gravity() {
      for (int j=0; j<10; j++) {
         int top = current_state.length-1;
         int bottom = current_state.length-1;
         while (top >= 0) {
            while (top >= 0 && current_state[top][j] == 0) top--;
            if (top >= 0)
               current_state[bottom--][j] = current_state[top--][j];
         }
         while (bottom >= 0) current_state[bottom--][j] = 0;
      }    
   }
   
   public static void print(PrintWriter pw) throws IOException {
      for (int i = 0; i < current_state.length; i++) {
         for (int j = 0; j < 10; j++) {
            pw.print(current_state[i][j]);
         }
         pw.println();
      }
   }
}