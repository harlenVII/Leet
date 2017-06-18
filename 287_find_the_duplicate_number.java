public class Solution {
    public int findDuplicate(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int i = 1, j = nums.length - 1;
        while (i < j) {
            int mid = i + (j - i) / 2;
            System.out.println(mid);
            int count = 0;
            for (int num : nums)
                if (num <= mid)
                    count++;
            if (count > mid)
                j = mid;
            else
                i = mid+1;
        }
        return i;
    }
}
