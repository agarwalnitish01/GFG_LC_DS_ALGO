package leetcode;

public class LinkedList_parition_list {
    /*
    Given the head of a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

Input: head = [1,4,3,2,5,2], x = 3
Output: [1,2,2,4,3,5]


     */
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
    
    public ListNode partition(ListNode head, int x) {
        ListNode less = new ListNode(0);
        ListNode higher = new ListNode(0);

        ListNode lessHead =less;
        ListNode higherHead = higher;

        while(head!=null){
            if(head.val<x){
                lessHead.next=head;
                lessHead = lessHead.next;
            }
            else{
                higherHead.next = head;
                higherHead = higherHead.next;
            }
            head = head.next;
        }
        higherHead.next=null;
        lessHead.next=higher.next;

        return less.next;
    }
}
