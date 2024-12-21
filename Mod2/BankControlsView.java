
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BankControlsView extends JPanel implements ActionListener
{
    Program program;
    JLabel userInputLabel;
    JTextField userInputField;
    JButton withdrawButton;
    JButton depositButton;

    public BankControlsView(Program program)
    {
        //Object instantiation
        this.program = program;

        userInputLabel = new JLabel("Enter amount: ");

        userInputField = new JTextField(10);
        userInputField.setEditable(true);

        withdrawButton = new JButton("Withdraw");
        withdrawButton.addActionListener(this);

        depositButton = new JButton("Deposit");
        depositButton.addActionListener(this);

        //Layout set-up
        setLayout(new GridBagLayout());
        GridBagConstraints gbConstraints = new GridBagConstraints();

        gbConstraints.gridx = 0;
        gbConstraints.gridy = 0;
        gbConstraints.insets = new Insets(5, 5, 5, 5);
        add(userInputLabel, gbConstraints);

        gbConstraints.gridx = 1;
        gbConstraints.gridy = 0;
        add(userInputField, gbConstraints);

        gbConstraints.gridx=0;
        gbConstraints.gridy=1;
        add(withdrawButton, gbConstraints);

        gbConstraints.gridx=1;
        gbConstraints.gridy=1;
        add(depositButton, gbConstraints);
    }

    @Override
    public void actionPerformed(ActionEvent event)
    {
        try
        {
            String actionType = event.getActionCommand();
            Double userInputValue = Double.parseDouble(userInputField.getText());

            //Value needs to be above 0 to be processed correctly.
            if (userInputValue <= 0)
            {
                JOptionPane.showMessageDialog(this, "Input value must be greater than 0!");
                return;
            }

            program.processTransaction(actionType, userInputValue);
            userInputField.setText("");
        }
        catch (Exception exception)
        {
            JOptionPane.showMessageDialog(this, "Input value must be a number!");
        }
    }
    

}
