package SlidingWindow;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/*
 * You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.

Return the max sliding window.
 */
class Solution {
    /*
     * Construct a monotonic deque for each sliding window and store the pge.
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        Deque<Integer> dq = new ArrayDeque<>();
        List<Integer> res = new ArrayList<>();

        for(int i=0; i<k;i++){
            while(!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]){ dq.pollLast();}

            dq.offerLast(i);
        }

        res.add(nums[dq.peekFirst()]);

    for(int i=k; i<nums.length;i++){
        if(dq.peekFirst() == i-k){
            dq.pollFirst();
        }

        while(!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]) dq.pollLast();

        dq.offerLast(i);

        res.add(nums[dq.peekFirst()]);
    }

    return res.stream().mapToInt(i->i).toArray();
}

}
//TC - O(n), SC-(O(k))