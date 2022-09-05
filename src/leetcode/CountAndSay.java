package leetcode;

import java.util.*;

public class CountAndSay {

    public static void main(String[] args) {
        System.out.println(countUtil(3));
    }

    static String countUtil(int n){
        String res = "1";
        for(int i = 0 ;i<n-1;i++){
            int[] arr = new int[res.length()];
            int k = 0 ;
            for(int j = 0 ; j< res.length(); j++){
                arr[k++] = res.charAt(j)-48;
            }
            res = FrequencyCountAndCharacter(arr);
        }

        return res;
    }

    static String FrequencyCountAndCharacter(int[] arr)
    {
        String s = "";
        int count = 1;
        for(int i = 0 ;i< arr.length-1;i++){
            if(arr[i]==arr[i+1]){
                count++;
            } else {
                s = s + count + arr[i];
                count=1;
            }
        }
        s = s + count + arr[arr.length-1];
        return s;
    }
}
