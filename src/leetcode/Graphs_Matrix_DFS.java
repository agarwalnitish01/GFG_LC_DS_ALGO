package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Graphs_Matrix_DFS {


    static Boolean isValid(boolean[][] vis, int row,
                           int col) {

        if (row < 0 || col < 0 ||
                row >= vis.length || col >= vis[0].length)
            return false;

        if (vis[row][col]==true)
            return false;

        return true;
    }

    static List<Integer> DFS(int[][] grid) {

        int [] up =   {0, 0, 1, -1, 1, 1, -1, -1};
        int [] down = {-1, 1, 0, 0, -1, 1, -1, 1};

        boolean[][] vis = new boolean[grid.length][grid[0].length];
        List<Integer> result = new ArrayList<>();

        Stack<int[]> st = new Stack<>();
        st.push(new int[]{0, 0});

        while (!st.empty()) {
            int [] cell = st.pop();
            int x = cell[0];
            int y = cell[1];

            if (!isValid(vis, x, y))
                continue;

            vis[x][y] = true;
            result.add(grid[x][y]);

            for (int i = 0; i < up.length; i++) {
                int new_x = x + up[i];
                int new_y = y + down[i];
                st.push(new int[]{new_x, new_y});
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

        List<Integer> integers = DFS(grid);

        for(Integer integer : integers){
            System.out.print(integer + " ");
        }
    }
}
