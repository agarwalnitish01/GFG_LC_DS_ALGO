package leetcode;


import java.util.Stack;

class LinkedList_merge_two_linkedList {
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
        ListNode listNode13 = new ListNode(6,null);
        ListNode listNode12 = new ListNode(4,null);
        ListNode listNode11 = new ListNode(2,null);
        head1 = listNode11;
        listNode11.next = listNode12;
        listNode12.next = listNode13;

        
        ListNode listNode23 = new ListNode(9,null);
        ListNode listNode22 = new ListNode(7,null);
        ListNode listNode21 = new ListNode(5,null);
        head2 = listNode21;
        listNode21.next = listNode22;
        listNode22.next = listNode23;

        printList(merge2(head1,head2));
        System.out.println();
    }


    private static ListNode merge2(ListNode temp1, ListNode temp2) {

        ListNode res = new ListNode(-1);
        ListNode tempRes = res;


        while(temp1 != null && temp2 != null){

            if (temp1.val< temp2.val){
                tempRes.next = temp1;
                temp1=temp1.next;
            }
            else{
                tempRes.next = temp2;
                temp2 = temp2.next;
            }

            tempRes = tempRes.next;

        }

        if(temp1 == null)
            tempRes.next = temp2;
        else
            tempRes.next = temp1;
        return res.next;

    }
    public static void printList(ListNode currNode) {
        while (currNode != null) {
            System.out.print(currNode.val + " ");
            currNode = currNode.next;
        }
    }
}
