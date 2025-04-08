package Stacks;

import java.util.Stack;

/*
 * Given an array of integers temperatures represents the daily temperatures, return an array answer such that answer[i] is the number of days you have to wait after the ith day to get a warmer temperature. If there is no future day for which this is possible, keep answer[i] == 0 instead.
 */

 /*
  * Find the next strictly greater element.
  */
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> s = new Stack<>();
        int n=temperatures.length;
        int[] res = new int[n];

        for(int i=n-1;i>=0;i--){
            while(!s.isEmpty() && temperatures[i] >= temperatures[s.peek()]){
                s.pop();
            }

            res[i] = s.empty() ? 0 : s.peek()-i;

            s.push(i);
        }
        return res;
    }
}
//TC -O(n), SC-O(n)
