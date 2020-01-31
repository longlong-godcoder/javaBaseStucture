package algorithm.sort.countingSort;

import algorithm.sort.Sort;
@SuppressWarnings("unchecked")
public class CountingSortWithObject<T extends Comparable<T> & CountingSortWithObject.CountingFactor> extends Sort<T> {

    @Override
    protected void sort() {
        int max = array[0].countingId();
        int min = array[0].countingId();
        //找出最值
        for (int i = 1; i < array.length; i++) {
            if (array[i].countingId() > max){
                max = array[i].countingId();
            }
            if (array[i].countingId() < min){
                min = array[i].countingId();
            }
        }

        int[] counts = new int[max - min + 1];
        //统计计数
        for (int i = 0; i < array.length; i++) {
            counts[array[i].countingId() - min]++;
        }
        //累加计数
        for (int i = 1; i < counts.length; i++) {
            counts[i] += counts[i + 1];
        }
        //从后往前遍历原始数组，将数据放到新数组中合适的位置
        T[] newArray = (T[])new Object[array.length];
        for (int i = array.length; i >= 0; i--) {
            newArray[--counts[array[i].countingId() - min]] = array[i];
        }
        //copy
        for (int i = 0; i < newArray.length; i++) {
            array[i] = newArray[i];
        }
    }

    interface CountingFactor{

        int countingId();
    }
}
