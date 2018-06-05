package org.qingguo;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreefromInorderandPostorderTraversal106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(postorder == null || postorder.length == 0 || inorder == null || inorder.length == 0 || postorder.length != inorder.length) return null;
        Map<Integer, Integer> mapI = new HashMap<>();
        for(int i = 0; i < inorder.length; i++){
            mapI.put(inorder[i],i);
        }
        return helper(inorder,0, inorder.length - 1, postorder, 0, inorder.length - 1, mapI);
    }

    private TreeNode helper(int[] inorder, int stI, int edI, int[] postorder, int stP, int edP, Map<Integer,Integer> map){
        if(stI > edI || stP > edP) return null;
        TreeNode root = new TreeNode(postorder[edP]);
        if(stI == edI) return root;
        int rootI = map.get(root.val);
        root.left = helper(inorder,stI,rootI - 1, postorder,stP,stP + rootI - 1 - stI, map);
        root.right = helper(inorder,rootI + 1, edI, postorder,stP + rootI  - stI,edP - 1, map);
        return root;
    }
}
