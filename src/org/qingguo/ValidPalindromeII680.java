package org.qingguo;

public class ValidPalindromeII680 {
    public boolean validPalindrome(String s) {
        int lf = 0;
        int rt = s.length() - 1;
        while (lf < rt){
            if (s.charAt(lf) != s.charAt(rt)){
                return isPanlindrome(s,lf + 1, rt) || isPanlindrome(s,lf, rt - 1);
            }
            lf++;
            rt--;
        }
        return true;
    }
    public boolean isPanlindrome(String s, int lf, int rt){
        while (lf < rt){
            if (s.charAt(lf) != s.charAt(rt)){
                return false;
            }
            lf++;
            rt--;
        }
        return true;
    }
}
