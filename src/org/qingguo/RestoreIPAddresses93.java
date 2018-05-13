package org.qingguo;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses93 {
    public static void main(String[] args){
        RestoreIPAddresses93 rs = new RestoreIPAddresses93();
        System.out.println(rs.restoreIpAddresses("25525511135"));
    }
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() < 4 || s.length() > 12){
            return res;
        }
        dfs(s, res,0,0,"");

        return res;
    }
    private void dfs(String s, List<String> res, int curr, int count, String currString){
        if (count > 4) return;
        if(curr == s.length() && count == 4){
            res.add(currString);
            return;
        }
        for (int i = 1; i < 4; i++){
            if (curr + i > s.length()) break;
            String temp = s.substring(curr,curr + i);
            if ((temp.charAt(0) == '0' && i > 1) || (i == 3 && Integer.parseInt(temp) > 255)){
                continue;
            }
            dfs(s,res,curr + i, count + 1, currString + temp + (count == 3 ? "":"."));
        }
    }
}
