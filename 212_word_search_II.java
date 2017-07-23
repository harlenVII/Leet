public class Solution {
    class Trie {
        class Node {
            char ch;
            Map<Character, Node> childs;
            Node (char c) {
                ch = c;
                childs = new HashMap<>();
            }
        }
        Node root;
        /** Initialize your data structure here. */
        public Trie() {
            root = new Node('-');
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
            temp.childs.put('.', null);
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            Node temp = root;
            for (char c : word.toCharArray()) {
                if (!temp.childs.containsKey(c))
                    return false;
                temp = temp.childs.get(c);
            }
            return temp.childs.containsKey('.');
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
    public List<String> findWords(char[][] board, String[] words) {
        Set<String> res = new HashSet<>();
        if (board == null || board.length == 0 || words == null || words.length == 0)
            return new ArrayList<>();
        Trie root = new Trie();
        for (String str : words)
            root.insert(str);
        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[0].length; j++)
                helper(board, root, i, j, "", res, new boolean[board.length][board[0].length]);
        return new ArrayList<>(res);
    }
    private void helper(char[][] board, Trie root, int x, int y, String cur, Set<String> res, boolean[][] visited) {
        cur += board[x][y];
        if (visited[x][y] || !root.startsWith(cur))
            return;
        if (root.search(cur)) {
            res.add(cur);
        }
        int[] dx = new int[]{1, -1, 0, 0};
        int[] dy = new int[]{0, 0, 1, -1};
        for (int i = 0; i < 4; i++) {
            int newx = x + dx[i];
            int newy = y + dy[i];
            if (newx < 0 || newx == board.length || newy < 0 || newy == board[0].length)
                continue;
            visited[x][y] = true;
            helper(board, root, newx, newy, cur, res, visited);
            visited[x][y] = false;
        }
    }
}
