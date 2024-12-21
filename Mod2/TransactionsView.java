import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class TransactionsView extends JPanel
{
    JTextArea transactionDisplay;
    JScrollPane scrollPanel;
    JLabel initBalanceLabel;
    JLabel currentBalanceLabel;

    TransactionData transactionData;

    public TransactionsView(TransactionData transactionData)
    {
        //Object instantiation
        this.transactionData = transactionData;

        transactionDisplay = new JTextArea(5,10);
        scrollPanel = new JScrollPane(transactionDisplay);
        transactionDisplay.setEditable(false);
        
        initBalanceLabel = new JLabel();
        currentBalanceLabel = new JLabel();


        //Populate components with data
        updateInitBalance();
        populateTransactionDisplay();
        updateCurrentBalance();


        //Layout set-up
        setLayout(new GridBagLayout());
        GridBagConstraints gbConstraints = new GridBagConstraints();
        
        gbConstraints.gridx=0;
        gbConstraints.gridy=0;
        gbConstraints.insets = new Insets(5, 10, 5, 10);
        add(initBalanceLabel, gbConstraints);

        gbConstraints.gridy=1;
        add(scrollPanel, gbConstraints);

        gbConstraints.gridy=2;
        add(currentBalanceLabel, gbConstraints);

    }

    public void updateInitBalance()
    {
        String formattedInitBalance = String.format("%.2f", transactionData.getInitBalance());
        initBalanceLabel.setText("Initial Balance: $" + formattedInitBalance);
    }

    public void populateTransactionDisplay()
    {
        ArrayList<Double> transactions = transactionData.getTransactions();
        transactionDisplay.setText(""); //Clear text area before populating with transaction data

        if (transactions.isEmpty())
        {
            return;
        }

        for (Double transaction : transactions)
        {

            /* Formatting for GUI Display purposes
             * Deposits remain positive with empty symbol (IE: $5.00)
             * Withdraws move negative symbol to the front (IE: -$5.00 instead of $-5.00)
             */
            Double transactionAmount = transaction;
            String symbol = "";

            if (transaction < 0)
            {
                transactionAmount = transaction * -1;
                symbol = "-";
            }

            String formattedTransaction = String.format("%.2f", transactionAmount);
            transactionDisplay.append(symbol + "$" + formattedTransaction + "\n");
        }
    }

    public void updateCurrentBalance()
    {
        String formattedBankBalance = String.format("%.2f", transactionData.getBankBalance());
        currentBalanceLabel.setText("Current Balance: $" + formattedBankBalance);
    }
}
