public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if (s == null)
            return res;
        helper(res, new ArrayList<>(), s, 0);
        return res;
    }
    private void helper(List<String> res, List<String> cur, String s, int index) {
        if (index == s.length() && cur.size()  == 4) {
            res.add(String.join(".", cur));
            return;
        }
        if (cur.size() > 4)
            return;
        String temp = "";
        for (int i = index; i < s.length(); i++) {
            if (s.charAt(index) == '0' && i > index)
                break;
            temp += s.charAt(i);
            if (Integer.valueOf(temp) > 255)
                break;
            cur.add(temp);
            helper(res, cur, s, i + 1);
            cur.remove(cur.size() - 1);
        }
    }
}
