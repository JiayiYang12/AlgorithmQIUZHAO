import java.util.Queue;

import org.w3c.dom.Node;

/*
 * @lc app=leetcode.cn id=429 lang=java
 *
 * [429] N叉树的层序遍历
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<Node> stk = new LinkedList<>();
        if (root == null) return res;
        stk.add(root);
        while (!stk.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = stk.size();
            for (int i = 0; i< size; i++) {
                Node node = stk.poll();
                level.add(node.val);
                stk.addAll(node.children);
            }
            res.add(level);
        }
        return res;
    }
}
// @lc code=end

