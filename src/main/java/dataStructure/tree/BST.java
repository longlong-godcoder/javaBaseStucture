package dataStructure.tree;
/**
 * Binary Search Tree
 */

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

    public boolean contains(E element){
        return node(element) != null;
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
        do {
            cmp = compare(element, node.element);
            parent = node;
            if (cmp > 0){
                node = node.right;
            }else if(cmp < 0){
                node = node.left;
            }else {
                node.element = element;
                return;
            }
        }while (node != null);

        Node<E> newNode = createNode(element, parent);
        if (cmp > 0){
            parent.right = newNode;
        }else {
            parent.left = newNode;
        }
        size++;
        afterAdd(newNode);
    }

    public void remove(E element){
        remove(node(element));
    }

    private void remove(Node<E> node){
        if (node == null) return;

        size--;
        if (node.hasTwoChildren()){
            Node<E> successor = successor(node);
            node.element = successor.element;
            node = successor;
        }

        Node<E> replaceNode = node.left != null ? node.left : node.right;
        if (replaceNode != null){
            replaceNode.parent = node.parent;

            if (node.parent == null){
                root = replaceNode;
            }else if (node == node.parent.left){
                node.parent.left = replaceNode;
            }else {
                node.parent.right = replaceNode;
            }
            afterRemove(replaceNode);
        }else {
            //说明删除的叶子节点同时也是根节点
            if (node.parent == null){
                root = null;
                afterRemove(node);
            }else {
                if (node == node.parent.left){
                    node.parent.left = null;
                }else {
                    node.parent.right = null;
                }
                afterRemove(node);
            }
        }

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
