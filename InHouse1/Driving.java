import java.util.*;
import java.io.*;
public class Driving {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		StringTokenizer st = new StringTokenizer(s.nextLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		LinkedList<Edge>[] edges = new LinkedList[n+1];
		boolean[] visited = new boolean[n+1];
		int[] distances = new int[n+1];
		
		for(int i = 0; i <= n; i++) {
			edges[i] = new LinkedList();
			distances[i] = Integer.MAX_VALUE;
		}
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(s.nextLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			edges[a].add(new Edge(w, b));
			edges[b].add(new Edge(w, a));
		}
		
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		distances[start] = 0;
		pq.add(new Node(start, 0, false));
		while(!pq.isEmpty()) {
			Node nd = pq.poll();
			if(visited[nd.id]) continue;
			visited[nd.id] = true;
			for(Edge e: edges[nd.id]) {
				int new_dist = e.weight+nd.dist;
				if(nd.food) new_dist+=10;
				if(new_dist < distances[e.dest]) {
					distances[e.dest] = new_dist;
					pq.add(new Node(e.dest, new_dist, !nd.food));
				}
			}
		}
		System.out.println(distances[end]);
		

	}

}

class Node implements Comparable<Node>{
	
	public int id;
	public int dist;
	public boolean food;
	
	public Node(int i, int d, boolean f) {
		id = i;
		dist = d;
		food = f;
	}
	
	public int compareTo(Node n) {
		return dist-n.dist;
	}
}

class Edge{
	
	public int weight;
	public int dest;
	
	public Edge(int w, int n) {
		weight = w;
		dest = n;
	}
	
}