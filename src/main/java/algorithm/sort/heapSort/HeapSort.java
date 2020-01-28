package algorithm.sort.heapSort;

import algorithm.sort.Sort;

public class HeapSort<T extends Comparable<T>> extends Sort<T> {

    private int heapSize;

    @Override
    protected void sort() {

        heapSize = array.length;
        //自下而上，下滤
        for (int i = (heapSize >> 1)- 1; i >= 0; i--) {
            siftDown(i);
        }
        //完成堆排序
        while (heapSize > 1){
            swap(0, --heapSize);
            siftDown(0);
        }
    }

    /**
     * 下滤：恢复堆的性质
     */
    private void siftDown(int index){
        //提前获取index元素
        T element = array[index];

        int half = heapSize >> 1;
        //index < half表示index为非叶子节点
        while (index < half){
            //提取左子节点，因为非叶子节点一定存在左子节点
            int childIndex = (index << 1) + 1;
            T child = array[childIndex];
            //获取右子节点
            int rightIndex = childIndex + 1;
            //rightIndex < heapSize 说明存在右子节点
            if (rightIndex < heapSize && cmp(array[rightIndex], child) > 0){
                child = array[childIndex = rightIndex];
            }
            //大于等于子节点，表示不需要再下沉
            if (cmp(element, child) >= 0) break;
            //child覆盖至index位置
            array[index] = child;
            //调整index
            index = childIndex;
        }
        array[index] = element;
    }
}
