public class Solution {
    public boolean wordPattern(String pattern, String str) {
        if (pattern == null || str == null)
            return true;
        String[] strList = str.split(" ");
        if (pattern.length() != strList.length)
            return false;
        Map<Character, String> map = new HashMap<>();
        int i = 0;
        for (char p : pattern.toCharArray()) {
            if (map.containsKey(p)) {
                if (map.get(p).compareTo(strList[i]) != 0)
                    return false;
            } else if (map.containsValue(strList[i])) {
                return false;
            } else {
                map.put(p, strList[i]);
            }
            i++;
        }
        return true;
    }
}
