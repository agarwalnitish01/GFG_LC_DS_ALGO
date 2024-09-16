package leetcode;

import java.util.*;
// 2^n
public class Backtracking_CombinationSum_1 {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates,target,new ArrayList<>(),result,0);
        return result;
    }

    private static void dfs(int[] candidates, int target, ArrayList<Integer> current, List<List<Integer>> result,int j) {
        if( target == 0 ){
            result.add(new ArrayList<>(current));
            return;
        }
        if(target<0){
            return;
        }

        for(int i = j ;i<candidates.length;i++){
            current.add(candidates[i]);
            dfs(candidates,target-candidates[i],current,result,i);
            current.remove(current.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] arr = {2,5,2,1,2};
        List<List<Integer>> result = combinationSum(arr,5);

        for(List<Integer> list : result){
            for(int a : list){
                System.out.print(a + " ");
            }
            System.out.println();
        }
    }
}
