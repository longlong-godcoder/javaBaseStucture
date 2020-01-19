package dataStructure.tree;

import java.util.Comparator;

/**
 * Balanced Binary Search Tree
 */
public class BBST<E> extends BST<E>{

    public BBST() {
        this(null);
    }

    public BBST(Comparator<E> comparator) {
        super(comparator);
    }

    /**
     * 旋转，跳跃，我闭着眼...
     */
    protected void rotate(
            Node<E> r,
            Node<E> b, Node<E> c, Node<E> d, Node<E> e, Node<E> f){


    }
}
