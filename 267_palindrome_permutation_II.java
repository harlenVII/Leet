public class Solution {
    public List<String> generatePalindromes(String s) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() == 0)
            return res;
        int[] map = new int[256];
        int odd = 0;
        for (char ch : s.toCharArray()) {
            map[ch]++;
            if (map[ch] % 2 == 1)
                odd++;
            else
                odd--;
        }
        if (odd > 1)
            return res;
        
        int length = 0;
        String mid = "";
        for (int i = 0; i < map.length; i++) {
            if (map[i] == 0)
                continue;
            if (map[i] % 2 == 1) {
                mid += (char)i;
                map[i]--;
            }
            map[i] /= 2;
            length += map[i];
        }
        helper(res, "", map, length, mid);
        return res;
    }
    private void helper(List<String> res, String cur, int[] map, int length, String mid) {
        if (cur.length() == length) {
            StringBuilder rev = new StringBuilder(cur);
            rev.reverse();
            res.add(cur + mid + rev.toString());
            return;
        }
        for (int i = 0; i < map.length; i++) {
            if (map[i] == 0)
                continue;
            map[i]--;
            helper(res, cur + (char)i, map, length, mid);
            map[i]++;
        }
        
    }
}
