package Bits;

class Solution {
    /*
    a ^ b: adds bits without carry (XOR → like normal binary addition without carrying)

a & b: finds where carry will happen (AND)
    */
    public int getSum(int a, int b) {
        while(b!=0){
            int xor = a^b;
            int carry = (a&b) << 1;
            a = xor;
            b = carry;
        }

        return a;
    }
}
