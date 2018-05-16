package org.qingguo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeZigzagLevelOrderTraversal103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> front = new LinkedList<>();
        Queue<TreeNode> newFront = null;
        front.add(root);
        boolean order = true;
        while (!front.isEmpty()){
            newFront = new LinkedList<>();
            List<Integer> temp = new ArrayList<>();
            while (!front.isEmpty()){
                TreeNode node = front.poll();
                if (order){
                    temp.add(node.val);
                } else {
                    temp.add(0,node.val);
                }

                if (node.left != null){
                    newFront.add(node.left);
                }
                if (node.right != null){
                    newFront.add(node.right);
                }
            }
            front = newFront;
            order = !order;
            res.add(temp);
        }
        return res;
    }
}
