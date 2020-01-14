package dataStructure.list;

public class SingleLinkedList<E> extends AbstractList<E> {

    private Node<E> first;

    @Override
    public void clear() {
        size = 0;
        first = null;
    }

    @Override
    public void add(int index, E element) {

    }

    @Override
    public E get(int index) {

    }

    @Override
    public E set(int index, E element) {
        return null;
    }

    @Override
    public E remove(int index) {
        rangeCheck(index);

        Node<E> node = first;
        if (index == 0){
            first = first.next;
        }else {
            Node<E> prev = node(index - 1);
            node = prev.next;
        }
    }

    @Override
    public int indexOf(E element) {
        return 0;
    }

    private Node<E> node(int index){
        rangeCheck(index);

        Node<E> node = first;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    private static class Node<E> {
        E element;
        Node<E> next;
        public Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }
    }
}
