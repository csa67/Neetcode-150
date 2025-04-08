package Stacks;

import java.util.Stack;

/*
 * Given an array of integers heights representing the histogram's bar height where the width of each bar is 1, return the area of the largest rectangle in the histogram.
 */
class Solution{
    /*
    *The height of the histogram's rectangle would be the min height if 2 bars are covered and width between the indices.
    *So, find nse and pse for each element, area = height * (nse-pse-1);
    *instead of 2 passes to find nse again, you can do a single pass by whenever current is a smaller element than the prev element, you've found the nse. (current)
    prev number in the stack would be the pse. 
     * fIND THE PREVIOUS SMALLER ELEMENT.
     */
    public int largestRectangleArea(int[] heights) {
        int max_area = 0;
        int n = heights.length;

        Stack<Integer> stack = new Stack();
        for(int i=0; i<n;i++){
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]){
                int currentHeight = stack.pop();
                int pse = stack.empty() ? -1:stack.peek();
                int currentarea = currentHeight * (i-pse-1);
                max_area = Math.max(max_area,currentarea);
            }
        }

        while(!stack.isEmpty()){
            int currentHeight = stack.pop();
            int pse = stack.empty() ? -1:stack.peek();
            int currentarea = currentHeight * (n-pse-1);
            max_area = Math.max(max_area,currentarea);
        }

        return max_area;

    }

    //TC - O(n), SC-O(n)
}
