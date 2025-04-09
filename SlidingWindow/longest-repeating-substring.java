package SlidingWindow;

/*
 * You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character. You can perform this operation at most k times.

Return the length of the longest substring containing the same letter you can get after performing the above operations.
 */

class Solution {
    /*
     * Bruteforce- start from every character, count the max window length possible by replacing k elements.
     * TC - O(n^2)
     */
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int cnt = 0;
        int x = k;

        for (int i = 0; i < n; i++) {
            char currentChar = s.charAt(i);
            for (int j = 0; j < n; j++) {
                if (s.charAt(j) != currentChar) {
                    k--;
                }
                if (k == -1) {
                    cnt = Math.max(cnt, j - i);
                    break;
                }
                if (k == 0 && j == n - 1) {
                    cnt = Math.max(cnt, j - i + 1);
                }
            }
            k = x;
        }
        return cnt;
    }
    /*
     *Now using sliding window, keep left at start of the window and increase right until least total window size - most freq character is not more than k elements. 
     then start shrinking left side. 
     */
    public int characterReplacement2(String s, int k) {
        int n = s.length();
        int[] freq = new int[26];
        int cnt = 0;
        int left=0;
        int max_freq = Integer.MIN_VALUE;

        for (int right = 0; right < n; right++) {
            char currentChar = s.charAt(right);
            freq[currentChar-'a']++;
            max_freq = Math.max(max_freq, freq[currentChar-'a']);

            while((right-left+1) > max_freq+k){
                freq[s.charAt(left)-'a']--;
                left++;
            }

            cnt = Math.max(cnt,right-left+1);
        }
        return cnt;
    }
}