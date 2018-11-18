import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class About extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					About frame = new About();
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
	public About() {
		setTitle("About");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblHelp = new JLabel("About");
		lblHelp.setHorizontalAlignment(SwingConstants.CENTER);
		lblHelp.setBounds(196, 0, 46, 14);
		contentPane.add(lblHelp);
		
		JTextArea txtAbout = new JTextArea();
		txtAbout.setText("This is a program with a gui interface that was created to path a network. It's creators are Cason Mandigo, Andrew Meshay, Kai Yin, and Justin Lynch. This project was coded using Java with "
				+ "Eclipse as the IDE, and gitHub was used as the version control. The program is compatable with any computer capable of running java.");
		txtAbout.setBounds(10, 11, 464, 439);
		txtAbout.setLineWrap(true);
		txtAbout.setWrapStyleWord(true);
		contentPane.add(txtAbout);
	}

}
