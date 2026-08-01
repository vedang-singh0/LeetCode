class Solution {
    private int[][] grid;
    private Integer[][] t;
    private int n;

    public int minFallingPathSum(int[][] grid) {
        this.grid = grid;
        this.n = grid.length;
        this.t = new Integer[n][n];

        int ans = Integer.MAX_VALUE;

       
        for (int c = 0; c < n; c++) {
            ans = Math.min(ans, dfs(0, c,grid));
        }
        return ans;
    }

    public int dfs(int r, int c,int[][] grid) {
       
        if (r == n - 1) {
            return grid[r][c];
        }
        if (t[r][c] != null) {
            return t[r][c];
        }
        int ans = Integer.MAX_VALUE;
  
        for (int nextCol = 0; nextCol < n; nextCol++) {
            if (nextCol != c) 
            ans = Math.min(ans, dfs(r + 1, nextCol,grid));
        }
        t[r][c] = grid[r][c] + ans;
        return t[r][c];
    }
}