package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Pascal_Triangle {
    public static void main(String[] args) {

         int n = 5;

        List<List<Integer>> result = reshape2(n);

        for( List<Integer> a : result){
            for( Integer b : a){
                System.out.print(b);
            }
            System.out.println();
        }


    }

    public static List<List<Integer>> reshape2(int n) {
        List<List<Integer>> res = new ArrayList<>();
        int[][] result = new int[n][n];
        int i,j;
        for( i = 0 ;i<n;i++){
            Arrays.fill(result[i],-1);
        }

        for(i=0;i<n;i++){
            List<Integer> temp = new ArrayList<>();
            for(j=0;j<=i;j++){
                if(j - 1 >= 0 && j - 1 < n) {

                    result[i][j] =( result[i - 1][j - 1]==-1?0:result[i - 1][j - 1]) + (result[i - 1][j]==-1?0:result[i - 1][j]);
                    temp.add(result[i][j]);

                } else {
                    result[i][j] = 1;
                    temp.add(result[i][j]);
                }
            }
            res.add(temp);
        }
        return res;
    }
}
