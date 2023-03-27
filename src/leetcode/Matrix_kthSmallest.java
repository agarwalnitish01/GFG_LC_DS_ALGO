package leetcode;

class Matrix_kthSmallest {
    public static int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;

        int low = matrix[0][0]; // first element
        int high = matrix[n - 1][n - 1]; // Last element

        int mid, temp, count;

        while (low < high) {
            mid = low + (high - low) / 2;
            temp = n - 1;
            count = 0;

            // For each row count the elements that are smaller than mid
            for (int i = 0; i < n; i++) {

                while (temp >= 0 && matrix[i][temp] > mid) {
                    temp--;
                }
                count += (temp + 1);
            }

            if (count < k) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;

    }

    public static void main(String[] args) {
        int[][] arr = {{1,5,9},
                {10,11,13},
                {12,13,15}};
        System.out.println(kthSmallest(arr, 2));
    }
}

