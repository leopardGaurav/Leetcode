class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            
            if (sum == target) {
                // Return 1-indexed positions
                return new int[] { left + 1, right + 1 };
            } else if (sum < target) {
                left++; // We need a larger sum, move left pointer forward
            } else {
                right--; // We need a smaller sum, move right pointer backward
            }
        }
        
        return new int[] {}; // Guaranteed to have a solution per constraints
    }
}