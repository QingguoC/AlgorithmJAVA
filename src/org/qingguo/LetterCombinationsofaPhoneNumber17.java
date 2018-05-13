package org.qingguo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LetterCombinationsofaPhoneNumber17 {

    List<String> result;
    public List<String> letterCombinations(String digits) {
        result  = new ArrayList<>();
        if (digits == null || digits.length() == 0){
            return result;
        }
        HashMap<Integer, String> map = new HashMap<>();
        map.put(2,"abc");
        map.put(3,"def");
        map.put(4,"ghi");
        map.put(5,"jkl");
        map.put(6,"mno");
        map.put(7,"pqrs");
        map.put(8,"tuv");
        map.put(9,"wxyz");

        result.add("");
        helper(map,result,digits);
        return result;
    }

    private void helper(HashMap<Integer, String> map, List<String> res, String digits) {
        if (digits == null || digits.length() == 0){
            return;
        }
        String toAdd = map.get(digits.charAt(0) - '0');
        List<String> newRes = new ArrayList<>();
        for (String s : res){
            for (char c : toAdd.toCharArray()){
                newRes.add(s + c);
            }
        }
        result = newRes;
        helper(map,newRes,digits.substring(1));

    }

}
