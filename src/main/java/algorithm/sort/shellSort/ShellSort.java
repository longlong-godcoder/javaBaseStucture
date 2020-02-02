package algorithm.sort.shellSort;

import algorithm.sort.Sort;
import dataStructure.list.LinkedList;
import dataStructure.list.List;

public class ShellSort<T extends Comparable<T>> extends Sort<T> {

    @Override
    protected void sort() {

    }

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
