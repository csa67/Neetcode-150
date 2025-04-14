package Bits;

/*
 * n & (n-1) ==> would flip the least set bit to 0 as they differ by 1.
 */
class Solution {
    public int hammingWeight(int n) {
        int sum=0;
        while(n!=0){
            sum++;
            n=n&(n-1);
        }

        return sum;
    }
}