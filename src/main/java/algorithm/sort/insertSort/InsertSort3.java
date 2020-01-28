package algorithm.sort.insertSort;

import algorithm.sort.Sort;

/**
 *  插入排序的效率，主要损失在寻找合适插入位置上。
 *  所以可以使用二分查找法优化这部分逻辑，效果立竿见影，将时间复杂度控制到nlogn
 *  另外，二分查找的引入，会使插入排序变成不稳定排序
 */
public class InsertSort3<T extends Comparable<T>> extends Sort<T> {

    @Override
    protected void sort() {
        for (int begin = 1; begin < array.length; begin++) {
            insert(begin, search(begin));
        }
    }

    /**
     * 完成InsertSort2类似的插入挪动功能
     */
    private void insert(int source, int dest){
        T value = array[source];
        for (int i = source; i > dest; i--) {
            array[i] = array[i - 1];
        }
        array[dest] = value;
    }

    /**
     *  获取插入的索引位置
     *  局部有序数组的区间是[0，index)
     */
    private int search(int index){
        int begin = 0;
        int end = index;
        /**
         *  分查找的最终结果必然最后到区间begin + 1 == end
         *  那么必然：mid == begin，
         *  所以if 待插入元素 < mid，无妨将end = mid，虽然显然这对于循环的最后一部来说毫无价值。
         *  if 待插入元素 >= mid, 则将插入到mid + 1也就是begin + 1的位置。
         */

        while (begin < end){
            int mid = (begin + end) >> 2;
            if (cmp(array[index], array[mid]) < 0){
                end = mid;
            }else {
                begin = mid + 1;
            }
        }
        return begin;

    }
}
