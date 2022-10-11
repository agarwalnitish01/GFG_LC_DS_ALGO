package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class Zero_Distance_One_Matrix {
    public static int[][] updateMatrix(int[][] matrix) {
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int r = matrix.length;
        int c = matrix[0].length;
        boolean[][] visited = new boolean[r][c];

        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (matrix[i][j] == 0) {
                    q.add(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }

        int step = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int k = 0; k < size; k++) {
                int[] temp = q.poll();
                for (int[] dir : dirs) {
                    int x = temp[0] + dir[0];
                    int y = temp[1] + dir[1];
                    if (x >= 0 && x < r && y >= 0 && y < c && !visited[x][y]) {
                        visited[x][y] = true;
                        matrix[x][y] = step;
                        q.add(new int[]{x, y});
                    }
                }
            }
            step++;
        }

        return matrix;
    }

    public static void main(String[] args) {
        int[][] mat = {
                {0, 0, 0},
                {0, 1, 0},
                {1, 1, 1}
        };
        mat = updateMatrix(mat);
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }
}
