package leetcode;
import java.util.*;

public class FirstPositiveMissing {
    public static  int firstMissingPositive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        int max = Integer.MIN_VALUE ;
        for(int a : nums){
            max = Math.max(max,a);
            set.add(a);
        }
        if(max==Integer.MAX_VALUE){
            max = Integer.MAX_VALUE-1;
        }
        int min = 1;
        for(int i = 1 ;i<=max+1;i++){
            if(!set.contains(i)){
                min = i;
                break;
            }
        }

        return min;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
         System.out.print(firstMissingPositive(arr));
    }
}
