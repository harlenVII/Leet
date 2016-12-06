public class Solution {
    public String addBinary(String a, String b) {
        if (a == null || b == null)
            return null;
        int pa = a.length() - 1, pb = b.length() - 1;
        StringBuilder res = new StringBuilder();
        int carry = 0;
        while (pa >= 0 && pb >= 0) {
            int i = a.charAt(pa) - '0';
            int j = b.charAt(pb) - '0';
            int cur = i + j + carry;
            if (cur == 2) {
                cur = 0;
                carry = 1;
            } else if (cur == 3) {
                cur = 1;
                carry = 1;
            } else {
                carry = 0;
            }
            res.insert(0, cur);
            pa--;
            pb--;
        }
        while (pa >= 0) {
            int i = a.charAt(pa) - '0';
            int cur = i + carry;
            if (cur == 2) {
                cur = 0;
                carry = 1;
            } else {
                carry = 0;
            }
            res.insert(0, cur);
            pa--;
        }
        while (pb >= 0) {
            int j = b.charAt(pb) - '0';
            int cur = j + carry;
            if (cur == 2) {
                cur = 0;
                carry = 1;
            } else {
                carry = 0;
            }
            res.insert(0, cur);
            pb--;
        }
        if (carry == 1)
            res.insert(0, 1);
        return res.toString();
    }
}
