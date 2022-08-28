package leetcode;

public class FirstAndLastElementSortedArray {
    public static void main(String[] args){
        int[] arr = {5,7,7,8,8,10};
        int[] result = searchRange(arr,8);

        for(int i = 0 ;i<result.length;i++)
            System.out.println(result[i]);
    }

    public static int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int i=0,j;
        int[] result = new int[2];
        int start = -1;
        int end = -1;

        for (i=0;i<n;i++) {
            j=n-1-i;
            if (nums[i]==target && start==-1) {
                start = i;
            }
            if (nums[j]==target && end==-1) {
                end = j;
            }

            if(start>=0 && end >=0)
                break;
        }
        result[0] = start;
        result[1] = end;

        return result;
    }
}
