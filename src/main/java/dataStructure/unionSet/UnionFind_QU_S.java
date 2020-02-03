package dataStructure.unionSet;

/**
 * QUICK UNION 基于size优化
 * size表示以此根节点所有元素的数量
 */
public class UnionFind_QU_S extends UnionFind_QU{

    private int[] sizes;

    public UnionFind_QU_S(int capacity) {
        super(capacity);

        sizes = new int[capacity];
        //默认size为1
        for (int i = 0; i < sizes.length; i++) {
            sizes[i] = 1;
        }
    }

    /**
     *  将size小的树嫁接在size大的节点上
     */
    @Override
    public void union(int value1, int value2) {
        int set1 = find(value1);
        int set2 = find(value2);
        if (set1 == set2) return;

        if (sizes[set1] < sizes[set2]){
            parents[set1] = set2;
            sizes[set2] += sizes[set1];
        }else {
            parents[set2] = set1;
            sizes[set1] += sizes[set2];
        }
    }
}
