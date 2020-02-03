package dataStructure.unionSet;

/**
 * 并查集：QUICK UNION
 * 主要思想：parents列表首先记录集合标识元素，并且value值也为标识值。
 * 时间复杂度：查找要多级追溯到根节点，与树的高度成正比，合并也是调用find方法。
 */
public class UnionFind_QU extends UnionFind{

    public UnionFind_QU(int capacity) {
        super(capacity);
    }

    /**
     *  查找value所在集合
     */
    @Override
    public int find(int value) {
        rangeCheck(value);
        //根节点的parent节点就是根节点本身
        while (value != parents[value]){
            value = parents[value];
        }
        return value;
    }

    /**
     *  将value1的根节点嫁接到value2的根节点上。
     */
    @Override
    public void union(int value1, int value2) {
        int parent1 = find(value1);
        int parent2 = find(value2);
        if (parent1 == parent2) return;
        parents[parent1] = parent2;
    }
}
