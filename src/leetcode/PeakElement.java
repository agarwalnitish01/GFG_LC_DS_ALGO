package leetcode;

public class PeakElement {
    public static void main(String[] args) {
        int[] arr = {1,2,3,1};
        System.out.println(peakElement(arr));
    }

    public static int peakElement(int[] arr) {

        if (arr.length == 1) {
            return 0;
        }
        int n = arr.length;
        for (int i = 1; i < n - 1; i++) {
            if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1])
                return i;
        }

        return arr[0] > arr[n - 1] ? 0 : n-1;
    }
}
