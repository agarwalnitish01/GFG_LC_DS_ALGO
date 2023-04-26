package Different;
import java.util.*;

public class daily_temperature {

        public int[] dailyTemperatures(int[] temperatures) {
            int length = temperatures.length;
            if(length == 0) return null;

            int[] answer = new int[length];

            // creat a dictionary keeps temperature and index in int[] temperature
            HashMap<Integer, Integer> map = new HashMap<>();
            // create a monotonic list
            Deque<Integer> deque = new ArrayDeque<>();
            for(int i=length-1; i>=0; i--){
                int temperature = temperatures[i];
                map.put(temperature, i);
                while(!deque.isEmpty() && deque.peekLast()<=temperature){
                    deque.pollLast();
                }

                int result = deque.isEmpty() ? -1 : deque.peekLast();
                if(result == -1){
                    answer[i] = 0;
                }
                else{
                    result = map.get(result)-i;
                    answer[i] = result;
                }

                deque.addLast(temperatures[i]);

            }

            return answer;
        }
    }
