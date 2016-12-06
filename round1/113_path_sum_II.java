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
    List<List<Integer>> list= new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        helper(root, sum, 0, new ArrayList<Integer>());
        return list;
    }
    private void helper(TreeNode root, int sum, int cur, List<Integer> curList){
        if (root == null)
            return;
        curList.add(root.val);
        if (root.left == null && root.right == null) // leaf
            if (sum == cur + root.val){
                list.add(curList);
                return;
            }
        List<Integer> newList = new ArrayList<>(curList);
        helper(root.right, sum, cur + root.val, curList);
        helper(root.left, sum, cur + root.val, newList);
    }
}
