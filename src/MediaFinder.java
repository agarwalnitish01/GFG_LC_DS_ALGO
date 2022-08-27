import java.util.ArrayList;
import java.util.List;
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
        if(size%2==0){
            return ( list.get(list.size()/2) + list.get((list.size()/2) +1)) / 2.0;
        } else {
            return list.get(size/2);
        }
    }

    public static void main(String args[]){

    }
}
