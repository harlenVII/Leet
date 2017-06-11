public class Solution {
    public String countAndSay(int n) {
        if (n <= 0)
            return null;
        String[] res = new String[n + 1];
        res[1] = "1";
        for (int i = 2; i <= n; i++) {
            String s = res[i - 1];
            StringBuilder next = new StringBuilder();
            int cur = 0;
            while (cur < s.length()) {
                char ch = s.charAt(cur);
                int start = cur;
                while(cur < s.length() && s.charAt(cur) == ch) {
                    cur++;
                }
                next.append(cur - start);
                next.append(ch);
            }
            res[i] = next.toString();
        }
        return res[n];
    }
}
