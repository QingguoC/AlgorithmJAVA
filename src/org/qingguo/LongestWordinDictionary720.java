package org.qingguo;

import java.util.Arrays;
import java.util.HashSet;

public class LongestWordinDictionary720 {
    public static void main(String[] args){
        HashSet<String> set = new HashSet<>();
        set.add("");
        String[] words = new String[]{"yo","ew","fc","zrc","yodn","fcm","qm","qmo","fcmz","z","ewq","yod","ewqz","y"};
        LongestWordinDictionary720 longestWordinDictionary720 = new LongestWordinDictionary720();
        System.out.println(longestWordinDictionary720.longestWord(words));
    }
    String res;
    public String longestWord(String[] words) {

        res = "";
        Trie trie = new Trie();
        for (String w : words){
            trie.insert(w);
        }
        for(TrieNode child : trie.root.children){
            helper(child);
        }
        return res;
    }
    public void helper(TrieNode node){
        if (node == null || node.word == null) return;
        if (node.word.length() > res.length()) res = node.word;
        for (TrieNode child : node.children){
            helper(child);
        }
        return;
    }
    class TrieNode{
        String word;
        TrieNode[] children;
        TrieNode(){
            this.children = new TrieNode[26];
        }
    }
    class Trie{
        TrieNode root;
        Trie(){
            this.root = new TrieNode();
        }
        public void insert(String s){
            if (s == null || s.length() == 0){
                return;
            }
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
    }
    public String longestWord1(String[] words) {
        Arrays.sort(words);
        String res = "";
        HashSet<String> set = new HashSet<>();
        set.add("");
        for(String w : words){
            if(set.contains(w.substring(0,w.length()-1))){
                set.add(w);
                if(w.length() > res.length()) res = w;
            }
        }
        return res;
    }
}
