package numberlist.objectlist;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.MathContext;

/**
 * This class represents a single complex number of the form x + yi.
 *
 * @author Giovanna Chintya Susanto
 * @author Lok Hei Gee
 * @author Jason Christian Limpah
 * @author Feny Graciella Dai
 * @version 3/6/2021
 */
public final class Complex implements Comparable<Complex>, Copiable,
        Serializable {

    //fields
    private double real;
    private double imaginary;

    /**
     * Default constructor. Creates a new Complex object. Sets both real and
     * imaginary to zero.
     */
    public Complex() {
        real = 0;
        imaginary = 0;
    }

    /**
     * Full constructor. Creates a new Complex object.
     *
     * @param real the value of the real portion of the complex number
     * @param imaginary the value of the imaginary portion of the complex number
     */
    public Complex(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    /**
     * Provides access to the real portion of the complex number
     *
     * @return the value of the real portion of the complex number
     */
    public double getReal() {
        return real;
    }

    /**
     * Provides access to the imaginary portion of the complex number
     *
     * @return the value of the imaginary portion of the complex number
     */
    public double getImaginary() {
        return imaginary;
    }

    /**
     * Adds the current and the given complex numbers together, and stores the
     * sum in a new Complex object. The current and given complex numbers are
     * not altered in the process.
     *
     * @param other the other complex number to add to this one
     * @return the new Complex object that holds the result of the addition
     */
    public Complex add(Complex other) {
        Complex newComplex = new Complex(real + other.real, imaginary
                + other.imaginary);
        return newComplex;
    }

    /**
     * Subtracts the other complex number from this one, and stores the result
     * in a new Complex object. The current and given complex numbers are not
     * altered in the process.
     *
     * @param other the other complex number to subtract from this one
     * @return the new Complex object that holds the result of the subtraction
     */
    public Complex subtract(Complex other) {
        Complex newComplex = new Complex(real - other.real, imaginary
                - other.imaginary);
        return newComplex;
    }

    /**
     * This method is supported for the benefit of hash tables such as those
     * provided by HashMap.
     *
     * @return a hash code value for this object
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + (int) (Double.doubleToLongBits(this.real)
                ^ (Double.doubleToLongBits(this.real) >>> 32));
        hash = 79 * hash + (int) (Double.doubleToLongBits(this.imaginary)
                ^ (Double.doubleToLongBits(this.imaginary) >>> 32));
        return hash;
    }

    /**
     * The equals method for class Object implements the most discriminating
     * possible equivalence relation on objects; that is, for any non-null
     * reference values x and y, this method returns true if and only if x and y
     * refer to the same object (x == y has the value true).
     *
     * @param obj the reference object with which to compare
     * @return true if the arguments are equal to each other and false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Complex other = (Complex) obj;
        if (Double.doubleToLongBits(this.real)
                != Double.doubleToLongBits(other.real)) {
            return false;
        }
        if (Double.doubleToLongBits(this.imaginary)
                != Double.doubleToLongBits(other.imaginary)) {
            return false;
        }
        return true;
    }

    /**
     * Provides a string representation of the current complex number, in the
     * form x + yi.
     *
     * @return the string representation of the current complex number
     */
    @Override
    public String toString() {
        BigDecimal bd = new BigDecimal(real);
        bd = bd.round(new MathContext(2));
        real = bd.doubleValue();
        bd = new BigDecimal(imaginary);
        bd = bd.round(new MathContext(2));
        imaginary = bd.doubleValue();
        if (imaginary == 0) {
            return real + "";
        }
        if (real == 0) {
            return imaginary + "i";
        }
        if (imaginary < 0) {
            return real + " - " + (-imaginary) + "i";
        }
        return real + " + " + imaginary + "i";
    }

    /**
     * This method is to make a deep copy for Complex
     *
     * @return copy which is Complex's deep copy
     */
    @Override
    public Complex copy() {
        Complex copy = new Complex(getReal(), getImaginary());
        return copy;
    }

    /**
     * This method is to compare two different Complex numbers
     *
     * @param other the other complex number
     * @return 0 if both complex numbers are identical, -1 if this complex is
     * smaller than the other complex and 1 if this complex is larger than the
     * other complex.
     */
    @Override
    public int compareTo(Complex other) {
        if (this.real - other.real == 0) {
            return (int) (this.imaginary - other.imaginary);
        } else {
            return (int) (this.real - other.real);
        }
    }

}
