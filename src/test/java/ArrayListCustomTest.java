import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.*;

/**
 * Created by Nick on 2/17/2018.
 */
public class ArrayListCustomTest {
    private ArrayListCustom arrayListCustom;

    @Before
    public void setUp() {
        arrayListCustom = new ArrayListCustom();
    }

    @After
    public void tearDown() {
        arrayListCustom = null;
    }

    @Test
    public void testListInit() {
        assertTrue(arrayListCustom.isEmpty());
        assertTrue(arrayListCustom.size() == 0);
    }

    @Test
    public void shouldAddStringElementsByIndex() {
        arrayListCustom.add(0, "1");
        arrayListCustom.add(1, "2");
        arrayListCustom.add(2, "3");

        assertEquals("1", arrayListCustom.get(0));
        assertEquals("2", arrayListCustom.get(1));
        assertEquals("3", arrayListCustom.get(2));

        arrayListCustom.add(1, "4");

        assertEquals("1", arrayListCustom.get(0));
        assertEquals("4", arrayListCustom.get(1));
        assertEquals("2", arrayListCustom.get(2));
        assertEquals("3", arrayListCustom.get(3));
        assertTrue(arrayListCustom.size() == 4);
    }

    @Test
    public void shouldAddNumberElementsByIndex() {
        arrayListCustom.add(0, 1);
        arrayListCustom.add(1, 2);
        arrayListCustom.add(2, 3.5);

        assertEquals(1, arrayListCustom.get(0));
        assertEquals(2, arrayListCustom.get(1));
        assertEquals(3.5, arrayListCustom.get(2));

        arrayListCustom.add(1, 4.7900395854302394);

        assertEquals(1, arrayListCustom.get(0));
        assertEquals(4.7900395854302394, arrayListCustom.get(1));
        assertEquals(2, arrayListCustom.get(2));
        assertEquals(3.5, arrayListCustom.get(3));
        assertTrue(arrayListCustom.size() == 4);
    }

    @Test
    public void testSetElement() {
        arrayListCustom.add(0, "Karol");
        arrayListCustom.add(1, "Vanessa");
        arrayListCustom.add(2, "Amanda");

        arrayListCustom.set(1, "Livia");

        assertEquals("Karol", arrayListCustom.get(0));
        assertEquals("Livia", arrayListCustom.get(1));
        assertEquals("Amanda", arrayListCustom.get(2));
        assertTrue(arrayListCustom.size() == 3);
    }

    @Test
    public void testRemoveElement() {
        arrayListCustom.add(0, "Karol");
        arrayListCustom.add(1, "Vanessa");
        arrayListCustom.add(2, "Amanda");

        assertEquals("Amanda", arrayListCustom.remove(2));
        assertTrue(arrayListCustom.size() == 2);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveWithEmptyList() {
        arrayListCustom.remove(0);
    }

    @Test
    public void testSizeOfList() {
        arrayListCustom.add(0, "Karol");
        arrayListCustom.add(1, "Vanessa");
        arrayListCustom.add(2, "Amanda");

        assertTrue(arrayListCustom.size() == 3);
    }

    @Test
    public void shouldAddElements() {
        arrayListCustom.add("Karol");
        arrayListCustom.add(2);
        arrayListCustom.add(2.5);

        assertEquals("Karol", arrayListCustom.get(0));
        assertEquals(2, arrayListCustom.get(1));
        assertEquals(2.5, arrayListCustom.get(2));
        assertTrue(arrayListCustom.size() == 3);
    }

    @Test
    public void shouldReturnFirstIndexOfElement() {
        arrayListCustom.add("Karol");
        arrayListCustom.add("Kristina");
        arrayListCustom.add("Kristina");
        arrayListCustom.add("Kristina");
        arrayListCustom.add("Olya");

        assertEquals(1, arrayListCustom.indexOf("Kristina"));
    }

    @Test
    public void shouldReturnLastIndexOfElement() {
        arrayListCustom.add("Karol");
        arrayListCustom.add("Kristina");
        arrayListCustom.add("Kristina");
        arrayListCustom.add("Kristina");
        arrayListCustom.add("Olya");

        assertEquals(3, arrayListCustom.lastIndexOf("Kristina"));
    }

    @Test
    public void shouldContainElement() {
        arrayListCustom.add("Karol");
        arrayListCustom.add("Veoleta");
        arrayListCustom.add("Petr");
        arrayListCustom.add("Kristina");
        arrayListCustom.add("Olya");

        assertTrue(arrayListCustom.contains("Kristina"));
    }

    @Test
    public void shouldNotContainElement() {
        arrayListCustom.add("Karol");
        arrayListCustom.add("Veoleta");
        arrayListCustom.add("Petr");
        arrayListCustom.add("Kristina");
        arrayListCustom.add("Olya");

        assertFalse(arrayListCustom.contains("Kolya"));
    }

    @Test
    public void shouldClearList() {
        arrayListCustom.add("Karol");
        arrayListCustom.add("Veoleta");
        arrayListCustom.add("Petr");
        arrayListCustom.add("Kristina");
        arrayListCustom.add("Olya");
        assertTrue(arrayListCustom.size() == 5);
        arrayListCustom.clear();
        assertTrue(arrayListCustom.size() == 0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddElementWithNegativeIndex() {
        arrayListCustom.add(-1, "Karol");
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSetElementWithNegativeIndex() {
        arrayListCustom.add(0, "Karol");
        arrayListCustom.set(-1, "Bench");
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveElementWithNegativeIndex() {
        arrayListCustom.remove(-1);
    }

    @Test
    public void shouldReturnFirstIndexMinusOneIfNotSuchElement() {
        assertEquals(-1, arrayListCustom.indexOf(null));
    }

    @Test
    public void shouldReturnLastIndexMinusOneIfNotSuchElement() {
        assertEquals(-1, arrayListCustom.lastIndexOf(null));
    }
}
