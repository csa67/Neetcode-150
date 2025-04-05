package Tries.implementation;

public class Trie {
    
    private final TrieNode root;

    public Trie(){
        root = new TrieNode();
    }

    public void insert(String word){
        TrieNode node = root;
        for(char ch:word.toCharArray()){
            int index = ch-'a';
            if(node.children[index] == null){
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }
        node.isEndOfWord = true;
    }

    public boolean search(String word){
        TrieNode node = root;
        for(char ch: word.toCharArray()){
            int index = ch-'a';
            if(node.children[index] == null) return false;
            node = node.children[index];
        }

        return node.isEndOfWord;
    }

    public boolean startsWithPrefix(String word){
        TrieNode node = root;
        for(char ch:word.toCharArray()){
            int index=ch-'a';
            if(node.children[index] == null) return false;
            node = node.children[index];
        }

        return true;
    }
}
