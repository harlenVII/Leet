public class Solution {
    public int myAtoi(String str) {
        if (str == null || str.length() == 0)
            return 0;
        str = str.trim();
        char first = str.charAt(0);
        int sign = 1;
        if (first == '-' || first == '+') {
            str = str.substring(1);
            if (first == '-')
                sign = -1;
        }
        int res = 0;
        for (char ch : str.toCharArray()) {
            if (ch > '9' || ch < '0')
                break;
            int digit = ch - '0';
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && Integer.MAX_VALUE % 10 < digit))
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            res = res * 10 + digit;
        }
        return res * sign;
    }
}
