public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() <= 10)
            return res;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i <= s.length() - 10; i++) {
            String sub = s.substring(i, i + 10);
            if (!map.containsKey(sub))
                map.put(sub, 1);
            else if (map.get(sub) == 1) {
                map.put(sub, 2);
                res.add(sub);
            }
        }
        return res;
    }
}
