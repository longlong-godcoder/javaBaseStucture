package algorithm.sort.mergeSort;

import algorithm.sort.Sort;
@SuppressWarnings("unchecked")
public class MergeSort<T extends Comparable<T>> extends Sort<T> {

    private T[] leftArray;

    @Override
    protected void sort() {
        leftArray = (T[]) new Comparable[array.length >> 1];
        sort(0, array.length);
    }

    private void sort(int begin, int end){
        if (end - begin < 2) return;

        int mid = (begin + end) >> 1;
        sort(begin, mid);
        sort(mid, end);
        merge(begin, mid, end);
    }

    private void merge(int begin, int mid, int end){
        int leftIndex = 0, leftEnd = mid - begin;
        int rightIndex = mid, rightEnd = end;
        int arrayIndex = begin;

        for (int i = leftIndex; i < leftEnd; i++) {
            leftArray[i] = array[begin + i];
        }
        //如果左边数组提前遍历完，说明右边未遍历完的数组已经有序；
        while (leftIndex < leftEnd){
            //如果右边数组提前遍历完，那么接下来都走else的逻辑将剩余左边数组元素拷贝至array对应位置。
            if (rightIndex < rightEnd && cmp(array[rightIndex], leftArray[leftIndex]) < 0){
                array[arrayIndex++] = array[rightIndex++];
            }else {
                array[arrayIndex++] = leftArray[leftIndex ++];
            }
        }
    }
}
