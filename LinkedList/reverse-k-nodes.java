package LinkedList;

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode ptr = head;
        int count=0;

        while(count<k && ptr!=null){
            ptr = ptr.next;
            count++;
        }

        if(count == k){
            ListNode reversedHead = reverseListTillK(head,k);

            head.next = reverseKGroup(ptr,k);
            return reversedHead;
        }

        return head;
    }

    public ListNode reverseListTillK(ListNode head, int k) {
        ListNode prev = null;
        ListNode curr = head;
        
        while(k>0){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp; 
            k--;
        }

        return prev;
    }
}
