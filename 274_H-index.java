class Solution {
    public int hIndex(int[] citations) {
        if (citations.length == 0)
            return 0;
        int[] buckets = new int[citations.length + 1];
        for (int num : citations)
            if (num >= citations.length)
                buckets[citations.length]++;
            else
                buckets[num]++;
        int count = 0;
        for (int i = citations.length; i>= 0; i--) {
            count += buckets[i];
            if (count >= i)
                return i;
        }
        return 0;
    }
}
