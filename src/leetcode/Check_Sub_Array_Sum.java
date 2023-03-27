package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Check_Sub_Array_Sum {
    public static boolean checkSubarraySum(int[] nums, int k) {

        Map<Integer, Integer> modVals = new HashMap<>();
        modVals.put(0, -1);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
            int mod = sum % k;
            if (modVals.containsKey(mod)) {
                if (modVals.get(mod)+1<i){
                    return true;
                }
            } else
                modVals.putIfAbsent(mod, i);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {23,2,6,4,7};
        int fee = 6;
        System.out.println(checkSubarraySum(arr, fee));
    }
}
