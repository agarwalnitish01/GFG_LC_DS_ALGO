package leetcode;

public class DP_Matrix_Unique_Paths_III {
    public static int uniquePathsIII(int[][] grid) {
        int nonObstacleCells = getNonObstacles(grid);
        int[] startingSquare = getStartingSquare(grid);
        return dfs(grid, nonObstacleCells + 1, startingSquare[0], startingSquare[1]);
    }

    public static int dfs(int[][] grid, int nonObstacleCells, int row, int col) {
        if (row < 0 || col < 0 || row == grid.length || col == grid[0].length || grid[row][col] == -1) {
            return 0;
        }

        if (grid[row][col] == 2) {
            if (nonObstacleCells == 0) {
                return 1;
            }else {
                return 0;
            }
        }

        grid[row][col] = -1;

        int result = dfs(grid, nonObstacleCells - 1, row + 1, col)
                + dfs(grid, nonObstacleCells - 1, row - 1, col)
                + dfs(grid, nonObstacleCells - 1, row, col + 1)
                + dfs(grid, nonObstacleCells - 1, row, col - 1);

        grid[row][col] = 0;

        return result;
    }

    static int getNonObstacles(int[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0)
                    count++;
            }
        }
        return count;
    }

    static int[] getStartingSquare(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1)
                    return new int[] {i, j};
            }
        }
        return new int[0];
    }

    public static void main(String[] args) {
        int[][] arr = {
                {1, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 2}
        };
        System.out.print(uniquePathsIII(arr));
    }
}
