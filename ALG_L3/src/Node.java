/** class Node for the implementation of simple linked list. The node
 * contains only an item and a reference to the following Node
 * 
 * @Alec Howard
 */

public class Node<E> {

    /** Object contained in the Node */
    private E item;
    /** reference to the following node */
    private Node<E> next;
    private Node<E> prev; //Set up prev statement

    /** Contructor: create a new Node containing the specified item
     * @param newItem the item encapsulated in the node
     */
    public Node(E newItem, Node<E> head) {
	item = newItem;
	next = null;
	prev = null;
	
	
	 //Editing constructor to include prev
    } // end constructor

    /** Constructor: creates a new Node containing the specified item
     * and links this node to the specified node: this -> nextNode
     * @param newItem the item encapsulated in the node
     * @param nextNode the successor node of this node.
     */
    public Node(E newItem, Node<E> prevNode, Node<E> nextNode) {
	item = newItem;
	prev = prevNode;
	next = nextNode;
    } // end constructor
    

    /** set the item in the node
     * @param newItem the new item to be encapsulated in the node.
     */
    public void setItem(E newItem) {
	item = newItem;
    } // end setItem
    
    /** get the item encapsulated in the node
     * @return the object encapsulated in the node
     */
    public E getItem() {
	return item;
    } // end getItem
    
    /** set the reference to the following node
     * @param new following node */
    public void setNext(Node<E> nextNode) {
	next = nextNode;
    } // end setNext
    
    public void setPrev(Node<E> prevNode) { //Created Setter for Prev
    	prev = prevNode;
    }// end SetPrev

    /** get the following node
     * @returns the following node
     */
    public Node<E> getNext() {
	return next;
    } // end getNext
    
    public Node<E> getPrev() { // Created Getter for Prev
    	return prev;
    } // end getPrev

} // end class Node