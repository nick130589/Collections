import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        ArrayListCustom<Integer> list = new ArrayListCustom();
        list.add(0, 1);
        list.add(1, 2);
        list.add(2, 3);
        list.add(3, 4);
        list.add(4, 5);
        list.add(5, 6);
        ArrayListCustom<Integer> list4 = new ArrayListCustom();
        list4.add(1);
        list4.add(2);
        list4.add(3);
        list4.add(4);
        list4.add(5);
        list4.add(6);
        list4.add(7);
        List<Integer> list2 = new ArrayList<Integer>();

        ArrayList<Integer> list3 = new ArrayList<Integer>();
        list3.add(3);
        for (int i = 0; i < list.size(); i++)
        {
           // System.out.println(list.);
        }

        list2.add(0, 1);
        list2.add(1, 2);
        list2.add(2, 3);
        list2.add(3, 4);
        list2.add(4, 5);
        list2.add(5, 6);
    }


}
