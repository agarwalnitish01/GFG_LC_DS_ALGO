package leetcode;

import java.util.*;


public class K_CLosest_To_Origin {
    public static int[][] kClosest(int[][] points, int k) {
        Map<Integer, List<int[]>> map = new HashMap<>();
        List<Integer> integers = new ArrayList<>();
        for (int[] a : points) {
            int num = a[0] * a[0] + a[1] * a[1];
            integers.add(num);

            if (map.containsKey(num)) {
                map.get(num).add(a);
            } else {
                List<int[]> list = new ArrayList<>();
                list.add(a);
                map.put(num, list);
            }
        }
        int[][] result = new int[k][2];
        int j = 0;

        Collections.sort(integers);
        for (int i = 0; i < k; i++) {
            List<int[]> temp = map.get(integers.get(i));
            for (int[] a : temp) {
                result[j] = a;
                j++;
            }

            if (j == k)
                break;
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] num = {
                {0, 1},
                {1, 0}
        };
        for (int[] a : kClosest(num, 2)) {
            System.out.print(a[0] + " " + a[1]);
            System.out.println();
        }

    }

    public static int[][] kClosest2(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for (int[] i : points) {
            pq.add(new int[]{getDistance(i), i[0], i[1]});
            if (pq.size() > k)
                pq.poll();
        }
        int[][] ans = new int[k][2];
        int j = 0;
        for (int[] i : pq) {
            ans[j][0] = i[1];
            ans[j][1] = i[2];
            j++;
        }
        return ans;

    }

    private static int getDistance(int[] i) {
        return i[0] * i[0] + i[1] * i[1];
    }

}
