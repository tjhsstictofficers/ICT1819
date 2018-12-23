import java.io.*;
import java.util.*;

public class BrokeHavish {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		int [] data = new int [n+1];
		int [] prefixSums = new int[n+1];
		prefixSums[0] = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			data[i] = Integer.parseInt(st.nextToken());
			prefixSums[i] = data[i] + prefixSums[i-1];
		}
		if (n == 1) {
			pw.println("1 " + 0 +" " + 0);
		} else {
			int min = Integer.MAX_VALUE;
			int index = 0;
			int havish = 0;
			int arvind = 0;
			int max = Integer.MIN_VALUE;
			for (int i = 1; i <= n; i++) {
				max = Math.max(max, data[i]);
				int difference = Math.abs((prefixSums[n] - prefixSums[i]) - (prefixSums[i] - max));
				if (difference < min) {
					min = difference;
					havish = (prefixSums[i] - max);
					arvind = (prefixSums[n] - prefixSums[i]);
					index = i;
				}
			}
			pw.println(index + " " + havish + " " + arvind);
		}
		pw.close();
	}

}
