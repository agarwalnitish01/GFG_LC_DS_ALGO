package leetcode;

import java.util.*;


public class Graphs_Matrix_Max_Area_Islands {

    public static int maxAreaOfIsland(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;
        int max = 0;
        for(int i = 0 ;i<m;i++){
            for( int j=0;j<n;j++){
                if(matrix[i][j]==1){
                    max = Math.max(max,bfs(matrix,i,j));
                }
            }
        }
        return max;

    }
    static int dfs(int[][] matrix,int i, int j)
    {
        if (i < 0 || j < 0 || i >= matrix.length || j >= matrix[i].length || matrix[i][j] == 0)
            return 0;

        matrix[i][j] = 0;
        int ans = 1;
        ans +=  dfs(matrix,i-1,j);
        ans += dfs(matrix,i+1,j);
        ans += dfs(matrix,i,j-1);
        ans += dfs(matrix,i,j+1);

        return ans;
    }


    public static void main(String[] args) {
        int[][] mat = {
                {1,1,1,1,0},
                {1,1,0,1,0},
                {1,0,0,0,0},
                {0,1,0,0,0}
        };

        System.out.println(maxAreaOfIsland(mat));
    }

    private static int bfs(int[][] grid, int x, int y) {
        int area = 1;
        int row = grid.length, col = grid[0].length;
        int[] dirX = {1, 0, 0, -1};
        int[] dirY = {0, 1, -1, 0};
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        grid[x][y] = 0;
        while (!queue.isEmpty()) {
            int[] c = queue.poll();
            for (int i = 0; i < 4; i++) {
                int x_new = c[0] + dirX[i];
                int y_new = c[1] + dirY[i];

                if (x_new < 0 || x_new >= row || y_new < 0 || y_new >= col) {
                    continue;
                }
                if (grid[x_new][y_new] == 1) {
                    area++;
                    grid[x_new][y_new] = 0;
                    queue.offer(new int[]{x_new, y_new});
                }
            }
        }
        return area;
    }
}
