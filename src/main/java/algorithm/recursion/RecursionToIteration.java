package algorithm.recursion;

/**
 *  以递归的思路去分解与实现问题是相对比较容易的，但由于可能会导致性能问题，我们往往需要对时间复杂度和空间复杂度进行优化。
 *  那结果最好的办法是尽可能的转化为迭代的方式解决问题。
 *  但是，有一点，不是所有的递归都是效率底的，有可能存在递归已经是最优解的情况，比如hanoi的例子
 */
public class RecursionToIteration {
    /*
    ================================
    Tail Call 尾调用优化
    ================================
     */

    /**
     * 阶乘的计算
     */
    public int factorial(int n){
        if (n <= 1) return 1;
        return n * factorial(n - 1);
    }

    /**
     * 使用Tail Call 尾调用的方式优化递归的空间复杂度，这样部分编译器可以复用栈空间
     * 但是，但是，jvm貌似没这功能
     * @param n
     * @return
     */
    public int factorialTailCall(int n){
        return factorialTailCall(n, 1);
    }

    private int factorialTailCall(int n, int result){
        if (n <= 1) return 1;
        return factorialTailCall(n - 1, result * n);
    }

    /**
     * 斐波拉契数列同样可以使用尾调用优化
     * 窍门就是将计算封装到参数传入
     */
    public int fib(int n){
        return fib(n, 1, 1);
    }

    private int fib(int n, int first, int second){
        if (n <= 1) return 1;
        return fib(n - 1, second, first + second);
    }

    /*
    仔细观察上面两个尾递归的代码，发现不就是迭代么？
    那我是不是可以认为，可以转化为尾调用的逻辑，同样可以转化为迭代实现？
    所以不是jvm没做这个优化功能，是实在是没什么用。
     */


}
