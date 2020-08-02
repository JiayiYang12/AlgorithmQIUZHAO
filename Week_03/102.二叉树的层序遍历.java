import java.util.ArrayList;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=102 lang=java
 *
 * [102] 二叉树的层序遍历
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<> ();
        // res中的元素为多个Integer数组，每个数组代表同一层的结点遍历结果
        if (root == null) return res;
        Queue <TreeNode> nodes = new LinkedList<>();
        // nodes中的结点，均为单独添加，不区分是否有括号括起
        nodes.add(root);
        while (!nodes.isEmpty()) {
            int size = nodes.size(); // 记录当前层结点的个数
            List<Integer> cur_layer_res = new ArrayList<>();
            for (int i = 0; i < size; i ++) {
                TreeNode head = nodes.poll();
                cur_layer_res.add(head.val);
                if (head.left != null) {
                    nodes.add(head.left);
                }
                if (head.right != null) {
                    nodes.add(head.right);
                }
            }
            res.add(cur_layer_res);
        }
        return res;
    }
}
// @lc code=end

