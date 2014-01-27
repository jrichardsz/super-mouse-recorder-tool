package org.rnasystems.simpleapps.mousesave.controller.save;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTable;

import org.rnasystems.simpleapps.mousesave.controller.drag.ControllerSaveMouseCoordinates;
import org.rnasystems.simpleapps.mousesave.view.CoordinatesView;

public class ControllerExport implements ActionListener{

	private JButton buttonSave;
	private JTable table;	
	private ControllerSaveMouseCoordinates controllerSaveMouseCoordinates;

	public ControllerExport(CoordinatesView coordinatesView , ControllerSaveMouseCoordinates controllerSaveMouseCoordinates){
		buttonSave=coordinatesView.getButtonSave();
		buttonSave.addActionListener(this);		
		table = coordinatesView.getTable();
		
		this.controllerSaveMouseCoordinates = controllerSaveMouseCoordinates;
	}

	public void actionPerformed(ActionEvent e){

		if(e.getSource() == buttonSave){

			if(controllerSaveMouseCoordinates!=null){
				controllerSaveMouseCoordinates.stop();
			}
			
			
			JDialog.setDefaultLookAndFeelDecorated(true);
			
		    Object[] selectionValues = { ExportType.csv,ExportType.arrayAutoit};
		    String initialSelection = ExportType.csv.toString();
		    
		    String selection = ""+JOptionPane.showInputDialog(null, "Select type of export",
		        "Coordinates", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);
		    
		    
		    switch(ExportType.valueOf(selection)){
		    
			case arrayAutoit:
				ExportAutoitArray.export(table);
				break;
				
			case csv:
				ExportCSV.export(table);
				break;
			}
			
		    
		    if(controllerSaveMouseCoordinates!=null){
		    	controllerSaveMouseCoordinates.start();
		    }
		    
			
		}

	}
	
	public enum ExportType {
	
		csv, arrayAutoit

	}

}
