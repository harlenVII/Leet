public class Solution {
    public List<String> findItinerary(String[][] tickets) {
        LinkedList<String> result = new LinkedList<>();
        if (tickets == null || tickets.length == 0)
            return result;
        
        // a better solution is using priorityqueue instead of linkedlist
        HashMap<String, LinkedList<String>> graph = new HashMap<>();
        for (String[] ticket : tickets) {
            if (!graph.containsKey(ticket[0]))
                graph.put(ticket[0], new LinkedList<String>());
            graph.get(ticket[0]).add(ticket[1]);
            
        }
        for (LinkedList<String> edges : graph.values())
            Collections.sort(edges);
        
        //below is recursively bfs
        bfs(result, graph, "JFK");
        return result;
        
        // //below is iterative bfs using stack
        // Stack<String> stack = new Stack<>();
        // stack.push("JFK");
        // while (!stack.isEmpty()) {
        //     String next = stack.peek();
        //     if (graph.containsKey(next) && graph.get(next).size() > 0)
        //         stack.push(graph.get(next).removeFirst());
        //     else
        //         result.addFirst(stack.pop());
        // }
        // return result;
    }
    private void bfs(LinkedList<String> result, HashMap<String, LinkedList<String>> graph, String node) {
        while (graph.containsKey(node) && graph.get(node).size() > 0) {
            String next = graph.get(node).removeFirst();
            bfs(result, graph, next);
        }
        result.addFirst(node);
    }
}
