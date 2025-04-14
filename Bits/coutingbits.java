package Bits;

/*
 * n&n-1 would remove the least set bit, which is 1 less than the num should have. so start with 0, and keep icnrementing with 1. 
 */
class Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n+1];

        for(int x=1; x<=n;x++){
            ans[x] = ans[x&(x-1)]+1;
        }

        return ans;
    }
}
