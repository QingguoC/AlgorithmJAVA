package org.qingguo;

public class DeleteNodeinaBST450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        if (root.val == key) {
            if (root.left == null && root.right == null) {
                root = null;
                return root;
            }
            if (root.right != null){
                TreeNode p = root.right;
                if (p.left == null){
                    p.left = root.left;
                    root = p;
                    return root;
                }
                TreeNode q = p.left;
                while (q.left != null) {
                    p = p.left;
                    q = q.left;
                }
                p.left = q.right;
                q.right = root.right;
                q.left = root.left;
                root = q;
                return root;
            }
            else {
                root = root.left;
                return root;
            }
        }
        if (root.val > key) root.left = deleteNode(root.left,key);
        else root.right = deleteNode(root.right,key);
        return root;
    }

}
