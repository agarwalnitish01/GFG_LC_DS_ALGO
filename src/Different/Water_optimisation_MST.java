package Different;


import java.util.*;

public class Water_optimisation_MST {

    public static int supplyWater(int n, int[] wells, int[][] pipes) {
        int ans = 0;
        List<PairKeyValueInteger<Integer, Integer>>[] graph = new List[n + 1];
        Queue<PairKeyValueInteger<Integer, Integer>> minHeap =
                new PriorityQueue<>(Comparator.comparing(PairKeyValueInteger::getKey)); // (d, u)

        for (int i = 0; i <= n; ++i)
            graph[i] = new ArrayList<>();

        for (int[] p : pipes) {
            final int u = p[0];
            final int v = p[1];
            final int w = p[2];
            graph[u].add(new PairKeyValueInteger<>(v, w));
            graph[v].add(new PairKeyValueInteger<>(u, w));
        }

        // Connect virtual 0 with node 1 to n.
        for (int i = 0; i < n; ++i) {
            graph[0].add(new PairKeyValueInteger<>(i + 1, wells[i]));
            minHeap.offer(new PairKeyValueInteger<>(wells[i], i + 1));
        }

        Set<Integer> mst = new HashSet<>(List.of(0));

        while (mst.size() < n + 1) {
            PairKeyValueInteger<Integer, Integer> pair = minHeap.poll();
            final int d = pair.getKey();
            final int u = pair.getValue();
            if (mst.contains(u))
                continue;
            // Adding the new vertex
            mst.add(u);
            ans += d;
            // Expand if possible
            for (PairKeyValueInteger<Integer, Integer> pair1 : graph[u]) {
                final int v = pair1.getKey();
                final int w = pair1.getValue();
                if (!mst.contains(v))
                    minHeap.offer(new PairKeyValueInteger<>(w, v));
            }
        }

        return ans;

    }

    public static void main(String args[]){
        int[] wells = {1,2,2};
        int[][] pipes = { {1,2,1},{2,3,1}};
        System.out.print(supplyWater(3,wells,pipes));
    }
}
