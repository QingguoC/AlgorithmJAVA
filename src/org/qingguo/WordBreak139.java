package org.qingguo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/*
idea:
dp method.
string ending at i index is true if any previous index with dp value true, and from the next to i is in the dictionary.

dp[i] is true meaning substing from 0 to the ending at i can be segmented to some words in dictionary.
 */


public class WordBreak139 {
    public static void main(String[] args){
        WordBreak139 wordBreak139 = new WordBreak139();
        List<String> dict = new ArrayList<>();
        dict.add("cats");
        dict.add("sand");
        dict.add("dog");
        dict.add("and");
        dict.add("cat");
        System.out.println(wordBreak139.wordBreak("catsandog",dict));
    }
    public boolean wordBreak(String s, List<String> wordDict){
        HashSet<String> dict = new HashSet<>();
        for (String str : wordDict){
            dict.add(str);
        }
        boolean[] dp = new boolean[s.length()];
        if (dict.contains(s.substring(0,1))){
            dp[0] = true;
        }
        for (int i = 1; i < s.length(); i++){
            if (dict.contains(s.substring(0,i+1))){
                dp[i] = true;
            }
            for (int j = 0; j < i && !dp[i]; j++){
                if (dp[j] && dict.contains(s.substring(j+1,i+1))){
                    dp[i] = true;
                }
            }
        }
        return dp[s.length()-1];
    }
}
