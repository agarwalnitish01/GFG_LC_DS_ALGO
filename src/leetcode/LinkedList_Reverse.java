package leetcode;


import java.util.Stack;

class LinkedList_Reverse {
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
        ListNode listNodeResult = reverseList2(head);
        printList(listNodeResult);
    }

    public static ListNode reverseList(ListNode head) {
        ListNode previousNode = null;
        ListNode traverseNode = head;

        while(traverseNode != null){
            ListNode next = traverseNode.next;
            traverseNode.next = previousNode;
            previousNode = traverseNode;
            traverseNode = next;
        }

        return previousNode;
    }

    public static ListNode reverseList2(ListNode head) {
        if(head==null||head.next==null)
            return head;

        ListNode p1 = head;
        ListNode p2 = p1.next;

        head.next = null;
        while(p2 != null){
            ListNode t = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = t;
        }

        return p1;
    }
    public static void printList(ListNode currNode) {
        while (currNode != null) {
            System.out.print(currNode.val + " ");
            currNode = currNode.next;
        }
    }
}
