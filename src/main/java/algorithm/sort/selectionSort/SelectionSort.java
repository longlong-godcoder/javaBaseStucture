package algorithm.sort.selectionSort;

import algorithm.sort.Sort;

/**
 * 无论最好还是最坏，选择排序的原生时间复杂度停留在n2，可以以堆的方式处理选择最值的逻辑来提高效率达到nlogn
 */
public class SelectionSort<T extends Comparable<T>> extends Sort<T>{

    @Override
    protected void sort() {

        for (int end = array.length - 1; end > 0; end--) {
            int max = 0;
            for (int begin = 1; begin <= end; begin++) {
                if (cmp(max, begin) < 0){
                    max = begin;
                }
            }
            swap(max, end);
        }
    }
}
