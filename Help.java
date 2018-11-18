import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Help extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Help frame = new Help();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Help() {
		setTitle("Help");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblHelp = new JLabel("Help");
		lblHelp.setHorizontalAlignment(SwingConstants.CENTER);
		lblHelp.setBounds(196, 0, 46, 14);
		contentPane.add(lblHelp);
		
		JTextArea txtHelp = new JTextArea();
		txtHelp.setText("Your first step would be to input the activity name, duration, and any predecessors in the fields given near the bottom of the window, and then click add to add the node to the list. Dependencies must be entered as a comma-separated list with no whitespace. Duration must be a numerical value. Activity names may not contain whitespace. If any issues are present in the pending entry, a window will open prompting the user to fix any errors, such as non-numerical duration or whitespace in activity name. If you wish to make any changes, you can edit the entry with the edit button next to the node entry in the list. You may delete any nodes, or clear the entire list by clicking the respective buttons. Once finished with inputting all nodes, you can then choose additional options"
				+ "+ by clicking the show critical paths checklist, or create report checklist. If you have the report checklist selected, you need to add the name of the report in the relevant text field, and when proces is pressed all paths will be created in descending order, or just the critical path(s) if selected, and they will create a text report if selected.");
		txtHelp.setBounds(10, 11, 464, 439);
		txtHelp.setLineWrap(true);
		txtHelp.setWrapStyleWord(true);
		contentPane.add(txtHelp);
		

		  
		 
	}
}