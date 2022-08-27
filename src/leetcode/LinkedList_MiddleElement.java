package leetcode;


import java.util.Stack;

class LinkedList_MiddleElement {
    static ListNode head;

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args){
        ListNode listNode4 = new ListNode(4,null);
        ListNode listNode3 = new ListNode(2,null);
       //ListNode listNode2_5 = new ListNode(3,listNode3);
        ListNode listNode2 = new ListNode(2,null);
        ListNode listNode1 = new ListNode(4,null);
        head = new ListNode();
        head.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;

        System.out.println(middleElement(head));
        System.out.println(isPal(head));
    }

    private static ListNode middleElement(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow =slow.next;
        }
        return slow;
    }

    public static boolean isPal(ListNode head) {
        ListNode fast = head;
        Stack<Integer> stack = new Stack<>();
        while(fast.next != null){
            stack.push(fast.val);
            fast = fast.next;
        }
        stack.push(fast.val);
        fast = head;
        while(fast.next!=null){
            int num = stack.pop();
            if(fast.val != num){
                return false;
            }
            fast = fast.next;
        }
        return true;
    }

}
