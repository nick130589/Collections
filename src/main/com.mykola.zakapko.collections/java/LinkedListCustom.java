import java.util.NoSuchElementException;
import java.util.StringJoiner;

/**
 * Created by Nick on 1/14/2018.
 */
public class LinkedListCustom<E> {

    private Node<E> head;
    private Node<E> tail;
    private int size;

    public int size(){
        return size;
    }

    public void add(int index, E value) {
        validateElementIndexForAdd(index);
        if (index == size) {
            linkLast(value);
        } else {
            linkBefore(value, node(index));
        }
        //linkFirst(value);
        //TODO: beginning
        //TODO: middle
    }

    void linkBefore(E value, Node<E> node) {
        Node<E> pred = node.prev;
        Node<E> newNode = new Node<>(pred, value, node);
        node.prev = newNode;
        if (pred == null)
            head = newNode;
        else
            pred.next = newNode;
        size++;

    }
    public void linkLast(E value) {
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

    Node<E> node(int index) {
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

    private void validateElementIndexForAdd(int index) {
        if (index < 0 || index > this.size)
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }

    private String outOfBoundsMsg(int index) {
        return "Index: " + index + ", Size: " + size;
    }

    private static class Node<E>{
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
