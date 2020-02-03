package dataStructure.unionSet;

import java.util.HashMap;
import java.util.Objects;

public class UnionFindWithObject<V> {

    private HashMap<V, Node<V>> nodes = new HashMap<>();

    /**
     * 添加集合方法
     */
    public void makeSet(V value){
        if (nodes.containsKey(value)) return;
        nodes.put(value, new Node<V>(value));
    }

    public V find(V value){
        Node<V> node = findNode(value);
        return node == null ? null : node.value;
    }

    /**
     *  合并两个集合的所有元素,采用rank优化
     */
    public void union(V value1, V value2){
        Node<V> set1 = findNode(value1);
        Node<V> set2 = findNode(value2);
        if (set1 == null || set2 == null) return;
        if (Objects.equals(set1.value, set2.value)) return;

        if (set1.rank < set2.rank){
            set1.parent = set2;
        }else if (set1.rank > set2.rank){
            set2.parent = set1;
        }else {
            set1.parent = set2;
            set2.rank += 1;
        }
    }

    public boolean isSame(V value1, V value2){
        return Objects.equals(find(value1), find(value2));
    }

    /**
     * 采用Path Halving
     */
    private Node<V> findNode(V value){
        Node<V> node = nodes.get(value);
        if (node == null) return null;

        while (!Objects.equals(node.value, node.parent.value)){
            node.parent = node.parent.parent;
            node = node.parent;
        }
        return node;
    }

    /**
     * value作为集合与元素的唯一标识，这和Integer的并查集没区别
     * Node类设计主要封装rank属性和parent属性
     * 其实使用连个HashMap也可以，一个存放parents，一个存放ranks
     * 总之，设计不唯一
     * @param <V>
     */
    private static class Node<V>{
        V value;
        Node<V> parent = this;
        int rank = 1;

        public Node(V value) {
            this.value = value;
        }
    }
}
