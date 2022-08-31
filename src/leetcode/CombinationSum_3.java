package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum_3 {
    public static List<List<Integer>> combinationSum(int[] candidates, int k ,int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates,target,new ArrayList<>(),result,0,k);
        return result;
    }

    private static void dfs(int[] candidates, int target, ArrayList<Integer> current, List<List<Integer>> result,int j, int k) {
        if( target == 0 && current.size()==k){
            result.add(new ArrayList<>(current));
            return;
        }
        if(target<0){
            return;
        }

        for(int i = j ;i<candidates.length;i++){
            if(i>j && candidates[i-1] == candidates[i])
                continue;
            current.add(candidates[i]);
            dfs(candidates,target-candidates[i],current,result,i+1,k);
            current.remove(current.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        List<List<Integer>> result = combinationSum(arr,3,9);

        for(List<Integer> list : result){
            for(int a : list){
                System.out.print(a + " ");
            }
            System.out.println();
        }
    }
}
