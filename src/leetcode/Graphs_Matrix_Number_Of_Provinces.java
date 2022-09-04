package leetcode;

import java.util.LinkedList;
import java.util.Queue;

class Graphs_Matrix_Number_Of_Provinces {

    public static int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int count = 0;

        for (int i = 0; i < n; i++) {

            if (!visited[i]) {
                count++;
                visited[i] = true;
            } else {
                continue;
            }

            Queue<Integer> queue = new LinkedList<>();
            queue.add(i);

            while (!queue.isEmpty()) {

                int node = queue.poll();

                for (int j = 0; j < n; j++) {
                    if (isConnected[node][j] == 1 && !visited[j]) {
                        queue.add(j);
                        visited[j] = true;
                    }
                }
            }

        }

        return count;
    }

    public static void main(String[] args) {
        int[][] mat = {{1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}};

        System.out.println(findCircleNum(mat));
        System.out.println(findCircleNum2(mat));
    }

    public static int findCircleNum2(int[][] matrix) {

        int n = matrix.length;

        if(n == 1)
            return 1;

        boolean[] visited = new boolean[n];
        int count = 0;

        for(int i = 0; i < n; i++)
        {
            if(!visited[i])
            {
                count++;
                dfs(matrix, i, visited);
            }
        }

        return count;
    }

    static void dfs(int[][] matrix, int i, boolean[] visited)
    {
        visited[i] = true;

        for(int j = 0; j < matrix.length; j++)
        {
            if(matrix[i][j] == 1 && visited[j]==false) {
                dfs(matrix, j, visited);
            }
        }
    }
}
