package Different;


import javafx.util.Pair;

import java.util.*;

public class Water_optimisation_MST {

    public static int supplyWater(int n, int[] wells, int[][] pipes) {
        int ans = 0;
        List<Pair<Integer, Integer>>[] graph = new List[n + 1];
        Queue<Pair<Integer, Integer>> minHeap =
                new PriorityQueue<>(Comparator.comparing(Pair::getKey)); // (d, u)

        for (int i = 0; i <= n; ++i)
            graph[i] = new ArrayList<>();

        for (int[] p : pipes) {
            final int u = p[0];
            final int v = p[1];
            final int w = p[2];
            graph[u].add(new Pair<>(v, w));
            graph[v].add(new Pair<>(u, w));
        }

        // Connect virtual 0 with node 1 to n.
        for (int i = 0; i < n; ++i) {
            graph[0].add(new Pair<>(i + 1, wells[i]));
            minHeap.offer(new Pair<>(wells[i], i + 1));
        }

        Set<Integer> mst = new HashSet<>(Arrays.asList(0));

        while (mst.size() < n + 1) {
            Pair<Integer, Integer> pair = minHeap.poll();
            final int d = pair.getKey();
            final int u = pair.getValue();
            if (mst.contains(u))
                continue;
            // Adding the new vertex
            mst.add(u);
            ans += d;
            // Expand if possible
            for (Pair<Integer, Integer> pair1 : graph[u]) {
                final int v = pair1.getKey();
                final int w = pair1.getValue();
                if (!mst.contains(v))
                    minHeap.offer(new Pair<>(w, v));
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
