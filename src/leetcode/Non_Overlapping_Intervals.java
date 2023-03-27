package leetcode;

import java.util.Arrays;

public class Non_Overlapping_Intervals {
    public static void main(String[] args){
        int[][]  intervals = {
                {1,2},
                {2,3},
                {3,4},
                {1,3}
        };
        System.out.print(eraseOverlapIntervals(intervals));
}

    public static int eraseOverlapIntervals(int[][] intervals) {

        Arrays.sort   (intervals,(v1,v2)->(v1[1]-v2[1]));
        int count = 1;
        int end = intervals[0][1];
        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0]>=end){
                count++;
                end = intervals[i][1];
            }
        }
        return intervals.length-count;
    }
}
