import java.util.LinkedHashMap;

public class BankAccount {
    String firstName;
    String lastName;
    int accountID;
    double balance;

    public BankAccount(String firstName, String lastName, int accountID)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.accountID = accountID;
        this.balance = 0;
    }

    public void Deposit(double amount)
    {
        this.balance += amount;
        System.out.printf("Depositing amount of $%.2f\n", amount);
    }

    public void Withdrawal(double amount)
    {
        this.balance -= amount;
    }

    public double GetBalance()
    {
        return this.balance;
    }

    public void SetFirstName(String firstName)
    {
        System.out.println("\nFirst name has been changed to " + firstName);
        this.firstName = firstName;
    }

    public String GetFirstName()
    {
        return this.firstName;
    }

    public void SetLastName(String lastName)
    {
        System.out.println("\nLast name has been changed to " + lastName);
        this.lastName = lastName;
    }

    public String GetLastName()
    {
        return this.lastName;
    }

    public void SetAccountID(int newAccountID)
    {
        System.out.println("\nAccount ID has been changed to " + newAccountID);
        this.accountID = newAccountID;
    }

    public int GetAccountID()
    {
        return this.accountID;
    }

    public LinkedHashMap<String, String> GetAccountSummary()
    {
        LinkedHashMap<String, String> accountSummary = new LinkedHashMap<>();
        accountSummary.put("First Name", this.firstName);
        accountSummary.put("Last Name", this.lastName);
        accountSummary.put("Account ID", Integer.toString(this.accountID));
        accountSummary.put("Account Balance", Double.toString(this.balance));

        return accountSummary;
    }
}
