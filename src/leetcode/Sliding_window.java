package leetcode;

import java.util.Deque;
import java.util.LinkedList;

class Sliding_window {
    public static int[] maxSlidingWindow(int[] arr, int K) {
        int N = arr.length;
        Deque<Integer> Qi = new LinkedList<>();

        int i;
        for (i = 0; i < K; ++i) {
            while (!Qi.isEmpty() && arr[i] >= arr[Qi.peekLast()]) {
                Qi.removeLast();
            }
            Qi.addLast(i);
        }

        int[] result = new int[N - K + 1];
        int count = 0;
        for (i = K; i < N; ++i) {

            result[count++] = arr[Qi.peek()];

            while ((!Qi.isEmpty()) && Qi.peek() <= i - K)
                Qi.removeFirst();

            while ((!Qi.isEmpty())
                    && arr[i] >= arr[Qi.peekLast()])
                Qi.removeLast();

            Qi.addLast(i);
        }
        result[count++] = arr[Qi.peek()];
        return result;
    }


    public static int[] maxSlidingWindow2(int[] arr, int K) {
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
        int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};
        int[] result = maxSlidingWindow(arr, 3);
        for (int i = 0; i < result.length; i++)
            System.out.print(result[i] + " ");

        System.out.println();

        int[] result2 = maxSlidingWindow2(arr, 3);
        for (int i = 0; i < result2.length; i++)
            System.out.print(result2[i] + " ");
    }
}

