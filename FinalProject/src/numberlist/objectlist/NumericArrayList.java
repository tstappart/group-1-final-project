package numberlist.objectlist;

import java.io.Serializable;
import numberlist.IndexException;

/**
 * This class provides a growable array for primitive object values.
 *
 * @author Giovanna Chintya Susanto
 * @author Lok Hei Gee
 * @author Jason Christian Limpah
 * @author Feny Graciella Dai
 * @version 3/6/2021
 */
public class NumericArrayList extends NumericList implements Copiable,
        Serializable {

    //field
    private Copiable[] list;

    /**
     * Constructor. Initializes the underlying array to 10 elements.
     */
    public NumericArrayList() {
        list = new Copiable[10];
    }

    /**
     * Inserts the given object value at the given index.Existing elements are
     * moved up as needed to make room for the new value.
     *
     * @param index the index where the new value should be stored
     * @param obj the object to be stored
     * @throws numberlist.IndexException
     */
    @Override
    public void add(int index, Copiable obj) throws IndexException {
        if (index < 0 || index > getCount()) {
            throw new IndexException(0, count, index);
        } else {
            if (list[list.length - 1] != null) {
                Copiable[] growList = new Copiable[list.length * 2];
                for (int i = 0; i < list.length; i++) {
                    growList[i] = list[i];
                }
                list = growList;
            }
            for (int i = count - 1; i >= index; i--) {
                list[i + 1] = list[i];
            }
            list[index] = obj;
            count++;
        }
    }

    /**
     * It replaces the value at the given index with the given value. It also
     * returns the value that was replaced.
     *
     * @param index index where the value needs to be set
     * @param obj the replacement value
     * @return the value that was replaced.
     * @throws numberlist.IndexException
     */
    @Override
    Copiable set(int index, Copiable obj) throws IndexException {
        if (index < 0 || index >= count) {
            throw new IndexException(-1, -1, index);
        }
        Copiable removed = list[index];
        list[index] = obj;
        return removed;
    }

    /**
     * Deletes the value at the given index. Existing elements are moved down as
     * needed to keep all values contiguous, without any empty spaces in the
     * array.
     *
     * @param index the index of the element that should be removed
     * @return the object that was removed
     * @throws numberlist.IndexException
     */
    @Override
    public Copiable remove(int index) throws IndexException {
        if (index < 0 || index >= getCount()) {
            throw new IndexException(0, count - 1, index);
        } else {
            Copiable obj = list[index];
            for (int i = 0; i < list.length; i++) {
                if (i > index) {
                    list[i - 1] = list[i];
                }
                if (i > count - 1) {
                    list[i] = null;
                }
            }
            count--;
            return obj;
        }
    }

    /**
     * Deletes the first instance of the given value. Existing elements are
     * moved down as needed to keep all values contiguous, without any empty
     * spaces in the array. If the value does not exist, this method returns
     * without doing anything.
     *
     * @param obj the value to remove
     */
    @Override
    public void remove(Copiable obj) {
        int index = findFirstIndex(obj);
        if (index != -1) {
            try {
                remove(index);
            } catch (IndexException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    /**
     * Returns the value at the given index without removing it.
     *
     * @param index the index of the element
     * @return the object at that index
     * @throws numberlist.IndexException
     */
    @Override
    public Copiable getValue(int index) throws IndexException {
        if (index < 0 || index >= getCount()) {
            throw new IndexException(0, count - 1, index);
        } else {
            return list[index];
        }
    }

    /**
     * Returns the index of the first instance of the given value in the array.
     * If the value doesn't exist, -1 is returned.
     *
     * @param obj the Object to find in the array
     * @return the index where the value was found, or -1 if not found
     */
    @Override
    public int findFirstIndex(Copiable obj) {
        for (int i = 0; i < count; i++) {
            if (list[i].equals(obj)) {
                return i;
            }
        }
        return -1;
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
        if (getCount() > 0) {
            output = output.substring(0, output.length() - 2);
        } else {
            output = output.substring(0, output.length() - 1);
        }
        output += " ]";
        return output;
    }

    /**
     * This method is to make a deep copy for NumericArrayList
     *
     * @return copy, which is NumericArrayList's deep copy
     */
    @Override
    public NumericArrayList copy() {
        NumericArrayList copy = new NumericArrayList();
        try {
            for (int i = 0; i < count; i++) {
                copy.add(i, list[i].copy());
            }
        } catch (IndexException ex) {
            System.out.println(ex.getMessage());
        }
        return copy;
    }
}
