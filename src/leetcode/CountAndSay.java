package leetcode;

import java.util.*;

public class CountAndSay {

    public static void main(String[] args) {
        System.out.println(countUtil(4));
    }

    static String countUtil(int n){
        String res = "1";
        for(int i = 0 ;i<n-1;i++){
            char[] arr = res.toCharArray();
            res = FrequencyCountAndCharacter(arr);
        }

        return res;
    }

    static String FrequencyCountAndCharacter(char[] arr)
    {
        String s = "";
        int count = 1;
        for(int i = 0 ;i< arr.length-1;i++){
            if(arr[i]==arr[i+1]){
                count++;
            } else {
                char freq = (char) (count + 48);
                s = s + freq + arr[i];
                count=1;
            }
        }
        char freq = (char) (count + 48);
        s = s + freq + arr[arr.length-1];
        return s;
    }
}
