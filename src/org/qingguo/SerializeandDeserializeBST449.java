package org.qingguo;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SerializeandDeserializeBST449 {
    public static void main(String[] args){
        SerializeandDeserializeBST449 sd = new SerializeandDeserializeBST449();
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        n1.left = n2;
        n1.right = n3;
        n3.left = n4;
        n4.right = n5;
        n4.left = n6;
        System.out.println(sd.serialize(n1));
    }
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "# ";
        return "" + root.val + " " + serialize(root.left) + serialize(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) return null;
        Queue<String> queue = new LinkedList<>();
        queue.addAll(Arrays.asList(data.split(" ")));
        return helper(queue);
    }
    private TreeNode helper(Queue<String> queue){
        if (queue.isEmpty()) return null;
        String curr = queue.poll();
        if (curr.equals("#")) return null;
        TreeNode root = new TreeNode(Integer.parseInt(curr));
        root.left = helper(queue);
        root.right = helper(queue);
        return root;
    }
}
