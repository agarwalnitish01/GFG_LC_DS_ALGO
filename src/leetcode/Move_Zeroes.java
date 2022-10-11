package leetcode;

public class Move_Zeroes {
    public static void moveZeroes(int[] nums) {
        int n = nums.length;
        int k=0;
        for(int i = 0 ; i<n; i++){
            nums[k] = nums[i];
            if(nums[i]!=0){
                k++;
            }
        }

        for(int i=k;i<n;i++)
            nums[i]=0;
    }

    public static void main(String args[]){
        int[] nums = {0,1,0,3,12};
        moveZeroes(nums);
        for(int a : nums) {
            System.out.println(a);
        }
    }
}
