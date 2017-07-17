public class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord == null || endWord == null || wordList == null || wordList.size() == 0)
            return 0;
        Set<String> words = new HashSet<>(wordList);
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer(beginWord);
        int res = 1;
        while (!queue.isEmpty()) {
            res++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                char[] chars = queue.poll().toCharArray();
                for (int j = 0; j < chars.length; j++) {
                    for (char k = 'a'; k <= 'z'; k++) {
                        if (chars[j] == k)
                            continue;
                        char origin = chars[j];
                        chars[j] = k;
                        String newstr = String.valueOf(chars);
                        if (words.contains(newstr) && !visited.contains(newstr)) {
                            if (newstr.equals(endWord))
                                return res;
                            visited.add(newstr);
                            queue.offer(newstr);
                        }
                        chars[j] = origin;
                    }
                }
            }
        }
        return 0;
    }
}
