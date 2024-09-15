package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Course_Schedule_II {
    /*
    Complexity
Time complexity :- 𝑂(𝑛+𝑚) where 𝑛 is the number of courses (nodes) and 𝑚 is the number of prerequisite pairs (edges). We process each node and edge exactly once.

Space complexity :- 𝑂(𝑛+𝑚), for storing the adjacency list and the indegree array.
     */
    public int[] findOrder(int n, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        int m =prerequisites.length;
        for (int i = 0; i < m; i++) {
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        int indegree[] = new int[n];
        for (int i = 0; i < n; i++) {
            for (int it : adj.get(i)) {
                indegree[it]++;
            }
        }
        Queue<Integer> q = new LinkedList<Integer>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }
        int topo[] = new int[n];
        int index = 0;
        while (!q.isEmpty()) {
            int node = q.peek();
            q.remove();
            topo[index++] = node;
            for (int it : adj.get(node)) {
                indegree[it]--;
                if (indegree[it] == 0) q.add(it);
            }
        }
        if (index == n) return topo;
        int[] arr = {};
        return arr;
    }
}
