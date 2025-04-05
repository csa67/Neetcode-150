/*
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.
 */

 /*
  * Constraints: 
  */

class Solution{
    /*
     * Bruteforce - 2 loops and check if the sum of 2 numbers is equal to target.
     * 
     * Better- put all elements with index in a hashmap.nowiterate over the array and find the diff from target,try and search for that in the hashmap.
     * 
     * Optimal - instead of 2 pass in hashmap do only one. 
     */
    private int[] twoSum(int[] nums, int target){
        Map<Integer,Integer> indexMap = new HashMap<>(nums.length);

        for(int i=0; i<nums.length;i++){
            int diff = target-nums[i];
            if(indexMap.containsKey(diff)){
                return new int[]{i,indexMap.get(diff)};
            }
            indexMap.put(nums[i],i);
        }

        return new int[]{-1,-1};
    }
}

/*
 * Time complexity: O(n), loop through all arrays once.
 * Space: O(n)
 */