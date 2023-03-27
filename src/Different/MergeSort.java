package Different;

public class MergeSort {


    public static void mergeSort(int nums[], int l, int r) {
        if (l >= r) {
            return;
        }

        int mid = (r + l) / 2;

        mergeSort(nums, l, mid);
        mergeSort(nums, mid + 1, r);
        merge(nums, l, mid, r);
    }

    public static int[] merge(int[] nums, int si, int mid, int ei) {
        int i = si;
        int j = mid + 1;
        int[] temp = new int[ei - si + 1];
        int k = 0;

        while (i <= mid && j <= ei) {
            if (nums[i] < nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = nums[i++];
        }

        while (j <= ei) {
            temp[k++] = nums[j++];
        }

        for (int x = 0, y = si; x < temp.length; x++, y++) {
            nums[y] = temp[x];
        }
        return nums;
    }


    public static void main(String[] args) {
        int[] arr = {10,11,0,1,17,2,5};
        int k = 11;
        mergeSort(arr, 0, arr.length - 1);
        for(int a : arr){
            System.out.println(a);
        }

    }
}
