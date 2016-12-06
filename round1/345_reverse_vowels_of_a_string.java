public class Solution {
    public String reverseVowels(String s) {
        if (s == null)
            return null;
        StringBuilder sb = new StringBuilder(s);
        int left = 0, right = sb.length() - 1;
        while (left < right) {
            while (left != right && !isVowel(sb.charAt(left)))
                left++;
            while (right != left && !isVowel(sb.charAt(right)))
                right--;
            if (left != right) {
                char c = sb.charAt(left);
                sb.setCharAt(left, sb.charAt(right));
                sb.setCharAt(right, c);
                left++;
                right--;
            }
        }
        return sb.toString();
    }
    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }
}
