package leetcode;

public class MergeTwoSortedArray {
    public static void merge(int[] A, int m, int[] B, int n) {
        int k = m + n - 1;
        int i = m - 1, j = n - 1;

        while (i >= 0 && j >= 0) {
            if (B[j] >= A[i]) {
                A[k--] = B[j--];
            } else {
                A[k--] = A[i--];
            }
        }

        while (i >= 0) {
            A[k--] = A[i--];
        }

        while (j >= 0) {
            A[k--] = B[j--];
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 0, 0, 0};
        int[] arr2 = {2, 5, 6};
        merge(arr1, 3, arr2, 3);

        for (int i = 0; i < arr1.length; i++)
            System.out.print(arr1[i] + " ");
    }
}
