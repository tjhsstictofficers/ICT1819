// This solution file was written by Rahul Mittal

import java.io.*;
import java.util.*;

public class cowpatibility {
    static String PROBLEM_NAME = "cowpatibility";
    static int[] bitsInNum = new int[32];
    static int[] combIx = new int[32];
    static Integer[][] whichFlavors = new Integer[32][];

    public static void main(String[] args) throws IOException {
        BufferedReader br; PrintWriter writer;
        
            br = new BufferedReader(new FileReader(new File(PROBLEM_NAME + ".in")));
            writer = new PrintWriter(new BufferedWriter(new FileWriter(PROBLEM_NAME + ".out")));
        
        solve(br, writer);
        writer.flush();
        writer.close();
    }

    static void solve(BufferedReader br, PrintWriter writer) throws IOException {
        // Precalculations

        for (int i = 1; i < 32; i++) {
            List<Integer> flavors = new ArrayList<>();
            for (int j = 0; j < 5; j++) {
                if ((i & (1 << j)) != 0) {
                    flavors.add(j);
                }
            }
            bitsInNum[i] = flavors.size();
            whichFlavors[i] = flavors.toArray(new Integer[0]);
            int ix = 0;
            for (int j = 0; j < i; j++) {
                if (bitsInNum[i] == bitsInNum[j]) {
                    ix++;
                }
            }
            combIx[i] = ix;
        }

        //

        int n = Integer.parseInt(br.readLine());
        long nLong = (long) n;
        List<Cow> cows = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            Cow cow = new Cow();
            cow.readFlavors(br);
            cow.generateFlavorSets();
            cows.add(cow);
        }
        Map<FlavorSet, Long> amounts = new HashMap<>();
        long totalMatches = 0;
        for (Cow cow : cows) {
            for (int i = 0; i < 5; i++) {
                for (FlavorSet flavorSet : cow.flavorSets[i]) {
                    Long amount = amounts.get(flavorSet);
                    if (amount != null) {
                        if (i % 2 == 0) {
                            totalMatches += amount;
                        } else {
                            totalMatches -= amount;
                        }
                    }
                    amounts.merge(flavorSet, 1L, (a, b) -> a + b);
                }
            }
        }
        long totalPairs = (nLong * (nLong - 1L)) >> 1;
        writer.println(totalPairs - totalMatches);
    }

    static class Cow {
        final int[] flavors = new int[5];
        final FlavorSet[][] flavorSets = new FlavorSet[][] {
                new FlavorSet[5],
                new FlavorSet[10],
                new FlavorSet[10],
                new FlavorSet[5],
                new FlavorSet[1]
        };

        void readFlavors(BufferedReader br) throws IOException{
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                flavors[j] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(flavors);
        }

        void generateFlavorSets() {
            for (int i = 1; i < 32; i++) {
                FlavorSet flavorSet = new FlavorSet(bitsInNum[i]);
                for (int j = 0; j < bitsInNum[i]; j++) {
                    flavorSet.flavors[j] = flavors[whichFlavors[i][j]];
                }
                flavorSets[bitsInNum[i] - 1][combIx[i]] = flavorSet;
            }
        }
    }

    static class FlavorSet {
        final int[] flavors;

        FlavorSet(int flavorAmt) {
            this.flavors = new int[flavorAmt];
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            FlavorSet flavorSet = (FlavorSet) o;
            return Arrays.equals(flavors, flavorSet.flavors);
        }

        @Override
        public int hashCode() {
            return Arrays.hashCode(flavors);
        }
    }
}