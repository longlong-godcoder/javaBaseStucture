package algorithm.sort.insertSort;

import algorithm.sort.Sort;

/**
 * 下面是对插入排序的一个小优化，将InsertSort1中的多次调用的swap交换函数，换成挪动，也就是提前备份value，避免多次交换。
 * 可能不知所云，但是看了下面的代码你就知道了，而且显而易见，这没多大用
 * @param <T>
 */
public class InsertSort2<T extends Comparable<T>> extends Sort<T> {

    @Override
    protected void sort() {
        for (int begin = 1; begin < array.length; begin++) {
            int current = begin;
            T value = array[current];
            while (current > 0 && cmp(begin, begin - 1) < 0){
                array[current] = array[current - 1];
                current --;
            }
            array[current] = value;
        }
    }
}
