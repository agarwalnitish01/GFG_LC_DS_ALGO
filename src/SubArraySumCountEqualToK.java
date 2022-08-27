import java.util.HashMap;

public class SubArraySumCountEqualToK {

    static int findSubarraySum(int arr[], int n, int sum) {
        HashMap<Integer, Integer> prevSum = new HashMap<>();
        prevSum.put(0, 1);
        int res = 0;

        int currSum = 0;

        for (int i = 0; i < n; i++) {
            currSum += arr[i];
            int removeSum = currSum - sum;
            if (prevSum.containsKey(removeSum)) {
                res += prevSum.get(removeSum);
            }
            prevSum.put(currSum, prevSum.getOrDefault(currSum, 0) + 1);
        }
        return res;
    }

    public static void main(String[] args) {

        int arr[] = {10, 2, -2, -20, 10};
        int sum = -10;
        int n = arr.length;
        System.out.println(findSubarraySum(arr, n, sum));
    }
}
