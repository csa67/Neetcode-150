package graphs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) return 0;

        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(beginWord, 1));
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        while (!queue.isEmpty()) {
            Pair curr = queue.poll();
            String word = curr.word;
            int count = curr.count;

            for (int i = 0; i < word.length(); i++) {
                char[] wordArray = word.toCharArray();
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    if (wordArray[i] == ch) continue;
                    wordArray[i] = ch;
                    String newWord = new String(wordArray);

                    if (newWord.equals(endWord)) return count + 1;

                    if (wordSet.contains(newWord) && !visited.contains(newWord)) {
                        queue.offer(new Pair(newWord, count + 1));
                        visited.add(newWord);
                    }
                }
            }
        }

        return 0;
    }

    static class Pair {
        String word;
        int count;

        Pair(String word, int count) {
            this.word = word;
            this.count = count;
        }
    }
}

