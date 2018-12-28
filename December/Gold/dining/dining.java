import java.io.*;
import java.util.*;

public class dining {

   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new FileReader(new File("dining.in")));
      PrintWriter pw = new PrintWriter(new FileWriter(new File("dining.out")));	
      StringTokenizer st = new StringTokenizer(br.readLine());
      int n = Integer.parseInt(st.nextToken());
      int m = Integer.parseInt(st.nextToken());
      int k = Integer.parseInt(st.nextToken());
      HashMap<Integer, LinkedList<Edge>> graph = new HashMap<Integer, LinkedList<Edge>>();
      for (int i = 0; i < m; i++) {
         st = new StringTokenizer(br.readLine());
         int first = Integer.parseInt(st.nextToken());
         int second = Integer.parseInt(st.nextToken());
         int count = Integer.parseInt(st.nextToken());
         // creation of the graph
         if (!graph.containsKey(first))
            graph.put(first, new LinkedList<Edge>());
         graph.get(first).add(new Edge(count, second));
         if (!graph.containsKey(second))
            graph.put(second, new LinkedList<Edge>());
         graph.get(second).add(new Edge(count, first));
         
      }
      int[] org_dist = new int[n+1];
      org_dist = djkstra(graph, n, n);
      graph.put(n+1, new LinkedList<Edge>());
      
      //adding queries to the graph
      for (int i = 0; i < k; i++) {
         st = new StringTokenizer(br.readLine());
         int index = Integer.parseInt(st.nextToken());
         int yumminess = Integer.parseInt(st.nextToken());
         graph.get(n+1).add(new Edge(org_dist[index] - yumminess, index)); 
      }
      int [] dist = djkstra(graph, n+1, n+1);
   	
      for (int i = 1; i <= n-1; i++) {
         pw.println((dist[i] <= org_dist[i]) ? "1" : "0");
      }
      pw.close();
   	
   }
	
   public static int[] djkstra (HashMap<Integer, LinkedList<Edge>> bob, int n, int size) {  
      int[] dist = new int[size+1];
      PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
      Arrays.fill(dist, Integer.MAX_VALUE);
      dist[n] = 0;
      pq.add(new Edge(0, n));
      while (!pq.isEmpty()) {
         Edge e = pq.poll();
         for (Edge k : bob.get(e.node)) {
            int node = k.node;
            int weight = k.dist;
            if (dist[node] > e.dist + weight) {
               dist[node] = e.dist+weight;
               pq.add(new Edge(dist[node], node));
            }
         }
        	
      }
      return dist;
        
   }
	
   static class Edge implements Comparable<Edge> {
   	
      int dist, node;
   	
      public Edge (int d, int n) {
         dist = d;
         node = n;
      }
   	
      public int compareTo (Edge e) {
         return dist - e.dist;
      }
   }


}
