public class Solution {
    public String decodeString(String s) {
        Stack<Integer> ints = new Stack<>();
        Stack<String> ss = new Stack<>();
        StringBuilder cur = new StringBuilder();
        char[] cs = s.toCharArray();
        int idx = 0;
        while (idx < cs.length) {
            if (Character.isDigit(cs[idx])) {
                int count = 0;
                while (Character.isDigit(cs[idx])) {
                    count = count * 10 + cs[idx] - '0';
                    idx++;
                }
                ints.push(count);
            } else if (cs[idx] == '[') {
                ss.push(cur.toString());
                cur = new StringBuilder();
                idx++;
            } else if (cs[idx] == ']') {
                int times = ints.pop();
                String temp = cur.toString();
                for (int i = 1; i < times; i++)
                    cur.append(temp);
                cur.insert(0, ss.pop());
                idx++;
            } else
                cur.append(cs[idx++]);
        }
        return cur.toString();
    }
}
