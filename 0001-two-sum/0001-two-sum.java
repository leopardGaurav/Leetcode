import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Map to store the number and its corresponding index: {number -> index}
        Map<Integer, Integer> seen = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            // Check if the complement already exists in our map
            if (seen.containsKey(complement)) {
                return new int[] { seen.get(complement), i };
            }

            // Otherwise, store the current number and its index
            seen.put(nums[i], i);
        }

        // Return an empty array if no solution is found (LeetCode guarantees one solution exists)
        return new int[0];
    }
}