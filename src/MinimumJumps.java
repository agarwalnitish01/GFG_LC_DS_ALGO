import java.util.Arrays;

class MinimumJumps {

    public static int jump(int[] nums) {
        int farthest=0;
        int current=0;
        int jump=0;

        if(nums.length==1)
            return 0;
        for( int i=0;i<nums.length-1;i++){
            farthest=Math.max(farthest,nums[i]+i);
            if(i==current){
                current=farthest;
                jump++;
            }
        }
        return jump;
    }

    public static int jumpDP(int[] arr) {
        int i,j;
        int n = arr.length;
        int[] jumps = new int[arr.length];
        jumps[0] = 0;
        for(i = 1 ;i<n;i++){
            jumps[i] = Integer.MAX_VALUE;
            for(j=0;j<i;j++){
                if(j+arr[j]>=i){
                    jumps[i]  = Math.min(jumps[i],jumps[j]+1);
                    break;
                }
            }
        }
        return jumps[n-1];
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

    static boolean canReachDP(int[] nums){
        int n = nums.length;
        if(n<=1)
            return true;
        if(nums[0]==0)
            return false;
        int[] dp =new int[n];
        dp[0]=nums[0];

        for(int i=1;i<n;i++){
            dp[i] = Math.max(dp[i-1]-1,nums[i]);
            if(dp[i]==0 && i!=n-1){
                return false;
            }
        }

        return true;
    }

    // Driver code
    public static void main(String[] args)
    {
        int[] arr = {2,3,1,2,4,2};
        int n = arr.length;
        System.out.println("Reachable - "
                + canReach(arr, n ));
        System.out.print("Minimum number of jumps to reach end is "
                + jumpDP(arr ));
        System.out.print("Minimum number of jumps to reach end is "
                + jump(arr ));
    }
}
 