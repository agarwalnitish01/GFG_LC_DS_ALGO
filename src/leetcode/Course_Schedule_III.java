package leetcode;

import java.util.*;

public class Course_Schedule_III {
    /*
    courses = [[100,200],[1000,1250],[200,1300],[2000,3200]] (sorted by last day), heap = [], total = 0

course[i = 0] = [100, 200], heap = [100], total = 100 ≤ 200
course[i = 1] = [1000, 1250], heap = [1000, 100], total = 1100 ≤ 1250
course[i = 2] = [200, 1300], heap = [1000, 100, 200], total = 1300 ≤ 1300

course[i = 3] = [2000, 3200], heap = [2000, 100, 200, 1000], total = 3300 > 3200
swap, total -= 2000 = 1300, heap = [1000, 100, 200]

Max courses = heap size = 3
Courses you can take, in this order:
[100, 200] = start at 0, end at 100
[1000, 1250] = start at 100, end at 1100
[200, 1300] = start at 1100, end at 1300
T/S: O(n lg n)/O(n), where n = size(courses)
     */
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (c1, c2) -> Integer.compare(c1[1], c2[1]));
        // max heap to track the max duration courses
        PriorityQueue<Integer> heap = new PriorityQueue<>((d1, d2) -> Integer.compare(d2, d1));

        int time = 0;
        for(int[] course: courses) {
            int duration = course[0], lastDay = course[1];
            time += duration;
            heap.add(duration);
            // if pass the last day, remove courses these take longest time.
            if(time > lastDay) {
                time -= heap.poll();
            }
        }
        return heap.size();
    }
}
