package numberlist.objectlist;

import java.io.Serializable;

/**
 * This class represents the node, to link values together in lists using
 * references.
 *
 * @author Giovanna Chintya Susanto
 * @author Lok Hei Gee
 * @author Jason Christian Limpah
 * @author Feny Graciella Dai
 * @version 3/6/2021
 */
class Node implements Serializable {

    //fields
    private Node nextNode;
    private Copiable value;

    /**
     * Constructor. Initializes the value.
     */
    public Node(Copiable obj) {
        this.value = obj;
        nextNode = null;
    }

    /**
     * Provides access to the value
     *
     * @return the value of the value
     */
    public Copiable getValue() {
        return value;
    }

    /**
     * Allows the value to be set
     *
     * @param value value to set value to
     */
    public void setValue(Copiable value) {
        this.value = value;
    }

    /**
     * Provides access to the nextNode
     *
     * @return the value of the nextNode
     */
    public Node getNextNode() {
        return nextNode;
    }

    /**
     * Allows the nextNode to be set
     *
     * @param nextNode value to set nextNode to
     */
    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }

}
