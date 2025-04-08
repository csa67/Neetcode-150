package Stacks;

import java.util.ArrayList;
import java.util.List;

/*
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 */
class Solution {
    /*
     * Bruteforce-generate all strings of length 2n and check if they are valid. TC - O(2^2n⋅n)
     * 
     * Better-recursively find all valid paranthesis.
     */
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backtrack(res, new StringBuilder(), 0, 0, n);

        return res;
    }

    private void backtrack(
        List<String> res, StringBuilder currentString, int openCount, int closeCount,int n
    ){
        if(currentString.length() == 2*n){
            res.add(currentString.toString());
            return;
        }

        if(openCount < n){
            currentString.append("(");
            backtrack(res,currentString,openCount+1,closeCount,n);
            currentString.deleteCharAt(currentString.length()-1);
        }

        if(openCount > closeCount){
            currentString.append(")");
            backtrack(res,currentString,openCount,closeCount+1,n);
            currentString.deleteCharAt(currentString.length()-1);
        }
    }
    //TC - O(4^n/root of n)
    //SC - O(n)
}
