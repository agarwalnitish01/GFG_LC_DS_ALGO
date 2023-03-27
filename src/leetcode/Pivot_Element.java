package leetcode;

public class Pivot_Element {
    public static void main(String args[]){
        int[] nums = {1,7,3,6,5,6};
        System.out.print(pivotIndex(nums));
    }

    public static int pivotIndex(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];

        left[0] = nums[0];
        for(int i=1;i<n;i++)
            left[i] = nums[i]+ left[i-1];

        right[n-1] = nums[n-1];
        for(int i=n-2;i>=0;i--)
            right[i] = nums[i] + right[i+1];

        for(int i =1 ; i<n-1;i++){
            if(left[i-1]==right[i+1])
                return i;
        }
        return -1;
    }
}
