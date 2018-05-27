package org.qingguo;

public class MagicDictionary {
    public static void main(String[] args){
        MagicDictionary md = new MagicDictionary();
        md.buildDict(new String[]{"hello","leetcode"});
        System.out.println(md.search("hello"));
        System.out.println(md.search("hhllo"));
        System.out.println(md.search("hell"));
        System.out.println(md.search("leetcoded"));
    }
    /** Initialize your data structure here. */
    Trie trie;
    public MagicDictionary() {
        this.trie = new Trie();
    }

    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        if (dict == null || dict.length == 0) return;
        for(String s : dict){
            trie.insert(s);
        }
    }

    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
        if (word == null || word.length() == 0) return false;

        return helper(word,false,0,this.trie.root);
    }
    private boolean helper(String word, boolean shifted, int curr, TrieNode node){
        if (node == null || curr > word.length()) {

            return false;
        }

        if (curr == word.length() ) {
            if (shifted && node != null && node.isWord){
                    return true;
            } else {
                return false;
            }
        }


        if (shifted){
            if (helper(word,true, curr + 1, node.children[word.charAt(curr) - 'a'])){
                return true;
            }

            return false;
        }
        for (int i = 0; i < 26; i++){
            if (word.charAt(curr) - 'a' == i) {
                if (helper(word,false, curr + 1, node.children[i])){
                    return true;
                }
            } else {
                if (helper(word,true, curr + 1, node.children[i])){

                    return true;
                }
            }

        }

        return false;

    }
}
