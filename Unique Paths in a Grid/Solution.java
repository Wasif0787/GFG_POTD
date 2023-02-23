//User function Template for Java

class Solution {

    static int uniquePaths(int n, int m, int[][] grid) {

        // code here

        int mod = ((int)Math.pow(10,9))+7;

        if(grid[0][0] == 0) return 0;

        long[][] dp = new long[n][m];

        dp[0][0] = 1;

        for(int i=0;i<n;i++){

            for(int j=0;j<m;j++){

                if(i == 0 && j == 0 || grid[i][j] == 0 ) continue;

                if(i == 0) dp[i][j] = dp[i][j-1];

                else if(j == 0) dp[i][j] = dp[i-1][j];

                else dp[i][j] = (dp[i-1][j] + dp[i][j-1])%mod;

            }

        }

        return (int)(dp[n-1][m-1]);

    }

};
