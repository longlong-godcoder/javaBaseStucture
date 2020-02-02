package algorithm.sort.shellSort;

import algorithm.sort.Sort;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 希尔排序
 * 主要思想：根据步长序列，进行分步分组排序。
 * 比如步长序列是{2，4，8}，就先将数组分成8组分别排序，以此类推
 * @param <T>
 */
public class ShellSort<T extends Comparable<T>> extends Sort<T> {

    @Override
    protected void sort() {
        //这里采用sedgewick步长序列，效率更高
        List<Integer> stepSequence = sedgewickStepSequence();
        for (Integer step :
                stepSequence) {
            sort(step);
        }
    }

    private void sort(int step){
        //根据step步长，分成多列进行单独排序
        for (int col = 0; col < step; col++) {
            //遍历同一列的每个元素, 这里局部采用插入排序
            for (int begin = col + step; begin < array.length; begin+=step) {
                int current = begin;
                while (current > col && cmp(current, current - step) < 0){
                    swap(current, current - step);
                    current -= step;
                }
            }
        }
    }
    //希尔本人的步长序列，时间复杂度最差是n2次方
    private List<Integer> shellStepSequence(){
        ArrayList<Integer> stepSequence = new ArrayList<>();
        int step = array.length;
        while ((step >>= 1) > 0){
            stepSequence.add(step);
        }
        return stepSequence;
    }
    //1986年 Robert sedgewick提出的步长序列，最坏时间复杂度n(4/3)次方
    private List<Integer> sedgewickStepSequence(){
        LinkedList<Integer> stepSequence = new LinkedList<>();
        int k = 0,step = 0;
        while (true){
            if (k % 2 == 0){
                //pow == 2的2分之k次方
                int pow = (int) Math.pow(2, k >> 1);
                //step == 9(2(k) - 2(2/k)) + 1
                step = 1 + 9 * (pow * pow - pow);
            }else {
                int pow1 = (int) Math.pow(2, k);
                int pow2 = (int) Math.pow(2, (k + 1) >> 1);
                step = 8 * pow1 - 6 * pow2 + 1;
            }

            if (step >= array.length) break;
            stepSequence.add(step);
            k++;
        }
        return stepSequence;
    }

}
