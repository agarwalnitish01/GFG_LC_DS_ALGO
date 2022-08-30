package leetcode;

public class Matrix_Reshape {
    public static void main(String[] args) {



        int[][] mat = {
                {1,2},
                {3,4}
        };
        int r=1;
        int c=4;

         int[][] res = reshape(mat,r,c);

        for(int i = 0;i<r;i++) {
            for (int j = 0; j <c; j++) {
                System.out.print(res[i][j]);
            }
            System.out.println();
        }

    }

    public static int[][] reshape(int[][] matrix, int r,int c) {
        int m = matrix.length;
        int n = matrix[0].length;

        if(m*n!=r*c){
            return matrix;
        }
        int[][] result = new int[r][c];
        int k=0,i,j;
        int[] arr = new int[r*c];
        for(i=0;i<m;i++) {
            for(j=0; j<n;j++) {
                arr[k] = matrix[i][j];
                k++;
            }
        }
        i=0;j=0;
        for(k=0; k<arr.length;k++) {
            if(j==c){
                j=0;
                i++;
            }
            result[i][j] = arr[k];
            j++;
        }
        return result;
    }

}
