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
    public int countNodes(TreeNode root) {
        if (root == null)
            return 0;
        int height = 0;
        TreeNode temp = root;
        while (temp.left != null){
            height++;
            temp = temp.left;
        }
        int count = 0;
        int curLevel = 0;
        while (root != null){//binary search
            TreeNode node = root.left;
            if (node == null){//no more subtree
                if (curLevel ==  height)//it is leaf, of course has no subtrees
                    count++;//add itself
                break;
            }
            int depth = curLevel;
            while (node != null){
                depth++;
                node = node.right;
            }
            curLevel++;
            if (depth == height){
                count += 1 << (height - curLevel);
                root = root.right;
            }else
                root = root.left;
        }
        return count + (1 << height) - 1;
    }
}
