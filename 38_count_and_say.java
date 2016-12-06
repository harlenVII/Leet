public class Solution {
    public String countAndSay(int n) {
        ArrayList<String> list = new ArrayList<>();
        list.add("1");
        while (list.size() < n) {
            StringBuilder next = new StringBuilder();
            String s = list.get(list.size() - 1);
            for (int i = 0; i < s.length();) {
                char c = s.charAt(i);
                int len = 0;
                while (i != s.length() && s.charAt(i) == c) {
                    i++;
                    len++;
                }
                next.append(len);
                next.append(c);
            }
            list.add(next.toString());
        }
        return list.get(n - 1);
    }
}
