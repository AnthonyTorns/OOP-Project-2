package project2;

import java.util.Scanner;
import java.util.Vector;
import java.io.IOException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.*;
/**
 * DO NOT MODIFY: Exploratory Data Analysis of Amazon Product Reviews
 * @author Anthony Torns II
 * @version 2.0
 * @ methods: actionperformed evaluates button press on start menu 
 * Option1 window and Option 2window are methods to control wheter user chooses 1 or 2 on main menu 
 * 
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
				Option2Window();
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
		displayTable(dset, true);

	}

	TableModel dataModel = new AbstractTableModel() {
		public int getColumnCount() { return 10; }
		public int getRowCount() { return 10;}
		public Object getValueAt(int row, int col) { return Integer.valueOf(row*col); }
};

	public void displayTable(String id, boolean found) {
		JTable table;
		try {
			var d = dh.populateCollection(id);
			if(found == true) {
				d.computeStats();
				dh.saveStatsToFile(id);
			}
			String data = dh.saveReportToFile(id, 20);
			Vector<String> s = new Vector<String>();
			int c = 0;
			int i =1;
			String[] column = new String[4];
			String[][] datas = new String [20][4];
			int j = 1;
			for(String da : data.split(",")) {
				if(c < 4){
					column[c] = da;
					c++;
				}
				else {
					if(da.contains(System.lineSeparator())) {
						datas[j][0] = da;
						j++;
					}
					else {
						datas[j][i] = da;
						if(i == 3) {
							i = 1;
							j++;
						}
						else { 
							i++;
						}
					}
				}
			}
	
			table = new JTable(datas, column);
			JFrame tableFrame  = new JFrame("Display Stats");
			tableFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			tableFrame.setSize(1000, 400);
			tableFrame.add(new JScrollPane(table));
			tableFrame.pack();
			tableFrame.setVisible(true);
			tableFrame.setLocationRelativeTo(null);
		
			
		
			//System.out.println(data);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null,"Fail");
			e.printStackTrace();
		}
		

	}

	public void Option2Window() { 
		JOptionPane option2 = new JOptionPane("Rating Stats - New Collection");
		String newID = option2.showInputDialog(null, "Select a dataset ID from the list below");
			if (!(dh.checkID(newID))) {
						String newData = option2.showInputDialog(null, "What is the the source file name for the new collection?");
						boolean check = dh.addCollection(newID, newData);
						if(check == true){
							JOptionPane.showMessageDialog(null, "Collection added!");
							displayTable(newID,true);
						}
						else {
							JOptionPane.showMessageDialog(null, "Collection not found, try again!");
						}
			}
			else {
				JOptionPane.showMessageDialog(null, "Collection is already in the databse, displaying existing statisitcs");
				String [] choiceString = {"3 Use existing stat data.", "4 Process statistics again, I have new data."};
				Object choice = JOptionPane.showInputDialog(null, "Statistics are already computed and saved \n"
				+ "Choose one of the following functions:\n\n" + "\t 3. Use existing stat data.\n"
				+ "\t 4. Process statistics again, I have new data.\n", "Rating Stats App - display stats", JOptionPane.QUESTION_MESSAGE,null , choiceString, null);
				if(choice.toString().contains("4")) {
					displayTable(newID, true);
				}
				else {
					displayTable(newID, false);
				}
			}
			
	}

}