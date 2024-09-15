package leetcode;

// Java implementation of the approach

class Meeting_room_II {
    static int minHalls(int lectures[][], int n) {

        // Array to store the number of
        // lectures ongoing at time t
        int[] prefix_sum = new int[100001];

        // For every lecture increment start
        // point s decrement (end point + 1)
        for (int i = 0; i < n; i++) {
            prefix_sum[lectures[i][0]]++;
            prefix_sum[lectures[i][1] + 1]--;
        }

        int ans = prefix_sum[0];

        // Perform prefix sum and update
        // the ans to maximum
        for (int i = 1; i < 100001; i++) {
            prefix_sum[i] += prefix_sum[i - 1];
            ans = Math.max(ans, prefix_sum[i]);
        }
        return ans;
    }

    // Driver code
    public static void main(String[] args) {
        int lectures[][] = {{0, 5},
                {1, 2},
                {1, 10}};
        int n = lectures.length;

        System.out.println(minHalls(lectures, n));
    }
}




