import javax.swing.tree.TreeNode;

import apple.laf.JRSUIUtils.Tree;

/*
 * @lc app=leetcode.cn id=236 lang=java
 *
 * [236] 二叉树的最近公共祖先
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private TreeNode res;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return res;

    }

    public boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        // terminator
        if (root == null) return false;

        boolean leftson = dfs(root.left, p, q);
        boolean rightson = dfs(root.right, p, q);

        // p, q是否同时存在于以root为根结点的树上
        if ((leftson && rightson) || ((leftson || rightson) && (root.val == p.val || root.val == q.val))) {
            res = root;
        }

        // p, q中任意一个存在于以root为根结点的树上
        return leftson || rightson || root.val == p.val || root.val == q.val;




    }
}
// @lc code=end

