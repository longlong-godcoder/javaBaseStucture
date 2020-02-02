package dataStructure.unionSet;

/**
 * 并查集：QUICK FIND
 * 主要思想：元素存入parents数组，值为所属集合.
 * 时间复杂度，查找为O（1），合并为O（n）
 */
public class UnionFind_QF extends UnionFind{

    public UnionFind_QF(int capacity) {
        super(capacity);
    }

    /**
     *  查找value所在集合
     */
    @Override
    public int find(int value) {
        rangeCheck(value);
        return parents[value];
    }

    /**
     * 将value1的所有元素并入value2所在集合
     */
    @Override
    public void union(int value1, int value2) {
        int set1 = find(value1);
        int set2 = find(value2);
        if (set1 == set2) return;

        for (int i = 0; i < parents.length; i++){
            if (parents[i] == set1){
                parents[i] = set2;
            }
        }
    }
}
