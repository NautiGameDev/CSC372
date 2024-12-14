import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class Main
{
//#region Program Set-up
    public static void main(String[] args) 
    {
        Scanner userInput = new Scanner(System.in);
        HashMap<String, CheckingAccount> checkingAccountDB = new HashMap<>();

        boolean isProgramRunning = true;

        while (isProgramRunning)
        {
            System.out.println("\n\nEnter the command, or letter, to perform an action (Example: New Account, or N, to create a new account)");

            System.out.println("  [N]ew Checking Account");
            System.out.println("  [A]ccess Checking Account");
            System.out.println("  [Q]uit program");

            System.out.print("\n>> ");
            String userChoice = userInput.next();
          
            switch (userChoice.toLowerCase())
            {
                case "n": case "new": case "new checking": case "new checking account":
                    CreateNewCheckingAccount(userInput, checkingAccountDB);
                    break;
                case "a": case "access": case "access checking": case "access checking account":
                    AccessCheckingAccount(userInput, checkingAccountDB);
                    break;
                case "q": case "quit": case "quit program":
                    isProgramRunning = false;
                    break;                
            }
        }

        System.out.println("Closing program... Thank you!");
    }
//#endregion

//#region Create New Account Methods
    public static void CreateNewCheckingAccount(Scanner userInput, HashMap<String, CheckingAccount> checkingAccountDB)
    {
        System.out.println("\n\nCreating a new checking account...");
        userInput.nextLine();

        System.out.println("\nEnter your first name:");
        System.out.print("\n>> ");
        String firstName = userInput.nextLine();

        System.out.println("\nEnter your last name:");
        System.out.print("\n>> ");
        String lastName = userInput.nextLine();

        int accountNumber = GenerateAccountNumber();

            CheckingAccount newCheckingAccount = new CheckingAccount(firstName, lastName, accountNumber);
            String databaseName = lastName + "," + firstName;
            checkingAccountDB.put(databaseName, newCheckingAccount);
            System.out.println("\nNew account has been created!");
            newCheckingAccount.accountSummary();
        
    }

    public static int GenerateAccountNumber()
    {
        String accountNumber = "";
        Random random = new Random();

        for (int i=0; i<5; i++)
        {
            int randomNumber = random.nextInt(9) + 1;
            accountNumber += Integer.toString(randomNumber);
        }
        
        return Integer.parseInt(accountNumber);
    }
//#endregion

//#region Access account methods
    public static void AccessCheckingAccount(Scanner userInput, HashMap<String, CheckingAccount> checkingAccountDB)
    {
        userInput.nextLine();

        System.out.println("\n\nAccessing checking account...");

        System.out.println("\nEnter your first name(Case sensitive):");
        System.out.print("\n>> ");
        String firstName = userInput.next();

        System.out.println("\nEnter your last name(Case sensitive):");
        System.out.print("\n>> ");
        String lastName = userInput.next();
        
        if (checkingAccountDB.keySet().contains(lastName + "," + firstName))
        {
            System.out.println("\nYour checking account has been found.");
            ProcessCheckingAccount(userInput, checkingAccountDB.get(lastName + "," + firstName));
        }
        else
        {
            System.out.println("\nChecking account couldn't be found for " + firstName + " " + lastName + ".");
        }
    }

    public static void ProcessCheckingAccount(Scanner userInput, CheckingAccount userCheckingAccount)
    {
        //Using a while loop so that user can perform multiple actions before returning to main menu.

        boolean isAccessingAccount = true;
        while (isAccessingAccount)
        {
            System.out.println("\n\nAccessing account for " + userCheckingAccount.GetFirstName() + " " + userCheckingAccount.GetLastName());

            System.out.println("Enter a command, or letter, to perform an action.");
            System.out.println("  Account [B]alance");
            System.out.println("  Account [S]ummary");
            System.out.println("  [W]ithdraw Cash");
            System.out.println("  [D]eposit Cash");
            System.out.println("  [C]hange account information");
            System.out.println("  [F]inish");
            
            System.out.print("\n>> ");
            String userChoice = userInput.next();
            userInput.nextLine();

            switch (userChoice.toLowerCase())
            {
                case "b": case "balance": case "account balance":
                    System.out.println("\nYour account balance is: " + userCheckingAccount.GetBalance());
                    break;
                case "s": case "summary": case "account summary":
                    System.out.println("\nAccount Summary:");
                    userCheckingAccount.accountSummary();
                    break;
                case "w": case "withdraw": case "withdraw cash":
                    System.out.println("\nEnter an amount to withdraw:");
                    double userWithdrawAmount = GetInputDouble(userInput);
                    userCheckingAccount.processWithdrawal(userWithdrawAmount);
                    break;
                case "d": case "deposit": case "deposit cash":
                    System.out.println("\nEnter the amount to deposit:");
                    double userDepsitAmount = GetInputDouble(userInput);
                    userCheckingAccount.Deposit(userDepsitAmount);
                    break;
                case "c": case "change account": case "change": case "change account information":
                    ProcessChangeAccountInformation(userInput, userCheckingAccount);
                    break;
                case "f": case "finish":
                    isAccessingAccount = false;
                    break;
                default:
                    System.out.println("\nEnter a valid command, or type M to return to the main menu.");
            }
        }
    }

    public static double GetInputDouble(Scanner userInput)
    {
        //Using a while loop to ensure user input is a double before performing actions.
        boolean isInputValid = false;
        while (!isInputValid)
        {
            System.out.print("\n>> ");
            if (userInput.hasNextDouble())
            {
                isInputValid = true;
                return userInput.nextDouble();
            }
            else
            {
                userInput.nextLine();
                System.out.println("\nError: Please enter a numerical value.");
            }
        }

        return 0;
    }
//#endregion

//#region Change account information methods
    public static void ProcessChangeAccountInformation(Scanner userInput, CheckingAccount userCheckingAccount)
    {
        //Use while loop to ensure user input is valid
        boolean isInputValid = false;
        while (!isInputValid)
        {
            System.out.println("\nEnter the information you wish to change:");

            System.out.println("  [F]irst Name");
            System.out.println("  [L]ast name");
            System.out.println("  [I]D number");
            System.out.println("  [B]ack");

            System.out.print("\n>> ");
            String userChoice = userInput.next();
            userInput.nextLine();

            switch (userChoice.toLowerCase())
            {
                case "f": case "first": case "first name":
                    System.out.println("\n\nEnter new first name:");
                    System.out.print(">> ");
                    String newFirstName = userInput.next();
                    userInput.nextLine();
                    userCheckingAccount.SetFirstName(newFirstName);
                    isInputValid = true;
                    break;
                case "l": case "last": case "last name":
                    System.out.println("\n\nEnter new last name:");
                    System.out.print(">> ");
                    String newLastName = userInput.next();
                    userInput.nextLine();
                    userCheckingAccount.SetLastName(newLastName);
                    isInputValid = true;
                    break;
                case "i": case "id": case "id number":
                    int newIDNumber = GetNewIDNumber(userInput);
                    userCheckingAccount.SetAccountID(newIDNumber);
                    isInputValid = true;
                    break;
                case "b": case "back":
                    isInputValid = true;
                    break;
                default:
                    System.out.println("Please enter a valid number");       
            }
        }
    }

    public static int GetNewIDNumber(Scanner userInput)
    {
        //User while loop to ensure ID number is 5 digits long
        boolean isInputValid = false;
        while (!isInputValid)
        {
            System.out.println("\nEnter an ID number 5 digits long:");
            System.out.print(">>");

            if (userInput.hasNextInt())
            {
                int newUserID = userInput.nextInt();

                if (Integer.toString(newUserID).length() == 5)
                {
                    isInputValid = true;
                    return newUserID;
                }
                else
                {
                    System.out.println("Please enter a 5 digit number");
                }
            }
            else
            {
                System.out.println("Please enter a 5 digit number");
            }
        }

        return 0;
    }

//#endregion
}