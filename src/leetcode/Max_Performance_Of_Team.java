package leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

class Max_Performance_Of_Team {
    public static int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int[][] players = new int[n][2];
        for (int i = 0; i < n; i++) {
            players[i][0] = efficiency[i];
            players[i][1] = speed[i];
        }
        // Sort the players based on efficiency in decreasing order, as for each iteration, we'll consider only players with higher efficiency.
        Arrays.sort(players, (p1, p2) -> (p2[0] - p1[0]));

        // Priority-Queue to maintain players with highest relative speeds with efficiencies greater than the one under iteration.
        PriorityQueue<Integer> speedQueue = new PriorityQueue<>(k);
        long teamPerformance = 0, teamSpeed = 0;

        for (int i = 0; i < n; i++) {
            int currSpeed = players[i][1];
            int currEffn = players[i][0];
            if (speedQueue.size() >= k) {
                teamSpeed = teamSpeed -speedQueue.remove();
            }
            speedQueue.add(currSpeed);
            teamSpeed = teamSpeed + currSpeed;

            teamPerformance = Math.max(teamPerformance, teamSpeed * currEffn);
        }
        return (int)teamPerformance;
    }
    public static void main(String[] args){
        int[]  speed = {2,10,3,1,5,8};
        int[]  effn = {5,4,3,9,7,2};
        System.out.print(maxPerformance(6,speed,effn,2));
    }
}
