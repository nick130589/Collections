import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
//        ArrayListCustom<Integer> list = new ArrayListCustom();
//        list.add(0, 1);
//        list.add(1, 2);
//        list.add(2, 3);
//        list.add(3, 4);
//        list.add(4, 5);
//        list.add(5, 6);
//        ArrayListCustom<Integer> list4 = new ArrayListCustom();
//        list4.add(1);
//        list4.add(2);
//        list4.add(3);
//        list4.add(4);
//        list4.add(5);
//        list4.add(6);
//        list4.add(7);
//        List<Integer> list2 = new ArrayList<Integer>();
//
        ArrayList<String> list3 = new ArrayList<>();
        list3.add(0, "Test");
       // list3.lastIndexOf(0, null);
//        list3.add(0);
//        list3.add(1);
//        list3.add(2);
//        list3.remove(1);
//        for (int i = 0; i < list.size(); i++)
//        {
//           // System.out.println(list.);
//        }
//
//        list2.add(0, 1);
//        list2.add(1, 2);
//        list2.add(2, 3);
//        list2.add(3, 4);
//        list2.add(4, 5);
//        list2.add(5, 6);
//
        List<Integer> linkedList2 = new LinkedList<Integer>();
        linkedList2.add(null);
        linkedList2.indexOf(null);
        linkedList2.add(0, 2);
        linkedList2.indexOf(2);
        linkedList2.add(1, 3);
        linkedList2.add(2, 4);
//
//        LinkedListCustom <Integer> linkedList = new LinkedListCustom<Integer>();
//        linkedList.add(0, 2);
//        int value = linkedList.getFirst();
//        linkedList.add(1, 3);
//        linkedList.add(2, 4);
        LinkedListCustom<String> list = new LinkedListCustom<>();
        list.add(0, "0");
        System.out.println(list);
        list.add(1, "1");
        System.out.println(list);
        list.add(2, "2");
        System.out.println(list);
        list.addFirst("6");
        System.out.println(list);
        list.add(1, "8");
        System.out.println(list);
    }


}
