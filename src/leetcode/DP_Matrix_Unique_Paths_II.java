package leetcode;

public class DP_Matrix_Unique_Paths_II {
    public static int uniquePathsWithObstacles(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        if (grid[m - 1][n - 1] == 1) {
            return 0;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    grid[i][j] = -50;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            if (grid[i][0] == -50)
                break;
            else
                grid[i][0] = 1;
        }

        for (int i = 0; i < n; i++) {
            if (grid[0][i] == -50)
                break;
            else
                grid[0][i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (grid[i][j] != -50) {
                    grid[i][j] = isValid(grid[i - 1][j]) + isValid(grid[i][j - 1]);
                }
            }
        }

        return grid[m - 1][n - 1] == -50 ? 0 : grid[m - 1][n - 1];
    }

    private static int isValid(int a) {
        return a == -50 ? 0 : a;
    }

    public static void main(String[] args) {
        int[][] arr = {
                {0, 1},
                {0, 0}
        };
        System.out.print(uniquePathsWithObstacles(arr));
    }
}
