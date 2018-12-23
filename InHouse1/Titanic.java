import java.util.*;
import java.io.*;

public class Titanic {
	
	static int[][] walls;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		
		int lines = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		visited = new boolean[lines][lines];
		walls = new int[lines][lines];
		for (int i = 0; i < lines; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < lines; j++) {
				walls[i][j] = Integer.parseInt(st.nextToken());
				visited[i][j] = false;
			}
		}
		pw.println(floodFill(x, y));
		pw.close();
	}
	
	public static int floodFill (int x, int y) {
		visited[x][y] = true;
		int a = walls[x][y];
		boolean [] nesw = new boolean[4];
		if (a >= 8) {
			nesw[3] = true;
			a = a-8;
		}
		if (a >= 4) {
			nesw[2] = true;
			a = a-4;
		}
		if (a >= 2) {
			nesw[1] = true;
			a = a-2;
		}
		if (a >= 1) {
			nesw[0] = true;
			a = a - 1;
		}
		int count = 0;
		if (!nesw[0] && visited[x-1][y] == false) {
			count += floodFill(x-1, y); 
		}
		if (!nesw[1] && visited[x][y+1] == false) {
			count += floodFill(x, y+1);
		}
		if (!nesw[2] && visited[x+1][y] == false) {
			count += floodFill(x+1, y);
		}
		if (!nesw[3] && visited[x][y-1] == false) {
			count += floodFill(x, y-1);
		}
		return 1 + count;
		
	}

}
