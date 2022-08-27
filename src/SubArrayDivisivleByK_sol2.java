import java.util.*;

class SubArrayDivisivleByK_sol2 {

    public static int subarraysDivByK(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int currSum = 0;
        int count = 0;

        map.put(0, 1);

        for(int i=0; i<nums.length; i++) {
            currSum += nums[i];
            int reminder = (currSum+k) % k;
            if(map.containsKey(reminder)) {
                count += map.get(reminder);
            }
            map.put(reminder, map.getOrDefault(reminder, 0)+1);
        }
        return count;
    }

    public static void main(String[] args) {

        int arr[] = {4, 5, 0, -2, -3, 1};
        int k = 5;
        System.out.println(subarraysDivByK(arr, k));
    }
}
