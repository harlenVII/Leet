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
    class Node {
        TreeNode node;
        int level;
        Node(TreeNode n, int l) {
            node = n;
            level = l;
        }
    }
    
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        Queue<Node> queue = new LinkedList<>();
        Map<Integer, List<Integer>> map = new TreeMap<>();
        queue.offer(new Node(root, 0));
        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            map.computeIfAbsent(temp.level, k-> new ArrayList<>()).add(temp.node.val);
            if (temp.node.left != null)
                queue.offer(new Node(temp.node.left, temp.level - 1));
            if (temp.node.right != null)
                queue.offer(new Node(temp.node.right, temp.level + 1));
        }
        res.addAll(map.values());
        return res;
    }
}
