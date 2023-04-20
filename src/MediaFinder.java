import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
// 1 2 3 4 5  -> 3

// 1 2 3 4 5 6 -> 3+4 -> 3.5
public class MediaFinder {
    List<Integer> list;
    int size = 0;

    public MediaFinder() {
        list = new ArrayList<>();
    }

    public void addNum(int num) {
        list.add(num);
        size++;
    }

    public double findMedian() {
        if (size % 2 == 0) {
            return (list.get(list.size() / 2) + list.get((list.size() / 2) + 1)) / 2.0;
        } else {
            return list.get(size / 2);
        }
    }

    public static void main(String args[]) {

    }
}

class MedianFinder {
    // max queue is always larger or equal to min queue
    PriorityQueue<Integer> min = new PriorityQueue();
    PriorityQueue<Integer> max = new PriorityQueue(1000, Collections.reverseOrder());

    // Adds a number into the data structure.
    public void addNum(int num) {
        max.offer(num);
        min.offer(max.poll());
        if (max.size() < min.size()) {
            max.offer(min.poll());
        }
    }

    // Returns the median of current data stream
    public double findMedian() {
        if (max.size() == min.size()) return (max.peek() + min.peek()) / 2.0;
        else return max.peek();
    }
};