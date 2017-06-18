public class Solution {
    public int compareVersion(String version1, String version2) {
        if (version1 == null || version2 == null)
            return 0;
        List<Integer> l1 = parse(version1);
        List<Integer> l2 = parse(version2);
        int size = Math.min(l1.size(), l2.size());
        for (int i = 0; i < size; i++) {
            if (l1.get(i) < l2.get(i))
                return -1;
            else if (l1.get(i) > l2.get(i))
                return 1;
        }
        if (l1.size() > l2.size())
            return 1;
        if (l1.size() == l2.size())
            return 0;
        if (l1.size() < l2.size())
            return -1;
        return 0;
    }
    private List<Integer> parse(String version) {
        String[] vs = version.split("\\.");
        List<Integer> res = new ArrayList<>();
        for (String v: vs) {
            res.add(Integer.parseInt(v));
        }
        // remove trailing zeros
        for (int i = res.size() - 1; i >= 0; i--) {
            if (res.get(i) == 0)
                res.remove(i);
            else
                break;
        }
        return res;
    }
}
