
import java.util.LinkedList;
import java.util.Queue;

public class Minimum_Time_Orange_Rotten {

    static boolean isValid(int i, int j, int[][] matrix, int m, int n) {
        return (i >= 0 && j >= 0 && i < m && j < n && matrix[i][j] == 1);
    }


    static boolean checkAll(int[][] arr, int m, int n) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 1) {
                    return true;
                }
            }
        }
        return false;
    }


    static int rotOranges(int[][] arr) {
        int m = arr.length;
        int n = arr[0].length;

        Queue<int[]> Q = new LinkedList<>();
        int[] temp;
        int ans = 0;
        int x_new, y_new;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 2) {
                    Q.add(new int[]{i, j});
                }
            }
        }


        while (!Q.isEmpty()) {
            boolean flag = false;
            int size = Q.size();
            for (int i = 0; i < size; i++) {
                temp = Q.peek();

                x_new = temp[0] + 1;
                y_new = temp[1];
                if (isValid(x_new, y_new, arr, m, n)) {
                    flag = true;
                    arr[x_new][y_new] = 2;
                    Q.add(new int[]{x_new, y_new});
                }

                x_new = temp[0] - 1;
                y_new = temp[1];
                if (isValid(x_new, y_new, arr, m, n)) {
                    flag = true;
                    arr[x_new][y_new] = 2;
                    Q.add(new int[]{x_new, y_new});
                }

                x_new = temp[0];
                y_new = temp[1] + 1;
                if (isValid(x_new, y_new, arr, m, n)) {
                    flag = true;
                    arr[x_new][y_new] = 2;
                    Q.add(new int[]{x_new, y_new});
                }

                x_new = temp[0];
                y_new = temp[1] - 1;
                if (isValid(x_new, y_new, arr, m, n)) {
                    flag = true;
                    arr[x_new][y_new] = 2;
                    Q.add(new int[]{x_new, y_new});
                }
                Q.remove();

            }
            if (flag) {
                ans++;
            }
        }

        return (checkAll(arr, m, n)) ? -1 : ans;

    }

    // Driver program
    public static void main(String[] args) {
        int[][] arr = {
                {2, 1, 0, 2, 1},
                {1, 0, 1, 2, 1},
                {1, 0, 0, 2, 1}
        };
        int ans = rotOranges(arr);
        if (ans == -1)
            System.out.println("All oranges cannot rot");
        else
            System.out.println("Time required for all oranges to rot = " + ans);
    }

}