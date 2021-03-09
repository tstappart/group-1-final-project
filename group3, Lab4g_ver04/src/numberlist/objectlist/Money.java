package numberlist.objectlist;

import java.io.Serializable;

/**
 * This class represents a single monetary value in U.S. dollars and cents.
 *
 * @author Giovanna Chintya Susanto
 * @author Lok Hei Gee
 * @author Jason Christian Limpah
 * @author Feny Graciella Dai
 * @version 3/6/2021
 */
public final class Money implements Comparable<Money>, Copiable, Serializable {

    //fields
    private long dollars;
    private byte cents;

    /**
     * Default constructor. Creates a new Money object. Sets both dollars and
     * cents to zero.
     */
    public Money() {
        dollars = 0;
        cents = 0;
    }

    /**
     * Full constructor. Creates a new Money object. Dollars and cents are
     * normalized. If one is negative and the other is positive, the resulting
     * object will be the natural addition of the two values. (Example: 2
     * dollars and -5 cents is converted to 1 dollar and 95 cents.) If the
     * absolute value of cents is greater than 99, the resulting object will
     * carry the extra cents into the dollars. (Example: 1 dollar and 105 cents
     * is converted to 2 dollars and 5 cents.) A negative value is represented
     * with both the dollars and cents negative.
     *
     * @param dollars the number of dollars in the amount
     * @param cents the number of cents in the amount
     */
    public Money(long dollars, byte cents) {
        long value = dollars * 100;
        value += cents;
        this.dollars = value / 100;
        this.cents = (byte) (value % 100);
    }

    /**
     * Provides access to the dollars portion of the monetary value.
     *
     * @return the dollars portion of this Money object
     */
    public long getDollars() {
        return dollars;
    }

    /**
     * Provides access to the cents portion of the monetary value.
     *
     * @return the cents portion of this Money object
     */
    public byte getCents() {
        return cents;
    }

    /**
     * Adds the current and the given Money objects together, and stores the sum
     * in a new Money object. The current and given Money objects are not
     * altered in the process. The resulting Money object's dollars and cents
     * are normalized as defined in the full constructor comments.
     *
     * @param other the other Money object to add to this one
     * @return the Money object containing the results of this addition
     */
    public Money add(Money other) {
        long value = dollars * 100;
        value += cents;
        long oValue = other.dollars * 100;
        oValue += other.cents;
        long result = value + oValue;
        return new Money(result / 100, (byte) (result % 100));
    }

    /**
     * Subtracts the given Money object from this one, and stores the result in
     * a new Money object. The current and given Money objects are not altered
     * in the process. The resulting Money object's dollars and cents are
     * normalized as defined in the full constructor comments.
     *
     * @param other the other Money object to subtract from this one
     * @return the Money object containing the results of this subtraction
     */
    public Money subtract(Money other) {
        long value = dollars * 100;
        value += cents;
        long oValue = other.dollars * 100;
        oValue += other.cents;
        long result = value - oValue;
        return new Money(result / 100, (byte) (result % 100));
    }

    /**
     * This method is supported for the benefit of hash tables such as those
     * provided by HashMap.
     *
     * @return a hash code value for this object
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + (int) (this.dollars ^ (this.dollars >>> 32));
        hash = 29 * hash + this.cents;
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
        final Money other = (Money) obj;
        if (this.dollars != other.dollars) {
            return false;
        }
        if (this.cents != other.cents) {
            return false;
        }
        return true;
    }

    /**
     * Provides a string representation of the current Money object, in the form
     * $mm.mm. Negative values have a minus sign before the dollar sign. Zero
     * dollar amounts are represented with one zero between the dollar sign and
     * the decimal point. Cents that are multiples of 10 still show two decimal
     * places. (Examples: $12.34, -$6.50, $0.99, -$0.99, $0.00)
     *
     * @return the string representation
     */
    @Override
    public String toString() {
        String moneyText = Math.abs(dollars) + "."
                + String.format("%02d", Math.abs(cents));
        if (dollars >= 0) {
            return "$" + moneyText;
        } else {
            return "-$" + moneyText;
        }
    }

    /**
     * This method is to make a deep copy for Money
     *
     * @return copy which is Money's deep copy
     */
    @Override
    public Money copy() {
        Money copy = new Money(getDollars(), getCents());
        return copy;
    }

    /**
     * This method is to compare two different Money objects
     *
     * @param other the other complex number
     * @return 0 if both money objects are identical, -1 if this money  is
     * smaller than the other complex and 1 if this money is larger than the
     * other complex.
     */
    @Override
    public int compareTo(Money other) {
        if (this.dollars - other.dollars == 0) {
            return (int) (this.cents - other.cents);
        } else {
            return (int) (this.dollars - other.dollars);
        }
    }
}
