package leetcode;

import java.util.*;


public class UglyNumber {
    public static void main(String[] args){
        int result = nthUglyNumber(5);

        System.out.println(result);
    }

    public static  int nthUglyNumber(int n) {
        int twoIndex = 0;
        int threeIndex = 0;
        int fiveIndex = 0;
        int temp = n;
        List<Integer> list = new ArrayList<>();
        list.add(1);
        while(temp-- >1){
            int by2 = list.get(twoIndex)*2;
            int by3 = list.get(threeIndex)*3;
            int by5 = list.get(fiveIndex)*5;

            int min = Math.min(by2,Math.min(by3,by5));
            list.add(min);
            if(min == by2){
                twoIndex++;
            }
            if(min == by3){
                threeIndex++;
            }
            if(min == by5){
                fiveIndex++;
            }
        }
        return list.get(n-1);
    }
}
