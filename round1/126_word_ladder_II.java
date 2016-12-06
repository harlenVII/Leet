public class Solution {
    class Node{
        String value;
        Node parent;
        Node(String v, Node p) {
            value = v;
            parent = p;
        }
    }
    public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
        // check input
        Set<String> visited = new HashSet<>();
        Set<Node> set = new HashSet<>();
        set.add(new Node(beginWord, null));
        boolean find = false;
        Set<Node> result = new HashSet<>();
        List<List<String>> res = new ArrayList<>();
        while (!set.isEmpty()) {
            Set<Node> tempSet = new HashSet<>();
            // need to create a snapshot of visited, because there maybe are different ways to the same words in a same distance
            Set<String> visitedSnapshot = new HashSet<>(visited);
            for (Node node : set) {
                String word = node.value;
                char[] cs = word.toCharArray();
                for (int i = 0; i < cs.length; i++) {
                    char temp = cs[i];
                    for (char j = 'a'; j <= 'z'; j++) {
                        if (j == cs[i])
                            continue;
                        cs[i] = j;
                        String newWord = String.valueOf(cs);
                        // add to result list
                        if (newWord.equals(endWord)) {
                            find = true;
                            result.add(new Node(newWord, node));
                        }
                        if (wordList.contains(newWord) && !visitedSnapshot.contains(newWord)) {
                            tempSet.add(new Node(newWord, node));
                            visited.add(newWord);
                        }
                    }
                    cs[i] = temp;
                }
            }
            // complete this round
            if (find == true)
                break;
            set = tempSet;
        }
        for (Node n : result) {
            LinkedList<String> cur = new LinkedList<>();
            while (n != null) {
                cur.addFirst(n.value);
                n = n.parent;
            }
            res.add(cur);
        }
        return res;
    }
}
