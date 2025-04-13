package Recursion;

import java.util.ArrayList;
import java.util.List;

/*
 * Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.

The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the frequency of at least one of the chosen numbers is different.

The test cases are generated such that the number of unique combinations that sum up to target is less than 150 combinations for the given input.
 */
class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> curr = new ArrayList<>();
        backtrack(0,candidates,target,curr);
        return res;
    }

    private void backtrack(int i, int[] candidates, int target, List<Integer> curr){

        if(target == 0){
            res.add(new ArrayList<>(curr));
            return;
        }

        if(target < 0 || i == candidates.length) return;

        curr.add(candidates[i]);
        backtrack(i,candidates,target-candidates[i],curr);
        curr.remove(curr.size()-1);
        backtrack(i+1,candidates,target,curr);
    }
}
