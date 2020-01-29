package algorithm.sort.quickSort;

import algorithm.sort.Sort;

/**
 * 既然都叫快速排序了，那么在nlogn级别的排序中，自然是最优秀的。
 * 当然，貌似就好了那么一丢丢，而且这么折腾，稳定性也不能保证的。
 */
public class QuickSort<T extends Comparable<T>> extends Sort<T> {

    @Override
    protected void sort() {
        sort(0, array.length);
    }

    private void sort(int begin, int end){
        if (end - begin < 2) return;

        int mid = pivotIndex(begin, end);
        sort(begin, mid);
        sort(mid + 1, end);
    }

    private int pivotIndex(int begin, int end){
        //随机选择一个元素和begin交换位置，这样避免获取到的轴点不均匀
        swap(begin, begin + (int)(Math.random() * (end - begin)));

        T pivot = array[begin];
        //这里不要误解，只是我喜欢左闭右开的区间，但快速排序end必须指向一个确定的元素，所以做个end--处理；
        end--;

        //这里反复交替的作用是为了尽量保证左右两侧的元素数量均衡
        //同时，将等于划分到else也是这个目的，如果元素全部相等，也可以得到数量均匀的分割。
        while (begin < end){
            while (begin < end){
                if (cmp(pivot, array[end]) < 0){
                    end--;
                }else {
                    array[begin++] = array[end];
                    break;
                }
            }

            while (begin < end){
                if (cmp(pivot, array[begin]) > 0){
                    begin++;
                }else {
                    array[end--] = array[begin];
                    break;
                }
            }
        }
        //将轴点元素放入最终位置
        array[begin] = pivot;
        //最终结果是begin == end；
        return begin;
    }
}
