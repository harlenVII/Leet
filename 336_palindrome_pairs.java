public class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>(); 
        if (words == null || words.length == 0)
            return res;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++)
            map.put(words[i], i);
        
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j <= words[i].length(); j++) {
                String s1 = words[i].substring(0, j);
                String s2 = words[i].substring(j);
                if (isPalindrome(s1)) {
                    String s2r = new StringBuilder(s2).reverse().toString();
                    if (map.containsKey(s2r) && map.get(s2r) != i) {
                        List<Integer> list = new ArrayList<>();
                        list.add(map.get(s2r));
                        list.add(i);
                        res.add(list);
                    }
                }
                if (isPalindrome(s2)) {
                    String s1r = new StringBuilder(s1).reverse().toString();
                    if (map.containsKey(s1r) && map.get(s1r) != i && s2.length() != 0) {// last condition to avoid duplication
                        List<Integer> list = new ArrayList<>();
                        list.add(i);
                        list.add(map.get(s1r));
                        res.add(list);
                    }
                }
            }
        }
        return res;
    }
    private boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;
        while (left <= right) {
            if (str.charAt(left++) !=  str.charAt(right--)) return false;
        }
        return true;
    }
}
