/**
 * Created by Nick on 2/18/2018.
 */
public interface  ListCustom<E> {

    int size();
    boolean isEmpty();
    boolean contains(E value);
    boolean add(E e);
    void clear();
    boolean equals(Object o);
    int hashCode();
    E get(int index);
    E set(int index, E element);
    void add(int index, E element);
    E remove(int index);
    int indexOf(Object o);
    int lastIndexOf(Object o);

}
