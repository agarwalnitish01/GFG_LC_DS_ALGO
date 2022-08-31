package leetcode;

import java.util.HashMap;
import java.util.Stack;

public class LongestValidParenthesis {
    public static void main(String[] args) {
        String s = ")()())";
        System.out.println(minimum_Add(s));
    }

    public static int minimum_Add(String s) {
        Stack<Integer> st=new Stack<>();
        st.push(-1);
        int max=0;
        for(int i=0;i<s.length();i++){

            char c = s.charAt(i);

            if(c=='('){
                st.push(i);
            }
            else{
                st.pop();
                if(st.isEmpty()){
                    st.push(i);
                }
                else{
                    int len = i - st.peek();
                    max = Math.max(max,len);
                }
            }
        }

        return max;
    }


    public static int minimum_Add2(String s) {
        Stack<Character> stack = new Stack<>();
        HashMap<Character,Character> map = new HashMap<>();
        map.put(')','(');
        map.put(']','[');
        map.put('}','{');

        int c=0;
        int max=0;
        for (char value : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == map.get(value)) {
                stack.pop();
                c=c+2;
                max = Math.max(max,c);
            } else {
                stack.push(value);
                c=0;
            }
        }

        return max;
    }
}
