package numberlist.primitivelist;

import java.io.Serializable;
import numberlist.IndexException;

/**
 * This class provides a growable array for primitive long values.
 *
 * @author Giovanna Chintya Susanto
 * @author Lok Hei Gee
 * @author Jason Christian Limpah
 * @author Feny Graciella Dai
 * @version 3/6/2021
 */
class LongArrayList implements Serializable {

    //fields
    private long[] list;
    private int count;

    /**
     * Constructor. Initializes the underlying array to 10 elements.
     */
    LongArrayList() {
        list = new long[10];
        count = 0;
    }

    /**
     * Inserts the given long value at the given index. Existing elements are
     * moved up as needed to make room for the new value.
     *
     * @param index the index where the new value should be stored
     * @param value the value to be stored
     * @throws numberlist.IndexException
     */
    public void add(int index, long value) throws IndexException {
        if (index < 0 || index > count) {
            throw new IndexException(0, count, index);
        } else {
            if (list[list.length - 1] > 0) {
                long[] growList = new long[list.length * 2];
                for (int i = 0; i < list.length; i++) {
                    growList[i] = list[i];
                }
                list = growList;
            }
            for (int i = list.length - 1; i >= index; i--) {
                if (list[i] > 0) {
                    list[i + 1] = list[i];
                    list[i] = 0L;
                }
            }
            list[index] = value;
            count++;
        }
    }

    /**
     * Replaces the value at the given index with the given value.
     *
     * @param index the index where the value was replaced
     * @param value the given value
     * @return the value that was replaced.
     * @throws numberlist.IndexException
     */
    public long set(int index, long value) throws IndexException {
        if (index > count - 1 || index < 0) {
            throw new IndexException(-1, -1, index);
        }
        long replace = list[index];
        list[index] = value;
        return replace;
    }

    /**
     * Deletes the value at the given index. Existing elements are moved down as
     * needed to keep all values contiguous, without any empty spaces in the
     * array.
     *
     * @param index the index of the element that should be removed
     * @return the value that was removed
     * @throws numberlist.IndexException
     */
    public long remove(int index) throws IndexException {
        if (index < 0 || index >= count) {
            throw new IndexException(0, count - 1, index);
        }
        long removed = list[index];
        for (int i = index; i < list.length - 1; i++) {
            list[i] = list[i + 1];
        }
        count--;
        return removed;
    }

    /**
     * Deletes the first instance of the given value. Existing elements are
     * moved down as needed to keep all values contiguous, without any empty
     * spaces in the array. If the value does not exist, this method returns
     * without doing anything.
     *
     * @param value the value to remove
     */
    public void remove(long value) {
        int index = findFirstIndex(value);
        try {
            if (index != -1) {
                remove(index);
            }
        } catch (IndexException ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * Returns the value at the given index without removing it.
     *
     * @param index the index of the element
     * @return the value at that index
     * @throws numberlist.IndexException
     */
    public long getValue(int index) throws IndexException {
        if (index < 0 || index >= count) {
            throw new IndexException(0, count - 1, index);
        } else {
            return list[index];
        }
    }

    /**
     * Returns the index of the first instance of the given value in the array.
     * If the value doesn't exist, -1 is returned.
     *
     * @param value the value to find in the array
     * @return the index where the value was found, or -1 if not found
     */
    public int findFirstIndex(long value) {
        for (int i = 0; i < count; i++) {
            if (value == list[i]) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Provides access to the number of values currently in the array.
     *
     * @return the number of values in the array
     */
    public int getCount() {
        return count;
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
        for (int i = 0; i < count; i++) {
            output += list[i] + ", ";
        }
        if (count > 0) {
            output = output.substring(0, output.length() - 2);
        } else {
            output = output.substring(0, output.length() - 1);
        }
        output += " ]";
        return output;
    }

}
