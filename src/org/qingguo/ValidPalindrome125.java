package org.qingguo;

public class ValidPalindrome125 {
    public boolean isPalindrome(String s){
        if (s == null || s.length() == 0){
            return true;
        }
        String str = s.replaceAll("\\W","");
        str = str.toLowerCase();

        int lt = 0;
        int rt = str.length()-1;
        while (lt < rt){
            if (str.charAt(lt++) != str.charAt(rt--)){
                return false;
            }
        }
        return true;
    }
}
