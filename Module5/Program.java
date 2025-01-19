import java.util.ArrayList;
import java.util.Scanner;

/*
 *  Chris Russell
 *  Module 5 Option 1
 */

public class Program
{
    public static void main(String[] args)
    {
        //Instantiate objects
        Scanner userInput = new Scanner(System.in);
        ArrayList<Integer> numbList = new ArrayList<Integer>();
        int numbersRequired = 5;
        int productOfInput = 1;

        //For loop to ask user for x amount of numbers
        //Nested while loop ensures that user enters 5 integers without skipping any input steps due to non-integer inputs.
        for (int i = 0; i < numbersRequired; i++)
        {
            boolean isInputValid = false;

            while (!isInputValid)
            {
                System.out.print("\nEnter a number(" + (i+1) + "):");
                if (userInput.hasNextInt())
                {
                    numbList.add(userInput.nextInt());
                    isInputValid = true;
                }
                else
                {
                    System.out.println("Please enter a number.");
                    userInput.nextLine();
                }
            }
        }

        userInput.close();

        productOfInput = calculateProduct(productOfInput, numbList);

        System.out.println("\n\nThe product of the numbers you entered is:" + productOfInput);
    }

    public static int calculateProduct(int productOfInput, ArrayList<Integer> numbList)
    {

        productOfInput = productOfInput * numbList.getFirst();
        numbList.remove(numbList.getFirst());

        if (numbList.isEmpty())
        {
            return productOfInput;
        }
        else
        {
            return calculateProduct(productOfInput, numbList);
        }
    }
}