package Bits;

class Solution{
    public int reverseIntegeR(int n){
        int rev = 0;
        while(n!=0){
            int pop = n%10;
            n=n/10;

            /*
            Integer overflow cases
             * 2^31 - 1 = 2147483647 -- ending with 7; -2^31 = -2147483648 -- ending with 8.
             */
            if(rev > Integer.MAX_VALUE/10 || rev == Integer.MAX_VALUE/10 && pop>7){
                return 0;
            }

            if(rev < Integer.MIN_VALUE/10 || rev==Integer.MIN_VALUE/10 && pop<-8){
                return 0;
            }

            rev=rev*10+pop;
        }
        return rev;
    }
}
