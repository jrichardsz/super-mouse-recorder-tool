package org.rnasystems.simpleapps.mousesave.controller;

import org.rnasystems.simpleapps.mousesave.controller.clear.ControllerClearTable;
import org.rnasystems.simpleapps.mousesave.controller.drag.ControllerSaveMouseCoordinates;
import org.rnasystems.simpleapps.mousesave.controller.execution.ControllerStartStopListener;
import org.rnasystems.simpleapps.mousesave.controller.save.ControllerExport;
import org.rnasystems.simpleapps.mousesave.view.CoordinatesView;

public class Controllers{

	ControllerExport controllerExport = null;
	CoordinatesView coordinatesView = null;
	ControllerSaveMouseCoordinates controllerSaveMouseCoordinates = null; 
	ControllerClearTable controllerClearTable = null;
	ControllerStartStopListener controllerStartStopListener = null;
	
	public Controllers(CoordinatesView coordinatesView){
		this.coordinatesView = coordinatesView;
	}
	
	public void start(){
		controllerSaveMouseCoordinates = new ControllerSaveMouseCoordinates(coordinatesView);
		controllerExport = new ControllerExport(coordinatesView,controllerSaveMouseCoordinates);
		controllerClearTable = new ControllerClearTable(coordinatesView);
		controllerStartStopListener = new ControllerStartStopListener(coordinatesView,controllerSaveMouseCoordinates);
	}

}
