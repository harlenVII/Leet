public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        if (s == null)
            return result;
        helper(result, s, 0, new ArrayList<String>());
        return result;
    }
    private void helper(List<List<String>> result, String s, int index, List<String> cur) {
        if (index == s.length()) {
            result.add(new ArrayList<String>(cur));
            return;
        }
        for (int i = index; i < s.length(); i++) {
            String sub = s.substring(index, i + 1);
            if (isPalindrome(sub)) {
                cur.add(sub);
                helper(result, s, i + 1, cur);
                cur.remove(cur.size() - 1);
            }
        }
    }
    private boolean isPalindrome(String s) {
        if (s == null)
            return false;
        int i = 0, j = s.length() - 1;
        while (i <= j) {
            if (s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}
