public class Node
{
    private final int id;
    private Node next;
    // Constructor for Node
    public Node(int id)
    {
        this.id = id;
        next = null;
    }
    // Return the Node ID
    public int getID()
    {
        return id;
    }
    // Return the Next node
    public Node getNext()
    {
        return next;
    }
    // Set the Next Node
    public void setNext(Node next)
    {
        this.next = next;
    }
}
