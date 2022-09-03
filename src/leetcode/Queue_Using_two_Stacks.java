package leetcode;

import java.util.Stack;

public class Queue_Using_two_Stacks {
    static class MyQueue {

        Stack<Integer> st;
        int topIndex = 0;

        public MyQueue() {
            st = new Stack<>();
        }

        public void push(int x) {
            st.push(x);
        }

        public int pop() {
            st.removeElementAt(topIndex);
            return st.elementAt(topIndex++);
        }

        public int peek() {
            return st.elementAt(topIndex);
        }

        public boolean empty() {
            return st.isEmpty();
        }
    }


    public static void main(String args[]) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(10);
        myQueue.push(20);
        myQueue.push(30);
        myQueue.push(40);
        myQueue.push(50);
        System.out.println(myQueue.peek());
        System.out.println(myQueue.pop());
        myQueue.push(60);
        System.out.println(myQueue.empty());
    }
}