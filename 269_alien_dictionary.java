class Solution {
    public String alienOrder(String[] words) {
        if (words == null || words.length == 0)
            return "";
        Set<Character> set = new HashSet<>();
        Map<Character, List<Character>> graph = new HashMap<>();
        
        for (int i = 0; i < words.length; i++) {
            for (char ch : words[i].toCharArray())
                set.add(ch);
            if (i == words.length - 1)
                continue;
            
            // get an edge from words[i] and words[i+1]
            // first find the character
            if (words[i + 1].startsWith(words[i]))
                continue;
            int j = 0, k = 0;
            while (words[i].charAt(j) == words[i+1].charAt(k)) {
                j++;
                k++;
            }
            
            // edge from j->k
            graph.computeIfAbsent(words[i].charAt(j), m -> new ArrayList<>()).add(words[i + 1].charAt(j));
        }
        int charNum = set.size();
        
        // topological sort, first indegree map
        Map<Character, Integer> indegree = new HashMap<>();
        for (Map.Entry<Character, List<Character>> entry : graph.entrySet()) {
            char from = entry.getKey();
            if (!indegree.containsKey(from))
                indegree.put(from, 0);
            for (char to : entry.getValue())
                indegree.put(to, indegree.getOrDefault(to, 0) + 1);
        }

        Queue<Character> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        
        // put char with indegree 0
        for (Map.Entry<Character, Integer> entry : indegree.entrySet()) {
            if (entry.getValue() == 0)
                queue.offer(entry.getKey());
        }
        set.removeAll(indegree.keySet());
        for (char ch : set)
            queue.offer(ch);
        
        // BFS
        while (!queue.isEmpty()) {
            char ch = queue.poll();
            sb.append(ch);
            if (!graph.containsKey(ch))
                continue;
            for (char to : graph.get(ch)) {
                indegree.put(to, indegree.get(to) - 1);
                if (indegree.get(to) == 0)
                    queue.offer(to);
            }
        }
        return sb.length() == charNum ? sb.toString() : "";
    }
}
