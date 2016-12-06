public class Solution {
    public int lengthLongestPath(String input) {
        if (input == null || input.length() == 0)
            return 0;
        int max = 0;
        int[] list = new int[input.lastIndexOf("\n") + 3];
        for (String s : input.split("\n")) {
            int level = s.lastIndexOf("\t") + 1;
            list[level + 1] = list[level] + s.length() - level + 1;
            if (s.contains(".")) {
                max = Math.max(max, list[level + 1] - 1);
            }
        }
        return max;
    }
}
