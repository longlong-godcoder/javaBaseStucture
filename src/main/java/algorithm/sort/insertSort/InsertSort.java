package algorithm.sort.insertSort;

import algorithm.sort.Sort;

public class InsertSort<T extends Comparable<T>> extends Sort<T> {

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
