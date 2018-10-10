import javax.swing.*;
import java.awt.*;
public class GUI {
    JFrame f;
    GUI() {
        f=new JFrame();
        JButton help=new JButton("Help");
        JButton reset=new JButton("Reset");
        JButton about=new JButton("About");
        JTextField activity = new JTextField("Activity");
        activity.setPreferredSize(new Dimension(100,20));
        JTextField duration = new JTextField("Duration");
        duration.setPreferredSize(new Dimension(100,20));
        JTextField predecessors = new JTextField("Predecessors");
        predecessors.setPreferredSize(new Dimension(100,20));
        JButton add = new JButton("Add");
        JButton process = new JButton("Process");
        /*Top Part of GUI*/
        JPanel top=new JPanel();
        top.setLayout(new FlowLayout());
        top.add(help);
        top.add(reset);
        top.add(about);
        /*The Bottom Part of the GUI*/
        JPanel inputPanel=new JPanel();
        inputPanel.setLayout(new FlowLayout());
        inputPanel.add(activity);
        inputPanel.add(duration);
        inputPanel.add(predecessors);
        inputPanel.add(add);
        inputPanel.add(process);
        /*Middle Part of GUI*/
        JPanel list=new JPanel();
        list.setLayout(new GridLayout(2,1));
        list.add(new JLabel("Current List"));
        /*Adds everything back in*/
        f.setLayout(new GridLayout(3,1));
        f.add(top);
        f.add(list);
        f.add(inputPanel);

        f.setSize(800, 800);

        f.setVisible(true);
    }
    public static void main(String[] args) {
        new GUI();
    }
}
