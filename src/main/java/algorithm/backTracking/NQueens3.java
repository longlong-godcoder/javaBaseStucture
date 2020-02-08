package algorithm.backTracking;

/**
 * 使用位运算优化空间复杂度
 */
public class NQueens3 extends NQueens{
    /**
     * 这里根据n的值设置cols的数据类型, 那么因为byte仅8位，只能解决8皇后的问题了
     */
    private byte cols;
    /**
     * 对应斜线数量，如果是8皇后问题，则采用16位的short
     */
    private short k1;

    private short k2;

    private int n;

    @Override
    public void placeQueen(int n){
        this.n = n;

        queens = new int[n];

        place(0);
        System.out.println("皇后一共有" + ways + "种摆法");
    }

    /**
     * 摆放第row行的皇后
     */
    private void place(int row){
        //表示前面n行已经摆完
        if(row == n) {
            ways++;
            show();
            return;
        }
        //从第0列开始遍历
        for (int col = 0; col < n; col++) {
            //如果同一列存在皇后，则继续循环
            int cv = 1 << col;
            if ((cols & cv) != 0) continue;
            //如果同一斜线存在皇后，继续循环
            int k1Index = row - col + n - 1;
            int kv1 = 1 << k1Index;
            if ((k1 & kv1) != 0) continue;
            int k2Index = row + col;
            int kv2 = 1 << k2Index;
            if ((k2 & kv2) != 0) continue;
            //否则设置皇后

            cols |= cv;
            k1 |= kv1;
            k2 |= kv2;
            queens[row] = col;

            //进入下一行遍历
            place(row + 1);
            //回溯，说明此行此列的皇后不可放置，boolean数组要恢复默认值
            cols &= ~cv;
            k1 &= ~kv1;
            k2 &= ~kv2;
        }
    }

}
