public class Solution {
    private int binarySearch(ArrayList<Integer> list, int num){
        if (list == null || list.size() == 0)
            return 0;

        int start = 0, end = list.size() - 1;
        while(start + 1 < end){
            int middle = start + (end - start) / 2;
            if (list.get(middle) > num)
                end = middle;
            else if (list.get(middle) < num)
                start = middle;
            else
                return middle;
        }
        if (list.get(start) > num)
            return start;
        return end;
    }

    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }

        int len = 0;
        ArrayList<Integer> LIS = new ArrayList<>();// LIS[i] stores the smallest number of the subsequence whose length is i. Noted that LIS isn't the increasing sequence.
        len++;
        LIS.add(nums[0]);
        for (int i = 1; i < nums.length; i++){
            if (nums[i] > LIS.get(LIS.size() - 1)){
                LIS.add(nums[i]);
                len++;
            }else{
                int pos = binarySearch(LIS, nums[i]);//to find the minimum number larger than nums[i]
                LIS.set(pos, nums[i]);
            }
        }
        return len;
    }
}
