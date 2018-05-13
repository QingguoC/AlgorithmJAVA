package org.qingguo;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeandDeserializeBinaryTree297 {
    public static void main(String[] args){
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        t1.left = t2;
        t2.right = t3;
        t3.left = t4;
        t1.right = t5;
        SerializeandDeserializeBinaryTree297 sd = new SerializeandDeserializeBinaryTree297();
        System.out.println(sd.serialize(t1));
    }
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null){
            return "#";
        }

        return "" + root.val + " " + serialize(root.left) + " " + serialize(root.right);
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] dataArr = data.split(" ");
        Queue<String> dataQ = new LinkedList<>();
        for (String s : dataArr){
            dataQ.add(s);
        }
        TreeNode root  = helper(dataQ);
        return root;
    }
    private TreeNode helper(Queue<String> dataQ){
        if (dataQ.isEmpty()){
            return null;
        }
        String curr = dataQ.poll();
        if (curr.equals("#")){
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(curr));
        root.left = helper(dataQ);
        root.right = helper(dataQ);
        return root;
    }
}
