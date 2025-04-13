package Recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 */
class Solution {
    /*
     * each digit has letter mapping, length of which are the no:of choices in each permutation.
     */
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return new ArrayList<>();

        HashMap<Integer, List<Character>> digitToLetter = new HashMap<>();

        char ch = 'a';
        for (int i = 2; i <= 9; i++) {
            digitToLetter.put(i, new ArrayList<>());

            // 7 and 9 have 4 letters
            int lettersCount = (i == 7 || i == 9) ? 4 : 3;

            for (int j = 0; j < lettersCount; j++) {
                digitToLetter.get(i).add(ch++);
            }
        }

        List<String> res = new ArrayList<>();
        StringBuilder curr = new StringBuilder();
        backtrack(0, digits, digitToLetter, res, curr);
        return res;
    }

    private void backtrack(int idx, String digits, HashMap<Integer, List<Character>> digitMap, List<String> res, StringBuilder curr) {
        if (idx == digits.length()) {
            res.add(curr.toString());
            return;
        }

        int digit = digits.charAt(idx) - '0'; // Convert char to int
        List<Character> letters = digitMap.get(digit);

        for (char ch : letters) {
            curr.append(ch);
            backtrack(idx + 1, digits, digitMap, res, curr);
            curr.deleteCharAt(curr.length() - 1); // backtrack
        }
    }
}
