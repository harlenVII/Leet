public class Solution {
    public String addBinary(String a, String b) {
        if (a == null || b == null)
            return null;
        if (a.isEmpty())
            return b;
        if (b.isEmpty())
            return a;
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        StringBuilder res = new StringBuilder();
        while (i >= 0 || j >= 0 || carry == 1) {
            int ai = i == -1 ? 0 : a.charAt(i--) - '0';
            int bj = j == -1 ? 0 : b.charAt(j--) - '0';
            int sum = ai + bj + carry;
            if (sum >= 2) {
                sum -= 2;
                carry = 1;
            } else {
                carry = 0;
            }
            res.insert(0, sum);
        }
        return res.toString();
    }
}
