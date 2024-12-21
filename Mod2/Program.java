import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Program extends JFrame
{
    JLabel programLabel;
    InitScreenView initScreenView;
    TransactionData transactionData;
    TransactionsView transactionsView;
    BankControlsView bankControlsView;

    public Program()
    {
        //Program set-up
        setTitle("My banking application");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Program instantiation
        programLabel = new JLabel("Simple Banking App");

        initScreenView = new InitScreenView(this);

        //Layout set-up
        setLayout(new GridBagLayout());
        GridBagConstraints gbConstraints = new GridBagConstraints();

        gbConstraints.gridx=0;
        gbConstraints.gridy=0;
        gbConstraints.insets = new Insets(5, 10, 5, 10);
        add(programLabel, gbConstraints);

        gbConstraints.gridx=0;
        gbConstraints.gridy=1;
        add(initScreenView, gbConstraints);

        pack();
    }

    public void displayMainScreen(Double initBalance)
    {
        remove(initScreenView);

        transactionData = new TransactionData(initBalance);
        transactionsView = new TransactionsView(transactionData);

        bankControlsView = new BankControlsView(this);

        setLayout(new GridBagLayout());
        GridBagConstraints gbConstraints = new GridBagConstraints();

        gbConstraints.gridx=0;
        gbConstraints.gridy=0;
        gbConstraints.insets = new Insets(5, 10, 5, 10);
        add(programLabel, gbConstraints);

        gbConstraints.gridx=0;
        gbConstraints.gridy=1;
        add(transactionsView, gbConstraints);

        gbConstraints.gridx=0;
        gbConstraints.gridy=2;
        add(bankControlsView, gbConstraints);
        
        repaint();
        revalidate();
        pack();
    }

    public void processTransaction(String transactionType, Double amount)
    {
        if (transactionType.equals("Deposit"))
        {
            transactionData.deposit(amount);
        }
        else if (transactionType.equals("Withdraw"))
        {
            transactionData.withdraw(amount);
        }

        transactionsView.populateTransactionDisplay();
        transactionsView.updateCurrentBalance();
    }

    public static void main(String[] args)
    {
       Program program = new Program();
       program.setVisible(true);
    }
}