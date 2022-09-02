package leetcode;


class LinkedList_Delete_All_K_Element {
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
        ListNode listNode4 = new ListNode(2, null);
        ListNode listNode3 = new ListNode(6, null);
        ListNode listNode2 = new ListNode(4, null);
        ListNode listNode1 = new ListNode(2, null);
        head = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        ListNode listNodeResult = deleteNthElement(head, 2);
        printList(listNodeResult);
    }

    public static ListNode deleteNthElement(ListNode head, int n) {
        ListNode dummyhead = new ListNode(-1);
        dummyhead.next = head;
        ListNode curr = head, prev = dummyhead;
        while (curr != null) {
            if (curr.val == n) {
                prev.next = curr.next;
            } else {
                prev = prev.next;
            }
            curr = curr.next;
        }
        return dummyhead.next;
    }

    public static void printList(ListNode currNode) {
        while (currNode != null) {
            System.out.print(currNode.val + " ");
            currNode = currNode.next;
        }
    }
}
