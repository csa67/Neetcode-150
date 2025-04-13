package Queues;

/*
 * Given an integer array nums and an integer k, return the kth largest element in the array.

Note that it is the kth largest element in the sorted order, not the kth distinct element.
 */
class Solution {
    /*
     * Bruteforce - sorting O(nlogn)
     * better - using a maxHeap - O(nlogk)
     * optimal - using quick select - O(N), but in worst selection of pivot(too many duplicates) O(N^2)
     * ==> use 3 way partition to skip duplicates too.
     */
    public int findKthLargest(int[] nums, int k) {
        int target = nums.length - k; // kth largest = (n - k)th smallest
        return quickSelect(nums, 0, nums.length - 1, target);
    }

    private int quickSelect(int[] nums, int left, int right, int k) {
        if (left >= right) return nums[left];

        int pivot = nums[left + (right - left) / 2];
        int lt = left, i = left, gt = right;

        // 3-way partition
        while (i <= gt) {
            if (nums[i] < pivot) {
                swap(nums, lt++, i++);
            } else if (nums[i] > pivot) {
                swap(nums, i, gt--);
            } else {
                i++;
            }
        }

        // Now:
        // nums[left...lt-1] < pivot
        // nums[lt...gt] == pivot
        // nums[gt+1...right] > pivot

        if (k < lt) return quickSelect(nums, left, lt - 1, k);
        else if (k > gt) return quickSelect(nums, gt + 1, right, k);
        else return nums[k]; // k is in the pivot group
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}