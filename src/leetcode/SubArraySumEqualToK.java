package leetcode;

import java.util.HashMap;
import java.util.Map;

public class SubArraySumEqualToK {

    static int findSubarraySum(int[] arr, int n, int sum) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int count = 0;
        int currSum = 0;

        for (int i = 0; i < n; i++) {
            currSum = currSum + arr[i];
            int removeSum = currSum - sum;
            if (map.containsKey(removeSum)) {
                count = count + map.get(removeSum);
            }
            map.put(currSum, map.getOrDefault(currSum, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {

        int arr[] = {10, 2, -2, -20, 10};
        int sum = -10;
        int n = arr.length;
        System.out.println(findSubarraySum(arr, n, sum));
    }
}
