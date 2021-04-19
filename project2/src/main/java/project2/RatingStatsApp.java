package project2;

import java.util.Scanner;
import java.io.IOException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.*;
/**
 * DO NOT MODIFY: Exploratory Data Analysis of Amazon Product Reviews
 * @author tesic
 * @version 2.0
 */
public class RatingStatsApp implements ActionListener {

	// Used to read from System's standard input
	static final Scanner CONSOLE_INPUT = new Scanner(System.in);
	private static 	JFrame frame;
	private static JComboBox selectionBox;
	private static  int option;
	static DatasetHandler dh;
	
	public static void main(final String[] args) {
		option = 3;
		JOptionPane loadWindow = new JOptionPane();
		JPanel panel;
		JLabel welcomeLabel;
		String [] datasetOptions = new String[] {"1. Display computed statistics for specific dataID", "2. Add new collection and compute statistics.", "0. Exit program."};
		JButton enterButton;
	
		try {
			dh = new DatasetHandler();
			int dbSize = dh.getDataSets();

			loadWindow.showMessageDialog(null, "Loading the datasets from:" + dh.getFolderPath() + System.lineSeparator());
			loadWindow.showMessageDialog(null, dh.printDB() + System.lineSeparator() + "     " + dbSize + " datasets available");
			loadWindow.setVisible(true);

			frame = new JFrame("Rating Stats App");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			panel = new JPanel(new GridBagLayout());

			GridBagConstraints layoutConstraints = new GridBagConstraints();
			//layoutConstraints.gridwidth = 3;
			//layoutConstraints.gridheight = 5;
		
			

			layoutConstraints.gridx = 0;
			layoutConstraints.gridy = 0;
			welcomeLabel = new JLabel("Choose one of the following functions: from the list below");
			panel.add(welcomeLabel, layoutConstraints);

			layoutConstraints.gridx = 0;
			layoutConstraints.gridy = 1;
			selectionBox = new JComboBox(datasetOptions);
			panel.add(selectionBox, layoutConstraints);

			layoutConstraints.gridx = 0;
			layoutConstraints.gridy = 2;
			enterButton = new JButton("Enter");
			enterButton.addActionListener(new RatingStatsApp());
			panel.add(enterButton, layoutConstraints);

			panel.setVisible(true);
			frame.add(panel);
			frame.pack();
			frame.setLocationRelativeTo(null);
			frame.setVisible(true);
			
			
		} catch (IOException e) {
			
			loadWindow.showMessageDialog(null, "Dataset path not found: " + e.getMessage());
		}
	
	}// end mail

	public static void setOption( int choice) {
		option = choice;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		int choice = selectionBox.getSelectedIndex();
			switch(choice) {
				case 0: 
				frame.dispose();
				setOption(choice);
				Option1Window();
				break;

				case 1: 
				frame.dispose();
				setOption(choice);
				break;

				default: frame.dispose();
				JOptionPane.showMessageDialog(null, "GoodBye!");
				System.exit(0);
				break; 
			}	
		
	}
	
	public void Option1Window() {
		JOptionPane pane = new JOptionPane();
		String [] comboString = dh.printDB().split("\n");
		Object input = JOptionPane.showInputDialog(null, "Select a dataset ID from the list below", "Rating Stats App - display stats", JOptionPane.QUESTION_MESSAGE,null , comboString, null);
		String dset = input.toString().substring(0, input.toString().indexOf(','));
		displayTable(dset);

	}

	TableModel dataModel = new AbstractTableModel() {
		public int getColumnCount() { return 10; }
		public int getRowCount() { return 10;}
		public Object getValueAt(int row, int col) { return Integer.valueOf(row*col); }
};

	public void displayTable(String id) {
		JTable table = new JTable();
		table.setModel(dataModel);
		try {
			var d = dh.populateCollection(id);
			d.computeStats();
			dh.saveStatsToFile(id);
			dh.saveReportToFile(id, 20);
			System.out.println(id);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null,"Fail");
			e.printStackTrace();
		}
		

	}

	public void Option2Window() { 
		
	}

}