package algorithm.greedy;

import java.util.Arrays;
import java.util.Comparator;

public class CoinChange {

    private Integer[] facecs = {25, 5, 10, 1};

    private int coins;

    /**
     * 贪心策略选硬币，显而易见，并非全局最优解，因为它没有尝试各种可能
     * 但它简单，高效，不需要穷举，常作为辅助算法使用
     * @param money
     */
    public void coin(int money){
        sort(facecs);
        //贪心算法，从最大面值开始遍历
        int i = 0;
        while (i < facecs.length){
            //如果money小于当前面值，进行下一循环
            if (money < facecs[i]){
                i++;
                continue;
            }

            System.out.println(facecs[i]);
            money -= facecs[i];
            coins++;
        }

        System.out.println("需要" + coins + "个硬币");
    }

    /**
     * 面值从大到小排序
     * @param facecs
     */
    private void sort(Integer[] facecs){
        Arrays.sort(facecs, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
    }

}
