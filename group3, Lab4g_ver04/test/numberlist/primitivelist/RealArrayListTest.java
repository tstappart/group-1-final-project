package numberlist.primitivelist;

import numberlist.IndexException;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * This is the JUnit Test for the RealArrayList class.
 *
 * @author Giovanna Chintya Susanto
 * @author Lok Hei Gee
 * @author Jason Christian Limpah
 * @author Feny Graciella Dai
 * @version 3/6/2021
 */
public class RealArrayListTest {

    RealArrayList list;

    @Before
    public void setUp() {
        list = new RealArrayList();
    }

    /**
     * Test of add method, of class RealArrayList.
     * @throws numberlist.IndexException
     */
    @Test
    public void testAdd() throws IndexException {
        int index = list.add(123);
        assertEquals(0, index);
        for (int i = 1; i < 5; i++) {
            list.add(i, i * 10.11);
        }
        assertEquals(5, list.getCount());
        list.add(15.345);
        assertTrue(15.345 == list.getValue(5));
    }

    /**
     * Test of removeAll method, of class RealArrayList.
     * @throws numberlist.IndexException
     */
    @Test
    public void testRemoveAll() throws IndexException {
        list.add(123);
        list.add(123);
        list.add(456);
        list.removeAll(123);
        double value = list.getValue(0);
        assertEquals(456, value, 0.001);
        for (int i = 1; i < 5; i++) {
            list.add(i, i * 10.11);
        }
        assertEquals(5, list.getCount());
        for (int i = 5; i < 15; i++) {
            list.add(i, 9322.4);
        }
        assertEquals(15, list.getCount());
        list.removeAll(9322.4);
        assertEquals(5, list.getCount());
        assertEquals(-1, list.findLastIndex(9322.4));
    }

    /**
     * Test of findLastIndex method, of class RealArrayList.
     * @throws numberlist.IndexException
     */
    @Test
    public void testFindLastIndex() throws IndexException {
        list.add(123);
        list.add(123);
        list.add(456);
        int index1 = list.findLastIndex(123);
        int index2 = list.findLastIndex(99999);
        assertEquals(1, index1);
        assertEquals(-1, index2);
        for (int i = 0; i < 3; i++) {
            list.remove(0);
        }
        for (int i = 0; i < 5; i++) {
            list.add(i, i * 10.512);
        }
        assertEquals(5, list.getCount());
        for (int i = 5; i < 15; i++) {
            list.add(i, 10.512);
        }
        assertEquals(1, list.findFirstIndex(10.512));
        assertEquals(14, list.findLastIndex(10.512));
        assertEquals(-1, list.findLastIndex(32));
    }

}
