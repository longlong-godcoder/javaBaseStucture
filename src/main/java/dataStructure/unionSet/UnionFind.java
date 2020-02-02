package dataStructure.unionSet;

/**
 * 并查集的抽象父类，声明和定义共同方法
 */
public abstract class UnionFind {
    //集合标识数组
    protected int[] parents;

    public UnionFind(int capacity) {
        if (capacity < 0){
            throw new IllegalArgumentException("capacity must >= 1");
        }

        parents = new int[capacity];

        for (int i = 0; i < parents.length; i++) {
            parents[i] = i;
        }
    }

    /**
     *  查找value所属于的集合
     */
    public abstract int find(int value);

    /**
     * 合并value1和value2的集合
     */
    public abstract void union(int value1, int value2);

    /**
     *  判断value1和value2是否在一个集合
     */
    public boolean isSame(int value1, int value2){
        return find(value1) == find(value2);
    }

    protected void rangeCheck(int value){
        if (value < 0 || value >= parents.length){
            throw new IllegalArgumentException("value is out of bounds");
        }
    }
}
