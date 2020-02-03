package dataStructure.unionSet;

/**
 * 基于 QUICK UNION RANK 优化，路径分裂(Path Spliting)，
 */
public class UnionFind_QU_R_PS extends UnionFind_QU_R{

    public UnionFind_QU_R_PS(int capacity) {
        super(capacity);
    }

    /**
     *  说实话我一时间没想出来到底这相比路径压缩有什么优势。
     *  while循环次数和路径压缩递归调用次数相同，所以空间复杂度相当，
     *  同时优化效果还不如路径压缩，毕竟树高仅仅是减半。
     */
    @Override
    public int find(int value) {
        rangeCheck(value);

        while (value != parents[value]){
            int parent = parents[value];
            parents[value] = parents[parent];
            value = parent;
        }
        return value;
    }

}
