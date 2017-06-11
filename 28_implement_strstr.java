public class Solution {
    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null || needle.length() == 0)
            return 0;
        int m = haystack.length();
        int n = needle.length();
        for (int i = 0; i <= m - n; i++) {
            int k = i;
            int j = 0;
            while (j != n) {
                if (haystack.charAt(k) != needle.charAt(j))
                    break;
                k++;
                j++;
            }
            if (j == n)
                return i;
        }
        return -1;
    }
}
