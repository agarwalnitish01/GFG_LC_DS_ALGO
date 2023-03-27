package leetcode;

public class Best_Sightseeing_Pair {
    public static int maxScoreSightseeingPair(int[] values) {
        var maxScore = 0;
        int sumMax = values[0];
        for (int i = 1; i < values.length; i++) {
            maxScore = Math.max(maxScore, sumMax + values[i] - i);
            sumMax = Math.max(sumMax, values[i] + i);
        }
        return maxScore;
    }

    public static void main(String[] args) {

        int[] arr = {8,1,5,2,6};
        System.out.println(maxScoreSightseeingPair(arr));
    }
}
