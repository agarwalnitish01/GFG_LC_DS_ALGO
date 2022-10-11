package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

class TimeKeyBasedStoreValue {
    HashMap<String, TreeMap<Integer, String>> stringTimeMap;
    /** Initialize your data structure here. */
    public TimeKeyBasedStoreValue() {
        stringTimeMap = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        stringTimeMap.putIfAbsent(key, new TreeMap<>());
        stringTimeMap.get(key).put(timestamp, value);
    }

    public String get(String key, int timestamp) {
        if(stringTimeMap.containsKey(key)) {
            Integer idx = stringTimeMap.get(key).floorKey(timestamp);
            if(idx != null) {
                return stringTimeMap.get(key).get(idx);
            }
        }
        return "";
    }

    public static void main(String args[]){
        TimeKeyBasedStoreValue timeMap = new TimeKeyBasedStoreValue();
        System.out.println("null");
        timeMap.set("foo", "bar", 1);  // store the key "foo" and value "bar" along with timestamp = 1.
        System.out.println("null");
        System.out.println(timeMap.get("foo", 1));         // return "bar"
        System.out.println(timeMap.get("foo", 3));         // return "bar", since there is no value corresponding to foo at timestamp 3 and timestamp 2, then the only value is at timestamp 1 is "bar".
        timeMap.set("foo", "bar2", 4); // store the key "foo" and value "bar2" along with timestamp = 4.
        System.out.println("null");
        System.out.println(timeMap.get("foo", 4));         // return "bar2"
        System.out.println(timeMap.get("foo", 5));
    }
}