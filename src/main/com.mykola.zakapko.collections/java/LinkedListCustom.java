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

    public void add(int index, E value){
        validateElementIndexForAdd(index);

        Node<E> node = new Node<>(tail, value, null);
        if(size == 0){
            head = tail = node;
        }else if(index == size){
            tail.next = node;
        node.prev = tail;
        tail = node;
    }
        size++;
        //linkFirst(value);
        //TODO: beginning
        //TODO: middle
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
