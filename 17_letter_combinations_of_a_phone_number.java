public class Solution {
    static HashMap<Integer, String> map = new HashMap<>();
    static {
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");
        map.put(0, " ");
    }

    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        if (digits == null || digits.length() == 0)
            return list;    
        helper(list, digits, 0, "");
        return list;
    }
    private void helper(List<String> list, String s, int index, String cur) {
        if (index == s.length()) {
            list.add(cur);
            return;
        }
        String all = map.get(s.charAt(index) - '0');
        for (int i = 0; i < all.length(); i++) {
            helper(list, s, index + 1, cur + all.charAt(i));
        }
    }
}
