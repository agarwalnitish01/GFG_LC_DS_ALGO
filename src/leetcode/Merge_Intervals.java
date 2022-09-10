package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Merge_Intervals {
    public static void main(String[] args) {
        int[][] intervals = {
                {1,3},
                {2,6},
                {8,10}
        };

        int[][] res = merge2(intervals);

        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                System.out.print(res[i][j]);
            }
            System.out.println();
        }
    }

    public static int[][] merge(int[][] intervals) {
        List<int[]> result = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int leftValue = intervals[0][0];
        int rightValue = intervals[0][1];
        for (int[] interval : intervals) {
            if (rightValue >= interval[0]) {
                rightValue = Math.max(rightValue, interval[1]);
            } else {
                result.add(new int[]{leftValue, rightValue});
                leftValue = interval[0];
                rightValue = interval[1];
            }
        }
        result.add(new int[]{leftValue, rightValue});
        return result.toArray(new int[result.size()][]);
    }

    public static int[][] merge2(int[][] intervals) {
        ArrayList<int[]> list = new ArrayList();
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);

        int i = 0;
        while(i<intervals.length){
            int min = intervals[i][0];
            int max = intervals[i][1];
            int j=i+1;
            while(j<intervals.length && max >= intervals[j][0]){
                min = Math.min(min,intervals[j][0]);
                max = Math.max(max,intervals[j][1]);
                j++;
            }
            list.add(new int[]{min,max});
            i=j;
        }

        return list.toArray(new int[list.size()][]);
    }
}
