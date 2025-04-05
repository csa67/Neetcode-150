package Tries.implementation;

public class TrieNode {
    
    TrieNode[] children = new TrieNode[26];
    boolean isEndOfWord = false;

    public TrieNode(){
        isEndOfWord = false;
    }
}
