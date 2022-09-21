package leetcode;


import java.util.HashSet;
import java.util.Set;

class LinkedList_Swap_Nodes_In_Pairs {
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
        ListNode listNode1 = new ListNode(1, null);
        head = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        printList(head);
        System.out.println();
        head = swapPairs(head);
        printList(head);
    }

    public static void printList(ListNode currNode) {
        while (currNode != null) {
            System.out.print(currNode.val + " ");
            currNode = currNode.next;
        }
    }


    public static ListNode swapPairs(ListNode head) {
        if (head==null || head.next==null)
            return head;

        ListNode temp=head.next; // save the second node
        head.next=head.next.next; // change the pointer of the head to the second nodes next pointer i.e the third node
        temp.next=head; // now make the saved second node point to head node
        head=temp;// and make the second node the head node


        ListNode curr=head.next; // Start from the second node
        while(curr.next!=null && curr.next.next!=null){// Ensure that there are atleast two more nodes to swap
            // Repeat the same steps again
            ListNode prev=curr;
            ListNode first=curr.next;
            ListNode second=curr.next.next;
            first.next=second.next;
            second.next=first;
            prev.next=second;
            curr = curr.next.next;
        }

        return head;
    }
}
