/**
 * 给你一个 m x n 的矩阵 mat 和一个整数 k ，请你返回一个矩阵 answer ，其中每个 answer[i][j] 是所有满足下述条件的元素 mat[r][c] 的和：
 *
 * i - k <= r <= i + k,
 * j - k <= c <= j + k 且
 * (r, c) 在矩阵内。
 */
public class LeetCode08_1314 {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        //1、预处理二位前缀和矩阵
        int m = mat.length;
        int n = mat[0].length;
        int[][] dp = new int[m+1][n+1];
        for(int i = 1;i <= m;i++){
            for(int j = 1;j <= n;j++){
                dp[i][j] = dp[i-1][j] +dp[i][j-1] -dp[i-1][j-1] +mat[i-1][j-1];
            }
        }

        //2、使用
        int[][] ret = new int[m][n];
        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++){
                //先找到对角线的坐标位置
                int x1 = Math.max(0,i-k) + 1;
                int y1 = Math.max(0,j-k) + 1;
                int x2 = Math.min(i+k,m-1) + 1;
                int y2 = Math.min(n-1,j+k) + 1;
                ret[i][j] = dp[x2][y2]-dp[x1-1][y2]-dp[x2][y1-1]+dp[x1-1][y1-1];
            }
        }
        return ret;
    }
}
