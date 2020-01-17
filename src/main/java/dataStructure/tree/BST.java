package dataStructure.tree;

import java.util.Comparator;
@SuppressWarnings("unchecked")
public class BST<E> extends BinaryTree<E>{

    private Comparator<E> comparator;

    public BST(){
        this(null);
    }

    public BST(Comparator<E> comparator) {
        this.comparator = comparator;
    }

    public void add(E element){
        elementNotNullCheck(element);

        if (root == null){
            root = createNode(element, null);
            size++;

            afterAdd(root);
            return;
        }

        Node<E> parent = root;
        Node<E> node = root;
        int cmp = 0;


    }

    private Node<E> node(E element){
        Node<E> node = root;
        while (node != null){
            int cmp = compare(element, node.element);
            if (cmp == 0) return node;
            if (cmp > 0){
                node = node.right;
            }else {
                node = node.left;
            }
        }
        return null;
    }

    protected void afterAdd(Node<E> node){
    }

    protected void afterRemove(Node<E> node){

    }

    private int compare(E e1, E e2){
        if (comparator != null){
            return comparator.compare(e1, e2);
        }
        return ((Comparable<E>)e1).compareTo(e2);
    }

    private void elementNotNullCheck(E element){
        if (element == null){
            throw  new IllegalArgumentException("element must not be null");
        }
    }
}
