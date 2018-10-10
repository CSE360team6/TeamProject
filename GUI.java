import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class GUI {

    public static void main(String[] args){
        
    	Node node = new Node(null, 0, null);
        // create JFrame and JTable
        JFrame frmNetworkPathwayFinder = new JFrame();
        frmNetworkPathwayFinder.setTitle("Network Pathway Finder");
        JTable table = new JTable(); 
        
        // create a table model and set a Column Identifiers to this model 
        Object[] columns = {"Activity","Duration","Predecessor"};
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columns);
        
        
        
        // set the model to the table
        table.setModel(model);
        
        // Change A JTable Background Color, Font Size, Font Color, Row Height
        table.setBackground(Color.LIGHT_GRAY);
        table.setForeground(Color.BLACK);
        Font font = new Font("",2,15);
        table.setFont(font);
        table.setRowHeight(30);
        
        // create JTextFields
        JTextField textActivity = new JTextField();
        JTextField textDuration = new JTextField();
        JTextField textPredecessor = new JTextField();
        
        // create JButtons
        JButton btnInput = new JButton("Input");
        JButton btnDelete = new JButton("Delete");
        JButton btnEdit = new JButton("Edit");     
        
        textActivity.setBounds(105, 310, 100, 25);
        textDuration.setBounds(255, 310, 100, 25);
        textPredecessor.setBounds(411, 310, 100, 25);
        
        btnInput.setBounds(639, 310, 100, 25);
        btnEdit.setBounds(774, 82, 100, 25);
        btnDelete.setBounds(774, 138, 100, 25);
        
        // create JScrollPane
        JScrollPane pane = new JScrollPane(table);
        pane.setBounds(10, 49, 765, 225);
        
        frmNetworkPathwayFinder.getContentPane().setLayout(null);
        
        frmNetworkPathwayFinder.getContentPane().add(pane);
        
        // add JTextFields to the JFrame
        frmNetworkPathwayFinder.getContentPane().add(textActivity);
        frmNetworkPathwayFinder.getContentPane().add(textDuration);
        frmNetworkPathwayFinder.getContentPane().add(textPredecessor);
    
        // add JButtons to the JFrame
        frmNetworkPathwayFinder.getContentPane().add(btnInput);
        frmNetworkPathwayFinder.getContentPane().add(btnDelete);
        frmNetworkPathwayFinder.getContentPane().add(btnEdit);
        
        JLabel lblActivity = new JLabel("Activity");
        lblActivity.setBounds(121, 285, 46, 14);
        frmNetworkPathwayFinder.getContentPane().add(lblActivity);
        
        JLabel lblDuration = new JLabel("Duration");
        lblDuration.setBounds(276, 285, 46, 14);
        frmNetworkPathwayFinder.getContentPane().add(lblDuration);
        
        JLabel lblPredecessor = new JLabel("Predecessor");
        lblPredecessor.setBounds(426, 285, 85, 14);
        frmNetworkPathwayFinder.getContentPane().add(lblPredecessor);
        
        JButton btnProcess = new JButton("Process");
        btnProcess.setBounds(774, 311, 89, 23);
        frmNetworkPathwayFinder.getContentPane().add(btnProcess);
        
        JButton btnHelp = new JButton("Help");
        btnHelp.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Help H = new Help();
        		H.setVisible(true);
        	}
        });
        btnHelp.setBounds(30, 0, 89, 23);
        frmNetworkPathwayFinder.getContentPane().add(btnHelp);
        
        JButton btnAbout = new JButton("About");
        btnAbout.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		About A = new About();
        		A.setVisible(true);
        	}
        });
        btnAbout.setBounds(200, 0, 89, 23);
        frmNetworkPathwayFinder.getContentPane().add(btnAbout);
        
        JButton btnRestart = new JButton("Restart");
        btnRestart.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		GUI.main(args);
        		frmNetworkPathwayFinder.dispose();
        	}
        });
        btnRestart.setBounds(365, 0, 89, 23);
        frmNetworkPathwayFinder.getContentPane().add(btnRestart);
        
        // create an array of objects to set the row data
        Object[] row = new Object[3];
        
        // button to add the row
        btnInput.addActionListener(new ActionListener(){
        	ArrayList<String> predecessor = new ArrayList<String>();
            @Override
            public void actionPerformed(ActionEvent e) {
             try {
            ;
                row[0] = textActivity.getText();
                
                row[1] = Integer.parseInt(textDuration.getText());
                
                row[2] = textPredecessor.getText();
                          
                // add row to the table
                model.addRow(row);
             }
             catch(NumberFormatException nfe) 
             {
             	JOptionPane.showMessageDialog(null, "The duration must be an integer.");
             	
             }
             textActivity.setText(null);
             textDuration.setText(null);
             textPredecessor.setText(null);
             
            }
        });
        
        // button to remove selected row
        btnDelete.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
            
                // i = the index of the selected row
                int i = table.getSelectedRow();
                if(i >= 0){
                    // remove a row from jtable
                    model.removeRow(i);
                }
                else{
                    System.out.println("Delete Error");
                }
            }
        });
        
        // click on the row to add its text back into the boxes 
        table.addMouseListener(new MouseAdapter(){
        
        @Override
        public void mouseClicked(MouseEvent e){
            
            // i = the index of the selected row
            int i = table.getSelectedRow();
            
            textActivity.setText(model.getValueAt(i, 0).toString());
            textDuration.setText(model.getValueAt(i, 1).toString());
            textPredecessor.setText(model.getValueAt(i, 2).toString());
           
        }
        });
        
        // button to update the row after entering in different text
        btnEdit.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
             
                // i = the index of the selected row
                int i = table.getSelectedRow();
                
                if(i >= 0) 
                	try {
                {
                   model.setValueAt(textActivity.getText(), i, 0);
                   model.setValueAt(Integer.parseInt(textDuration.getText()), i, 1);
                   model.setValueAt(textPredecessor.getText(), i, 2);
                  
                }
               
                }
                catch(NumberFormatException nfe) 
                {
                	JOptionPane.showMessageDialog(null, "The duration must be an integer.");
                }
                textActivity.setText(null);
                textDuration.setText(null);
                textPredecessor.setText(null);
            }
        });
        
        frmNetworkPathwayFinder.setSize(900,400);
        frmNetworkPathwayFinder.setLocationRelativeTo(null);
        frmNetworkPathwayFinder.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmNetworkPathwayFinder.setVisible(true);
        
    }
}
