package leetcode;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args){
        int[] arr = {2,7,11,15};

        int result[] = twoSum(arr,9);

        for(int res : result)
            System.out.println(res);
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0 ;i< nums.length;i++){
            if(map.containsKey(target-nums[i])){
                result[0] = map.get(target-nums[i]);;
                result[1] = i;
                break;
            }
            else
                map.put(nums[i],i);
        }
        return result;
    }
}
