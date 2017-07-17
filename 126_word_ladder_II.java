public class Solution {
    class Node{
        String val;
        Node parent;
        Node(String val, Node parent) {
            this.val = val;
            this.parent = parent;
        }
    }
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        if (beginWord == null || endWord == null || wordList == null || wordList.size() == 0)
            return res;
        Set<String> visited = new HashSet<>();
        Set<String> words = new HashSet<>(wordList);
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(beginWord, null));
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            // need to create a snapshot for visited because there may be different ways to read same works in a same distance
            Set<String> snapshot = new HashSet<>(visited);
            for (int i = 0; i < size; i++) {
                Node temp = queue.poll();
                char[] chars = temp.val.toCharArray();
                for (int j = 0; j < chars.length; j++) {
                    for (char k = 'a'; k <= 'z'; k++) {
                        if (chars[j] == k)
                            continue;
                        char origin = chars[j];
                        chars[j] = k;
                        String newstr = String.valueOf(chars);
                        if (words.contains(newstr) && !snapshot.contains(newstr)) {
                            visited.add(newstr);
                            Node node = new Node(newstr, temp);
                            queue.offer(node);
                            if (newstr.equals(endWord)) {
                                res.add(nodesToList(node));
                            }
                        }
                        chars[j] = origin;
                    }
                }
            }
            if (res.size() > 0)
                return res;
        }
        return res;
    }
    private List<String> nodesToList(Node node) {
        LinkedList<String> res = new LinkedList<>();
        while (node != null) {
            res.addFirst(node.val);
            node = node.parent;
        }
        return res;
    }
}
