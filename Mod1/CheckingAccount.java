
import java.util.LinkedHashMap;



public class CheckingAccount extends BankAccount {
    
    float interestRate;

    public CheckingAccount(String firstName, String lastName, int accountID)
    {
        super(firstName, lastName, accountID);
        this.interestRate = 0.01f;
    }

    public void processWithdrawal(double amount)
    {
        System.out.printf("\n\nWithdrawing the amount of: $%.2f\n", amount);
        double accountBalance = super.GetBalance();
        
        if (accountBalance - amount < 0)
        {
            System.out.printf("The withdrawal of $%.2f will result in a negative account balance. A fee of $30 has been applied.\n", amount);
            amount += 30;
            super.Withdrawal(amount);
        }
        else
        {
            super.Withdrawal(amount);
        }
    }

    public void accountSummary()
    {
        LinkedHashMap<String, String> bankAccountDetails = super.GetAccountSummary();
        bankAccountDetails.put("Interest Rate", Float.toString(this.interestRate));

        for (String accountItem : bankAccountDetails.keySet())
        {
            System.out.println(accountItem + ": " + bankAccountDetails.get(accountItem));
        }
    }
}
