import java.util.Stack;

import org.w3c.dom.Node;

/*
 * @lc app=leetcode.cn id=590 lang=java
 *
 * [590] N叉树的后序遍历
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
    public List<Integer> postorder(Node root) {
        Deque<Integer> res = new ArrayDeque<Integer> ();
        Stack <Node> stk = new Stack<>();
        if (root == null) return new ArrayList(res);
        stk.add(root);
        while (!stk.isEmpty()) {
            Node node = stk.pop();
            res.addFirst(node.val);
            for (Node item: node.children) {
                stk.push(item);
            }
        }
        return new ArrayList(res);
    }
}
// @lc code=end

