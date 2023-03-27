package leetcode;

import java.util.*;

class Subsets_II {
    public static List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        generateSubsets(0, nums, new ArrayList<>(), result);
        return result;
    }

    public static void generateSubsets(int j, int[] nums, List<Integer> current, List<List<Integer>> result) {
        if(!result.contains(current)) {
            result.add(new ArrayList<>(current));
        }

        for (int i = j; i < nums.length; i++) {
            current.add(nums[i]);
            generateSubsets(i + 1, nums, current, result);
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,2,2};
        List<List<Integer>> result = subsets(arr);

        for(List<Integer> list : result){
            for(int a : list){
                System.out.print(a + " ");
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> subsetsWithDup2(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());
        for(int i = 0 ; i<nums.length; i++){
            int size = ans.size();
            for(int j =0 ; j < size ; j++){
                List<Integer> sub = new ArrayList<>(ans.get(j));
                sub.add(nums[i]);
                Collections.sort(sub);
                if(!ans.contains(sub)){
                    ans.add(sub);
                }
            }
        }
        return ans;
    }
}
