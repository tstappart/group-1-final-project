package numberlist.objectlist;

import java.io.Serializable;
import numberlist.IndexException;

/**
 * This class is a linked class for the Numeric Array
 *
 * @author Giovanna Chintya Susanto
 * @author Lok Hei Gee
 * @author Jason Christian Limpah
 * @author Feny Graciella Dai
 * @version 3/6/2021
 */
public class NumericLinkedList extends NumericList implements Copiable,
        Serializable {

    //field
    private Node firstNode;

    /**
     * Default Constructor.
     *
     */
    public NumericLinkedList() {
        this.firstNode = null;
    }

    /**
     * Inserts the given object value at the given index. Existing elements are
     * moved up as needed to make room for the new value.
     *
     * @param index the index where the new value should be stored
     * @param obj the object to be stored
     * @throws numberlist.IndexException
     */
    @Override
    public void add(int index, Copiable obj) throws IndexException {
        if (index < 0 || index > count) {
            throw new IndexException(0, super.count, index);
        }
        Node newNode = new Node(obj);
        if (index == 0) {
            newNode.setNextNode(firstNode);
            firstNode = newNode;
        } else {
            Node currentNode = firstNode;
            for (int i = 0; i < index - 1; i++) {
                currentNode = currentNode.getNextNode();
            }
            newNode.setNextNode(currentNode.getNextNode());
            currentNode.setNextNode(newNode);
        }
        count++;
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
        if (index < 0 || index >= count) {
            throw new IndexException(0, super.count - 1, index);
        }
        if (index == 0) {
            Node removed = firstNode;
            Node nextNode = removed.getNextNode();
            firstNode = nextNode;
            count--;
            return removed.getValue();
        } else {
            Node currentNode = firstNode;
            Node targetNode;
            for (int i = 0; i < index - 1; i++) {
                currentNode = currentNode.getNextNode();
            }
            targetNode = currentNode.getNextNode();
            currentNode.setNextNode(targetNode.getNextNode());
            count--;
            return targetNode.getValue();
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
        int index = this.findFirstIndex(obj);
        try {
            this.remove(index);
        } catch (IndexException ex) {
            System.out.println(ex.getMessage());
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
        if (index < 0 || index >= count) {
            throw new IndexException(0, super.count - 1, index);
        }
        Node currentNode = firstNode;
        for (int i = 1; i <= index; i++) {
            currentNode = currentNode.getNextNode();
        }
        return currentNode.getValue();
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
        Node currentNode = firstNode;
        for (int i = 0; i < count; i++) {
            if (currentNode.getValue().equals(obj)) {
                return i;
            }
            currentNode = currentNode.getNextNode();
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
        Node current = firstNode;

        String listName = "[ ";
        for (int i = 0; i < count; i++) {
            listName += current.getValue().toString() + ", ";
            current = current.getNextNode();
        }
        if (getCount() > 0) {
            listName = listName.substring(0, listName.length() - 2);
        } else {
            listName = listName.substring(0, listName.length() - 1);
        }
        listName += " ]";
        return listName;
    }

    /**
     * Replaces the value at the given index with the given value.
     *
     * @param index the index where the value was replaced
     * @param obj the given value
     * @return the value that was replaced.
     * @throws numberlist.IndexException
     */
    @Override
    public Copiable set(int index, Copiable obj) throws IndexException {
        if (index < 0 || index >= count) {
            throw new IndexException(-1, -1, index);
        }
        Node currentNode = firstNode;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.getNextNode();
        }
        Copiable removedValue = currentNode.getValue();
        currentNode.setValue(obj);
        return removedValue;
    }

    /**
     * This method is to make a deep copy for NumericLinkedList
     *
     * @return copy, which is NumericLinkedList's deep copy
     */
    @Override
    public NumericLinkedList copy() {
        NumericLinkedList copy = new NumericLinkedList();
        try {
            Node currentNode = firstNode;
            copy.add(0, currentNode.getValue().copy());
            for (int i = 1; i < count; i++) {
                currentNode = currentNode.getNextNode();
                copy.add(i, currentNode.getValue().copy());
            }
        } catch (IndexException ex) {
            System.out.println(ex.getMessage());
        }
        return copy;
    }
}
