package BinarySearch;

/*
 * You are given an m x n integer matrix matrix with the following two properties:

Each row is sorted in non-decreasing order.
The first integer of each row is greater than the last integer of the previous row.
Given an integer target, return true if target is in matrix or false otherwise.

You must write a solution in O(log(m * n)) time complexity.
 */

 /*
  * Input is a matrix and output is a boolean. The whole matrix is sorted. So, binary search can be applied.
  * Bruteforce- I can change the matrix into a 1d array and perform binary search.
  * Unnecessary computations, try and perform binary search on the matrix.
  */
class Solution{
    /*
    Approach 1- search in the whole matrix. How do I represent the matrix indices?

    eg: 3*2 matrix, 0 1
                    2 3
                    4 5
        element 3 - row 1, 2nd element - row = 3/2 col = 3%2;
    */ 
    private boolean searchInMatrix(int[][] matrix, int target){
        int m=matrix.length;
        int n=matrix[0].length;

        int l=0;
        int h=m*n-1;

        while(l<=h){
            int mid = (l+h)/2;
            int currentElement = matrix[mid/n][mid%n];
            if(currentElement == target){
                return true;
            }else if(currentElement>target){
                h=mid-1;
            }else{
                l=mid+1;
            }
        }

        return false;
    }
    //TC - O(log(m*n)) 

    /*
     * Approach - 2 
     * Step wise linear search, check the rightmost element to know if i have to check the row, or move to next column.
     * TC - O(m+n)
     */
    private boolean searchInMatrix2(int[][] matrix, int target){
        int m=matrix.length;
        int n=matrix[0].length;

        int r=0;
        int c=n-1;

        while(r<=m && c>=0){
            if(matrix[r][c] == target){
                return true;
            }else if(matrix[r][c] > target){
                c--;
            }else{
                r++;
            }
        }

        return false;
    }
}
