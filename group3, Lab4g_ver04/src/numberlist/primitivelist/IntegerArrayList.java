package numberlist.primitivelist;

import java.io.Serializable;
import numberlist.IndexException;

/**
 * This class inherit from LongArrayList, and create three new methods
 *
 * @author Giovanna Chintya Susanto
 * @author Lok Hei Gee
 * @author Jason Christian Limpah
 * @author Feny Graciella Dai
 * @version 3/6/2021
 */
public class IntegerArrayList extends LongArrayList implements Serializable {

    /**
     * Inserts at the end of the list and return the index it was inserted at
     *
     * @param value the value want to store in
     * @return the index of the saving value
     */
    public int add(long value) {
        try {
            super.add(super.getCount(), value);
        } catch (IndexException ie) {
            //this should never happen
        }
        return super.getCount() - 1;
    }

    /**
     * Deletes all instances of the value from the list
     *
     * @param value the value want to remove
     */
    public void removeAll(long value) {
        try {
            for (int i = getCount() - 1; i >= 0; i--) {
                if (getValue(i) == value) {
                    remove(i);
                }
            }
        } catch (IndexException ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * Returns the index of the last element in the list that contains the
     * value, or -1 if the value does not exist
     *
     * @param value the value want to find
     * @return the last index of the finding value
     */
    public int findLastIndex(long value) {
        try {
            int index = -1;
            for (int i = 0; i < super.getCount(); i++) {
                if (super.getValue(i) == value) {
                    index = i;
                }
            }
            return index;

        } catch (IndexException ie) {
            //This should never happen
        }
        return -1;
    }
}
