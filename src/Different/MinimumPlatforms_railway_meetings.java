package Different;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumPlatforms_railway_meetings {
    // Function to find the minimum number of platforms required
    public static int findPlatformOptimized(int[] arr, int[] dep, int n) {
        int count = 0, maxPlatforms = 0;
        // Find the maximum departure time
        int maxDepartureTime = dep[0];
        for (int i = 1; i < n; i++) {
            maxDepartureTime = Math.max(maxDepartureTime, dep[i]);
        }

        // Create a list to store the count of trains at each time
        int[] v = new int[maxDepartureTime + 2];

        // Increment the count at the arrival time and decrement at the departure time
        for (int i = 0; i < n; i++) {
            v[arr[i]] = v[arr[i]] +1;
            v[dep[i]+1] =  v[dep[i]+1] -1;
        }

        // Iterate over the list and keep track of the maximum sum seen so far
        for (int i = 0; i <= maxDepartureTime + 1; i++) {
            count += v[i];
            maxPlatforms = Math.max(maxPlatforms, count);
        }

        return maxPlatforms;
    }

    static int findPlatform(int arr[], int dep[], int n)
    {
        Arrays.sort(arr);
        Arrays.sort(dep);

        int plat_needed = 1, result = 1;
        int i = 1, j = 0;

        while (i < n && j < n) {

            if (arr[i] <= dep[j]) {
                plat_needed++;
                i++;
            }

            else if (arr[i] > dep[j]) {
                plat_needed--;
                j++;
            }

            if (plat_needed > result)
                result = plat_needed;
        }

        return result;
    }

    // Driver Code
    public static void main(String[] args) {
        int[] arr = {100, 300, 500};
        int[] dep = {900, 400, 600};
        int n = arr.length;
        System.out.println(findPlatformOptimized(arr, dep, n));
    }
}
