public class Solution {
    class Node{
        int value;
        int leftSum;
        int count;
        Node left, right;
        Node (int value) {
            this.value = value;
        }
    }
    public List<Integer> countSmaller(int[] nums) {
        Integer[] res = new Integer[nums.length];
        if (nums.length == 0)
            return Arrays.asList(res);
        Node root = new Node(nums[nums.length - 1]);
        for (int i = nums.length - 1; i >= 0; i--) {
            res[i] = insert(root, nums[i]);
        }
        return Arrays.asList(res);
    }
    private int insert(Node node, int num) {
        int sum = 0;
        while (node.value != num) {
            if (node.value > num) {
                if (node.left == null)
                    node.left = new Node(num);
                node.leftSum++;
                node = node.left;
            } else {
                if (node.right == null)
                    node.right = new Node(num);
                sum += node.count + node.leftSum;
                node = node.right;
            }
        }
        node.count++;
        return sum + node.leftSum;
    }
}
/* Every node will maintain a val sum recording the total of number on it's left bottom side, dup counts the duplication. For example, [3, 2, 2, 6, 1], from back to beginning,we would have:

                1(0, 1)
                     \
                     6(3, 1)
                     /
                   2(0, 2)
                       \
                        3(0, 1)
When we try to insert a number, the total number of smaller number would be adding dup and sum of the nodes where we turn right.
for example, if we insert 5, it should be inserted on the way down to the right of 3, the nodes where we turn right is 1(0,1), 2,(0,2), 3(0,1), so the answer should be (0 + 1)+(0 + 2)+ (0 + 1) = 4
*/
