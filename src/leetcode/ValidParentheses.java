package leetcode;

import java.util.HashMap;
import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        String s = "{[]}";
        System.out.println(valid(s));
    }

    public static boolean valid(String s) {
        Stack<Character> stack = new Stack<>();
        HashMap<Character,Character> map = new HashMap<>();
        map.put(')','(');
        map.put(']','[');
        map.put('}','{');

        for (char value : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == map.get(value)) {
                stack.pop();
            } else {
                stack.push(value);
            }
        }

        return stack.isEmpty();
    }

}
