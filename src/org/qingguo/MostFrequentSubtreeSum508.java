package org.qingguo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MostFrequentSubtreeSum508 {
    int mostFreq = 0;
    public int[] findFrequentTreeSum(TreeNode root) {
        HashMap<Integer, Integer> count = new HashMap<>();
        helper(root,count);
        List<Integer> mostFreqList = new ArrayList<>();
        for(int i : count.keySet()){
            if (count.get(i) == mostFreq){
                mostFreqList.add(i);
            }
        }
        int[] res = new int[mostFreqList.size()];
        for (int i = 0; i < res.length; i++){
            res[i] = mostFreqList.get(i);
        }
        return res;
    }

    private int helper(TreeNode root, HashMap<Integer, Integer> count){
        if (root == null) return 0;
        root.val = root.val + helper(root.left, count) + helper(root.right, count);
        count.put(root.val, count.getOrDefault(root.val,0) + 1);
        if (count.get(root.val) > mostFreq){
            mostFreq = count.get(root.val);
        }
        return root.val;
    }

}
