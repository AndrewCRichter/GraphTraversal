

public class Graph
{
    private final int numNodes;
    private final Node[] nodes;
    private final boolean[] unfound;
    private Node start;
    private boolean breadth;


    public Graph()
    {
        this(8);
        this.addConnection(1, 2);
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
    }
    public void addConnection(int startID, int endID)
    {
        if(startID <= numNodes && endID <= numNodes && startID > 0 && endID > 0)
        {
            startID--;
            endID--;
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
                nodes[startID] = new Node(endID);
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
    public void Search(int startNode, boolean breadthFirst)
    {
        if(startNode <= numNodes && startNode > 0)
        {
            for(int i = 0; i < numNodes; ++i)
            {
                unfound[i] = true;
            }
            startNode--;
            breadth = breadthFirst;
            start = new Node(startNode);
            Node current = start;
            Node lastAdded = start;
            Node connection;
            unfound[startNode] = false;
            while(current != null)
            {
                connection = nodes[current.getID()];
                while (connection != null)
                {
                    if(unfound[connection.getID()])
                    {
                        unfound[connection.getID()] = false;
                        if(breadth)
                        {
                            lastAdded.setNext(new Node(connection.getID()));
                            lastAdded = lastAdded.getNext();
                        }
                        else
                        {
                            lastAdded = new Node(connection.getID());
                            lastAdded.setNext(current.getNext());
                            current.setNext(lastAdded);
                        }
                    }
                    connection = connection.getNext();
                }
                current = current.getNext();
            }
        }
        else
        {
            System.out.println("Start Node dose not exists.");
        }
    }
    public void Display()
    {
        if(start != null)
        {
            Node visited = start;
            String out;
            if(breadth)
            {
                out = "BFS";
            }
            else
            {
                out = "DFS";
            }
            out += " with the start node " + (start.getID() + 1) + " discovers the nodes in the following order: ";
            while (visited != null)
            {
                out += visited.getID() + 1;
                visited = visited.getNext();
                if(visited == null)
                {
                    out += ".\n\n";
                    System.out.println(out);
                }
                else
                {
                    out += ", ";
                }
            }
        }
    }
}
