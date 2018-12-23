import java.util.*;

public class LunchLine {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int sum = 0; 
		boolean flag = false;
		for (int k = 0; k < n; k++) {
			sum += sc.nextInt();
			if (sc.nextInt() == 1) {
				flag = true;
				break;
			}
		}
		if (flag)
			System.out.println("YES");
		else if (sum <= 120)
			System.out.println("YES");
		else
			System.out.println("NO");
		sc.close();
	}

}