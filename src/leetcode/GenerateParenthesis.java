package leetcode;

import java.util.ArrayList;
import java.util.List;

class GenerateParenthesis {
    public static List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        dfs(n, 0, 0, list, "");
        return list;
    }

    private static void dfs(int n, int openCount, int closeCount, List<String> result, String currentString) {
        if (openCount == n && closeCount == n) {
            result.add(currentString);
            return;
        }

        if (openCount < n)
            dfs(n, openCount + 1, closeCount, result, currentString + '(');

        if (openCount > closeCount)
            dfs(n, openCount, closeCount + 1, result, currentString + ')');
    }
    public static void main(String[] args) {
        List<String> strings = generateParenthesis(3);
        for(String a: strings){
            System.out.println(a);
        }

    }
}
