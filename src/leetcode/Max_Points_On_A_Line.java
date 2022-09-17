package leetcode;

import javafx.util.Pair;

import java.util.*;

public class Max_Points_On_A_Line {

    static Pair getLine(int[] a, int[] b){
        if(a[0]==b[0])
            return new Pair<>(null,(double)a[0]);
        return new Pair<>((double)(a[1]-b[1])/(double)(a[0]-b[0]), a[1]-((double)(a[1]-b[1])/(double)(a[0]-b[0]))*a[0]);
    }

    public static int maxPoints(int[][] points) {
        int len=points.length,i,j,maxSize=1;
        HashMap<Pair,HashSet<Integer>> map = new HashMap<>();
        for(i=0;i<len;i++){
            for(j=i+1;j<len;j++){
                Pair<Double,Double> line=getLine(points[i],points[j]);
                HashSet<Integer> set = map.containsKey(line)? map.get(line) : new HashSet<>();
                set.add(i);
                set.add(j);
                map.put(line,set);
                maxSize=Math.max(maxSize,set.size());
            }
        }
        return maxSize;
    }

    public static void main(String[] args) {
        int[][] arr = {
                {1, 1},
                {3, 2},
                {5, 3},
                {4, 1},
                {2, 3},
                {1, 4}
        };

        System.out.print(maxPoints(arr));
    }
}
