package leetcode;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

class Graphs_Matrix_Minimum_Vertices_To_Reach_All {

    public static List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        int[] inDegree = new int[n];
        List<Integer> ans = new ArrayList<>();
        for(List<Integer> edge: edges) {
            inDegree[edge.get(1)]++;
        }

        for(int i=0;i<n;i++) {
            if (inDegree[i] == 0) {
                ans.add(i);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        List<List<Integer>> num = new ArrayList<>();
        List<Integer> a =  new ArrayList<>();
        a.add(0);
        a.add(1);
        List<Integer> b =  new ArrayList<>();
        b.add(0);
        b.add(2);
        List<Integer> c =  new ArrayList<>();
        c.add(2);
        c.add(5);
        List<Integer> d =  new ArrayList<>();
        d.add(3);
        d.add(4);
        List<Integer> e =  new ArrayList<>();
        e.add(4);
        e.add(2);
        num.add(a);
        num.add(b);
        num.add(c);
        num.add(d);
        num.add(e);
        List<Integer> integers =findSmallestSetOfVertices(6,num);

        for(Integer integer : integers){
            System.out.print(integer + " ");
        }
        System.out.println();
    }
}
