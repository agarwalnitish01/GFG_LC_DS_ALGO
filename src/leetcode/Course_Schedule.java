package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Course_Schedule {
    /*
    Complexity
Time complexity : O(V+E)
Space complexity : O(V+E)
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        List<List<Integer>> adjList = new ArrayList<>();


        for(int i=0;i<numCourses;i++)
        {
            adjList.add(new ArrayList<>());
        }

        for(int[] prerequisite : prerequisites)
        {
            int course = prerequisite[0];
            int pre = prerequisite[1];
            adjList.get(pre).add(course);
            inDegree[course]++;
        }

        //Step 2 : Initia;ize and process queue
        Queue<Integer> queue = new LinkedList<>();

        for(int i=0;i<numCourses;i++)
        {
            if(inDegree[i]==0)
            {
                queue.offer(i);
            }
        }

        int count=0;
        while(!queue.isEmpty())
        {
            int current = queue.poll();
            count++;

            for(int neighbor:adjList.get(current))
            {
                inDegree[neighbor]--;
                if(inDegree[neighbor]==0)
                {
                    queue.offer(neighbor);
                }
            }
        }
        return count==numCourses;



    }
}
