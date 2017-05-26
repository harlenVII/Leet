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
    Map<Integer, Integer> counts = new HashMap<>();
    public int[] findFrequentTreeSum(TreeNode root) {
        getSum(root);
        if (counts.isEmpty()) 
            return new int[0];
        int max = Collections.max(counts.values());
        List<Integer> res = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            if (entry.getValue() == max)
                res.add(entry.getKey());
        }
        return res.stream().mapToInt(i->i).toArray();
    }
    private int getSum(TreeNode root) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null) {
            counts.put(root.val, counts.getOrDefault(root.val, 0) + 1);
            return root.val;
        }
        int sum = getSum(root.left) + getSum(root.right) + root.val;
        counts.put(sum, counts.getOrDefault(sum, 0) + 1);
        return sum;
    }
}
