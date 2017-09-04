class AutocompleteSystem {
    class Node {
        String str;
        Map<String, Node> map;
        int time;
        Node (String str) {
            this.str = str;
            map = new HashMap<>();
            time = 0;
        }
    }
    Node root = new Node("");
    Node cur;
    String unfinished;
        
    public AutocompleteSystem(String[] sentences, int[] times) {
        for (int i = 0; i < sentences.length; i++) {
            saveSentence(sentences[i], times[i]);
        }
        cur = root;
        unfinished = "";
    }
    
    public List<String> input(char c) {
        List<String> res = new ArrayList<>();
        if (c == '#') {
            saveSentence(unfinished, 1);
            unfinished = "";
            cur = root;
            return res;
        }
        PriorityQueue<Node> heap = new PriorityQueue<Node>((a, b) -> (a.time == b.time ? a.str.compareTo(b.str) : b.time - a.time));
        unfinished += c;
        
        if (!cur.map.containsKey(unfinished))
            return res;
        cur = cur.map.get(unfinished);
        bfs(heap, cur);
        
        for (int i = 0; i < 3; i++) {
            if (!heap.isEmpty())
                res.add(heap.poll().str);
            else
                break;
        }
        return res;
    }
    
    private void saveSentence(String sentence, int time) {
        Node temp = root;
        String sub = "";
        for (char ch : sentence.toCharArray()) {
            sub += ch;
            if (temp.map.containsKey(sub))
                temp = temp.map.get(sub);
            else {
                Node newNode = new Node(sub);
                temp.map.put(sub, newNode);
                temp = newNode;
            }
        }
        temp.time += time;
    }
    
    private void bfs(PriorityQueue<Node> heap, Node node) {
        if (node.time > 0)
            heap.offer(node);
        for (Node n : node.map.values())
            bfs(heap, n);
    }
}

/**
 * Your AutocompleteSystem object will be instantiated and called as such:
 * AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
 * List<String> param_1 = obj.input(c);
 */
