class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        // Step 1: Replace numbers out of our range (<= 0 or > n) with n + 1
        // These numbers cannot affect the smallest missing positive integer from 1 to n.
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0 || nums[i] > n) {
                nums[i] = n + 1;
            }
        }

        // Step 2: Use the index as a hash key to mark presence
        // If we encounter a number 'val' between 1 and n, we make the element at index (val - 1) negative.
        for (int i = 0; i < n; i++) {
            int val = Math.abs(nums[i]);
            if (val >= 1 && val <= n) {
                int idx = val - 1;
                if (nums[idx] > 0) {
                    nums[idx] = -nums[idx];
                }
            }
        }

        // Step 3: Find the first index with a positive value
        // The index + 1 represents the missing positive integer.
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }

        // Step 4: If all numbers from 1 to n are present, the answer is n + 1
        return n + 1;
    }
}