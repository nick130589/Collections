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
        //TODO: validateElementIndex(index);

        Node<E> node = new Node<E>(value);
        if(size == 0){
            head = tail = node;
        }else if(index == size){
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
        //TODO: beginning
        //TODO: middle
    }

    private static class Node<E>{
        E value;
        Node<E> next;
        Node<E> prev;

        private Node(E value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", next=" + next +
                    ", prev=" + prev +
                    '}';
        }
    }
}
