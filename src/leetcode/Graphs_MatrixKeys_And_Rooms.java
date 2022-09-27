package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Graphs_MatrixKeys_And_Rooms {
    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[rooms.size()];

        visited[0] = true;
        queue.add(0);

        while (!queue.isEmpty()) {

            int curr = queue.remove();
            visited[curr] = true;

            List<Integer> roomKey = rooms.get(curr);
            for (int key : roomKey) {
                if (!visited[key]) {
                    visited[key] = true;
                    queue.add(key);
                }
            }
        }

        for (int i = 0; i < visited.length; i++)
            if (!visited[i])
                return false;

        return true;
    }

    public static void main(String[] args) {
        List<List<Integer>> num = new ArrayList<>();
        List<Integer> a =  new ArrayList<>();
        a.add(1);
        a.add(3);
        List<Integer> b =  new ArrayList<>();
        b.add(3);
        b.add(0);
        b.add(1);
        List<Integer> c =  new ArrayList<>();
        c.add(2);
        List<Integer> d =  new ArrayList<>();
        d.add(0);

        num.add(a);
        num.add(b);
        num.add(c);
        num.add(d);

        System.out.println(canVisitAllRooms(num));
    }
}
