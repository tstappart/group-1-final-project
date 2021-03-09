package numberlist;

/**
 * This class provides an exception if index is out of range
 *
 * @author Giovanna Chintya Susanto
 * @author Lok Hei Gee
 * @author Jason Christian Limpah
 * @author Feny Graciella Dai
 * @version 3/6/2021
 */
public class IndexException extends Exception {

    //fields
    private int min;
    private int max;
    private int value;

    /**
     * Constructor
     *
     * @param min the minimum index of the array
     * @param max the maximum index of the array
     * @param value the index of the element that user sent
     */
    public IndexException(int min, int max, int value) {
        super("Invalid Index. Index should be between " + min + " and " + max);
        this.min = min;
        this.max = max;
        this.value = value;
    }

    /**
     * Provides access to the minimum value of index
     *
     * @return the minimum value of index
     */
    public int getMin() {
        return min;
    }

    /**
     * Provides access to the maximum value of index
     *
     * @return the maximum value of index
     */
    public int getMax() {
        return max;
    }

    /**
     * Provides the value at a given index
     *
     * @return the value at that index
     */
    public int getValue() {
        return value;
    }
}
