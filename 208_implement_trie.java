class TrieNode {
    char val;
    Map<Character, TrieNode> children;
    
    public TrieNode() {
        val = '\0';
        children = new HashMap<>();
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode temp = root;
        for (char ch : word.toCharArray()) {
            if (temp.children.containsKey(ch)) {
                temp = temp.children.get(ch);
                continue;
            } else {
                TrieNode newNode = new TrieNode();
                newNode.val = ch;
                temp.children.put(ch, newNode);
                temp = newNode;
            }
        }
        temp.children.put('$', null);
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode temp = root;
        for (char ch : word.toCharArray()) {
            if (temp.children.containsKey(ch)) {
                temp = temp.children.get(ch);
            } else {
                return false;
            }
        }
        if (temp.children.containsKey('$'))
            return true;
        else
            return false;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode temp = root;
        for (char ch : prefix.toCharArray()) {
            if (temp.children.containsKey(ch)) {
                temp = temp.children.get(ch);
            } else {
                return false;
            }
        }
        return true;
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");
