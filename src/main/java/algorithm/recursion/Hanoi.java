package algorithm.recursion;

/**
 * 汉诺塔，需求不清楚的话自行百度吧，十分经典，不解释了
 */
public class Hanoi {
    /**
     * 过程分析：
     * 如果有n个碟子
     * 1.如果要将p1最底部的第n个盘子移动到p3，那么必须将上面n - 1个盘子移动到p2
     * 2.第二步就将第n个盘子移动到p3
     * 3.第三部将n - 1个盘子移动到p3
     * 那么其实如何挪动 n - 1个盘子，也是和一样从第 n - 1个盘子开始处理
     * @param p1 第一个盘子
     * @param p2 中间的盘子
     * @param p3 第三个盘子
     */
    public void hanoi(int n, String p1, String p2, String p3){
        if (n == 1){
            move(n, p1, p3);
            return;
        }
        //step1: (n - 1)*plates from p1 -> p2
        hanoi(n - 1, p1, p3, p2);
        //step2: n plate from p1 -> p3
        move(n, p1, p3);
        //step3: (n - 1)*plates from p2 -> p3
        hanoi(n - 1, p2, p1, p3);

    }

    /**
     * 移动一个盘子
     */
    private void move(int n, String from, String to){
        System.out.println("plate " + n + ", move from " + from + " to " + to);
    }

    /*
     * 那是否有优化的空间呢，不难发现，hanoi的每一步都是必要且不重复的，所以没有任何优化空间
     * 时间复杂度计算：
     * step1 T(n - 1), step2 O(1), step3 T(n - 1)
     * 所以：
     * T(n)
     * = 2 x T(n - 1) + O(1)
     * = 2^2 X T(n - 2) + 2 x O(1) + O(1)
     * = 2^3 X T(n - 3) + (2^2 + 2^1 + 2^0) X O(1)
     * = 2^(n - 1) X T(1) + (2^(n - 2) + ... + 2^2 + 2^1 + 2^0) X O(1)
     * = (2^(n - 1) + (2^(n - 2) + ... + 2^2 + 2^1 + 2^0) X O(1) = (2^n - 1) X O(1) = O(2^n)
     *
     * 空间复杂度：
     * 由于和递归调用深度有关，所以显然空间复杂度是O(n)
     */
}
