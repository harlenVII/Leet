public class Solution {
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        if (beginWord == null || endWord == null || wordList == null || wordList.size() == 0)
            return 0;
        int len = 1;
        Set<String> set = new HashSet<>();
        Set<String> visited = new HashSet<>();
        set.add(beginWord);
        while (!set.isEmpty()) {
            len++;
            Set<String> temp = new HashSet<>();
            for (String word : set) {
                char[] seq = word.toCharArray();
                for (int i = 0; i < seq.length; i++) {
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        if (seq[i] == ch)
                            continue;
                        char old = seq[i];
                        seq[i] = ch;
                        String newWord = String.valueOf(seq);
                        if (wordList.contains(newWord) && !visited.contains(newWord)) {
                            if (newWord.equals(endWord))
                                return len;
                            temp.add(newWord);
                            visited.add(newWord);
                        }
                        seq[i] = old;
                    }
                }
            }
            set = temp;
        }
        return 0;
    }
}
