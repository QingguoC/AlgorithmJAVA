package org.qingguo;

import java.util.ArrayList;
import java.util.List;

public class SumRoottoLeafNumbers129 {
    int sums;
    public int sumNumbers(TreeNode root){
        sums = 0;
        dfs(root,0);
        return sums;
    }
    public void dfs(TreeNode root, int sum){
        if (root == null){
            sums += sum;
            return;
        }
        if (root.left == null && root.right == null){
            sums += sum * 10 + root.val;
            return;
        }
        if (root.left != null){
            dfs(root.left,sum * 10 + root.val);
        }

        if (root.right != null){
            dfs(root.right,sum * 10 + root.val);
        }
    }
}
