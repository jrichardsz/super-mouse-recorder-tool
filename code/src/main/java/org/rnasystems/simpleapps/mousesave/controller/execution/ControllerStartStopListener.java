package org.rnasystems.simpleapps.mousesave.controller.execution;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import org.rnasystems.simpleapps.mousesave.controller.drag.ControllerSaveMouseCoordinates;
import org.rnasystems.simpleapps.mousesave.view.CoordinatesView;

public class ControllerStartStopListener implements ActionListener{

	private ControllerSaveMouseCoordinates controllerSaveMouseCoordinates = null;
	private JButton jButtonStart = null;
	private JButton jButtonStop = null;
	
	public ControllerStartStopListener(CoordinatesView coordinatesView , ControllerSaveMouseCoordinates controllerSaveMouseCoordinates){
		
		jButtonStart = coordinatesView.getButtonStart();
		jButtonStart.addActionListener(this);
		
		jButtonStop = coordinatesView.getButtonStop();
		jButtonStop.addActionListener(this);
		
		this.controllerSaveMouseCoordinates = controllerSaveMouseCoordinates;
	}

	public void actionPerformed(ActionEvent e){
		
		if(e.getSource()==jButtonStart){
			
			if(controllerSaveMouseCoordinates!=null){
				jButtonStart.setEnabled(false);
				jButtonStop.setEnabled(true);
				controllerSaveMouseCoordinates.start();
			}

		}else if(e.getSource()==jButtonStop){
			
			if(controllerSaveMouseCoordinates!=null){
				jButtonStart.setEnabled(true);
				jButtonStop.setEnabled(false);
				controllerSaveMouseCoordinates.stop();
			}

		}
		
	}

}
