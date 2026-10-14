import java.util.HashSet;
import java.util.Set;

class Solution {
    public int longestConsecutive(int[] nums) {
        // Saare elements ko HashSet me daal lo taaki O(1) lookup mil sake
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }
        
        int maxLen = 0;
        
        for (int n : numSet) {
            // Check karo ki kya yeh sequence ka starting point hai (yani n-1 set me nahi hai)
            if (!numSet.contains(n - 1)) {
                int length = 1;
                
                // Aage ke consecutive numbers count karo
                while (numSet.contains(n + length)) {
                    length++;
                }
                
                // Maximum length ko update karo
                maxLen = Math.max(maxLen, length);
            }
        }
        
        return maxLen;
    }
}