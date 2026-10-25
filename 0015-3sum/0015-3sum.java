import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        
        // Step 1: Sort the array
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length - 2; i++) {
            // Optimization: If the smallest number is greater than 0, 
            // the sum can never be 0 (since array is sorted)
            if (nums[i] > 0) {
                break;
            }
            
            // Skip duplicate elements for the first number to avoid duplicate triplets
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            
            // Step 2: Two pointers approach
            int left = i + 1;
            int right = nums.length - 1;
            
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    
                    // Skip duplicates for the second and third numbers
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++; // Sum is too small, move left pointer forward
                } else {
                    right--; // Sum is too large, move right pointer backward
                }
            }
        }
        
        return result;
    }
}