package leetcode;

import java.util.LinkedList;
import java.util.Queue;

class Matrix_Number_Of_Islands {
    public static void main(String[] args) {
        char[][] mat = {{'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','0','0','0','0'},
                {'0','1','0','0','0'}};

        System.out.println(numIslands(mat));
    }

    public static int numIslands(char[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;
        int count = 0;
        for(int i = 0 ;i<m;i++){
            for( int j=0;j<n;j++){
                if(matrix[i][j]=='1'){
                    count++;
                    dfs(matrix,i,j);
                }
            }
        }
        return count;

    }
    static void dfs(char[][] matrix,int i, int j)
    {
        if (i < 0 || j < 0 || i >= matrix.length || j >= matrix[i].length || matrix[i][j] == '0')
            return;

        matrix[i][j] = '0';
        dfs(matrix,i-1,j);
        dfs(matrix,i+1,j);
        dfs(matrix,i,j-1);
        dfs(matrix,i,j+1);

    }
}
