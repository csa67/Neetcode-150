package Tries.implementation;

public class TrieNode {
    
    TrieNode[] children = new TrieNode[26];
    boolean isEndOfWord = false;
    int wordCount;
    int prefixCount;

    public TrieNode(){
        isEndOfWord = false;
        wordCount = 0;
        prefixCount = 0;
    }
}
