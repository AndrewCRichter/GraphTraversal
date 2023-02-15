import java.util.Scanner;
// This program asks the user to give a start node and traversal algorithm and displays the
// nodes in the order that they were visited. The program repeats this process until the user decides to exit.
//
// Andrew Richter
// CS224 Algorithm Design & Analysis
// Spring 2023
//
public class Main
{
    public static void main(String[] args)
    {
        Graph graph = new Graph();              //  The Graph to traverse
        Scanner in = new Scanner(System.in);
        int inputInt;                           //  User input for the node number
        String inputString;                     //  User input string
        boolean again = true;                   //  true to continue loop
        boolean breadth = true;                 //  true for breadth first search and false for depth first search
        // Loop through program as long as user wants to continue
        while (again)
        {
            System.out.println("Enter a start node number between 1 and 8 for the node traversal: ");
            inputInt = in.nextInt();
            in.nextLine();
            System.out.println("Enter B for breadth-first search (BFS) or D for depth-first search (DFS): ");
            do
            {
                again = false;
                inputString = in.nextLine().strip();
                if (inputString.equalsIgnoreCase("B"))
                {
                    breadth = true;
                }
                else if (inputString.equalsIgnoreCase("D"))
                {
                    breadth = false;
                }
                else
                {
                    System.out.println("Pleas enter B or D: ");
                    again = true;
                }
            } while (again);
            // Search the graph with the start node and the traversal type.
            if(graph.Search(inputInt, breadth))
            {
                // If the start node is valid, display the nodes in the order traversed.
                graph.Display();
            }
            System.out.println("Would you like to go again? Enter Y if so and anything else to exit: ");
            inputString = in.nextLine().toUpperCase();
            again = inputString.equalsIgnoreCase("Y");
        }
    }
}