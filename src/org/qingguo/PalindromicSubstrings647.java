package org.qingguo;

public class PalindromicSubstrings647 {
    int count;
    public int countSubstrings(String s) {
        if (s == null || s.length() == 0){
            return 0;
        }
        if (s.length() == 1){
            return 1;
        }
        count = 0;
        for (int i = 0; i < s.length(); i++){
            extend(s,i,i);

            extend(s,i,i+1);
        }
        return count;
    }

    private void extend(String s, int lo, int hi) {
        while (lo >= 0 && hi < s.length() && s.charAt(lo) == s.charAt(hi)){
            count++;
            lo--;
            hi++;
        }
    }
}
