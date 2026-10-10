class NumArray {
    private int[] prefixSums;

    public NumArray(int[] nums) {
        // prefixSums[i] stores the sum of elements from nums[0] to nums[i-1]
        prefixSums = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            prefixSums[i + 1] = prefixSums[i] + nums[i];
        }
    }
    
    public int sumRange(int left, int right) {
        // The sum from left to right is prefixSums[right + 1] - prefixSums[left]
        return prefixSums[right + 1] - prefixSums[left];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left, right);
 */