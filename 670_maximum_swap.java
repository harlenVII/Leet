class Solution {
    public int maximumSwap(int num) {
        char[] digits = String.valueOf(num).toCharArray();
        int[] pos = new int[10];
        for (int i = 0; i < digits.length; i++)
            pos[digits[i] - '0'] = i;
        for (int i = 0; i < digits.length; i++) {
            for (int j = 9; j > digits[i] - '0'; j--) {
                if (pos[j] > i) {
                    char tmp = digits[pos[j]];
                    digits[pos[j]] = digits[i];
                    digits[i] = tmp;
                    return Integer.parseInt(String.valueOf(digits));
                }
            }
        }
        return num;
    }
}
