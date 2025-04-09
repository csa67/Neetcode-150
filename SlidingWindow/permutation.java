package SlidingWindow;

/*
 * Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.

In other words, return true if one of s1's permutations is the substring of s2.
 */
class Solution {
        /*
         * Bruteforce- Try all permutations, and check if any is present in s2. O(n!)
         * 
         * Better - sort string 1 and then starting from first character of s2, sort every substring of s2 of length s1 and check if it is equal to s1.
         * O((l2-l1).l1logl1)
         * 
         * Using hashmap, keep track of all frequencies in s1 and then check for every substring of length s1 in s2 and check if frequenices match.
         * O( l1 + 26l1 (l2 - l1))
         * 
         * Improve it by using an array of frequencies and compute the first window, and for every next element , expand right side, and shrink left side.
         * O(l1 + 26(l2-l1)) = O(l2)
         */
        public boolean checkInclusion(String s1, String s2) {
            if (s1.length() > s2.length())
                return false;
            int[] s1arr = new int[26];
            int[] s2arr = new int[26];
            for (int i = 0; i < s1.length(); i++) {
                s1arr[s1.charAt(i) - 'a']++;
                s2arr[s2.charAt(i) - 'a']++;
            }
            for (int i = 0; i < s2.length() - s1.length(); i++) {
                if (matches(s1arr, s2arr))
                    return true;
                s2arr[s2.charAt(i + s1.length()) - 'a']++;
                s2arr[s2.charAt(i) - 'a']--;
            }
            return matches(s1arr, s2arr);
        }
        
        public boolean matches(int[] s1arr, int[] s2arr) {
            for (int i = 0; i < 26; i++) {
                if (s1arr[i] != s2arr[i])
                    return false;
            }
            return true;
        }

        /*
         * Instead of checking if arrays are equal every single time, this can be further optimized by only checking if the equal freq counts becomes 26.
         * 
         */
            public boolean checkInclusion2(String s1, String s2) {
                if (s1.length() > s2.length())
                    return false;
                int[] s1arr = new int[26];
                int[] s2arr = new int[26];
                for (int i = 0; i < s1.length(); i++) {
                    s1arr[s1.charAt(i) - 'a']++;
                    s2arr[s2.charAt(i) - 'a']++;
                }
        
                int count = 0;
                for (int i = 0; i < 26; i++) {
                    if (s1arr[i] == s2arr[i])
                        count++;
                }
        
                for (int i = 0; i < s2.length() - s1.length(); i++) {
                    int r = s2.charAt(i + s1.length()) - 'a', l = s2.charAt(i) - 'a';
                    if (count == 26)
                        return true;
                    s2arr[r]++;
                    if (s2arr[r] == s1arr[r]) {
                        count++;
                    } else if (s2arr[r] == s1arr[r] + 1) {
                        count--;
                    }
                    s2arr[l]--;
                    if (s2arr[l] == s1arr[l]) {
                        count++;
                    } else if (s2arr[l] == s1arr[l] - 1) {
                        count--;
                    }
                }
                return count == 26;
            }
}
