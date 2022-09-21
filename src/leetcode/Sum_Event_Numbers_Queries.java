package leetcode;


class Sum_Event_Numbers_Queries {
    public static int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int sum = 0;
        for (int a : nums) {
            if (a % 2 == 0) {
                sum = sum + a;
            }
        }
        int[] result = new int[queries.length];
        int k = 0;

        for (int[] a : queries) {
            if (nums[a[1]] % 2 == 0) {
                sum = sum - nums[a[1]];
            }
            nums[a[1]] = nums[a[1]] + a[0];
            if (nums[a[1]] % 2 == 0) {
                sum = sum + nums[a[1]];
            }
            result[k] = sum;
            k++;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        int[][] queries = {
                {1, 0},
                {-3, 1},
                {-4, 0},
                {2, 3}
        };
        int[] result = sumEvenAfterQueries(nums, queries);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }
}
