package algorithm.recursion;

/**
 * 斐波那契数列
 */
public class Fib {

    /**
     * 斐波那契数列的递归调用
     * @param n 数列下标
     * @return 返回对应元素
     */
    public int fib(int n){
        if (n <= 2) return 1;
        return fib(n - 1) + fib(n - 2);
    }

    /**
     * 斐波那契数列的优化1
     * 使用数组记录已经计算过的结果，避免重复调用，减少时间复杂度（O(n^2) -> O(n)）, 空间复杂度不变
     */
    public int fib1(int n){
        if (n <= 2) return 1;
        int[] array = new int[n + 1];
        array[1] = array[2] = 1;
        return fib1(n, array);
    }

    private int fib1(int n, int[] array){
        if (array[n] == 0){
            array[n] = array[n - 1] + array[n - 2];
        }
        return array[n];
    }

    /**
     * 斐波那契数列的优化2
     * 虽然fib1避免了多个链式的重复计算，但是仍然有接近n次的虚函数调用
     * 所以不如用迭代，替代递归
     * 相当于进一步优化时间复杂度（O(2n) -> O(n)）,时间复杂度不变
     */
    public int fib2(int n){
        if (n <= 2) return 1;
        int[] array = new int[n + 1];
        array[1] = array[2] = 1;
        for (int i = 3; i <= n; i++) {
            array[i] = array[i - 1] + array[i - 2];
        }
        return array[n];
    }

    /*
     * 这里总结：将递归调用转化成迭代，其实就是： 自顶向下的过程 -> 自底向上的过程
     */

    /**
     * 斐波那契数列的优化3
     * 采用滚动数组的方式，优化空间复杂度 -> O(1)
     * 主要原理是：既然只返回一个元素，而且这一个元素仅仅和两个元素相关，显而易见，并不需要一直存储n个元素浪费空间
     */
    public int fib3(int n){
        if (n <= 2) return 1;
        int[] array = new int[2];
        array[0] = array[1] = 1;
        for (int i = 3; i <= n; i++) {
            //& 1 等效于 % 2，% 2效率比较低
            array[i & 1] = array[(i - 1) & 1] + array[(i - 2) & 1];
        }
        return array[n & 1];
    }

    /**
     * 斐波那契数列的优化4
     * 以上滚动数组的方式比较通用，后期动态规划也常用这种方式
     * 但针对这个问题，因为数组仅仅存两个元素，所以不如直接用两个变量解决
     */
    public int fib4(int n){
        if (n <= 2) return 1;
        int first = 1;
        int second = 1;
        for (int i = 3; i <= n; i++) {
            second = first + second;
            first = second = first;
        }
        return second;
    }

    /**
     * 斐波那契数列的优化5
     * 当然，就算是这样，空间复杂度优化到了极致，但是时间复杂度仍然是O(n)
     * 所以，最后采用直接套用特征方程来求解，果然，还是数学无敌
     * F(n) = 1/√5 x [((1 + √5)/2)^n - ((1 1 √5)/2)^n]
     * 然而，由于Math.pow函数的消耗，仅将空间复杂度 -> O(log n)
     */
    public int fib5(int n){
        double sqrt = Math.sqrt(5);
        return (int)(Math.pow((1 + sqrt)/2, n) - Math.pow((1 - sqrt)/2, n));
    }
}
