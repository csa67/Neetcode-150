package intervals;

import java.util.ArrayList;
import java.util.List;

/*
 * Find the insertion point using binary search and add it to the list.
 */
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if(intervals.length==0){
            return new int[][]{newInterval};
        }

        int n=intervals.length;
        int start = newInterval[0];
        int end = newInterval[1];

        int l=0,r=n-1;

        while(l<=r){
            int mid = l+(r-l)/2;
            if(intervals[mid][0] < start) l = mid+1;
            else r=mid-1;
        }

        List<int[]> result = new ArrayList<>();
        for(int i=0; i<l;i++){
            result.add(intervals[i]);
        }
        result.add(newInterval);
        for(int i=l;i<n;i++){
            result.add(intervals[i]);
        }


        List<int[]>merged = new ArrayList<>();
        for(int[] interval:result){
            if(merged.isEmpty() || merged.get(merged.size()-1)[1] < interval[0]){
                merged.add(interval);
            }else{
                  merged.get(merged.size() - 1)[1] = Math.max(
                    merged.get(merged.size() - 1)[1],
                    interval[1]
                );
            }
        }

        return merged.toArray(new int[0][]);
    }
}