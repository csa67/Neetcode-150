package BinarySearch;

/*
 * Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. The guards have gone and will come back in h hours.

Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and eats k bananas from that pile. If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.

Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.

Return the minimum integer k such that she can eat all the bananas within h hours.
 */

 /*
  * input - piles[] array and eating speed k.
  * each hour - any 1 pile, and k bananas from the pile. 
  maximum value would be max bananas in pile and the no:of hours would be size of array. with a known search range, binary search can be performed.
  */
class Solution {
    public int minEatingSpeed(int[] piles, int hrs) {
        
        int max_pile = Integer.MIN_VALUE;

        for(int i:piles){
            max_pile = Math.max(max_pile, i);
        }

        int l=1;
        int h=max_pile;
        int ans = 0;

        while(l<=h){
            int mid = (l+h)/2;
            int timeNeeded = getTimeForSpeed(mid, piles);
        
            if(timeNeeded <= hrs){
                ans=mid;
                h=mid-1;
            }else{
                l=mid+1;
            }
        }
        return ans;
    }

    private int getTimeForSpeed(int k, int[] piles){
        int cnt=0;
        for(int i:piles){
            cnt+=(i + k - 1) / k;;
        }
        return cnt;
    }
}
//Binary Search: O(log(max_pile)), Each getTimeForSpeed call: O(n), So total time: O(n * log(max_pile))
