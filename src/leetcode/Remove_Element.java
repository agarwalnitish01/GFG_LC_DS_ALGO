package leetcode;


class Remove_Element {
    public static int removeElement(int[] nums, int val) {
        int size = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[size] = nums[i];
                size++;
            }
        }
        return size;
    }

    public static void main (String[] args)
    {
        int[] nums = {3,2,2,3};
        int size = removeElement(nums,2);
        for(int i = 0 ; i< size;i++){
            System.out.print(nums[i] + " ");
        }
    }
}
