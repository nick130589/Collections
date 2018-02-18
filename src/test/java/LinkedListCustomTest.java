import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Nick on 2/17/2018.
 */
public class LinkedListCustomTest {
    private LinkedListCustom linkedListCustom;

    @Before
    public void setUp() {
        linkedListCustom = new LinkedListCustom();
    }

    @After
    public void tearDown() {
        linkedListCustom = null;
    }

    @Test
    public void testListInit() {
        assertTrue(linkedListCustom.isEmpty());
        assertTrue(linkedListCustom.size() == 0);
    }

    @Test
    public void shouldAddStringElementsByIndex() {
        linkedListCustom.add(0, "1");
        linkedListCustom.add(1, "2");
        linkedListCustom.add(2, "3");

        assertEquals("1", linkedListCustom.get(0));
        assertEquals("2", linkedListCustom.get(1));
        assertEquals("3", linkedListCustom.get(2));

        linkedListCustom.add(1, "4");

        assertEquals("1", linkedListCustom.get(0));
        assertEquals("4", linkedListCustom.get(1));
        assertEquals("2", linkedListCustom.get(2));
        assertEquals("3", linkedListCustom.get(3));
        assertTrue(linkedListCustom.size() == 4);
    }

    @Test
    public void shouldAddNumberElementsByIndex() {
        linkedListCustom.add(0, 1);
        linkedListCustom.add(1, 2);
        linkedListCustom.add(2, 3.5);

        assertEquals(1, linkedListCustom.get(0));
        assertEquals(2, linkedListCustom.get(1));
        assertEquals(3.5, linkedListCustom.get(2));

        linkedListCustom.add(1, 4.7900395854302394);

        assertEquals(1, linkedListCustom.get(0));
        assertEquals(4.7900395854302394, linkedListCustom.get(1));
        assertEquals(2, linkedListCustom.get(2));
        assertEquals(3.5, linkedListCustom.get(3));
        assertTrue(linkedListCustom.size() == 4);
    }

    @Test
    public void testSetElement() {
        linkedListCustom.add(0, "Karol");
        linkedListCustom.add(1, "Vanessa");
        linkedListCustom.add(2, "Amanda");

        linkedListCustom.set(1, "Livia");

        assertEquals("Karol", linkedListCustom.get(0));
        assertEquals("Livia", linkedListCustom.get(1));
        assertEquals("Amanda", linkedListCustom.get(2));
        assertTrue(linkedListCustom.size() == 3);
    }

    @Test
    public void testRemoveElement() {
        linkedListCustom.add(0, "Karol");
        linkedListCustom.add(1, "Vanessa");
        linkedListCustom.add(2, "Amanda");

        assertEquals("Amanda", linkedListCustom.remove(2));
        assertTrue(linkedListCustom.size() == 2);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveWithEmptyList() {
        linkedListCustom.remove(0);
    }

    @Test
    public void testSizeOfList() {
        linkedListCustom.add(0, "Karol");
        linkedListCustom.add(1, "Vanessa");
        linkedListCustom.add(2, "Amanda");

        assertTrue(linkedListCustom.size() == 3);
    }

    @Test
    public void shouldAddElements() {
        linkedListCustom.add("Karol");
        linkedListCustom.add(2);
        linkedListCustom.add(2.5);

        assertEquals("Karol", linkedListCustom.get(0));
        assertEquals(2, linkedListCustom.get(1));
        assertEquals(2.5, linkedListCustom.get(2));
        assertTrue(linkedListCustom.size() == 3);
    }

    @Test
    public void shouldReturnFirstIndexOfElement() {
        linkedListCustom.add("Karol");
        linkedListCustom.add("Kristina");
        linkedListCustom.add("Kristina");
        linkedListCustom.add("Kristina");
        linkedListCustom.add("Olya");

        assertEquals(1, linkedListCustom.indexOf("Kristina"));
    }

    @Test
    public void shouldReturnLastIndexOfElement() {
        linkedListCustom.add("Karol");
        linkedListCustom.add("Kristina");
        linkedListCustom.add("Kristina");
        linkedListCustom.add("Kristina");
        linkedListCustom.add("Olya");

        assertEquals(3, linkedListCustom.lastIndexOf("Kristina"));
    }

    @Test
    public void shouldContainElement() {
        linkedListCustom.add("Karol");
        linkedListCustom.add("Veoleta");
        linkedListCustom.add("Petr");
        linkedListCustom.add("Kristina");
        linkedListCustom.add("Olya");

        assertTrue(linkedListCustom.contains("Kristina"));
    }

    @Test
    public void shouldNotContainElement() {
        linkedListCustom.add("Karol");
        linkedListCustom.add("Veoleta");
        linkedListCustom.add("Petr");
        linkedListCustom.add("Kristina");
        linkedListCustom.add("Olya");

        assertFalse(linkedListCustom.contains("Kolya"));
    }

    @Test
    public void shouldClearList() {
        linkedListCustom.add("Karol");
        linkedListCustom.add("Veoleta");
        linkedListCustom.add("Petr");
        linkedListCustom.add("Kristina");
        linkedListCustom.add("Olya");
        assertTrue(linkedListCustom.size() == 5);
        linkedListCustom.clear();
        assertTrue(linkedListCustom.size() == 0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddElementWithNegativeIndex() {
        linkedListCustom.add(-1, "Karol");
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSetElementWithNegativeIndex() {
        linkedListCustom.add(0, "Karol");
        linkedListCustom.set(-1, "Bench");
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveElementWithNegativeIndex() {
        linkedListCustom.remove(-1);
    }

    @Test
    public void shouldAddElementBeforeFirst() {
        linkedListCustom.add("Karol");
        linkedListCustom.add("Veoleta");
        linkedListCustom.add("Petr");
        linkedListCustom.addFirst("Kolya");

        assertEquals("Kolya", linkedListCustom.get(0));
        assertEquals("Karol", linkedListCustom.get(1));
        assertEquals("Veoleta", linkedListCustom.get(2));
        assertEquals("Petr", linkedListCustom.get(3));
        assertTrue(linkedListCustom.size() == 4);
    }

    @Test
    public void shouldReturnFirstElement() {
        linkedListCustom.add("Karol");
        linkedListCustom.add("Veoleta");
        linkedListCustom.add("Petr");

        assertEquals("Karol", linkedListCustom.getFirst());
    }

    @Test
    public void shouldReturnLastElement() {
        linkedListCustom.add("Karol");
        linkedListCustom.add("Veoleta");
        linkedListCustom.add("Petr");

        assertEquals("Petr", linkedListCustom.getLast());
    }

    @Test
    public void shouldRemoveLastElement() {
        linkedListCustom.add("Karol");
        linkedListCustom.add("Veoleta");
        linkedListCustom.add("Petr");

        assertEquals("Petr", linkedListCustom.removeLast());
        assertTrue(linkedListCustom.size() == 2);
    }

    @Test
    public void shouldRemoveFirstElement() {
        linkedListCustom.add("Karol");
        linkedListCustom.add("Veoleta");
        linkedListCustom.add("Petr");

        assertEquals("Karol", linkedListCustom.removeFirst());
        assertTrue(linkedListCustom.size() == 2);
    }


    @Test(expected = NoSuchElementException.class)
    public void testGetFirstElementFromEmptyList() {
        linkedListCustom.getFirst();
    }

    @Test(expected = NoSuchElementException.class)
    public void testGetLastElementFromEmptyList() {
        linkedListCustom.getLast();
    }

    @Test(expected = NoSuchElementException.class)
    public void testRemoveFirstElementFromEmptyList() {
        linkedListCustom.removeFirst();
    }

    @Test(expected = NoSuchElementException.class)
    public void testRemoveLastElementFromEmptyList() {
        linkedListCustom.removeLast();
    }


    @Test
    public void shouldReturnFirstIndexZeroIfElementIsNull() {
        linkedListCustom.add(null);
        assertEquals(0, linkedListCustom.indexOf(null));
    }

    @Test
    public void shouldReturnLastIndexZeroIfElementIsNull() {
        linkedListCustom.add(null);
        assertEquals(0, linkedListCustom.lastIndexOf(null));
    }

    @Test
    public void shouldReturnFirstIndexMinusOneIfNotSuchElement() {
        assertEquals(-1, linkedListCustom.indexOf(null));
    }

    @Test
    public void shouldReturnLastIndexMinusOneIfNotSuchElement() {
        assertEquals(-1, linkedListCustom.lastIndexOf(null));
    }
}
