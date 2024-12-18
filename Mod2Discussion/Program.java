import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Program
{
    public static void main(String[] args)
    {
        JFrame myApp = new JFrame();
        myApp.setTitle("My cool app");

        Page page = new Page("This is page 1");
        Buttons buttons = new Buttons(page);
        
        myApp.setLayout(new GridBagLayout());
        GridBagConstraints positionConst = new GridBagConstraints();

        positionConst.gridx=0;
        positionConst.gridy=0;
        positionConst.insets = new Insets(10,10,10,10);
        myApp.add(buttons, positionConst);

        positionConst.gridy=1;
        myApp.add(page, positionConst);

        myApp.pack();
        myApp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myApp.setVisible(true);
    }
 }


class Buttons extends JPanel
{
    JButton page1Button;
    JButton page2Button;
    JButton page3Button;

    public Buttons(Page page)
    {
        page1Button = new JButton("Page 1");
        page1Button.addActionListener(page);
        page2Button = new JButton("Page 2");
        page2Button.addActionListener(page);
        
        add(page1Button);
        add(page2Button);
    }    
}

class Page extends JPanel implements ActionListener
{
    JLabel pageLabel;
   
    Page(String pageText)
    {
        pageLabel = new JLabel(pageText);
        add(pageLabel);
    }  
    
    @Override
    public void actionPerformed(ActionEvent event)
    {
        if (event.getActionCommand().equals("Page 1"))
        {
            pageLabel.setText("This is page 1");
        }
        else if (event.getActionCommand().equals("Page 2"))
        {
            pageLabel.setText("This is page 2");
        }
    }
}