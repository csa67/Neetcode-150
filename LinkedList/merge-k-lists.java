package LinkedList;

import java.util.Comparator;
import java.util.PriorityQueue;

/*
 * You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.

Merge all the linked-lists into one sorted linked-list and return it.
 */

class Solution{
    /*
     * Bruteforce - take an array and add all elements of each list and sort.
     * 
     * Better: Take a minheap, to get the min of k lists every time.
     */
    public ListNode mergeKLists(ListNode[] lists) {

        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;

        PriorityQueue<ListNode> pq = new PriorityQueue<>(
            new Comparator<ListNode>() {
                @Override
                public int compare(ListNode l1, ListNode l2){
                    if(l1.val < l2.val){
                        return 1;
                    }else if(l1.val == l2.val){
                        return 0;
        
                    }else{
                        return -1;
                    }
                }
            }
        );
    
        for(ListNode l:lists){
            if(l!=null) pq.offer(l);
        }

        while(!pq.isEmpty()){
            temp.next = pq.poll();
            temp = temp.next;
            if(temp.next!=null) pq.offer(temp.next);
        }

        return dummy.next;
    }    
    /*
    *TC - O(NlogK), N-nodes K-lists, SC-O(N)
     * Optimal:Use merge sort.
     */
    public ListNode mergeKLists2(ListNode[] lists) {
        int size = lists.length;
        int interval = 1;

        while(interval < size){
            for(int i=0; i<size-interval;i+=interval*2){
                lists[i]=merge2Lists(lists[i], lists[i+interval]);
            }
            interval*=2;
        }

        
        return size > 0 ? lists[0] : null;
    }

    private ListNode merge2Lists(ListNode l1, ListNode l2){
        ListNode head = new ListNode(0);
        ListNode point = head;

        while(l1 !=null && l2!=null){
            if(l1.val <= l2.val){
                point.next = l1;
                l1=l1.next;
            }else{
                point.next = l2;
                l2=l2.next;
            }

            point = point.next;
        }

        if(l1!=null) point.next = l1;
        if(l2!=null) point.next = l2;

        return head.next;
    }
    //TC-O(nlogk), SC-O(1)

}
