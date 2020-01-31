package algorithm.sort.radixSort;

import algorithm.sort.Sort;

/**
 * 基数排序（进制排序）
 * 主要思想：分别从低到高对进制的不同位数进行排序，子排序采用计数排序
 * @param <T>
 */
@SuppressWarnings("unchecked")
public class RadixSort<T extends Comparable<T> & RadixSort.CountingFactor> extends Sort<T> {
    //进制，默认为10
    private int radix = 10;

    public RadixSort(int radix) {
        this.radix = radix;
    }

    public RadixSort() {
    }

    @Override
    protected void sort() {

        int max = array[0].countingId();
        for (int i = 1; i < array.length; i++) {
            if (array[i].countingId() > max){
                max = array[i].countingId();
            }
        }

        for (int divider = 1; divider <= max ; divider*=radix) {
            countingSort(divider);
        }
    }

    private void countingSort(int divider){
        //开辟相应进制大小的内存空间
        int[] counts = new int[radix];
        //统计计数
        for (int i = 0; i < array.length; i++) {
            counts[array[i].countingId() / divider % radix]++;
        }
        //累加计数
        for (int i = 0; i < counts.length; i++) {
            counts[i] += counts[i - 1];
        }
        //从后往前遍历原始数组，放入新数组合适位置
        T[] newArray = (T[]) new Object[array.length];
        for (int i = array.length - 1; i >= 0; i--) {
            newArray[--counts[array[i].countingId() / divider % radix]] = array[i];
        }

        //copy
        for (int i = 0; i < newArray.length; i++) {
            array[i] = newArray[i];
        }

    }


    public static interface CountingFactor{
        int countingId();
    }

}
