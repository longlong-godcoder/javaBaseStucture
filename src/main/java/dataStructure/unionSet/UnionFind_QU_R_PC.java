package dataStructure.unionSet;

/**
 * 基于QUICK UNION RANK 优化后，加入路径压缩算法（Path Compression）
 */
public class UnionFind_QU_R_PC extends UnionFind_QU_R{

    public UnionFind_QU_R_PC(int capacity) {
        super(capacity);
    }

    /**
     * 查找时，使路径上的所有结点都指向根节点，压缩路径长度。
     * 显而易见，这样实现成本很高。
     */
    @Override
    public int find(int value) {
        rangeCheck(value);

        if (parents[value] != value){
            parents[value] = find(parents[value]);
        }
        return parents[value];
    }
}
