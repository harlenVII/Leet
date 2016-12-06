public class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s == null || t == null || s.length() > t.length())
            return false;
        int index = 0;
        for (char cs : s.toCharArray()) {
            int i = t.indexOf(cs, index);
            if (i == -1)
                return false;
            else
                index = i + 1;
        }
        return true;
    }
}
