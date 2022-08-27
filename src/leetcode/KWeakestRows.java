package leetcode;

import java.util.Arrays;

public class KWeakestRows {
    public static void main(String[] args) {
        int k = 3;


        int[][] mat = {{1, 1, 0, 0, 0},
                {1, 1, 1, 1, 0},
                {1, 0, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {1, 1, 1, 1, 1}};

        int[] arr = kWeakestRows(mat, k);

        for (int value : arr) {
            System.out.println(value);
        }
    }

    public static int[] kWeakestRows(int[][] mat, int k) {
        int M = mat.length;
        int N = mat[0].length;

        int[] arr = new int[M];
        for (int i = 0; i < M; i++) {
            int sum = 0;
            for (int j = 0; j < N; j++) {
                sum = sum + mat[i][j];
            }
            arr[i] = sum;
        }
        int[] unsorted = Arrays.copyOf(arr,arr.length);
        Arrays.sort(arr);
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = linearSearch(unsorted, arr[i]);

        }
        return result;
    }

    public static int linearSearch(int[] arr, int key){
        for(int i=0;i<arr.length;i++){
            if(arr[i] == key){
                arr[i] = Integer.MAX_VALUE;
                return i;
            }
        }
        return -1;
    }
}
