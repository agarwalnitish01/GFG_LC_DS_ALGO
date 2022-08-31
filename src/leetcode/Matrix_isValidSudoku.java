package leetcode;

import java.util.*;

public class Matrix_isValidSudoku {
    public static void main(String[] args) {
        char[][] mat = {
                {'5','3','.','.','7','.','.','.','.'}
                ,{'6','.','.','1','9','5','.','.','.'}
                ,{'.','9','8','.','.','.','.','6','.'}
                ,{'8','.','.','.','6','.','.','.','3'}
                ,{'4','.','.','8','.','3','.','.','1'}
                ,{'7','.','.','.','2','.','.','.','6'}
                ,{'.','6','.','.','.','.','2','8','.'}
                ,{'.','.','.','4','1','9','.','.','5'}
                ,{'.','.','.','.','8','.','.','7','9'}};

        System.out.println(isValidSudoku(mat));
    }

    public static boolean isValidSudoku(char[][] board) {
        int row = board.length;
        int col = board[0].length;
        HashSet<Character> rows = new HashSet<>();
        HashSet<Character> cols = new HashSet<>();
        HashMap<List<Integer>, HashSet<Character>> boxes = new HashMap<>();
        for (int i=0; i<row; i++) {

            for (int j=0; j<col; j++) {
                if (!boxes.containsKey(Arrays.asList(i/3, j/3))) {
                    boxes.put(Arrays.asList(i/3, j/3), new HashSet<>());
                }

                if (board[i][j]!='.' && rows.contains(board[i][j])){
                    return false;
                }else {
                    rows.add(board[i][j]);
                }

                if (board[j][i]!='.' && cols.contains(board[j][i])) {
                    return false;
                }else {
                    cols.add(board[j][i]);
                }

                if (board[i][j]!='.'&& boxes.get(Arrays.asList(i/3, j/3)).contains(board[i][j])) {
                    return false;
                } else {
                    boxes.get(Arrays.asList(i / 3, j / 3)).add(board[i][j]);
                }
            }
            rows.clear();
            cols.clear();
        }
        return true;

    }
}
