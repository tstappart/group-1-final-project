package numberlist.primitivelist;

import java.io.Serializable;
import numberlist.IndexException;

/**
 * This class provides a growable array for primitive double values.
 *
 * @author Giovanna Chintya Susanto
 * @author Lok Hei Gee
 * @author Jason Christian Limpah
 * @author Feny Graciella Dai
 * @version 3/6/2021
 */
public class DoubleArrayList implements Serializable {

    //field
    private LongArrayList list;

    /**
     * Constructor. Initializes the underlying array to 10 elements using
     * composition from LongArrayList class.
     */
    public DoubleArrayList() {
        this.list = new LongArrayList();
    }

    /**
     * Inserts the given double value at the given index.The index is assumed to
     * be a value between 0 and count. Existing elements are moved up as needed
     * to make room for the new value.
     *
     * @param index the index where the new value should be stored
     * @param value the value to be stored
     * @throws numberlist.IndexException
     */
    public void add(int index, double value) throws IndexException {
        list.add(index, Double.doubleToRawLongBits(value));

    }

    /**
     * Deletes the value at the given index.The index is assumed to be a value
     * between 0 and count - 1. Existing elements are moved down as needed to
     * keep all values contiguous, without any empty spaces in the array.
     *
     * @param index the index of the element that should be removed
     * @return the value that was removed
     * @throws numberlist.IndexException
     */
    public double remove(int index) throws IndexException {
        return Double.longBitsToDouble(list.remove(index));
    }

    /**
     * Deletes the first instance of the given value. Existing elements are
     * moved down as needed to keep all values contiguous, without any empty
     * spaces in the array. If the value does not exist, this method returns
     * without doing anything.
     *
     * @param value the value to remove
     */
    public void remove(double value) {
        list.remove(Double.doubleToRawLongBits(value));
    }

    /**
     * Returns the value at the given index without removing it.The index is
     * assumed to be a value between 0 and count - 1.
     *
     * @param index the index of the element
     * @return the value at that index
     * @throws numberlist.IndexException
     */
    public double getValue(int index) throws IndexException {
        return Double.longBitsToDouble(list.getValue(index));
    }

    /**
     * Returns the index of the first instance of the given value in the array.
     * If the value doesn't exist, -1 is returned.
     *
     * @param value the value to find in the array
     * @return the index where the value was found, or -1 if not found
     */
    public int findFirstIndex(double value) {
        return list.findFirstIndex(Double.doubleToRawLongBits(value));
    }

    /**
     * Provides access to the number of values currently in the array.
     *
     * @return the number of values in the array
     */
    public int getCount() {
        return list.getCount();
    }

    /**
     * Provides a string representation of the growable array, displaying all
     * values currently in the array using the format [ value1, value2, ... ].
     *
     * @return the string representation of the array
     */
    @Override
    public String toString() {
        String output = "[ ";
        try {
            for (int i = 0; i < list.getCount(); i++) {
                output += Double.longBitsToDouble(list.getValue(i)) + ", ";
            }
            if (list.getCount() > 0) {
                output = output.substring(0, output.length() - 2);
            } else {
                output = output.substring(0, output.length() - 1);
            }
            output += " ]";
        } catch (IndexException ex) {
            System.out.println(ex.getMessage());
        }
        return output;
    }

    /**
     * Replaces the value at the given index with the given value.
     *
     * @param index the index where the value was replaced
     * @param value the given value
     * @return the value that was replaced.
     * @throws numberlist.IndexException
     */
    public double set(int index, double value) throws IndexException {
        return Double.longBitsToDouble(list.set(index,
                Double.doubleToRawLongBits(value)));
    }
}
