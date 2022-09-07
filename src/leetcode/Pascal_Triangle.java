package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Pascal_Triangle {
    public static void main(String[] args) {

         int n = 3;

        List<Integer> result = reshape2(n);


            for( Integer b : result){
                System.out.print(b + " ");

        }


    }

    public static List<Integer> reshape2(int n) {
        ++n;
        List<List<Integer>> res = new ArrayList<>();
        int[][] result = new int[n+3][n+3];
        int i,j;
        for( i = 0 ;i<n;i++){
            Arrays.fill(result[i],-1);
        }

        for(i=0;i<n;i++){
            List<Integer> temp = new ArrayList<>();
            for(j=0;j<=i;j++){
                if(j - 1 >= 0 && j - 1 < n) {
                    result[i][j] =Math.max(result[i - 1][j - 1], 0) + (Math.max(result[i - 1][j], 0));
                } else {
                    result[i][j] = 1;
                }
                temp.add(result[i][j]);
            }
            res.add(temp);
        }

        return res.get(n-1);
    }
}
