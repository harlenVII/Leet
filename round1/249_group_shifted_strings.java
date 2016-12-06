public class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strings) {
            // back to a
            char[] cs = s.toCharArray();
            int diff = cs[0] - 'a';
            for (int i = 0; i < cs.length; i++) {
                cs[i] -= diff;
                if (cs[i] < 'a')
                    cs[i] += 26;
            }
            map.computeIfAbsent(String.valueOf(cs), k -> new ArrayList<String>()).add(s);
        }
        List<List<String>> res = new ArrayList<>();
        for (List<String> l : map.values()) {
            res.add(new ArrayList<>(l));
        }
        return res;
    }
}
