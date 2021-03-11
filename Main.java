import javax.swing.*;

public class Main {
    public static void main(String[] args)
    {
        JFrame frame = new JFrame("My First GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,200);

        JPanel panel = new JPanel();
        frame.add(panel);

        JLabel lbl = new JLabel("Select Difficulty");
        lbl.setVisible(true);
        panel.add(lbl);

        String[] choices = {"Beginner", "Intermediate", "Hard"};
        final JComboBox<String> cb = new JComboBox<String>(choices);
        cb.setVisible(true);
        panel.add(cb);

        JButton btn = new JButton("OK");
        panel.add(btn);
        frame.setVisible(true);
    }


}
