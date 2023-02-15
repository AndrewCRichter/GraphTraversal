
// The Graph class contains all the functionality of a Graph.
// The graph can contain any number of nodes and any set of connections. It can be directed
// or undirected and can do a breadth-first search and a depth-first search for any graph
// given any start node and can display the nodes in the order they were visited for the most
// recent traversal.

public class Graph
{
    private final int numNodes;         //  The number of nodes in the Graph
    private final Node[] nodes;         //  The adjacency list of the Graph
    private final boolean[] unfound;    //  A list saying whether each node in the graph was visited during the traversal.
    private Node start;                 //  The start node for the traversal
    private boolean breadth;            //  The traversal type: true for breadth-first, and false for depth-first search.

    // The default constructor for the Graph creates a Graph with 8 nodes and predetermined connections.
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
    // This constructor creates a graph with any number of nodes and no connections,
    // expecting the connections to be added later.
    public Graph(int numNodes)
    {
        this.numNodes = numNodes;
        this.nodes = new Node[numNodes];
        this.unfound = new boolean[numNodes];
    }
    // Create a new directed connection from a start node ID to the end node ID provided,
    // added to the end of the adjacency list.
    public void addConnection(int startID, int endID)
    {
        // If the start and end ID are both valid:
        if(startID <= numNodes && endID <= numNodes && startID > 0 && endID > 0)
        {
            //  Shift start and end ID to start indexing at 0.
            startID--;
            endID--;
            // Starting at the beginning of the adjacency list for the start node, go through the list
            // to make sure that a connection to the end node doesn't already exist and then add the
            // connected node to the end of the list.
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
            System.out.println("Node dose not exist.");
        }
    }
    // Traverse the graph starting with startNode using Breadth-first search if breadthFirst is true,
    // otherwise use depth-first search.
    public boolean Search(int startNode, boolean breadthFirst)
    {
        // If the start node is valid:
        if(startNode <= numNodes && startNode > 0)
        {
            //Set each node in the graph to unfound.
            for(int i = 0; i < numNodes; ++i)
            {
                unfound[i] = true;
            }
            // Shift startNode to start indexing at 0.
            startNode--;
            breadth = breadthFirst;
            // Set the first, current and last nodes in the search to the start node.
            start = new Node(startNode);
            Node current = start;
            Node lastAdded = start;
            Node connection;
            // Set the start node to found.
            unfound[startNode] = false;
            // While there are still more nodes in the traversal list,
            // continue adding undiscovered nodes that are connected to the current node to the traversal list.
            while(current != null)
            {
                // Get the index of the current node for the adjacency list.
                connection = nodes[current.getID()];
                // While there are still nodes that are connected to the current node in the list:
                while (connection != null)
                {
                    //  If the connected node has not been found, set it to found and either
                    //  add it to the end of the traversal list for breadth-first search or
                    //  add it to the beginning of the traversal list for depth-first search.
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
                    // go to the next node connected to the current node
                    connection = connection.getNext();
                }
                // go to the next node in the traversal list
                current = current.getNext();
            }
            return true;
        }
        else
        {
            System.out.println("Start Node dose not exist.");
            return false;
        }
    }
    // Display the nodes in the order traversed
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
            //  Add each node to the output string.
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
