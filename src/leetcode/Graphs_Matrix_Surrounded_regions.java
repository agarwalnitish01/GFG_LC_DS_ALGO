package leetcode;

class Graphs_Matrix_Surrounded_regions {
    public static void main(String[] args) {
        char[][] mat = {
                {'X','X','X','X'},
                {'X','O','O','X'},
                {'X','X','O','X'},
                {'O','O','X','X'}
        };

        char[][] mat1 = {
                {'O','O','O'},
                {'O','O','O'},
                {'O','O','O'}
        };

        numIslands(mat);

        for(int i = 0 ;i < mat.length; i++){
            for( int j = 0 ;j <mat[0].length; j++){
                System.out.print(mat[i][j]);
            }
            System.out.println();
        }
    }

    public static void numIslands(char[][] matrix) {

        int i,j;
        int m = matrix.length;
        int n = matrix[0].length;

        for(i = 0 ;i < m; i++) {
            for (j = 0; j < n; j++) {
                if (matrix[i][j] == 'O')
                    matrix[i][j] = '-';

            }
        }

        for (i = 0; i < m; i++)
            if (matrix[i][0] == '-')
                dfs(matrix, i, 0);

        for (i = 0; i < m; i++)
            if (matrix[i][n - 1] == '-')
                dfs(matrix, i, n - 1);

        for (i = 0; i < n; i++)
            if (matrix[0][i] == '-')
                dfs(matrix, 0, i);

        for (i = 0; i < n; i++)
            if (matrix[m - 1][i] == '-')
                dfs(matrix, m - 1, i);

        for(i = 0 ;i<m;i++){
            for( j=0;j<n;j++) {
                if (matrix[i][j] == '-') {
                    matrix[i][j] = 'X';
                }
            }
        }
    }

    static void dfs(char[][] matrix,int i, int j)
    {
        if (i < 0 || j < 0 || i >= matrix.length || j >= matrix[i].length || matrix[i][j] != '-')
            return;

        matrix[i][j] = 'O';
        dfs(matrix,i-1,j);
        dfs(matrix,i+1,j);
        dfs(matrix,i,j-1);
        dfs(matrix,i,j+1);

    }
}
