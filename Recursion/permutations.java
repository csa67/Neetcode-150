package Recursion;

import java.util.ArrayList;
import java.util.List;

/*
 * Find all the possible permuations of nums.
 */
class Solution {
    /*
     * Rearrangemetns - recurse on values and not indices.
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        backtrack(nums,curr,res);
        return res;
    }

    private void backtrack(int[] nums, List<Integer> curr, List<List<Integer>> res){
        if(curr.size() == nums.length){
            res.add(new ArrayList<>(curr));
            return;
        }

        for(int num:nums){
            if(!curr.contains(num)){
                curr.add(num);
                backtrack(nums,curr,res);
                curr.remove(curr.size()-1);
            }
        }
    }
}