public class Solution {
    public int lengthLongestPath(String input) {
        if (input == null || input.length() == 0)
            return 0;
        int res = 0;
        String[] strs = input.split("\n");
        List<Integer> list = new ArrayList<>();
        for (String str : strs) {
            int level = str.lastIndexOf("\t") + 1;
            int newVal = (level == 0 ? 0 : list.get(level - 1) + 1) + str.length() - level;
            if (list.size() > level) {
                list.set(level, newVal);
            } else {
                list.add(newVal);
            }
            if (str.contains(".")) {
                res = Math.max(res, newVal);
            }
        }
        return res;
    }
}
