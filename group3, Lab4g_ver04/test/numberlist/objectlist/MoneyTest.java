package numberlist.objectlist;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * This is the JUnit Test for the Money class.
 *
 * @author Giovanna Chintya Susanto
 * @author Lok Hei Gee
 * @author Jason Christian Limpah
 * @author Feny Graciella Dai
 * @version 3/6/2021
 */
public class MoneyTest {

    Money m1, m2, m3, m4, m5, m6;

    @Before
    public void setUp() {
        m1 = new Money(12L, (byte) 23);
        m2 = new Money(34L, (byte) 45);
        m3 = new Money(12L, (byte) 23);
        m4 = new Money(-56L, (byte) -67);
        m5 = new Money(2L, (byte) 123);
        m6 = new Money(5L, (byte) -90);
    }

    /**
     * Test of getDollars method, of class Money.
     */
    @Test
    public void testGetDollarsPos() {
        assertTrue(m1.getDollars() == 12);
    }

    @Test
    public void testGetDollarsNeg() {
        assertTrue(m4.getDollars() == -56);
    }

    @Test
    public void testGetDollarsHighCents() {
        assertTrue(m5.getDollars() == 3);
    }

    @Test
    public void testGetDollarsPosNeg() {
        assertTrue(m6.getDollars() == 4);
    }

    /**
     * Test of getCents method, of class Money.
     */
    @Test
    public void testGetCentsPos() {
        assertTrue(m1.getCents() == 23);
    }

    @Test
    public void testGetCentsNeg() {
        assertTrue(m4.getCents() == -67);
    }

    @Test
    public void testGetCentsHighCents() {
        assertTrue(m5.getCents() == 23);
    }

    @Test
    public void testGetCentsPosNeg() {
        assertTrue(m6.getCents() == 10);
    }

    /**
     * Test of add method, of class Money.
     */
    @Test
    public void testAddPos() {
        Money m = m1.add(m2);
        assertTrue(m != m1);
        assertTrue(m != m2);
        assertTrue(m1.getDollars() == 12);
        assertTrue(m2.getDollars() == 34);
        assertTrue(m.getDollars() == 46);
        assertTrue(m1.getCents() == 23);
        assertTrue(m2.getCents() == 45);
        assertTrue(m.getCents() == 68);
    }

    @Test
    public void testAddFlipPos() {
        m1 = new Money(1L, (byte) 99);
        m2 = new Money(2L, (byte) 6);
        Money m = m1.add(m2);
        assertTrue(m != m1);
        assertTrue(m != m2);
        assertTrue(m1.getDollars() == 1);
        assertTrue(m2.getDollars() == 2);
        assertTrue(m.getDollars() == 4);
        assertTrue(m1.getCents() == 99);
        assertTrue(m2.getCents() == 6);
        assertTrue(m.getCents() == 5);
    }

    @Test
    public void testAddNeg() {
        m3 = new Money(12L, (byte) 23);
        m4 = new Money(-56L, (byte) -67);
        Money m = m3.add(m4);
        assertTrue(m != m3);
        assertTrue(m != m4);
        assertTrue(m3.getDollars() == 12);
        assertTrue(m4.getDollars() == -56);
        assertTrue(m.getDollars() == -44);
        assertTrue(m3.getCents() == 23);
        assertTrue(m4.getCents() == -67);
        assertTrue(m.getCents() == -44);
    }

    @Test
    public void testAddFlipNeg() {
        m1 = new Money(-2L, (byte) -6);
        m2 = new Money(-1L, (byte) -99);
        Money m = m1.add(m2);
        assertTrue(m != m1);
        assertTrue(m != m2);
        assertTrue(m1.getDollars() == -2);
        assertTrue(m2.getDollars() == -1);
        assertTrue(m.getDollars() == -4);
        assertTrue(m1.getCents() == -6);
        assertTrue(m2.getCents() == -99);
        assertTrue(m.getCents() == -5);
    }

    /**
     * Test of subtract method, of class Money.
     */
    @Test
    public void testSubtractPos() {
        Money m = m2.subtract(m1);
        assertTrue(m != m1);
        assertTrue(m != m2);
        assertTrue(m1.getDollars() == 12);
        assertTrue(m2.getDollars() == 34);
        assertTrue(m.getDollars() == 22);
        assertTrue(m1.getCents() == 23);
        assertTrue(m2.getCents() == 45);
        assertTrue(m.getCents() == 22);
    }

    @Test
    public void testSubtractFlipPos() {
        m1 = new Money(-1L, (byte) -99);
        m2 = new Money(2L, (byte) 6);
        Money m = m2.subtract(m1);
        assertTrue(m != m1);
        assertTrue(m != m2);
        assertTrue(m1.getDollars() == -1);
        assertTrue(m2.getDollars() == 2);
        assertTrue(m.getDollars() == 4);
        assertTrue(m1.getCents() == -99);
        assertTrue(m2.getCents() == 6);
        assertTrue(m.getCents() == 5);
    }

    @Test
    public void testSubtractNeg() {
        Money m = m1.subtract(m2);
        assertTrue(m != m1);
        assertTrue(m != m2);
        assertTrue(m1.getDollars() == 12);
        assertTrue(m2.getDollars() == 34);
        assertTrue(m.getDollars() == -22);
        assertTrue(m1.getCents() == 23);
        assertTrue(m2.getCents() == 45);
        assertTrue(m.getCents() == -22);
    }

    @Test
    public void testSubtractFlipNeg() {
        m1 = new Money(-1L, (byte) -99);
        m2 = new Money(2L, (byte) 6);
        Money m = m1.subtract(m2);
        assertTrue(m != m1);
        assertTrue(m != m2);
        assertTrue(m1.getDollars() == -1);
        assertTrue(m2.getDollars() == 2);
        assertTrue(m.getDollars() == -4);
        assertTrue(m1.getCents() == -99);
        assertTrue(m2.getCents() == 6);
        assertTrue(m.getCents() == -5);
    }

    /**
     * Test of equal method, of class Money.
     */
    @Test
    public void testEqual() {
        assertEquals(true, m1.equals(m1));
        assertEquals(false, m1.equals(m2));
    }

    /**
     * Test of toString method, of class Money.
     */
    @Test
    public void testToString() {
        assertEquals(m1.toString(), "$12.23");
        assertEquals(m4.toString(), "-$56.67");
        assertEquals(m1.toString(), m3.toString());
        assertEquals((new Money(0L, (byte) 0)).toString(), "$0.00");
        assertEquals((new Money(0L, (byte) 5)).toString(), "$0.05");
        assertEquals((new Money(0L, (byte) 50)).toString(), "$0.50");
    }

    /**
     * Test of copy method, of class Money.
     */
    @Test
    public void testCopy() {
        Money m = m1;
        Money mm = m1.copy();
        assertEquals(m.equals(mm), true);
        assertEquals(m2.equals(mm), false);
    }

    /**
     * Test of compareTo method, of class Complex.
     */
    @Test
    public void testCompareTo() {
        assertEquals(0, m1.compareTo(m3));
        assertEquals(90.0, m2.compareTo(m4), 0);
    }

}
