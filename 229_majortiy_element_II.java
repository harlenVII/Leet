c class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return result;
        int can1 = 0, count1 = 0;
        int can2 = 0, count2 = 0;
        for (int num : nums) {
            if (num == can1)
                count1++;
            else if (num == can2)
                count2++;
            else if (count1 == 0) {
                can1 = num;
                count1++;
            } else if (count2 == 0) {
                can2 = num;
                count2++;
            } else {
                count1--;
                count2--;
            }
        }
        count1 = count2 = 0;
        for (int num : nums) {
            if (num == can1)
                count1++;
            else if (num == can2)
                count2++;
        }
        if (count1 > nums.length / 3)
            result.add(can1);
        if (count2 > nums.length / 3)
            result.add(can2);
        return result;
    }
}
