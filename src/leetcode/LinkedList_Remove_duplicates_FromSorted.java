package leetcode;


import java.util.*;

class LinkedList_Remove_duplicates_FromSorted {
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
        ListNode listNode4 = new ListNode(4, null);
        ListNode listNode3 = new ListNode(3, null);
        ListNode listNode2 = new ListNode(2, null);
        ListNode listNode1 = new ListNode(2, null);
        ListNode listNode0 = new ListNode(1, null);
        head = listNode0;
        listNode0.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;

        ListNode newList  = deleteDuplicates(head);
        printList(newList);
        System.out.println();
        ListNode newList2  = deleteDuplicates2(head);
        printList(newList2);
    }


    public static ListNode deleteDuplicates(ListNode currNode) {
        Map<Integer,Integer> map = new LinkedHashMap<>();
        while (currNode != null) {
            map.put(currNode.val,map.getOrDefault(currNode.val,0)+1);
            currNode = currNode.next;
        }

        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;

        for(Map.Entry<Integer,Integer> m:map.entrySet()) {
            if(m.getValue()==1){
                cur.next=new ListNode(m.getKey());
                cur=cur.next;
            }
        }

        return dummy.next;
    }

    public static ListNode deleteDuplicates2(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode res=new ListNode(0);
        ListNode prev=res;
        ListNode curr=head;
        prev.next=curr;

        while(curr!=null){
            while(curr.next != null  && curr.val==curr.next.val){
                curr=curr.next;
            }
            if(prev.next!=curr){
                prev.next=curr.next;
                curr=prev.next;
            }
            else{
                curr=curr.next;
                prev=prev.next;
            }

        }
        return res.next;
    }

    public static void printList(ListNode currNode) {
        while (currNode != null) {
            System.out.print(currNode.val + " ");
            currNode = currNode.next;
        }
    }

}
