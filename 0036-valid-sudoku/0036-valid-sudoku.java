class Solution {
    public boolean isValidSudoku(char[][] board) {
        // Hash sets or boolean arrays to track seen numbers (0 to 8 representing '1' to '9')
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] boxes = new boolean[9][9];
        
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                char current = board[r][c];
                
                // Skip empty cells
                if (current == '.') {
                    continue;
                }
                
                int num = current - '1'; // Convert char '1'-'9' to index 0-8
                int boxIndex = (r / 3) * 3 + (c / 3); // Map 2D coordinates to 3x3 box index (0-8)
                
                // Check if the number already exists in the same row, column, or 3x3 box
                if (rows[r][num] || cols[c][num] || boxes[boxIndex][num]) {
                    return false;
                }
                
                // Mark the number as seen
                rows[r][num] = true;
                cols[c][num] = true;
                boxes[boxIndex][num] = true;
            }
        }
        
        return true;
    }
}