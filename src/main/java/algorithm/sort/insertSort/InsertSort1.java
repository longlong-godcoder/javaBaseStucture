package algorithm.sort.insertSort;

import algorithm.sort.Sort;

/**
 *  主要思想：与冒泡和选择排序不同，插入排序是保持局部有序，然后不断插入新的元素
 *
 *  插入排序的时间复杂度，最好是n，最坏是n2。
 */
public class InsertSort1<T extends Comparable<T>> extends Sort<T> {

    @Override
    protected void sort() {
        for (int begin = 1; begin < array.length; begin++) {
            int current = begin;
            while (current > 0 && cmp(current, current - 1) < 0){
                swap(current, current - 1);
                current--;
            }
        }
    }
}
