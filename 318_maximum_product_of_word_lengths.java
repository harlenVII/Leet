public class Solution {
    public int maxProduct(String[] words) {
        if (words == null || words.length == 0)
            return 0;
        int[] bits = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            for (char ch : words[i].toCharArray()) {
                bits[i] |= 1 << (ch - 'a');
            }
        }
        
        int res = 0;
        
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if ((bits[i] & bits[j]) == 0) {
                    res = Math.max(res, words[i].length() * words[j].length());
                }
            }
        }
        return res;
    }
}
