public class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() == 0 || t.length() == 0)
            return "";
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : t.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        int i = 0, j = 0;
        int left = 0, len = Integer.MAX_VALUE;
        int size = map.size();
        while (j < s.length()) {
            char ch = s.charAt(j);
            if (map.containsKey(ch)) {
                int num = map.get(ch);
                map.put(ch, num - 1);
                if (num - 1 == 0)
                    size--;
            }
            j++;
            while (size == 0) {
                if (j - i < len) {
                    left = i;
                    len = j - i;
                }
                char c = s.charAt(i);
                if (map.containsKey(c)) {
                    int num = map.get(c);
                    map.put(c, num + 1);
                    if (num == 0)
                        size++;
                }
                i++;
            }
        }
        return len == Integer.MAX_VALUE ?  "" : s.substring(left, left + len);
    }
}
