import java.util.ArrayList;
import java.util.Scanner;

public class ListMaker
{
    private static ArrayList<String> myArrList = new ArrayList<>();

    public static void main(String[] args)
    {
        Scanner pipe = new Scanner(System.in);
        boolean done = false;

        IO.println("Welcome to ListMaker!");

        do
        {
            displayMenu();

            String menuChoice = SafeInput.getRegExString(pipe, "Enter your choice", "[AaDdIiPpQq]");

            if(menuChoice.equalsIgnoreCase("A"))
            {
                addItem(pipe);
            }
            else if(menuChoice.equalsIgnoreCase("D"))
            {
                deleteItem(pipe);
            }
            else if(menuChoice.equalsIgnoreCase("I"))
            {
                insertItem(pipe);
            }
            else if(menuChoice.equalsIgnoreCase("P"))
            {
                printList();
            }
            else if(menuChoice.equalsIgnoreCase("Q"))
            {
                done = SafeInput.getYNConfirm(pipe, "Are you sure you want to quit?");
            }

        }while(!done);

        IO.println("Thank you for using ListMaker!");

        pipe.close();
    }

    private static void displayMenu()
    {
        IO.println("");
        IO.println("Current List:");
        printList();

        IO.println("Menu Options:");
        IO.println("A - Add an item");
        IO.println("D - Delete an item");
        IO.println("I - Insert an item");
        IO.println("P - Print the list");
        IO.println("Q - Quit");
    }

    private static void addItem(Scanner pipe)
    {
        String newItem = SafeInput.getNonZeroLenString(pipe, "Enter the item to add");

        myArrList.add(newItem);

        IO.println("Item added successfully!");
    }

    private static void deleteItem(Scanner pipe)
    {
        if(myArrList.size() == 0)
        {
            IO.println("The list is empty. There is nothing to delete!");
        }
        else
        {
            displayNumberedList();

            int itemNumber = SafeInput.getRangedInt(pipe, "Enter the item number to delete", 1, myArrList.size());

            String removedItem = myArrList.remove(itemNumber - 1);

            IO.println("Removed: " + removedItem);
        }
    }

    private static void insertItem(Scanner pipe)
    {
        if(myArrList.size() == 0)
        {
            IO.println("The list is currently empty. The item will be added at position 1.");
        }
        else
        {
            displayNumberedList();
        }

        int location = SafeInput.getRangedInt(pipe, "Enter the location to insert the item", 1, myArrList.size() + 1);

        String newItem = SafeInput.getNonZeroLenString(pipe, "Enter the item to insert");

        myArrList.add(location - 1, newItem);

        IO.println("Item inserted successfully!");
    }

    private static void printList()
    {
        if(myArrList.size() == 0)
        {
            IO.println("The list is currently empty.");
        }
        else
        {
            for(int i = 0; i < myArrList.size(); i++)
            {
                IO.println(myArrList.get(i));
            }
        }
    }

    private static void displayNumberedList()
    {
        IO.println("");
        IO.println("Current List:");

        for(int i = 0; i < myArrList.size(); i++)
        {
            IO.println((i + 1) + ". " + myArrList.get(i));
        }

        IO.println("");
    }
}