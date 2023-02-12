

public class Graph
{
    private int numNodes;
    private Node nodes[];
    private boolean unfound[];
    Node searchQueueStart;
    Node searchQueueEnd;

    public Graph()
    {
        this(8);
        this.addConnection(1, 3);
        this.addConnection(2, 1);
        this.addConnection(2, 3);
        this.addConnection(2, 4);
        this.addConnection(2, 5);
        this.addConnection(3, 1);
        this.addConnection(3, 2);
        this.addConnection(3, 5);
        this.addConnection(3, 7);
        this.addConnection(3, 8);
        this.addConnection(4, 2);
        this.addConnection(4, 5);
        this.addConnection(5, 2);
        this.addConnection(5, 3);
        this.addConnection(5, 4);
        this.addConnection(5, 6);
        this.addConnection(6, 5);
        this.addConnection(7, 3);
        this.addConnection(7, 8);
        this.addConnection(8, 3);
        this.addConnection(8, 7);


    }
    public Graph(int numNodes)
    {
        this.numNodes = numNodes;
        this.nodes = new Node[numNodes];
        this.unfound = new boolean[numNodes];
        for(int i = 0; i < numNodes; ++i)
        {
            unfound[i] = true;
        }
    }
    public void addConnection(int startID, int endID)
    {
        if(startID < numNodes && endID < numNodes)
        {
            Node next = nodes[startID];
            Node last = null;
            while(next != null)
            {
                if(next.getID() == endID)
                {
                    System.out.println("Connection already exists.");
                    return;
                }
                last = next;
                next = next.getNext();
            }
            if(last == null)
            {
                nodes[startID].setNext(new Node(endID));
            }
            else
            {
                last.setNext(new Node(endID));
            }
        }
        else
        {
            System.out.println("Node dose not exists.");
        }
    }
}
