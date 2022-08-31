package leetcode;

import java.util.*;

class Matrix_Interval_List_Intersections {
    public static void main(String[] args) {
        int[][] A = {
                {0,2},
                {5,8}
        };

        int[][] B = {
                {1,5},
                {8,12}
        };
        int[][] res = intervalIntersection(A,B);

        for(int i = 0;i<res.length;i++) {
            for (int j = 0; j <res[0].length; j++) {
                System.out.print(res[i][j]);
            }
            System.out.println();
        }
    }

    public static int[][] intervalIntersection(int[][] firstList, int[][] secondList) {

        List<int[]> intersections = new ArrayList<>();
        int i = 0, j = 0;

        while(i<firstList.length && j < secondList.length){
            int start = Math.max(firstList[i][0], secondList[j][0]);
            int end = Math.min(firstList[i][1], secondList[j][1]);

            if(end >= start){
                intersections.add(new int[]{start, end});
            }

            if(firstList[i][1] < secondList[j][1]){
                i++;
            }else {
                j++;
            }
        }
        return intersections.toArray(new int[intersections.size()][]);
    }
}
