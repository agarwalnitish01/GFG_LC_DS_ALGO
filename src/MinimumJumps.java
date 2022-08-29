class MinimumJumps {
    public static int jump(int[] nums) {
        int totalWindows = nums.length > 1 ? 1 : 0;
        int start = 0;
        int end = nums[0];
        while (end <= nums.length) {
            int maxReachableIdx = maxIndexReachableFromGivenWindow(nums, start, end);
            totalWindows++;
            start = end + 1;
            end = maxReachableIdx;
        }
        return totalWindows;
    }

    public static int maxIndexReachableFromGivenWindow(int[] array, int startIdx, int endIdx) {
        int max = endIdx;
        for (int i = startIdx; i <= endIdx; i++)
            max = Math.max(max, i + array[i]);
        return max;
    }

    private static int minJumps(int[] arr, int n)
    {
        int[] jumps = new int[n];
        // result
        int i, j;

        if (n == 0 || arr[0] == 0)
            return Integer.MAX_VALUE;

        jumps[0] = 0;

        for (i = 1; i < n; i++) {
            jumps[i] = Integer.MAX_VALUE;
            for (j = 0; j < i; j++) {
                if (j + arr[j]>=i) {
                    jumps[i] = Math.min(jumps[i], jumps[j] + 1);
                    break;
                }

            }
        }
        return jumps[n - 1];
    }

    static boolean canReach(int[] arr, int n){
        int jump = arr[0]-1;
        for(int i =1;i<n;i++){
            if(jump<0) {
                return false;
            }
            jump=Math.max(jump,arr[i]);
            jump--;
        }
        return true;
    }

    // Driver code
    public static void main(String[] args)
    {
        int[] arr = {1,2,2,3,0};
        int n = arr.length;
        System.out.println("Reachable ? "
                + canReach(arr, n ));
        System.out.println("Minimum number of jumps to reach end is "
                + jump(arr));

        System.out.print("Minimum number of jumps to reach end is "
                + minJumps(arr,  n ));
    }
}
 