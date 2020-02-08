package algorithm.recursion;

/**
 * 走楼梯，有n阶楼梯，每次能走1阶或者2阶，有多少种走法
 */
public class ClimbStairs {
    /**
     * 递归调用走楼梯：
     * 和斐波那契数列相似，f（n）= f(n - 1) + f(n - 2)
     */
    public int climbStairs(int n){
        if (n <= 2) return n;
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    /**
     * 走楼梯优化
     * 既然和fib如此相似，后面元素的结果取决于前面两个元素的结果
     * 可以一步到位优化到如下结果，非常简单
     */
    public int climbStairs1(int n){
        if (n <= 2) return n;
        int first = 1;
        int second = 2;
        for (int i = 3; i <= n; i++) {
            second = first + second;
            first = second - first;
        }
        return second;
    }
}
