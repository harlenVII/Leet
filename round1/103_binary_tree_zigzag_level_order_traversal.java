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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        
        if (root == null)
            return list;
        queue.offer(root);
        boolean fromLeftToRight = true;
        while (!queue.isEmpty()){
            int size = queue.size();
            LinkedList<Integer> tempList = new LinkedList<>();
            for (int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                if (fromLeftToRight)
                    tempList.add(node.val);
                else
                    tempList.addFirst(node.val);
                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
            }
            fromLeftToRight = !fromLeftToRight;
            list.add(tempList);
        }
        return list;
    }
}
