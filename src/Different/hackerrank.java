package Different;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class hackerrank {
    public static int topKFrequent(int[] prices, int m) {
        int sum = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int num : prices){
            pq.add(num);
        }

        while(m>0){
            int maxPrice = pq.poll();
            int secondPrice = pq.peek();
            if(maxPrice >= secondPrice * 2){
                int discountPrice = maxPrice / 4;
                pq.add(discountPrice);
                m=m-2;
            }
            else {
                int discountPrice = maxPrice / 2;
                pq.add(discountPrice);
                m=m-1;
            }
        }
        for(int num : pq){
            sum = sum + num;
        }

        return sum;
    }

    public static void main(String[] args) {
        int[] num = {9,9,5,7,3};

        System.out.println(topKFrequent(num,2));


    }
}