package leetcode;


import java.util.ArrayList;
import java.util.List;

class Matrix_Spiral {

    // Function to print in spiral order
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<Integer>();

        if (matrix.length == 0)
            return ans;

        int m = matrix.length, n = matrix[0].length;
        boolean[][] seen = new boolean[m][n];
        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};
        int x = 0, y = 0, di = 0;


        for (int i = 0; i < m * n; i++) {
            ans.add(matrix[x][y]);
            seen[x][y] = true;
            int cr = x + dr[di];
            int cc = y + dc[di];

            if (isValid(m, n, cr, cc)
                    && !seen[cr][cc]) {
                x = cr;
                y = cc;
            } else {
                di = (di + 1) % 4;
                x = x + dr[di];
                y = y + dc[di];
            }
        }
        return ans;
    }

    private static boolean isValid(int m, int n, int cr, int cc) {
        return 0 <= cr && cr < m && 0 <= cc && cc < n;
    }

    // Driver Code
    public static void main(String[] args) {
        int a[][] = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}};

        System.out.println(spiralOrder(a));
    }

}

