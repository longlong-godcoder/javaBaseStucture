package dataStructure.tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree<E> {

    protected int size;
    protected Node<E> root;

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void clear(){
        root = null;
        size = 0;
    }

    /**
     * 先序遍历
     */
    public void preorder(Visitor<E> visitor){
        if (visitor == null) return;
        preorder(root, visitor);
    }

    private void preorder(Node<E> node, Visitor<E> visitor){
        if (node == null || visitor.stop) return;
        visitor.stop = visitor.visit(node.element);
        preorder(node.left, visitor);
        preorder(node.right, visitor);
    }

    /**
     * 中序遍历
     */
    public void inorder(Visitor<E> visitor){
        if (visitor == null) return;
        inorder(root, visitor);
    }

    private void inorder(Node<E> node, Visitor<E> visitor){
        if (node == null || visitor.stop) return;
        inorder(node.left, visitor);
        if (visitor.stop) return;
        visitor.stop = visitor.visit(node.element);
        inorder(node.right, visitor);
    }

    /**
     * 后序遍历
     */
    public void postorder(Visitor<E> visitor){
        if (visitor == null) return;
        preorder(root, visitor);
    }

    private void postorder(Node<E> node, Visitor<E> visitor){
        if (node == null || visitor.stop) return;

        preorder(node.left, visitor);
        postorder(node.right, visitor);
        if (visitor.stop) return;
        visitor.stop = visitor.visit(node.element);
    }

    public void levelOrder(Visitor<E> visitor){
        if (root == null || visitor == null) return;

        Queue<Node<E>> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            Node<E> node = queue.poll();

        }
    }

    public static abstract class Visitor<E> {
        boolean stop;

        abstract boolean visit(E element);
    }

    protected static class Node<E> {
        E element;
        Node<E> left;
        Node<E> right;
        Node<E> parent;



        public Node(E element, Node<E> parent) {
            this.element = element;
            this.parent = parent;
        }

        public boolean isLeaf(){
            return left == null && right == null;
        }

        public boolean hasTwoChildren(){
            return left != null && right != null;
        }

    }
}
