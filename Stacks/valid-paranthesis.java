package Stacks;

import java.util.Stack;

/*
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.
 */
class Solution {
    public boolean isValid(String str) {
        Stack<Character> s = new Stack();

        for(int i=0; i<str.length();i++){
            char current = str.charAt(i);
            if(current == '(' || current == '[' || current=='{'){
                s.push(current);
            }else if(current ==']'){
                if(!s.isEmpty() && s.peek() == '[') s.pop();
                else return false;
            }else if(current =='}'){
                if(!s.isEmpty() && s.peek() == '{') s.pop();
                else return false;
            }else{
                if(!s.isEmpty() && s.peek() == '(') s.pop();
                else return false;
            }
        }

        return s.isEmpty();
    }
}
//TC- O(n) SC-O(n)
