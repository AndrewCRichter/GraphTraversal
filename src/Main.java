import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Graph graph = new Graph();
        Scanner in = new Scanner(System.in);
        int inputInt;
        String inputString;
        boolean again = true;
        boolean breadth = true;
        while (again)
        {
            System.out.println("Enter a start node number for the node traversal: ");
            inputInt = in.nextInt();
            in.nextLine();
            System.out.println("Enter B for breadth-first search or D for depth-first search: ");
            do {
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
            graph.Search(inputInt, breadth);
            graph.Display();
            System.out.println("Would you like to go again? Enter Y if so and anything else to exit: ");
            inputString = in.nextLine().toUpperCase();
            again = inputString.equalsIgnoreCase("Y");
        }
    }
}