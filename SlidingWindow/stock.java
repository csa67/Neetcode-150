package SlidingWindow;

/*
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.

You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 */

 /*
  * Input - array of prices, maximum price buy one one day and sell on a different day.
  profit = sell - buy => max profit = high sell and low buy.
  so for each i, maximum element on the right. or else 0.
  */
class Solution {
    public int buyAndSellStack(int[] nums){
        int n=nums.length;
        int maxProfit = 0;
        for(int i=0; i<n;i++){
            for(int j=i+1; j<n;j++){
                maxProfit = Math.max(maxProfit,nums[j] - nums[i]);
            }
        }
        return maxProfit;
    }
    //TC-O(n^2), SC-O(1)

    public int buyAndSellStack2(int[] nums){
        int n=nums.length;
        int minProfit = Integer.MAX_VALUE; int maxProfit = 0;
        for(int i=0; i<n;i++){
            if(nums[i] < minProfit){
                minProfit = nums[i];
            }

            maxProfit = Math.max(maxProfit, nums[i] - minProfit);
        }
        return maxProfit;
    }

    //TC-O(n), SC-O(1)
}
