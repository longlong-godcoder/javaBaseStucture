package dataStructure.unionSet;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.Union;

/**
 * QUICK UNION的并查集，主要时间复杂度消耗在树形查找上；
 * 因此，基于思路主要基于树型查找优化，以下是基于树的高度rank优化。
 */
public class UnionFind_QU_R extends UnionFind_QU{

    private int[] ranks;

    public UnionFind_QU_R(int capacity) {
        super(capacity);

        ranks = new int[capacity];
        //默认树高为1
        for (int i = 0; i < ranks.length; i++) {
            ranks[i] = 1;
        }
    }

    /**
     *  通过优化union方法，优化树形结构
     *  将高度低的树并入高度高的树，如果高度相同，value1并入value2，同时ranks[parent2]++
     */
    @Override
    public void union(int value1, int value2) {
        int parent1 = find(value1);
        int parent2 = find(value2);
        if (parent1 == parent2) return;

        if (ranks[parent1] < ranks[parent2]){
            parents[parent1] = parent2;
        }else if (ranks[parent1] > ranks[parent2]){
            parents[parent2] = parent1;
        }else {
            parents[parent1] = parent2;
            ranks[parent2]++;
        }
    }
}
