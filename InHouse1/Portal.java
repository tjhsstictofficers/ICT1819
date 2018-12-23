import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Portal {
	static int n, q;
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(f.readLine());
		n = Integer.parseInt(st.nextToken());
		q = Integer.parseInt(st.nextToken());
		Portal[] portals = new Portal[n];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(f.readLine());
			portals[i] = new Portal(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		Arrays.sort(portals, new Comparator<Portal>() { //sort portals by distance
			@Override
			public int compare(Portal x, Portal y) {
				if (x.getDist() < y.getDist())
					return -1;
				else if (x.getDist() > y.getDist())
					return 1;
				return 0;
			}
		});
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < q; i++) {
			double d = Double.parseDouble(f.readLine());
			int index = binarySearch(portals, d);
			sb.append(portals[index].getX()).append(" ").append(portals[index].getY());
			if (i < q - 1)
				sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
	
	private static int binarySearch(Portal[] portals, double d) {
		if (d < portals[0].getDist())
			return 0;
		
		if (d > portals[n-1].getDist())
			return n-1;
		
		int low = 0;
        int high = n - 1;
        
        while (low <= high) {
            int mid = (low + high) / 2;

            if (d < portals[mid].getDist())
                high = mid - 1;
            else if (d > portals[mid].getDist())
                low = mid + 1;
            else
                return mid;
        }

        return (portals[low].getDist() - d) < (d - portals[high].getDist()) ? low : high;
	}
}

class Portal {
	private int x;
	private int y;
	private double dist;

	public Portal() {
		x = 0;
		y = 0;
		dist = 0.0;
	}

	public Portal(int x, int y) {
		this.x = x;
		this.y = y;
		this.dist = Math.sqrt(x*x + y*y);
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	public double getDist() {
		return dist;
	}
}