package numberlist.objectlist;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * This is the JUnit Test for the Complex class.
 *
 * @author Giovanna Chintya Susanto
 * @author Lok Hei Gee
 * @author Jason Christian Limpah
 * @author Feny Graciella Dai
 * @version 3/6/2021
 */
public class ComplexTest {

    Complex c1, c2, c3, c4;

    @Before
    public void setUp() {
        c1 = new Complex(1.2, 2.3);
        c2 = new Complex(4.5, 5.6);
        c3 = new Complex(1.2, 2.3);
        c4 = new Complex(-5.6, -6.7);
    }

    /**
     * Test of getReal method, of class Complex.
     */
    @Test
    public void testGetRealPos() {
        assertEquals(c1.getReal(), 1.2, 0.1);
    }

    @Test
    public void testGetRealNeg() {
        assertEquals(c4.getReal(), -5.6, 0.1);
    }

    /**
     * Test of getImaginary method, of class Complex.
     */
    @Test
    public void testGetImaginaryPos() {
        assertEquals(c1.getImaginary(), 2.3, 0.1);
    }

    @Test
    public void testGetImaginaryNeg() {
        assertEquals(c4.getImaginary(), -6.7, 0.1);
    }

    /**
     * Test of add method, of class Complex.
     */
    @Test
    public void testAddPos() {
        Complex c = c1.add(c2);
        assertTrue(c != c1);
        assertTrue(c != c2);
        assertEquals(c1.getReal(), 1.2, 0.1);
        assertEquals(c1.getImaginary(), 2.3, 0.1);
        assertEquals(c2.getReal(), 4.5, 0.1);
        assertEquals(c2.getImaginary(), 5.6, 0.1);
        assertEquals(c.getReal(), 5.7, 0.1);
        assertEquals(c.getImaginary(), 7.9, 0.1);
    }

    @Test
    public void testAddNeg() {
        Complex c = c1.add(c4);
        assertTrue(c != c1);
        assertTrue(c != c4);
        assertEquals(c1.getReal(), 1.2, 0.1);
        assertEquals(c1.getImaginary(), 2.3, 0.1);
        assertEquals(c4.getReal(), -5.6, 0.1);
        assertEquals(c4.getImaginary(), -6.7, 0.1);
        assertEquals(c.getReal(), -4.4, 0.1);
        assertEquals(c.getImaginary(), -4.4, 0.1);
    }

    /**
     * Test of subtract method, of class Complex.
     */
    @Test
    public void testSubtractPos() {
        Complex c = c2.subtract(c1);
        assertTrue(c != c1);
        assertTrue(c != c2);
        assertEquals(c1.getReal(), 1.2, 0.1);
        assertEquals(c1.getImaginary(), 2.3, 0.1);
        assertEquals(c2.getReal(), 4.5, 0.1);
        assertEquals(c2.getImaginary(), 5.6, 0.1);
        assertEquals(c.getReal(), 3.3, 0.1);
        assertEquals(c.getImaginary(), 3.3, 0.1);
    }

    @Test
    public void testSubtractNeg() {
        Complex c = c1.subtract(c4);
        assertTrue(c != c1);
        assertTrue(c != c4);
        assertEquals(c1.getReal(), 1.2, 0.1);
        assertEquals(c1.getImaginary(), 2.3, 0.1);
        assertEquals(c4.getReal(), -5.6, 0.1);
        assertEquals(c4.getImaginary(), -6.7, 0.1);
        assertEquals(c.getReal(), 6.7, 0.1);
        assertEquals(c.getImaginary(), 9.0, 0.1);
    }

    /**
     * Test of equal method, of class Complex.
     */
    @Test
    public void testEqual() {
        assertEquals(true, c1.equals(c1));
        assertEquals(false, c1.equals(c2));
    }

    /**
     * Test of toString method, of class Complex.
     */
    @Test
    public void testToString() {
        assertEquals(c1.toString(), "1.2 + 2.3i");
        assertEquals(c4.toString(), "-5.6 - 6.7i");
        assertEquals((new Complex(0, 1.2)).toString(), "1.2i");
        assertEquals((new Complex(1.2, 0)).toString(), "1.2");
        assertEquals((new Complex(0, -1.2)).toString(), "-1.2i");
        assertEquals((new Complex(-1.2, 0)).toString(), "-1.2");
        assertEquals(c1.toString(), c3.toString());
    }

    /**
     * Test of copy method, of class Complex.
     */
    @Test
    public void testCopy() {
        Complex c = c1;
        Complex cc = c1.copy();
        assertEquals(c.equals(cc), true);
        assertEquals(c2.equals(cc), false);
    }

    /**
     * Test of compareTo method, of class Complex.
     */
    @Test
    public void testCompareTo() {
        assertEquals(0, c1.compareTo(c3));
        assertEquals(10.0, c2.compareTo(c4), 0);
    }

}
