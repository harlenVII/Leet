public class Solution {
    public String licenseKeyFormatting(String S, int K) {
        if (S == null || S.length() == 0)
            return S;
        String s = S.replaceAll("-", "");
        s = s.toUpperCase();
        StringBuilder sb = new StringBuilder(s);
        for (int i = sb.length() - K; i > 0; i -= K)
            sb.insert(i, '-');
        return sb.toString();
    }
}
