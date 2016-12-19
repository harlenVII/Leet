public class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s == null || s.length() == 0)
            return 0;
        int start = 0, end = 0;
        int len = 0;
        Map<Character, Integer> map = new HashMap<>();
        while (end < s.length()) {
            char ch = s.charAt(end);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            while (map.size() > k) {
                ch = s.charAt(start);
                map.put(ch, map.get(ch) - 1);
                if (map.get(ch) == 0)
                    map.remove(ch);
                start++;
            }
            len = Math.max(len, end - start + 1);
            end++;
        }
        return len;
    }
}
