import java.util.ArrayList;

public class TransactionData {
    
    Double initBankBalance;
    ArrayList<Double> transactionList;

    public TransactionData(Double initBankBalance)
    {
        transactionList = new ArrayList<>();
        this.initBankBalance = initBankBalance;
    }

    public void deposit(Double amount)
    {
        transactionList.add(amount);
        System.out.println("Deposit: " + amount);
    }

    public void withdraw(Double amount)
    {
        transactionList.add(amount * -1); //User input is always above 0. Withdraw action will convert amount to a negative number.
        System.out.println("Withdraw: " + (amount * -1));
    }

    public Double getInitBalance()
    {
        return initBankBalance;
    }

    public Double getBankBalance()
    {
        Double balance = initBankBalance;

        if (transactionList.isEmpty())
        {
            return initBankBalance;
        }

        for (double transaction : transactionList)
        {
            balance += transaction;
        }

        return balance;
    }

    public ArrayList<Double> getTransactions()
    {
        return transactionList;
    }


}
