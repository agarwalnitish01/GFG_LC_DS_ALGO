package leetcode;

public class RotateMatrix {
    public static void main(String[] args) {



        int[][] mat = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        rotate(mat);

        for(int i = 0;i<3;i++) {
            for (int j = 0; j <3; j++) {
                System.out.print(mat[i][j]);
            }
            System.out.println();
        }

    }

    public static void rotate(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int k=0,l=0;
        int[][] result = new int[m][n];
        for(int i = 0;i<m;i++) {
            l=0;
            for (int j = n-1; j >= 0; j--) {
                result[k][l] = matrix[j][i];
                l++;
            }
            k++;
        }

        for(int i = 0;i<m;i++) {
            for(int j = 0; j <n; j++) {
                matrix[i][j] = result[i][j];
            }
        }
    }
}
