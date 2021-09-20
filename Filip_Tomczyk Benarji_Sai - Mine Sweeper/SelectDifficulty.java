import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectDifficulty extends JFrame implements ActionListener {

    private JFrame frame;
    final JComboBox<String> dropdown;

    public SelectDifficulty() {
        frame = new JFrame("Mine Sweeper");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,200);

        JPanel panel = new JPanel();
        frame.add(panel);

        JLabel label = new JLabel("Select Difficulty");
        label.setVisible(true);
        panel.add(label);

        String[] levels = {"Beginner", "Intermediate", "Hard"};
        dropdown = new JComboBox<String>(levels);
        dropdown.setVisible(true);
        panel.add(dropdown);

        JButton okButton = new JButton("OK");
        panel.add(okButton);
        okButton.addActionListener(this);

        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getActionCommand().equals("OK"))
        {
            if(dropdown.getSelectedItem().toString().equals("Beginner")) {
                Map map = new Map(8, 8, 10);
            }
            else if(dropdown.getSelectedItem().toString().equals("Intermediate")) {
                Map map = new Map(16, 16, 40);
            }
            else {
                Map map = new Map(16, 30, 99);
            }
            frame.setVisible(false);
        }
    }
}
