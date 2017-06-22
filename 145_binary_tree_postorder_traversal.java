/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    class Node{
        Node(TreeNode node) {
            this.node = node;
            visited = false;
        }
        TreeNode node;
        boolean visited;
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null)
            return res;
        TreeNode temp = root;
        Stack<Node> stack = new Stack<>();
        while (temp != null || !stack.isEmpty()) {
            if (temp != null) {
                stack.push(new Node(temp));
                temp = temp.left;
            } else {
                Node node = stack.pop();
                if (!node.visited) {
                    stack.push(node);
                    temp = node.node.right;
                    node.visited = true;
                } else {
                    res.add(node.node.val);    
                }
            }
        }
        return res;
    }
}
