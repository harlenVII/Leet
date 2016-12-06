public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null ||strs.length == 0)
            return new ArrayList<List<String>>();
        HashMap<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] s2 = s.toCharArray();
            Arrays.sort(s2);
            String s3 = String.valueOf(s2);
            map.computeIfAbsent(s3, k -> new ArrayList<String>()).add(s);
        }
        return new ArrayList<List<String>>(map.values());
    }
}
