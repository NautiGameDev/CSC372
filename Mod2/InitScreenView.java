
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

public class InitScreenView extends JPanel implements ActionListener
{
    Program program;
    JLabel instructionsLabel;
    JTextField userInputField;
    JButton confirmButton;

    public InitScreenView(Program program)
    {
        //Object instantiation
        this.program = program;

        instructionsLabel = new JLabel("Enter initial bank balance:");
        
        userInputField = new JTextField(10);
        userInputField.setEditable(true);

        confirmButton = new JButton("Confirm");
        confirmButton.addActionListener(this);

        //Layout set-up
        setLayout(new GridBagLayout());
        GridBagConstraints gbConstraints = new GridBagConstraints();

        gbConstraints.gridx=0;
        gbConstraints.gridy=0;
        gbConstraints.insets = new Insets(5, 5, 5, 5);
        add(instructionsLabel, gbConstraints);

        gbConstraints.gridx=0;
        gbConstraints.gridy=1;
        add(userInputField, gbConstraints);

        gbConstraints.gridx=0;
        gbConstraints.gridy=2;
        add(confirmButton, gbConstraints);
    }

    @Override
    public void actionPerformed(ActionEvent event)
    {
        try
        {
            Double userInputDouble = Double.parseDouble(userInputField.getText());
            program.displayMainScreen(userInputDouble);
        }
        catch (Exception ex)
        {
            JOptionPane.showMessageDialog(this, "Input value needs to be a number!");
        }
    }
}
