package leetcode;


import java.util.ArrayList;
import java.util.List;

public class Graphs_Matrix_Paths_Source_To_Target {

    public static List<List<Integer>> allPathsSourceTarget(int[][] adjList) {
        int source = 0;
        int des = adjList.length-1;
        List<List<Integer>> result = new ArrayList<>();
        dfs(source, des, adjList, new ArrayList<>(), result);
        return result;
    }

    private static void dfs(int source, int dest, int[][] adjList, List<Integer> currPath, List<List<Integer>> result) {
        currPath.add(source);
        if (source == dest)
            result.add(new ArrayList<>(currPath));

        for (int neighbour : adjList[source]) {
            dfs(neighbour, dest, adjList, currPath, result);
        }

        currPath.remove(currPath.size() - 1);
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1,2},
                {3},
                {3},
                {}
        };
        List<List<Integer>> result = allPathsSourceTarget(matrix);

        for(List<Integer> list : result){
            for(int a : list){
                System.out.print(a + " ");
            }
            System.out.println();
        }
    }
}
