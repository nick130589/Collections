import java.util.NoSuchElementException;
import java.util.StringJoiner;

/**
 * Created by Nick on 1/14/2018.
 */
public class LinkedListCustom<E> implements ListCustom {

    private Node<E> head;
    private Node<E> tail;
    private int size;

    public int size() {
        return size;
    }

    public void add(int index, Object value) {
        validateElementIndexForAdd(index);
        if (index == size) {
            linkLast((E) value);
        } else {
            linkBefore((E) value, node(index));
        }
    }

    private void linkBefore(E value, Node<E> node) {
        Node<E> pred = node.prev;
        Node<E> newNode = new Node<>(pred, value, node);
        node.prev = newNode;
        if (pred == null)
            head = newNode;
        else
            pred.next = newNode;
        size++;

    }

    private E unlinkFirst(Node<E> f) {
        final E element = f.value;
        final Node<E> next = f.next;
        f.value = null;
        f.next = null; // help GC
        head = next;
        if (next == null)
            tail = null;
        else
            next.prev = null;
        size--;
        return element;
    }

    private E unlinkLast(Node<E> l) {
        // assert l == last && l != null;
        final E element = l.value;
        final Node<E> prev = l.prev;
        l.value = null;
        l.prev = null; // help GC
        tail = prev;
        if (prev == null)
            head = null;
        else
            prev.next = null;
        size--;
        return element;
    }

    private void linkLast(E value) {
        Node<E> node = new Node<>(tail, value, null);
        if (size == 0) {
            head = tail = node;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
        size++;
    }

    private Node<E> node(int index) {
        // assert isElementIndex(index);

        if (index < (size >> 1)) {
            Node<E> x = head;
            for (int i = 0; i < index; i++)
                x = x.next;
            return x;
        } else {
            Node<E> x = tail;
            for (int i = size - 1; i > index; i--)
                x = x.prev;
            return x;
        }
    }

    public void addFirst(E e) {
        linkFirst(e);
    }

    private void linkFirst(E e) {
        final Node<E> f = head;
        final Node<E> newNode = new Node<>(null, e, f);
        head = newNode;
        if (f == null)
            tail = newNode;
        else
            f.prev = newNode;
        size++;
    }

    public E getFirst() {
        final Node<E> f = head;
        if (f == null)
            throw new NoSuchElementException();
        return f.value;
    }

    public E getLast() {
        final Node<E> l = tail;
        if (l == null)
            throw new NoSuchElementException();
        return l.value;
    }

    public boolean add(Object e) {
        linkLast((E) e);
        return true;
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

    public int indexOf(Object o) {
        int index = 0;
        if (o == null) {
            for (Node<E> x = head; x != null; x = x.next) {
                if (x.value == null)
                    return index;
                index++;
            }
        } else {
            for (Node<E> x = head; x != null; x = x.next) {
                if (o.equals(x.value))
                    return index;
                index++;
            }
        }
        return -1;
    }

    public int lastIndexOf(Object o) {
        int index = size;
        if (o == null) {
            for (Node<E> x = tail; x != null; x = x.prev) {
                index--;
                if (x.value == null)
                    return index;
            }
        } else {
            for (Node<E> x = tail; x != null; x = x.prev) {
                index--;
                if (o.equals(x.value))
                    return index;
            }
        }
        return -1;
    }

    public boolean contains(Object o) {
        return indexOf(o) != -1;
    }

    public E set(int index, Object element) {
        validateElementIndex(index);
        Node<E> x = node(index);
        E oldVal = x.value;
        x.value = (E) element;
        return oldVal;
    }

    public void clear() {
        for (Node<E> x = head; x != null; ) {
            Node<E> next = x.next;
            x.value = null;
            x.next = null;
            x.prev = null;
            x = next;
        }
        head = tail = null;
        size = 0;
    }

    public E removeFirst() {
        final Node<E> f = head;
        if (f == null)
            throw new NoSuchElementException();
        return unlinkFirst(f);
    }

    public E removeLast() {
        final Node<E> l = tail;
        if (l == null)
            throw new NoSuchElementException();
        return unlinkLast(l);
    }


    public E remove(int index) {
        validateElementIndex(index);
        return unlink(node(index));
    }

    private E unlink(Node<E> x) {
        final E element = x.value;
        final Node<E> next = x.next;
        final Node<E> prev = x.prev;

        if (prev == null) {
            head = next;
        } else {
            prev.next = next;
            x.prev = null;
        }

        if (next == null) {
            tail = prev;
        } else {
            next.prev = prev;
            x.next = null;
        }

        x.value = null;
        size--;
        return element;
    }


    public E get(int index) {
        validateElementIndex(index);
        return node(index).value;
    }


    public boolean isEmpty() {
        return size == 0;
    }

    private static class Node<E> {
        E value;
        Node<E> next;
        Node<E> prev;

        private Node(Node<E> prev, E value, Node<E> next) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }

//        @Override
//        public String toString() {
//            return "Node{" +
//                    "value=" + value +
//                    ", next=" + next +
//                    ", prev=" + prev +
//                    '}';
//        }
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "[", "]");
        Node<E> temp = head;
        for (int i = 0; i < size; i++) {
            joiner.add(String.valueOf(temp.value));
            temp = temp.next;
        }

        return joiner.toString();
    }
}
