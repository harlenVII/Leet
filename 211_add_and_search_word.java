public class WordDictionary {
    class Node {
        char ch;
        Map<Character, Node> childs;
        Node (char c) {
            ch = c;
            childs = new HashMap<>();
        }
    }
    class Trie {
        Node root = new Node('-');
        /** Initialize your data structure here. */
        public Trie() {
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            Node temp = root;
            for (char c : word.toCharArray()) {
                if (temp.childs.containsKey(c)) {
                    temp = temp.childs.get(c);
                } else {
                    Node newNode = new Node(c);
                    temp.childs.put(c, newNode);
                    temp = newNode;
                }
            }
            temp.childs.put('$', null);
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            Node temp = root;
            for (char c : word.toCharArray()) {
                if (!temp.childs.containsKey(c))
                    return false;
                temp = temp.childs.get(c);
            }
            return temp.childs.containsKey('$');
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            Node temp = root;
            for (char c : prefix.toCharArray()) {
                if (!temp.childs.containsKey(c))
                    return false;
                temp = temp.childs.get(c);
            }
            return true;
        }
    }
    Trie root;
    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new Trie();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        root.insert(word);
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        if (word == null)
            return true;
        return helper(root.root, word);
    }
    private boolean helper(Node node, String word) {
        if (word.isEmpty())
            return node.childs.containsKey('$');
        char first = word.charAt(0);
        if (first == '.') {
            String next = word.substring(1);
            for (Map.Entry<Character, Node> entry : node.childs.entrySet()) {
                if (entry.getKey() == '$')
                    continue;
                if (helper(entry.getValue(), next))
                    return true;
            }
        } else {
            if (node.childs.containsKey(first))
                return helper(node.childs.get(first), word.substring(1));
            else
                return false;
        }
        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
