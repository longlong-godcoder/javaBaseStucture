package dataStructure;

import utils.printer.BinaryTreeInfo;

import java.util.Comparator;

public class BST<E> implements BinaryTreeInfo{

    private int size;
    private Node<E> root;
    private Comparator<E> comparator;

    public BST() {
    }

    public BST(Comparator<E> comparator) {
        this.comparator = comparator;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void clear(){

    }

    public void add(E element){
        elementNotNullCheck(element);

        if (root == null){
            root = new Node<E>(element, null);
            size ++;
            return;
        }

        Node<E> node = root;
        Node<E> parent = null;
        int cmp = 0;
        while (node != null){
            cmp = compare(element, node.element);
            parent = node;
            if (cmp > 0){
                node = node.right;
            }else if(cmp < 0){
                node = node.left;
            }else {
                return;
            }
        }
        Node<E> newNode = new Node<E>(element, parent);
        if (cmp > 0){
            parent.right = newNode;
        }else {
            parent.left = newNode;
        }

        size ++;
    }

    public void remove(){

    }

    public boolean contains(){
        return true;
    }

    private int compare(E e1, E e2){
        if (comparator != null){
            return comparator.compare(e1, e2);
        }
        return ((Comparable<E>)e1).compareTo(e2);
    }

    private void elementNotNullCheck(E element){
        if (element == null){
            throw new IllegalArgumentException("element must not be null");
        }
    }

    public Object root() {
        return root;
    }

    public Object left(Object node) {
        return ((Node<E>)node).left;
    }

    public Object right(Object node) {
        return ((Node<E>)node).right;
    }

    public Object string(Object node) {
        return ((Node<E>)node).element;
    }

    private static class Node<E>{
        E element;
        Node<E> left;
        Node<E> right;
        Node<E> parent;

        public Node(E element, Node<E> parent) {
            this.element = element;
            this.parent = parent;
        }
    }
}
