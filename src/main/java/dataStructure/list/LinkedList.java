package dataStructure.list;


public class LinkedList<E> extends AbstractList<E>{

    private Node<E> first;
    private Node<E> last;

    @Override
    public void clear() {
        size = 0;
        first = null;
        last = null;
    }

    @Override
    public void add(int index, E element) {
        rangeCheckForAdd(index);

        if (index == size){
            Node<E> oldLast = last;
            last = new Node<>(element, oldLast, null);
            if (oldLast == null){
                first = last;
            }else {
                oldLast.next = last;
            }
        }else {
            Node<E> next = node(index);
            Node<E> prev = next.prev;
            Node<E> node = new Node<>(element, prev, next);
            next.prev = node;

            if (prev == null){
                first = node;
            }else {
                prev.next = node;
            }
        }

        size++;
    }

    @Override
    public E get(int index) {
        return node(index).element;
    }

    @Override
    public E set(int index, E element) {
        Node<E> node = node(index);
        E old = node.element;
        node.element = element;
        return old;
    }

    @Override
    public E remove(int index) {
        rangeCheck(index);

        Node<E> node = node(index);
        Node<E> prev = node.prev;
        Node<E> next = node.next;

        if (prev == null){
            first = next;
        }else {
            prev.next = next;
        }

        if (next == null){
            last = prev;
        }else {
            next.prev = prev;
        }

        size--;
        return node.element;
    }

    @Override
    public int indexOf(E element) {
        if (element == null){
            Node<E> node = first;
            for (int i = 0; i < size; i++){
                if (node.element == null) return i;
                node = node.next;
            }
        }else {
            Node<E> node = first;
            for (int i = 0; i < size; i++){
                if (element.equals(node.element)) return i;
                node = node.next;
            }
        }
        return ELEMENT_NOT_FOUND;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("size=")
                .append(size).append(", [");

        Node<E> node = first;
        for (int i = 0; i < size; i++){
            if (i != 0){
                stringBuilder.append(", ");
            }
            stringBuilder.append(node);
            node = node.next;
        }

        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    /**
     *  get node by index
     */
    private Node<E> node(int index){
        rangeCheck(index);

        if (index < (size >> 1)){
            Node<E> node = first;
            for (int i = 0; i < index; i++){
                node = node.next;
            }
            return node;
        }else {
            Node<E> node = last;
            for (int i = size - 1; i > index; i--){
                node = node.prev;
            }
            return node;
        }
    }

    private static class Node<E>{
        E element;
        private Node<E> prev;
        private Node<E> next;

        public Node(E element, Node<E> prev, Node<E> next) {
            this.element = element;
            this.prev = prev;
            this.next = next;
        }

        @Override
        public String toString() {

            StringBuilder stringBuilder = new StringBuilder();

            if (prev != null){
                stringBuilder.append(prev.element);
            }else {
                stringBuilder.append("null");
            }

            stringBuilder.append("_").append(element).append("_");

            if (next != null){
                stringBuilder.append(next.element);
            }else {
                stringBuilder.append("null");
            }
            return stringBuilder.toString();
        }
    }
}
