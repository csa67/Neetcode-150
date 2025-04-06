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
            node.prefixCount++;
        }
        node.isEndOfWord = true;
        node.wordCount++;
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

    public int countWordsEqualTo(String word){
        TrieNode node = root;
        for(char ch:word.toCharArray()){
            int index = ch-'a';
            if(node.children[index] == null) return 0;
            node = node.children[index];
        }

        return node.isEndOfWord ? node.wordCount : 0;
    }

    public int countWordsStartingWith(String prefix){
        TrieNode node = root;
        for(char ch: prefix.toCharArray()){
            int index = ch-'a';
            if(node.children[index] == null) return 0;
            node = node.children[index];
        }

        return node.prefixCount;
    }

    public boolean delete(String word){
        return delete(root,word,0);
    }

    private boolean delete(TrieNode node, String word, int depth){
        if(node == null) return false;

        if(depth == word.length()){
            if(!node.isEndOfWord) return false;
            node.isEndOfWord = false;
            node.wordCount--;
            return node.prefixCount == 0;
        }

        int idx = word.charAt(depth) - 'a';
        boolean deleteChildren = delete(node.children[idx],word, depth+1);

        if(deleteChildren){
            node.children[idx] = null;
        }
        
        node.prefixCount--;
        return node.prefixCount == 0 && !node.isEndOfWord;

    }
}
