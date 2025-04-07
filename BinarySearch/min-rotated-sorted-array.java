package BinarySearch;
/*Suppose an array of length n sorted in ascending order is rotated between 1 and n times. For example, the array nums = [0,1,2,4,5,6,7] might become:

[4,5,6,7,0,1,2] if it was rotated 4 times.
[0,1,2,4,5,6,7] if it was rotated 7 times.
Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].

Given the sorted rotated array nums of unique elements, return the minimum element of this array.

You must write an algorithm that runs in O(log n) time.
 */


 /*
  * Does the array have duplicates? No.
  As the array is rotated for every element picked, atleast one half(l/r) is sorted. 
  */
  class Solution {
    public int findMin(int[] nums) {
        int l = 0;
        int h = nums.length - 1;
        int ans = nums[0]; // start with something valid

        while (l <= h) {
            int mid = l + (h - l) / 2;

            // If the current subarray is sorted
            if (nums[l] <= nums[h]) {
                ans = Math.min(ans, nums[l]);
                break;
            }

            // Left half is sorted
            if (nums[l] <= nums[mid]) {
                ans = Math.min(ans, nums[l]);
                l = mid + 1;
            } 
            // Right half is sorted
            else {
                ans = Math.min(ans, nums[mid]);
                h = mid - 1;
            }
        }

        return ans;
    }
}

//TC - O(logN), C-O(1)
