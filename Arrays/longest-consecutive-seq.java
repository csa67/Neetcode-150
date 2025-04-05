/*
 * Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
 * 
 */

 /*
  * Constraints - unsorted and no sortin.
  *can contain negative numbers.
  */

import java.util.Set;

class Solution{
    /*
     * Bruteforce, start from every number, count to the max consecutive num possible and store the max value. 
     * 
     * Better, before checking next consecutive number for each number, check if prev number is presebt, so you don't keep checking the length of same sequence multiple times.
     * 
     * To make this bruteforce better, instead of traversing through the whole array multiple times, we can use a hash set and search in O(1).
     */
    public int longestConsecutive(int[] nums){
        Set<Integer> numSet = new HashSet<>();
        
        for(int i: nums){
            numSet.add(i);
        }

        int longestStreak = 0;

        for(int i:nums){
            //This would stop repetitive checks for the same sequences.
            if(!numSet.contains(i-1)){
                int currentStreak =1;
                int currentNum = i;
                while(numSet.contains(currentNum+1)){
                    currentStreak++;
                    currentNum++;
                }

                longestStreak = Math.max(longestStreak,currentStreak);
            }
        }

        return longestStreak;
    }
  }

  /*
   * TC - O(n^3) to O(n)
   * SC - O(n)
   */