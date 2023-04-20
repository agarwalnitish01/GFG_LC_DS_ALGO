package Different;

class RodCutting {

    /* Returns the best obtainable price for a rod of length
    n and price[] as prices of different pieces */
    public static int cutRod(int[] prices, int n) {

        int[][] mat = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    mat[i][j] = 0;
                } else {
                    if (i == 1) {
                        mat[i][j] = j * prices[i - 1];
                    } else {
                        if (i > j) {
                            mat[i][j] = mat[i - 1][j];
                        } else {
                            mat[i][j] = Math.max(prices[i - 1] + mat[i][j - i], mat[i - 1][j]);
                        }
                    }
                }
            }
        }

        return mat[n][n];
    }

    /* Driver program to test above functions */
    public static void main(String args[]) {
        int arr[] = {1, 5, 8, 9, 10, 17, 17, 20};
        int size = arr.length;
        System.out.println("Maximum Obtainable Value is "
                + cutRod(arr, size));
    }
}
