public class Solution {
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0)
            return 0;
        int len = citations.length;
        int res[] = new int[len + 1];
        for (int i :  citations) {
            if (i >= len)
                res[len]++;
            else
                res[i]++;
        }
        
        int total = 0;
        for (int i = len; i >= 0; i--) {
            total += res[i];
            if (total >= i)
                return i;
        }
        return 0;
    }
}
