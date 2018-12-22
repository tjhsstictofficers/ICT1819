import java.io.*;
import java.util.*;

public class mixmilk {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new File("mixmilk.in"));
        int cap1, cap2, cap3;
        int cur1, cur2, cur3;

        cap1 = scan.nextInt();
        cur1 = scan.nextInt();
        cap2 = scan.nextInt();
        cur2 = scan.nextInt();
        cap3 = scan.nextInt();
        cur3 = scan.nextInt();
        
        scan.close();

        int[] curArr = new int[3];
        curArr[0] = cur1;
        curArr[1] = cur2;
        curArr[2] = cur3;
        
        int[] capArr = new int[3];
        capArr[0] = cap1;
        capArr[1] = cap2;
        capArr[2] = cap3;
        
        for(int i = 0; i < 100; i++) {
            step(curArr, capArr, i);
        }

        PrintWriter pw = new PrintWriter(new File("mixmilk.out"));
        pw.println(curArr[0]);
        pw.println(curArr[1]);
        pw.println(curArr[2]);
        pw.close();
    }   

    static void step(int[] curArr, int[] capArr, int index) {
        int f = (index)%3;
        int t = (index+1)%3;

        int amount = Math.min(curArr[f], capArr[t]-curArr[t]);
        curArr[f] -= amount;
        curArr[t] += amount;
    }
}
