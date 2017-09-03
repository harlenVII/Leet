class Solution {
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, k);
    }
    private int quickSelect(int[] nums, int left, int right, int k) {
        if (left == right)
            return nums[left];
        int pivot = nums[right];
        int i = left, j = right - 1;
        while (i <= j) {
            if (nums[i] <= pivot) {
                i++;
            } else {
                swap(nums, i, j);
                j--;
            }
        }
        swap(nums, i, right);
        
        int rank = right - i + 1;
        if (rank == k)
            return nums[i];
        else if (rank < k)
            return quickSelect(nums, left, i - 1, k - rank);
        else
            return quickSelect(nums, i + 1, right, k);
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
