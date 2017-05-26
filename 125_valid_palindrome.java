public class Solution {
    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0)
            return true;
        char[] cs = s.toLowerCase().toCharArray();
        int i = 0, j = cs.length - 1;
        while (i < j) {
            while (i < j && !Character.isLetterOrDigit(cs[i]))
                i++;
            while (i < j && !Character.isLetterOrDigit(cs[j]))
                j--;
            if (i >= j)
                return true;
            
            if (cs[i] != cs[j])
                return false;
            i++;
            j--;
        }
        return true;
    }
}
