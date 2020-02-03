package dataStructure.unionSet;

/**
 * 基于QUICK UNION RANK 优化的 路径减半（Path Halving）
 */
public class UnionFind_QU_R_PH extends UnionFind_QU_R{

    public UnionFind_QU_R_PH(int capacity) {
        super(capacity);
    }

    /**
     *  虽然没有大大降低树高，但这样减半了以后value找到根节点的路径，同时相比路径压缩，消耗也减半。
     */
    @Override
    public int find(int value) {
        rangeCheck(value);
        while (value != parents[value]){
            //使value的父节点指向祖父节点
            parents[value] = parents[parents[value]];
            value = parents[value];
        }
        return value;
    }
}
