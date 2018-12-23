import java.util.*;
import java.io.*;

public class FibbString {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		String word = br.readLine();
		HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
		for (int i = 0; i < word.length(); i++) {
			if (!hm.containsKey(word.charAt(i)))
				hm.put(word.charAt(i), 0);
			hm.put(word.charAt(i), hm.get(word.charAt(i))+1);
		}
		State[] frequency = new State[hm.size()];
		int i = 0;
		for (char letter: hm.keySet()) {
			frequency[i] = new State(letter, hm.get(letter));
			i++;
		}
		Arrays.sort(frequency);
		boolean flag = false;
		for (int j = 0; j < frequency.length; j++) {
			if (j == 0 || j == 1) {
				if (frequency[j].count != 1) {
					flag = true;
					break;
				}
			} else {
				if (frequency[j].count != frequency[j-1].count + frequency[j-2].count) {
					flag = true;
					break;
				}
			}
		}
		if (flag)
			pw.println("NO");
		else
			pw.println("YES");
		pw.close();

	}
	
	static class State implements Comparable<State>{
		char letter;
		int count;
		
		public State (char c, int i) {
			letter = c;
			count = i;
		}

		@Override
		public int compareTo(State arg0) {
			return count - arg0.count;
		}
		
	}

}
