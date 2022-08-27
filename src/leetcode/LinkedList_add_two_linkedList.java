package leetcode;


import java.util.Stack;

class LinkedList_add_two_linkedList {
    static ListNode head1;
    static ListNode head2;
    
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
        ListNode listNode13 = new ListNode(2,null);
        ListNode listNode12 = new ListNode(4,null);
        ListNode listNode11 = new ListNode(3,null);
        head1 = new ListNode();
        head1.next = listNode11;
        listNode11.next = listNode12;
        listNode12.next = listNode13;

        
        ListNode listNode23 = new ListNode(5,null);
        ListNode listNode22 = new ListNode(6,null);
        ListNode listNode21 = new ListNode(4,null);
        head2 = new ListNode();
        head2.next = listNode21;
        listNode21.next = listNode22;
        listNode22.next = listNode23;
        
        System.out.println(sum(head1,head2));
    }

    private static ListNode sum(ListNode head1, ListNode head2) {
        Stack<Integer> stack1 = new Stack<Integer>();
        Stack<Integer> stack2 = new Stack<Integer>();
        Stack<ListNode> stack3 = new Stack<ListNode>();

        head1 = head1.next;
        while(head1!=null){
            stack1.push(head1.val);
            head1 = head1.next;
        }
        head2 = head2.next;
        while(head2!=null){
            stack2.push(head2.val);
            head2 = head2.next;
        }
        int carry = 0;// 342    465
        while(!stack1.empty() && !stack2.empty()){
            int num = stack1.pop() + stack2.pop() + carry;
            if(num<=9){
                carry = 0;
                stack3.push(new ListNode((num)));
            } else {
                carry = 1;
                stack3.push(new ListNode((num-10)));
            }
        }

        if (carry == 1) {
            stack3.push(new ListNode(1));
        }

        ListNode head3 = null;
        if (!stack3.isEmpty())
            head3 = stack3.peek();
        while (!stack3.isEmpty()) {
            ListNode temp = stack3.peek();
            stack3.pop();
            if (stack3.size() == 0) {
                temp.next = null;
            }
            else {
                temp.next = stack3.peek();
            }
        }
        return head3;
    }


}
