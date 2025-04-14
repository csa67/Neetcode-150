package intervals;

import java.util.Arrays;

/*
 * In this problem, we need to find the min intervals that have to be removed to get non-overlapping intervals.
 * equivalent to finding maximum non-overlapping intervals.
 * Sort the intervals based on their end times, because the sooner an interval finishes we could have another interval starting after it.
 */
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[1]-b[1]);
        int ans = 0;
        int k = Integer.MIN_VALUE;

        for(int[] interval:intervals){
            int start = interval[0];
            int end = interval[1];

            if(start >= k){
                k=end;
            }else{
                ans++;
            }
        }

        return ans;
    }
}
