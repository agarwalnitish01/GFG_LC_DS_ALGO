package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class Graphs_Matrix_Number_Of_Closed_Islands {

    public static int closedIsland(int[][] grid) {

        if (grid == null || grid.length == 0)
            return 0;

        int total = 0;
        int m = grid.length;
        int n = grid[0].length;


        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (grid[i][j] == 0) {
                    total = getTotal(grid, total, m, n, i, j);
                }
            }
        }

        return total;

    }

    private static int getTotal(int[][] grid, int total, int m, int n, int i, int j) {

        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i, j});
        grid[i][j] = 1;
        boolean closed = true;

        while (!q.isEmpty()) {
            int[] curr = q.poll();

            for (int[] dir : dirs) {
                int r = curr[0] + dir[0];
                int c = curr[1] + dir[1];

                if (r < 0 || c < 0 || r >= m || c >= n) {
                    closed = false;
                    continue;
                }

                if (grid[r][c] == 0) {
                    q.add(new int[]{r, c});
                    grid[r][c] = 1;
                }

            }
        }

        if (closed)
            total++;

        return total;
    }


    public static void main(String[] args) {
        int[][] mat = {
                {1,1,1,1,1,1,1,0},
                {1,0,0,0,0,1,1,0},
                {1,0,1,0,1,1,1,0},
                {1,0,0,0,0,1,0,1},
                {1,1,1,1,1,1,1,0}
        };

        System.out.println(closedIsland(mat));
    }
}
