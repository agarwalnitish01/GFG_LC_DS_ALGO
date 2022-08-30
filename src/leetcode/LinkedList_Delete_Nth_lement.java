package leetcode;


class LinkedList_Delete_Nth_lement {
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

    public static void main(String[] args) {
        ListNode listNode5 = new ListNode(10, null);
        ListNode listNode4 = new ListNode(8, null);
        ListNode listNode3 = new ListNode(6, null);
        ListNode listNode2 = new ListNode(4, null);
        ListNode listNode1 = new ListNode(2, null);
        head = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        ListNode listNodeResult = deleteNthElement(head, 1);
        printList(listNodeResult);
    }

    public static ListNode deleteNthElement(ListNode head, int n) {
        int count = Count(head);
        if(count==n){
            head=head.next;
            return head;
        }

        ListNode h = head;
        for(int i=0;i<count-n-1;i++){
            h=h.next;

        }
        h.next = h.next.next;
        return head;
    }
    public static int Count(ListNode t){
        int c=1;
        while(t.next != null){
            c++;
            t = t.next;
        }
        return c;

    }


    public static void printList(ListNode currNode) {
        while (currNode != null) {
            System.out.print(currNode.val + " ");
            currNode = currNode.next;
        }
    }
}
