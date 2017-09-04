class Solution {
    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++)
            graph.add(new ArrayList<>());
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        Set<Integer> visited = new HashSet<>();
        if (dfs(-1, 0, visited, graph) == false) return false;
        if (visited.size() != n) return false;
        return true;
        
    }
    private boolean dfs(int pre, int cur, Set<Integer> visited, List<List<Integer>> graph) {
        visited.add(cur);
        for (int adj : graph.get(cur)) {
            if (adj == pre) continue;
            if (visited.contains(adj)) return false;
            if (dfs(cur, adj, visited, graph) == false) return false; 
        }
        return true;
    }
}
