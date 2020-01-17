package algorithm.sort;

import java.text.DecimalFormat;

/**
 *
 * @param <T>
 */
public abstract class Sort<T extends Comparable<T>> implements Comparable<Sort<T>> {

    protected T[] array;
    private int cmpCount;
    private int swapCount;
    private long time;
    private DecimalFormat decimalFormat = new DecimalFormat("#.00");

    public void sort(T[] array){
        if (array == null || array.length < 2) return;

        this.array = array;

        long startTime = System.currentTimeMillis();
        sort();
        this.time = System.currentTimeMillis() - startTime;
    }

    protected abstract void sort();

    /**
     * 比较数组的元素
     */
    protected int cmp(int index1, int index2){
        cmpCount++;
        return array[index1].compareTo(array[index2]);
    }

    /**
     * 比较数组的元素
     */
    protected int cmp(T value1, T value2){
        cmpCount++;
        return value1.compareTo(value2);
    }

    /**
     *  交换数组元素
     */
    protected void swap(int index1, int index2){
        swapCount++;
        T tmp = array[index1];
        array[index1] = array[index2];
        array[index2] = tmp;
    }

    /**
     * 比较两种排序方法
     * @param o
     * @return
     */
    @Override
    public int compareTo(Sort<T> o) {
        int result = (int) (time - o.time);
        if (result != 0) return result;

        result = cmpCount - o.cmpCount;
        if (result != 0) return result;

        return swapCount = o.swapCount;
    }


}
