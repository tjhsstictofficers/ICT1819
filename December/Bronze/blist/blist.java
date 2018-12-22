import java.io.*;
import java.util.*;

public class blist {
    public static void main(String[] args) throws IOException{
        Scanner scan = new Scanner(new File("blist.in"));
        PrintWriter pw = new PrintWriter(new File("blist.out"));
        int N = Integer.parseInt(scan.nextLine().trim());
        int[] s = new int[N];
        int[] t = new int[N];
        int[] b = new int[N];
        for(int i = 0; i < N; i++) {
            s[i] = scan.nextInt();
            t[i] = scan.nextInt();
            b[i] = scan.nextInt();
        }
        scan.close();
        int maxBuc = 0;
        for(int i = 0; i < 1000; i++) {
            int curBuc = 0;
            for(int j = 0; j < N; j++) {
                if(s[j] <= i && t[j] >= i) curBuc += b[j];        
            }
            maxBuc = Math.max(curBuc,maxBuc);
        }
        pw.println(maxBuc);
        pw.close();
    }
}
