package leetcode;

import java.util.ArrayList;
import java.util.List;

class Graphs_Matrix_Word_Search {
    public static void main(String[] args) {
        char[][] mat = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}};

        System.out.println(exist(mat, "ABCCED"));
    }

    public static boolean exist(char[][] board, String word) {

        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if(dfs(board, word.toCharArray(), i, i, 0)){
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public static boolean dfs(char[][] board, char[] word, int i, int j, int k) {
        if (k >= word.length || i >= board.length || j >= board[0].length || i < 0 || j < 0 || board[i][j] != word[k]) {
            return false;
        }
        if (k == word.length - 1) {
            return (board[i][j] == word[k]);
        }
        char temp = board[i][j];
        board[i][j] = '0';
        boolean left = dfs(board, word, i, j - 1, k + 1);
        boolean right = dfs(board, word, i, j + 1, k + 1);
        boolean top = dfs(board, word, i - 1, j, k + 1);
        boolean down = dfs(board, word, i + 1, j, k + 1);
        board[i][j] = temp;
        return left || right || top || down;
    }
}
