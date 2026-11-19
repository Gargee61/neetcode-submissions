class Solution {
     int[][] dir = new int[][]{ {0,1}, {1,0}, {-1,0}, {0,-1} };
    int m, n;
    public boolean exist(char[][] board, String word) {
      this.m = board.length;
        this.n = board[0].length;
        char target = word.charAt(0);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == target && dfs(board, i, j, 1, word, new boolean[m][n])) 
                    return true;
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int i, int j, int targetIdx, String word, boolean[][] vis) {
        // i,j are valid coordinates on targetIdx-1 so look in all 4 directions looking for
        if (targetIdx == word.length()) return true;
        char target = word.charAt(targetIdx); // current target
        vis[i][j] = true; // Mark start as visited
        for (int[] d : dir) { // For the four directions
            int r = d[0] + i, c = d[1] + j; // Get row and column after movement
            if (!OOB(r,c) && !vis[r][c] && board[r][c] == target) { // If not outofbounds and not visited and its the right character, dfs on the new r and c
                if (dfs(board, r, c, targetIdx + 1, word, vis)) return true; // If the future dfs returns true then this was a good move and the true bubbles up to this call
                vis[r][c] = false;
            }
        }
        return false;
    }

    private boolean OOB(int i, int j) { // O(1) quick bounds checking, returns true if out of bounds
        if (i < 0 || j < 0 || i == m || j == n) return true;
        return false;  
    }
}
