package algorithm.backTracking;

/**
 * N皇后问题优化方案
 * 之前的N皇后的isValid方法中，多次重复遍历之前所有行，效率低下
 * 采用3个boolean数组来分别存储同列，同斜线是否有皇后
 */
public class NQueens2 extends NQueens{
    /**
     * 用于判断同一列是否有皇后
     */
    private boolean[] cols;

    /**
     * 用于判断同一斜线是否有皇后，斜率为1的斜线数组，长度为2n - 1。
     * 所有斜线满足 row = col + k，k ∈ [1 - n, n - 1], 使用k表示数组长度，则row - col + n - 1 = k, k ∈ [0, 2n - 2]
     * 所以数组索引是 row - col + n - 1
     */
    private boolean[] k1;
    /**
     * 用于判断同一斜线是否有皇后，斜率为-1的斜线数组, 长度为2n - 1。同理
     * 所有斜率满足 row = -col + k，k ∈ [0, 2n - 2], 则数组索引是 row + col
     */
    private boolean[] k2;

    @Override
    public void placeQueen(int n){
        if (n < 1) return;
        cols = new boolean[n];
        k1 = new boolean[(n << 1) - 1];
        k2 = new boolean[k1.length];

        queens = new int[n];

        place(0);
        System.out.println("皇后一共有" + ways + "种摆法");
    }

    /**
     * 摆放第row行的皇后
     */
    private void place(int row){
        //表示前面n行已经摆完
        if(row == cols.length) {
            ways++;
            show();
            return;
        }
        //从第0列开始遍历
        for (int col = 0; col < cols.length; col++) {
            //如果同一列存在皇后，则继续循环
            if (cols[col]) continue;
            //如果同一斜线存在皇后，继续循环
            int k1Index = row - col + cols.length - 1;
            if (k1[k1Index]) continue;
            int k2Index = row + col;
            if (k2[k2Index]) continue;
            //否则设置皇后
            cols[col] = true;
            k1[k1Index] = true;
            k2[k2Index] = true;

            queens[row] = col;

            //进入下一行遍历
            place(row + 1);
            //回溯，说明此行此列的皇后不可放置，boolean数组要恢复默认值
            cols[col] = false;
            k1[k1Index] = false;
            k2[k2Index] = false;
        }
    }

    public static void main(String[] args) {
        new NQueens2().placeQueen(4);
    }

}
