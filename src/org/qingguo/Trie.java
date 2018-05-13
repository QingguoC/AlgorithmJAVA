package org.qingguo;

public class Trie {
    /** Initialize your data structure here. */
    TrieNode root;
    public Trie() {
        root = new TrieNode(' ');
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        if (word == null || word.length() == 0 || search(word)){
            return;
        }
        char[] chars = word.toCharArray();
        TrieNode p = root;
        for (int i = 0; i < chars.length; i++){
            if (p.children[chars[i] - 'a'] == null){
                p.children[chars[i] - 'a'] = new TrieNode(chars[i]);
            }
            p = p.children[chars[i] - 'a'];
        }
        p.isWord = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        if (word == null || word.length() == 0){
            return false;
        }
        char[] chars = word.toCharArray();
        TrieNode p = root;
        int i = 0;
        while (p.children != null && i < chars.length){
            if (p.children[chars[i] - 'a'] == null){
                return false;
            }
            p = p.children[chars[i++] - 'a'];
        }
        return p.isWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        if (prefix == null || prefix.length() == 0){
            return false;
        }
        char[] chars = prefix.toCharArray();
        TrieNode p = root;
        int i = 0;
        while (p.children != null && i < chars.length){
            if (p.children[chars[i] - 'a'] == null){
                return false;
            }
            p = p.children[chars[i++] - 'a'];
        }
        return true;
    }
}
class TrieNode{
    char val;
    TrieNode[] children;
    boolean isWord;
    TrieNode(char x){
        val = x;
        children = new TrieNode[26];
    }
}
