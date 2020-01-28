package algorithm.sort.bubbleSort;

import algorithm.sort.Sort;

/**
 * 主要思想：依次将局部最值元素冒泡到最尾端
 *
 * 冒泡排序的时间复杂度，最好是n，最坏是n2，所以有优化的余地，下面是没有优化的算法
 */
public class BubbleSort1<T extends Comparable<T>> extends Sort<T> {


    @Override
    protected void sort() {
        for (int end = array.length - 1; end > 0; end--) {
            for (int begin = 1; begin <= end; begin++) {
                if (cmp(begin, begin - 1) < 0){
                    swap(begin, begin - 1);
                }
            }
        }
    }
}
