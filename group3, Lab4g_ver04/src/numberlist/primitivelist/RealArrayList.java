package numberlist.primitivelist;

import java.io.Serializable;
import numberlist.IndexException;

/**
 * This class provides a growable array for primitive real values.
 *
 * @author Giovanna Chintya Susanto
 * @author Lok Hei Gee
 * @author Jason Christian Limpah
 * @author Feny Graciella Dai
 * @version 3/6/2021
 */
public class RealArrayList extends DoubleArrayList implements Serializable {

    /**
     * Inserts the given double value at the end of the list and return the
     * index where the value was inserted at.
     *
     * @param value the value to be stored
     * @return the index where the value was stored inside the array
     */
    public int add(double value) {
        try {
            add(getCount(), value);
        } catch (IndexException ex) {
            System.out.println(ex.getMessage());
        }
        return getCount() - 1;
    }

    /**
     * Deletes all the instance of the value from the list.
     *
     * @param value the value to be removed from the list.
     */
    public void removeAll(double value) {
        for (int i = getCount(); i > -1; i--) {
            try {
                if (getValue(i) == value) {
                    remove(i);
                }
            } catch (IndexException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    /**
     * Return the last index of the last value in the list that contains the
     * value, or -1 if the value does not exist.
     *
     * @param value the value to be found in the list
     * @return the index of where the last value in the list is found or -1 if
     * not found.
     */
    public int findLastIndex(double value) {
        for (int i = getCount() - 1; i > -1; i--) {
            try {
                if (value == getValue(i)) {
                    return i;
                }
            } catch (IndexException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return -1;
    }
}
