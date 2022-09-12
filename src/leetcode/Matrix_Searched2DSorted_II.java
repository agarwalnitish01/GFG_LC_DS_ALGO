package leetcode;

public class Matrix_Searched2DSorted_II {
    public static void main(String[] args) {


        int[][] mat = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        int k = 7;
        System.out.println(searchMatrix(mat, k));
    }

    private static boolean searchMatrix(int[][] arr, int target) {
        int m = arr.length;
        int n = arr[0].length;
        int i = 0;
        int j = n - 1;

        while(i>=0 && i < m && j >= 0 && j<n) {
            if(target == arr[i][j]) {
                return true;
            } else if(target < arr[i][j]) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }
}
