// Given an integer array nums, return true if any value appears at least twice in the array, 
// and return false if every element is distinct.

/*
 * Input - array of numbers. Output - boolean.
 * what is the array is empty? return true
 * can I sort the array?
 */

import java.util.HashSet;
import java.util.Set;

class DuplicateUtil{
    /*
     * Bruteforce: Linear search, finding if a particular value is in a list by checking each of its elements, one at a time and in sequence until the desired one is found.
     * 
     * Better: Sorting and check if prev element is same as current element.
     * 
     * Optimal:Have a hash set to keep track of all elements and if the set already contains the element return false.
     */
    private boolean checkDuplicate(int[] nums){
        Set<Integer> numberSet = new HashSet<>(nums.length);

        for(int i:nums){
            if(!numberSet.contains(i)){
                numberSet.add(i);
            }else{
                return false;
            }
        }

        return true;
    }

}