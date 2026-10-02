import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>(strs.length * 2);
        int[] count = new int[26];

        for (String s : strs) {
            Arrays.fill(count, 0);
            for (int i = 0, n = s.length(); i < n; i++) {
                count[s.charAt(i) - 'a']++;
            }

            // Compact key: only chars that appear, e.g. "a1b2z1"
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                if (count[i] != 0) {
                    sb.append((char) ('a' + i)).append(count[i]);
                }
            }

            map.computeIfAbsent(sb.toString(), k -> new ArrayList<>()).add(s);
        }
        return new ArrayList<>(map.values());
    }
}