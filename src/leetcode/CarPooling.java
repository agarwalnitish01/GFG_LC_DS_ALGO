package leetcode;

public class CarPooling {
        public boolean carPooling(int[][] trips, int capacity) {
            int[] count = new int[1001];
            for (int i = 0; i < trips.length; i++) {
                count[trips[i][1]] += trips[i][0];
                count[trips[i][2]] -= trips[i][0];
            }

            int curr = 0;
            for (int i : count) {
                curr += i;
                if (curr > capacity) {
                    return false;
                }
            }

            return true;
        }



    public boolean carPooling2(int[][] trips, int capacity) {
        // we need to createnew array to store the passanger's get in & get out count,so will take one array to store that
        // the array of size can be maximum upto 1000 but we can also consider the max elem in given array and we can create the array of size max+1
        int n=0;
        for(int x[]:trips){
            n=Math.max(n,x[2]);
        }
        int km[]=new int[n+1];
        for(int trip[]:trips){
            km[trip[1]]+=trip[0];
            km[trip[2]]-=trip[0];
        }
        for(int x:km){
            capacity-=x;
            if(capacity<0){
                return false;
            }
        }
        return true;
    }
    }
