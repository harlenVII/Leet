public class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<>();
        if (n < 0 || edges == null)
            return res;
        if (n == 1) {
            res.add(0);
            return res;
        }
        List<Set<Integer>> graph = new ArrayList<>(); // use set to delete element by value
        for (int i = 0; i < n; i++) {
            graph.add(new HashSet<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        
        // get all leaves
        for (int i = 0; i < n; i++)
            if (graph.get(i).size() == 1)
                res.add(i);
        
        // from leaf to root, bfs
        while (n > 2) {
            n -= res.size();
            List<Integer> list = new ArrayList<>();
            for (int i : res) {
                int j = graph.get(i).iterator().next();
                graph.get(j).remove(i);
                if (graph.get(j).size() == 1)
                    list.add(j);
            }
            res = list;
        }
        return res;
    }
}
