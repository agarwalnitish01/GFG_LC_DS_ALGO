package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Backtracking_Combinations {
    public static List<List<Integer>> combinations(int k ,int n) {
        int[] candidates = new int[n];
        for(int i = 1 ;i <=n;i++){
            candidates[i-1] = i;
        }
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates,new ArrayList<>(),result,0,k);
        return result;
    }

    private static void dfs(int[] candidates,ArrayList<Integer> current, List<List<Integer>> result,int j, int k) {
        if(current.size()==k){
            result.add(new ArrayList<>(current));
            return;
        }
        for(int i = j ;i<candidates.length;i++){
            if(i>j && candidates[i-1] == candidates[i])
                continue;
            current.add(candidates[i]);
            dfs(candidates,current,result,i+1,k);
            current.remove(current.size()-1);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> result = combinations(2,4);

        for(List<Integer> list : result){
            for(int a : list){
                System.out.print(a + " ");
            }
            System.out.println();
        }
    }
}
