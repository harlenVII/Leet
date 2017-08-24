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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        helper(root, res, new ArrayList<>(), sum);
        return res;
    }
    private void helper(TreeNode node, List<List<Integer>> res, List<Integer> cur, int left) {
        if (node == null)
            return;
        cur.add(node.val);
        if (node.left == null && node.right == null) {
            if (left == node.val)
                res.add(new ArrayList<>(cur));
        }
        helper(node.left, res, cur, left - node.val);
        helper(node.right, res, cur, left - node.val);
        cur.remove(cur.size() - 1);
    }
}
