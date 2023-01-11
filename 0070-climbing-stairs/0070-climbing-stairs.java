class Solution {
    public int climbStairs(int n) {
        int [] dp = new int[n+1];
        return fib(n, dp);
        
    }
    
    public int fib(int n, int [] dp)
    {
        if(n < 2) return 1;
        if(dp[n] != 0) return dp[n];
        dp[n] = fib(n-1,dp) + fib(n-2,dp);
        return dp[n];
        
    }
}