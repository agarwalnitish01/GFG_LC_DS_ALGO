package leetcode;

import java.util.*;

public class Triangle {
    public static int minimumTotal(List<List<Integer>> triangle) {

        for(int i = 1; i < triangle.size(); i++){
            List<Integer> prev = triangle.get(i-1);
            List<Integer> integers = triangle.get(i);
            for(int j = 0 ; j < integers.size() ; j++){
                int a = isValid(prev,j) ? prev.get(j) : Integer.MAX_VALUE;
                int b = isValid(prev,j-1) ? prev.get(j-1) : Integer.MAX_VALUE;
                integers.set(j,integers.get(j) + Math.min(a,b));
            }
        }

        int min = Integer.MAX_VALUE;
        for(int a : triangle.get(triangle.size()-1)){
            min = Math.min(min,a);
        }
        return min;
    }

    private static boolean isValid(List<Integer> prev, int i) {
        if(i>=0 && i < prev.size()){
            return true;
        }
        return false;
    }

    public static void main(String[] args){
        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();
        List<Integer> c = new ArrayList<>();
        List<Integer> d = new ArrayList<>();

        a.add(2);

        b.add(3);
        b.add(4);

        c.add(6);
        c.add(5);
        c.add(7);

        d.add(4);
        d.add(1);
        d.add(8);
        d.add(3);

        List<List<Integer>> lists = new ArrayList<>();
        lists.add(a);
        lists.add(b);
        lists.add(c);
        lists.add(d);

        System.out.print(minimumTotal(lists));
    }
}
