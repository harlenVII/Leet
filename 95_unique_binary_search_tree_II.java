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
    public List<TreeNode> generateTrees(int n) {
        List<List<TreeNode>> allList = new ArrayList<>();
        
        List<TreeNode> list = new ArrayList<TreeNode>();
        allList.add(list);
        
        list = new ArrayList<TreeNode>();
        list.add(new TreeNode(1));
        allList.add(list);
        
        for (int nodeNum = 2; nodeNum <= n; nodeNum++){
            list = new ArrayList<>();
            for (int rootVal = 1; rootVal <= nodeNum; rootVal++){
                if (rootVal == 1){//left is null
                    for (int r = 0; r < allList.get(nodeNum - rootVal).size(); r++){
                        TreeNode root = new TreeNode(rootVal);
                        root.left = null;
                        root.right = copy(allList.get(nodeNum - rootVal).get(r));
                        addVal(root.right, rootVal);
                        list.add(root);
                    }
                }else if (rootVal == nodeNum){//right is null
                    for (int l = 0; l < allList.get(rootVal - 1).size(); l++){
                        TreeNode root = new TreeNode(rootVal);
                        root.left = copy(allList.get(rootVal - 1).get(l));
                        root.right = null;
                        list.add(root);
                    }
                }else
                    for (int l = 0; l < allList.get(rootVal - 1).size(); l++)
                        for (int r = 0; r < allList.get(nodeNum - rootVal).size(); r++){
                            TreeNode root = new TreeNode(rootVal);
                            root.left = copy(allList.get(rootVal - 1).get(l));
                            root.right = copy(allList.get(nodeNum - rootVal).get(r));
                            addVal(root.right, rootVal);
                            list.add(root);
                        }
            }
            allList.add(list);
        }
        return allList.get(n);
    }
    private TreeNode copy(TreeNode root){
        if (root == null)
            return null;
        TreeNode newNode = new TreeNode(root.val);
        newNode.left = copy(root.left);
        newNode.right = copy(root.right);
        return newNode;
    }
    private void addVal(TreeNode root, int num){
        if (root == null)
            return;
        root.val += num;
        addVal(root.left, num);
        addVal(root.right, num);
    }
}
