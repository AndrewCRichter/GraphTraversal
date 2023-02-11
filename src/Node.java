public class Node
{
    private int id;
    private Node next;
    public Node(int id)
    {
        this.id = id;
        next = null;
    }
    public int getID()
    {
        return id;
    }
    public Node getNext()
    {
        return next;
    }
    public void setNext(Node next)
    {
        this.next = next;
    }
}
