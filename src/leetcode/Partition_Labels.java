package leetcode;

import java.util.*;

public class Partition_Labels {
    public static void main(String[] args) {


        System.out.print(partitionLabels("ababcbacadefegdehijhklij"));
    }

    public static List<Integer> partitionLabels(String s) {
        List<Integer> ans = new ArrayList<>();

        int i = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            int endIndex = s.lastIndexOf(c);

            for (int j = i + 1; j <= endIndex; j++) {
                endIndex = Math.max( s.lastIndexOf(s.charAt(j)),endIndex);
            }

            ans.add(endIndex - i + 1);
            i = endIndex + 1;
        }

        return ans;
    }
}
