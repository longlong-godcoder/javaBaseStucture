package dataStructure;


@SuppressWarnings("unchecked")
public class ArrayLIst<T> {
    /**
     * the size of ArrayList
     */
    private int size;
    /**
     * all the elements
     */
    private T[] elements;

    private static final int DEFAULT_CAPACITY = 10;

    private static final int ELEMENT_NOT_FOUND = -1;

    public ArrayLIst(int capacity) {
        capacity = capacity < DEFAULT_CAPACITY ? DEFAULT_CAPACITY : capacity;
        elements = (T[]) new Object[capacity];
    }

    public ArrayLIst(){
        this(DEFAULT_CAPACITY);
    }

    /**
     * remove all elements
     */
    public void clear(){
        for (int i = 0; i < size; i++){
            elements[i] = null;
        }
        size = 0;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public boolean contains(T element){
        return indexOf(element) != ELEMENT_NOT_FOUND;
    }

    public int indexOf(T element){
        if (element == null){
            for (int i = 0; i < size; i++){
                if (elements[i] == null) return i;
            }
        }else {
            for (int i = 0;i < size; i++){
                if (element.equals(elements[i])) return i;
            }
        }
        return ELEMENT_NOT_FOUND;
    }

    public T get(int index){
        rangeCheck(index);
        return elements[index];
    }

    public T set(int index, T element){
        rangeCheck(index);
        T old = elements[index];
        elements[index] = element;
        return old;
    }

    public void add(T element){
        add(size, element);
    }

    public void add(int index, T element){
        rangeCheckForAdd(index);

        ensureCapacity(size + 1);

        for (int i =size; i > index; i--){
            elements[i] = elements[i - 1];
        }
        elements[index] = element;
        size ++;
    }

    public T remove(int index){
        rangeCheck(index);

        T old = elements[index];
        for (int i = index + 1; i < size; i++){
            elements[i - 1] = elements[i];
        }
        elements[--size] = null;
        return old;
    }

    private void ensureCapacity(int capacity){
        int oldCapacity = elements.length;
        if (oldCapacity >= capacity) return;
        //expand capacity to 1.5x
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        T[] newElments = (T[]) new Object[newCapacity];
        for (int i = 0; i < size; i++){
            newElments[i] = elements[i];
        }
        elements = newElments;
    }

    private void rangeCheck(int index){
        if (index < 0 || index >= size){
            outOfBounds(index);
        }
    }

    private void rangeCheckForAdd(int index){
        if (index < 0 || index > size){
            outOfBounds(index);
        }
    }

    private void outOfBounds(int index){
        throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("size=").append(size).append(",[");
        for (int i = 0; i < size; i++){
            if (i != 0){
                stringBuilder.append(", ");
            }
            stringBuilder.append(elements[i]);
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
