package leetcode;


import java.util.HashSet;
import java.util.Set;

class LinkedList_RemoveDuplicates {
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
        ListNode listNode2 = new ListNode(2, null);
        ListNode listNode1 = new ListNode(2, null);
        head = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        ListNode listNodeResult = deleteDuplicates(head);
        printList(listNodeResult);
    }

    public static ListNode removeDuplicates(ListNode head) {
        if(head==null||head.next==null)
            return head;

        Set<Integer> set = new HashSet<>();
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode curr = head;
        ListNode prev = dummy;


        while (curr != null) {
            if(set.contains(curr.val)) {
                prev.next = curr.next;
            } else {
                set.add(curr.val);
                prev = prev.next;
            }
            curr = curr.next;
        }

        return dummy.next;
    }
    public static void printList(ListNode currNode) {
        while (currNode != null) {
            System.out.print(currNode.val + " ");
            currNode = currNode.next;
        }
    }

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode temp = head;

        while(temp!=null && temp.next!=null){
            if(temp.val == temp.next.val){
                temp.next = temp.next.next;
            }else{
                temp = temp.next;
            }
        }
        return head;
    }
}
