public class Solution {
    public int[] countBits(int num) {
        int[] nums = new int[num + 1];
        if (num == 0) {
            nums[0] = 0;
            return nums;
        }else if (num == 1) {
            nums[0] = 0;
            nums[1] = 1;
            return nums;
        }
        nums[0] = 0;
        nums[1] = 1;        
        for (int i = 2, pow = 2; i <= num; i++) {
            nums[i] = 1 + nums[i - pow];
            if (i == pow * 2 - 1)
                pow *= 2;
        }
        return nums;
    }
}
