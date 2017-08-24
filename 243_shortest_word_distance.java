public class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        if (words == null || words.length < 2)
            return 0;
        int i = -1;
        int j = -1;
        int res = Integer.MAX_VALUE;
        for (int k = 0; k < words.length; k++) {
            if (word1.equals(words[k]))
                i = k;
            else if (word2.equals(words[k]))
                j = k;
            if (i != -1 && j != -1)
                res = Math.min(res, Math.abs(i - j));
        }
        return res;
    }
}
