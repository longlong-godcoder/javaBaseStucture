package dataStructure.list;

public abstract class AbstractList<E> implements List<E> {

    protected int size;

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(E element) {
        return indexOf(element) != ELEMENT_NOT_FOUND;
    }

    @Override
    public void add(E element) {
        add(size, element);
    }

    protected void outOfBound(int index){
        throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
    }

    protected void rangeCheck(int index){
        if (index < 0 || index >= size){
            outOfBound(index);
        }
    }

    protected void rangeCheckForAdd(int index){
        if (index < 0 || index > size){
            outOfBound(index);
        }
    }
}
