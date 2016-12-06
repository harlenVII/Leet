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
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node n = queue.poll();
                if (n.node.left != null)
                    queue.offer(new Node(n.node.left, n.level - 1));
                if (n.node.right != null)
                    queue.offer(new Node(n.node.right, n.level + 1));
                if (map.containsKey(n.level)) {
                    map.get(n.level).add(n.node.val);
                } else {
                    List<Integer> list = new ArrayList<>();
                    list.add(n.node.val);
                    map.put(n.level, list);
                }
            }
        }
        for (List<Integer> list : map.values()) {
            res.add(new ArrayList<Integer>(list));
        }
        return res;
    }
}
