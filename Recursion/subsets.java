package Recursion;

import java.util.ArrayList;
import java.util.List;

/*
 * Given an integer array nums of unique elements, return all possible subsets (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.


 */
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> currSubset = new ArrayList<>();
        backtrack(0, nums, res, currSubset);
        return res;
    }

    private void backtrack(int i, int[] nums, List<List<Integer>> res, List<Integer> currSubset) {
        int n=nums.length;
        res.add(new ArrayList<>(currSubset)); 
           

        for(int idx=i; idx<n;idx++){
            currSubset.add(nums[idx]);
            backtrack(idx+1,nums,res,currSubset);
            currSubset.remove(currSubset.size()-1);
        }
    }
}

