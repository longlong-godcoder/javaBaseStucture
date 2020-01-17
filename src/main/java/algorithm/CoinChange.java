package algorithm;

/**
 * 找钱问题：输入金额，返回最少数量钱币
 */
public class CoinChange {

    public static void main(String[] args) {
        boolean[] booleans = new boolean[2];
        for (Boolean x : booleans){
            System.out.println(x);
        }
    }
    /**
     * 暴力递归
     */
    public static int coins1(int n){
        if (n < 1) return Integer.MAX_VALUE;
        if (n == 2 || n == 5 || n == 20 || n == 25) return 1;
        int min1 = Math.min(coins1(n - 25), coins1(n - 20));
        int min2 = Math.min(coins1(n - 5), coins1(n - 1));
        return Math.min(min1, min2) + 1;
    }

    /**
     * 记忆化搜索
     * @param n
     * @return
     */
    public static int coins2(int n){
        if (n < 1) return -1;
        int[] dp = new int[n + 1];
        int[] faces = {1, 5, 20, 25};
        for (int face : faces){
            if (n < face) break;
            dp[face] = 1;
        }
        return coins2(n, dp);
}

    public static int coins2(int n, int[] dp){
        if (n < 1) return Integer.MAX_VALUE;
        if (dp[n] == 0){
            int min1 = Math.min(coins2(n - 25), coins2(n - 20));
            int min2 = Math.min(coins2(n - 5), coins2(n - 1));
            dp[n] = Math.min(min1, min2) + 1;
        }
        return dp[n];
    }

    public static int coins3(int n){
        if (n < 1) return -1;
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++){
            int min = dp[i - 1];

        }
        return 0;
    }
}
