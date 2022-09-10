package leetcode;

import java.util.HashMap;
import java.util.Map;

class SubArrayDivisibleByK {

    public static int subarraysDivByK(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int currSum = 0;
        int count = 0;

        map.put(0, 1);

        for(int i=0; i<arr.length; i++) {
            currSum = currSum + arr[i];
            int reminder = (currSum+k) % k;
            if(map.containsKey(reminder)) {
                count = count + map.get(reminder);
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
