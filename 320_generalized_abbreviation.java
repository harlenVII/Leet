public class Solution {
    public List<String> generateAbbreviations(String word) {
        List<String> res = new ArrayList<>();
        if (word == null)
            return res;
        backtracking(word, res, 0, 0, "");
        return res;
    }
    private void backtracking(String word, List<String> res, int index, int count, String cur) {
        if (index == word.length()) {
            if (count != 0)
                cur += String.valueOf(count);
            res.add(cur);
            return;
        }
        backtracking(word, res, index + 1, count + 1, cur);
        if (count != 0)
            cur += String.valueOf(count);
        cur += word.charAt(index);
        backtracking(word, res, index + 1, 0, cur);
    }
}
