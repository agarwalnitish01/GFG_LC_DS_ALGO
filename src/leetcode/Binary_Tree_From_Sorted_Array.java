package leetcode;

public class Binary_Tree_From_Sorted_Array {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0)
            return null;
        return createBST(nums, 0, nums.length - 1);
    }


    public static void main(String[] args) {
        int[] arr = {7, 1, 4, 2, 6, 9};
        System.out.println(sortedArrayToBST(arr));
    }

    public static TreeNode createBST(int[] nums, int start, int end) {
        if (end < start)
            return null;
        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = createBST(nums, start, mid - 1);
        root.right = createBST(nums, mid + 1, end);
        return root;
    }


}
