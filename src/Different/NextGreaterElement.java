package Different;


import java.util.ArrayList;
import java.util.HashMap;

class NextGreaterElement {
    static void nextLargerElement(int[] arr, int n) {
        ArrayList<HashMap<String, Integer>> s = new ArrayList<>();


        for (int i = 0; i < n; i++) {
            while (s.size() > 0
                    && s.get(s.size() - 1).get("value") < arr[i]) {

                HashMap<String, Integer> d = s.get(s.size() - 1);
                s.remove(s.size() - 1);
                arr[d.get("ind")] = arr[i];
            }

            HashMap<String, Integer> e = new HashMap<>();

            e.put("value", arr[i]);
            e.put("ind", i);
            s.add(e);
        }

        while (s.size() > 0) {
            HashMap<String, Integer> d = s.get(s.size() - 1);
            s.remove(s.size() - 1);
            arr[d.get("ind")] = -1;
        }
    }

    // Driver Code

    public static void main(String[] args) {
        int[] arr = {6, 8, 0, 1, 3};
        int n = 5;

        nextLargerElement(arr, n);
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
    }
}
