package leetcode;

public class DP_Delete_And_Earn {
    public static void main(String[] args) {
        int[] arr = {2,2,3,3,3,4,7,7,6,8};
        System.out.println(deleteAndEarn(arr));
        System.out.println(deleteAndEarn2(arr));
    }

    public static int deleteAndEarn(int[] nums) {
        int max=Integer.MIN_VALUE;
        for(int x: nums){
            max = Math.max(max,x);
        }
        int[] arr = new int[max+1];
        for(int x: nums){
            arr[x]+=x;
        }
        for(int i=2; i<max+1; i++){
            arr[i] = Math.max(arr[i]+arr[i-2], arr[i-1]);
        }
        return arr[max];
    }

    public static int deleteAndEarn2(int[] nums) {
        int max=Integer.MIN_VALUE;
        for(int x: nums){
            max = Math.max(max,x);
        }
        int[] arr = new int[max+2];
        for(int x: nums){
            arr[x]+=x;
        }
        for(int i=1; i<max+1; i++){
            arr[i+1] = Math.max(arr[i-1]+arr[i+1], arr[i]);
        }
        return arr[max];
    }
}
