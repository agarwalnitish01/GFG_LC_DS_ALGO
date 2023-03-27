package leetcode;


import java.util.Stack;

class LinkedList_loop_length {
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
        ListNode listNode11 = new ListNode(2,null);
        ListNode listNode12 = new ListNode(4,null);
        ListNode listNode13 = new ListNode(3,null);
        head1 = new ListNode();
        head1.next = listNode11;
        listNode11.next = listNode12;
        listNode12.next = listNode13;
        listNode13.next = listNode11;

        System.out.println(countNodesinLoop(head1));
    }

    static int countNodes(ListNode n)
    {
        int res = 1;
        ListNode temp = n;
        while (temp.next != n) {
            res++;
            temp = temp.next;
        }
        return res;
    }


    static int countNodesinLoop(ListNode list)
    {
        ListNode slow = list, fast = list;

        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast)
                return countNodes(slow);
        }

        return 0;
    }


}
