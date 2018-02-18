import java.util.Arrays;

/**
 * Created by Nick on 1/14/2018.
 */
public class ArrayListCustom<E> implements ListCustom {

    private static final int CAPACITY = 5;
    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;
    private E[] array;
    private int size;

    @SuppressWarnings("unchecked")
    public ArrayListCustom() {
        array = (E[]) new Object[CAPACITY];
    }

    public int size() {
        return size;
    }

    public void add(int index, Object value) {
        validateElementIndexForAdd(index);//:index > initialCapacity --> exception; index < 0
        ensureCapacity(size + 1);

        System.arraycopy(array, index, array, index + 1, size - index);

        array[index] = (E) value;
        size++;
    }


    private void validateElementIndexForAdd(int index) {
        if (index < 0 || index > this.size)
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }

    private void validateElementIndex(int index) {
        if (index < 0 || index >= this.size)
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }

    private String outOfBoundsMsg(int index) {
        return "Index: " + index + ", Size: " + size;
    }

    private void ensureCapacity(int minCapacity) {
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

    public boolean add(Object value) {
        ensureCapacity(size + 1);
        array[size++] = (E) value;
        return true;
    }

    public int indexOf(Object value) {
        if (value == null) {
            for (int i = 0; i < size; i++) {
                if (array[i] == null)
                    return i;
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (value.equals(array[i]))
                    return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(Object value) {
        if (value == null) {
            for (int i = size - 1; i >= 0; i--) {
                if (array[i] == null)
                    return i;
            }
        } else {
            for (int i = size - 1; i >= 0; i--) {
                if (value.equals(array[i]))
                    return i;
            }
        }
        return -1;
    }

    public boolean contains(Object value) {
        for (int i = 0; i < size; i++) {
            if (value.equals(array[i]))
                return true;
        }
        return false;
    }


    public E set(int index, Object value) {
        validateElementIndex(index);
        E oldValue = array[index];
        array[index] = (E) value;
        return oldValue;
    }


    public void clear() {
        for (int i = 0; i < size; i++)
            array[i] = null;

        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E get(int index) {
        validateElementIndex(index);
        return array[index];
    }

    public E remove(int index) {
        validateElementIndex(index);
        E oldValue = array[index];
        int numMoved = size - index - 1;
        if (numMoved > 0)
            System.arraycopy(array, index + 1, array, index,
                    numMoved);
        array[--size] = null; // clear to let GC do its work

        return oldValue;
    }


}
