public class Solution {
    public char findTheDifference(String s, String t) {
        if (s == null || t == null || s.length() + 1 != t.length())
            return ' ';
        char c = t.charAt(t.length() - 1);
        for (int i = 0; i < s.length(); i++) {
            c ^= s.charAt(i);
            c ^= t.charAt(i);
        }
        return c;
    }
}
