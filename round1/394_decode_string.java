public class Solution {
    public String decodeString(String s) {
        if (s == null)
            return null;
        Stack<String> ss = new Stack<>();
        Stack<Integer> si = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int i = 0;
        char[] cs = s.toCharArray();
        while (i < cs.length) {
            if (Character.isDigit(cs[i])) {
                int num = cs[i] - '0';
                i++;
                while (Character.isDigit(cs[i])) {
                    num = num * 10 + cs[i] - '0';
                    i++;
                }
                si.push(num);
            } else if (cs[i] == '[') {
                ss.push(sb.toString());
                sb = new StringBuilder();
                i++;
            } else if (cs[i] == ']') {
                int num = si.pop();
                String temp = sb.toString();
                for (int j = 0; j < num - 1; j++) {
                    sb.append(temp);
                }
                sb.insert(0, ss.pop());
                i++;
            } else {
                sb.append(cs[i]);
                i++;
            }
        }
        return sb.toString();
    }
}
