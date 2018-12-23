import java.io.*;
import java.util.*;

public class convention2 {

   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new FileReader(new File("convention2.in")));
      PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("convention2.out")));
      int N = Integer.parseInt(br.readLine());      
      LinkedList<State> data = new LinkedList<State>();
      for (int i = 1; i <= N; i++) {
         StringTokenizer st = new StringTokenizer(br.readLine());
         data.add(new State(i, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
      }
      Collections.sort(data);
      PriorityQueue<State> waiting = new PriorityQueue<State>(
         new Comparator<State>(){
            public int compare(State a, State b){
               return a.seniority - b.seniority;
            }
         });
      int index = 0;
      int current_time = 0;
      int max = 0;
      while (index < N) {
         if (waiting.isEmpty()) {
            waiting.add(data.remove());
            index++;
            current_time = waiting.peek().arrival;
            while (!data.isEmpty() && data.getFirst().arrival <= current_time) {
               waiting.add(data.remove());
               index++;
            }
            State temp = waiting.remove();
            max = Math.max(current_time-temp.arrival, max);
            current_time += temp.time; 
         }
         while (!data.isEmpty() && data.getFirst().arrival <= current_time) {
            waiting.add(data.remove());
            index++;
         }
         if (!waiting.isEmpty()) {
            State temp = waiting.remove();
            max = Math.max(current_time-temp.arrival, max);
            current_time += temp.time;
         }            
      
      }
      
      pw.println(max);
      pw.close();  
   
   
   
   }
   
   static class State implements Comparable<State> {
      int seniority;
      int arrival;
      int time;
      
      public State (int a, int b, int c) {
         seniority = a;
         arrival = b; 
         time = c;
      }
      
      public int compareTo(State s) {
         if (arrival != s.arrival)
            return arrival - s.arrival;
         return seniority - s.seniority;
      }
   
   
   
   }

}