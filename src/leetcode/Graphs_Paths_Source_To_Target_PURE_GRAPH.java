package leetcode;


import java.util.ArrayList;
import java.util.List;

public class Graphs_Paths_Source_To_Target_PURE_GRAPH {

    private int v;

    private ArrayList<Integer>[] adjList;

    public Graphs_Paths_Source_To_Target_PURE_GRAPH(int vertices) {

        this.v = vertices;
        adjList = new ArrayList[v];

        for (int i = 0; i < v; i++) {
            adjList[i] = new ArrayList<>();
        }
    }

    public void addEdge(int u, int v) {
        adjList[u].add(v);
    }

    public void printAllPaths(int s, int d) {
        boolean[] isVisited = new boolean[v];

        ArrayList<Integer> pathList = new ArrayList<>();
        pathList.add(s);
        printAllPathsUtil(s, d, isVisited, pathList);
    }

    private void printAllPathsUtil(Integer u, Integer d, boolean[] isVisited, List<Integer> localPathList) {

        if (u.equals(d)) {
            System.out.println(localPathList);
            return;
        }

        isVisited[u] = true;

        for (Integer i : adjList[u]) {
            if (!isVisited[i]) {
                localPathList.add(i);
                printAllPathsUtil(i, d, isVisited, localPathList);
                localPathList.remove(i);
            }
        }

        isVisited[u] = false;
    }

    public static void main(String[] args) {
        Graphs_Paths_Source_To_Target_PURE_GRAPH g = new Graphs_Paths_Source_To_Target_PURE_GRAPH(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 3);

        int s = 0;
        int d = 3;

        g.printAllPaths(s, d);
    }
}
