package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.

Each number in candidates may only be used once in the combination.

Note: The solution set must not contain duplicate combinations.
 */
class Solution {
    /*
     * Here, duplicates are present, so to get unique subsets, we need to prune subsets we check from duplicate indices.
     * we can maintain a set/simply sort the array and check if the previous element is same as current.
     * 
     * Also, using a for loop while backtracking/recursion would never give an outof bounds index.
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(0,target,candidates,curr,res);
        return res;
    }

    private void backtrack(int i, int target, int[] candidates, List<Integer> curr,List<List<Integer>> res ){
        
        if(target==0){
            res.add(new ArrayList<>(curr));
            return;
        }

        for(int idx=i;idx<candidates.length;idx++){
            if(idx>i && candidates[idx] == candidates[idx-1]) continue;
            
            if(candidates[i] > target) break;

            curr.add(candidates[idx]);
            backtrack(idx+1,target-candidates[idx],candidates,curr,res);
            curr.remove(curr.size()-1);
        }
    }
}