package numberlist.primitivelist;

import numberlist.IndexException;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * This is the JUnit Test for the DoubleArrayList class.
 *
 * @author Giovanna Chintya Susanto
 * @author Lok Hei Gee
 * @author Jason Christian Limpah
 * @author Feny Graciella Dai
 * @version 3/6/2021
 */
public class DoubleArrayListTest {

    DoubleArrayList list;

    @Before
    public void setUp() {
        list = new DoubleArrayList();
    }

    /**
     * Test of add method, of class DoubleArrayList.
     * @throws numberlist.IndexException
     */
    @Test
    public void testAddFirst() throws IndexException {
        list.add(0, 123);
        assertEquals(1, list.getCount());
        assertEquals(123, list.getValue(0), 0.001);
    }

    @Test
    public void testAddLots() throws IndexException {
        for (int i = 0; i < 1000; i++) {
            list.add(i, i * 10);
        }
        assertEquals(1000, list.getCount());
        for (int i = 0; i < 1000; i++) {
            assertEquals(i * 10, list.getValue(i), 0.001);
        }
    }

    @Test
    public void testAddMiddle() throws IndexException {
        for (int i = 0; i < 5; i++) {
            list.add(i, i * 10);
        }
        list.add(2, 123);
        assertEquals(6, list.getCount());
        assertEquals(0, list.getValue(0), 0.001);
        assertEquals(10, list.getValue(1), 0.001);
        assertEquals(123, list.getValue(2), 0.001);
        assertEquals(20, list.getValue(3), 0.001);
        assertEquals(30, list.getValue(4), 0.001);
        assertEquals(40, list.getValue(5), 0.001);
    }

    @Test
    public void testAddLotsMiddle() throws IndexException {
        for (int i = 0; i < 100; i++) {
            list.add(i, i * 10);
        }
        list.add(15, 123);
        assertEquals(101, list.getCount());
        for (int i = 0; i < 15; i++) {
            assertEquals(i * 10, list.getValue(i), 0.001);
        }
        assertEquals(123, list.getValue(15), 0.001);
        for (int i = 16; i < 100; i++) {
            assertEquals((i - 1) * 10, list.getValue(i), 0.001);
        }
    }

    @Test
    public void testAddWrongIndex() throws IndexException {
        boolean err = false;
        list.add(0, 19);
        list.add(1, 18);
        try {
            list.add(-1, 9);
            list.add(99999, 8);
        } catch (IndexException ie) {
            err = true;
            assertEquals(0, ie.getMin());
            assertEquals(2, ie.getMax());
            assertEquals(-1, ie.getValue());

        }
        assertTrue(err);
    }

    /**
     * Test of set method, of class DoubleArrayList.
     */
    @Test
    public void testSet() {
        boolean err = false;
        try {
            list.add(0, 10.25);
            list.add(1, 19.25);
            list.add(2, 26.25);
            list.add(3, 80.25);
            list.add(4, 34.25);
            assertEquals("[ 10.25, 19.25, 26.25, 80.25, 34.25 ]",
                    list.toString());
            list.set(2, 80.0);
            assertEquals("[ 10.25, 19.25, 80.0, 80.25, 34.25 ]",
                    list.toString());
            list.set(-1, 80);
        } catch (IndexException ex) {
            err = true;
            assertSame(-1, ex.getMin());
            assertSame(-1, ex.getMax());
            assertSame(-1, ex.getValue());
        }
        assertTrue(err);
    }

    /**
     * Test of remove method with index, of class DoubleArrayList.
     * @throws numberlist.IndexException
     */
    @Test
    public void testRemoveFirstIndex() throws IndexException {
        for (int i = 0; i < 5; i++) {
            list.add(i, i * 10);
        }
        double value = list.remove(0);
        assertEquals(0, value, 0.001);
        assertEquals(4, list.getCount());
        for (int i = 0; i < 4; i++) {
            assertEquals((i + 1) * 10, list.getValue(i), 0.001);
        }
    }

    @Test
    public void testRemoveWrongIndex() throws IndexException {
        boolean err = false;
        list.add(0, 9);
        list.add(1, 18);
        try {
            list.remove(-1);
        } catch (IndexException ie) {
            err = true;
            assertEquals(0, ie.getMin());
            assertEquals(1, ie.getMax());
            assertEquals(-1, ie.getValue());

        }
        assertTrue(err);
    }

    @Test
    public void testremoveLastIndex() throws IndexException {
        for (int i = 0; i < 5; i++) {
            list.add(i, i * 10);
        }
        double value = list.remove(4);
        assertEquals(4, list.getCount());
        for (int i = 0; i < 4; i++) {
            assertEquals(i * 10, list.getValue(i), 0.001);
        }
    }

    @Test
    public void testRemoveMiddleValue() throws IndexException {
        for (int i = 0; i < 5; i++) {
            list.add(i, i * 10);
        }
        for (int i = 5; i < 10; i++) {
            list.add(i, (i - 5) * 10);
        }
        for (int i = 10; i < 15; i++) {
            list.add(i, (i - 10) * 10);
        }
        list.remove(20L);
        assertEquals(14, list.getCount());
        for (int i = 0; i < 2; i++) {
            assertEquals(i * 10, list.getValue(i), 0.001);
        }
        for (int i = 2; i < 4; i++) {
            assertEquals((i + 1) * 10, list.getValue(i), 0.001);
        }
        for (int i = 4; i < 9; i++) {
            assertEquals((i - 4) * 10, list.getValue(i), 0.001);
        }
        for (int i = 9; i < 14; i++) {
            assertEquals((i - 9) * 10, list.getValue(i), 0.001);
        }
    }

    @Test
    public void testRemoveNonexistentValue() throws IndexException {
        for (int i = 0; i < 5; i++) {
            list.add(i, i * 10);
        }
        list.remove(123L);
        assertEquals(5, list.getCount());
        for (int i = 0; i < 5; i++) {
            assertEquals(i * 10, list.getValue(i), 0.001);
        }
    }

    @Test
    public void testRemoveFirstValue() throws IndexException {
        for (int i = 0; i < 5; i++) {
            list.add(i, (i + 1) * 10);
        }
        list.remove(10L);
        assertEquals(4, list.getCount());
        for (int i = 0; i < 4; i++) {
            assertEquals((i + 2) * 10, list.getValue(i), 0.001);
        }
    }

    @Test
    public void testRemoveLastValue() throws IndexException {
        for (int i = 0; i < 5; i++) {
            list.add(i, i * 10);
        }
        list.remove(40L);
        assertEquals(4, list.getCount());
        for (int i = 0; i < 4; i++) {
            assertEquals(i * 10, list.getValue(i), 0.001);
        }
    }

    /**
     * Test of getValue method, of class DoubleArrayList.
     * @throws numberlist.IndexException
     */
    @Test
    public void testGetOne() throws IndexException {
        list.add(0, 123);
        assertEquals(123, list.getValue(0), 0.001);
    }

    @Test
    public void testGetWrongIndex() throws IndexException {
        boolean err = false;
        list.add(0, 19);
        list.add(1, 18);
        try {
            list.getValue(-1);
        } catch (IndexException ie) {
            err = true;
            assertEquals(0, ie.getMin());
            assertEquals(1, ie.getMax());
            assertEquals(-1, ie.getValue());

        }
        assertTrue(err);
    }

    @Test
    public void testGetFirst() throws IndexException {
        for (int i = 0; i < 5; i++) {
            list.add(i, i * 10);
        }
        assertEquals(0, list.getValue(0), 0.001);
    }

    @Test
    public void testGetLast() throws IndexException {
        for (int i = 0; i < 5; i++) {
            list.add(i, i * 10);
        }
        assertEquals(40, list.getValue(4), 0.001);
    }

    @Test
    public void testGetMiddle() throws IndexException {
        for (int i = 0; i < 5; i++) {
            list.add(i, i * 10);
        }
        assertEquals(20, list.getValue(2), 0.001);
    }

    /**
     * Test of findFirstIndex method, of class DoubleArrayList.
     * @throws numberlist.IndexException
     */
    @Test
    public void testFindOne() throws IndexException {
        list.add(0, 123);
        assertEquals(0, list.findFirstIndex(123));

    }

    public void testFindFirst() throws IndexException {
        for (int i = 0; i < 5; i++) {
            list.add(i, i * 10);
        }
        assertEquals(0, list.findFirstIndex(0));
    }

    @Test
    public void testFindLast() throws IndexException {
        for (int i = 0; i < 5; i++) {
            list.add(i, i * 10);
        }
        assertEquals(4, list.findFirstIndex(40));
    }

    @Test
    public void testFindMiddle() throws IndexException {
        for (int i = 0; i < 5; i++) {
            list.add(i, i * 10);
        }
        assertEquals(2, list.findFirstIndex(20));
    }

    @Test
    public void testFindNonexistent() throws IndexException {
        for (int i = 0; i < 5; i++) {
            list.add(i, i * 10);
        }
        assertEquals(-1, list.findFirstIndex(123));
    }

    /**
     * Test of getCount method, of class DoubleArrayList.
     */
    @Test
    public void testGetCountEmpty() {
        assertEquals(0, list.getCount());
    }

    @Test
    public void testGetCountPartFilled() throws IndexException {
        for (int i = 0; i < 5; i++) {
            list.add(i, i * 10);
        }
        assertEquals(5, list.getCount());
    }

    @Test
    public void testGetCountFilled() throws IndexException {
        for (int i = 0; i < 10; i++) {
            list.add(i, i * 10);
        }
        assertEquals(10, list.getCount());
    }

    /**
     * Test of toString method, of class DoubleArrayList.
     */
    @Test
    public void testToStringEmpty() {
        assertEquals("[ ]", list.toString());
    }

    @Test
    public void testToString() throws IndexException {
        for (int i = 0; i < 5; i++) {
            list.add(i, i * 10.0);
        }
        assertEquals("[ 0.0, 10.0, 20.0, 30.0, 40.0 ]", list.toString());
    }

}
