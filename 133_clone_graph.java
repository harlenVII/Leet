/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
// DFS
// public class Solution {
//     public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
//         if (node == null)
//             return null;
//         Queue<UndirectedGraphNode> queue= new LinkedList<>();
//         HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        
//         queue.offer(node);
//         while (!queue.isEmpty()) {
//             UndirectedGraphNode tempNode = queue.poll();
//             map.put(tempNode, new UndirectedGraphNode(tempNode.label));
//             for (UndirectedGraphNode temp : tempNode.neighbors)
//                 if (!map.containsKey(temp))
//                     queue.offer(temp);
//         }
//         for (Map.Entry<UndirectedGraphNode, UndirectedGraphNode> entry : map.entrySet()) {
//             for (UndirectedGraphNode temp : entry.getKey().neighbors)
//                 entry.getValue().neighbors.add(map.get(temp));
//         }
//         return map.get(node);
//     }
// }

//BFS
public class Solution {
    HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null)
            return null;
        if (map.containsKey(node))
            return map.get(node);
        UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
        map.put(node, newNode);
        for (UndirectedGraphNode temp : node.neighbors) {
            newNode.neighbors.add(cloneGraph(temp));
        }
        return newNode;
    }
}
