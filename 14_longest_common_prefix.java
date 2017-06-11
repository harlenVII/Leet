public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0)
            return new String();
        int min = Integer.MAX_VALUE;
        List<String> ss = Arrays.asList(strs);
        for (int i = 0; i < ss.size(); i++) {
            if (ss.get(i) == null) {
                ss.remove(i);
                i--;
                continue;
            }
            min = Math.min(min, ss.get(i).length());
        }
        if (min == 0 || ss.size() == 0)
            return "";
        int i = 0;
        for (; i < min; i++) {
            char c = ss.get(0).charAt(i);
            boolean same = true;
            for (String s : ss) {
                if (s.charAt(i) != c) {
                    same = false;
                    break;
                }
            }
            if (!same)
                break;
        }
        return ss.get(0).substring(0, i);
    }
}
