public class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        if (list1 == null || list1.length == 0 || list2 == null || list2.length == 0)
            return new String[0];
        Map<String, Integer> map1 = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            map1.put(list1[i], i);
        }
        Map<String, Integer> map2 = new HashMap<>();
        int sum = Integer.MAX_VALUE;
        List<String> res = new ArrayList<>();
        for (int i = 0; i < list2.length; i++) {
            if (map1.containsKey(list2[i])) {
                int s = i + map1.get(list2[i]);
                if (s < sum) {
                    res.clear();
                    sum = s;
                    res.add(list2[i]);
                } else if (s == sum) {
                    res.add(list2[i]);
                }
            }
        }
        return res.toArray(new String[0]);
    }
}
