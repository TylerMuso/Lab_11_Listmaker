import java.util.Scanner;

public class SafeInput
{
    public static String getNonZeroLenString(Scanner pipe, String prompt)
    {
        String retVal = "";

        do
        {
            IO.print(prompt + ": ");
            retVal = pipe.nextLine();

            if(retVal.isEmpty())
            {
                IO.println("You must enter at least one character!");
            }

        }while(retVal.isEmpty());

        return retVal;
    }

    public static int getInt(Scanner pipe, String prompt)
    {
        int retVal = 0;
        String trash = "";
        boolean done = false;

        do
        {
            IO.print(prompt + ": ");

            if(pipe.hasNextInt())
            {
                retVal = pipe.nextInt();
                pipe.nextLine();
                done = true;
            }
            else
            {
                trash = pipe.nextLine();
                IO.println("You must enter a valid integer, not: " + trash);
            }
        }while(!done);

        return retVal;
    }

    public static double getDouble(Scanner pipe, String prompt)
    {
        double retVal = 0;
        String trash = "";
        boolean done = false;

        do
        {
            IO.print(prompt + ": ");
            if(pipe.hasNextDouble())
            {
                retVal = pipe.nextDouble();
                pipe.nextLine();
                done = true;
            }
            else
            {
                trash = pipe.nextLine();
                IO.println("You must enter a valid double, not: " + trash);
            }
        }while(!done);

        return retVal;
    }

    public static int getRangedInt(Scanner pipe, String prompt, int low, int high)
    {
        int retVal = 0;
        String trash = "";
        boolean done = false;

        do
        {
            IO.print(prompt + " [" + low + " - " + high +"]: ");
            if(pipe.hasNextInt())
            {
                retVal = pipe.nextInt();
                pipe.nextLine();
                if(retVal >= low && retVal <= high)
                {
                    done = true;
                }
                else
                {
                    IO.println("You must enter a valid int in range [" + low + " - " + high+"]  not: " + retVal);
                }
            }
            else
            {
                trash = pipe.nextLine();
                IO.println("You must enter a valid integer, not: " + trash);
            }
        }while(!done);

        return retVal;
    }

    public static double getRangedDouble(Scanner pipe, String prompt, double low, double high)
    {
        double retVal = 0;
        String trash = "";
        boolean done = false;

        do
        {
            IO.print(prompt + " [" + low + " - " + high +"]: ");
            if(pipe.hasNextDouble())
            {
                retVal = pipe.nextDouble();
                pipe.nextLine();
                if(retVal >= low && retVal <= high)
                {
                    done = true;
                }
                else
                {
                    IO.println("You must enter a valid double in range [" + low + " - " + high +"], not: " + retVal);
                }
            }
            else
            {
                trash = pipe.nextLine();
                IO.println("You must enter a valid double, not: " + trash);
            }
        }while(!done);

        return retVal;
    }

    public static boolean getYNConfirm(Scanner pipe, String prompt)
    {
        String input = "";
        boolean retVal = false;
        boolean done = false;

        do
        {
            IO.print(prompt + "[Y/N]: ");
            input = pipe.nextLine();

            if(input.isEmpty())
            {
                IO.println("You must enter y or n!");
            }
            else if(input.equalsIgnoreCase("Y"))
            {
                retVal = true;
                done = true;
            }
            else if(input.equalsIgnoreCase("N"))
            {
                retVal = false;
                done = true;
            }
            else
            {
                IO.println("You must enter Y or N! Not: " + input);
            }
        }while(!done);

        return retVal;
    }

    public static String getRegExString(Scanner pipe, String prompt, String regEx)
    {
        boolean done = false;
        String retVal = "";

        do
        {
            IO.print(prompt + ": ");
            retVal = pipe.nextLine();
            if(retVal.matches(regEx))
            {
                done = true;
            }
            else
            {
                IO.println("You must enter a value that matches pattern " + regEx + ", not: " + retVal);
            }
        }while(!done);

        return retVal;
    }


    public static void prettyHeader(String msg)
    {
        final int TOTAL_WIDTH = 60;
        final int BORDER_STAR = 3;
        int msgLength = msg.length();
        int totalSpaces = 0;
        int spaceBefore = 0;
        int spaceAfter = 0;

        if(msgLength > 54)
        {
            IO.println("Failed to create header msg is too long!");
            return;
        }

        totalSpaces = TOTAL_WIDTH - (2 * BORDER_STAR) - msgLength;
        spaceBefore = totalSpaces / 2;

        if(totalSpaces % 2 == 0)
            spaceAfter = spaceBefore;
        else
            spaceAfter = spaceBefore + 1;

        // print first row of stars
        for(int c = 1; c <= TOTAL_WIDTH; c++)
            IO.print("*");
        IO.println();
        // print the *** border
        for(int c = 1; c <= BORDER_STAR; c++)
            IO.print("*");
        // print the spaces before
        for(int c = 1; c <= spaceBefore; c++)
            IO.print(" ");
        IO.print(msg);
        // print the spaces after
        for(int c = 1; c <= spaceAfter; c++)
            IO.print(" ");
        // print the *** border
        for(int c = 1; c <= BORDER_STAR; c++)
            IO.print("*");
        IO.println();
        // print the bottom line of stars
        for(int c = 1; c <= TOTAL_WIDTH; c++)
            IO.print("*");
        IO.println();
    }

}