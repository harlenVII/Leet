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
    public TreeNode str2tree(String s) {
        if (s.length() == 0)
            return null;
        int i = 1;
        while (i < s.length() && Character.isDigit(s.charAt(i))) i++;
        TreeNode root = new TreeNode(Integer.parseInt(s.substring(0, i)));
        if (i != s.length()) {
            // find corresponding right brace
            i++;
            int start = i;
            int count = 1;
            while (count != 0) {
                if (s.charAt(i) == '(')
                    count++;
                else if (s.charAt(i) == ')')
                    count--;
                i++;
            }
            root.left = str2tree(s.substring(start, i - 1));
        }
        if (i != s.length()) {
            root.right = str2tree(s.substring(i + 1, s.length() - 1));
        }
        return root;
    }
}
