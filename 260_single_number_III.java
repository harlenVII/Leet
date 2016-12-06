public class Solution {
    public int[] singleNumber(int[] nums) {
        int[] result = new int[2];
        if (nums == null || nums.length == 0)
            return result;
        int aXORb = 0;
        for (int num : nums) {
            aXORb ^= num; 
        }
        //find the least 1 in aXORb, which means this digit is different between a and b.
        //then divide the nums into two groups. a and b are in different group.
        int i = 0;
        while (((aXORb >> i) & 1) == 0)
            i++;
        int a = 0, b = 0;
        for (int num : nums) {
            if (((num >> i) & 1) == 0)
                a ^= num;
            else
                b ^= num;
        }
        result[0] = a;
        result[1] = b;
        return result;
    }
}
