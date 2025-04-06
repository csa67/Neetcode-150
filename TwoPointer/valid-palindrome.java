package TwoPointer;
/*
 * A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.

Given a string s, return true if it is a palindrome, or false otherwise.
 */

 /*
  * Input string s, output boolean.
  * case conversion.
  * clean string to remove all alpha-numeric characters.
  */
class Solution{
    /*
     * Bruteforce: reverse strig and check if same.
     * 
     * Better: 2 pointer and check till the middle.
     */
    public boolean validPalindrome(String s) {

        s = cleanString(s);

        int l=0;
        int r=s.length()-1;

        while(l<=r){
            if(s.charAt(l) == s.charAt(r)){
                l++;
                r--;
            }else{
                return false;
            }
        }

        return true;
    }

    private String cleanString(String s){
        StringBuilder sb = new StringBuilder();
        for(char ch: s.toCharArray()){
            if(Character.isLetterOrDigit(ch)){
                sb.append(ch);
            }
        }
        return sb.toString().toLowerCase();
    }
    /*
     * TC - O(n), SC- O(n) because of string builder, you can do it without stringbuilder 
     * by skipping non-alphanumeric characters and checking lowercase characters/
     */

     public boolean validPalindrome2(String s){
        int l=0; int r = s.length()-1;

        while(l<=r){
           while(l<r && !Character.isLetterOrDigit(s.charAt(l))) l++;
           while(l<r && !Character.isLetterOrDigit(s.charAt(r))) r--;

           if(Character.toLowerCase(s.charAt(l)) == Character.toLowerCase(s.charAt(r))){
            l++;
            r--;
           }else{return false;}
        }

        return true;
     }
}