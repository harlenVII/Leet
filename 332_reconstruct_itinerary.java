public class Solution {
    public List<String> findItinerary(String[][] tickets) {
        if (tickets == null)
            return null;
        Map<String, PriorityQueue<String>> graph = new HashMap<>();
        for (String[] ticket : tickets) {
            graph.computeIfAbsent(ticket[0], k -> new PriorityQueue<>()).offer(ticket[1]);
        }
        List<String> res = new ArrayList<>();
        visit("JFK", graph, res);
        return res;
    }
    private void visit(String node, Map<String, PriorityQueue<String>> graph, List<String> res) {
        while (graph.containsKey(node) && graph.get(node).size() > 0) {
            visit(graph.get(node).poll(), graph, res);
        }
        res.add(0, node);
    }
}
