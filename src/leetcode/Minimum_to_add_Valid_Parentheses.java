package leetcode;

import java.util.HashMap;
import java.util.Stack;

public class Minimum_to_add_Valid_Parentheses {
    public static void main(String[] args) {
        String s = "()))((";
        System.out.println(minimum_Add(s));
        System.out.println(minimum_Add2(s));
    }

    public static int minimum_Add(String s) {
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

        return stack.size();
    }

    public static int minimum_Add2(String s) {
        int a = 0, b = 0;

        for (char value : s.toCharArray()) {
            if(value=='(')
                a++;
            else
                a--;

            if (a < 0) {
                b += 1;
                a = 0;
            }
        }

        return a+b;
    }
}
