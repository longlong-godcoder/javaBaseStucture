package algorithm.sort.heapSort;

import algorithm.sort.Sort;

public class HeapSort<T extends Comparable<T>> extends Sort<T> {

    private int heapSize;

    @Override
    protected void sort() {

        heapSize = array.length;
        for (int i = heapSize >> 1; i >= 0; i--) {

        }
    }

    private void siftDown(int index){
        T element = array[index];

        int half = heapSize >> 1;
        while (index < half){

        }
    }
}
