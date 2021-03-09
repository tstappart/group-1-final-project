package numberlist.objectlist;

import numberlist.IndexException;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * This is the JUnit Test for the NumericLinkedList class.
 *
 * @author Giovanna Chintya Susanto
 * @author Lok Hei Gee
 * @author Jason Christian Limpah
 * @author Feny Graciella Dai
 * @version 3/6/2021
 */
public class NumericLinkedListTest {

    NumericLinkedList list;

    @Before
    public void setUp() {
        list = new NumericLinkedList();

    }

    /**
     * Test of add method, of class NumericArrayList.
     */
    @Test
    public void testAddFirst() throws IndexException {
        list.add(0, new Complex(12, 34));
        assertEquals(1, list.getCount());
        assertEquals(new Complex(12, 34), list.getValue(0));
    }

    @Test
    public void testAddLots() throws IndexException {
        for (int i = 0; i < 1000; i++) {
            list.add(i, new Complex((i * 10), i));
        }
        assertEquals(1000, list.getCount());
        for (int i = 0; i < 1000; i++) {
            assertEquals(new Complex((i * 10), i), list.getValue(i));
        }
    }

    @Test
    public void testAddMiddle() throws IndexException {
        for (int i = 0; i < 5; i++) {
            list.add(i, new Complex(i, i));
        }
        list.add(2, new Complex(100, 100));
        assertEquals(6, list.getCount());
        assertEquals(new Complex(0, 0), list.getValue(0));
        assertEquals(new Complex(1, 1), list.getValue(1));
        assertEquals(new Complex(100, 100), list.getValue(2));
        assertEquals(new Complex(2, 2), list.getValue(3));
        assertEquals(new Complex(3, 3), list.getValue(4));
        assertEquals(new Complex(4, 4), list.getValue(5));
    }

    @Test
    public void testAddLotsMiddle() throws IndexException {
        for (int i = 0; i < 100; i++) {
            list.add(i, new Complex((i * 10), i));
        }
        list.add(15, new Complex(11, 22));
        assertEquals(101, list.getCount());
        for (int i = 0; i < 15; i++) {
            assertEquals(new Complex((i * 10), i), list.getValue(i));
        }
        assertEquals(new Complex(11, 22), list.getValue(15));
        for (int i = 16; i < 100; i++) {
            assertEquals(new Complex((i - 1) * 10, i - 1), list.getValue(i));
        }
    }

    @Test
    public void testAddWrongIndex() throws IndexException {
        boolean err = false;
        list.add(0, new Complex(19, 2));
        list.add(1, new Complex(18, 2));
        try {
            list.add(-1, new Complex(19, 2));
            list.add(99999, new Complex(18, 2));
        } catch (IndexException ie) {
            err = true;
            assertEquals(0, ie.getMin());
            assertEquals(2, ie.getMax());
            assertEquals(-1, ie.getValue());

        }
        assertTrue(err);
    }

    /**
     * Test of set method, of class LinkedList.
     */
    @Test
    public void testSet() {
        boolean err = false;
        try {
            for (int i = 0; i < 5; i++) {
                list.add(i, new Money(i * 10, (byte) 50));
            }
            assertEquals("[ $0.50, $10.50, $20.50, $30.50, $40.50 ]", list.toString());
            list.set(2, new Money(80, (byte) 50));
            assertEquals("[ $0.50, $10.50, $80.50, $30.50, $40.50 ]", list.toString());
            list.set(100, new Money(80, (byte) 50));
        } catch (IndexException ex) {
            err = true;
            assertSame(-1, ex.getMin());
            assertSame(-1, ex.getMax());
            assertSame(100, ex.getValue());
        }
        assertTrue(err);
    }

    /**
     * Test of remove method with index, of class NumericArrayList.
     */
    @Test
    public void testRemoveFirstIndex() throws IndexException {
        for (int i = 0; i < 5; i++) {
            list.add(i, new Complex((i * 10), 1));
        }
        Copiable value = list.remove(0);
        assertEquals(new Complex(0, 1), value);
        assertEquals(4, list.getCount());
        for (int i = 0; i < 4; i++) {
            assertEquals(new Complex(((i + 1) * 10), 1), list.getValue(i));
        }
    }

    @Test
    public void testRemoveWrongIndex() throws IndexException {
        boolean err = false;
        list.add(0, new Complex(19, 2));
        list.add(1, new Complex(18, 2));
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
    public void testRemoveLastIndex() throws IndexException {
        for (int i = 0; i < 5; i++) {
            list.add(i, new Complex((i * 10), 1));
        }
        list.remove(4);
        assertEquals(4, list.getCount());
        for (int i = 0; i < 4; i++) {
            assertEquals(new Complex((i * 10), 1), list.getValue(i));
        }
    }

    /**
     * Test of remove method with value, of class NumericArrayList.
     */
    @Test
    public void testRemoveMiddleValue() throws IndexException {
        for (int i = 0; i < 5; i++) {
            list.add(i, new Complex((i * 10), 1));
        }
        for (int i = 5; i < 10; i++) {
            list.add(i, new Complex(((i - 5) * 10), 1));
        }
        for (int i = 10; i < 15; i++) {
            list.add(i, new Complex(((i - 10) * 10), 1));
        }
        list.remove(new Complex(20, 1));
        assertEquals(14, list.getCount());
        for (int i = 0; i < 2; i++) {
            assertEquals(new Complex((i * 10), 1), list.getValue(i));
        }
        for (int i = 2; i < 4; i++) {
            assertEquals(new Complex(((i + 1) * 10), 1), list.getValue(i));
        }
        for (int i = 4; i < 9; i++) {
            assertEquals(new Complex(((i - 4) * 10), 1), list.getValue(i));
        }
        for (int i = 9; i < 14; i++) {
            assertEquals(new Complex(((i - 9) * 10), 1), list.getValue(i));
        }
    }

    @Test
    public void testRemoveNonexistentValue() throws IndexException {
        for (int i = 0; i < 5; i++) {
            list.add(i, new Complex((i * 10), 1));
        }
        list.remove(new Complex(999, 999));
        assertEquals(5, list.getCount());
        for (int i = 0; i < 5; i++) {
            assertEquals(new Complex((i * 10), 1), list.getValue(i));
        }
    }

    @Test
    public void testRemoveFirstValue() throws IndexException {
        for (int i = 0; i < 5; i++) {
            list.add(i, new Complex(((i + 1) * 10), 1));
        }
        list.remove(new Complex(10, 1));
        assertEquals(4, list.getCount());
        for (int i = 0; i < 4; i++) {
            assertEquals(new Complex(((i + 2) * 10), 1), list.getValue(i));
        }
    }

    @Test
    public void testRemoveLastValue() throws IndexException {
        for (int i = 0; i < 5; i++) {
            list.add(i, new Complex((i * 10), 1));
        }
        list.remove(new Complex(40, 1));
        assertEquals(4, list.getCount());
        for (int i = 0; i < 4; i++) {
            assertEquals(new Complex((i * 10), 1), list.getValue(i));
        }
    }

    /**
     * Test of getValue method, of class LongArrayList.
     */
    @Test
    public void testGetOne() throws IndexException {
        list.add(0, new Complex(10, 1));
        assertEquals(new Complex(10, 1), list.getValue(0));
    }

    @Test
    public void testGetWrongIndex() throws IndexException {
        boolean err = false;
        list.add(0, new Complex(19, 2));
        list.add(1, new Complex(18, 2));
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
            list.add(i, new Complex((i * 10), 1));
        }
        assertEquals(new Complex(0, 1), list.getValue(0));
    }

    @Test
    public void testGetLast() throws IndexException {
        for (int i = 0; i < 5; i++) {
            list.add(i, new Complex((i * 10), 1));
        }
        assertEquals(new Complex(40, 1), list.getValue(4));
    }

    @Test
    public void testGetMiddle() throws IndexException {
        for (int i = 0; i < 5; i++) {
            list.add(i, new Complex((i * 10), 1));
        }
        assertEquals(new Complex(20, 1), list.getValue(2));
    }

    /**
     * Test of findFirstIndex method, of class LongArrayList.
     */
    @Test
    public void testFindOne() throws IndexException {
        list.add(0, new Complex(10, 1));
        assertEquals(0, list.findFirstIndex(new Complex(10, 1)));
    }

    @Test
    public void testFindFirst() throws IndexException {
        for (int i = 0; i < 5; i++) {
            list.add(i, new Complex((i * 10), 1));
        }
        assertEquals(0, list.findFirstIndex(new Complex(0, 1)));
    }

    @Test
    public void testFindLast() throws IndexException {
        for (int i = 0; i < 5; i++) {
            list.add(i, new Complex((i * 10), 1));
        }
        assertEquals(4, list.findFirstIndex(new Complex(40, 1)));
    }

    @Test
    public void testFindMiddle() throws IndexException {
        for (int i = 0; i < 5; i++) {
            list.add(i, new Complex((i * 10), 1));
        }
        assertEquals(2, list.findFirstIndex(new Complex(20, 1)));
    }

    @Test
    public void testFindNonexistent() throws IndexException {
        for (int i = 0; i < 5; i++) {
            list.add(i, new Complex((i * 10), 1));
        }
        assertEquals(-1, list.findFirstIndex(new Complex(999, 999)));
    }

    /**
     * Test of getCount method, of class LongArrayList.
     */
    @Test
    public void testGetCountEmpty() {
        assertEquals(0, list.getCount());
    }

    @Test
    public void testGetCountPartFilled() throws IndexException {
        for (int i = 0; i < 5; i++) {
            list.add(i, new Complex((i * 10), 1));
        }
        assertEquals(5, list.getCount());
    }

    @Test
    public void testGetCountFilled() throws IndexException {
        for (int i = 0; i < 10; i++) {
            list.add(i, new Complex((i * 10), 1));
        }
        assertEquals(10, list.getCount());
    }

    /**
     * Test of toString method, of class LongArrayList.
     */
    @Test
    public void testToStringEmpty() {
        assertEquals("[ ]", list.toString());
    }

    @Test
    public void testToString() throws IndexException {
        for (int i = 0; i < 5; i++) {
            list.add(i, new Complex((i * 10), 1));
        }
        assertEquals("[ 1.0i, 10.0 + 1.0i, 20.0 + 1.0i, 30.0 + 1.0i, 40.0 + 1.0i ]", list.toString());
    }

    /**
     * Test of copy method, of class NumericLinkedTest.
     */
    @Test
    public void testCopy() throws IndexException {
        for (int i = 0; i < 5; i++) {
            list.add(i, new Complex((i * 10), 1));
        }
        NumericLinkedList l = (NumericLinkedList) list.copy();
        assertNotSame(list, l);
        assertEquals(list.getCount(), l.getCount());
        for (int i = 0; i < 5; i++) {
            assertTrue(list.getValue(i).equals(l.getValue(i)));
        }
    }

}
