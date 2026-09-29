class Solution {
    public boolean isAnagram(String s, String t) {
        // Agar length alag hai, toh anagram nahi ho sakta
        if (s.length() != t.length()) {
            return false;
        }
        
        // 26 size ka frequency array (English alphabets ke liye)
        int[] count = new int[26];
        
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++; // s ke character ke liye count badhao
            count[t.charAt(i) - 'a']--; // t ke character ke liye count ghatao
        }
        
        // Check karo ki sabhi counts 0 hain ya nahi
        for (int c : count) {
            if (c != 0) {
                return false;
            }
        }
        
        return true;
    }
}