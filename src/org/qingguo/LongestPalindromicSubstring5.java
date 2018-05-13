package org.qingguo;

public class LongestPalindromicSubstring5 {
    private int lo, maxLen;
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0){
            return null;
        }
        if(s.length() == 1){
            return s;
        }
        for (int i = 0; i < s.length()-1; i++){
            expand(s,i,i);
            expand(s,i, i+1);
        }
        return s.substring(lo,lo+maxLen);
    }

    private void expand(String s, int l, int r) {
        while (l >=0 && r < s.length() && s.charAt(l) == s.charAt(r)){
            l--;
            r++;
        }
        if(maxLen < r - l - 1){
            maxLen = r - l - 1;
            lo = l+1;
        }
    }
}
