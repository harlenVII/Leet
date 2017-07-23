public class Solution {
    public boolean wordPatternMatch(String pattern, String str) {
        if (pattern == null || str == null)
            return true;
        return helper(pattern, str, 0, 0, new HashMap<>());
    }
    private boolean helper(String pattern, String str, int pp, int ps, Map<Character, String> map) {
        if (ps == str.length()) {
            if (pp == pattern.length())
                return true;
            else
                return false;
        }
        if (pp == pattern.length())
            return false;
        
        char ch = pattern.charAt(pp);
        if (map.containsKey(ch)) {
            String temp = map.get(ch);
            if (str.length() < ps + temp.length())
                return false;
            String sub = str.substring(ps, ps + temp.length());
            if (temp.equals(sub))
                return helper(pattern, str, pp + 1, ps + temp.length(), map);
            else
                return false;
        }
        for (int i = ps; i < str.length(); i++) {
            String sub = str.substring(ps, i + 1);
            if (map.containsValue(sub))
                continue;
            map.put(ch, sub);
            if (helper(pattern, str, pp + 1, i + 1, map))
                return true;
            map.remove(ch);
        }
        return false;
    }
}
