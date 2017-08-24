public class WordDistance {
    Map<String, List<Integer>> map;
    public WordDistance(String[] words) {
        map = new HashMap<>();
        for (int i = 0; i < words.length; i++)
            map.computeIfAbsent(words[i], k -> new ArrayList<>()).add(i);
    }
    
    public int shortest(String word1, String word2) {
        List<Integer> l1 = map.get(word1);
        List<Integer> l2 = map.get(word2);
        int i = 0, j = 0;
        int min = Integer.MAX_VALUE;
        while (i < l1.size() && j < l2.size()) {
            int i1 = l1.get(i);
            int i2 = l2.get(j);
            if (i1 < i2) {
                min = Math.min(min, i2 - i1);
                i++;
            } else {
                min = Math.min(min, i1 - i2);
                j++;
            }    
        }
        return min;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(words);
 * int param_1 = obj.shortest(word1,word2);
 */
