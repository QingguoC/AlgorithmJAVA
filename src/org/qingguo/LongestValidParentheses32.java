package org.qingguo;

import java.util.Stack;

public class LongestValidParentheses32 {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() < 2) return 0;
        Stack<Integer> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for(int i = 0; i < chars.length; i++){
            if (chars[i] == '(') stack.add(i + 1);
            else {
                if (!stack.isEmpty() && stack.peek() > 0 ){
                    stack.pop();
                    continue;
                }else{
                    stack.add(-(i + 1));
                }
            }
        }
        if (stack.isEmpty()) return chars.length;
        int max = 0;
        int last = chars.length;
        int start = 0;
        while (!stack.isEmpty()){
            start = Math.abs(stack.pop());
            max = Math.max(max, last - start);
            last = start - 1;
        }
        max = Math.max(max, last - 0);
        return max;
    }


}
