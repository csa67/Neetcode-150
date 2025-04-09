package LinkedList;

/*
 * Given head, the head of a linked list, determine if the linked list has a cycle in it.

There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.

Return true if there is a cycle in the linked list. Otherwise, return false.
 */

 class Solution{
    /*
     * If ll has a cycle, then we visit the same node twice.
     * bruteforce - put all nodes visited in a hash set, and if we reach the same node again return false.
     * 
     * optimal - slow and fast pointers, if there is a cycle they are bound to meet in the cycle because they move towards each other.
     */
    public boolean cycleExists(ListNode head){
        if(head == null || head.next == null) return false;
        ListNode slow = head;
        ListNode fast = head;

        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast=fast.next.next;

            if(fast==slow){
                return true;
            }
        }

        return false;
    }
 }
