package LinkedList;

/*
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
 */
class Solution {
    class ListNode{
        ListNode next;
        int data;

        public ListNode(int data){
            this.data = data;
            next = null;
        }
    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        
        while(curr!=null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp; 
        }

        return prev;
    }
}
