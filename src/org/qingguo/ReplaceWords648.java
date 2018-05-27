package org.qingguo;

import java.util.List;

public class ReplaceWords648 {
    public String replaceWords(List<String> dict, String sentence) {
        Trie trie = new Trie();
        for (String s : dict){
            trie.insert(s);
        }
        String[] words = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        String f = trie.findRoot(words[0]);
        if (f != null){
            sb.append(f);
        } else {
            sb.append(words[0]);
        }

        for(int i  = 1; i < words.length; i++){
            String temp = trie.findRoot(words[i]);
            if (temp == null) {
                sb.append(" " + words[i]);
            } else {
                sb.append(" " + temp);
            }
        }

        return sb.toString();
    }
    class TrieNode{
        String word;
        TrieNode[] children;
        public TrieNode(){
            this.children = new TrieNode[26];
        }
    }
    class Trie{
        TrieNode root;
        Trie(){
            this.root = new TrieNode();
        }
        public void insert(String s){
            if (s == null || s.length() == 0) return;
            char[] chars = s.toCharArray();
            TrieNode p = this.root;
            for (char c : chars){
                if (p.children[c - 'a'] == null){
                    p.children[c - 'a'] = new TrieNode();
                }
                p = p.children[c - 'a'];
            }
            p.word = s;
        }
        public String findRoot(String s){
            if (s == null || s.length() == 0) return null;
            char[] chars = s.toCharArray();
            TrieNode p = this.root;
            for (char c : chars){
                if (p.children[c - 'a'] == null){
                    return null;
                }
                p = p.children[c - 'a'];
                if (p.word != null){
                    return p.word;
                }
            }
            if (p.word != null){
                return p.word;
            }
            return null;
        }
    }
}
