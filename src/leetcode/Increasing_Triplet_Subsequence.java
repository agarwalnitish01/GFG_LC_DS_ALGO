package leetcode;

public class Increasing_Triplet_Subsequence {
    public static boolean increasingTriplet(int[] nums) {
        if(nums.length<3)
            return false;
        int a = Integer.MAX_VALUE;
        int b = Integer.MAX_VALUE;
        int c = Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++)
        {
            nums[i] = nums[i] -1;
            if(nums[i]<=a)
            {
                a=nums[i];

            }
            else if(nums[i]<=b)
            {
                b=nums[i];

            }
            else if(nums[i]<=c)
            {
                c=nums[i];

            }
            else
                System.out.println(a+" "+b+" "+c);
            if(a<Integer.MAX_VALUE && b<Integer.MAX_VALUE && c<Integer.MAX_VALUE)
                return true;

        }
        return false;
    }

    public static void main(String args[]){
        int[] nums = {4,5,2147483647,1,2};
        System.out.println(increasingTriplet(nums));
    }
}
