import java.util.Arrays;

/**
 * Created by Nick on 1/14/2018.
 */
public class ArrayListCustom<E> {

    private static final int CAPACITY = 5;
    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;
    private E[] array;
    private int size;

    @SuppressWarnings("unchecked")
    public ArrayListCustom() {
        array = (E[]) new Object[CAPACITY];
    }

    public int size(){
        return size;
    }

    public void add(int index, E value){
        validateElementIndex(index);//:index > initialCapacity --> exception; index < 0
        ensureCapacity(size + 1);

        System.arraycopy(array, index, array, index + 1, size - index);

        array[index] = value;
        size++;
    }


    private void validateElementIndex(int index)
    {
        if (index > size || index < 0)
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }

    private String outOfBoundsMsg(int index) {
        return "Index: "+index+", Size: "+size;
    }

    private void ensureCapacity(int minCapacity)
    {
        if (minCapacity - array.length > 0)
            grow(minCapacity);
    }

    private void grow(int minCapacity) {
        // overflow-conscious code
        int oldCapacity = array.length;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        if (newCapacity - minCapacity < 0)
            newCapacity = minCapacity;
        if (newCapacity - MAX_ARRAY_SIZE > 0)
            newCapacity = hugeCapacity(minCapacity);
        // minCapacity is usually close to size, so this is a win:
        array = Arrays.copyOf(array, newCapacity);
    }

    private static int hugeCapacity(int minCapacity) {
        if (minCapacity < 0) // overflow
            throw new OutOfMemoryError();
        return (minCapacity > MAX_ARRAY_SIZE) ?
                Integer.MAX_VALUE :
                MAX_ARRAY_SIZE;
    }

    public boolean add(E e) {
        ensureCapacity(size + 1);
        array[size++] = e;
        return true;
    }

}
