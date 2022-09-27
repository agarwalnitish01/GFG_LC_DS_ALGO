package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class WInner_Circular_Queue {

    public static int findTheWinner(int n, int k) {

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++)
            queue.add(i);

        while (queue.size() != 1) {
            for (int i = 0; i < k - 1; i++) {
                queue.add(queue.remove());
            }
            queue.remove();
        }

        return queue.remove();
    }

    public static void main(String[] args) {
        System.out.print(findTheWinner(5, 2));
        System.out.print(findTheWinner2(5, 2));
    }

    public static int findTheWinner2(int n, int k) {
        // base case f(1,k)=0
        int winner=0;

        // f(n,k)=(f(n-1,k)+k)%n
        for(int i=2; i<=n; i++){
            winner=(winner+k)%i;
        }

        return winner+1;
    }
}
