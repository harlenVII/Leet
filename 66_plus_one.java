public class Solution {
    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0)
            return digits;
        int carry = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            int num = digits[i] + carry;
            if (num == 10) {
                digits[i] = 0;
                carry = 1;
            } else {
                digits[i] = num;
                carry = 0;
            }
        }
        if (carry == 1) {
            int[] res = new int[digits.length + 1];
            res[0] = 1;
            for (int i = 0; i < digits.length; i++)
                res[i + 1] = digits[i];
            return res;
        } else {
            return digits;
        }
    }
}
