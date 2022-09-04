package leetcode;

import java.util.ArrayDeque;
import java.util.Queue;

class Graphs_Matrix_Shortest_Path_Corner {


    public static int shortestPathBinaryMatrix(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        boolean [][] visited = new boolean [m][n];

        int [] up =   {0, 0, 1, -1, 1, 1, -1, -1};
        int [] down = {-1, 1, 0, 0, -1, 1, -1, 1};

        if(grid[0][0] == 1 || grid[m-1][n-1] == 1)
            return -1;

        ArrayDeque<int []> q = new ArrayDeque<>();
        q.add(new int[]{0,0,1});
        visited[0][0] = true;

        while(!q.isEmpty()){
            int [] tmp = q.removeFirst();
            int x = tmp[0];
            int y = tmp[1];
            int steps = tmp[2];
            visited[x][y] = true;

            if(x == m-1 && y == n-1)
                return steps;

            for(int i = 0; i < 8; i++){
                int x_new = x + up[i];
                int y_new = y + down[i];

                if(isValid(m, n, x_new, y_new)){
                    if(visited[x_new][y_new] == false && grid[x_new][y_new] == 0){
                        q.add(new int[]{x_new,y_new,steps+1});
                        visited[x_new][y_new] = true;
                    }
                }
            }
        }

        return -1;
    }

    private static boolean isValid(int m, int n, int row, int col) {
        return row >= 0 && row < m && col >= 0 && col < n;
    }

    public static void main(String[] args) {
        int[][] mat = {
                {0, 0, 0},
                {1, 1, 0},
                {1, 1, 0}
        };

        System.out.println(shortestPathBinaryMatrix(mat));
    }
}
