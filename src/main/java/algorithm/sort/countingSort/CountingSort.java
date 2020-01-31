package algorithm.sort.countingSort;

import algorithm.sort.Sort;

public class CountingSort extends Sort<Integer> {

    @Override
    protected void sort() {
        int max = array[0];
        int min = array[0];
        //找出数组两个最值，得出counting数组长度
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max){
                max = array[i];
            }
            if (array[i] < min){
                min = array[i];
            }
        }
        //初始化counting数组，默认值为0
        int[] counts = new int[max - min + 1];
        //统计元素出现次数
        for (int i = 0; i < array.length; i++) {
            counts[array[i] - min]++;
        }
        //为了保证排序稳定性，采取生成累加数组的优化方案
        //这里使得每个下标下面都存储了之前有多少个元素
        for (int i = 1; i < counts.length; i++) {
            counts[i] += counts[i - 1];
        }

        //下面从后往前遍历原始数组，将元素放入数组中合适的位置
        int[] newArray = new int[array.length];
        for (int i = array.length - 1; i >= 0; i--) {
            newArray[--counts[array[i] - min]] = array[i];
        }
        //copy back
        for (int i = 0; i < newArray.length; i++) {
            array[i] = newArray[i];
        }

    }


}
