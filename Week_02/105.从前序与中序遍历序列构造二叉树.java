/*
 * @lc app=leetcode.cn id=105 lang=java
 *
 * [105] 从前序与中序遍历序列构造二叉树
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
    Map <Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i ++) {
            map.put(inorder[i], i);
        }
        return helper(preorder, inorder, 0, inorder.length - 1, 0, inorder.length - 1);

    }

    public TreeNode helper(int[] preorder, int[] inorder, int preorder_left, int preorder_right, int inorder_left, int inorder_right) {
        if (preorder_left > preorder_right || inorder_left > inorder_right) {
            return null;
        }

        int preorder_root = preorder_left;
        TreeNode root = new TreeNode(preorder[preorder_root]);
        int inorder_root = map.get(preorder[preorder_root]);
        int size_left_tree = inorder_root - inorder_left;

        TreeNode leftchild = helper(preorder, inorder, preorder_left + 1, preorder_left + size_left_tree,
        inorder_left, inorder_root - 1);
        TreeNode rightchild = helper(preorder, inorder, preorder_left + size_left_tree + 1, preorder_right, 
        inorder_root + 1, inorder_right);
        root.left = leftchild;
        root.right = rightchild;


        return root;
    }

}
// @lc code=end

