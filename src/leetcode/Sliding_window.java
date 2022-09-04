package leetcode;

import java.util.*;

class Sliding_window {

    public static int[] maxSlidingWindow(int[] arr, int K) {
        int N = arr.length;
        int[] result = new int[N - K + 1];
        int count = 0;

        for (int i = 0; i < N - K + 1; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = i; j < i + K; j++) {
                if (arr[j] > max)
                    max = arr[j];
            }
            result[count++] = max;
        }
        return result;
    }

    // Driver code
    public static void main(String[] args) {
        int[] arr = {1,3,-1,-3,5,3,6,7};
        int[] result = maxSlidingWindow2(arr, 3);
        for (int value : result)
            System.out.print(value + " ");

    }

    public static int[] maxSlidingWindow2(int[] nums, int k) {
        Deque<Integer> deque = new ArrayDeque<>();
        int[] result = new int[nums.length-k+1];

        int i,window=0,j=0;
        for(i=0; i<nums.length; i++) {
            if(window < k)
                window++;
            else if(deque.size()>0 && deque.peek() == i-k) {
                deque.pollFirst();
            }

            while(deque.size()>0 && nums[i] > nums[deque.peekLast()]) {
                deque.pollLast();
            }

            deque.add(i);

            if(window >= k) {
                result[j] = nums[deque.peek()];
                j++;
            }
        }

        return result;
    }
}

