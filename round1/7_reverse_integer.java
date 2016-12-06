public class Solution {
    public int reverse(int x) {
        StringBuilder sb = new StringBuilder();
        sb.append(x);
        Boolean flag = false;
        if (sb.charAt(0) == '-') {
            flag = true;
            sb.deleteCharAt(0);
        }
        sb.reverse();
        long num = Long.parseLong(sb.toString());
        if (flag)
            num = -num;
        if (num > Integer.MAX_VALUE || num < Integer.MIN_VALUE)
            return 0;
        return (int) num;
    }
}
