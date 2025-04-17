package DP.twod;

class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int aheadBuy = 0; int aheadNotBuy = 0;
        int afterCooldown = 0;
  
        for(int i=n-1;i>=0;i--){
                int currBuy =  Math.max(aheadBuy, aheadNotBuy- prices[i]);
                int currSell = Math.max(aheadNotBuy,afterCooldown + prices[i]);
                
                afterCooldown = aheadBuy;
                aheadBuy = currBuy;
                aheadNotBuy = currSell;
        }

        return aheadBuy;
    }
}