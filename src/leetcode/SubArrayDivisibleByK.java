package leetcode;

import java.util.HashMap;
import java.util.Map;

class SubArrayDivisibleByK {

    public static int subarraysDivByK(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int count = 0;
        int currSum = 0;

        for(int i=0; i<arr.length; i++) {
            currSum = currSum + arr[i];
            int remainder = (currSum+k) % k;
            if(map.containsKey(remainder)) {
                count = count + map.get(remainder);
            }
            map.put(remainder, map.getOrDefault(remainder, 0)+1);
        }
        return count;
    }

    public static void main(String[] args) {

        int arr[] = {4, 5, 0, -2, -3, 1};
        int k = 5;
        System.out.println(subarraysDivByK(arr, k));
    }
}
