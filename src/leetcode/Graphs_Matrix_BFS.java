package leetcode;


import java.util.*;

class Graphs_Matrix_BFS {

    static boolean isValid(boolean[][] vis,int row, int col) {

        return row >= 0 && row < vis.length && col >= 0 && col < vis[0].length;
    }

    static List<Integer> BFS(int[][] grid) {
        int [] up =   {0, 0, 1, -1, 1, 1, -1, -1};
        int [] down = {-1, 1, 0, 0, -1, 1, -1, 1};

        boolean[][] vis = new boolean[grid.length][grid[0].length];
        List<Integer> result = new ArrayList<>();

        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{0, 0});
        vis[0][0] = true;

        while (!q.isEmpty()) {
            int [] cell = q.removeFirst();
            int x = cell[0];
            int y = cell[1];
            vis[x][y] = true;
            result.add(grid[x][y]);

            for (int i = 0; i < up.length; i++) {
                int x_new = x + up[i];
                int y_new = y + down[i];

                if (isValid(vis, x_new, y_new) && vis[x_new][y_new] == false) {
                    q.add(new int[]{x_new, y_new});
                    vis[x_new][y_new] = true;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {

        int[][] grid = {
                        {1, 2, 3, 4},
                        {5, 6, 7, 8},
                        {9, 10, 11, 12},
                        {13, 14, 15, 16}
        };
        // BFS - 1 2 5 6 3 7 9 10 11 4 8 12 13 14 15 16
        // DFS - 1 6 3 8 11 16 12 7 4 2 5 10 15 14 9 13
        List<Integer> integers = BFS(grid);

        for(Integer integer : integers){
            System.out.print(integer + " ");
        }
    }
}
