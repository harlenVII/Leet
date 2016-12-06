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
    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> tree = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp = root;
        while (temp != null || !stack.empty()){
            while (temp != null){
                stack.push(temp);
                temp = temp.left;
            }
            if (!stack.empty()){
                temp = stack.pop();
                tree.add(temp.val);
                if (tree.size() == k){
                    return tree.get(k - 1);
                }
                temp = temp.right;
            }
        }
        return -1;//will never be called if k is legal.
    }
}
