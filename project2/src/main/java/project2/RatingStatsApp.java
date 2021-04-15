package project2;

import java.util.Scanner;
import java.io.IOException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

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
	private static DatasetHandler dh;
	
	public static void main(final String[] args) {
		option = 3;
		JOptionPane loadWindow = new JOptionPane();
		JPanel panel;
		JLabel welcomeLabel;
		String [] datasetOptions = new String[] {"1. Display computed statistics for specific dataID", "2. Add new collection and compute statistics.", "0. Exit program."};
		JButton enterButton;
	
		String selection = "";

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
				//Option1Window();
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
	/*
	public void Option1Window() {
		JFrame option1Window = new JFrame();
		JComboBox option1Box = new JComboBox();
		JOptionPane pane = new JOptionPane();
		pane.showInputDialog(option1Box, "Please enter a Dataset ID from the list below!");

	}
	*/
}