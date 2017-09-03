class Solution {
    public String multiply(String num1, String num2) {
        int m = num1.length();
        int n = num2.length();
        int[] nums = new int[m + n];
        for (int i = m - 1; i >= 0 ; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int digit = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int p1 = i + j;
                int p2 = i + j + 1;
                digit += nums[p2];
                nums[p1] += digit / 10;
                nums[p2] = digit % 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i : nums) {
            if (sb.length() == 0 && i == 0)
                continue;
            sb.append(i);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
