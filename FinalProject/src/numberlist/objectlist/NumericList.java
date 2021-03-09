package numberlist.objectlist;

import java.io.Serializable;
import numberlist.IndexException;

/**
 * This class is an abstract class for numeric list
 *
 * @author Giovanna Chintya Susanto
 * @author Lok Hei Gee
 * @author Jason Christian Limpah
 * @author Feny Graciella Dai
 * @version 3/6/2021
 */
abstract class NumericList implements Serializable {

    //field
    int count;

    /**
     * This is an abstract method for add
     *
     * @param index where we want to save
     * @param obj the information we want to save
     * @throws numberlist.IndexException
     */
    abstract void add(int index, Copiable obj) throws IndexException;

    /**
     * This method add the obj into the end of the list
     *
     * @param obj the Object of the information which want to save in
     * @return return an integer about where the obj save
     * @throws numberlist.IndexException
     */
    public int add(Copiable obj) throws IndexException {
        add(count, obj);
        return count - 1;
    }

    /**
     * This is an abstract method for set
     *
     * @param index the index where the value was replaced
     * @param obj the given value
     * @return the value that was replaced.
     * @throws numberlist.IndexException
     */
    abstract Copiable set(int index, Copiable obj) throws IndexException;

    /**
     * This is an abstract method for remove
     *
     * @param index the index of where we want to remove
     * @return return the Object for what we remove
     * @throws numberlist.IndexException
     */
    abstract Object remove(int index) throws IndexException;

    /**
     * This is an abstract method for remove
     *
     * @param obj the Object of what we want to remove
     */
    abstract void remove(Copiable obj);

    /**
     * This is an abstract method for add
     *
     * @param index the index for the information we want to find
     * @return return an Object for what we find
     * @throws numberlist.IndexException
     */
    abstract Object getValue(int index) throws IndexException;

    /**
     * This is an abstract method for finding the first index
     *
     * @param obj the Object we want to find
     * @return an integer for the first index of what we want to find
     */
    abstract int findFirstIndex(Copiable obj);

    /**
     * This method return the count for the list
     *
     * @return an integer for the list count
     */
    public int getCount() {
        return count;
    }
}
