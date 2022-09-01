package leetcode;

import java.util.*;

class Backtracking_Permutations {

    public static List<List<Integer>> permuteUnique(int[] candidates) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int n : candidates) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        dfs(candidates, new ArrayList<>(), result, map);
        return result;
    }

    private static void dfs(int[] candidates, List<Integer> current, List<List<Integer>> result, HashMap<Integer, Integer> map) {
        if (current.size() == candidates.length) {
            result.add(new ArrayList<>(current));
            return;
        }
        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
            if(entry.getValue() > 0) {
                current.add(entry.getKey());
                map.put(entry.getKey(), entry.getValue() - 1);
                dfs(candidates, current,result, map);
                map.put(entry.getKey(), entry.getValue() + 1);
                current.remove(current.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,2,2};
        List<List<Integer>> result = permuteUnique(arr);

        for(List<Integer> list : result){
            for(int a : list){
                System.out.print(a + " ");
            }
            System.out.println();
        }
    }
}
