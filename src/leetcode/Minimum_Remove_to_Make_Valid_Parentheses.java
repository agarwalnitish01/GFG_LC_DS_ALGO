package leetcode;

import java.util.Stack;

public class Minimum_Remove_to_Make_Valid_Parentheses {
    public static String minRemoveToMakeValid(String s) {
        int len = s.length();

        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);

            if (!Character.isLowerCase(ch)) {
                if (st.empty()) {
                    st.push(i);
                } else {
                    char top = s.charAt(st.peek());
                    if (ch == ')' && top == '(') {
                        st.pop();
                    } else {
                        st.push(i);
                    }
                }
            }
        }

        StringBuilder ans = new StringBuilder();

        for (int i = len - 1; i >= 0; i--) {
            if (!st.empty() && i == st.peek()) {
                st.pop();
            } else {
                ans.append(s.charAt(i));
            }
        }

        return ans.reverse().toString();
    }

    public static void main(String args[]) {
        System.out.print(minRemoveToMakeValid("lee(t(c)o)de)"));
    }
}
