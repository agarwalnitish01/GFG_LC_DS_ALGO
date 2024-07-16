package leetcode;

import java.util.Arrays;

public class MinimumNumberForNBouqets {
    public static void main(String args[]){
        int[] arr = {7,7,7,7,12,7,7};
        int m =2;
        int k = 3;
        int days = minDaysForMBouqets(arr,m,k);
        System.out.println(days);
    }

    private static int minDaysForMBouqets(int[] bloomDay, int m, int k) {
        int start = 1;
        int end = Arrays.stream(bloomDay).max().getAsInt();
        int ans = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            int currLength = 0;
            int count = 0;

            for (int i = 0; i < bloomDay.length; i++) {
                if (bloomDay[i] <= mid) {
                    currLength++;
                    if (currLength >= k) {
                        currLength = 0;
                        count++;
                    }
                } else {
                    currLength = 0;
                }
            }

            if (count >= m) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return ans;
    }

}
