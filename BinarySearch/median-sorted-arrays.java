package BinarySearch;
/*
 * Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
 */
class Solution {
    /*
     *Bruteforce - merge 2 arrays into a sorted list and then get the median, This would take a space - O(m+n).

     Better - without merging, just get the index of median by adding lengths by 2 and find the element that would be in that position.

     Optimal - Binary search, try and find the correct left half to median by picking 1-n elements from array1 and remaining from array2.

     eg: arr1 - [1 3 5 6 9] arr2- [2 3 4 7] total length = 10, so median is 5th element.

            1  | 3 5 6 9   1 3  | 5 6 9
      2 3 4 7  | 8         2 3  | 4 7
     */
    public double getMedian(int[] arr1, int[] arr2){
        int n=arr1.length;
        int m=arr2.length;

        int l=0,r=n;
        while(l<=r){
            int partitionA = (l+r)/2;
            int partitionB = (m+n+1)/2 - partitionA;

            int minRightA = (partitionA == n) ? Integer.MAX_VALUE : arr1[partitionA];
            int minRightB = (partitionB ==m) ? Integer.MAX_VALUE : arr2[partitionB];

            int maxLeftA = (partitionA == 0) ? Integer.MIN_VALUE: arr1[partitionA-1];
            int maxLeftB = (partitionB == 0) ? Integer.MIN_VALUE : arr2[partitionB-1];

            if(maxLeftA<=minRightB && maxLeftB<=minRightA){
                if((m+n)%2 ==0){
                    //even length, so median is avg of 2 mids
                    return (Math.max(maxLeftA,maxLeftB)+Math.min(minRightA,minRightB))/2.0;
                }else{
                    return Math.max(maxLeftA,maxLeftB);
                }
            }else if(maxLeftA > minRightB){
                r=partitionA-1;
            }else{
                l=partitionA+1;
            }
        }
        return 0.0;
    }
}
