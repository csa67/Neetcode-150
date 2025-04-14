package intervals;

import java.util.Arrays;
import java.util.PriorityQueue;

/*
 * Given an array of meeting time intervals intervals where intervals[i] = [starti, endi], return the minimum number of conference rooms required.
 */
class Solution {
    /*
     * You are sorting based on start times, for allocating rooms.
     * If they finish, the room becomes empty and other meeting could be held in the same room.
     */
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals,(a,b) -> a[0] - b[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b) -> a[1] - b[1]
        );

        for(int[] interval: intervals){
            if(!pq.isEmpty() && pq.peek()[1] <= interval[0]){
                pq.poll();
            }
            pq.add(interval);
        }

        return pq.size();
    }
}
