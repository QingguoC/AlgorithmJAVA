package org.qingguo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindDuplicateSubtrees652 {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        Map<String, Integer> map = new HashMap();
        List<TreeNode> list = new ArrayList<>();
        helper(root,map, list);
        return list;

    }
    private String helper(TreeNode root, Map<String, Integer> map, List<TreeNode> list ){
        if(root == null) return "#";
        String hash = "" + root.val + helper(root.left,map,list) + helper(root.right, map, list);
        if(map.getOrDefault(hash, 0) == 1) {
            list.add(root);
        }
        map.put(hash,map.getOrDefault(hash,0) + 1);
        return hash;
    }
}
