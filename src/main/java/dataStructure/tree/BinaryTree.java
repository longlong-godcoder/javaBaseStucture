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

    /**
     *  层序遍历
     */
    public void levelOrder(Visitor<E> visitor){
        if (root == null || visitor == null) return;

        Queue<Node<E>> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            Node<E> node = queue.poll();
            if (visitor.visit(node.element)) return;

            if (node.left != null){
                queue.offer(node.left);
            }
            if (node.right != null){
                queue.offer(node.right);
            }
        }
    }

    /**
     *
     * @return
     */
    public boolean isComplete(){
        if (root == null) return false;
        Queue<Node<E>> queue = new LinkedList<>();
        queue.offer(root);

        boolean leaf = false;
        while (!queue.isEmpty()){
            Node<E> node = queue.poll();
            if (leaf && !node.isLeaf()) return false;

            if (node.left != null){
                queue.offer(node.left);
            }else if (node.right != null){
                return false;
            }

            if (node.right != null){
                queue.offer(node.right);
            }else {
                leaf = true;
            }
        }

        return true;
    }

    public int height2(){
        if (root == null) return 0;

        int height = 0;
        int levelSize = 1;

        Queue<Node<E>> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()){
            Node<E> node = queue.poll();
            levelSize --;

            if (node.left != null){
                queue.offer(node.left);
            }

            if (node.right != null){
                queue.offer(node.right);
            }

            if (levelSize == 0){
                levelSize = queue.size();
                height ++;
            }
        }

        return height;
    }

    public int height(){
        return height(root);
    }

    private int height(Node<E> node){
        if (root == null) return 0;
        return 1 + Math.max(height(node.left), height(node.right));
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
