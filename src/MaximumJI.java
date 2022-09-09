import java.io.*;
import java.util.*;

class MaximumJI{

    // Function to find maximum
// index difference
    static int maxIndexDiff(ArrayList<Integer> arr, int n)
    {

        // Initialise unordered_map
        Map<Integer,
                ArrayList<Integer>> hashmap = new HashMap<Integer,
                ArrayList<Integer>>();

        // Iterate from 0 to n - 1
        for(int i = 0; i < n; i++)
        {
            if(hashmap.containsKey(arr.get(i)))
            {
                hashmap.get(arr.get(i)).add(i);
            }
            else
            {
                hashmap.put(arr.get(i), new ArrayList<Integer>());
                hashmap.get(arr.get(i)).add(i);
            }
        }

        // Sort arr
        Collections.sort(arr);
        int maxDiff = Integer.MIN_VALUE;
        int temp = n;

        // Iterate from 0 to n - 1
        for(int i = 0; i < n; i++)
        {
            if (temp > hashmap.get(arr.get(i)).get(0))
            {
                temp = hashmap.get(arr.get(i)).get(0);
            }
            maxDiff = Math.max(maxDiff,
                    hashmap.get(arr.get(i)).get(
                            hashmap.get(arr.get(i)).size() - 1) - temp);
        }
        return maxDiff;
    }

    // Driver Code
    public static void main(String[] args)
    {
        int n = 9;
        ArrayList<Integer> arr = new ArrayList<Integer>(
                Arrays.asList(34, 8, 10, 3, 2, 80, 30, 33, 1));

        // Function Call
        int ans = maxIndexDiff(arr, n);

        System.out.println("The maxIndexDiff is : " + ans);
    }
}