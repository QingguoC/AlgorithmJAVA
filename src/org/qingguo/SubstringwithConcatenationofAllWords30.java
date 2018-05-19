package org.qingguo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SubstringwithConcatenationofAllWords30 {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0){
            return res;
        }
        HashMap<String, Integer> wordCounts = new HashMap<>();
        for (String w : words){
            wordCounts.put(w,wordCounts.getOrDefault(w,0) + 1);
        }
        int unitLen = words[0].length();
        for (int i = 0; i < s.length() - unitLen + 1; i++) {
            HashMap<String, Integer> seen = new HashMap<>();
            int count = 0;
            while (count < words.length) {
                if (i + count * unitLen + unitLen > s.length()) break;
                String curr = s.substring(i + count * unitLen, i + count * unitLen + unitLen);
                if (!wordCounts.containsKey(curr) || seen.getOrDefault(curr, 0) >= wordCounts.get(curr)) {
                    break;
                }
                seen.put(curr, seen.getOrDefault(curr, 0) + 1);
                count++;
            }
            if (count == words.length) {
                res.add(i);
            }

        }
        return res;
    }
}
