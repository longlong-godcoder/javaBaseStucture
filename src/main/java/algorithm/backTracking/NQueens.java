package algorithm.backTracking;

/**
 * 经典的国际象棋N皇后问题
 * 任意两个皇后都不能处于同一行，同一列或同一斜线上，有多少种摆法
 */
public class NQueens {
    /**
     * 索引为行号，元素为列号
     */
    protected int[] queens;
    /**
     * 一共有多少种摆法
     */
    protected int ways;

    public void placeQueen(int n){
        if (n < 1) return;
        queens = new int[n];
        place(0);
        System.out.println("皇后一共有" + ways + "种摆法");
    }

    /**
     * 摆放第row行的皇后
     */
    private void place(int row){
        //表示前面n行已经摆完
        if(row == queens.length) {
            ways++;
            show();
            return;
        }
        //从第0列开始遍历
        for (int col = 0; col < queens.length; col++) {
            if (isValid(row, col)){
                queens[row] = col;
                place(row + 1);
            }
        }
    }

    /**
     * 减枝处理，判断是否符合规则
     * 这里是完成回溯的关键
     */
    private boolean isValid(int row, int col){
        //遍历前面的每一行
        for (int i = 0; i < row; i++) {
            //同一列上有皇后不能摆放
            if (queens[i] == col) return false;
            //斜率为 1 或 -1 则是在同一斜线上
            if (row - i == Math.abs(col - queens[i])) return false;
        }
        return true;
    }

    /**
     * 打印一种摆法
     */
    protected void show(){
        for (int row = 0; row < queens.length; row++) {
            for (int col = 0; col < queens.length; col++) {
                if (queens[row] == col){
                    System.out.print(1 + " ");
                }else {
                    System.out.print(0 + " ");
                }
            }
            System.out.println();
        }
        System.out.println("-------------------------");
    }

}
