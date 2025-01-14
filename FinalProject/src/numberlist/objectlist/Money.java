package numberlist.objectlist;

import java.io.Serializable;

/**
 * This class represents a single monetary value in U.S. dollars and cents.
 *
 * @author Octavia Stappart
 * @author Kirtiashna Chandra
 * @date 03/06/2021
 * @version 1.0
 */
public final class Money implements Copiable, Comparable<Money>, Serializable {

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

    public Money divide(int divisor) {
        long value = dollars * 100;
        value += cents;
        long result = value / divisor;
        return new Money(result/ 100, (byte) (result % 100));
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

        String output;
        if (dollars < 0 || cents < 0) {
            output = String.format("-$%d.%2d", Math.abs(dollars), Math.abs(cents));
        } else {
            output = String.format("$%d.%02d", dollars, cents);
        }
        return output;
    }

    /**
     * Tests whether two Money objects are equal. This method determines if two
     * distinct Money objects have the same contents.
     *
     * @param other the object to evaluate
     * @return true if the objects have identical content, else false
     */
    @Override
    public boolean equals(Object other) {
        if (other instanceof Money) {
            return (dollars == ((Money) other).dollars && cents == ((Money) other).cents);
        } else {
            return false;
        }
    }

    /**
     * This method overrides the hashCode method due to the use of the
     * overridden Object equals method. This method determines if two equal
     * objects return the same hash code.
     *
     * @return the hash code
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + (int) (this.dollars ^ (this.dollars >>> 32));
        hash = 17 * hash + this.cents;
        return hash;
    }

    /**
     * Returns a deep copy of a Money object. Implements the copy() method from
     * the Copiable interface.
     *
     * @return a deep copy of the Money object
     */
    @Override
    public Money copy() {
        Money newMoney = new Money(this.getDollars(), this.getCents());
        return newMoney;
    }

    /**
     * Compares two Money objects. Returns -1 if the object is less than the
     * other value, 0 if equal, and 1 if greater than.
     *
     * @param other
     * @return -1 if less, 0 if equal, 1 if greater
     */
    @Override
    public int compareTo(Money other) {
        long value = this.dollars * 100 + this.cents;
        long oValue = other.dollars * 100 + other.cents;
        if (value < oValue) {
            return -1;
        }
        if (value == oValue) {
            return 0;
        } else {
            return 1;
        }
    }
}
