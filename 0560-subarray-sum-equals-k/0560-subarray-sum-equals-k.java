import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int currentSum = 0;
        
        // Map to store (prefixSum -> frequency)
        Map<Integer, Integer> prefixSumMap = new HashMap<>();
        
        // Base case: a prefix sum of 0 has occurred once
        prefixSumMap.put(0, 1);
        
        for (int num : nums) {
            currentSum += num;
            
            // Check if (currentSum - k) exists in the map
            int diff = currentSum - k;
            if (prefixSumMap.containsKey(diff)) {
                count += prefixSumMap.get(diff);
            }
            
            // Add or update the frequency of currentSum in the map
            prefixSumMap.put(currentSum, prefixSumMap.getOrDefault(currentSum, 0) + 1);
        }
        
        return count;
    }
}