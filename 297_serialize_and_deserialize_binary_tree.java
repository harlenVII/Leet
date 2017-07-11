/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        toString(root, sb);
        return sb.toString();
    }
    
    private void toString(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("X;");
            return;
        }
        sb.append(root.val).append(";");
        toString(root.left, sb);
        toString(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(";")));
        return parse(queue);
    }
    
    private TreeNode parse(Queue<String> queue) {
        String temp = queue.poll();
        if (temp.equals("X"))
            return null;
        TreeNode node = new TreeNode(Integer.parseInt(temp));
        node.left = parse(queue);
        node.right = parse(queue);
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
