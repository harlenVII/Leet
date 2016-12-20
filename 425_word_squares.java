public class Solution {
    class TrieNode{
        char ch;
        Map<Character, TrieNode> children;
        TrieNode (char c) {
            ch = c;
            children = new HashMap<>();
        }
    }
    private TrieNode root = new TrieNode('\0');
    
    public List<List<String>> wordSquares(String[] words) {
        List<List<String>> res = new ArrayList<>();
        if (words == null || words.length == 0)
            return res;
        // initialize trie
        for (String word : words) {
            TrieNode temp = root;
            for (char c : word.toCharArray()) {
                if (!temp.children.containsKey(c)) {
                    TrieNode newNode = new TrieNode(c);
                    temp.children.put(c, newNode);
                    temp = newNode;
                } else {
                    temp = temp.children.get(c);
                }
            }
        }
        backtracking(res, words, new ArrayList<>());
        return res;
    }
    
    private void backtracking(List<List<String>> res, String[] word, List<String> cur) {
        if (cur.size() == word[0].length()) {
            res.add(new ArrayList<>(cur));
            return;
        }
        if (cur.size() == 0) {
            for (String s : word) {
                cur.add(s);
                backtracking(res, word, cur);
                cur.remove(cur.size() - 1);
            }
        } else {
            // find next prefix
            int len = cur.size();
            String prefix = "";
            for (String s : cur) {
                prefix += s.charAt(len);
            }
            
            // find node
            TrieNode temp = root;
            for (char ch : prefix.toCharArray()) {
                if (!temp.children.containsKey(ch)) {
                    return;
                }
                temp = temp.children.get(ch);
            }
            
            // get all string
            for (String s : traverse(prefix, temp)) {
                cur.add(s);
                backtracking(res, word, cur);
                cur.remove(cur.size() - 1);
            }
        }
    }
    
    private List<String> traverse(String prefix, TrieNode root) {
        List<String> res = new ArrayList<>();
        if (root.children.size() == 0) {
            res.add(prefix);
            return res;
        }
        for (TrieNode node : root.children.values()) {
            res.addAll(traverse(prefix + node.ch, node));
        }
        return res;
    }
}
