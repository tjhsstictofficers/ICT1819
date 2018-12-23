import java.util.Scanner;
import java.util.ArrayList;

public class RussianTunnels 
{
	public static int[] vis = new int[(int)1e5+1];
	public static int dfs(ArrayList< ArrayList<Integer> > graph, int node) 
	{
		if(vis[node] == 1) 
			return 0;
		vis[node] = 1;
		for(int next : graph.get(node))
			dfs(graph, next);
	    return 1;
	}
	public static void main(String[] args) 
	{
   		Scanner sc = new Scanner(System.in);
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		for(int x = 0; x < (int)1e5+1; x++) 
		{
			ArrayList<Integer> t = new ArrayList<>();
			graph.add(t);
		}
		int N = sc.nextInt(), M = sc.nextInt();
		for(int x = 0; x < M; x++) 
		{
			int first = sc.nextInt(), second = sc.nextInt();
			graph.get(first).add(second);
			graph.get(second).add(first);
		}
		int numConnectedComponents = 0;
		for(int x = 1; x <= N; x++) 
			numConnectedComponents += dfs(graph, x);
		System.out.println(numConnectedComponents-1);
	}
}