public class Solution {
    public String convertToTitle(int n) {
        if (n <= 0)
            return null;
        StringBuilder res = new StringBuilder();
        while (n != 0) {
            res.insert(0, (char)((--n) % 26 + 'A'));
            n /= 26;
        }
        return res.toString();
    }
}
