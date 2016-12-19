public class Solution {
    public int majorityElement(int[] nums) {
        // hash table is simple, we use moore voting algorithm
        int res = 0, count = 0;
        for (int num : nums) {
            if (count == 0)
                res = num;
            if (num == res)
                count++;
            else
                count--;
        }
        return res;
    }
}
