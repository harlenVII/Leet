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
    public int sumNumbers(TreeNode root) {
        if (root == null)
            return 0;
        ArrayList<StringBuilder> list = constructPath(root);
        int result = 0;
        for (StringBuilder s : list){
            System.out.println(s);
            result += Integer.parseInt(s.reverse().toString());
        }
        return result;
    }
    private ArrayList<StringBuilder> constructPath(TreeNode root){
        if (root == null)
            return null;
        ArrayList<StringBuilder> left = constructPath(root.left);
        ArrayList<StringBuilder> right = constructPath(root.right);
        if (left == null && right == null){
            ArrayList<StringBuilder> leaf = new ArrayList<>();
            leaf.add(new StringBuilder(String.valueOf(root.val)));
            return leaf;
        }
        if (left != null && right != null)
            left.addAll(right);
        else if (right != null)
            left = right;
        for(int i = 0; i < left.size(); i++)
            left.get(i).append(root.val);
        return left;
    }
}


// a concise version
int totalSum = 0;

public int sumNumbers(TreeNode root) {
    sum(root, 0);
    return totalSum;
}

public void sum(TreeNode root, int sum) {
    if (root == null) return;

    sum = sum * 10 + root.val;

    if (root.left == null && root.right == null) {
        totalSum += sum;
        return;
    }

    sum(root.left, sum);
    sum(root.right, sum);
}

