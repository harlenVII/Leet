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
    private class HelperNode{
        TreeNode node;
        boolean isVisited;
        HelperNode(TreeNode node){
            this.node = node;
            isVisited = false;
        }
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<HelperNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<Integer>();
        TreeNode tmp = root;
        while (tmp != null || !stack.empty()){
            while (tmp != null){
                HelperNode helperNode = new HelperNode(tmp);
                stack.push(helperNode);
                tmp = tmp.left;
            }
            if (!stack.empty()){
                HelperNode top = stack.pop();
                if (!top.isVisited){
                    top.isVisited = true;
                    stack.push(top);
                    tmp = top.node.right;
                }else{
                    list.add(top.node.val);
                    tmp = null;
                }
            }
        }
        return list;
    }
}
